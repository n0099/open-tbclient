package com.baidu.prologue.a.c;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public class l {
    private static final DisplayMetrics bzD = com.baidu.prologue.a.b.b.getAppContext().getResources().getDisplayMetrics();
    private static final float bzE = bzD.density;
    private static DisplayMetrics sDisplayMetrics;

    public static float getDensity(Context context) {
        initDisplayMetrics(com.baidu.prologue.a.b.b.getAppContext());
        if (sDisplayMetrics != null) {
            return sDisplayMetrics.density;
        }
        return 0.0f;
    }

    private static void initDisplayMetrics(Context context) {
        if (sDisplayMetrics == null) {
            Context appContext = com.baidu.prologue.a.b.b.getAppContext();
            if (appContext != null) {
                context = appContext;
            }
            if (context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) (getDensity(context) * f);
    }
}
