package com.baidu.ala.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.tbadk.widget.TbImageView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class AlaUtilHelper {
    public static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static float[] getPhysicalScreenSize(Context context) {
        float[] fArr = new float[2];
        if (context == null) {
            return fArr;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.xdpi;
        if (f2 != 0.0f) {
            float f3 = displayMetrics.ydpi;
            if (f3 != 0.0f) {
                fArr[0] = displayMetrics.widthPixels / f2;
                fArr[1] = displayMetrics.heightPixels / f3;
            }
        }
        return fArr;
    }

    public static int getVirtualBarHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static boolean isVirtualBarDisabled(Context context) {
        try {
            return (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled") : 0) == 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z, boolean z2) {
        if (tbImageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2 && str.toLowerCase().startsWith("http")) {
            tbImageView.U(str, 10, false);
        } else if (z) {
            tbImageView.U(str, 25, false);
        } else {
            tbImageView.U(str, 12, false);
        }
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z) {
        if (tbImageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.toLowerCase().startsWith("http")) {
            tbImageView.U(str, 10, false);
        } else if (z) {
            tbImageView.U(str, 25, false);
        } else {
            tbImageView.U(str, 12, false);
        }
    }
}
