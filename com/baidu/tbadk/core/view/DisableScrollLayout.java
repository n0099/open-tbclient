package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aGW;
    private double aGX;
    private boolean aGY;
    private int mHeaderViewHeight;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aGW = 0.0d;
        this.aGX = 0.0d;
        this.aGY = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGW = 0.0d;
        this.aGX = 0.0d;
        this.aGY = true;
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderViewHeight = i;
    }

    public void bD(boolean z) {
        this.aGY = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aGW = motionEvent.getX();
            this.aGX = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.mHeaderViewHeight) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aGW) > Math.abs(y - this.aGX) || (y > this.aGX && !this.aGY)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
