package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int djX;
    private double eMr;
    private double eMs;
    private boolean eMt;

    public DisableScrollLayout(Context context) {
        super(context);
        this.eMr = 0.0d;
        this.eMs = 0.0d;
        this.eMt = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eMr = 0.0d;
        this.eMs = 0.0d;
        this.eMt = true;
    }

    public void setHeaderViewHeight(int i) {
        this.djX = i;
    }

    public void jc(boolean z) {
        this.eMt = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.eMr = motionEvent.getX();
            this.eMs = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.djX) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.eMr) > Math.abs(y - this.eMs) || (y > this.eMs && !this.eMt)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
