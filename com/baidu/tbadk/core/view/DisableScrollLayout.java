package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bMx;
    private double dfe;
    private double dff;
    private boolean dfg;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dfe = 0.0d;
        this.dff = 0.0d;
        this.dfg = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfe = 0.0d;
        this.dff = 0.0d;
        this.dfg = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bMx = i;
    }

    public void fQ(boolean z) {
        this.dfg = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dfe = motionEvent.getX();
            this.dff = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bMx) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dfe) > Math.abs(y - this.dff) || (y > this.dff && !this.dfg)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
