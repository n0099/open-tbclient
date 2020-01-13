package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes6.dex */
public class h {
    private static float a = 0.0f;
    private static float b = 0.0f;
    private static int c;

    public static float a(Context context) {
        if (a == 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return a;
    }

    public static int b(Context context) {
        if (c == 0) {
            c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return c;
    }

    public static float c(Context context) {
        if (b == 0.0f) {
            b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return b;
    }

    public static int a(int i, Context context) {
        return (int) (0.5f + (a(context) * i));
    }

    public static int a(float f, Context context) {
        return (int) ((c(context) * f) + 0.5f);
    }
}
