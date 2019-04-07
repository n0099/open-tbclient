package com.baidu.swan.apps.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class r {
    private static SharedPreferences aeU = null;

    private static SharedPreferences LZ() {
        if (aeU == null) {
            aeU = PreferenceManager.getDefaultSharedPreferences(getAppContext());
        }
        return aeU;
    }

    public static boolean getBoolean(String str, boolean z) {
        return LZ().getBoolean(str, z);
    }

    public static void setBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = LZ().edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    private static Context getAppContext() {
        return AppRuntime.getAppContext();
    }
}
