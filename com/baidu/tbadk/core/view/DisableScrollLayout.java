package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private double aiA;
    private boolean aiB;
    private int aiy;
    private double aiz;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aiz = 0.0d;
        this.aiA = 0.0d;
        this.aiB = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiz = 0.0d;
        this.aiA = 0.0d;
        this.aiB = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aiy = i;
    }

    public void aJ(boolean z) {
        this.aiB = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aiz = motionEvent.getX();
            this.aiA = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aiy) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aiz) > Math.abs(y - this.aiA) || (y > this.aiA && !this.aiB)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
