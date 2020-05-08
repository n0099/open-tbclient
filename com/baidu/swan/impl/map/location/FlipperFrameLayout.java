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
    private float Vc;
    private h cVW;
    private boolean cWe;

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
        this.cVW = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cWe || this.cVW == null) {
            this.Vc = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.Vc = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.Vc = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.Vc;
                boolean z = rawY <= 0.0f;
                if (z && !this.cVW.isFlipped() && N(rawY)) {
                    this.cVW.fO(true);
                    return true;
                } else if (!z && aAv() && this.cVW.isFlipped() && N(rawY)) {
                    this.cVW.fO(false);
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
        this.cWe = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void fN(boolean z) {
        this.cWe = true;
    }
}
