package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aYF;
    private double aYG;
    private double aYH;
    private boolean aYI;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aYG = 0.0d;
        this.aYH = 0.0d;
        this.aYI = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aYG = 0.0d;
        this.aYH = 0.0d;
        this.aYI = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aYF = i;
    }

    public void bo(boolean z) {
        this.aYI = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aYG = motionEvent.getX();
            this.aYH = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aYF) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aYG) > Math.abs(y - this.aYH) || (y > this.aYH && !this.aYI)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
