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
    float auO;
    int auU;
    private View bco;
    private View bcp;
    float bcq;
    private Rect bcr;
    private boolean bcs;
    private a bct;
    private boolean bcu;

    /* loaded from: classes.dex */
    public interface a {
        void w(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bct = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auO = 0.0f;
        this.auU = 0;
        this.bcq = 0.0f;
        this.bcs = false;
        this.bcu = false;
        this.auU = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bct != null) {
            this.bct.w(motionEvent);
        }
        if (this.bco != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.auO = motionEvent.getRawY();
                    this.bcq = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bcs = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bcs = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bcs && Math.abs(this.auO - motionEvent.getRawY()) < this.auU && this.bcq < this.auU && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bco.isClickable()) {
                            this.bco.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bcq = this.bcq > Math.abs(this.auO - motionEvent.getRawY()) ? this.bcq : Math.abs(this.auO - motionEvent.getRawY());
                    if (this.bcs && this.bcq < this.auU) {
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
        if (this.bcu) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bcu = z;
    }

    public void setTopOrderView(View view) {
        this.bco = view;
    }

    private boolean Eb() {
        if (this.bco == null) {
            return false;
        }
        if (this.bcr == null) {
            return true;
        }
        return this.bcr.width() <= 0 || this.bcr.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Eb()) {
            int[] iArr = {0, 0};
            if (this.bco != null) {
                this.bco.getLocationOnScreen(iArr);
                this.bcr = new Rect(iArr[0], iArr[1], iArr[0] + this.bco.getWidth(), iArr[1] + this.bco.getHeight());
            }
        }
        return this.bcr;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bcp != null) {
            this.bcp.setEnabled(z);
            this.bcp.setClickable(z);
            this.bcp.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bcp = view;
    }
}
