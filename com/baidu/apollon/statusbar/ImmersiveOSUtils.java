package com.baidu.apollon.statusbar;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes2.dex */
public class ImmersiveOSUtils {
    public static final String FLYME = "flyme";
    public static final String KEY_DISPLAY = "ro.build.display.id";
    public static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String LEECO = "leeco";
    public static final String LETV = "letv";
    public static final String NUBIA = "nubia";
    public static final String ZTEC2016 = "zte c2016";
    public static final String ZUKZ1 = "zuk z1";

    public static String getEMUIVersion() {
        return isEMUI() ? getSystemProperty("ro.build.version.emui", "") : "";
    }

    public static String getFlymeOSFlag() {
        return getSystemProperty("ro.build.display.id", "");
    }

    public static String getFlymeOSVersion() {
        return isFlymeOS() ? getSystemProperty("ro.build.display.id", "") : "";
    }

    public static String getMIUIVersion() {
        return isMIUI() ? getSystemProperty("ro.miui.ui.version.name", "") : "";
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", ""));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains(FLYME);
    }

    public static boolean isFlymeOS4Plus() {
        int intValue;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains(IXAdRequestInfo.OS)) {
                intValue = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                intValue = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            return ((double) intValue) > 4.4d;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        int intValue;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains(IXAdRequestInfo.OS)) {
                intValue = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                intValue = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            return intValue == 5;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isLeshi() {
        String str = Build.BRAND;
        if (str != null) {
            String lowerCase = str.toLowerCase();
            return lowerCase.contains(LETV) || lowerCase.contains(LEECO);
        }
        return false;
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isMIUI6Plus() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            return Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isNubia() {
        String str = Build.MANUFACTURER;
        return str != null && str.toLowerCase().contains("nubia");
    }

    public static boolean isSpecialOS() {
        return isZUKZ1() || isZTKC2016() || isNubia() || isLeshi();
    }

    public static boolean isSupportStatusBarDarkFont() {
        return Build.VERSION.SDK_INT >= 27 || isMIUI6Plus() || isFlymeOS4Plus() || Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isZTKC2016() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains(ZTEC2016);
    }

    public static boolean isZUKZ1() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains(ZUKZ1);
    }
}
