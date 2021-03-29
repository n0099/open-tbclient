package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static float f9455a;

    /* renamed from: b  reason: collision with root package name */
    public static float f9456b;

    /* renamed from: c  reason: collision with root package name */
    public static int f9457c;

    public static float a(Context context) {
        if (f9455a == 0.0f) {
            f9455a = context.getResources().getDisplayMetrics().density;
        }
        return f9455a;
    }

    public static int b(Context context) {
        if (f9457c == 0) {
            f9457c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return f9457c;
    }

    public static float c(Context context) {
        if (f9456b == 0.0f) {
            f9456b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return f9456b;
    }

    public static int a(int i, Context context) {
        return (int) ((a(context) * i) + 0.5f);
    }

    public static int a(float f2, Context context) {
        return (int) ((f2 * c(context)) + 0.5f);
    }
}
