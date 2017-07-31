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
    float Ji;
    int Jo;
    private View amT;
    private View amU;
    float amV;
    private Rect amW;
    private boolean amX;
    private a amY;
    private boolean amZ;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.amY = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ji = 0.0f;
        this.Jo = 0;
        this.amV = 0.0f;
        this.amX = false;
        this.amZ = false;
        this.Jo = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.amY != null) {
            this.amY.j(motionEvent);
        }
        if (this.amT != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Ji = motionEvent.getRawY();
                    this.amV = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.amX = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.amX = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.amX && Math.abs(this.Ji - motionEvent.getRawY()) < this.Jo && this.amV < this.Jo && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.amT.isClickable()) {
                            this.amT.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.amV = this.amV > Math.abs(this.Ji - motionEvent.getRawY()) ? this.amV : Math.abs(this.Ji - motionEvent.getRawY());
                    if (this.amX && this.amV < this.Jo) {
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
        if (this.amZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.amZ = z;
    }

    public void setTopOrderView(View view) {
        this.amT = view;
    }

    private boolean wQ() {
        if (this.amT == null) {
            return false;
        }
        if (this.amW == null) {
            return true;
        }
        return this.amW.width() <= 0 || this.amW.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wQ()) {
            int[] iArr = {0, 0};
            if (this.amT != null) {
                this.amT.getLocationOnScreen(iArr);
                this.amW = new Rect(iArr[0], iArr[1], iArr[0] + this.amT.getWidth(), iArr[1] + this.amT.getHeight());
            }
        }
        return this.amW;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.amU != null) {
            this.amU.setEnabled(z);
            this.amU.setClickable(z);
            this.amU.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.amU = view;
    }
}
