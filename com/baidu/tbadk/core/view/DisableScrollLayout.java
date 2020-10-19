package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dbv;
    private double eDV;
    private double eDW;
    private boolean eDX;

    public DisableScrollLayout(Context context) {
        super(context);
        this.eDV = 0.0d;
        this.eDW = 0.0d;
        this.eDX = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eDV = 0.0d;
        this.eDW = 0.0d;
        this.eDX = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dbv = i;
    }

    public void iP(boolean z) {
        this.eDX = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.eDV = motionEvent.getX();
            this.eDW = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dbv) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.eDV) > Math.abs(y - this.eDW) || (y > this.eDW && !this.eDX)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
