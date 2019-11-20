package com.baidu.swan.impl.map.location;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ScrollingView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.swan.impl.map.location.h;
/* loaded from: classes5.dex */
public class FlipperFrameLayout extends FrameLayout implements h.a {
    private h bHf;
    private boolean bHn;
    private float mLastY;

    public FlipperFrameLayout(@NonNull Context context) {
        super(context);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlipperFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setViewFlipper(h hVar) {
        this.bHf = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.bHn || this.bHf == null) {
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
                if (z && !this.bHf.ZT() && aa(rawY)) {
                    this.bHf.du(true);
                    return true;
                } else if (!z && ZP() && this.bHf.ZT() && aa(rawY)) {
                    this.bHf.du(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean ZP() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean aa(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void dr(boolean z) {
        this.bHn = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void ds(boolean z) {
        this.bHn = true;
    }
}
