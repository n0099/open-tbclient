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
    int LB;
    float Lv;
    private View avF;
    private View avG;
    float avH;
    private Rect avI;
    private boolean avJ;
    private a avK;
    private boolean avL;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.avK = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lv = 0.0f;
        this.LB = 0;
        this.avH = 0.0f;
        this.avJ = false;
        this.avL = false;
        this.LB = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.avK != null) {
            this.avK.p(motionEvent);
        }
        if (this.avF != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Lv = motionEvent.getRawY();
                    this.avH = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.avJ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.avJ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.avJ && Math.abs(this.Lv - motionEvent.getRawY()) < this.LB && this.avH < this.LB && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.avF.isClickable()) {
                            this.avF.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.avH = this.avH > Math.abs(this.Lv - motionEvent.getRawY()) ? this.avH : Math.abs(this.Lv - motionEvent.getRawY());
                    if (this.avJ && this.avH < this.LB) {
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
        if (this.avL) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.avL = z;
    }

    public void setTopOrderView(View view) {
        this.avF = view;
    }

    private boolean Am() {
        if (this.avF == null) {
            return false;
        }
        if (this.avI == null) {
            return true;
        }
        return this.avI.width() <= 0 || this.avI.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Am()) {
            int[] iArr = {0, 0};
            if (this.avF != null) {
                this.avF.getLocationOnScreen(iArr);
                this.avI = new Rect(iArr[0], iArr[1], iArr[0] + this.avF.getWidth(), iArr[1] + this.avF.getHeight());
            }
        }
        return this.avI;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.avG != null) {
            this.avG.setEnabled(z);
            this.avG.setClickable(z);
            this.avG.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.avG = view;
    }
}
