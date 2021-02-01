package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes9.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cEj;
    private boolean cEk;
    private float cEl;
    private a cEm;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cEj = false;
        this.cEk = false;
        this.cEm = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cEl = y;
                break;
            case 2:
                if (y - this.cEl < 0.0f) {
                    if (!this.cEj || this.cEk) {
                        return false;
                    }
                } else if (!this.cEk) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cEm != null) {
            this.cEm.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cEm = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cEj = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cEk = z;
    }
}
