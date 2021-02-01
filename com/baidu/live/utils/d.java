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
    private static int bNM = 0;
    private static boolean bNN = false;
    private static boolean bNO = false;

    public static int Vk() {
        String str;
        String str2;
        String str3;
        if (bNM == 0) {
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
                bNM = 1;
            } else if (str.contains(RomUtils.MANUFACTURER_XIAOMI) || str2.contains(RomUtils.MANUFACTURER_XIAOMI) || str3.contains(RomUtils.MANUFACTURER_XIAOMI)) {
                bNM = 2;
            } else if (str.contains("samsung") || str2.contains("samsung") || str3.contains("samsung")) {
                bNM = 3;
            } else if (str.contains(RomUtils.MANUFACTURER_HUAWEI) || str2.contains(RomUtils.MANUFACTURER_HUAWEI) || str3.contains(RomUtils.MANUFACTURER_HUAWEI)) {
                bNM = 4;
            } else if (str.contains(RomUtils.MANUFACTURER_VIVO) || str2.contains(RomUtils.MANUFACTURER_VIVO) || str3.contains(RomUtils.MANUFACTURER_VIVO)) {
                bNM = 5;
            } else if (str.contains(RomUtils.MANUFACTURER_OPPO) || str2.contains(RomUtils.MANUFACTURER_OPPO) || str3.contains(RomUtils.MANUFACTURER_OPPO)) {
                bNM = 6;
            } else if (str.contains(RomUtils.MANUFACTURER_MEIZU) || str2.contains(RomUtils.MANUFACTURER_MEIZU) || str3.contains(RomUtils.MANUFACTURER_MEIZU)) {
                bNM = 7;
            } else if (str.contains("oneplus") || str2.contains("oneplus") || str3.contains("oneplus")) {
                bNM = 8;
            } else {
                bNM = 1;
            }
        }
        return bNM;
    }

    public static boolean bd(Context context) {
        if (bNN) {
            return bNO;
        }
        bNN = true;
        switch (Vk()) {
            case 2:
                bNO = bh(context);
                break;
            case 3:
            case 7:
            default:
                bNO = false;
                break;
            case 4:
                bNO = be(context);
                break;
            case 5:
                bNO = bf(context);
                break;
            case 6:
                bNO = bg(context);
                break;
            case 8:
                bNO = bj(context);
                break;
        }
        return bNO;
    }

    public static boolean be(Context context) {
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

    public static boolean bf(Context context) {
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

    public static boolean bg(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean bh(Context context) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return "1".equals((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.miui.notch"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int bi(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean bj(Context context) {
        return TextUtils.equals("ONEPLUS A6000", Build.MODEL) || TextUtils.equals("GM1900", Build.MODEL);
    }

    public static boolean bk(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean Vl() {
        String str;
        if (Vk() == 2) {
            String str2 = Build.MODEL;
            if (str2 != null) {
                str = str2.toLowerCase();
            } else {
                str = "";
            }
            if (str.contains("mix 3") || str.contains("redmi 7") || str.contains("zte a2121")) {
                return true;
            }
        }
        return false;
    }
}
