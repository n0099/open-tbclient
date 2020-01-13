package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bIf;
    private boolean daA;
    private double dax;
    private double daz;

    public DisableScrollLayout(Context context) {
        super(context);
        this.dax = 0.0d;
        this.daz = 0.0d;
        this.daA = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dax = 0.0d;
        this.daz = 0.0d;
        this.daA = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bIf = i;
    }

    public void fI(boolean z) {
        this.daA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.dax = motionEvent.getX();
            this.daz = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bIf) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.dax) > Math.abs(y - this.daz) || (y > this.daz && !this.daA)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
