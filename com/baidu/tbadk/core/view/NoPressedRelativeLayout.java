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
    float GP;
    int GV;
    private View alU;
    private View alV;
    float alW;
    private Rect alX;
    private boolean alY;
    private a alZ;
    private boolean ama;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.alZ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GP = 0.0f;
        this.GV = 0;
        this.alW = 0.0f;
        this.alY = false;
        this.ama = false;
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.alZ != null) {
            this.alZ.j(motionEvent);
        }
        if (this.alU != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.GP = motionEvent.getRawY();
                    this.alW = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.alY = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.alY = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.alY && Math.abs(this.GP - motionEvent.getRawY()) < this.GV && this.alW < this.GV && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.alU.isClickable()) {
                            this.alU.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.alW = this.alW > Math.abs(this.GP - motionEvent.getRawY()) ? this.alW : Math.abs(this.GP - motionEvent.getRawY());
                    if (this.alY && this.alW < this.GV) {
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
        if (this.ama) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ama = z;
    }

    public void setTopOrderView(View view) {
        this.alU = view;
    }

    private boolean wo() {
        if (this.alU == null) {
            return false;
        }
        if (this.alX == null) {
            return true;
        }
        return this.alX.width() <= 0 || this.alX.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wo()) {
            int[] iArr = {0, 0};
            if (this.alU != null) {
                this.alU.getLocationOnScreen(iArr);
                this.alX = new Rect(iArr[0], iArr[1], iArr[0] + this.alU.getWidth(), iArr[1] + this.alU.getHeight());
            }
        }
        return this.alX;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.alV != null) {
            this.alV.setEnabled(z);
            this.alV.setClickable(z);
            this.alV.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.alV = view;
    }
}
