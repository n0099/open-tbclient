package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dpS;
    private double eSg;
    private double eSh;
    private boolean eSi;

    public DisableScrollLayout(Context context) {
        super(context);
        this.eSg = 0.0d;
        this.eSh = 0.0d;
        this.eSi = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSg = 0.0d;
        this.eSh = 0.0d;
        this.eSi = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dpS = i;
    }

    public void jl(boolean z) {
        this.eSi = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.eSg = motionEvent.getX();
            this.eSh = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dpS) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.eSg) > Math.abs(y - this.eSh) || (y > this.eSh && !this.eSi)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
