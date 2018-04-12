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
    float Fs;
    int Fy;
    private Rect anA;
    private boolean anB;
    private a anC;
    private boolean anD;
    private View anx;
    private View any;
    float anz;

    /* loaded from: classes.dex */
    public interface a {
        void o(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.anC = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Fs = 0.0f;
        this.Fy = 0;
        this.anz = 0.0f;
        this.anB = false;
        this.anD = false;
        this.Fy = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.anC != null) {
            this.anC.o(motionEvent);
        }
        if (this.anx != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Fs = motionEvent.getRawY();
                    this.anz = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.anB = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.anB = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.anB && Math.abs(this.Fs - motionEvent.getRawY()) < this.Fy && this.anz < this.Fy && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.anx.isClickable()) {
                            this.anx.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.anz = this.anz > Math.abs(this.Fs - motionEvent.getRawY()) ? this.anz : Math.abs(this.Fs - motionEvent.getRawY());
                    if (this.anB && this.anz < this.Fy) {
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
        if (this.anD) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.anD = z;
    }

    public void setTopOrderView(View view2) {
        this.anx = view2;
    }

    private boolean wM() {
        if (this.anx == null) {
            return false;
        }
        if (this.anA == null) {
            return true;
        }
        return this.anA.width() <= 0 || this.anA.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wM()) {
            int[] iArr = {0, 0};
            if (this.anx != null) {
                this.anx.getLocationOnScreen(iArr);
                this.anA = new Rect(iArr[0], iArr[1], iArr[0] + this.anx.getWidth(), iArr[1] + this.anx.getHeight());
            }
        }
        return this.anA;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.any != null) {
            this.any.setEnabled(z);
            this.any.setClickable(z);
            this.any.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view2) {
        this.any = view2;
    }
}
