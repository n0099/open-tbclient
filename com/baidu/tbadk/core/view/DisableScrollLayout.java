package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dok;
    private double eRi;
    private double eRj;
    private boolean eRk;

    public DisableScrollLayout(Context context) {
        super(context);
        this.eRi = 0.0d;
        this.eRj = 0.0d;
        this.eRk = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eRi = 0.0d;
        this.eRj = 0.0d;
        this.eRk = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dok = i;
    }

    public void jm(boolean z) {
        this.eRk = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.eRi = motionEvent.getX();
            this.eRj = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dok) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.eRi) > Math.abs(y - this.eRj) || (y > this.eRj && !this.eRk)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
