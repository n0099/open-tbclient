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
    int OV;
    private View bQW;
    private View bQX;
    float bQY;
    private Rect bQZ;
    private boolean bRa;
    private a bRb;
    private boolean bRc;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bRb = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.OV = 0;
        this.bQY = 0.0f;
        this.bRa = false;
        this.bRc = false;
        this.OV = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bRb != null) {
            this.bRb.u(motionEvent);
        }
        if (this.bQW != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bQY = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bRa = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bRa = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bRa && Math.abs(this.startY - motionEvent.getRawY()) < this.OV && this.bQY < this.OV && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bQW.isClickable()) {
                            this.bQW.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bQY = this.bQY > Math.abs(this.startY - motionEvent.getRawY()) ? this.bQY : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bRa && this.bQY < this.OV) {
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
        if (this.bRc) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bRc = z;
    }

    public void setTopOrderView(View view) {
        this.bQW = view;
    }

    private boolean aex() {
        if (this.bQW == null) {
            return false;
        }
        if (this.bQZ == null) {
            return true;
        }
        return this.bQZ.width() <= 0 || this.bQZ.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aex()) {
            int[] iArr = {0, 0};
            if (this.bQW != null) {
                this.bQW.getLocationOnScreen(iArr);
                this.bQZ = new Rect(iArr[0], iArr[1], iArr[0] + this.bQW.getWidth(), iArr[1] + this.bQW.getHeight());
            }
        }
        return this.bQZ;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bQX != null) {
            this.bQX.setEnabled(z);
            this.bQX.setClickable(z);
            this.bQX.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bQX = view;
    }
}
