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
    private View acj;
    private View ack;
    float acl;
    private Rect acm;
    private boolean acn;
    private a aco;
    private boolean acp;
    int yA;
    float yu;

    /* loaded from: classes.dex */
    public interface a {
        void d(MotionEvent motionEvent);
    }

    public void setDispathEventAction(a aVar) {
        this.aco = aVar;
    }

    public NoPressedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yu = 0.0f;
        this.yA = 0;
        this.acl = 0.0f;
        this.acn = false;
        this.acp = false;
        this.yA = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aco != null) {
            this.aco.d(motionEvent);
        }
        if (this.acj != null) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.yu = motionEvent.getRawY();
                    this.acl = 0.0f;
                    if (getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.acn = true;
                        setBottomViewClickEventEnabled(false);
                    } else {
                        this.acn = false;
                        setBottomViewClickEventEnabled(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                case 1:
                case 3:
                    if (this.acn && Math.abs(this.yu - motionEvent.getRawY()) < this.yA && this.acl < this.yA && getTopViewRect() != null && getTopViewRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        setBottomViewClickEventEnabled(false);
                        if (this.acj.isClickable()) {
                            this.acj.performClick();
                        }
                        return true;
                    }
                    break;
                case 2:
                    this.acl = this.acl > Math.abs(this.yu - motionEvent.getRawY()) ? this.acl : Math.abs(this.yu - motionEvent.getRawY());
                    if (this.acn && this.acl < this.yA) {
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
        if (this.acp) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setNeedInterceptTouchEvent(boolean z) {
        this.acp = z;
    }

    public void setTopOrderView(View view) {
        this.acj = view;
    }

    private boolean uZ() {
        if (this.acj == null) {
            return false;
        }
        if (this.acm == null) {
            return true;
        }
        return this.acm.width() <= 0 || this.acm.height() <= 0;
    }

    private Rect getTopViewRect() {
        if (uZ()) {
            int[] iArr = new int[2];
            if (this.acj != null) {
                this.acj.getLocationOnScreen(iArr);
                this.acm = new Rect(iArr[0], iArr[1], iArr[0] + this.acj.getWidth(), iArr[1] + this.acj.getHeight());
            }
        }
        return this.acm;
    }

    private void setBottomViewClickEventEnabled(boolean z) {
        if (this.ack != null) {
            this.ack.setEnabled(z);
            this.ack.setClickable(z);
            this.ack.setLongClickable(z);
        }
    }

    public void setBottomOrderView(View view) {
        this.ack = view;
    }
}
