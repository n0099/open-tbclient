package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class ScreenUtils {
    public static int dp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static int getLogicalPixel(Context context, int i2) {
        try {
            return (int) (i2 / getScreenDensity(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int getPixel(Context context, int i2) {
        try {
            return (int) (i2 * getScreenDensity(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static float getScreenDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    public static int getScreenHeight(Context context) {
        return getScreenRect(context).height();
    }

    public static Rect getScreenRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        try {
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                return new Rect(0, 0, displayMetrics.heightPixels, displayMetrics.widthPixels);
            }
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getScreenWidth(Context context) {
        return getScreenRect(context).width();
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static Rect getWindowRect(Context context) {
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int px2dp(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
