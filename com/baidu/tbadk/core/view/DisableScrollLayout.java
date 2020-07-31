package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cEo;
    private double efU;
    private double efV;
    private boolean efW;

    public DisableScrollLayout(Context context) {
        super(context);
        this.efU = 0.0d;
        this.efV = 0.0d;
        this.efW = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efU = 0.0d;
        this.efV = 0.0d;
        this.efW = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cEo = i;
    }

    public void hW(boolean z) {
        this.efW = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.efU = motionEvent.getX();
            this.efV = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cEo) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.efU) > Math.abs(y - this.efV) || (y > this.efV && !this.efW)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
