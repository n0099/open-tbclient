package com.baidu.swan.apps.as;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public final class w {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void decorateSrcATopMode(Context context, Drawable drawable) {
        decorateSrcATopMode(context, drawable, 255);
    }

    public static void decorateSrcATopMode(Context context, Drawable drawable, int i) {
        decorateSpecificMode(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
    }

    public static void decorateSpecificMode(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        if (context != null && drawable != null) {
            int uiCoverLayerColor = getUiCoverLayerColor(context);
            if (i >= 0 && i < 255) {
                uiCoverLayerColor = Color.argb((Color.alpha(uiCoverLayerColor) * i) / 255, Color.red(uiCoverLayerColor), Color.green(uiCoverLayerColor), Color.blue(uiCoverLayerColor));
            }
            drawable.setColorFilter(uiCoverLayerColor, mode);
        }
    }

    public static int getUiCoverLayerColor(Context context) {
        return context.getResources().getColor(a.c.aiapps_ui_cover_layer_color);
    }
}
