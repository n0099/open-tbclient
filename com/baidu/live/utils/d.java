package com.baidu.live.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes11.dex */
public class d {
    private static int bOO = 0;
    private static boolean bOP = false;
    private static boolean bOQ = false;

    public static int Xw() {
        String str;
        String str2;
        String str3;
        if (bOO == 0) {
            String str4 = Build.MODEL;
            String str5 = Build.MANUFACTURER;
            String str6 = Build.BRAND;
            if (str4 != null) {
                str = str4.toLowerCase();
            } else {
                str = "";
            }
            if (str5 != null) {
                str2 = str5.toLowerCase();
            } else {
                str2 = "";
            }
            if (str6 != null) {
                str3 = str6.toLowerCase();
            } else {
                str3 = "";
            }
            if (str == null || str2 == null || str3 == null) {
                bOO = 1;
            } else if (str.contains(RomUtils.MANUFACTURER_XIAOMI) || str2.contains(RomUtils.MANUFACTURER_XIAOMI) || str3.contains(RomUtils.MANUFACTURER_XIAOMI)) {
                bOO = 2;
            } else if (str.contains("samsung") || str2.contains("samsung") || str3.contains("samsung")) {
                bOO = 3;
            } else if (str.contains(RomUtils.MANUFACTURER_HUAWEI) || str2.contains(RomUtils.MANUFACTURER_HUAWEI) || str3.contains(RomUtils.MANUFACTURER_HUAWEI)) {
                bOO = 4;
            } else if (str.contains(RomUtils.MANUFACTURER_VIVO) || str2.contains(RomUtils.MANUFACTURER_VIVO) || str3.contains(RomUtils.MANUFACTURER_VIVO)) {
                bOO = 5;
            } else if (str.contains(RomUtils.MANUFACTURER_OPPO) || str2.contains(RomUtils.MANUFACTURER_OPPO) || str3.contains(RomUtils.MANUFACTURER_OPPO)) {
                bOO = 6;
            } else if (str.contains(RomUtils.MANUFACTURER_MEIZU) || str2.contains(RomUtils.MANUFACTURER_MEIZU) || str3.contains(RomUtils.MANUFACTURER_MEIZU)) {
                bOO = 7;
            } else if (str.contains("oneplus") || str2.contains("oneplus") || str3.contains("oneplus")) {
                bOO = 8;
            } else {
                bOO = 1;
            }
        }
        return bOO;
    }

    public static boolean be(Context context) {
        if (bOP) {
            return bOQ;
        }
        bOP = true;
        switch (Xw()) {
            case 2:
                bOQ = bi(context);
                break;
            case 3:
            case 7:
            default:
                bOQ = false;
                break;
            case 4:
                bOQ = bf(context);
                break;
            case 5:
                bOQ = bg(context);
                break;
            case 6:
                bOQ = bh(context);
                break;
            case 8:
                bOQ = bk(context);
                break;
        }
        return bOQ;
    }

    public static boolean bf(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchMethodException e2) {
            return false;
        } catch (Exception e3) {
            return false;
        }
    }

    public static boolean bg(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException e) {
            return Build.MODEL.toLowerCase().contains("x21a");
        } catch (NoSuchMethodException e2) {
            return Build.MODEL.toLowerCase().contains("x21a");
        } catch (Exception e3) {
            return false;
        }
    }

    public static boolean bh(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean bi(Context context) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return "1".equals((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.miui.notch"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int bj(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean bk(Context context) {
        return TextUtils.equals("ONEPLUS A6000", Build.MODEL) || TextUtils.equals("GM1900", Build.MODEL);
    }

    public static boolean bl(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean Xx() {
        String str;
        if (Xw() == 2) {
            String str2 = Build.MODEL;
            if (str2 != null) {
                str = str2.toLowerCase();
            } else {
                str = "";
            }
            if (str.contains("mix 3")) {
                return true;
            }
        }
        return false;
    }
}
