package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class t {
    private static SharedPreferences ayE = null;

    private static SharedPreferences Un() {
        if (ayE == null) {
            ayE = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return ayE;
    }

    public static long getLong(String str, long j) {
        return Un().getLong(str, j);
    }

    public static boolean getBoolean(String str, boolean z) {
        return Un().getBoolean(str, z);
    }

    public static void v(String str, boolean z) {
        SharedPreferences.Editor edit = Un().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
