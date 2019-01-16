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
    int OC;
    private View aIE;
    private View aIF;
    float aIG;
    private Rect aIH;
    private boolean aII;
    private a aIJ;
    private boolean aIK;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aIJ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.OC = 0;
        this.aIG = 0.0f;
        this.aII = false;
        this.aIK = false;
        this.OC = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aIJ != null) {
            this.aIJ.q(motionEvent);
        }
        if (this.aIE != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.aIG = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aII = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aII = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aII && Math.abs(this.startY - motionEvent.getRawY()) < this.OC && this.aIG < this.OC && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aIE.isClickable()) {
                            this.aIE.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aIG = this.aIG > Math.abs(this.startY - motionEvent.getRawY()) ? this.aIG : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.aII && this.aIG < this.OC) {
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
        if (this.aIK) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aIK = z;
    }

    public void setTopOrderView(View view) {
        this.aIE = view;
    }

    private boolean Fk() {
        if (this.aIE == null) {
            return false;
        }
        if (this.aIH == null) {
            return true;
        }
        return this.aIH.width() <= 0 || this.aIH.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Fk()) {
            int[] iArr = {0, 0};
            if (this.aIE != null) {
                this.aIE.getLocationOnScreen(iArr);
                this.aIH = new Rect(iArr[0], iArr[1], iArr[0] + this.aIE.getWidth(), iArr[1] + this.aIE.getHeight());
            }
        }
        return this.aIH;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aIF != null) {
            this.aIF.setEnabled(z);
            this.aIF.setClickable(z);
            this.aIF.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aIF = view;
    }
}
