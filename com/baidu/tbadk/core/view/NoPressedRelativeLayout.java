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
    private View alT;
    private View alU;
    float alV;
    private Rect alW;
    private boolean alX;
    private a alY;
    private boolean alZ;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.alY = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GP = 0.0f;
        this.GV = 0;
        this.alV = 0.0f;
        this.alX = false;
        this.alZ = false;
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.alY != null) {
            this.alY.j(motionEvent);
        }
        if (this.alT != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.GP = motionEvent.getRawY();
                    this.alV = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.alX = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.alX = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.alX && Math.abs(this.GP - motionEvent.getRawY()) < this.GV && this.alV < this.GV && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.alT.isClickable()) {
                            this.alT.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.alV = this.alV > Math.abs(this.GP - motionEvent.getRawY()) ? this.alV : Math.abs(this.GP - motionEvent.getRawY());
                    if (this.alX && this.alV < this.GV) {
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
        if (this.alZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.alZ = z;
    }

    public void setTopOrderView(View view) {
        this.alT = view;
    }

    private boolean wo() {
        if (this.alT == null) {
            return false;
        }
        if (this.alW == null) {
            return true;
        }
        return this.alW.width() <= 0 || this.alW.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wo()) {
            int[] iArr = {0, 0};
            if (this.alT != null) {
                this.alT.getLocationOnScreen(iArr);
                this.alW = new Rect(iArr[0], iArr[1], iArr[0] + this.alT.getWidth(), iArr[1] + this.alT.getHeight());
            }
        }
        return this.alW;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.alU != null) {
            this.alU.setEnabled(z);
            this.alU.setClickable(z);
            this.alU.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.alU = view;
    }
}
