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
    float HH;
    int HN;
    private View akU;
    private View akV;
    float akW;
    private Rect akX;
    private boolean akY;
    private a akZ;
    private boolean ala;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.akZ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HH = 0.0f;
        this.HN = 0;
        this.akW = 0.0f;
        this.akY = false;
        this.ala = false;
        this.HN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.akZ != null) {
            this.akZ.j(motionEvent);
        }
        if (this.akU != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.HH = motionEvent.getRawY();
                    this.akW = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.akY = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.akY = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.akY && Math.abs(this.HH - motionEvent.getRawY()) < this.HN && this.akW < this.HN && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.akU.isClickable()) {
                            this.akU.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.akW = this.akW > Math.abs(this.HH - motionEvent.getRawY()) ? this.akW : Math.abs(this.HH - motionEvent.getRawY());
                    if (this.akY && this.akW < this.HN) {
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
        if (this.ala) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ala = z;
    }

    public void setTopOrderView(View view) {
        this.akU = view;
    }

    private boolean wV() {
        if (this.akU == null) {
            return false;
        }
        if (this.akX == null) {
            return true;
        }
        return this.akX.width() <= 0 || this.akX.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wV()) {
            int[] iArr = new int[2];
            if (this.akU != null) {
                this.akU.getLocationOnScreen(iArr);
                this.akX = new Rect(iArr[0], iArr[1], iArr[0] + this.akU.getWidth(), iArr[1] + this.akU.getHeight());
            }
        }
        return this.akX;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.akV != null) {
            this.akV.setEnabled(z);
            this.akV.setClickable(z);
            this.akV.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.akV = view;
    }
}
