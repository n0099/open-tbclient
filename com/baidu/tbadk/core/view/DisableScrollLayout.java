package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int akp;
    private double akq;
    private double akr;
    private boolean aks;

    public DisableScrollLayout(Context context) {
        super(context);
        this.akq = 0.0d;
        this.akr = 0.0d;
        this.aks = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akq = 0.0d;
        this.akr = 0.0d;
        this.aks = true;
    }

    public void setHeaderViewHeight(int i) {
        this.akp = i;
    }

    public void aF(boolean z) {
        this.aks = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.akq = motionEvent.getX();
            this.akr = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.akp) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.akq) > Math.abs(y - this.akr) || (y > this.akr && !this.aks)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
