package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bHv;
    private double dan;
    private double dao;
    private boolean dap;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dan = 0.0d;
        this.dao = 0.0d;
        this.dap = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dan = 0.0d;
        this.dao = 0.0d;
        this.dap = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bHv = i;
    }

    public void fD(boolean z) {
        this.dap = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dan = motionEvent.getX();
            this.dao = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bHv) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dan) > Math.abs(y - this.dao) || (y > this.dao && !this.dap)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
