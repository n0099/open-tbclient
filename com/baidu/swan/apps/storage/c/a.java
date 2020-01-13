package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final Set<String> bRD;

    public a(String str) {
        super(str);
        this.bRD = new HashSet();
    }

    public boolean lX(String str) {
        return this.bRD.contains(str);
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (ada()) {
            super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (ada()) {
            super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putString(String str, String str2) {
        if (ada() || lX(str)) {
            super.putString(str, str2);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g
    public void putStringSet(String str, Set<String> set) {
        if (ada() || lX(str)) {
            super.putStringSet(str, set);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putInt(String str, int i) {
        if (ada() || lX(str)) {
            super.putInt(str, i);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putLong(String str, long j) {
        if (ada() || lX(str)) {
            super.putLong(str, j);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putFloat(String str, float f) {
        if (ada() || lX(str)) {
            super.putFloat(str, f);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putBoolean(String str, boolean z) {
        if (ada() || lX(str)) {
            super.putBoolean(str, z);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void remove(String str) {
        if (ada() || lX(str)) {
            super.remove(str);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return lX(str) ? super.getString(str, str2) : bk(str, str2);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return lX(str) ? super.getInt(str, i) : J(str, i);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return lX(str) ? super.getLong(str, j) : n(str, j);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return lX(str) ? super.getFloat(str, f) : e(str, f);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return lX(str) ? super.getBoolean(str, z) : D(str, z);
    }

    private void log() {
        if (DEBUG) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }
}
