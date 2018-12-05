package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aGt;
    private double aGu;
    private boolean aGv;
    private int mHeaderViewHeight;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aGt = 0.0d;
        this.aGu = 0.0d;
        this.aGv = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGt = 0.0d;
        this.aGu = 0.0d;
        this.aGv = true;
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderViewHeight = i;
    }

    public void bC(boolean z) {
        this.aGv = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aGt = motionEvent.getX();
            this.aGu = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.mHeaderViewHeight) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aGt) > Math.abs(y - this.aGu) || (y > this.aGu && !this.aGv)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
