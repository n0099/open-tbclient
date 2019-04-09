package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aIP;
    private double bPi;
    private double bPj;
    private boolean bPk;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bPi = 0.0d;
        this.bPj = 0.0d;
        this.bPk = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bPi = 0.0d;
        this.bPj = 0.0d;
        this.bPk = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aIP = i;
    }

    public void dM(boolean z) {
        this.bPk = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bPi = motionEvent.getX();
            this.bPj = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aIP) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bPi) > Math.abs(y - this.bPj) || (y > this.bPj && !this.bPk)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
