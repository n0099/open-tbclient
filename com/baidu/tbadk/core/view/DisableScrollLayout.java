package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int auh;
    private double aui;
    private double auj;
    private boolean auk;

    public DisableScrollLayout(Context context) {
        super(context);
        this.aui = 0.0d;
        this.auj = 0.0d;
        this.auk = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aui = 0.0d;
        this.auj = 0.0d;
        this.auk = true;
    }

    public void setHeaderViewHeight(int i) {
        this.auh = i;
    }

    public void aO(boolean z) {
        this.auk = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.aui = motionEvent.getX();
            this.auj = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.auh) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.aui) > Math.abs(y - this.auj) || (y > this.auj && !this.auk)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
