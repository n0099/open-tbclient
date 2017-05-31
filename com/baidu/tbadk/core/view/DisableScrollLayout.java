package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int ahQ;
    private double ahR;
    private double ahS;
    private boolean ahT;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ahR = 0.0d;
        this.ahS = 0.0d;
        this.ahT = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahR = 0.0d;
        this.ahS = 0.0d;
        this.ahT = true;
    }

    public void setHeaderViewHeight(int i) {
        this.ahQ = i;
    }

    public void aI(boolean z) {
        this.ahT = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ahR = motionEvent.getX();
            this.ahS = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.ahQ) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ahR) > Math.abs(y - this.ahS) || (y > this.ahS && !this.ahT)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
