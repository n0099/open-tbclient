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
    private View ebJ;
    private View ebK;
    float ebL;
    private Rect ebM;
    private boolean ebN;
    private a ebO;
    private boolean ebP;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.ebO = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.ebL = 0.0f;
        this.ebN = false;
        this.ebP = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ebO != null) {
            this.ebO.p(motionEvent);
        }
        if (this.ebJ != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.ebL = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.ebN = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.ebN = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.ebN && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.ebL < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.ebJ.isClickable()) {
                            this.ebJ.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.ebL = this.ebL > Math.abs(this.startY - motionEvent.getRawY()) ? this.ebL : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.ebN && this.ebL < this.touchSlop) {
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
        if (this.ebP) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ebP = z;
    }

    public void setTopOrderView(View view) {
        this.ebJ = view;
    }

    private boolean aXY() {
        if (this.ebJ == null) {
            return false;
        }
        if (this.ebM == null) {
            return true;
        }
        return this.ebM.width() <= 0 || this.ebM.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aXY()) {
            int[] iArr = {0, 0};
            if (this.ebJ != null) {
                this.ebJ.getLocationOnScreen(iArr);
                this.ebM = new Rect(iArr[0], iArr[1], iArr[0] + this.ebJ.getWidth(), iArr[1] + this.ebJ.getHeight());
            }
        }
        return this.ebM;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.ebK != null) {
            this.ebK.setEnabled(z);
            this.ebK.setClickable(z);
            this.ebK.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.ebK = view;
    }
}
