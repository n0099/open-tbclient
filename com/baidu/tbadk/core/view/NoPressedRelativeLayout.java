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
    private View aks;
    private View akt;
    float aku;
    private Rect akv;
    private boolean akw;
    private a akx;
    private boolean aky;

    /* loaded from: classes.dex */
    public interface a {
        void j(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.akx = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HJ = 0.0f;
        this.HP = 0;
        this.aku = 0.0f;
        this.akw = false;
        this.aky = false;
        this.HP = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.akx != null) {
            this.akx.j(motionEvent);
        }
        if (this.aks != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.HJ = motionEvent.getRawY();
                    this.aku = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.akw = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.akw = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.akw && Math.abs(this.HJ - motionEvent.getRawY()) < this.HP && this.aku < this.HP && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.aks.isClickable()) {
                            this.aks.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.aku = this.aku > Math.abs(this.HJ - motionEvent.getRawY()) ? this.aku : Math.abs(this.HJ - motionEvent.getRawY());
                    if (this.akw && this.aku < this.HP) {
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
        if (this.aky) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.aky = z;
    }

    public void setTopOrderView(View view) {
        this.aks = view;
    }

    private boolean wi() {
        if (this.aks == null) {
            return false;
        }
        if (this.akv == null) {
            return true;
        }
        return this.akv.width() <= 0 || this.akv.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (wi()) {
            int[] iArr = new int[2];
            if (this.aks != null) {
                this.aks.getLocationOnScreen(iArr);
                this.akv = new Rect(iArr[0], iArr[1], iArr[0] + this.aks.getWidth(), iArr[1] + this.aks.getHeight());
            }
        }
        return this.akv;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.akt != null) {
            this.akt.setEnabled(z);
            this.akt.setClickable(z);
            this.akt.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.akt = view;
    }
}
