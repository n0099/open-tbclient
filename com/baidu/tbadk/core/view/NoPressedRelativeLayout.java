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
    private View dcb;
    private View dcc;
    float dcd;
    private Rect dce;
    private boolean dcf;
    private a dcg;
    private boolean dch;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dcg = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dcd = 0.0f;
        this.dcf = false;
        this.dch = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dcg != null) {
            this.dcg.q(motionEvent);
        }
        if (this.dcb != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dcd = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dcf = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dcf = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dcf && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dcd < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dcb.isClickable()) {
                            this.dcb.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dcd = this.dcd > Math.abs(this.startY - motionEvent.getRawY()) ? this.dcd : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dcf && this.dcd < this.touchSlop) {
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
        if (this.dch) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dch = z;
    }

    public void setTopOrderView(View view) {
        this.dcb = view;
    }

    private boolean aFr() {
        if (this.dcb == null) {
            return false;
        }
        if (this.dce == null) {
            return true;
        }
        return this.dce.width() <= 0 || this.dce.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aFr()) {
            int[] iArr = {0, 0};
            if (this.dcb != null) {
                this.dcb.getLocationOnScreen(iArr);
                this.dce = new Rect(iArr[0], iArr[1], iArr[0] + this.dcb.getWidth(), iArr[1] + this.dcb.getHeight());
            }
        }
        return this.dce;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dcc != null) {
            this.dcc.setEnabled(z);
            this.dcc.setClickable(z);
            this.dcc.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dcc = view;
    }
}
