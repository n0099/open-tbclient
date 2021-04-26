package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static float f9344a;

    /* renamed from: b  reason: collision with root package name */
    public static float f9345b;

    /* renamed from: c  reason: collision with root package name */
    public static int f9346c;

    public static float a(Context context) {
        if (f9344a == 0.0f) {
            f9344a = context.getResources().getDisplayMetrics().density;
        }
        return f9344a;
    }

    public static int b(Context context) {
        if (f9346c == 0) {
            f9346c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return f9346c;
    }

    public static float c(Context context) {
        if (f9345b == 0.0f) {
            f9345b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return f9345b;
    }

    public static int a(int i2, Context context) {
        return (int) ((a(context) * i2) + 0.5f);
    }

    public static int a(float f2, Context context) {
        return (int) ((f2 * c(context)) + 0.5f);
    }
}
