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
    private View dgH;
    private View dgI;
    float dgJ;
    private Rect dgK;
    private boolean dgL;
    private a dgM;
    private boolean dgN;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dgM = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dgJ = 0.0f;
        this.dgL = false;
        this.dgN = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dgM != null) {
            this.dgM.q(motionEvent);
        }
        if (this.dgH != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dgJ = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dgL = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dgL = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dgL && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dgJ < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dgH.isClickable()) {
                            this.dgH.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dgJ = this.dgJ > Math.abs(this.startY - motionEvent.getRawY()) ? this.dgJ : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dgL && this.dgJ < this.touchSlop) {
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
        if (this.dgN) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dgN = z;
    }

    public void setTopOrderView(View view) {
        this.dgH = view;
    }

    private boolean aHK() {
        if (this.dgH == null) {
            return false;
        }
        if (this.dgK == null) {
            return true;
        }
        return this.dgK.width() <= 0 || this.dgK.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aHK()) {
            int[] iArr = {0, 0};
            if (this.dgH != null) {
                this.dgH.getLocationOnScreen(iArr);
                this.dgK = new Rect(iArr[0], iArr[1], iArr[0] + this.dgH.getWidth(), iArr[1] + this.dgH.getHeight());
            }
        }
        return this.dgK;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dgI != null) {
            this.dgI.setEnabled(z);
            this.dgI.setClickable(z);
            this.dgI.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dgI = view;
    }
}
