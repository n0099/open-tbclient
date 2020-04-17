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
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class AlaUtilHelper {
    private static boolean hasNavBar(Context context) {
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
        return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
    }

    private static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable th) {
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

    public static int getVirtualBarHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z, boolean z2) {
        if (tbImageView != null && !TextUtils.isEmpty(str)) {
            if (z2 && str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                tbImageView.startLoad(str, 10, false);
            } else if (z) {
                tbImageView.startLoad(str, 25, false);
            } else {
                tbImageView.startLoad(str, 12, false);
            }
        }
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z) {
        if (tbImageView != null && !TextUtils.isEmpty(str)) {
            if (str.toLowerCase().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                tbImageView.startLoad(str, 10, false);
            } else if (z) {
                tbImageView.startLoad(str, 25, false);
            } else {
                tbImageView.startLoad(str, 12, false);
            }
        }
    }

    public static float[] getPhysicalScreenSize(Context context) {
        float[] fArr = new float[2];
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics.xdpi != 0.0f && displayMetrics.ydpi != 0.0f) {
                fArr[0] = displayMetrics.widthPixels / displayMetrics.xdpi;
                fArr[1] = displayMetrics.heightPixels / displayMetrics.ydpi;
            }
        }
        return fArr;
    }

    public static boolean isVirtualBarDisabled(Context context) {
        try {
            return (Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled") : 0) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
