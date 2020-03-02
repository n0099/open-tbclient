package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bMl;
    private double deE;
    private double deF;
    private boolean deG;

    public DisableScrollLayout(Context context) {
        super(context);
        this.deE = 0.0d;
        this.deF = 0.0d;
        this.deG = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deE = 0.0d;
        this.deF = 0.0d;
        this.deG = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bMl = i;
    }

    public void fP(boolean z) {
        this.deG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.deE = motionEvent.getX();
            this.deF = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bMl) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.deE) > Math.abs(y - this.deF) || (y > this.deF && !this.deG)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
