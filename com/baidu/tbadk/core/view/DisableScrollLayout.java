package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int ajI;
    private double ajJ;
    private double ajK;
    private boolean ajL;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ajJ = 0.0d;
        this.ajK = 0.0d;
        this.ajL = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajJ = 0.0d;
        this.ajK = 0.0d;
        this.ajL = true;
    }

    public void setHeaderViewHeight(int i) {
        this.ajI = i;
    }

    public void aI(boolean z) {
        this.ajL = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ajJ = motionEvent.getX();
            this.ajK = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.ajI) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ajJ) > Math.abs(y - this.ajK) || (y > this.ajK && !this.ajL)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
