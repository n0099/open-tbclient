package com.baidu.platform.comapi.wnplatform.o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static float f9926a;

    /* renamed from: b  reason: collision with root package name */
    public static int f9927b;

    public static float a(Context context) {
        if (f9926a == 0.0f) {
            f9926a = context.getResources().getDisplayMetrics().density;
        }
        return f9926a;
    }

    public static int b(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public static int c(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public static int d(Context context) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int e(Context context) {
        int c2;
        int d2;
        if (context == null) {
            return 0;
        }
        int i = f9927b;
        if (i > 0) {
            return i;
        }
        if (context instanceof Activity) {
            View findViewById = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null && findViewById.getHeight() > 0) {
                return findViewById.getHeight();
            }
            c2 = c(context);
            d2 = d(context);
        } else {
            c2 = c(context);
            d2 = d(context);
        }
        return c2 - d2;
    }

    public static float b(float f2, Context context) {
        if (context == null) {
            return f2;
        }
        int b2 = b(context);
        float f3 = b2 / 2.0f;
        float f4 = ((f3 - f2) / f3) * (b2 / 4);
        float f5 = f2 + f4;
        com.baidu.platform.comapi.wnplatform.d.a.b("getRightY:rawY:" + f2 + "centerY:" + f3 + "yOffSet:" + f4);
        return f5;
    }

    public static int a(Context context, int i) {
        return (int) ((a(context) * i) + 0.5f);
    }

    public static float a(float f2, Context context) {
        if (context == null) {
            return f2;
        }
        int b2 = b(context);
        float f3 = b2 / 2.0f;
        float f4 = ((f3 - f2) / f3) * (b2 / 4);
        float f5 = f2 + f4;
        com.baidu.platform.comapi.wnplatform.d.a.b("getRightX:rawX:" + f2 + "centerX:" + f3 + "xOffSet:" + f4);
        return f5;
    }
}
