package com.baidu.searchbox.ui;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
/* loaded from: classes4.dex */
public class ImageViewPressedEffectHelper {
    public static final int DEFAULT_PRESSED_MASK_LAYER_COLOR = 335544320;
    public static final int EFFECT_PRESSED_MASK_LAYER = 1;
    public static final int NIGHT_PRESSED_MASK_LAYER_COLOR = -1811939328;

    public static void attach(View view2, int i) {
    }

    /* loaded from: classes4.dex */
    public static class PressedMaskEffect implements View.OnTouchListener {
        public boolean mIsNight;

        public PressedMaskEffect() {
            this.mIsNight = false;
        }

        public PressedMaskEffect(boolean z) {
            this.mIsNight = false;
            this.mIsNight = z;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            ImageView imageView;
            Drawable drawable;
            if (!(view2 instanceof ImageView) || (drawable = (imageView = (ImageView) view2).getDrawable()) == null) {
                return false;
            }
            if (this.mIsNight) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        drawable.setColorFilter(PorterDuffModeHelper.getUiCoverLayerColor(view2.getContext()), PorterDuff.Mode.SRC_ATOP);
                        imageView.invalidate();
                    }
                } else {
                    drawable.setColorFilter(ImageViewPressedEffectHelper.NIGHT_PRESSED_MASK_LAYER_COLOR, PorterDuff.Mode.SRC_ATOP);
                    imageView.invalidate();
                }
            } else {
                int action2 = motionEvent.getAction();
                if (action2 != 0) {
                    if (action2 == 1 || action2 == 3) {
                        drawable.clearColorFilter();
                        imageView.invalidate();
                    }
                } else {
                    drawable.setColorFilter(ImageViewPressedEffectHelper.DEFAULT_PRESSED_MASK_LAYER_COLOR, PorterDuff.Mode.SRC_ATOP);
                    imageView.invalidate();
                }
            }
            return false;
        }
    }

    public static void attach(View view2) {
        if (view2 != null) {
            view2.setOnTouchListener(new PressedMaskEffect());
        }
    }

    public static void attach(View view2, boolean z) {
        if (view2 != null) {
            view2.setOnTouchListener(new PressedMaskEffect(z));
        }
    }
}
