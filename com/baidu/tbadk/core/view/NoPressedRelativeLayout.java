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
    private View acT;
    private View acU;
    float acV;
    private Rect acW;
    private boolean acX;
    private a acY;
    private boolean acZ;
    float yV;
    int zb;

    /* loaded from: classes.dex */
    public interface a {
        void d(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.acY = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yV = 0.0f;
        this.zb = 0;
        this.acV = 0.0f;
        this.acX = false;
        this.acZ = false;
        this.zb = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.acY != null) {
            this.acY.d(motionEvent);
        }
        if (this.acT != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.yV = motionEvent.getRawY();
                    this.acV = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.acX = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.acX = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.acX && Math.abs(this.yV - motionEvent.getRawY()) < this.zb && this.acV < this.zb && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.acT.isClickable()) {
                            this.acT.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.acV = this.acV > Math.abs(this.yV - motionEvent.getRawY()) ? this.acV : Math.abs(this.yV - motionEvent.getRawY());
                    if (this.acX && this.acV < this.zb) {
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
        if (this.acZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.acZ = z;
    }

    public void setTopOrderView(View view) {
        this.acT = view;
    }

    private boolean uZ() {
        if (this.acT == null) {
            return false;
        }
        if (this.acW == null) {
            return true;
        }
        return this.acW.width() <= 0 || this.acW.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (uZ()) {
            int[] iArr = new int[2];
            if (this.acT != null) {
                this.acT.getLocationOnScreen(iArr);
                this.acW = new Rect(iArr[0], iArr[1], iArr[0] + this.acT.getWidth(), iArr[1] + this.acT.getHeight());
            }
        }
        return this.acW;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.acU != null) {
            this.acU.setEnabled(z);
            this.acU.setClickable(z);
            this.acU.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.acU = view;
    }
}
