package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class DisableScrollLayout extends FrameLayout {
    private int cNm;
    private double epB;
    private double epC;
    private boolean epD;

    public DisableScrollLayout(Context context) {
        super(context);
        this.epB = 0.0d;
        this.epC = 0.0d;
        this.epD = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epB = 0.0d;
        this.epC = 0.0d;
        this.epD = true;
    }

    public void setHeaderViewHeight(int i) {
        this.cNm = i;
    }

    public void it(boolean z) {
        this.epD = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.epB = motionEvent.getX();
            this.epC = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.cNm) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.epB) > Math.abs(y - this.epC) || (y > this.epC && !this.epD)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
