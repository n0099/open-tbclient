package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    private boolean mCanSlide;
    private boolean mForceActivityTransparent;
    private OnTranslucentListener mListener;
    private boolean mNightMode;
    private SlideInterceptor mSlideInterceptor;
    private double mSlideRegionFactor;
    private WeakReference<Activity> mTopActivity;

    public CustomSlidingPanelLayout(Context context) {
        super(context);
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
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
                try {
                    if (this.mSlideInterceptor != null) {
                        if (!this.mSlideInterceptor.isSlidable(motionEvent)) {
                            return false;
                        }
                    }
                } catch (AbstractMethodError e) {
                    e.printStackTrace();
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void attachActivity(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21 && activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            this.mTopActivity = new WeakReference<>(activity);
            activity.getWindow().getDecorView().setBackgroundColor(0);
            if (!this.mForceActivityTransparent) {
                convertActivityFromTranslucent();
            }
        }
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void forceActivityTransparent(boolean z) {
        this.mForceActivityTransparent = z;
    }

    public void setNightMode(boolean z) {
        this.mNightMode = z;
    }

    protected void init() {
        setCanSlideRegionFactor(this.mSlideRegionFactor);
        setActivityIsTranslucent(true);
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        this.mSlideInterceptor = slideInterceptor;
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void convertActivityToTranslucent() {
        if (this.mTopActivity == null || this.mTopActivity.get() == null) {
            if (this.mListener != null) {
                this.mListener.onTranslucent(false);
                return;
            }
            return;
        }
        SlideUtil.convertToTranslucent(this.mTopActivity.get(), new OnTranslucentListener() { // from class: com.baidu.searchbox.widget.CustomSlidingPanelLayout.1
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
                CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
                if (CustomSlidingPanelLayout.this.mListener != null) {
                    CustomSlidingPanelLayout.this.mListener.onTranslucent(z);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void convertActivityFromTranslucent() {
        if (this.mTopActivity == null || this.mTopActivity.get() == null) {
            if (this.mListener != null) {
                this.mListener.onTranslucent(true);
                return;
            }
            return;
        }
        SlideUtil.convertFromTranslucent(this.mTopActivity.get(), new OnTranslucentListener() { // from class: com.baidu.searchbox.widget.CustomSlidingPanelLayout.2
            @Override // com.baidu.searchbox.widget.OnTranslucentListener
            public void onTranslucent(boolean z) {
                CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
                if (CustomSlidingPanelLayout.this.mListener != null) {
                    CustomSlidingPanelLayout.this.mListener.onTranslucent(z);
                }
            }
        });
    }

    public void setOnTransparentListener(OnTranslucentListener onTranslucentListener) {
        this.mListener = onTranslucentListener;
    }
}
