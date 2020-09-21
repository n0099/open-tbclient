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
    private View etV;
    private View etW;
    float etX;
    private Rect etY;
    private boolean etZ;
    private a eua;
    private boolean eub;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.eua = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.etX = 0.0f;
        this.etZ = false;
        this.eub = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eua != null) {
            this.eua.E(motionEvent);
        }
        if (this.etV != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.etX = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.etZ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.etZ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.etZ && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.etX < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.etV.isClickable()) {
                            this.etV.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.etX = this.etX > Math.abs(this.startY - motionEvent.getRawY()) ? this.etX : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.etZ && this.etX < this.touchSlop) {
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
        if (this.eub) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.eub = z;
    }

    public void setTopOrderView(View view) {
        this.etV = view;
    }

    private boolean blp() {
        if (this.etV == null) {
            return false;
        }
        if (this.etY == null) {
            return true;
        }
        return this.etY.width() <= 0 || this.etY.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (blp()) {
            int[] iArr = {0, 0};
            if (this.etV != null) {
                this.etV.getLocationOnScreen(iArr);
                this.etY = new Rect(iArr[0], iArr[1], iArr[0] + this.etV.getWidth(), iArr[1] + this.etV.getHeight());
            }
        }
        return this.etY;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.etW != null) {
            this.etW.setEnabled(z);
            this.etW.setClickable(z);
            this.etW.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.etW = view;
    }
}
