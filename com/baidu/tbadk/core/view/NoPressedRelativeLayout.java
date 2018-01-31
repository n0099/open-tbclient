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
    float auT;
    int auZ;
    private boolean baA;
    private a baB;
    private boolean baC;
    private View baw;
    private View bax;
    float bay;
    private Rect baz;

    /* loaded from: classes.dex */
    public interface a {
        void s(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.baB = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auT = 0.0f;
        this.auZ = 0;
        this.bay = 0.0f;
        this.baA = false;
        this.baC = false;
        this.auZ = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.baB != null) {
            this.baB.s(motionEvent);
        }
        if (this.baw != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.auT = motionEvent.getRawY();
                    this.bay = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.baA = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.baA = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.baA && Math.abs(this.auT - motionEvent.getRawY()) < this.auZ && this.bay < this.auZ && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.baw.isClickable()) {
                            this.baw.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bay = this.bay > Math.abs(this.auT - motionEvent.getRawY()) ? this.bay : Math.abs(this.auT - motionEvent.getRawY());
                    if (this.baA && this.bay < this.auZ) {
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
        if (this.baC) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.baC = z;
    }

    public void setTopOrderView(View view) {
        this.baw = view;
    }

    private boolean DH() {
        if (this.baw == null) {
            return false;
        }
        if (this.baz == null) {
            return true;
        }
        return this.baz.width() <= 0 || this.baz.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (DH()) {
            int[] iArr = {0, 0};
            if (this.baw != null) {
                this.baw.getLocationOnScreen(iArr);
                this.baz = new Rect(iArr[0], iArr[1], iArr[0] + this.baw.getWidth(), iArr[1] + this.baw.getHeight());
            }
        }
        return this.baz;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bax != null) {
            this.bax.setEnabled(z);
            this.bax.setClickable(z);
            this.bax.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bax = view;
    }
}
