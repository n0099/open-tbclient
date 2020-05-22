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
    private float Vr;
    private h dgX;
    private boolean dhf;

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
        this.dgX = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dhf || this.dgX == null) {
            this.Vr = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.Vr = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.Vr = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.Vr;
                boolean z = rawY <= 0.0f;
                if (z && !this.dgX.isFlipped() && M(rawY)) {
                    this.dgX.fZ(true);
                    return true;
                } else if (!z && aEn() && this.dgX.isFlipped() && M(rawY)) {
                    this.dgX.fZ(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean aEn() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean M(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void fX(boolean z) {
        this.dhf = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void fY(boolean z) {
        this.dhf = true;
    }
}
