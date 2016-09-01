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
    private View afJ;
    private View afK;
    float afL;
    private Rect afM;
    private boolean afN;
    private a afO;
    private boolean afP;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.afO = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bk = 0.0f;
        this.Bq = 0;
        this.afL = 0.0f;
        this.afN = false;
        this.afP = false;
        this.Bq = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.afO != null) {
            this.afO.f(motionEvent);
        }
        if (this.afJ != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Bk = motionEvent.getRawY();
                    this.afL = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.afN = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.afN = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.afN && Math.abs(this.Bk - motionEvent.getRawY()) < this.Bq && this.afL < this.Bq && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.afJ.isClickable()) {
                            this.afJ.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.afL = this.afL > Math.abs(this.Bk - motionEvent.getRawY()) ? this.afL : Math.abs(this.Bk - motionEvent.getRawY());
                    if (this.afN && this.afL < this.Bq) {
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
        if (this.afP) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.afP = z;
    }

    public void setTopOrderView(View view) {
        this.afJ = view;
    }

    private boolean wd() {
        if (this.afJ == null) {
            return false;
        }
        if (this.afM == null) {
            return true;
        }
        return this.afM.width() <= 0 || this.afM.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wd()) {
            int[] iArr = new int[2];
            if (this.afJ != null) {
                this.afJ.getLocationOnScreen(iArr);
                this.afM = new Rect(iArr[0], iArr[1], iArr[0] + this.afJ.getWidth(), iArr[1] + this.afJ.getHeight());
            }
        }
        return this.afM;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.afK != null) {
            this.afK.setEnabled(z);
            this.afK.setClickable(z);
            this.afK.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.afK = view;
    }
}
