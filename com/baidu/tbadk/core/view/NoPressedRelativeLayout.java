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
    private View dGe;
    private View dGf;
    float dGg;
    private Rect dGh;
    private boolean dGi;
    private a dGj;
    private boolean dGk;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dGj = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dGg = 0.0f;
        this.dGi = false;
        this.dGk = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dGj != null) {
            this.dGj.p(motionEvent);
        }
        if (this.dGe != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dGg = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dGi = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dGi = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dGi && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dGg < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dGe.isClickable()) {
                            this.dGe.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dGg = this.dGg > Math.abs(this.startY - motionEvent.getRawY()) ? this.dGg : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dGi && this.dGg < this.touchSlop) {
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
        if (this.dGk) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dGk = z;
    }

    public void setTopOrderView(View view) {
        this.dGe = view;
    }

    private boolean aQc() {
        if (this.dGe == null) {
            return false;
        }
        if (this.dGh == null) {
            return true;
        }
        return this.dGh.width() <= 0 || this.dGh.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aQc()) {
            int[] iArr = {0, 0};
            if (this.dGe != null) {
                this.dGe.getLocationOnScreen(iArr);
                this.dGh = new Rect(iArr[0], iArr[1], iArr[0] + this.dGe.getWidth(), iArr[1] + this.dGe.getHeight());
            }
        }
        return this.dGh;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dGf != null) {
            this.dGf.setEnabled(z);
            this.dGf.setClickable(z);
            this.dGf.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dGf = view;
    }
}
