package com.baidu.android.util.sp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes3.dex */
public final class PreferenceUtils {
    private static SharedPreferences mPreference = null;

    private static SharedPreferences getPreference() {
        if (mPreference == null) {
            mPreference = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return mPreference;
    }

    private PreferenceUtils() {
    }

    public static String getString(String str, String str2) {
        return getPreference().getString(str, str2);
    }

    public static int getInt(String str, int i) {
        return getPreference().getInt(str, i);
    }

    public static long getLong(String str, long j) {
        return getPreference().getLong(str, j);
    }

    public static float getFloat(String str, float f) {
        return getPreference().getFloat(str, f);
    }

    public static boolean getBoolean(String str, boolean z) {
        return getPreference().getBoolean(str, z);
    }

    public static void removeKey(String str) {
        if (getPreference().contains(str)) {
            SharedPreferences.Editor edit = getPreference().edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static boolean containsKey(String str) {
        return getPreference().contains(str);
    }

    public static void setBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void setString(String str, String str2) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void setStringCommit(String str, String str2) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void setInt(String str, int i) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void setLong(String str, long j) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void setFloat(String str, float f) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public static void registerOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getPreference().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void unregisterOnChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        getPreference().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
