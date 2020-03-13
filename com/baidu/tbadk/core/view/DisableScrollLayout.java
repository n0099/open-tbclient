package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bMm;
    private double deR;
    private double deS;
    private boolean deT;

    public DisableScrollLayout(Context context) {
        super(context);
        this.deR = 0.0d;
        this.deS = 0.0d;
        this.deT = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deR = 0.0d;
        this.deS = 0.0d;
        this.deT = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bMm = i;
    }

    public void fP(boolean z) {
        this.deT = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.deR = motionEvent.getX();
            this.deS = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bMm) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.deR) > Math.abs(y - this.deS) || (y > this.deS && !this.deT)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
