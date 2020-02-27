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
    private View dgg;
    private View dgh;
    float dgi;
    private Rect dgj;
    private boolean dgk;
    private a dgl;
    private boolean dgm;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dgl = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dgi = 0.0f;
        this.dgk = false;
        this.dgm = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dgl != null) {
            this.dgl.q(motionEvent);
        }
        if (this.dgg != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dgi = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dgk = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dgk = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dgk && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dgi < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dgg.isClickable()) {
                            this.dgg.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dgi = this.dgi > Math.abs(this.startY - motionEvent.getRawY()) ? this.dgi : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dgk && this.dgi < this.touchSlop) {
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
        if (this.dgm) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dgm = z;
    }

    public void setTopOrderView(View view) {
        this.dgg = view;
    }

    private boolean aHD() {
        if (this.dgg == null) {
            return false;
        }
        if (this.dgj == null) {
            return true;
        }
        return this.dgj.width() <= 0 || this.dgj.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aHD()) {
            int[] iArr = {0, 0};
            if (this.dgg != null) {
                this.dgg.getLocationOnScreen(iArr);
                this.dgj = new Rect(iArr[0], iArr[1], iArr[0] + this.dgg.getWidth(), iArr[1] + this.dgg.getHeight());
            }
        }
        return this.dgj;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dgh != null) {
            this.dgh.setEnabled(z);
            this.dgh.setClickable(z);
            this.dgh.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dgh = view;
    }
}
