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
    private View fjF;
    private View fjG;
    float fjH;
    private Rect fjI;
    private boolean fjJ;
    private a fjK;
    private boolean fjL;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.fjK = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.fjH = 0.0f;
        this.fjJ = false;
        this.fjL = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fjK != null) {
            this.fjK.E(motionEvent);
        }
        if (this.fjF != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.fjH = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.fjJ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.fjJ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.fjJ && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.fjH < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.fjF.isClickable()) {
                            this.fjF.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.fjH = this.fjH > Math.abs(this.startY - motionEvent.getRawY()) ? this.fjH : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.fjJ && this.fjH < this.touchSlop) {
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
        if (this.fjL) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.fjL = z;
    }

    public void setTopOrderView(View view) {
        this.fjF = view;
    }

    private boolean buf() {
        if (this.fjF == null) {
            return false;
        }
        if (this.fjI == null) {
            return true;
        }
        return this.fjI.width() <= 0 || this.fjI.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (buf()) {
            int[] iArr = {0, 0};
            if (this.fjF != null) {
                this.fjF.getLocationOnScreen(iArr);
                this.fjI = new Rect(iArr[0], iArr[1], iArr[0] + this.fjF.getWidth(), iArr[1] + this.fjF.getHeight());
            }
        }
        return this.fjI;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.fjG != null) {
            this.fjG.setEnabled(z);
            this.fjG.setClickable(z);
            this.fjG.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.fjG = view;
    }
}
