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
/* loaded from: classes19.dex */
public class FlipperFrameLayout extends FrameLayout implements h.a {
    private h dBF;
    private boolean dBN;
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
        this.dBF = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dBN || this.dBF == null) {
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
                if (z && !this.dBF.isFlipped() && T(rawY)) {
                    this.dBF.gW(true);
                    return true;
                } else if (!z && aSa() && this.dBF.isFlipped() && T(rawY)) {
                    this.dBF.gW(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean aSa() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean T(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void gU(boolean z) {
        this.dBN = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void gV(boolean z) {
        this.dBN = true;
    }
}
