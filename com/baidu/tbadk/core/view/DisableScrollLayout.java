package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private boolean aYA;
    private int aYx;
    private double aYy;
    private double aYz;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aYy = 0.0d;
        this.aYz = 0.0d;
        this.aYA = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYy = 0.0d;
        this.aYz = 0.0d;
        this.aYA = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aYx = i;
    }

    public void bn(boolean z) {
        this.aYA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aYy = motionEvent.getX();
            this.aYz = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aYx) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aYy) > Math.abs(y - this.aYz) || (y > this.aYz && !this.aYA)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
