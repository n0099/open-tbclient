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
    private boolean dUA;
    private View dUu;
    private View dUv;
    float dUw;
    private Rect dUx;
    private boolean dUy;
    private a dUz;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dUz = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dUw = 0.0f;
        this.dUy = false;
        this.dUA = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dUz != null) {
            this.dUz.p(motionEvent);
        }
        if (this.dUu != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dUw = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dUy = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dUy = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dUy && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dUw < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dUu.isClickable()) {
                            this.dUu.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dUw = this.dUw > Math.abs(this.startY - motionEvent.getRawY()) ? this.dUw : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dUy && this.dUw < this.touchSlop) {
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
        if (this.dUA) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dUA = z;
    }

    public void setTopOrderView(View view) {
        this.dUu = view;
    }

    private boolean aWd() {
        if (this.dUu == null) {
            return false;
        }
        if (this.dUx == null) {
            return true;
        }
        return this.dUx.width() <= 0 || this.dUx.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aWd()) {
            int[] iArr = {0, 0};
            if (this.dUu != null) {
                this.dUu.getLocationOnScreen(iArr);
                this.dUx = new Rect(iArr[0], iArr[1], iArr[0] + this.dUu.getWidth(), iArr[1] + this.dUu.getHeight());
            }
        }
        return this.dUx;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dUv != null) {
            this.dUv.setEnabled(z);
            this.dUv.setClickable(z);
            this.dUv.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dUv = view;
    }
}
