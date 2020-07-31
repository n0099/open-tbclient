package com.baidu.swan.e;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes18.dex */
public class b {
    private static final String dDH = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    public static final String cfS = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static boolean aOY() {
        if (PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_t7_success", false)) {
            return aPc() || aPd();
        }
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ae(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", true).putString("swan_sailor_version_name", str).putInt("swan_sailor_version_code", i).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void aOZ() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }

    public static int aPa() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_sailor_version_code", 0);
    }

    public static String aPb() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sailor_version_name", "");
    }

    public static boolean aPc() {
        return new File(new StringBuilder().append(dDH).append(File.separator).append(GlobalConstants.LIB_ZEUS_CHROMIUM).toString()).exists() && acW();
    }

    public static boolean aPd() {
        return new File(new StringBuilder().append(cfS).append(File.separator).append(GlobalConstants.LIB_ZEUS_V8).toString()).exists() && !acW();
    }

    public static boolean acW() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void gX(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }
}
