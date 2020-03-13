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
    private float BF;
    private h cwK;
    private boolean cwS;

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
        this.cwK = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cwS || this.cwK == null) {
            this.BF = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.BF = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.BF = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.BF;
                boolean z = rawY <= 0.0f;
                if (z && !this.cwK.isFlipped() && ad(rawY)) {
                    this.cwK.eQ(true);
                    return true;
                } else if (!z && ash() && this.cwK.isFlipped() && ad(rawY)) {
                    this.cwK.eQ(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean ash() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean ad(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void eO(boolean z) {
        this.cwS = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void eP(boolean z) {
        this.cwS = true;
    }
}
