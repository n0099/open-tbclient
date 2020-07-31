package com.baidu.searchbox.ui.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.e.b;
import com.airbnb.lottie.g;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.e;
import com.baidu.android.common.ui.R;
/* loaded from: classes3.dex */
public final class PorterDuffModeHelper {
    private static final int COLOR_FF = 255;
    private static final boolean DEBUG = false;
    private static final String TAG = "PorterDuffModeHelper";

    public static void decorateSrcATopMode(Context context, Drawable drawable) {
        decorateSrcATopMode(context, drawable, 255);
    }

    public static void decorateSrcATopMode(Context context, Drawable drawable, int i) {
        decorateSpecificMode(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
    }

    public static void decorateSpecificMode(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        if (context != null && drawable != null) {
            int uiCoverLayerColor = getUiCoverLayerColor(context);
            int argb = (i < 0 || i >= 255) ? uiCoverLayerColor : Color.argb((Color.alpha(uiCoverLayerColor) * i) / 255, Color.red(uiCoverLayerColor), Color.green(uiCoverLayerColor), Color.blue(uiCoverLayerColor));
            if (drawable instanceof g) {
                ((g) drawable).addValueCallback(new e("**"), (e) k.Bx, (com.airbnb.lottie.e.e<e>) new com.airbnb.lottie.e.e<ColorFilter>() { // from class: com.baidu.searchbox.ui.util.PorterDuffModeHelper.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.airbnb.lottie.e.e
                    public ColorFilter getValue(b<ColorFilter> bVar) {
                        return null;
                    }
                });
                final PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(argb, mode);
                ((g) drawable).addValueCallback(new e("**"), (e) k.Bx, (com.airbnb.lottie.e.e<e>) new com.airbnb.lottie.e.e<ColorFilter>() { // from class: com.baidu.searchbox.ui.util.PorterDuffModeHelper.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.airbnb.lottie.e.e
                    public ColorFilter getValue(b<ColorFilter> bVar) {
                        return porterDuffColorFilter;
                    }
                });
                return;
            }
            drawable.setColorFilter(argb, mode);
        }
    }

    public static int getUiCoverLayerColor(Context context) {
        return context.getResources().getColor(R.color.ui_cover_layer_color);
    }
}
