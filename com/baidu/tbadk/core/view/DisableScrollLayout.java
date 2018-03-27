package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int baf;
    private double bag;
    private double bah;
    private boolean bai;

    public DisableScrollLayout(Context context) {
        super(context);
        this.bag = 0.0d;
        this.bah = 0.0d;
        this.bai = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bag = 0.0d;
        this.bah = 0.0d;
        this.bai = true;
    }

    public void setHeaderViewHeight(int i) {
        this.baf = i;
    }

    public void bs(boolean z) {
        this.bai = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.bag = motionEvent.getX();
            this.bah = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.baf) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.bag) > Math.abs(y - this.bah) || (y > this.bah && !this.bai)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
