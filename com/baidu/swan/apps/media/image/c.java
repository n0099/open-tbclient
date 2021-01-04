package com.baidu.swan.apps.media.image;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes9.dex */
public final class c {
    public static void a(Context context, Drawable drawable) {
        a(context, drawable, 255);
    }

    public static void a(Context context, Drawable drawable, int i) {
        a(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
    }

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        if (context != null && drawable != null) {
            int dd = dd(context);
            if (i >= 0 && i < 255) {
                dd = Color.argb((Color.alpha(dd) * i) / 255, Color.red(dd), Color.green(dd), Color.blue(dd));
            }
            drawable.setColorFilter(dd, mode);
        }
    }

    public static int dd(Context context) {
        return 0;
    }
}
