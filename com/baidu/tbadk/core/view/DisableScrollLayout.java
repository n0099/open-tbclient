package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aiU;
    private double aiV;
    private double aiW;
    private boolean aiX;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aiV = 0.0d;
        this.aiW = 0.0d;
        this.aiX = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiV = 0.0d;
        this.aiW = 0.0d;
        this.aiX = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aiU = i;
    }

    public void aI(boolean z) {
        this.aiX = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aiV = motionEvent.getX();
            this.aiW = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aiU) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aiV) > Math.abs(y - this.aiW) || (y > this.aiW && !this.aiX)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
