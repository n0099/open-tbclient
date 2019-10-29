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
    private a cpA;
    private boolean cpB;
    private View cpv;
    private View cpw;
    float cpx;
    private Rect cpy;
    private boolean cpz;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.cpA = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.cpx = 0.0f;
        this.cpz = false;
        this.cpB = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.cpA != null) {
            this.cpA.q(motionEvent);
        }
        if (this.cpv != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.cpx = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.cpz = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.cpz = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.cpz && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.cpx < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.cpv.isClickable()) {
                            this.cpv.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.cpx = this.cpx > Math.abs(this.startY - motionEvent.getRawY()) ? this.cpx : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.cpz && this.cpx < this.touchSlop) {
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
        if (this.cpB) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.cpB = z;
    }

    public void setTopOrderView(View view) {
        this.cpv = view;
    }

    private boolean anK() {
        if (this.cpv == null) {
            return false;
        }
        if (this.cpy == null) {
            return true;
        }
        return this.cpy.width() <= 0 || this.cpy.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (anK()) {
            int[] iArr = {0, 0};
            if (this.cpv != null) {
                this.cpv.getLocationOnScreen(iArr);
                this.cpy = new Rect(iArr[0], iArr[1], iArr[0] + this.cpv.getWidth(), iArr[1] + this.cpv.getHeight());
            }
        }
        return this.cpy;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.cpw != null) {
            this.cpw.setEnabled(z);
            this.cpw.setClickable(z);
            this.cpw.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.cpw = view;
    }
}
