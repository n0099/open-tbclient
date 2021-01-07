package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static float f3953a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private static float f3954b = 0.0f;
    private static int c;

    public static float a(Context context) {
        if (f3953a == 0.0f) {
            f3953a = context.getResources().getDisplayMetrics().density;
        }
        return f3953a;
    }

    public static int b(Context context) {
        if (c == 0) {
            c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return c;
    }

    public static float c(Context context) {
        if (f3954b == 0.0f) {
            f3954b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return f3954b;
    }

    public static int a(int i, Context context) {
        return (int) (0.5f + (a(context) * i));
    }

    public static int a(float f, Context context) {
        return (int) ((c(context) * f) + 0.5f);
    }
}
