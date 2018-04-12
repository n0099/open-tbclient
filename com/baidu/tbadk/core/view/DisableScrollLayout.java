package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int alJ;
    private double alK;
    private double alL;
    private boolean alM;

    public DisableScrollLayout(Context context) {
        super(context);
        this.alK = 0.0d;
        this.alL = 0.0d;
        this.alM = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alK = 0.0d;
        this.alL = 0.0d;
        this.alM = true;
    }

    public void setHeaderViewHeight(int i) {
        this.alJ = i;
    }

    public void aK(boolean z) {
        this.alM = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.alK = motionEvent.getX();
            this.alL = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.alJ) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.alK) > Math.abs(y - this.alL) || (y > this.alL && !this.alM)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
