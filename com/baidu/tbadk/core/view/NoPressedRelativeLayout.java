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
    int Ot;
    private View aEB;
    private View aEC;
    float aED;
    private Rect aEE;
    private boolean aEF;
    private a aEG;
    private boolean aEH;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aEG = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.Ot = 0;
        this.aED = 0.0f;
        this.aEF = false;
        this.aEH = false;
        this.Ot = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aEG != null) {
            this.aEG.q(motionEvent);
        }
        if (this.aEB != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.aED = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aEF = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aEF = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aEF && Math.abs(this.startY - motionEvent.getRawY()) < this.Ot && this.aED < this.Ot && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aEB.isClickable()) {
                            this.aEB.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aED = this.aED > Math.abs(this.startY - motionEvent.getRawY()) ? this.aED : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.aEF && this.aED < this.Ot) {
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
        if (this.aEH) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aEH = z;
    }

    public void setTopOrderView(View view) {
        this.aEB = view;
    }

    private boolean DT() {
        if (this.aEB == null) {
            return false;
        }
        if (this.aEE == null) {
            return true;
        }
        return this.aEE.width() <= 0 || this.aEE.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (DT()) {
            int[] iArr = {0, 0};
            if (this.aEB != null) {
                this.aEB.getLocationOnScreen(iArr);
                this.aEE = new Rect(iArr[0], iArr[1], iArr[0] + this.aEB.getWidth(), iArr[1] + this.aEB.getHeight());
            }
        }
        return this.aEE;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aEC != null) {
            this.aEC.setEnabled(z);
            this.aEC.setClickable(z);
            this.aEC.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aEC = view;
    }
}
