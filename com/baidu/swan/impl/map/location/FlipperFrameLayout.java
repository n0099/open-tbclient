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
    private float NU;
    private h bnZ;
    private boolean boh;

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
        this.bnZ = hVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.boh || this.bnZ == null) {
            this.NU = motionEvent.getRawY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.NU = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                this.NU = motionEvent.getRawY();
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.NU;
                boolean z = rawY <= 0.0f;
                if (z && !this.bnZ.Uk() && al(rawY)) {
                    this.bnZ.da(true);
                    return true;
                } else if (!z && Ug() && this.bnZ.Uk() && al(rawY)) {
                    this.bnZ.da(false);
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean Ug() {
        if (getChildCount() <= 0) {
            return true;
        }
        View childAt = getChildAt(0);
        return ((childAt instanceof ScrollingView) && childAt.canScrollVertically(-1)) ? false : true;
    }

    private boolean al(float f) {
        return Math.abs(f) >= ((float) ViewConfiguration.getTouchSlop());
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void cX(boolean z) {
        this.boh = false;
    }

    @Override // com.baidu.swan.impl.map.location.h.a
    public void cY(boolean z) {
        this.boh = true;
    }
}
