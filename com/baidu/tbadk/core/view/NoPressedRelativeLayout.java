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
    float HJ;
    int HP;
    private View akV;
    private View akW;
    float akX;
    private Rect akY;
    private boolean akZ;
    private a ala;
    private boolean alb;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.ala = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HJ = 0.0f;
        this.HP = 0;
        this.akX = 0.0f;
        this.akZ = false;
        this.alb = false;
        this.HP = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ala != null) {
            this.ala.j(motionEvent);
        }
        if (this.akV != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.HJ = motionEvent.getRawY();
                    this.akX = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.akZ = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.akZ = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.akZ && Math.abs(this.HJ - motionEvent.getRawY()) < this.HP && this.akX < this.HP && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.akV.isClickable()) {
                            this.akV.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.akX = this.akX > Math.abs(this.HJ - motionEvent.getRawY()) ? this.akX : Math.abs(this.HJ - motionEvent.getRawY());
                    if (this.akZ && this.akX < this.HP) {
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
        if (this.alb) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.alb = z;
    }

    public void setTopOrderView(View view) {
        this.akV = view;
    }

    private boolean wV() {
        if (this.akV == null) {
            return false;
        }
        if (this.akY == null) {
            return true;
        }
        return this.akY.width() <= 0 || this.akY.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wV()) {
            int[] iArr = new int[2];
            if (this.akV != null) {
                this.akV.getLocationOnScreen(iArr);
                this.akY = new Rect(iArr[0], iArr[1], iArr[0] + this.akV.getWidth(), iArr[1] + this.akV.getHeight());
            }
        }
        return this.akY;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.akW != null) {
            this.akW.setEnabled(z);
            this.akW.setClickable(z);
            this.akW.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.akW = view;
    }
}
