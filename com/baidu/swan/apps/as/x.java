package com.baidu.swan.apps.as;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public final class x {
    private static SharedPreferences mPreference = null;

    private static SharedPreferences getPreference() {
        if (mPreference == null) {
            mPreference = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return mPreference;
    }

    public static long getLong(String str, long j) {
        return getPreference().getLong(str, j);
    }

    public static boolean getBoolean(String str, boolean z) {
        return getPreference().getBoolean(str, z);
    }

    public static void setBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = getPreference().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
