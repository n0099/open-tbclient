package com.baidu.spswitch.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class UIUtils {
    public static final boolean DEBUG = SPConfig.isDebug();
    public static final int STANDARD_STATUSBAR_HEIGHT = 50;
    public static final String TAG = "StatusBarUtil";
    public static boolean get = false;
    public static DisplayMetrics sDisplayMetrics;
    public static int statusBarHeight;

    public static int dip2px(@Nullable Context context, float f2) {
        if (context == null) {
            return 0;
        }
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dp2px(Context context, float f2) {
        return f2 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static float getDensity(@Nullable Context context) {
        initDisplayMetrics(AppRuntime.getAppContext());
        DisplayMetrics displayMetrics = sDisplayMetrics;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static synchronized int getStatusBarHeight(Context context) {
        int i2;
        synchronized (UIUtils.class) {
            if (!get) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
                    get = true;
                }
                if (DEBUG) {
                    Log.d(TAG, "status bar util: " + statusBarHeight);
                }
            }
            i2 = statusBarHeight;
        }
        return i2;
    }

    public static int getStatusBarHeightEx() {
        int identifier = AppRuntime.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int i2 = 0;
        if (identifier > 0) {
            try {
                i2 = AppRuntime.getAppContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? (int) (getDensity(null) * 25.0f) : i2;
    }

    public static void initDisplayMetrics(Context context) {
        Context appContext = AppRuntime.getAppContext();
        if (sDisplayMetrics == null) {
            if (appContext != null) {
                context = appContext;
            }
            if (context == null) {
                return;
            }
            sDisplayMetrics = context.getResources().getDisplayMetrics();
        }
    }
}
