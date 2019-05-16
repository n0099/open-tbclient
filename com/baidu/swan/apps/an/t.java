package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class t {
    private static SharedPreferences afb = null;

    private static SharedPreferences OG() {
        if (afb == null) {
            afb = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return afb;
    }

    public static long getLong(String str, long j) {
        return OG().getLong(str, j);
    }

    public static boolean getBoolean(String str, boolean z) {
        return OG().getBoolean(str, z);
    }

    public static void setBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = OG().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
