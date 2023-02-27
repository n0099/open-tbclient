package com.baidu.pass.face.platform.utils;

import android.content.Context;
/* loaded from: classes2.dex */
public final class DensityUtils {
    public static final float DOT_FIVE = 0.5f;
    public static final int PORTRAIT_DEGREE_270 = 270;
    public static final int PORTRAIT_DEGREE_90 = 90;

    public static int dip2px(Context context, float f) {
        return (int) ((f * getDensity(context)) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getDisplayHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / getDensity(context)) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
