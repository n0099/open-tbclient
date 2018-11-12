package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aCT;
    private double aCU;
    private boolean aCV;
    private int mHeaderViewHeight;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aCT = 0.0d;
        this.aCU = 0.0d;
        this.aCV = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCT = 0.0d;
        this.aCU = 0.0d;
        this.aCV = true;
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderViewHeight = i;
    }

    public void bB(boolean z) {
        this.aCV = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aCT = motionEvent.getX();
            this.aCU = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.mHeaderViewHeight) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aCT) > Math.abs(y - this.aCU) || (y > this.aCU && !this.aCV)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
