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
    float NW;
    int Oc;
    private View azd;
    private View aze;
    float azf;
    private Rect azg;
    private boolean azh;
    private a azi;
    private boolean azj;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.azi = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NW = 0.0f;
        this.Oc = 0;
        this.azf = 0.0f;
        this.azh = false;
        this.azj = false;
        this.Oc = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.azi != null) {
            this.azi.q(motionEvent);
        }
        if (this.azd != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.NW = motionEvent.getRawY();
                    this.azf = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.azh = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.azh = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.azh && Math.abs(this.NW - motionEvent.getRawY()) < this.Oc && this.azf < this.Oc && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.azd.isClickable()) {
                            this.azd.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.azf = this.azf > Math.abs(this.NW - motionEvent.getRawY()) ? this.azf : Math.abs(this.NW - motionEvent.getRawY());
                    if (this.azh && this.azf < this.Oc) {
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
        if (this.azj) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.azj = z;
    }

    public void setTopOrderView(View view) {
        this.azd = view;
    }

    private boolean BD() {
        if (this.azd == null) {
            return false;
        }
        if (this.azg == null) {
            return true;
        }
        return this.azg.width() <= 0 || this.azg.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (BD()) {
            int[] iArr = {0, 0};
            if (this.azd != null) {
                this.azd.getLocationOnScreen(iArr);
                this.azg = new Rect(iArr[0], iArr[1], iArr[0] + this.azd.getWidth(), iArr[1] + this.azd.getHeight());
            }
        }
        return this.azg;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.aze != null) {
            this.aze.setEnabled(z);
            this.aze.setClickable(z);
            this.aze.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.aze = view;
    }
}
