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
    float Hc;
    int Hi;
    private View amo;
    private View amp;
    float amq;
    private Rect amr;
    private boolean ams;
    private a amt;
    private boolean amu;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.amt = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hc = 0.0f;
        this.Hi = 0;
        this.amq = 0.0f;
        this.ams = false;
        this.amu = false;
        this.Hi = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.amt != null) {
            this.amt.j(motionEvent);
        }
        if (this.amo != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Hc = motionEvent.getRawY();
                    this.amq = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.ams = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.ams = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.ams && Math.abs(this.Hc - motionEvent.getRawY()) < this.Hi && this.amq < this.Hi && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.amo.isClickable()) {
                            this.amo.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.amq = this.amq > Math.abs(this.Hc - motionEvent.getRawY()) ? this.amq : Math.abs(this.Hc - motionEvent.getRawY());
                    if (this.ams && this.amq < this.Hi) {
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
        if (this.amu) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.amu = z;
    }

    public void setTopOrderView(View view) {
        this.amo = view;
    }

    private boolean wP() {
        if (this.amo == null) {
            return false;
        }
        if (this.amr == null) {
            return true;
        }
        return this.amr.width() <= 0 || this.amr.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wP()) {
            int[] iArr = {0, 0};
            if (this.amo != null) {
                this.amo.getLocationOnScreen(iArr);
                this.amr = new Rect(iArr[0], iArr[1], iArr[0] + this.amo.getWidth(), iArr[1] + this.amo.getHeight());
            }
        }
        return this.amr;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.amp != null) {
            this.amp.setEnabled(z);
            this.amp.setClickable(z);
            this.amp.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.amp = view;
    }
}
