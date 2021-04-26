package com.baidu.searchbox.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class CustomSlidingPanelLayout extends SlidingPaneLayout {
    public boolean mCanSlide;
    public boolean mForceActivityTransparent;
    public OnTranslucentListener mListener;
    public boolean mNightMode;
    public SlideInterceptor mSlideInterceptor;
    public double mSlideRegionFactor;
    public WeakReference<Activity> mTopActivity;

    public CustomSlidingPanelLayout(Context context) {
        super(context);
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void attachActivity(Activity activity) {
        if (Build.VERSION.SDK_INT < 21 || activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return;
        }
        this.mTopActivity = new WeakReference<>(activity);
        activity.getWindow().getDecorView().setBackgroundColor(0);
        if (this.mForceActivityTransparent) {
            return;
        }
        convertActivityFromTranslucent();
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void convertActivityFromTranslucent() {
        WeakReference<Activity> weakReference = this.mTopActivity;
        if (weakReference != null && weakReference.get() != null) {
            SlideUtil.convertFromTranslucent(this.mTopActivity.get(), new OnTranslucentListener() { // from class: com.baidu.searchbox.widget.CustomSlidingPanelLayout.2
                @Override // com.baidu.searchbox.widget.OnTranslucentListener
                public void onTranslucent(boolean z) {
                    CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
                    if (CustomSlidingPanelLayout.this.mListener != null) {
                        CustomSlidingPanelLayout.this.mListener.onTranslucent(z);
                    }
                }
            });
            return;
        }
        OnTranslucentListener onTranslucentListener = this.mListener;
        if (onTranslucentListener != null) {
            onTranslucentListener.onTranslucent(true);
        }
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void convertActivityToTranslucent() {
        WeakReference<Activity> weakReference = this.mTopActivity;
        if (weakReference != null && weakReference.get() != null) {
            SlideUtil.convertToTranslucent(this.mTopActivity.get(), new OnTranslucentListener() { // from class: com.baidu.searchbox.widget.CustomSlidingPanelLayout.1
                @Override // com.baidu.searchbox.widget.OnTranslucentListener
                public void onTranslucent(boolean z) {
                    CustomSlidingPanelLayout.this.setActivityIsTranslucent(z);
                    if (CustomSlidingPanelLayout.this.mListener != null) {
                        CustomSlidingPanelLayout.this.mListener.onTranslucent(z);
                    }
                }
            });
            return;
        }
        OnTranslucentListener onTranslucentListener = this.mListener;
        if (onTranslucentListener != null) {
            onTranslucentListener.onTranslucent(false);
        }
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout
    public void forceActivityTransparent(boolean z) {
        this.mForceActivityTransparent = z;
    }

    public void init() {
        setCanSlideRegionFactor(this.mSlideRegionFactor);
        setActivityIsTranslucent(true);
    }

    @Override // com.baidu.searchbox.widget.SlidingPaneLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        if (MotionEventCompat.getActionMasked(motionEvent) == 2) {
            if (!this.mCanSlide) {
                return false;
            }
            try {
                if (this.mSlideInterceptor != null) {
                    if (!this.mSlideInterceptor.isSlidable(motionEvent)) {
                        return false;
                    }
                }
            } catch (AbstractMethodError e2) {
                e2.printStackTrace();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCanSlidable(boolean z) {
        this.mCanSlide = z;
    }

    public void setNightMode(boolean z) {
        this.mNightMode = z;
    }

    public void setOnTransparentListener(OnTranslucentListener onTranslucentListener) {
        this.mListener = onTranslucentListener;
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        this.mSlideInterceptor = slideInterceptor;
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }

    public CustomSlidingPanelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCanSlide = true;
        this.mForceActivityTransparent = false;
        this.mSlideRegionFactor = 1.0d;
        init();
    }
}
