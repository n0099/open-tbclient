package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final Set<String> bVV;

    public a(String str) {
        super(str);
        this.bVV = new HashSet();
    }

    public boolean ml(String str) {
        return this.bVV.contains(str);
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (aft()) {
            super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (aft()) {
            super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putString(String str, String str2) {
        if (aft() || ml(str)) {
            super.putString(str, str2);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g
    public void putStringSet(String str, Set<String> set) {
        if (aft() || ml(str)) {
            super.putStringSet(str, set);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putInt(String str, int i) {
        if (aft() || ml(str)) {
            super.putInt(str, i);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putLong(String str, long j) {
        if (aft() || ml(str)) {
            super.putLong(str, j);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putFloat(String str, float f) {
        if (aft() || ml(str)) {
            super.putFloat(str, f);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void putBoolean(String str, boolean z) {
        if (aft() || ml(str)) {
            super.putBoolean(str, z);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g
    public void remove(String str) {
        if (aft() || ml(str)) {
            super.remove(str);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return ml(str) ? super.getString(str, str2) : bs(str, str2);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return ml(str) ? super.getInt(str, i) : H(str, i);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return ml(str) ? super.getLong(str, j) : n(str, j);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return ml(str) ? super.getFloat(str, f) : e(str, f);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return ml(str) ? super.getBoolean(str, z) : D(str, z);
    }

    private void log() {
        if (DEBUG) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }
}
