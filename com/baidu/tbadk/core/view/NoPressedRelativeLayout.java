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
    float HI;
    int HO;
    private View aki;
    private View akj;
    float akk;
    private Rect akl;
    private boolean akm;
    private a akn;
    private boolean ako;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.akn = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HI = 0.0f;
        this.HO = 0;
        this.akk = 0.0f;
        this.akm = false;
        this.ako = false;
        this.HO = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.akn != null) {
            this.akn.j(motionEvent);
        }
        if (this.aki != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.HI = motionEvent.getRawY();
                    this.akk = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.akm = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.akm = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.akm && Math.abs(this.HI - motionEvent.getRawY()) < this.HO && this.akk < this.HO && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aki.isClickable()) {
                            this.aki.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.akk = this.akk > Math.abs(this.HI - motionEvent.getRawY()) ? this.akk : Math.abs(this.HI - motionEvent.getRawY());
                    if (this.akm && this.akk < this.HO) {
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
        if (this.ako) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ako = z;
    }

    public void setTopOrderView(View view) {
        this.aki = view;
    }

    private boolean wf() {
        if (this.aki == null) {
            return false;
        }
        if (this.akl == null) {
            return true;
        }
        return this.akl.width() <= 0 || this.akl.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wf()) {
            int[] iArr = new int[2];
            if (this.aki != null) {
                this.aki.getLocationOnScreen(iArr);
                this.akl = new Rect(iArr[0], iArr[1], iArr[0] + this.aki.getWidth(), iArr[1] + this.aki.getHeight());
            }
        }
        return this.akl;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.akj != null) {
            this.akj.setEnabled(z);
            this.akj.setClickable(z);
            this.akj.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.akj = view;
    }
}
