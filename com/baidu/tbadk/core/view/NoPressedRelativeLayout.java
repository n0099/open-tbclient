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
    private View ehV;
    private View ehW;
    float ehX;
    private Rect ehY;
    private boolean ehZ;
    private a eia;
    private boolean eib;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.eia = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.ehX = 0.0f;
        this.ehZ = false;
        this.eib = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.eia != null) {
            this.eia.p(motionEvent);
        }
        if (this.ehV != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.ehX = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.ehZ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.ehZ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.ehZ && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.ehX < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.ehV.isClickable()) {
                            this.ehV.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.ehX = this.ehX > Math.abs(this.startY - motionEvent.getRawY()) ? this.ehX : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.ehZ && this.ehX < this.touchSlop) {
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
        if (this.eib) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.eib = z;
    }

    public void setTopOrderView(View view) {
        this.ehV = view;
    }

    private boolean bbY() {
        if (this.ehV == null) {
            return false;
        }
        if (this.ehY == null) {
            return true;
        }
        return this.ehY.width() <= 0 || this.ehY.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (bbY()) {
            int[] iArr = {0, 0};
            if (this.ehV != null) {
                this.ehV.getLocationOnScreen(iArr);
                this.ehY = new Rect(iArr[0], iArr[1], iArr[0] + this.ehV.getWidth(), iArr[1] + this.ehV.getHeight());
            }
        }
        return this.ehY;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.ehW != null) {
            this.ehW.setEnabled(z);
            this.ehW.setClickable(z);
            this.ehW.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.ehW = view;
    }
}
