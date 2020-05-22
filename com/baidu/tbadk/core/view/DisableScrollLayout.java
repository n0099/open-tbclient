package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cwR;
    private double dSR;
    private double dSS;
    private boolean dST;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dSR = 0.0d;
        this.dSS = 0.0d;
        this.dST = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSR = 0.0d;
        this.dSS = 0.0d;
        this.dST = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cwR = i;
    }

    public void hi(boolean z) {
        this.dST = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dSR = motionEvent.getX();
            this.dSS = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cwR) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dSR) > Math.abs(y - this.dSS) || (y > this.dSS && !this.dST)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
