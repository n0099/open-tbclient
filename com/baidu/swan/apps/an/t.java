package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class t {
    private static SharedPreferences afy = null;

    private static SharedPreferences Pv() {
        if (afy == null) {
            afy = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return afy;
    }

    public static long getLong(String str, long j) {
        return Pv().getLong(str, j);
    }

    public static boolean getBoolean(String str, boolean z) {
        return Pv().getBoolean(str, z);
    }

    public static void s(String str, boolean z) {
        SharedPreferences.Editor edit = Pv().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
