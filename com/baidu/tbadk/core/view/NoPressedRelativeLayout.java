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
    float Ig;
    int Im;
    private View akG;
    private View akH;
    float akI;
    private Rect akJ;
    private boolean akK;
    private a akL;
    private boolean akM;

    /* loaded from: classes.dex */
    public interface a {
        void f(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.akL = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ig = 0.0f;
        this.Im = 0;
        this.akI = 0.0f;
        this.akK = false;
        this.akM = false;
        this.Im = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.akL != null) {
            this.akL.f(motionEvent);
        }
        if (this.akG != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Ig = motionEvent.getRawY();
                    this.akI = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.akK = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.akK = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.akK && Math.abs(this.Ig - motionEvent.getRawY()) < this.Im && this.akI < this.Im && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.akG.isClickable()) {
                            this.akG.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.akI = this.akI > Math.abs(this.Ig - motionEvent.getRawY()) ? this.akI : Math.abs(this.Ig - motionEvent.getRawY());
                    if (this.akK && this.akI < this.Im) {
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
        if (this.akM) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.akM = z;
    }

    public void setTopOrderView(View view) {
        this.akG = view;
    }

    private boolean wz() {
        if (this.akG == null) {
            return false;
        }
        if (this.akJ == null) {
            return true;
        }
        return this.akJ.width() <= 0 || this.akJ.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wz()) {
            int[] iArr = new int[2];
            if (this.akG != null) {
                this.akG.getLocationOnScreen(iArr);
                this.akJ = new Rect(iArr[0], iArr[1], iArr[0] + this.akG.getWidth(), iArr[1] + this.akG.getHeight());
            }
        }
        return this.akJ;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.akH != null) {
            this.akH.setEnabled(z);
            this.akH.setClickable(z);
            this.akH.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.akH = view;
    }
}
