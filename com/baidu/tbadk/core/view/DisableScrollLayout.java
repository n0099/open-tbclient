package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aKI;
    private double bWW;
    private double bWX;
    private boolean bWY;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bWW = 0.0d;
        this.bWX = 0.0d;
        this.bWY = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWW = 0.0d;
        this.bWX = 0.0d;
        this.bWY = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aKI = i;
    }

    public void ei(boolean z) {
        this.bWY = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bWW = motionEvent.getX();
            this.bWX = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aKI) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bWW) > Math.abs(y - this.bWX) || (y > this.bWX && !this.bWY)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
