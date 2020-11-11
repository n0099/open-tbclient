package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final Set<String> dAK;

    public a(String str) {
        super(str);
        this.dAK = new HashSet();
    }

    public boolean tM(String str) {
        return this.dAK.contains(str);
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.c.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (aKP()) {
            super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.c.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (aKP()) {
            super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (aKP() || tM(str)) {
            super.putString(str, str2);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (aKP() || tM(str)) {
            super.putStringSet(str, set);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (aKP() || tM(str)) {
            super.putInt(str, i);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (aKP() || tM(str)) {
            super.putLong(str, j);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (aKP() || tM(str)) {
            super.putFloat(str, f);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (aKP() || tM(str)) {
            super.putBoolean(str, z);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (aKP() || tM(str)) {
            super.remove(str);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return tM(str) ? super.getString(str, str2) : cF(str, str2);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return tM(str) ? super.getInt(str, i) : Y(str, i);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return tM(str) ? super.getLong(str, j) : t(str, j);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return tM(str) ? super.getFloat(str, f) : f(str, f);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return tM(str) ? super.getBoolean(str, z) : ah(str, z);
    }

    private void log() {
        if (DEBUG) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }
}
