package com.baidu.platform.comapi.wnplatform.p;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes20.dex */
public class h {
    private static float c = 0.0f;
    private static int d = 0;
    public static int a = Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER;
    public static int b = 133;

    public static float a(Context context) {
        if (c == 0.0f) {
            c = context.getResources().getDisplayMetrics().density;
        }
        return c;
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
        if (d > 0) {
            return d;
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
}
