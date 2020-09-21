package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cPq;
    private double erK;
    private double erL;
    private boolean erM;

    public DisableScrollLayout(Context context) {
        super(context);
        this.erK = 0.0d;
        this.erL = 0.0d;
        this.erM = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erK = 0.0d;
        this.erL = 0.0d;
        this.erM = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cPq = i;
    }

    public void ir(boolean z) {
        this.erM = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.erK = motionEvent.getX();
            this.erL = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cPq) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.erK) > Math.abs(y - this.erL) || (y > this.erL && !this.erM)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
