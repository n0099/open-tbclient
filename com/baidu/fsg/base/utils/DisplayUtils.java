package com.baidu.fsg.base.utils;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes6.dex */
public final class DisplayUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final float f2023a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    private static DisplayMetrics f2024b;

    private DisplayUtils() {
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f, float f2) {
        return (int) ((f / f2) + 0.5f);
    }

    public static int sp2px(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    private static void a(Context context) {
        if (f2024b == null) {
            f2024b = context.getResources().getDisplayMetrics();
        }
    }

    public static int getDisplayWidth(Context context) {
        a(context);
        return f2024b.widthPixels;
    }

    public static int getDisplayHeight(Context context) {
        a(context);
        return f2024b.heightPixels;
    }
}
