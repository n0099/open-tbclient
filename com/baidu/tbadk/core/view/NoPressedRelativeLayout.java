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
    private View eOB;
    private View eOC;
    float eOD;
    private Rect eOE;
    private boolean eOF;
    private a eOG;
    private boolean eOH;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.eOG = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.eOD = 0.0f;
        this.eOF = false;
        this.eOH = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eOG != null) {
            this.eOG.E(motionEvent);
        }
        if (this.eOB != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.eOD = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.eOF = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.eOF = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.eOF && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.eOD < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.eOB.isClickable()) {
                            this.eOB.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.eOD = this.eOD > Math.abs(this.startY - motionEvent.getRawY()) ? this.eOD : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.eOF && this.eOD < this.touchSlop) {
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
        if (this.eOH) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.eOH = z;
    }

    public void setTopOrderView(View view) {
        this.eOB = view;
    }

    private boolean bpS() {
        if (this.eOB == null) {
            return false;
        }
        if (this.eOE == null) {
            return true;
        }
        return this.eOE.width() <= 0 || this.eOE.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bpS()) {
            int[] iArr = {0, 0};
            if (this.eOB != null) {
                this.eOB.getLocationOnScreen(iArr);
                this.eOE = new Rect(iArr[0], iArr[1], iArr[0] + this.eOB.getWidth(), iArr[1] + this.eOB.getHeight());
            }
        }
        return this.eOE;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.eOC != null) {
            this.eOC.setEnabled(z);
            this.eOC.setClickable(z);
            this.eOC.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.eOC = view;
    }
}
