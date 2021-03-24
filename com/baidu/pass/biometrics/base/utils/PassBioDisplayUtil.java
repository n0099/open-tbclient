package com.baidu.pass.biometrics.base.utils;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class PassBioDisplayUtil {
    public static void enableNavigationBarTint(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 134217728;
            window.setAttributes(attributes);
        }
        SapiSystemBarTintManager sapiSystemBarTintManager = new SapiSystemBarTintManager(activity);
        sapiSystemBarTintManager.setNavigationBarTintEnabled(true);
        sapiSystemBarTintManager.setNavigationBarTintColor(i);
    }

    public static int getNavigationBarHeight(Activity activity) {
        if (hasSoftKeys(activity.getWindowManager())) {
            return new SapiSystemBarTintManager(activity).getConfig().getNavigationBarHeight();
        }
        return 0;
    }

    public static boolean hasSoftKeys(WindowManager windowManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
        }
        return false;
    }
}
