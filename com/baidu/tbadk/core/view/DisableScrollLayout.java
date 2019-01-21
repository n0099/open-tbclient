package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aGX;
    private double aGY;
    private boolean aGZ;
    private int mHeaderViewHeight;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aGX = 0.0d;
        this.aGY = 0.0d;
        this.aGZ = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGX = 0.0d;
        this.aGY = 0.0d;
        this.aGZ = true;
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderViewHeight = i;
    }

    public void bD(boolean z) {
        this.aGZ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aGX = motionEvent.getX();
            this.aGY = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.mHeaderViewHeight) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aGX) > Math.abs(y - this.aGY) || (y > this.aGY && !this.aGZ)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
