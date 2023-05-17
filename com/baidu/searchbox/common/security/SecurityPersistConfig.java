package com.baidu.searchbox.common.security;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.Map;
import java.util.Set;
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes3.dex */
public class SecurityPersistConfig implements SharedPreferences {
    public static final String SHARED_PREF = "app_security_config";
    public static volatile SecurityPersistConfig sInstance;
    public final SharedPreferences mSysSharedPref;

    public SecurityPersistConfig(Context context) {
        this.mSysSharedPref = context.getSharedPreferences(SHARED_PREF, 0);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mSysSharedPref.contains(str);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSysSharedPref.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSysSharedPref.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static SecurityPersistConfig getInstance() {
        if (sInstance == null) {
            synchronized (SecurityPersistConfig.class) {
                if (sInstance == null) {
                    sInstance = new SecurityPersistConfig(AppRuntime.getAppContext());
                }
            }
        }
        return sInstance;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.mSysSharedPref.edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mSysSharedPref.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.mSysSharedPref.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.mSysSharedPref.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.mSysSharedPref.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.mSysSharedPref.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.mSysSharedPref.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.mSysSharedPref.getStringSet(str, set);
    }

    public void putString(String str, String str2) {
        this.mSysSharedPref.edit().putString(str, str2).commit();
    }

    public void setBoolean(String str, boolean z) {
        this.mSysSharedPref.edit().putBoolean(str, z).commit();
    }

    public void setInt(String str, int i) {
        this.mSysSharedPref.edit().putInt(str, i).commit();
    }

    public void setLong(String str, long j) {
        this.mSysSharedPref.edit().putLong(str, j).commit();
    }
}
