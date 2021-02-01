package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dyO;
    private double ffJ;
    private double ffK;
    private boolean ffL;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ffJ = 0.0d;
        this.ffK = 0.0d;
        this.ffL = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffJ = 0.0d;
        this.ffK = 0.0d;
        this.ffL = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dyO = i;
    }

    public void jX(boolean z) {
        this.ffL = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ffJ = motionEvent.getX();
            this.ffK = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dyO) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ffJ) > Math.abs(y - this.ffK) || (y > this.ffK && !this.ffL)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
