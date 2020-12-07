package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dvm;
    private double eYB;
    private double eYC;
    private boolean eYD;

    public DisableScrollLayout(Context context) {
        super(context);
        this.eYB = 0.0d;
        this.eYC = 0.0d;
        this.eYD = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYB = 0.0d;
        this.eYC = 0.0d;
        this.eYD = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dvm = i;
    }

    public void jC(boolean z) {
        this.eYD = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.eYB = motionEvent.getX();
            this.eYC = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dvm) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.eYB) > Math.abs(y - this.eYC) || (y > this.eYC && !this.eYD)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
