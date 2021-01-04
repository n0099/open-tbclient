package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes9.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cGA;
    private float cGB;
    private a cGC;
    private boolean cGz;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cGz = false;
        this.cGA = false;
        this.cGC = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cGB = y;
                break;
            case 2:
                if (y - this.cGB < 0.0f) {
                    if (!this.cGz || this.cGA) {
                        return false;
                    }
                } else if (!this.cGA) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cGC != null) {
            this.cGC.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cGC = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cGz = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cGA = z;
    }
}
