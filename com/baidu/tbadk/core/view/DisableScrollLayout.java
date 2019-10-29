package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bfc;
    private double cnW;
    private double cnX;
    private boolean cnY;

    public DisableScrollLayout(Context context) {
        super(context);
        this.cnW = 0.0d;
        this.cnX = 0.0d;
        this.cnY = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnW = 0.0d;
        this.cnX = 0.0d;
        this.cnY = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bfc = i;
    }

    public void es(boolean z) {
        this.cnY = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.cnW = motionEvent.getX();
            this.cnX = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bfc) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.cnW) > Math.abs(y - this.cnX) || (y > this.cnX && !this.cnY)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
