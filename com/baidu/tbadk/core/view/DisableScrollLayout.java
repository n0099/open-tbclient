package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int auC;
    private double auD;
    private double auE;
    private boolean auF;

    public DisableScrollLayout(Context context) {
        super(context);
        this.auD = 0.0d;
        this.auE = 0.0d;
        this.auF = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auD = 0.0d;
        this.auE = 0.0d;
        this.auF = true;
    }

    public void setHeaderViewHeight(int i) {
        this.auC = i;
    }

    public void aQ(boolean z) {
        this.auF = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.auD = motionEvent.getX();
            this.auE = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.auC) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.auD) > Math.abs(y - this.auE) || (y > this.auE && !this.auF)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
