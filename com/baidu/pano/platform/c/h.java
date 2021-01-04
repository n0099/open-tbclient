package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes15.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static float f3952a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private static float f3953b = 0.0f;
    private static int c;

    public static float a(Context context) {
        if (f3952a == 0.0f) {
            f3952a = context.getResources().getDisplayMetrics().density;
        }
        return f3952a;
    }

    public static int b(Context context) {
        if (c == 0) {
            c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return c;
    }

    public static float c(Context context) {
        if (f3953b == 0.0f) {
            f3953b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return f3953b;
    }

    public static int a(int i, Context context) {
        return (int) (0.5f + (a(context) * i));
    }

    public static int a(float f, Context context) {
        return (int) ((c(context) * f) + 0.5f);
    }
}
