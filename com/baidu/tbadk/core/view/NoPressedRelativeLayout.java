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
    private View bRa;
    private View bRb;
    float bRc;
    private Rect bRd;
    private boolean bRe;
    private a bRf;
    private boolean bRg;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bRf = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.OW = 0;
        this.bRc = 0.0f;
        this.bRe = false;
        this.bRg = false;
        this.OW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bRf != null) {
            this.bRf.u(motionEvent);
        }
        if (this.bRa != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bRc = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bRe = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bRe = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bRe && Math.abs(this.startY - motionEvent.getRawY()) < this.OW && this.bRc < this.OW && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bRa.isClickable()) {
                            this.bRa.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bRc = this.bRc > Math.abs(this.startY - motionEvent.getRawY()) ? this.bRc : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bRe && this.bRc < this.OW) {
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
        if (this.bRg) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bRg = z;
    }

    public void setTopOrderView(View view) {
        this.bRa = view;
    }

    private boolean aeu() {
        if (this.bRa == null) {
            return false;
        }
        if (this.bRd == null) {
            return true;
        }
        return this.bRd.width() <= 0 || this.bRd.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aeu()) {
            int[] iArr = {0, 0};
            if (this.bRa != null) {
                this.bRa.getLocationOnScreen(iArr);
                this.bRd = new Rect(iArr[0], iArr[1], iArr[0] + this.bRa.getWidth(), iArr[1] + this.bRa.getHeight());
            }
        }
        return this.bRd;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bRb != null) {
            this.bRb.setEnabled(z);
            this.bRb.setClickable(z);
            this.bRb.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bRb = view;
    }
}
