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
    int HA;
    float Hu;
    float alA;
    private Rect alB;
    private boolean alC;
    private a alD;
    private boolean alE;
    private View aly;
    private View alz;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.alD = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hu = 0.0f;
        this.HA = 0;
        this.alA = 0.0f;
        this.alC = false;
        this.alE = false;
        this.HA = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.alD != null) {
            this.alD.j(motionEvent);
        }
        if (this.aly != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Hu = motionEvent.getRawY();
                    this.alA = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.alC = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.alC = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.alC && Math.abs(this.Hu - motionEvent.getRawY()) < this.HA && this.alA < this.HA && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aly.isClickable()) {
                            this.aly.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.alA = this.alA > Math.abs(this.Hu - motionEvent.getRawY()) ? this.alA : Math.abs(this.Hu - motionEvent.getRawY());
                    if (this.alC && this.alA < this.HA) {
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
        if (this.alE) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.alE = z;
    }

    public void setTopOrderView(View view) {
        this.aly = view;
    }

    private boolean wh() {
        if (this.aly == null) {
            return false;
        }
        if (this.alB == null) {
            return true;
        }
        return this.alB.width() <= 0 || this.alB.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wh()) {
            int[] iArr = {0, 0};
            if (this.aly != null) {
                this.aly.getLocationOnScreen(iArr);
                this.alB = new Rect(iArr[0], iArr[1], iArr[0] + this.aly.getWidth(), iArr[1] + this.aly.getHeight());
            }
        }
        return this.alB;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.alz != null) {
            this.alz.setEnabled(z);
            this.alz.setClickable(z);
            this.alz.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.alz = view;
    }
}
