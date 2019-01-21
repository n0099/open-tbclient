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
    private View aIF;
    private View aIG;
    float aIH;
    private Rect aII;
    private boolean aIJ;
    private a aIK;
    private boolean aIL;
    float startY;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aIK = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.OC = 0;
        this.aIH = 0.0f;
        this.aIJ = false;
        this.aIL = false;
        this.OC = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aIK != null) {
            this.aIK.q(motionEvent);
        }
        if (this.aIF != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.aIH = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aIJ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aIJ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aIJ && Math.abs(this.startY - motionEvent.getRawY()) < this.OC && this.aIH < this.OC && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aIF.isClickable()) {
                            this.aIF.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aIH = this.aIH > Math.abs(this.startY - motionEvent.getRawY()) ? this.aIH : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.aIJ && this.aIH < this.OC) {
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
        if (this.aIL) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aIL = z;
    }

    public void setTopOrderView(View view) {
        this.aIF = view;
    }

    private boolean Fk() {
        if (this.aIF == null) {
            return false;
        }
        if (this.aII == null) {
            return true;
        }
        return this.aII.width() <= 0 || this.aII.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Fk()) {
            int[] iArr = {0, 0};
            if (this.aIF != null) {
                this.aIF.getLocationOnScreen(iArr);
                this.aII = new Rect(iArr[0], iArr[1], iArr[0] + this.aIF.getWidth(), iArr[1] + this.aIF.getHeight());
            }
        }
        return this.aII;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aIG != null) {
            this.aIG.setEnabled(z);
            this.aIG.setClickable(z);
            this.aIG.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aIG = view;
    }
}
