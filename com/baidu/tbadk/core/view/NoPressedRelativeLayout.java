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
    private View abP;
    private View abQ;
    float abR;
    private Rect abS;
    private boolean abT;
    private a abU;
    private boolean abV;
    float ys;
    int yy;

    /* loaded from: classes.dex */
    public interface a {
        void d(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.abU = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ys = 0.0f;
        this.yy = 0;
        this.abR = 0.0f;
        this.abT = false;
        this.abV = false;
        this.yy = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.abU != null) {
            this.abU.d(motionEvent);
        }
        if (this.abP != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.ys = motionEvent.getRawY();
                    this.abR = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.abT = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.abT = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.abT && Math.abs(this.ys - motionEvent.getRawY()) < this.yy && this.abR < this.yy && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.abP.isClickable()) {
                            this.abP.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.abR = this.abR > Math.abs(this.ys - motionEvent.getRawY()) ? this.abR : Math.abs(this.ys - motionEvent.getRawY());
                    if (this.abT && this.abR < this.yy) {
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
        if (this.abV) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.abV = z;
    }

    public void setTopOrderView(View view) {
        this.abP = view;
    }

    private boolean uZ() {
        if (this.abP == null) {
            return false;
        }
        if (this.abS == null) {
            return true;
        }
        return this.abS.width() <= 0 || this.abS.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (uZ()) {
            int[] iArr = new int[2];
            if (this.abP != null) {
                this.abP.getLocationOnScreen(iArr);
                this.abS = new Rect(iArr[0], iArr[1], iArr[0] + this.abP.getWidth(), iArr[1] + this.abP.getHeight());
            }
        }
        return this.abS;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.abQ != null) {
            this.abQ.setEnabled(z);
            this.abQ.setClickable(z);
            this.abQ.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.abQ = view;
    }
}
