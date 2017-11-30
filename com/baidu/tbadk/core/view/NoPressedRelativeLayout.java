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
    int GV;
    private View amp;
    private View amq;
    float amr;
    private Rect ams;
    private boolean amt;
    private a amu;
    private boolean amv;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.amu = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GP = 0.0f;
        this.GV = 0;
        this.amr = 0.0f;
        this.amt = false;
        this.amv = false;
        this.GV = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.amu != null) {
            this.amu.j(motionEvent);
        }
        if (this.amp != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.GP = motionEvent.getRawY();
                    this.amr = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.amt = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.amt = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.amt && Math.abs(this.GP - motionEvent.getRawY()) < this.GV && this.amr < this.GV && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.amp.isClickable()) {
                            this.amp.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.amr = this.amr > Math.abs(this.GP - motionEvent.getRawY()) ? this.amr : Math.abs(this.GP - motionEvent.getRawY());
                    if (this.amt && this.amr < this.GV) {
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
        if (this.amv) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.amv = z;
    }

    public void setTopOrderView(View view) {
        this.amp = view;
    }

    private boolean ws() {
        if (this.amp == null) {
            return false;
        }
        if (this.ams == null) {
            return true;
        }
        return this.ams.width() <= 0 || this.ams.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (ws()) {
            int[] iArr = {0, 0};
            if (this.amp != null) {
                this.amp.getLocationOnScreen(iArr);
                this.ams = new Rect(iArr[0], iArr[1], iArr[0] + this.amp.getWidth(), iArr[1] + this.amp.getHeight());
            }
        }
        return this.ams;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.amq != null) {
            this.amq.setEnabled(z);
            this.amq.setClickable(z);
            this.amq.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.amq = view;
    }
}
