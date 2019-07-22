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
    int MS;
    private View bZU;
    private View bZV;
    float bZW;
    private Rect bZX;
    private boolean bZY;
    private a bZZ;
    private boolean caa;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bZZ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.MS = 0;
        this.bZW = 0.0f;
        this.bZY = false;
        this.caa = false;
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bZZ != null) {
            this.bZZ.u(motionEvent);
        }
        if (this.bZU != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.bZW = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bZY = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bZY = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bZY && Math.abs(this.startY - motionEvent.getRawY()) < this.MS && this.bZW < this.MS && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bZU.isClickable()) {
                            this.bZU.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bZW = this.bZW > Math.abs(this.startY - motionEvent.getRawY()) ? this.bZW : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.bZY && this.bZW < this.MS) {
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
        if (this.caa) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.caa = z;
    }

    public void setTopOrderView(View view) {
        this.bZU = view;
    }

    private boolean aky() {
        if (this.bZU == null) {
            return false;
        }
        if (this.bZX == null) {
            return true;
        }
        return this.bZX.width() <= 0 || this.bZX.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (aky()) {
            int[] iArr = {0, 0};
            if (this.bZU != null) {
                this.bZU.getLocationOnScreen(iArr);
                this.bZX = new Rect(iArr[0], iArr[1], iArr[0] + this.bZU.getWidth(), iArr[1] + this.bZU.getHeight());
            }
        }
        return this.bZX;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bZV != null) {
            this.bZV.setEnabled(z);
            this.bZV.setClickable(z);
            this.bZV.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bZV = view;
    }
}
