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
    private View erQ;
    private View erR;
    float erS;
    private Rect erT;
    private boolean erU;
    private a erV;
    private boolean erW;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.erV = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.erS = 0.0f;
        this.erU = false;
        this.erW = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.erV != null) {
            this.erV.E(motionEvent);
        }
        if (this.erQ != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.erS = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.erU = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.erU = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.erU && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.erS < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.erQ.isClickable()) {
                            this.erQ.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.erS = this.erS > Math.abs(this.startY - motionEvent.getRawY()) ? this.erS : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.erU && this.erS < this.touchSlop) {
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
        if (this.erW) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.erW = z;
    }

    public void setTopOrderView(View view) {
        this.erQ = view;
    }

    private boolean bku() {
        if (this.erQ == null) {
            return false;
        }
        if (this.erT == null) {
            return true;
        }
        return this.erT.width() <= 0 || this.erT.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bku()) {
            int[] iArr = {0, 0};
            if (this.erQ != null) {
                this.erQ.getLocationOnScreen(iArr);
                this.erT = new Rect(iArr[0], iArr[1], iArr[0] + this.erQ.getWidth(), iArr[1] + this.erQ.getHeight());
            }
        }
        return this.erT;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.erR != null) {
            this.erR.setEnabled(z);
            this.erR.setClickable(z);
            this.erR.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.erR = view;
    }
}
