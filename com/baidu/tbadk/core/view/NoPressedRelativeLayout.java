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
    private boolean dgA;
    private View dgu;
    private View dgv;
    float dgw;
    private Rect dgx;
    private boolean dgy;
    private a dgz;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dgz = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dgw = 0.0f;
        this.dgy = false;
        this.dgA = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dgz != null) {
            this.dgz.q(motionEvent);
        }
        if (this.dgu != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dgw = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dgy = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dgy = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dgy && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dgw < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dgu.isClickable()) {
                            this.dgu.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dgw = this.dgw > Math.abs(this.startY - motionEvent.getRawY()) ? this.dgw : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dgy && this.dgw < this.touchSlop) {
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
        if (this.dgA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dgA = z;
    }

    public void setTopOrderView(View view) {
        this.dgu = view;
    }

    private boolean aHG() {
        if (this.dgu == null) {
            return false;
        }
        if (this.dgx == null) {
            return true;
        }
        return this.dgx.width() <= 0 || this.dgx.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aHG()) {
            int[] iArr = {0, 0};
            if (this.dgu != null) {
                this.dgu.getLocationOnScreen(iArr);
                this.dgx = new Rect(iArr[0], iArr[1], iArr[0] + this.dgu.getWidth(), iArr[1] + this.dgu.getHeight());
            }
        }
        return this.dgx;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dgv != null) {
            this.dgv.setEnabled(z);
            this.dgv.setClickable(z);
            this.dgv.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dgv = view;
    }
}
