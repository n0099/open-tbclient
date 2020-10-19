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
    private View eGf;
    private View eGg;
    float eGh;
    private Rect eGi;
    private boolean eGj;
    private a eGk;
    private boolean eGl;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.eGk = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.eGh = 0.0f;
        this.eGj = false;
        this.eGl = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eGk != null) {
            this.eGk.E(motionEvent);
        }
        if (this.eGf != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.eGh = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.eGj = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.eGj = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.eGj && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.eGh < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.eGf.isClickable()) {
                            this.eGf.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.eGh = this.eGh > Math.abs(this.startY - motionEvent.getRawY()) ? this.eGh : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.eGj && this.eGh < this.touchSlop) {
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
        if (this.eGl) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.eGl = z;
    }

    public void setTopOrderView(View view) {
        this.eGf = view;
    }

    private boolean bnZ() {
        if (this.eGf == null) {
            return false;
        }
        if (this.eGi == null) {
            return true;
        }
        return this.eGi.width() <= 0 || this.eGi.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bnZ()) {
            int[] iArr = {0, 0};
            if (this.eGf != null) {
                this.eGf.getLocationOnScreen(iArr);
                this.eGi = new Rect(iArr[0], iArr[1], iArr[0] + this.eGf.getWidth(), iArr[1] + this.eGf.getHeight());
            }
        }
        return this.eGi;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.eGg != null) {
            this.eGg.setEnabled(z);
            this.eGg.setClickable(z);
            this.eGg.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.eGg = view;
    }
}
