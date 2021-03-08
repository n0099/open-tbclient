package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dAp;
    private double fhi;
    private double fhj;
    private boolean fhk;

    public DisableScrollLayout(Context context) {
        super(context);
        this.fhi = 0.0d;
        this.fhj = 0.0d;
        this.fhk = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhi = 0.0d;
        this.fhj = 0.0d;
        this.fhk = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dAp = i;
    }

    public void jX(boolean z) {
        this.fhk = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.fhi = motionEvent.getX();
            this.fhj = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dAp) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.fhi) > Math.abs(y - this.fhj) || (y > this.fhj && !this.fhk)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
