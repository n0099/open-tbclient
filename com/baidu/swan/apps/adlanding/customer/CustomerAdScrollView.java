package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes7.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cuR;
    private boolean cuS;
    private float cuT;
    private a cuU;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cuR = false;
        this.cuS = false;
        this.cuU = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cuT = y;
                break;
            case 2:
                if (y - this.cuT < 0.0f) {
                    if (!this.cuR || this.cuS) {
                        return false;
                    }
                } else if (!this.cuS) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cuU != null) {
            this.cuU.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cuU = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cuR = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cuS = z;
    }
}
