package com.baidu.prologue.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/* loaded from: classes6.dex */
public final class j {
    private static SharedPreferences mPreference = null;
    private static SharedPreferences bzB = null;
    private static String bzC = null;

    private static SharedPreferences getPreference() {
        if (mPreference == null) {
            mPreference = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return mPreference;
    }

    public static String getString(String str, String str2) {
        return getPreference().getString(str, str2);
    }

    public static long getLong(String str, long j) {
        return getPreference().getLong(str, j);
    }

    public static void setString(String str, String str2) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void setLong(String str, long j) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putLong(str, j);
        edit.apply();
    }

    private static Context getAppContext() {
        return com.baidu.prologue.a.b.b.getAppContext();
    }
}
