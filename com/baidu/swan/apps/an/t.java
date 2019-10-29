package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class t {
    private static SharedPreferences ayW = null;

    private static SharedPreferences Up() {
        if (ayW == null) {
            ayW = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return ayW;
    }

    public static long getLong(String str, long j) {
        return Up().getLong(str, j);
    }

    public static boolean getBoolean(String str, boolean z) {
        return Up().getBoolean(str, z);
    }

    public static void v(String str, boolean z) {
        SharedPreferences.Editor edit = Up().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
