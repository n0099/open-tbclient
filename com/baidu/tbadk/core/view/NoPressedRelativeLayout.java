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
    float HH;
    int HN;
    private View alA;
    private View alB;
    float alC;
    private Rect alD;
    private boolean alE;
    private a alF;
    private boolean alG;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.alF = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HH = 0.0f;
        this.HN = 0;
        this.alC = 0.0f;
        this.alE = false;
        this.alG = false;
        this.HN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.alF != null) {
            this.alF.j(motionEvent);
        }
        if (this.alA != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.HH = motionEvent.getRawY();
                    this.alC = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.alE = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.alE = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.alE && Math.abs(this.HH - motionEvent.getRawY()) < this.HN && this.alC < this.HN && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.alA.isClickable()) {
                            this.alA.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.alC = this.alC > Math.abs(this.HH - motionEvent.getRawY()) ? this.alC : Math.abs(this.HH - motionEvent.getRawY());
                    if (this.alE && this.alC < this.HN) {
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
        if (this.alG) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.alG = z;
    }

    public void setTopOrderView(View view) {
        this.alA = view;
    }

    private boolean wH() {
        if (this.alA == null) {
            return false;
        }
        if (this.alD == null) {
            return true;
        }
        return this.alD.width() <= 0 || this.alD.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wH()) {
            int[] iArr = {0, 0};
            if (this.alA != null) {
                this.alA.getLocationOnScreen(iArr);
                this.alD = new Rect(iArr[0], iArr[1], iArr[0] + this.alA.getWidth(), iArr[1] + this.alA.getHeight());
            }
        }
        return this.alD;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.alB != null) {
            this.alB.setEnabled(z);
            this.alB.setClickable(z);
            this.alB.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.alB = view;
    }
}
