package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class NoPressedRelativeLayout extends RelativeLayout {
    private View erM;
    private View erN;
    float erO;
    private Rect erP;
    private boolean erQ;
    private a erR;
    private boolean erS;
    float startY;
    int touchSlop;

    /* loaded from: classes2.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.erR = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.erO = 0.0f;
        this.erQ = false;
        this.erS = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.erR != null) {
            this.erR.E(motionEvent);
        }
        if (this.erM != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.erO = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.erQ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.erQ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.erQ && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.erO < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.erM.isClickable()) {
                            this.erM.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.erO = this.erO > Math.abs(this.startY - motionEvent.getRawY()) ? this.erO : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.erQ && this.erO < this.touchSlop) {
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
        if (this.erS) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.erS = z;
    }

    public void setTopOrderView(View view) {
        this.erM = view;
    }

    private boolean bku() {
        if (this.erM == null) {
            return false;
        }
        if (this.erP == null) {
            return true;
        }
        return this.erP.width() <= 0 || this.erP.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bku()) {
            int[] iArr = {0, 0};
            if (this.erM != null) {
                this.erM.getLocationOnScreen(iArr);
                this.erP = new Rect(iArr[0], iArr[1], iArr[0] + this.erM.getWidth(), iArr[1] + this.erM.getHeight());
            }
        }
        return this.erP;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.erN != null) {
            this.erN.setEnabled(z);
            this.erN.setClickable(z);
            this.erN.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.erN = view;
    }
}
