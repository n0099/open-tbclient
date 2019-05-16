package com.baidu.swan.apps.an;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public final class s {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Context context, Drawable drawable) {
        a(context, drawable, 255);
    }

    public static void a(Context context, Drawable drawable, int i) {
        a(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
    }

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        if (context != null && drawable != null) {
            int bL = bL(context);
            if (i >= 0 && i < 255) {
                bL = Color.argb((Color.alpha(bL) * i) / 255, Color.red(bL), Color.green(bL), Color.blue(bL));
            }
            drawable.setColorFilter(bL, mode);
        }
    }

    public static int bL(Context context) {
        return context.getResources().getColor(a.c.aiapps_ui_cover_layer_color);
    }
}
