package com.baidu.swan.apps.media.image;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
public final class c {
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
        return 0;
    }
}
