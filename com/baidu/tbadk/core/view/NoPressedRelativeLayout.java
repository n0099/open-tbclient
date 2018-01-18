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
    float auQ;
    int auW;
    private View ban;
    private View bao;
    float bap;
    private Rect baq;
    private boolean bas;
    private a bat;
    private boolean bau;

    /* loaded from: classes.dex */
    public interface a {
        void s(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bat = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auQ = 0.0f;
        this.auW = 0;
        this.bap = 0.0f;
        this.bas = false;
        this.bau = false;
        this.auW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bat != null) {
            this.bat.s(motionEvent);
        }
        if (this.ban != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.auQ = motionEvent.getRawY();
                    this.bap = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bas = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bas = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bas && Math.abs(this.auQ - motionEvent.getRawY()) < this.auW && this.bap < this.auW && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.ban.isClickable()) {
                            this.ban.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.bap = this.bap > Math.abs(this.auQ - motionEvent.getRawY()) ? this.bap : Math.abs(this.auQ - motionEvent.getRawY());
                    if (this.bas && this.bap < this.auW) {
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
        if (this.bau) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bau = z;
    }

    public void setTopOrderView(View view) {
        this.ban = view;
    }

    private boolean DF() {
        if (this.ban == null) {
            return false;
        }
        if (this.baq == null) {
            return true;
        }
        return this.baq.width() <= 0 || this.baq.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (DF()) {
            int[] iArr = {0, 0};
            if (this.ban != null) {
                this.ban.getLocationOnScreen(iArr);
                this.baq = new Rect(iArr[0], iArr[1], iArr[0] + this.ban.getWidth(), iArr[1] + this.ban.getHeight());
            }
        }
        return this.baq;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bao != null) {
            this.bao.setEnabled(z);
            this.bao.setClickable(z);
            this.bao.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bao = view;
    }
}
