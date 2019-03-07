package com.baidu.searchbox.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.widget.SlidingPaneLayout;
/* loaded from: classes2.dex */
public class SlideHelper {
    private static final String DEFAULT_MASK_COLOR = "#0D000000";
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
            this.mSlideLayout.setShadowResource(R.drawable.sliding_layout_shadow);
            this.mSlideLayout.addView(this.mMaskView, layoutParams);
            this.mSlideLayout.addView(view, layoutParams);
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
            this.mSlideLayout.setShadowResource(R.drawable.sliding_layout_shadow);
            this.mSlideLayout.addView(this.mMaskView, layoutParams);
            this.mSlideLayout.addView(view, layoutParams);
            if (slideInterceptor != null) {
                ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
            }
            return this.mSlideLayout;
        }
        return view;
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

    public void setCanSlide(boolean z) {
        if (this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setCanSlidable(z);
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        if (slideInterceptor != null && this.mSlideLayout != null && (this.mSlideLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
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
}
