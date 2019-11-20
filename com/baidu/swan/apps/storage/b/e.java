package com.baidu.swan.apps.storage.b;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class e implements SharedPreferences {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private SharedPreferences bpM;

    public e(String str) {
        if (TextUtils.isEmpty(str) || "default".equals(str)) {
            this.bpM = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        } else {
            this.bpM = com.baidu.swan.apps.u.a.Jj().getSharedPreferences(str, 0);
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.bpM.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.bpM.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.bpM.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.bpM.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.bpM.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.bpM.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.bpM.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.bpM.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.bpM.edit();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.bpM.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.bpM.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void putString(String str, String str2) {
        aP(str, str2);
        this.bpM.edit().putString(str, str2).apply();
    }

    public void b(String str, Set<String> set) {
        c(str, set);
        this.bpM.edit().putStringSet(str, set).apply();
    }

    public void putInt(String str, int i) {
        this.bpM.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        this.bpM.edit().putLong(str, j).apply();
    }

    public void putFloat(String str, float f) {
        this.bpM.edit().putFloat(str, f).apply();
    }

    public void putBoolean(String str, boolean z) {
        this.bpM.edit().putBoolean(str, z).apply();
    }

    public void remove(String str) {
        this.bpM.edit().remove(str).apply();
    }

    private void aP(String str, String str2) {
        if (str2 == null || str2.length() <= 256) {
        }
    }

    private void c(String str, Set<String> set) {
        if (set != null) {
            for (String str2 : set) {
                aP(str, str2);
            }
        }
    }
}
