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
/* loaded from: classes10.dex */
public class FlipperFrameLayout extends FrameLayout implements h.a {
    private float Bn;
    private h csG;
    private boolean csO;

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
        this.csG = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.csO || this.csG == null) {
            this.Bn = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.Bn = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.Bn = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.Bn;
                boolean z = rawY <= 0.0f;
                if (z && !this.csG.isFlipped() && ae(rawY)) {
                    this.csG.eJ(true);
                    return true;
                } else if (!z && apS() && this.csG.isFlipped() && ae(rawY)) {
                    this.csG.eJ(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean apS() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean ae(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void eH(boolean z) {
        this.csO = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void eI(boolean z) {
        this.csO = true;
    }
}
