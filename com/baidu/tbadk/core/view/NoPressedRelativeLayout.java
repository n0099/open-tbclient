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
    int GW;
    private View amm;
    private View amn;
    float amo;
    private Rect amp;
    private boolean amq;
    private a amr;
    private boolean ams;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.amr = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GP = 0.0f;
        this.GW = 0;
        this.amo = 0.0f;
        this.amq = false;
        this.ams = false;
        this.GW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.amr != null) {
            this.amr.j(motionEvent);
        }
        if (this.amm != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.GP = motionEvent.getRawY();
                    this.amo = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.amq = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.amq = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.amq && Math.abs(this.GP - motionEvent.getRawY()) < this.GW && this.amo < this.GW && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.amm.isClickable()) {
                            this.amm.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.amo = this.amo > Math.abs(this.GP - motionEvent.getRawY()) ? this.amo : Math.abs(this.GP - motionEvent.getRawY());
                    if (this.amq && this.amo < this.GW) {
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
        if (this.ams) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ams = z;
    }

    public void setTopOrderView(View view) {
        this.amm = view;
    }

    private boolean wq() {
        if (this.amm == null) {
            return false;
        }
        if (this.amp == null) {
            return true;
        }
        return this.amp.width() <= 0 || this.amp.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wq()) {
            int[] iArr = {0, 0};
            if (this.amm != null) {
                this.amm.getLocationOnScreen(iArr);
                this.amp = new Rect(iArr[0], iArr[1], iArr[0] + this.amm.getWidth(), iArr[1] + this.amm.getHeight());
            }
        }
        return this.amp;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.amn != null) {
            this.amn.setEnabled(z);
            this.amn.setClickable(z);
            this.amn.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.amn = view;
    }
}
