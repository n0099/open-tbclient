package com.baidu.swan.apps.storage.c;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final Set<String> cLE;

    public a(String str) {
        super(str);
        this.cLE = new HashSet();
    }

    public boolean pn(String str) {
        return this.cLE.contains(str);
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.e.b, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (asS()) {
            super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.g, com.baidu.swan.e.b, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (asS()) {
            super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        } else {
            log();
        }
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (asS() || pn(str)) {
            super.putString(str, str2);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (asS() || pn(str)) {
            super.putStringSet(str, set);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (asS() || pn(str)) {
            super.putInt(str, i);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (asS() || pn(str)) {
            super.putLong(str, j);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        if (asS() || pn(str)) {
            super.putFloat(str, f);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (asS() || pn(str)) {
            super.putBoolean(str, z);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (asS() || pn(str)) {
            super.remove(str);
        } else {
            log();
        }
        return this;
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return pn(str) ? super.getString(str, str2) : ca(str, str2);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return pn(str) ? super.getInt(str, i) : T(str, i);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return pn(str) ? super.getLong(str, j) : n(str, j);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return pn(str) ? super.getFloat(str, f) : e(str, f);
    }

    @Override // com.baidu.swan.apps.storage.c.b, com.baidu.swan.apps.storage.c.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return pn(str) ? super.getBoolean(str, z) : X(str, z);
    }

    private void log() {
        if (DEBUG) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }
}
