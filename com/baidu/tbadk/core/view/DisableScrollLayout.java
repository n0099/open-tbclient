package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aIL;
    private double bPf;
    private double bPg;
    private boolean bPh;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bPf = 0.0d;
        this.bPg = 0.0d;
        this.bPh = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPf = 0.0d;
        this.bPg = 0.0d;
        this.bPh = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aIL = i;
    }

    public void dM(boolean z) {
        this.bPh = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bPf = motionEvent.getX();
            this.bPg = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aIL) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bPf) > Math.abs(y - this.bPg) || (y > this.bPg && !this.bPh)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
