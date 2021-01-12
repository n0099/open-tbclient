package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dwJ;
    private double fdu;
    private double fdv;
    private boolean fdw;

    public DisableScrollLayout(Context context) {
        super(context);
        this.fdu = 0.0d;
        this.fdv = 0.0d;
        this.fdw = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdu = 0.0d;
        this.fdv = 0.0d;
        this.fdw = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dwJ = i;
    }

    public void jU(boolean z) {
        this.fdw = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.fdu = motionEvent.getX();
            this.fdv = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dwJ) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.fdu) > Math.abs(y - this.fdv) || (y > this.fdv && !this.fdw)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
