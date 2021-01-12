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
    private View ffN;
    private View ffO;
    float ffP;
    private Rect ffQ;
    private boolean ffR;
    private a ffS;
    private boolean ffT;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.ffS = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.ffP = 0.0f;
        this.ffR = false;
        this.ffT = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ffS != null) {
            this.ffS.E(motionEvent);
        }
        if (this.ffN != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.ffP = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.ffR = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.ffR = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.ffR && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.ffP < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.ffN.isClickable()) {
                            this.ffN.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.ffP = this.ffP > Math.abs(this.startY - motionEvent.getRawY()) ? this.ffP : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.ffR && this.ffP < this.touchSlop) {
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
        if (this.ffT) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ffT = z;
    }

    public void setTopOrderView(View view) {
        this.ffN = view;
    }

    private boolean btI() {
        if (this.ffN == null) {
            return false;
        }
        if (this.ffQ == null) {
            return true;
        }
        return this.ffQ.width() <= 0 || this.ffQ.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (btI()) {
            int[] iArr = {0, 0};
            if (this.ffN != null) {
                this.ffN.getLocationOnScreen(iArr);
                this.ffQ = new Rect(iArr[0], iArr[1], iArr[0] + this.ffN.getWidth(), iArr[1] + this.ffN.getHeight());
            }
        }
        return this.ffQ;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.ffO != null) {
            this.ffO.setEnabled(z);
            this.ffO.setClickable(z);
            this.ffO.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.ffO = view;
    }
}
