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
    private View caa;
    private View cab;
    float cac;
    private Rect cad;
    private boolean cae;
    private a caf;
    private boolean cag;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.caf = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.MS = 0;
        this.cac = 0.0f;
        this.cae = false;
        this.cag = false;
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.caf != null) {
            this.caf.u(motionEvent);
        }
        if (this.caa != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.cac = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.cae = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.cae = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.cae && Math.abs(this.startY - motionEvent.getRawY()) < this.MS && this.cac < this.MS && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.caa.isClickable()) {
                            this.caa.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.cac = this.cac > Math.abs(this.startY - motionEvent.getRawY()) ? this.cac : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.cae && this.cac < this.MS) {
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
        if (this.cag) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.cag = z;
    }

    public void setTopOrderView(View view) {
        this.caa = view;
    }

    private boolean akA() {
        if (this.caa == null) {
            return false;
        }
        if (this.cad == null) {
            return true;
        }
        return this.cad.width() <= 0 || this.cad.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (akA()) {
            int[] iArr = {0, 0};
            if (this.caa != null) {
                this.caa.getLocationOnScreen(iArr);
                this.cad = new Rect(iArr[0], iArr[1], iArr[0] + this.caa.getWidth(), iArr[1] + this.caa.getHeight());
            }
        }
        return this.cad;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.cab != null) {
            this.cab.setEnabled(z);
            this.cab.setClickable(z);
            this.cab.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.cab = view;
    }
}
