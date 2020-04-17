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
/* loaded from: classes12.dex */
public class FlipperFrameLayout extends FrameLayout implements h.a {
    private float UZ;
    private h cVR;
    private boolean cVZ;

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
        this.cVR = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cVZ || this.cVR == null) {
            this.UZ = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.UZ = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.UZ = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.UZ;
                boolean z = rawY <= 0.0f;
                if (z && !this.cVR.isFlipped() && N(rawY)) {
                    this.cVR.fO(true);
                    return true;
                } else if (!z && aAv() && this.cVR.isFlipped() && N(rawY)) {
                    this.cVR.fO(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean aAv() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean N(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void fM(boolean z) {
        this.cVZ = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void fN(boolean z) {
        this.cVZ = true;
    }
}
