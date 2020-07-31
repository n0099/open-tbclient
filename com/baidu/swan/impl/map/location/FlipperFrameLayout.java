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
    private float VN;
    private h drE;
    private boolean drM;

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
        this.drE = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.drM || this.drE == null) {
            this.VN = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.VN = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.VN = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.VN;
                boolean z = rawY <= 0.0f;
                if (z && !this.drE.isFlipped() && O(rawY)) {
                    this.drE.gA(true);
                    return true;
                } else if (!z && aJk() && this.drE.isFlipped() && O(rawY)) {
                    this.drE.gA(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean aJk() {
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
    public void gy(boolean z) {
        this.drM = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void gz(boolean z) {
        this.drM = true;
    }
}
