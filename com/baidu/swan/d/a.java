package com.baidu.swan.d;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static final String eEn = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "zeus" + File.separator + "libs";
    public static final String cZa = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";

    @SuppressLint({"ApplySharedPref"})
    public static void bkd() {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_t7_success", false).commit();
    }

    public static boolean bke() {
        return new File(new StringBuilder().append(eEn).append(File.separator).append(GlobalConstants.LIB_ZEUS_CHROMIUM).toString()).exists() && avc();
    }

    public static boolean avc() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void iU(boolean z) {
        PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putBoolean("swan_full_install", z).commit();
    }
}
