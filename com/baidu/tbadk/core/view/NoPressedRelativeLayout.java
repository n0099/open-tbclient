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
    float Om;
    int Os;
    private View aDL;
    private View aDM;
    float aDN;
    private Rect aDO;
    private boolean aDP;
    private a aDQ;
    private boolean aDR;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aDQ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Om = 0.0f;
        this.Os = 0;
        this.aDN = 0.0f;
        this.aDP = false;
        this.aDR = false;
        this.Os = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aDQ != null) {
            this.aDQ.q(motionEvent);
        }
        if (this.aDL != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Om = motionEvent.getRawY();
                    this.aDN = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aDP = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aDP = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aDP && Math.abs(this.Om - motionEvent.getRawY()) < this.Os && this.aDN < this.Os && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aDL.isClickable()) {
                            this.aDL.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aDN = this.aDN > Math.abs(this.Om - motionEvent.getRawY()) ? this.aDN : Math.abs(this.Om - motionEvent.getRawY());
                    if (this.aDP && this.aDN < this.Os) {
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
        if (this.aDR) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aDR = z;
    }

    public void setTopOrderView(View view) {
        this.aDL = view;
    }

    private boolean DJ() {
        if (this.aDL == null) {
            return false;
        }
        if (this.aDO == null) {
            return true;
        }
        return this.aDO.width() <= 0 || this.aDO.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (DJ()) {
            int[] iArr = {0, 0};
            if (this.aDL != null) {
                this.aDL.getLocationOnScreen(iArr);
                this.aDO = new Rect(iArr[0], iArr[1], iArr[0] + this.aDL.getWidth(), iArr[1] + this.aDL.getHeight());
            }
        }
        return this.aDO;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aDM != null) {
            this.aDM.setEnabled(z);
            this.aDM.setClickable(z);
            this.aDM.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aDM = view;
    }
}
