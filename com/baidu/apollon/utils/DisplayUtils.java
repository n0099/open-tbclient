package com.baidu.apollon.utils;

import android.content.Context;
import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public final class DisplayUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final float f3981a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public static DisplayMetrics f3982b;

    public static void a(Context context) {
        if (f3982b == null) {
            f3982b = context.getResources().getDisplayMetrics();
        }
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getDisplayHeight(Context context) {
        a(context);
        return f3982b.heightPixels;
    }

    public static int getDisplayWidth(Context context) {
        a(context);
        return f3982b.widthPixels;
    }

    public static int px2dip(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f2, float f3) {
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int sp2px(float f2, float f3) {
        return (int) ((f2 * f3) + 0.5f);
    }
}
