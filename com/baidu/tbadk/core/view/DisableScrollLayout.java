package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int aui;
    private double auj;
    private double auk;
    private boolean aul;

    public DisableScrollLayout(Context context) {
        super(context);
        this.auj = 0.0d;
        this.auk = 0.0d;
        this.aul = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auj = 0.0d;
        this.auk = 0.0d;
        this.aul = true;
    }

    public void setHeaderViewHeight(int i) {
        this.aui = i;
    }

    public void aP(boolean z) {
        this.aul = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.auj = motionEvent.getX();
            this.auk = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.aui) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.auj) > Math.abs(y - this.auk) || (y > this.auk && !this.aul)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
