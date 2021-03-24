package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.widget.SlidingPaneLayout;
/* loaded from: classes3.dex */
public class SlideHelper {
    public static final String DEFAULT_MASK_COLOR = "#40000000";
    public static final String DEFAULT_SHADOW_DRAWABLE = "sliding_layout_shadow.9.png";
    public boolean canSlide;
    public View mMaskView;
    public SlidingPaneLayout mSlideLayout;

    public SlideHelper() {
        this(true);
    }

    public void attachActivity(Activity activity) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        slidingPaneLayout.attachActivity(activity);
    }

    public void attachSlideActivity(Activity activity) {
        if (activity != null) {
            attachSlideView(activity, activity.findViewById(16908290));
            attachActivity(activity);
        }
    }

    public void attachSlideView(Context context, View view, SlidingPaneLayout.LayoutParams layoutParams) {
        if (view == null || !this.canSlide) {
            return;
        }
        boolean isFocused = view.isFocused();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.removeView(view);
        if (this.mMaskView == null) {
            View view2 = new View(context);
            this.mMaskView = view2;
            view2.setBackgroundColor(Color.parseColor(DEFAULT_MASK_COLOR));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
        this.mSlideLayout = customSlidingPanelLayout;
        customSlidingPanelLayout.setShadowDrawable(SlideUtil.getImageFromFile(context, DEFAULT_SHADOW_DRAWABLE));
        this.mSlideLayout.addView(this.mMaskView, layoutParams2);
        this.mSlideLayout.addView(view, layoutParams2);
        this.mSlideLayout.setSliderFadeColor(0);
        if (layoutParams == null) {
            viewGroup.addView(this.mSlideLayout);
        } else {
            viewGroup.addView(this.mSlideLayout, layoutParams);
        }
        if (isFocused) {
            this.mSlideLayout.requestFocus();
        }
    }

    public void closePane() {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.closePane();
        }
    }

    public void forceActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        slidingPaneLayout.forceActivityTransparent(z);
    }

    public View getMaskView() {
        return this.mMaskView;
    }

    public void setActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        if (z) {
            slidingPaneLayout.convertActivityToTranslucent();
        } else {
            slidingPaneLayout.convertActivityFromTranslucent();
        }
    }

    public void setAutoSlideToRight(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setAutoSlideToRight(z);
        }
    }

    public void setCanSlide(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        ((CustomSlidingPanelLayout) slidingPaneLayout).setCanSlidable(z);
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setEnableReleaseWhenNoTranslucent(z);
        }
    }

    public void setFadeColor(int i) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setSliderFadeColor(i);
        }
    }

    public void setNightMode(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        ((CustomSlidingPanelLayout) slidingPaneLayout).setNightMode(z);
    }

    public void setOnTransparentListener(OnTranslucentListener onTranslucentListener) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout) || onTranslucentListener == null) {
            return;
        }
        ((CustomSlidingPanelLayout) slidingPaneLayout).setOnTransparentListener(onTranslucentListener);
    }

    public void setRegionFactor(double d2) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setCanSlideRegionFactor(d2);
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setShadowDrawable(drawable);
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        SlidingPaneLayout slidingPaneLayout;
        if (slideInterceptor == null || (slidingPaneLayout = this.mSlideLayout) == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        ((CustomSlidingPanelLayout) slidingPaneLayout).setSlideInterceptor(slideInterceptor);
    }

    public void setSlideListener(SlidingPaneLayout.PanelSlideListener panelSlideListener) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout == null || panelSlideListener == null) {
            return;
        }
        slidingPaneLayout.setPanelSlideListener(panelSlideListener);
    }

    public void showShadow(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.isShowShadow(z);
        }
    }

    public View wrapSlideView(Context context, View view, SlideInterceptor slideInterceptor) {
        if (view == null || !this.canSlide) {
            return view;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        if (this.mMaskView == null) {
            View view2 = new View(context);
            this.mMaskView = view2;
            view2.setBackgroundColor(Color.parseColor(DEFAULT_MASK_COLOR));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
        this.mSlideLayout = customSlidingPanelLayout;
        customSlidingPanelLayout.setShadowDrawable(SlideUtil.getImageFromFile(context, DEFAULT_SHADOW_DRAWABLE));
        this.mSlideLayout.addView(this.mMaskView, layoutParams);
        this.mSlideLayout.addView(view, layoutParams);
        if (slideInterceptor != null) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
        }
        return this.mSlideLayout;
    }

    public SlideHelper(boolean z) {
        this.canSlide = true;
        this.canSlide = z;
    }

    public void attachSlideView(Context context, View view) {
        attachSlideView(context, view, null);
    }
}
