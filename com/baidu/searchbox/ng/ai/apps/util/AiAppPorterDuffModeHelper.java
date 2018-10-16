package com.baidu.searchbox.ng.ai.apps.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ng.ai.apps.R;
/* loaded from: classes2.dex */
public final class AiAppPorterDuffModeHelper {
    private static final int COLOR_FF = 255;
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppPorterDuffModeHelper";

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
        return context.getResources().getColor(R.color.aiapps_ui_cover_layer_color);
    }
}
