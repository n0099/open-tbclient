package com.baidu.swan.f;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes11.dex */
public class b {
    private static final String dtb = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    public static final String bZt = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    public static boolean aKe() {
        if (PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_t7_success", false)) {
            return aKi() || aKj();
        }
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    public static void ad(String str, int i) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", true).putString("swan_sailor_version_name", str).putInt("swan_sailor_version_code", i).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void aKf() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }

    public static int aKg() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_sailor_version_code", 0);
    }

    public static String aKh() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sailor_version_name", "");
    }

    public static boolean aKi() {
        return new File(new StringBuilder().append(dtb).append(File.separator).append(GlobalConstants.LIB_ZEUS_CHROMIUM).toString()).exists() && aaM();
    }

    public static boolean aKj() {
        return new File(new StringBuilder().append(bZt).append(File.separator).append(GlobalConstants.LIB_ZEUS_V8).toString()).exists() && !aaM();
    }

    public static boolean aaM() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void gx(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }
}
