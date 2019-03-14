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
    int OW;
    private View bQX;
    private View bQY;
    float bQZ;
    private Rect bRa;
    private boolean bRb;
    private a bRc;
    private boolean bRd;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bRc = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.OW = 0;
        this.bQZ = 0.0f;
        this.bRb = false;
        this.bRd = false;
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bRc != null) {
            this.bRc.u(motionEvent);
        }
        if (this.bQX != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bQZ = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bRb = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bRb = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bRb && Math.abs(this.startY - motionEvent.getRawY()) < this.OW && this.bQZ < this.OW && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bQX.isClickable()) {
                            this.bQX.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bQZ = this.bQZ > Math.abs(this.startY - motionEvent.getRawY()) ? this.bQZ : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bRb && this.bQZ < this.OW) {
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
        if (this.bRd) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bRd = z;
    }

    public void setTopOrderView(View view) {
        this.bQX = view;
    }

    private boolean aex() {
        if (this.bQX == null) {
            return false;
        }
        if (this.bRa == null) {
            return true;
        }
        return this.bRa.width() <= 0 || this.bRa.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aex()) {
            int[] iArr = {0, 0};
            if (this.bQX != null) {
                this.bQX.getLocationOnScreen(iArr);
                this.bRa = new Rect(iArr[0], iArr[1], iArr[0] + this.bQX.getWidth(), iArr[1] + this.bQX.getHeight());
            }
        }
        return this.bRa;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bQY != null) {
            this.bQY.setEnabled(z);
            this.bQY.setClickable(z);
            this.bQY.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bQY = view;
    }
}
