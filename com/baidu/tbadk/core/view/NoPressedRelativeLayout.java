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
    float auG;
    int auM;
    private View bce;
    private View bcf;
    float bcg;
    private Rect bch;
    private boolean bci;
    private a bcj;
    private boolean bck;

    /* loaded from: classes.dex */
    public interface a {
        void w(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bcj = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auG = 0.0f;
        this.auM = 0;
        this.bcg = 0.0f;
        this.bci = false;
        this.bck = false;
        this.auM = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bcj != null) {
            this.bcj.w(motionEvent);
        }
        if (this.bce != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.auG = motionEvent.getRawY();
                    this.bcg = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bci = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bci = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bci && Math.abs(this.auG - motionEvent.getRawY()) < this.auM && this.bcg < this.auM && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bce.isClickable()) {
                            this.bce.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bcg = this.bcg > Math.abs(this.auG - motionEvent.getRawY()) ? this.bcg : Math.abs(this.auG - motionEvent.getRawY());
                    if (this.bci && this.bcg < this.auM) {
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
        if (this.bck) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bck = z;
    }

    public void setTopOrderView(View view) {
        this.bce = view;
    }

    private boolean Eb() {
        if (this.bce == null) {
            return false;
        }
        if (this.bch == null) {
            return true;
        }
        return this.bch.width() <= 0 || this.bch.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Eb()) {
            int[] iArr = {0, 0};
            if (this.bce != null) {
                this.bce.getLocationOnScreen(iArr);
                this.bch = new Rect(iArr[0], iArr[1], iArr[0] + this.bce.getWidth(), iArr[1] + this.bce.getHeight());
            }
        }
        return this.bch;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bcf != null) {
            this.bcf.setEnabled(z);
            this.bcf.setClickable(z);
            this.bcf.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bcf = view;
    }
}
