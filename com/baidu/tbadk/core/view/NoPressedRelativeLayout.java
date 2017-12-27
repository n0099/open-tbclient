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
    float auR;
    int auX;
    private View bao;
    private View bap;
    float baq;
    private Rect bas;
    private boolean bat;
    private a bau;
    private boolean bav;

    /* loaded from: classes.dex */
    public interface a {
        void s(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.bau = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auR = 0.0f;
        this.auX = 0;
        this.baq = 0.0f;
        this.bat = false;
        this.bav = false;
        this.auX = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.bau != null) {
            this.bau.s(motionEvent);
        }
        if (this.bao != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.auR = motionEvent.getRawY();
                    this.baq = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.bat = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.bat = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.bat && Math.abs(this.auR - motionEvent.getRawY()) < this.auX && this.baq < this.auX && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.bao.isClickable()) {
                            this.bao.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.baq = this.baq > Math.abs(this.auR - motionEvent.getRawY()) ? this.baq : Math.abs(this.auR - motionEvent.getRawY());
                    if (this.bat && this.baq < this.auX) {
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
        if (this.bav) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.bav = z;
    }

    public void setTopOrderView(View view) {
        this.bao = view;
    }

    private boolean DO() {
        if (this.bao == null) {
            return false;
        }
        if (this.bas == null) {
            return true;
        }
        return this.bas.width() <= 0 || this.bas.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (DO()) {
            int[] iArr = {0, 0};
            if (this.bao != null) {
                this.bao.getLocationOnScreen(iArr);
                this.bas = new Rect(iArr[0], iArr[1], iArr[0] + this.bao.getWidth(), iArr[1] + this.bao.getHeight());
            }
        }
        return this.bas;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.bap != null) {
            this.bap.setEnabled(z);
            this.bap.setClickable(z);
            this.bap.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.bap = view;
    }
}
