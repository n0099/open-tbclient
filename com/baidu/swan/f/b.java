package com.baidu.swan.f;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static final String dxL = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    public static final String cej = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static boolean aLk() {
        if (PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_t7_success", false)) {
            return aLo() || aLp();
        }
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ad(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", true).putString("swan_sailor_version_name", str).putInt("swan_sailor_version_code", i).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void aLl() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }

    public static int aLm() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_sailor_version_code", 0);
    }

    public static String aLn() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sailor_version_name", "");
    }

    public static boolean aLo() {
        return new File(new StringBuilder().append(dxL).append(File.separator).append(GlobalConstants.LIB_ZEUS_CHROMIUM).toString()).exists() && abS();
    }

    public static boolean aLp() {
        return new File(new StringBuilder().append(cej).append(File.separator).append(GlobalConstants.LIB_ZEUS_V8).toString()).exists() && !abS();
    }

    public static boolean abS() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void gC(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }
}
