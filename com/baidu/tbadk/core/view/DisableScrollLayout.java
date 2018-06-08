package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int atQ;
    private double atR;
    private double atS;
    private boolean atT;

    public DisableScrollLayout(Context context) {
        super(context);
        this.atR = 0.0d;
        this.atS = 0.0d;
        this.atT = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.atR = 0.0d;
        this.atS = 0.0d;
        this.atT = true;
    }

    public void setHeaderViewHeight(int i) {
        this.atQ = i;
    }

    public void aO(boolean z) {
        this.atT = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.atR = motionEvent.getX();
            this.atS = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.atQ) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.atR) > Math.abs(y - this.atS) || (y > this.atS && !this.atT)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
