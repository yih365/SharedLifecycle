package com.driuft.sharedlifecycle

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var _sharedPreferences: SharedPreferences

    val listener = OnSharedPreferenceChangeListener { sharedPreferences, key ->
        Toast.makeText(this, sharedPreferences.getString(key, resources.getString(R.string.default_state)), Toast.LENGTH_SHORT).show()
    }

    private fun getCurrentState() {
        val currentState = _sharedPreferences.getString(
            getString(R.string.current_lifecycle_state),
            resources.getString(R.string.default_state)
        ) ?: resources.getString(R.string.default_state)
        // Log statement at debug level
        Log.d("Lifecycle: ", currentState)
        // Toast
        Toast.makeText(this, currentState, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _sharedPreferences = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)
        _sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onCreate")
            apply()
        }

        Log.d(TAG, "onCreate")
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

//        getCurrentState()
    }

    override fun onStart() {
        super.onStart()
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStart")
            apply()
        }

        Log.d(TAG, "onStart")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()

//        getCurrentState()
    }

    override fun onResume() {
        super.onResume()
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onResume")
            apply()
        }

        Log.d(TAG, "onResume")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()

//        getCurrentState()
    }

    override fun onPause() {
        super.onPause()
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onPause")
            apply()
        }

        Log.d(TAG, "onPause")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()

//        getCurrentState()
    }

    override fun onStop() {
        super.onStop()
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStop")
            apply()
        }

        Log.d(TAG, "onStop")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()

//        getCurrentState()
    }

    override fun onRestart() {
        super.onRestart()
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onRestart")
            apply()
        }

        Log.d(TAG, "onRestart")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()

//        getCurrentState()
    }

    override fun onDestroy() {
        super.onDestroy()
        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onDestroy")
            apply()
        }

        Log.d(TAG, "onDestroy")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()

//        getCurrentState()

        unregisterListener()
    }

    private fun unregisterListener() {
        _sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    companion object {
        val TAG = "Lifecycle: "
    }
}