package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aLO;
    private double bYY;
    private double bYZ;
    private boolean bZa;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bYY = 0.0d;
        this.bYZ = 0.0d;
        this.bZa = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYY = 0.0d;
        this.bYZ = 0.0d;
        this.bZa = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aLO = i;
    }

    public void ep(boolean z) {
        this.bZa = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bYY = motionEvent.getX();
            this.bYZ = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aLO) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bYY) > Math.abs(y - this.bYZ) || (y > this.bYZ && !this.bZa)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
