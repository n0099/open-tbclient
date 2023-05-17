package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
/* loaded from: classes3.dex */
public class VideoSystemHelper {
    public static final String TAG = "VideoSystemHelper";

    public static float getDensity() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static int getDisplayHeight() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    public static DisplayMetrics getDisplayMetrics() {
        Context appContext = BDPlayerConfig.getAppContext();
        if (appContext == null) {
            return null;
        }
        return appContext.getResources().getDisplayMetrics();
    }

    public static int getDisplayWidth() {
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
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
        return resources.getDimensionPixelSize(resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.h, EMABTest.TYPE_DIMEN, "android"));
    }

    public static int getStatusBarHeight() {
        Context appContext = BDPlayerConfig.getAppContext();
        int i = 0;
        if (appContext == null) {
            return 0;
        }
        int identifier = appContext.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
        if (identifier > 0) {
            try {
                i = appContext.getResources().getDimensionPixelSize(identifier);
            } catch (Exception unused) {
            }
        }
        if (i == 0) {
            return (int) (getDensity() * 25.0f);
        }
        return i;
    }

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
}
