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
    private View faU;
    private View faV;
    float faW;
    private Rect faX;
    private boolean faY;
    private a faZ;
    private boolean fba;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.faZ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.faW = 0.0f;
        this.faY = false;
        this.fba = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.faZ != null) {
            this.faZ.E(motionEvent);
        }
        if (this.faU != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.faW = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.faY = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.faY = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.faY && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.faW < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.faU.isClickable()) {
                            this.faU.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.faW = this.faW > Math.abs(this.startY - motionEvent.getRawY()) ? this.faW : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.faY && this.faW < this.touchSlop) {
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
        if (this.fba) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.fba = z;
    }

    public void setTopOrderView(View view) {
        this.faU = view;
    }

    private boolean bvg() {
        if (this.faU == null) {
            return false;
        }
        if (this.faX == null) {
            return true;
        }
        return this.faX.width() <= 0 || this.faX.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bvg()) {
            int[] iArr = {0, 0};
            if (this.faU != null) {
                this.faU.getLocationOnScreen(iArr);
                this.faX = new Rect(iArr[0], iArr[1], iArr[0] + this.faU.getWidth(), iArr[1] + this.faU.getHeight());
            }
        }
        return this.faX;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.faV != null) {
            this.faV.setEnabled(z);
            this.faV.setClickable(z);
            this.faV.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.faV = view;
    }
}
