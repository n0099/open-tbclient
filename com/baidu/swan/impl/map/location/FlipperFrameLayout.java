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
    private float VV;
    private h dlJ;
    private boolean dlR;

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
        this.dlJ = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dlR || this.dlJ == null) {
            this.VV = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.VV = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.VV = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.VV;
                boolean z = rawY <= 0.0f;
                if (z && !this.dlJ.isFlipped() && O(rawY)) {
                    this.dlJ.ge(true);
                    return true;
                } else if (!z && aFt() && this.dlJ.isFlipped() && O(rawY)) {
                    this.dlJ.ge(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean aFt() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean O(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void gc(boolean z) {
        this.dlR = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void gd(boolean z) {
        this.dlR = true;
    }
}
