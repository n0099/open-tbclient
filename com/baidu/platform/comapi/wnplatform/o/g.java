package com.baidu.platform.comapi.wnplatform.o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static float f4459a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private static int f4460b = 0;

    public static float a(Context context) {
        if (f4459a == 0.0f) {
            f4459a = context.getResources().getDisplayMetrics().density;
        }
        return f4459a;
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
        if (context == null) {
            return 0;
        }
        if (f4460b > 0) {
            return f4460b;
        }
        if (context instanceof Activity) {
            View findViewById = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null && findViewById.getHeight() > 0) {
                return findViewById.getHeight();
            }
            return c(context) - d(context);
        }
        return c(context) - d(context);
    }

    public static int a(Context context, int i) {
        return (int) (0.5f + (a(context) * i));
    }

    public static float a(float f, Context context) {
        if (context != null) {
            int b2 = b(context);
            float f2 = b2 / 2.0f;
            float f3 = ((f2 - f) / f2) * (b2 / 4);
            float f4 = f + f3;
            com.baidu.platform.comapi.wnplatform.d.a.b("getRightX:rawX:" + f + "centerX:" + f2 + "xOffSet:" + f3);
            return f4;
        }
        return f;
    }

    public static float b(float f, Context context) {
        if (context != null) {
            int b2 = b(context);
            float f2 = b2 / 2.0f;
            float f3 = ((f2 - f) / f2) * (b2 / 4);
            float f4 = f + f3;
            com.baidu.platform.comapi.wnplatform.d.a.b("getRightY:rawY:" + f + "centerY:" + f2 + "yOffSet:" + f3);
            return f4;
        }
        return f;
    }
}
