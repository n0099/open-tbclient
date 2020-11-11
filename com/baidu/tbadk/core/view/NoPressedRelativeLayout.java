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
    private View eUq;
    private View eUr;
    float eUs;
    private Rect eUt;
    private boolean eUu;
    private a eUv;
    private boolean eUw;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.eUv = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.eUs = 0.0f;
        this.eUu = false;
        this.eUw = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eUv != null) {
            this.eUv.E(motionEvent);
        }
        if (this.eUq != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.eUs = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.eUu = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.eUu = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.eUu && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.eUs < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.eUq.isClickable()) {
                            this.eUq.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.eUs = this.eUs > Math.abs(this.startY - motionEvent.getRawY()) ? this.eUs : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.eUu && this.eUs < this.touchSlop) {
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
        if (this.eUw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.eUw = z;
    }

    public void setTopOrderView(View view) {
        this.eUq = view;
    }

    private boolean bss() {
        if (this.eUq == null) {
            return false;
        }
        if (this.eUt == null) {
            return true;
        }
        return this.eUt.width() <= 0 || this.eUt.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bss()) {
            int[] iArr = {0, 0};
            if (this.eUq != null) {
                this.eUq.getLocationOnScreen(iArr);
                this.eUt = new Rect(iArr[0], iArr[1], iArr[0] + this.eUq.getWidth(), iArr[1] + this.eUq.getHeight());
            }
        }
        return this.eUt;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.eUr != null) {
            this.eUr.setEnabled(z);
            this.eUr.setClickable(z);
            this.eUr.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.eUr = view;
    }
}
