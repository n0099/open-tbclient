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
    private View dgh;
    private View dgi;
    float dgj;
    private Rect dgk;
    private boolean dgl;
    private a dgm;
    private boolean dgn;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dgm = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dgj = 0.0f;
        this.dgl = false;
        this.dgn = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dgm != null) {
            this.dgm.q(motionEvent);
        }
        if (this.dgh != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dgj = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dgl = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dgl = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dgl && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dgj < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dgh.isClickable()) {
                            this.dgh.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dgj = this.dgj > Math.abs(this.startY - motionEvent.getRawY()) ? this.dgj : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dgl && this.dgj < this.touchSlop) {
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
        if (this.dgn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dgn = z;
    }

    public void setTopOrderView(View view) {
        this.dgh = view;
    }

    private boolean aHF() {
        if (this.dgh == null) {
            return false;
        }
        if (this.dgk == null) {
            return true;
        }
        return this.dgk.width() <= 0 || this.dgk.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aHF()) {
            int[] iArr = {0, 0};
            if (this.dgh != null) {
                this.dgh.getLocationOnScreen(iArr);
                this.dgk = new Rect(iArr[0], iArr[1], iArr[0] + this.dgh.getWidth(), iArr[1] + this.dgh.getHeight());
            }
        }
        return this.dgk;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dgi != null) {
            this.dgi.setEnabled(z);
            this.dgi.setClickable(z);
            this.dgi.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dgi = view;
    }
}
