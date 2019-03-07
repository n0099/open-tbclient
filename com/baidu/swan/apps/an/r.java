package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class r {
    private static SharedPreferences aeO = null;

    private static SharedPreferences Mb() {
        if (aeO == null) {
            aeO = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return aeO;
    }

    public static boolean getBoolean(String str, boolean z) {
        return Mb().getBoolean(str, z);
    }

    public static void setBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = Mb().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
