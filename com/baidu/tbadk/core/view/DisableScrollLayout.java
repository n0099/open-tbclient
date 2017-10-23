package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private boolean ajA;
    private int ajx;
    private double ajy;
    private double ajz;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ajy = 0.0d;
        this.ajz = 0.0d;
        this.ajA = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajy = 0.0d;
        this.ajz = 0.0d;
        this.ajA = true;
    }

    public void setHeaderViewHeight(int i) {
        this.ajx = i;
    }

    public void aH(boolean z) {
        this.ajA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ajy = motionEvent.getX();
            this.ajz = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.ajx) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ajy) > Math.abs(y - this.ajz) || (y > this.ajz && !this.ajA)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
