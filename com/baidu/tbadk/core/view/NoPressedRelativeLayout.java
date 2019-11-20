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
    private View coD;
    private View coE;
    float coF;
    private Rect coG;
    private boolean coH;
    private a coI;
    private boolean coJ;
    float startY;
    int touchSlop;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.coI = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startY = 0.0f;
        this.touchSlop = 0;
        this.coF = 0.0f;
        this.coH = false;
        this.coJ = false;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.coI != null) {
            this.coI.q(motionEvent);
        }
        if (this.coD != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.startY = motionEvent.getRawY();
                    this.coF = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.coH = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.coH = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.coH && Math.abs(this.startY - motionEvent.getRawY()) < this.touchSlop && this.coF < this.touchSlop && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.coD.isClickable()) {
                            this.coD.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.coF = this.coF > Math.abs(this.startY - motionEvent.getRawY()) ? this.coF : Math.abs(this.startY - motionEvent.getRawY());
                    if (this.coH && this.coF < this.touchSlop) {
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
        if (this.coJ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.coJ = z;
    }

    public void setTopOrderView(View view) {
        this.coD = view;
    }

    private boolean anI() {
        if (this.coD == null) {
            return false;
        }
        if (this.coG == null) {
            return true;
        }
        return this.coG.width() <= 0 || this.coG.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (anI()) {
            int[] iArr = {0, 0};
            if (this.coD != null) {
                this.coD.getLocationOnScreen(iArr);
                this.coG = new Rect(iArr[0], iArr[1], iArr[0] + this.coD.getWidth(), iArr[1] + this.coD.getHeight());
            }
        }
        return this.coG;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.coE != null) {
            this.coE.setEnabled(z);
            this.coE.setClickable(z);
            this.coE.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.coE = view;
    }
}
