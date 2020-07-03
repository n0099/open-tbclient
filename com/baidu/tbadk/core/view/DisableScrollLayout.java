package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cBB;
    private double dZJ;
    private double dZK;
    private boolean dZL;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dZJ = 0.0d;
        this.dZK = 0.0d;
        this.dZL = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZJ = 0.0d;
        this.dZK = 0.0d;
        this.dZL = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cBB = i;
    }

    public void hr(boolean z) {
        this.dZL = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dZJ = motionEvent.getX();
            this.dZK = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cBB) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dZJ) > Math.abs(y - this.dZK) || (y > this.dZK && !this.dZL)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
