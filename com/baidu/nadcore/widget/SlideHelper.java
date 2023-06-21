package com.baidu.nadcore.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.tieba.bd1;
import com.baidu.tieba.dd1;
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

    public void closePane() {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.o();
        }
    }

    public View getMaskView() {
        return this.mMaskView;
    }

    public SlideHelper(boolean z) {
        this.canSlide = true;
        this.canSlide = z;
    }

    public void attachActivity(Activity activity) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.m(activity);
        }
    }

    public void attachSlideActivity(Activity activity) {
        if (activity != null) {
            attachSlideView(activity, activity.findViewById(16908290));
            attachActivity(activity);
        }
    }

    public void forceActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.w(z);
        }
    }

    public void setActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            if (z) {
                slidingPaneLayout.r();
            } else {
                slidingPaneLayout.q();
            }
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
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setCanSlidable(z);
        }
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
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setNightMode(z);
        }
    }

    public void setOnTransparentListener(bd1 bd1Var) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout) && bd1Var != null) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setOnTransparentListener(bd1Var);
        }
    }

    public void setRegionFactor(double d) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.setCanSlideRegionFactor(d);
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
        if (slideInterceptor != null && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setSlideInterceptor(slideInterceptor);
        }
    }

    public void setSlideListener(SlidingPaneLayout.e eVar) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null && eVar != null) {
            slidingPaneLayout.setPanelSlideListener(eVar);
        }
    }

    public void showShadow(boolean z) {
        SlidingPaneLayout slidingPaneLayout = this.mSlideLayout;
        if (slidingPaneLayout != null) {
            slidingPaneLayout.A(z);
        }
    }

    public void attachSlideView(Context context, View view2) {
        attachSlideView(context, view2, null);
    }

    public void attachSlideView(Context context, View view2, SlidingPaneLayout.LayoutParams layoutParams) {
        if (view2 != null && this.canSlide) {
            boolean isFocused = view2.isFocused();
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            viewGroup.removeView(view2);
            if (this.mMaskView == null) {
                View view3 = new View(context);
                this.mMaskView = view3;
                view3.setBackgroundColor(Color.parseColor("#40000000"));
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout = customSlidingPanelLayout;
            customSlidingPanelLayout.setShadowDrawable(dd1.e(context, "sliding_layout_shadow.9.png"));
            this.mSlideLayout.addView(this.mMaskView, layoutParams2);
            this.mSlideLayout.addView(view2, layoutParams2);
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
    }

    public View wrapSlideView(Context context, View view2, SlideInterceptor slideInterceptor) {
        if (view2 != null && this.canSlide) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
            if (this.mMaskView == null) {
                View view3 = new View(context);
                this.mMaskView = view3;
                view3.setBackgroundColor(Color.parseColor("#40000000"));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout = customSlidingPanelLayout;
            customSlidingPanelLayout.setShadowDrawable(dd1.e(context, "sliding_layout_shadow.9.png"));
            this.mSlideLayout.addView(this.mMaskView, layoutParams);
            this.mSlideLayout.addView(view2, layoutParams);
            if (slideInterceptor != null) {
                ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
            }
            return this.mSlideLayout;
        }
        return view2;
    }
}
