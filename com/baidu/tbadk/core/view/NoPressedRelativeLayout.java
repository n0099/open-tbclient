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
    float eTA;
    private Rect eTB;
    private boolean eTC;
    private a eTD;
    private boolean eTE;
    private View eTy;
    private View eTz;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.eTD = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.eTA = 0.0f;
        this.eTC = false;
        this.eTE = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eTD != null) {
            this.eTD.E(motionEvent);
        }
        if (this.eTy != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.eTA = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.eTC = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.eTC = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.eTC && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.eTA < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.eTy.isClickable()) {
                            this.eTy.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.eTA = this.eTA > Math.abs(this.startY - motionEvent.getRawY()) ? this.eTA : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.eTC && this.eTA < this.touchSlop) {
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
        if (this.eTE) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.eTE = z;
    }

    public void setTopOrderView(View view) {
        this.eTy = view;
    }

    private boolean brH() {
        if (this.eTy == null) {
            return false;
        }
        if (this.eTB == null) {
            return true;
        }
        return this.eTB.width() <= 0 || this.eTB.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (brH()) {
            int[] iArr = {0, 0};
            if (this.eTy != null) {
                this.eTy.getLocationOnScreen(iArr);
                this.eTB = new Rect(iArr[0], iArr[1], iArr[0] + this.eTy.getWidth(), iArr[1] + this.eTy.getHeight());
            }
        }
        return this.eTB;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.eTz != null) {
            this.eTz.setEnabled(z);
            this.eTz.setClickable(z);
            this.eTz.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.eTz = view;
    }
}
