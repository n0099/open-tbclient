package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aCe;
    private double aCf;
    private boolean aCg;
    private int mHeaderViewHeight;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aCe = 0.0d;
        this.aCf = 0.0d;
        this.aCg = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCe = 0.0d;
        this.aCf = 0.0d;
        this.aCg = true;
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderViewHeight = i;
    }

    public void bl(boolean z) {
        this.aCg = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aCe = motionEvent.getX();
            this.aCf = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.mHeaderViewHeight) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aCe) > Math.abs(y - this.aCf) || (y > this.aCf && !this.aCg)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
