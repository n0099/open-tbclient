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
    float AT;
    int AZ;
    private View afo;
    private View afp;
    float afq;
    private Rect afr;
    private boolean afs;
    private a aft;
    private boolean afu;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aft = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AT = 0.0f;
        this.AZ = 0;
        this.afq = 0.0f;
        this.afs = false;
        this.afu = false;
        this.AZ = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aft != null) {
            this.aft.f(motionEvent);
        }
        if (this.afo != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.AT = motionEvent.getRawY();
                    this.afq = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.afs = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.afs = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.afs && Math.abs(this.AT - motionEvent.getRawY()) < this.AZ && this.afq < this.AZ && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.afo.isClickable()) {
                            this.afo.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.afq = this.afq > Math.abs(this.AT - motionEvent.getRawY()) ? this.afq : Math.abs(this.AT - motionEvent.getRawY());
                    if (this.afs && this.afq < this.AZ) {
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
        if (this.afu) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.afu = z;
    }

    public void setTopOrderView(View view) {
        this.afo = view;
    }

    private boolean wc() {
        if (this.afo == null) {
            return false;
        }
        if (this.afr == null) {
            return true;
        }
        return this.afr.width() <= 0 || this.afr.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wc()) {
            int[] iArr = new int[2];
            if (this.afo != null) {
                this.afo.getLocationOnScreen(iArr);
                this.afr = new Rect(iArr[0], iArr[1], iArr[0] + this.afo.getWidth(), iArr[1] + this.afo.getHeight());
            }
        }
        return this.afr;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.afp != null) {
            this.afp.setEnabled(z);
            this.afp.setClickable(z);
            this.afp.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.afp = view;
    }
}
