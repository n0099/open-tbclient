package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int ajT;
    private double ajU;
    private double ajV;
    private boolean ajW;

    public DisableScrollLayout(Context context) {
        super(context);
        this.ajU = 0.0d;
        this.ajV = 0.0d;
        this.ajW = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajU = 0.0d;
        this.ajV = 0.0d;
        this.ajW = true;
    }

    public void setHeaderViewHeight(int i) {
        this.ajT = i;
    }

    public void aF(boolean z) {
        this.ajW = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ajU = motionEvent.getX();
            this.ajV = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.ajT) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.ajU) > Math.abs(y - this.ajV) || (y > this.ajV && !this.ajW)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
