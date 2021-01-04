package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int dBv;
    private double fic;
    private double fie;
    private boolean fif;

    public DisableScrollLayout(Context context) {
        super(context);
        this.fic = 0.0d;
        this.fie = 0.0d;
        this.fif = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fic = 0.0d;
        this.fie = 0.0d;
        this.fif = true;
    }

    public void setHeaderViewHeight(int i) {
        this.dBv = i;
    }

    public void jY(boolean z) {
        this.fif = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.fic = motionEvent.getX();
            this.fie = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.dBv) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.fic) > Math.abs(y - this.fie) || (y > this.fie && !this.fif)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
