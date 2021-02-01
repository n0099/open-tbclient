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
    private View fie;
    private View fif;
    float fig;
    private Rect fih;
    private boolean fii;
    private a fij;
    private boolean fik;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void E(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.fij = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.fig = 0.0f;
        this.fii = false;
        this.fik = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.fij != null) {
            this.fij.E(motionEvent);
        }
        if (this.fie != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.fig = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.fii = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.fii = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.fii && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.fig < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.fie.isClickable()) {
                            this.fie.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.fig = this.fig > Math.abs(this.startY - motionEvent.getRawY()) ? this.fig : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.fii && this.fig < this.touchSlop) {
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
        if (this.fik) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.fik = z;
    }

    public void setTopOrderView(View view) {
        this.fie = view;
    }

    private boolean buc() {
        if (this.fie == null) {
            return false;
        }
        if (this.fih == null) {
            return true;
        }
        return this.fih.width() <= 0 || this.fih.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (buc()) {
            int[] iArr = {0, 0};
            if (this.fie != null) {
                this.fie.getLocationOnScreen(iArr);
                this.fih = new Rect(iArr[0], iArr[1], iArr[0] + this.fie.getWidth(), iArr[1] + this.fie.getHeight());
            }
        }
        return this.fih;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.fif != null) {
            this.fif.setEnabled(z);
            this.fif.setClickable(z);
            this.fif.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.fif = view;
    }
}
