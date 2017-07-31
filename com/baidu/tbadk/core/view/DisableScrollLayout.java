package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int akn;
    private double ako;
    private double akp;
    private boolean akq;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ako = 0.0d;
        this.akp = 0.0d;
        this.akq = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ako = 0.0d;
        this.akp = 0.0d;
        this.akq = true;
    }

    public void setHeaderViewHeight(int i) {
        this.akn = i;
    }

    public void aI(boolean z) {
        this.akq = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ako = motionEvent.getX();
            this.akp = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.akn) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ako) > Math.abs(y - this.akp) || (y > this.akp && !this.akq)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
