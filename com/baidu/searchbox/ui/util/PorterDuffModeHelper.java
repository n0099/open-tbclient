package com.baidu.searchbox.ui.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public final class PorterDuffModeHelper {
    public static final int COLOR_FF = 255;
    public static final boolean DEBUG = false;
    public static final String TAG = "PorterDuffModeHelper";

    public static void decorateSpecificMode(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        if (context != null && drawable != null) {
            decorateSpecificMode(context, drawable, mode, i, getUiCoverLayerColor(context));
        }
    }

    public static void decorateSpecificMode(Context context, Drawable drawable, PorterDuff.Mode mode, int i, int i2) {
        if (context != null && drawable != null) {
            if (i >= 0 && i < 255) {
                i2 = Color.argb((Color.alpha(i2) * i) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
            }
            if (drawable instanceof LottieDrawable) {
                LottieDrawable lottieDrawable = (LottieDrawable) drawable;
                lottieDrawable.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback<ColorFilter>() { // from class: com.baidu.searchbox.ui.util.PorterDuffModeHelper.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                        return null;
                    }
                });
                final PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                lottieDrawable.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback<ColorFilter>() { // from class: com.baidu.searchbox.ui.util.PorterDuffModeHelper.2
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                        return porterDuffColorFilter;
                    }
                });
                return;
            }
            drawable.setColorFilter(i2, mode);
        }
    }

    public static void decorateSrcATopMode(Context context, Drawable drawable) {
        decorateSrcATopMode(context, drawable, 255);
    }

    public static void decorateSrcATopMode(Context context, Drawable drawable, int i) {
        decorateSpecificMode(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
    }

    public static int getUiCoverLayerColor(Context context) {
        return context.getResources().getColor(R.color.obfuscated_res_0x7f060b83);
    }
}
