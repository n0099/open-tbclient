package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DisableScrollLayout extends FrameLayout {
    private int beJ;
    private double cne;
    private double cnf;
    private boolean cng;

    public DisableScrollLayout(Context context) {
        super(context);
        this.cne = 0.0d;
        this.cnf = 0.0d;
        this.cng = true;
    }

    public DisableScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cne = 0.0d;
        this.cnf = 0.0d;
        this.cng = true;
    }

    public void setHeaderViewHeight(int i) {
        this.beJ = i;
    }

    public void es(boolean z) {
        this.cng = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.cne = motionEvent.getX();
            this.cnf = motionEvent.getY();
        }
        if (motionEvent.getAction() == 2 && motionEvent.getY() <= this.beJ) {
            double y = motionEvent.getY();
            if (Math.abs(motionEvent.getX() - this.cne) > Math.abs(y - this.cnf) || (y > this.cnf && !this.cng)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
