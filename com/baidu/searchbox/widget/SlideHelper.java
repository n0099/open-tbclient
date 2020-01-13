package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.widget.SlidingPaneLayout;
/* loaded from: classes10.dex */
public class SlideHelper {
    private static final String DEFAULT_MASK_COLOR = "#40000000";
    private static final String DEFAULT_SHADOW_DRAWABLE = "sliding_layout_shadow.9.png";
    private boolean canSlide;
    private View mMaskView;
    private SlidingPaneLayout mSlideLayout;

    public SlideHelper() {
        this(true);
    }

    public SlideHelper(boolean z) {
        this.canSlide = true;
        this.canSlide = z;
    }

    public void attachSlideView(Context context, View view) {
        if (view != null && this.canSlide) {
            boolean isFocused = view.isFocused();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            if (this.mMaskView == null) {
                this.mMaskView = new View(context);
                this.mMaskView.setBackgroundColor(Color.parseColor(DEFAULT_MASK_COLOR));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.mSlideLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout.setShadowDrawable(SlideUtil.getImageFromFile(context, DEFAULT_SHADOW_DRAWABLE));
            this.mSlideLayout.addView(this.mMaskView, layoutParams);
            this.mSlideLayout.addView(view, layoutParams);
            this.mSlideLayout.setSliderFadeColor(0);
            viewGroup.addView(this.mSlideLayout);
            if (isFocused) {
                this.mSlideLayout.requestFocus();
            }
        }
    }

    public View wrapSlideView(Context context, View view, SlideInterceptor slideInterceptor) {
        if (view != null && this.canSlide) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            if (this.mMaskView == null) {
                this.mMaskView = new View(context);
                this.mMaskView.setBackgroundColor(Color.parseColor(DEFAULT_MASK_COLOR));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.mSlideLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout.setShadowDrawable(SlideUtil.getImageFromFile(context, DEFAULT_SHADOW_DRAWABLE));
            this.mSlideLayout.addView(this.mMaskView, layoutParams);
            this.mSlideLayout.addView(view, layoutParams);
            if (slideInterceptor != null) {
                ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
            }
            return this.mSlideLayout;
        }
        return view;
    }

    public void attachActivity(Activity activity) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            this.mSlideLayout.attachActivity(activity);
        }
    }

    public void forceActivityTransparent(boolean z) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            this.mSlideLayout.forceActivityTransparent(z);
        }
    }

    public void setActivityTransparent(boolean z) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            if (z) {
                this.mSlideLayout.convertActivityToTranslucent();
            } else {
                this.mSlideLayout.convertActivityFromTranslucent();
            }
        }
    }

    public void setOnTransparentListener(OnTranslucentListener onTranslucentListener) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout) && onTranslucentListener != null) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setOnTransparentListener(onTranslucentListener);
        }
    }

    public void setSlideListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        if (this.mSlideLayout != null && panelSlideListener != null) {
            this.mSlideLayout.setPanelSlideListener(panelSlideListener);
        }
    }

    public void setFadeColor(int i) {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.setSliderFadeColor(i);
        }
    }

    public void setNightMode(boolean z) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setNightMode(z);
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.setShadowDrawable(drawable);
        }
    }

    public void setCanSlide(boolean z) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setCanSlidable(z);
        }
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.setEnableReleaseWhenNoTranslucent(z);
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        if (slideInterceptor != null && this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
        }
    }

    public void setAutoSlideToRight(boolean z) {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.setAutoSlideToRight(z);
        }
    }

    public View getMaskView() {
        return this.mMaskView;
    }

    public void setRegionFactor(double d) {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.setCanSlideRegionFactor(d);
        }
    }

    public void closePane() {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.closePane();
        }
    }

    public void showShadow(boolean z) {
        if (this.mSlideLayout != null) {
            this.mSlideLayout.isShowShadow(z);
        }
    }
}
