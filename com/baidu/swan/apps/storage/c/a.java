package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final Set<String> dag;

    public a(String str) {
        super(str);
        this.dag = new HashSet();
    }

    public boolean st(String str) {
        return this.dag.contains(str);
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.c.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (aDM()) {
            super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.c.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (aDM()) {
            super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (aDM() || st(str)) {
            super.putString(str, str2);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (aDM() || st(str)) {
            super.putStringSet(str, set);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (aDM() || st(str)) {
            super.putInt(str, i);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (aDM() || st(str)) {
            super.putLong(str, j);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (aDM() || st(str)) {
            super.putFloat(str, f);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (aDM() || st(str)) {
            super.putBoolean(str, z);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (aDM() || st(str)) {
            super.remove(str);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return st(str) ? super.getString(str, str2) : ct(str, str2);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return st(str) ? super.getInt(str, i) : V(str, i);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return st(str) ? super.getLong(str, j) : r(str, j);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return st(str) ? super.getFloat(str, f) : e(str, f);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return st(str) ? super.getBoolean(str, z) : ab(str, z);
    }

    private void log() {
        if (DEBUG) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }
}
