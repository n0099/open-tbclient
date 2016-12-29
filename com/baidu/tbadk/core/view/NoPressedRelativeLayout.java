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
    float Bi;
    int Bo;
    private View agb;
    private View agc;
    float agd;
    private Rect agf;
    private boolean agg;
    private a agh;
    private boolean agi;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.agh = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bi = 0.0f;
        this.Bo = 0;
        this.agd = 0.0f;
        this.agg = false;
        this.agi = false;
        this.Bo = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.agh != null) {
            this.agh.f(motionEvent);
        }
        if (this.agb != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Bi = motionEvent.getRawY();
                    this.agd = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.agg = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.agg = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.agg && Math.abs(this.Bi - motionEvent.getRawY()) < this.Bo && this.agd < this.Bo && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.agb.isClickable()) {
                            this.agb.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.agd = this.agd > Math.abs(this.Bi - motionEvent.getRawY()) ? this.agd : Math.abs(this.Bi - motionEvent.getRawY());
                    if (this.agg && this.agd < this.Bo) {
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
        if (this.agi) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.agi = z;
    }

    public void setTopOrderView(View view) {
        this.agb = view;
    }

    private boolean wh() {
        if (this.agb == null) {
            return false;
        }
        if (this.agf == null) {
            return true;
        }
        return this.agf.width() <= 0 || this.agf.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wh()) {
            int[] iArr = new int[2];
            if (this.agb != null) {
                this.agb.getLocationOnScreen(iArr);
                this.agf = new Rect(iArr[0], iArr[1], iArr[0] + this.agb.getWidth(), iArr[1] + this.agb.getHeight());
            }
        }
        return this.agf;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.agc != null) {
            this.agc.setEnabled(z);
            this.agc.setClickable(z);
            this.agc.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.agc = view;
    }
}
