package com.baidu.swan.apps.ao;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.baidu.swan.apps.a;
/* loaded from: classes8.dex */
public final class z {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Context context, Drawable drawable) {
        a(context, drawable, 255);
    }

    public static void a(Context context, Drawable drawable, int i) {
        a(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
    }

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        if (context != null && drawable != null) {
            int da = da(context);
            if (i >= 0 && i < 255) {
                da = Color.argb((Color.alpha(da) * i) / 255, Color.red(da), Color.green(da), Color.blue(da));
            }
            drawable.setColorFilter(da, mode);
        }
    }

    public static int da(Context context) {
        return context.getResources().getColor(a.c.aiapps_ui_cover_layer_color);
    }
}
