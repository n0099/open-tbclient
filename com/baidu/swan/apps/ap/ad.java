package com.baidu.swan.apps.ap;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes10.dex */
public class ad {
    public static boolean aMK() {
        Context appContext = AppRuntime.getAppContext();
        if (cL(appContext)) {
            return false;
        }
        return cK(appContext);
    }

    private static boolean cK(Context context) {
        boolean z;
        int i;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                i = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            } else {
                i = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            }
        } catch (Exception e) {
            z = z2;
        }
        if (i != 0) {
            return false;
        }
        Class<?> cls = Class.forName("android.os.SystemProperties");
        String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
        if ("1".equals(str)) {
            z = false;
        } else {
            z = "0".equals(str) ? true : z2;
        }
        return z;
    }

    public static int aML() {
        if (!aMK()) {
            return 0;
        }
        return ah.getInternalDimensionSize(AppRuntime.getAppContext().getResources(), ah.isScreenPortrait() ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    public static boolean cL(Context context) {
        boolean z = true;
        String str = Build.BRAND;
        try {
            if (TextUtils.isEmpty(str)) {
                if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
                    z = false;
                }
            } else if (str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR")) {
                if (Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
                    z = false;
                }
            } else if (str.equalsIgnoreCase("XIAOMI")) {
                if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
                    z = false;
                }
            } else if (str.equalsIgnoreCase(RomUtils.ROM_VIVO)) {
                if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
                    z = false;
                }
            } else if (str.equalsIgnoreCase(RomUtils.ROM_OPPO)) {
                if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
                    z = false;
                }
            } else if (str.equalsIgnoreCase("SAMSUNG")) {
                if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled", 0) == 0) {
                    z = false;
                }
            } else if (Settings.Global.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static Pair<Integer, Integer> aMM() {
        Context appContext = AppRuntime.getAppContext();
        WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
        if (windowManager == null) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(ah.getDisplayHeight(appContext)));
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static Pair<Integer, Integer> aMN() {
        Pair<Integer, Integer> aMM = aMM();
        return new Pair<>(Integer.valueOf(((Integer) aMM.first).intValue()), Integer.valueOf(((Integer) aMM.second).intValue() - aML()));
    }
}
