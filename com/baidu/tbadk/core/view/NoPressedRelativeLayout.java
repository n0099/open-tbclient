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
    int Ot;
    private View aIc;
    private View aId;
    float aIe;
    private Rect aIf;
    private boolean aIg;
    private a aIh;
    private boolean aIi;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aIh = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.Ot = 0;
        this.aIe = 0.0f;
        this.aIg = false;
        this.aIi = false;
        this.Ot = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aIh != null) {
            this.aIh.q(motionEvent);
        }
        if (this.aIc != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.aIe = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aIg = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aIg = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aIg && Math.abs(this.startY - motionEvent.getRawY()) < this.Ot && this.aIe < this.Ot && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aIc.isClickable()) {
                            this.aIc.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aIe = this.aIe > Math.abs(this.startY - motionEvent.getRawY()) ? this.aIe : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.aIg && this.aIe < this.Ot) {
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
        if (this.aIi) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aIi = z;
    }

    public void setTopOrderView(View view) {
        this.aIc = view;
    }

    private boolean EX() {
        if (this.aIc == null) {
            return false;
        }
        if (this.aIf == null) {
            return true;
        }
        return this.aIf.width() <= 0 || this.aIf.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (EX()) {
            int[] iArr = {0, 0};
            if (this.aIc != null) {
                this.aIc.getLocationOnScreen(iArr);
                this.aIf = new Rect(iArr[0], iArr[1], iArr[0] + this.aIc.getWidth(), iArr[1] + this.aIc.getHeight());
            }
        }
        return this.aIf;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aId != null) {
            this.aId.setEnabled(z);
            this.aId.setClickable(z);
            this.aId.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aId = view;
    }
}
