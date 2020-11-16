package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes11.dex */
public class VideoSystemHelper {
    private static final String TAG = "VideoSystemHelper";

    @PublicMethod
    public static void setKeepScreenOnOff(Activity activity, boolean z) {
        if (activity != null) {
            if (z) {
                activity.getWindow().addFlags(128);
            } else {
                activity.getWindow().clearFlags(128);
            }
        }
    }

    public static int getNavigationBarHeight() {
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null) {
            return 0;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(appContext).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = appContext.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int getStatusBarHeight() {
        int i = 0;
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null) {
            return 0;
        }
        int identifier = appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                i = appContext.getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
            }
        }
        if (i == 0) {
            return (int) (25.0f * getDensity());
        }
        return i;
    }

    public static float getDensity() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDisplayWidth() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static int getDisplayHeight() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    private static DisplayMetrics getDisplayMetrics() {
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null) {
            return null;
        }
        return appContext.getResources().getDisplayMetrics();
    }
}
