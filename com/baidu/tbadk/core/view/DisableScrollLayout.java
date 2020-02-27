package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bMk;
    private double deD;
    private double deE;
    private boolean deF;

    public DisableScrollLayout(Context context) {
        super(context);
        this.deD = 0.0d;
        this.deE = 0.0d;
        this.deF = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deD = 0.0d;
        this.deE = 0.0d;
        this.deF = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bMk = i;
    }

    public void fP(boolean z) {
        this.deF = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.deD = motionEvent.getX();
            this.deE = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bMk) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.deD) > Math.abs(y - this.deE) || (y > this.deE && !this.deF)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
