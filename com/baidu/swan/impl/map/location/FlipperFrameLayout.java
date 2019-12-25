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
/* loaded from: classes9.dex */
public class FlipperFrameLayout extends FrameLayout implements h.a {
    private float Bi;
    private boolean csD;
    private h csv;

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
        this.csv = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.csD || this.csv == null) {
            this.Bi = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.Bi = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.Bi = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.Bi;
                boolean z = rawY <= 0.0f;
                if (z && !this.csv.isFlipped() && af(rawY)) {
                    this.csv.eE(true);
                    return true;
                } else if (!z && apz() && this.csv.isFlipped() && af(rawY)) {
                    this.csv.eE(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean apz() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean af(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void eC(boolean z) {
        this.csD = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void eD(boolean z) {
        this.csD = true;
    }
}
