package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bad;
    private double bae;
    private double baf;
    private boolean bag;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bae = 0.0d;
        this.baf = 0.0d;
        this.bag = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bae = 0.0d;
        this.baf = 0.0d;
        this.bag = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bad = i;
    }

    public void bs(boolean z) {
        this.bag = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bae = motionEvent.getX();
            this.baf = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bad) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bae) > Math.abs(y - this.baf) || (y > this.baf && !this.bag)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
