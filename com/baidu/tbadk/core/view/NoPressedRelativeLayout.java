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
    float Bk;
    int Bq;
    private View agJ;
    private View agK;
    float agL;
    private Rect agM;
    private boolean agN;
    private a agO;
    private boolean agP;

    /* loaded from: classes.dex */
    public interface a {
        void g(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.agO = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bk = 0.0f;
        this.Bq = 0;
        this.agL = 0.0f;
        this.agN = false;
        this.agP = false;
        this.Bq = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.agO != null) {
            this.agO.g(motionEvent);
        }
        if (this.agJ != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Bk = motionEvent.getRawY();
                    this.agL = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.agN = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.agN = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.agN && Math.abs(this.Bk - motionEvent.getRawY()) < this.Bq && this.agL < this.Bq && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.agJ.isClickable()) {
                            this.agJ.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.agL = this.agL > Math.abs(this.Bk - motionEvent.getRawY()) ? this.agL : Math.abs(this.Bk - motionEvent.getRawY());
                    if (this.agN && this.agL < this.Bq) {
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
        if (this.agP) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.agP = z;
    }

    public void setTopOrderView(View view) {
        this.agJ = view;
    }

    private boolean wx() {
        if (this.agJ == null) {
            return false;
        }
        if (this.agM == null) {
            return true;
        }
        return this.agM.width() <= 0 || this.agM.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wx()) {
            int[] iArr = new int[2];
            if (this.agJ != null) {
                this.agJ.getLocationOnScreen(iArr);
                this.agM = new Rect(iArr[0], iArr[1], iArr[0] + this.agJ.getWidth(), iArr[1] + this.agJ.getHeight());
            }
        }
        return this.agM;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.agK != null) {
            this.agK.setEnabled(z);
            this.agK.setClickable(z);
            this.agK.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.agK = view;
    }
}
