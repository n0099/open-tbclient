package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    int MD;
    private View bYR;
    private View bYS;
    float bYT;
    private Rect bYU;
    private boolean bYV;
    private a bYW;
    private boolean bYX;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bYW = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.MD = 0;
        this.bYT = 0.0f;
        this.bYV = false;
        this.bYX = false;
        this.MD = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bYW != null) {
            this.bYW.u(motionEvent);
        }
        if (this.bYR != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bYT = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bYV = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bYV = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bYV && Math.abs(this.startY - motionEvent.getRawY()) < this.MD && this.bYT < this.MD && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bYR.isClickable()) {
                            this.bYR.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bYT = this.bYT > Math.abs(this.startY - motionEvent.getRawY()) ? this.bYT : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bYV && this.bYT < this.MD) {
                        setBottomViewClickEventEnabled(false);
                    } else {
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.bYX) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bYX = z;
    }

    public void setTopOrderView(View view) {
        this.bYR = view;
    }

    private boolean ajt() {
        if (this.bYR == null) {
            return false;
        }
        if (this.bYU == null) {
            return true;
        }
        return this.bYU.width() <= 0 || this.bYU.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (ajt()) {
            int[] iArr = {0, 0};
            if (this.bYR != null) {
                this.bYR.getLocationOnScreen(iArr);
                this.bYU = new Rect(iArr[0], iArr[1], iArr[0] + this.bYR.getWidth(), iArr[1] + this.bYR.getHeight());
            }
        }
        return this.bYU;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bYS != null) {
            this.bYS.setEnabled(z);
            this.bYS.setClickable(z);
            this.bYS.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bYS = view;
    }
}
