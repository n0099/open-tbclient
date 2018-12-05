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
    private View aIb;
    private View aIc;
    float aId;
    private Rect aIe;
    private boolean aIf;
    private a aIg;
    private boolean aIh;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aIg = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.Ot = 0;
        this.aId = 0.0f;
        this.aIf = false;
        this.aIh = false;
        this.Ot = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aIg != null) {
            this.aIg.q(motionEvent);
        }
        if (this.aIb != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.aId = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aIf = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aIf = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aIf && Math.abs(this.startY - motionEvent.getRawY()) < this.Ot && this.aId < this.Ot && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aIb.isClickable()) {
                            this.aIb.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aId = this.aId > Math.abs(this.startY - motionEvent.getRawY()) ? this.aId : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.aIf && this.aId < this.Ot) {
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
        if (this.aIh) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aIh = z;
    }

    public void setTopOrderView(View view) {
        this.aIb = view;
    }

    private boolean EX() {
        if (this.aIb == null) {
            return false;
        }
        if (this.aIe == null) {
            return true;
        }
        return this.aIe.width() <= 0 || this.aIe.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (EX()) {
            int[] iArr = {0, 0};
            if (this.aIb != null) {
                this.aIb.getLocationOnScreen(iArr);
                this.aIe = new Rect(iArr[0], iArr[1], iArr[0] + this.aIb.getWidth(), iArr[1] + this.aIb.getHeight());
            }
        }
        return this.aIe;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aIc != null) {
            this.aIc.setEnabled(z);
            this.aIc.setClickable(z);
            this.aIc.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aIc = view;
    }
}
