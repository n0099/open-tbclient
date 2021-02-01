package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static float f3918a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private static float f3919b = 0.0f;
    private static int c;

    public static float a(Context context) {
        if (f3918a == 0.0f) {
            f3918a = context.getResources().getDisplayMetrics().density;
        }
        return f3918a;
    }

    public static int b(Context context) {
        if (c == 0) {
            c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return c;
    }

    public static float c(Context context) {
        if (f3919b == 0.0f) {
            f3919b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return f3919b;
    }

    public static int a(int i, Context context) {
        return (int) (0.5f + (a(context) * i));
    }

    public static int a(float f, Context context) {
        return (int) ((c(context) * f) + 0.5f);
    }
}
