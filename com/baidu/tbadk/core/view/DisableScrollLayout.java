package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int axu;
    private double axv;
    private double axw;
    private boolean axx;

    public DisableScrollLayout(Context context) {
        super(context);
        this.axv = 0.0d;
        this.axw = 0.0d;
        this.axx = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.axv = 0.0d;
        this.axw = 0.0d;
        this.axx = true;
    }

    public void setHeaderViewHeight(int i) {
        this.axu = i;
    }

    public void bb(boolean z) {
        this.axx = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.axv = motionEvent.getX();
            this.axw = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.axu) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.axv) > Math.abs(y - this.axw) || (y > this.axw && !this.axx)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
