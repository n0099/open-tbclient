package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes25.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cBJ;
    private boolean cBK;
    private float cBL;
    private a cBM;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cBJ = false;
        this.cBK = false;
        this.cBM = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cBL = y;
                break;
            case 2:
                if (y - this.cBL < 0.0f) {
                    if (!this.cBJ || this.cBK) {
                        return false;
                    }
                } else if (!this.cBK) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cBM != null) {
            this.cBM.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cBM = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cBJ = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cBK = z;
    }
}
