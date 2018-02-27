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
    float auF;
    int auL;
    private View bcc;
    private View bcd;
    float bce;
    private Rect bcf;
    private boolean bcg;
    private a bch;
    private boolean bci;

    /* loaded from: classes.dex */
    public interface a {
        void w(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bch = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auF = 0.0f;
        this.auL = 0;
        this.bce = 0.0f;
        this.bcg = false;
        this.bci = false;
        this.auL = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bch != null) {
            this.bch.w(motionEvent);
        }
        if (this.bcc != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.auF = motionEvent.getRawY();
                    this.bce = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bcg = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bcg = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bcg && Math.abs(this.auF - motionEvent.getRawY()) < this.auL && this.bce < this.auL && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bcc.isClickable()) {
                            this.bcc.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bce = this.bce > Math.abs(this.auF - motionEvent.getRawY()) ? this.bce : Math.abs(this.auF - motionEvent.getRawY());
                    if (this.bcg && this.bce < this.auL) {
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
        if (this.bci) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bci = z;
    }

    public void setTopOrderView(View view) {
        this.bcc = view;
    }

    private boolean Ea() {
        if (this.bcc == null) {
            return false;
        }
        if (this.bcf == null) {
            return true;
        }
        return this.bcf.width() <= 0 || this.bcf.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Ea()) {
            int[] iArr = {0, 0};
            if (this.bcc != null) {
                this.bcc.getLocationOnScreen(iArr);
                this.bcf = new Rect(iArr[0], iArr[1], iArr[0] + this.bcc.getWidth(), iArr[1] + this.bcc.getHeight());
            }
        }
        return this.bcf;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bcd != null) {
            this.bcd.setEnabled(z);
            this.bcd.setClickable(z);
            this.bcd.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bcd = view;
    }
}
