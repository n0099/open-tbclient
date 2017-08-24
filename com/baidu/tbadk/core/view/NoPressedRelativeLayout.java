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
    float Jk;
    int Jq;
    private View amU;
    private View amV;
    float amW;
    private Rect amX;
    private boolean amY;
    private a amZ;
    private boolean ana;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.amZ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Jk = 0.0f;
        this.Jq = 0;
        this.amW = 0.0f;
        this.amY = false;
        this.ana = false;
        this.Jq = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.amZ != null) {
            this.amZ.j(motionEvent);
        }
        if (this.amU != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Jk = motionEvent.getRawY();
                    this.amW = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.amY = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.amY = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.amY && Math.abs(this.Jk - motionEvent.getRawY()) < this.Jq && this.amW < this.Jq && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.amU.isClickable()) {
                            this.amU.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.amW = this.amW > Math.abs(this.Jk - motionEvent.getRawY()) ? this.amW : Math.abs(this.Jk - motionEvent.getRawY());
                    if (this.amY && this.amW < this.Jq) {
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
        if (this.ana) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.ana = z;
    }

    public void setTopOrderView(View view) {
        this.amU = view;
    }

    private boolean wR() {
        if (this.amU == null) {
            return false;
        }
        if (this.amX == null) {
            return true;
        }
        return this.amX.width() <= 0 || this.amX.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wR()) {
            int[] iArr = {0, 0};
            if (this.amU != null) {
                this.amU.getLocationOnScreen(iArr);
                this.amX = new Rect(iArr[0], iArr[1], iArr[0] + this.amU.getWidth(), iArr[1] + this.amU.getHeight());
            }
        }
        return this.amX;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.amV != null) {
            this.amV.setEnabled(z);
            this.amV.setClickable(z);
            this.amV.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.amV = view;
    }
}
