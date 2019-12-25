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
    private View dbR;
    private View dbS;
    float dbT;
    private Rect dbU;
    private boolean dbV;
    private a dbW;
    private boolean dbX;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dbW = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dbT = 0.0f;
        this.dbV = false;
        this.dbX = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dbW != null) {
            this.dbW.q(motionEvent);
        }
        if (this.dbR != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dbT = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dbV = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dbV = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dbV && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dbT < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dbR.isClickable()) {
                            this.dbR.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dbT = this.dbT > Math.abs(this.startY - motionEvent.getRawY()) ? this.dbT : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dbV && this.dbT < this.touchSlop) {
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
        if (this.dbX) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dbX = z;
    }

    public void setTopOrderView(View view) {
        this.dbR = view;
    }

    private boolean aEY() {
        if (this.dbR == null) {
            return false;
        }
        if (this.dbU == null) {
            return true;
        }
        return this.dbU.width() <= 0 || this.dbU.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aEY()) {
            int[] iArr = {0, 0};
            if (this.dbR != null) {
                this.dbR.getLocationOnScreen(iArr);
                this.dbU = new Rect(iArr[0], iArr[1], iArr[0] + this.dbR.getWidth(), iArr[1] + this.dbR.getHeight());
            }
        }
        return this.dbU;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dbS != null) {
            this.dbS.setEnabled(z);
            this.dbS.setClickable(z);
            this.dbS.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dbS = view;
    }
}
