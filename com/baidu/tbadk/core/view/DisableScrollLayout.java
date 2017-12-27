package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aYA;
    private boolean aYB;
    private int aYy;
    private double aYz;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aYz = 0.0d;
        this.aYA = 0.0d;
        this.aYB = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYz = 0.0d;
        this.aYA = 0.0d;
        this.aYB = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aYy = i;
    }

    public void bn(boolean z) {
        this.aYB = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aYz = motionEvent.getX();
            this.aYA = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aYy) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aYz) > Math.abs(y - this.aYA) || (y > this.aYA && !this.aYB)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
