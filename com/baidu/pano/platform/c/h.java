package com.baidu.pano.platform.c;

import android.content.Context;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static float f9013a;

    /* renamed from: b  reason: collision with root package name */
    public static float f9014b;

    /* renamed from: c  reason: collision with root package name */
    public static int f9015c;

    public static float a(Context context) {
        if (f9013a == 0.0f) {
            f9013a = context.getResources().getDisplayMetrics().density;
        }
        return f9013a;
    }

    public static int b(Context context) {
        if (f9015c == 0) {
            f9015c = context.getResources().getDisplayMetrics().densityDpi;
        }
        return f9015c;
    }

    public static float c(Context context) {
        if (f9014b == 0.0f) {
            f9014b = context.getResources().getDisplayMetrics().scaledDensity;
        }
        return f9014b;
    }

    public static int a(int i, Context context) {
        return (int) ((a(context) * i) + 0.5f);
    }

    public static int a(float f2, Context context) {
        return (int) ((f2 * c(context)) + 0.5f);
    }
}
