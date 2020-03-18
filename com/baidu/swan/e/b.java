package com.baidu.swan.e;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static final String cGh = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    public static final String brv = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static boolean awy() {
        if (PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_t7_success", false)) {
            return awC() || awD();
        }
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void U(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", true).putString("swan_sailor_version_name", str).putInt("swan_sailor_version_code", i).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void awz() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }

    public static int awA() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_sailor_version_code", 0);
    }

    public static String awB() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sailor_version_name", "");
    }

    public static boolean awC() {
        return new File(new StringBuilder().append(cGh).append(File.separator).append(GlobalConstants.LIB_ZEUS_CHROMIUM).toString()).exists() && Qe();
    }

    public static boolean awD() {
        return new File(new StringBuilder().append(brv).append(File.separator).append(GlobalConstants.LIB_ZEUS_V8).toString()).exists() && !Qe();
    }

    public static boolean Qe() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void fi(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }
}
