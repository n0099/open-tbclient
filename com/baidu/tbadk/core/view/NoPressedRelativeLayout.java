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
    int LD;
    float Lx;
    private View awo;
    private View awp;
    float awq;
    private Rect awr;
    private boolean aws;
    private a awt;
    private boolean awu;

    /* loaded from: classes.dex */
    public interface a {
        void p(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.awt = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lx = 0.0f;
        this.LD = 0;
        this.awq = 0.0f;
        this.aws = false;
        this.awu = false;
        this.LD = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.awt != null) {
            this.awt.p(motionEvent);
        }
        if (this.awo != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Lx = motionEvent.getRawY();
                    this.awq = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.aws = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.aws = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.aws && Math.abs(this.Lx - motionEvent.getRawY()) < this.LD && this.awq < this.LD && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.awo.isClickable()) {
                            this.awo.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.awq = this.awq > Math.abs(this.Lx - motionEvent.getRawY()) ? this.awq : Math.abs(this.Lx - motionEvent.getRawY());
                    if (this.aws && this.awq < this.LD) {
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
        if (this.awu) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.awu = z;
    }

    public void setTopOrderView(View view) {
        this.awo = view;
    }

    private boolean AC() {
        if (this.awo == null) {
            return false;
        }
        if (this.awr == null) {
            return true;
        }
        return this.awr.width() <= 0 || this.awr.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (AC()) {
            int[] iArr = {0, 0};
            if (this.awo != null) {
                this.awo.getLocationOnScreen(iArr);
                this.awr = new Rect(iArr[0], iArr[1], iArr[0] + this.awo.getWidth(), iArr[1] + this.awo.getHeight());
            }
        }
        return this.awr;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.awp != null) {
            this.awp.setEnabled(z);
            this.awp.setClickable(z);
            this.awp.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.awp = view;
    }
}
