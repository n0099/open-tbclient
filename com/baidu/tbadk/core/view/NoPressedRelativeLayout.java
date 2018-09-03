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
    float Lt;
    int Lz;
    private View avS;
    private View avT;
    float avU;
    private Rect avV;
    private boolean avW;
    private a avX;
    private boolean avY;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.avX = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lt = 0.0f;
        this.Lz = 0;
        this.avU = 0.0f;
        this.avW = false;
        this.avY = false;
        this.Lz = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.avX != null) {
            this.avX.q(motionEvent);
        }
        if (this.avS != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Lt = motionEvent.getRawY();
                    this.avU = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.avW = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.avW = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.avW && Math.abs(this.Lt - motionEvent.getRawY()) < this.Lz && this.avU < this.Lz && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.avS.isClickable()) {
                            this.avS.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.avU = this.avU > Math.abs(this.Lt - motionEvent.getRawY()) ? this.avU : Math.abs(this.Lt - motionEvent.getRawY());
                    if (this.avW && this.avU < this.Lz) {
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
        if (this.avY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.avY = z;
    }

    public void setTopOrderView(View view) {
        this.avS = view;
    }

    private boolean Aq() {
        if (this.avS == null) {
            return false;
        }
        if (this.avV == null) {
            return true;
        }
        return this.avV.width() <= 0 || this.avV.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (Aq()) {
            int[] iArr = {0, 0};
            if (this.avS != null) {
                this.avS.getLocationOnScreen(iArr);
                this.avV = new Rect(iArr[0], iArr[1], iArr[0] + this.avS.getWidth(), iArr[1] + this.avS.getHeight());
            }
        }
        return this.avV;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.avT != null) {
            this.avT.setEnabled(z);
            this.avT.setClickable(z);
            this.avT.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.avT = view;
    }
}
