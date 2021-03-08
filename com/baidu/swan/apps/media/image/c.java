package com.baidu.swan.apps.media.image;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes8.dex */
public final class c {
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
        return 0;
    }
}
