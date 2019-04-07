package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aIO;
    private double bPh;
    private double bPi;
    private boolean bPj;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bPh = 0.0d;
        this.bPi = 0.0d;
        this.bPj = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPh = 0.0d;
        this.bPi = 0.0d;
        this.bPj = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aIO = i;
    }

    public void dM(boolean z) {
        this.bPj = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bPh = motionEvent.getX();
            this.bPi = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aIO) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bPh) > Math.abs(y - this.bPi) || (y > this.bPi && !this.bPj)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
