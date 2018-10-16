package com.baidu.searchbox.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes2.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    private boolean mCanSlide;
    private SlideInterceptor mSlideInterceptor;
    private double mSlideRegionFactor;

    public CustomSlidingPanelLayout(Context context) {
        super(context);
        this.mCanSlide = true;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanSlide = true;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanSlide = true;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    public void setCanSlidable(boolean z) {
        this.mCanSlide = z;
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 2:
                if (!this.mCanSlide) {
                    return false;
                }
                if (this.mSlideInterceptor != null && !this.mSlideInterceptor.isSlidable()) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    protected void init() {
        setCanSlideRegionFactor(this.mSlideRegionFactor);
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        this.mSlideInterceptor = slideInterceptor;
    }
}
