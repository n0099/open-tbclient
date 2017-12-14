package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int akm;
    private double akn;
    private double ako;
    private boolean akp;

    public DisableScrollLayout(Context context) {
        super(context);
        this.akn = 0.0d;
        this.ako = 0.0d;
        this.akp = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = 0.0d;
        this.ako = 0.0d;
        this.akp = true;
    }

    public void setHeaderViewHeight(int i) {
        this.akm = i;
    }

    public void aF(boolean z) {
        this.akp = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.akn = motionEvent.getX();
            this.ako = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.akm) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.akn) > Math.abs(y - this.ako) || (y > this.ako && !this.akp)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
