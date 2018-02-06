package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int bap;
    private double baq;
    private double bas;
    private boolean bat;

    public DisableScrollLayout(Context context) {
        super(context);
        this.baq = 0.0d;
        this.bas = 0.0d;
        this.bat = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baq = 0.0d;
        this.bas = 0.0d;
        this.bat = true;
    }

    public void setHeaderViewHeight(int i) {
        this.bap = i;
    }

    public void bs(boolean z) {
        this.bat = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.baq = motionEvent.getX();
            this.bas = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.bap) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.baq) > Math.abs(y - this.bas) || (y > this.bas && !this.bat)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
