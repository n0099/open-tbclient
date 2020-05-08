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
    private View dGi;
    private View dGj;
    float dGk;
    private Rect dGl;
    private boolean dGm;
    private a dGn;
    private boolean dGo;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.dGn = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.dGk = 0.0f;
        this.dGm = false;
        this.dGo = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dGn != null) {
            this.dGn.p(motionEvent);
        }
        if (this.dGi != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.dGk = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.dGm = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.dGm = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.dGm && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.dGk < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.dGi.isClickable()) {
                            this.dGi.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.dGk = this.dGk > Math.abs(this.startY - motionEvent.getRawY()) ? this.dGk : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.dGm && this.dGk < this.touchSlop) {
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
        if (this.dGo) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.dGo = z;
    }

    public void setTopOrderView(View view) {
        this.dGi = view;
    }

    private boolean aPZ() {
        if (this.dGi == null) {
            return false;
        }
        if (this.dGl == null) {
            return true;
        }
        return this.dGl.width() <= 0 || this.dGl.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aPZ()) {
            int[] iArr = {0, 0};
            if (this.dGi != null) {
                this.dGi.getLocationOnScreen(iArr);
                this.dGl = new Rect(iArr[0], iArr[1], iArr[0] + this.dGi.getWidth(), iArr[1] + this.dGi.getHeight());
            }
        }
        return this.dGl;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.dGj != null) {
            this.dGj.setEnabled(z);
            this.dGj.setClickable(z);
            this.dGj.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.dGj = view;
    }
}
