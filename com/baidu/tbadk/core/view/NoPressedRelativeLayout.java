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
    private View agj;
    private View agk;
    float agl;
    private Rect agm;
    private boolean agn;
    private a ago;
    private boolean agp;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.ago = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bk = 0.0f;
        this.Bq = 0;
        this.agl = 0.0f;
        this.agn = false;
        this.agp = false;
        this.Bq = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ago != null) {
            this.ago.f(motionEvent);
        }
        if (this.agj != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Bk = motionEvent.getRawY();
                    this.agl = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.agn = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.agn = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.agn && Math.abs(this.Bk - motionEvent.getRawY()) < this.Bq && this.agl < this.Bq && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.agj.isClickable()) {
                            this.agj.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.agl = this.agl > Math.abs(this.Bk - motionEvent.getRawY()) ? this.agl : Math.abs(this.Bk - motionEvent.getRawY());
                    if (this.agn && this.agl < this.Bq) {
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
        if (this.agp) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.agp = z;
    }

    public void setTopOrderView(View view) {
        this.agj = view;
    }

    private boolean wt() {
        if (this.agj == null) {
            return false;
        }
        if (this.agm == null) {
            return true;
        }
        return this.agm.width() <= 0 || this.agm.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wt()) {
            int[] iArr = new int[2];
            if (this.agj != null) {
                this.agj.getLocationOnScreen(iArr);
                this.agm = new Rect(iArr[0], iArr[1], iArr[0] + this.agj.getWidth(), iArr[1] + this.agj.getHeight());
            }
        }
        return this.agm;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.agk != null) {
            this.agk.setEnabled(z);
            this.agk.setClickable(z);
            this.agk.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.agk = view;
    }
}
