package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cNq;
    private double epF;
    private double epG;
    private boolean epH;

    public DisableScrollLayout(Context context) {
        super(context);
        this.epF = 0.0d;
        this.epG = 0.0d;
        this.epH = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epF = 0.0d;
        this.epG = 0.0d;
        this.epH = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cNq = i;
    }

    public void iu(boolean z) {
        this.epH = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.epF = motionEvent.getX();
            this.epG = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cNq) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.epF) > Math.abs(y - this.epG) || (y > this.epG && !this.epH)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
