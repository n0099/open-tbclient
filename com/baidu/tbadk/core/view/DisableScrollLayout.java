package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aLq;
    private double bYf;
    private double bYg;
    private boolean bYh;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bYf = 0.0d;
        this.bYg = 0.0d;
        this.bYh = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYf = 0.0d;
        this.bYg = 0.0d;
        this.bYh = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aLq = i;
    }

    public void em(boolean z) {
        this.bYh = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bYf = motionEvent.getX();
            this.bYg = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aLq) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bYf) > Math.abs(y - this.bYg) || (y > this.bYg && !this.bYh)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
