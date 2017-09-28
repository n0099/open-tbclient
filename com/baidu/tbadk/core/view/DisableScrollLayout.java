package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int ajJ;
    private double ajK;
    private double ajL;
    private boolean ajM;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ajK = 0.0d;
        this.ajL = 0.0d;
        this.ajM = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajK = 0.0d;
        this.ajL = 0.0d;
        this.ajM = true;
    }

    public void setHeaderViewHeight(int i) {
        this.ajJ = i;
    }

    public void aI(boolean z) {
        this.ajM = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ajK = motionEvent.getX();
            this.ajL = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.ajJ) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ajK) > Math.abs(y - this.ajL) || (y > this.ajL && !this.ajM)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
