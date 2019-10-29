package com.baidu.f;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d implements SharedPreferences {
    private SharedPreferences bqe;

    public d(String str) {
        if (TextUtils.isEmpty(str) || "default".equals(str)) {
            this.bqe = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        } else {
            this.bqe = AppRuntime.getAppContext().getSharedPreferences(str, 0);
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.bqe.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.bqe.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.bqe.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.bqe.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.bqe.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.bqe.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.bqe.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.bqe.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.bqe.edit();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.bqe.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.bqe.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void putString(String str, String str2) {
        aP(str, str2);
        this.bqe.edit().putString(str, str2).apply();
    }

    public void putInt(String str, int i) {
        this.bqe.edit().putInt(str, i).apply();
    }

    public void putLong(String str, long j) {
        this.bqe.edit().putLong(str, j).apply();
    }

    private void aP(String str, String str2) {
        if (str2 == null || str2.length() <= 256) {
        }
    }
}
