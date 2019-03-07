package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aIK;
    private double bPe;
    private double bPf;
    private boolean bPg;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bPe = 0.0d;
        this.bPf = 0.0d;
        this.bPg = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPe = 0.0d;
        this.bPf = 0.0d;
        this.bPg = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aIK = i;
    }

    public void dM(boolean z) {
        this.bPg = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bPe = motionEvent.getX();
            this.bPf = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aIK) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bPe) > Math.abs(y - this.bPf) || (y > this.bPf && !this.bPg)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
