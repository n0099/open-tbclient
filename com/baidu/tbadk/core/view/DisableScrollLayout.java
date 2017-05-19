package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aif;
    private double aig;
    private double aih;
    private boolean aii;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aig = 0.0d;
        this.aih = 0.0d;
        this.aii = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aig = 0.0d;
        this.aih = 0.0d;
        this.aii = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aif = i;
    }

    public void aJ(boolean z) {
        this.aii = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aig = motionEvent.getX();
            this.aih = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aif) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aig) > Math.abs(y - this.aih) || (y > this.aih && !this.aii)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
