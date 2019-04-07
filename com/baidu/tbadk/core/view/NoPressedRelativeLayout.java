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
    private View bQZ;
    private View bRa;
    float bRb;
    private Rect bRc;
    private boolean bRd;
    private a bRe;
    private boolean bRf;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bRe = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.OW = 0;
        this.bRb = 0.0f;
        this.bRd = false;
        this.bRf = false;
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bRe != null) {
            this.bRe.u(motionEvent);
        }
        if (this.bQZ != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bRb = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bRd = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bRd = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bRd && Math.abs(this.startY - motionEvent.getRawY()) < this.OW && this.bRb < this.OW && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bQZ.isClickable()) {
                            this.bQZ.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bRb = this.bRb > Math.abs(this.startY - motionEvent.getRawY()) ? this.bRb : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bRd && this.bRb < this.OW) {
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
        if (this.bRf) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bRf = z;
    }

    public void setTopOrderView(View view) {
        this.bQZ = view;
    }

    private boolean aeu() {
        if (this.bQZ == null) {
            return false;
        }
        if (this.bRc == null) {
            return true;
        }
        return this.bRc.width() <= 0 || this.bRc.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aeu()) {
            int[] iArr = {0, 0};
            if (this.bQZ != null) {
                this.bQZ.getLocationOnScreen(iArr);
                this.bRc = new Rect(iArr[0], iArr[1], iArr[0] + this.bQZ.getWidth(), iArr[1] + this.bQZ.getHeight());
            }
        }
        return this.bRc;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bRa != null) {
            this.bRa.setEnabled(z);
            this.bRa.setClickable(z);
            this.bRa.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bRa = view;
    }
}
