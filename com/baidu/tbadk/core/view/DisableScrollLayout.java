package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aKI;
    private double bWX;
    private double bWY;
    private boolean bWZ;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bWX = 0.0d;
        this.bWY = 0.0d;
        this.bWZ = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bWX = 0.0d;
        this.bWY = 0.0d;
        this.bWZ = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aKI = i;
    }

    public void ei(boolean z) {
        this.bWZ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bWX = motionEvent.getX();
            this.bWY = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aKI) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bWX) > Math.abs(y - this.bWY) || (y > this.bWY && !this.bWZ)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
