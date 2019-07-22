package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aLq;
    private double bXZ;
    private double bYa;
    private boolean bYb;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bXZ = 0.0d;
        this.bYa = 0.0d;
        this.bYb = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXZ = 0.0d;
        this.bYa = 0.0d;
        this.bYb = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aLq = i;
    }

    public void em(boolean z) {
        this.bYb = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bXZ = motionEvent.getX();
            this.bYa = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aLq) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bXZ) > Math.abs(y - this.bYa) || (y > this.bYa && !this.bYb)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
