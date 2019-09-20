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
    private View caT;
    private View caU;
    float caV;
    private Rect caW;
    private boolean caX;
    private a caY;
    private boolean caZ;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void u(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.caY = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.MS = 0;
        this.caV = 0.0f;
        this.caX = false;
        this.caZ = false;
        this.MS = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.caY != null) {
            this.caY.u(motionEvent);
        }
        if (this.caT != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.caV = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.caX = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.caX = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.caX && Math.abs(this.startY - motionEvent.getRawY()) < this.MS && this.caV < this.MS && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.caT.isClickable()) {
                            this.caT.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.caV = this.caV > Math.abs(this.startY - motionEvent.getRawY()) ? this.caV : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.caX && this.caV < this.MS) {
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
        if (this.caZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.caZ = z;
    }

    public void setTopOrderView(View view) {
        this.caT = view;
    }

    private boolean akM() {
        if (this.caT == null) {
            return false;
        }
        if (this.caW == null) {
            return true;
        }
        return this.caW.width() <= 0 || this.caW.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (akM()) {
            int[] iArr = {0, 0};
            if (this.caT != null) {
                this.caT.getLocationOnScreen(iArr);
                this.caW = new Rect(iArr[0], iArr[1], iArr[0] + this.caT.getWidth(), iArr[1] + this.caT.getHeight());
            }
        }
        return this.caW;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.caU != null) {
            this.caU.setEnabled(z);
            this.caU.setClickable(z);
            this.caU.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.caU = view;
    }
}
