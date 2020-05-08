package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cln;
    private double dEF;
    private double dEG;
    private boolean dEH;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dEF = 0.0d;
        this.dEG = 0.0d;
        this.dEH = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEF = 0.0d;
        this.dEG = 0.0d;
        this.dEH = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cln = i;
    }

    public void gO(boolean z) {
        this.dEH = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dEF = motionEvent.getX();
            this.dEG = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cln) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dEF) > Math.abs(y - this.dEG) || (y > this.dEG && !this.dEH)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
