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
    private View avU;
    private View avV;
    float avW;
    private Rect avX;
    private boolean avY;
    private a avZ;
    private boolean awa;

    /* loaded from: classes.dex */
    public interface a {
        void q(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.avZ = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lt = 0.0f;
        this.Lz = 0;
        this.avW = 0.0f;
        this.avY = false;
        this.awa = false;
        this.Lz = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.avZ != null) {
            this.avZ.q(motionEvent);
        }
        if (this.avU != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.Lt = motionEvent.getRawY();
                    this.avW = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.avY = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.avY = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.avY && Math.abs(this.Lt - motionEvent.getRawY()) < this.Lz && this.avW < this.Lz && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.avU.isClickable()) {
                            this.avU.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.avW = this.avW > Math.abs(this.Lt - motionEvent.getRawY()) ? this.avW : Math.abs(this.Lt - motionEvent.getRawY());
                    if (this.avY && this.avW < this.Lz) {
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
        if (this.awa) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.awa = z;
    }

    public void setTopOrderView(View view) {
        this.avU = view;
    }

    private boolean As() {
        if (this.avU == null) {
            return false;
        }
        if (this.avX == null) {
            return true;
        }
        return this.avX.width() <= 0 || this.avX.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (As()) {
            int[] iArr = {0, 0};
            if (this.avU != null) {
                this.avU.getLocationOnScreen(iArr);
                this.avX = new Rect(iArr[0], iArr[1], iArr[0] + this.avU.getWidth(), iArr[1] + this.avU.getHeight());
            }
        }
        return this.avX;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.avV != null) {
            this.avV.setEnabled(z);
            this.avV.setClickable(z);
            this.avV.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.avV = view;
    }
}
