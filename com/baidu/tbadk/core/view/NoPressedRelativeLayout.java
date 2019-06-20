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
    int MC;
    private View bYS;
    private View bYT;
    float bYU;
    private Rect bYV;
    private boolean bYW;
    private a bYX;
    private boolean bYY;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bYX = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.MC = 0;
        this.bYU = 0.0f;
        this.bYW = false;
        this.bYY = false;
        this.MC = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bYX != null) {
            this.bYX.u(motionEvent);
        }
        if (this.bYS != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bYU = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bYW = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bYW = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bYW && Math.abs(this.startY - motionEvent.getRawY()) < this.MC && this.bYU < this.MC && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bYS.isClickable()) {
                            this.bYS.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bYU = this.bYU > Math.abs(this.startY - motionEvent.getRawY()) ? this.bYU : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bYW && this.bYU < this.MC) {
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
        if (this.bYY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bYY = z;
    }

    public void setTopOrderView(View view) {
        this.bYS = view;
    }

    private boolean ajt() {
        if (this.bYS == null) {
            return false;
        }
        if (this.bYV == null) {
            return true;
        }
        return this.bYV.width() <= 0 || this.bYV.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (ajt()) {
            int[] iArr = {0, 0};
            if (this.bYS != null) {
                this.bYS.getLocationOnScreen(iArr);
                this.bYV = new Rect(iArr[0], iArr[1], iArr[0] + this.bYS.getWidth(), iArr[1] + this.bYS.getHeight());
            }
        }
        return this.bYV;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bYT != null) {
            this.bYT.setEnabled(z);
            this.bYT.setClickable(z);
            this.bYT.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bYT = view;
    }
}
