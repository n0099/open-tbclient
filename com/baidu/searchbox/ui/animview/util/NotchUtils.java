package com.baidu.searchbox.ui.animview.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes13.dex */
public class NotchUtils {
    private static final String ONEPLUS6 = "ONEPLUS A6000";
    private static final int VIVO_NOTCH = 32;

    public static boolean isNotch(Context context) {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        String name = RomUtils.getName();
        if (!TextUtils.equals(name, RomUtils.ROM_EMUI) ? !TextUtils.equals(name, RomUtils.ROM_MIUI) ? !TextUtils.equals(name, RomUtils.ROM_OPPO) ? !TextUtils.equals(name, RomUtils.ROM_VIVO) ? !ONEPLUS6.equals(Build.MODEL) : !hasNotchAtVivo(context) : !hasNotchAtOPPO(context) : !hasNotchAtXiaoMi(context) : !hasNotchAtHuawei(context)) {
            z = false;
        }
        return z;
    }

    private static boolean hasNotchAtHuawei(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean hasNotchAtVivo(@NonNull Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean hasNotchAtOPPO(@NonNull Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    private static boolean hasNotchAtXiaoMi(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
