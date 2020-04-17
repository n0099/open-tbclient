package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int clh;
    private double dEB;
    private double dEC;
    private boolean dED;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dEB = 0.0d;
        this.dEC = 0.0d;
        this.dED = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dEB = 0.0d;
        this.dEC = 0.0d;
        this.dED = true;
    }

    public void setHeaderViewHeight(int i) {
        this.clh = i;
    }

    public void gO(boolean z) {
        this.dED = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dEB = motionEvent.getX();
            this.dEC = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.clh) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dEB) > Math.abs(y - this.dEC) || (y > this.dEC && !this.dED)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
