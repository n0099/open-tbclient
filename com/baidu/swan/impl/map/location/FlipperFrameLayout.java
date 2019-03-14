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
    private float Qm;
    private h bhQ;
    private boolean bhY;

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
        this.bhQ = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.bhY || this.bhQ == null) {
            this.Qm = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.Qm = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.Qm = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.Qm;
                boolean z = rawY <= 0.0f;
                if (z && !this.bhQ.QA() && aj(rawY)) {
                    this.bhQ.cJ(true);
                    return true;
                } else if (!z && Qw() && this.bhQ.QA() && aj(rawY)) {
                    this.bhQ.cJ(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean Qw() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean aj(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void cG(boolean z) {
        this.bhY = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void cH(boolean z) {
        this.bhY = true;
    }
}
