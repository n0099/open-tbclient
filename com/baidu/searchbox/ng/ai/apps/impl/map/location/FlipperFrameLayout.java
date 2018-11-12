package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ScrollingView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationViewFlipper;
/* loaded from: classes4.dex */
public class FlipperFrameLayout extends FrameLayout implements LocationViewFlipper.OnFlipListener {
    private boolean mIsInAnimation;
    private float mLastY;
    private LocationViewFlipper mViewFlipper;

    public FlipperFrameLayout(@NonNull Context context) {
        super(context);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setViewFlipper(LocationViewFlipper locationViewFlipper) {
        this.mViewFlipper = locationViewFlipper;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsInAnimation || this.mViewFlipper == null) {
            this.mLastY = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastY = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.mLastY = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.mLastY;
                boolean z = rawY <= 0.0f;
                if (z && !this.mViewFlipper.isFlipped() && overSlop(rawY)) {
                    this.mViewFlipper.scrollView(true);
                    return true;
                } else if (!z && isScrollChildInTop() && this.mViewFlipper.isFlipped() && overSlop(rawY)) {
                    this.mViewFlipper.scrollView(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean isScrollChildInTop() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean overSlop(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationViewFlipper.OnFlipListener
    public void onFlipOver(boolean z) {
        this.mIsInAnimation = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.impl.map.location.LocationViewFlipper.OnFlipListener
    public void onFlipStart(boolean z) {
        this.mIsInAnimation = true;
    }
}
