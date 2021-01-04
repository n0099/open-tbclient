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
    float fkA;
    private Rect fkB;
    private boolean fkC;
    private a fkD;
    private boolean fkE;
    private View fky;
    private View fkz;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.fkD = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.fkA = 0.0f;
        this.fkC = false;
        this.fkE = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fkD != null) {
            this.fkD.E(motionEvent);
        }
        if (this.fky != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.fkA = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.fkC = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.fkC = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.fkC && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.fkA < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.fky.isClickable()) {
                            this.fky.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.fkA = this.fkA > Math.abs(this.startY - motionEvent.getRawY()) ? this.fkA : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.fkC && this.fkA < this.touchSlop) {
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
        if (this.fkE) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.fkE = z;
    }

    public void setTopOrderView(View view) {
        this.fky = view;
    }

    private boolean bxB() {
        if (this.fky == null) {
            return false;
        }
        if (this.fkB == null) {
            return true;
        }
        return this.fkB.width() <= 0 || this.fkB.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bxB()) {
            int[] iArr = {0, 0};
            if (this.fky != null) {
                this.fky.getLocationOnScreen(iArr);
                this.fkB = new Rect(iArr[0], iArr[1], iArr[0] + this.fky.getWidth(), iArr[1] + this.fky.getHeight());
            }
        }
        return this.fkB;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.fkz != null) {
            this.fkz.setEnabled(z);
            this.fkz.setClickable(z);
            this.fkz.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.fkz = view;
    }
}
