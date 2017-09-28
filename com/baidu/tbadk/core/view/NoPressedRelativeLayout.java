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
    float Ht;
    int Hz;
    private View alK;
    private View alL;
    float alM;
    private Rect alN;
    private boolean alO;
    private a alP;
    private boolean alQ;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.alP = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ht = 0.0f;
        this.Hz = 0;
        this.alM = 0.0f;
        this.alO = false;
        this.alQ = false;
        this.Hz = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.alP != null) {
            this.alP.j(motionEvent);
        }
        if (this.alK != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Ht = motionEvent.getRawY();
                    this.alM = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.alO = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.alO = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.alO && Math.abs(this.Ht - motionEvent.getRawY()) < this.Hz && this.alM < this.Hz && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.alK.isClickable()) {
                            this.alK.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.alM = this.alM > Math.abs(this.Ht - motionEvent.getRawY()) ? this.alM : Math.abs(this.Ht - motionEvent.getRawY());
                    if (this.alO && this.alM < this.Hz) {
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
        if (this.alQ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.alQ = z;
    }

    public void setTopOrderView(View view) {
        this.alK = view;
    }

    private boolean wo() {
        if (this.alK == null) {
            return false;
        }
        if (this.alN == null) {
            return true;
        }
        return this.alN.width() <= 0 || this.alN.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wo()) {
            int[] iArr = {0, 0};
            if (this.alK != null) {
                this.alK.getLocationOnScreen(iArr);
                this.alN = new Rect(iArr[0], iArr[1], iArr[0] + this.alK.getWidth(), iArr[1] + this.alK.getHeight());
            }
        }
        return this.alN;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.alL != null) {
            this.alL.setEnabled(z);
            this.alL.setClickable(z);
            this.alL.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.alL = view;
    }
}
