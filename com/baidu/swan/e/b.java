package com.baidu.swan.e;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes10.dex */
public class b {
    private static final String cBW = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    public static final String bmY = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static boolean auf() {
        if (PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_t7_success", false)) {
            return auj() || auk();
        }
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void W(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", true).putString("swan_sailor_version_name", str).putInt("swan_sailor_version_code", i).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void aug() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }

    public static int auh() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_sailor_version_code", 0);
    }

    public static String aui() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sailor_version_name", "");
    }

    public static boolean auj() {
        return new File(new StringBuilder().append(cBW).append(File.separator).append(GlobalConstants.LIB_ZEUS_CHROMIUM).toString()).exists() && NL();
    }

    public static boolean auk() {
        return new File(new StringBuilder().append(bmY).append(File.separator).append(GlobalConstants.LIB_ZEUS_V8).toString()).exists() && !NL();
    }

    public static boolean NL() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void fa(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }
}
