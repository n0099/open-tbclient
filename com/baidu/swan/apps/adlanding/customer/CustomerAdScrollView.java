package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes8.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cBN;
    private boolean cBO;
    private float cBP;
    private a cBQ;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cBN = false;
        this.cBO = false;
        this.cBQ = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cBP = y;
                break;
            case 2:
                if (y - this.cBP < 0.0f) {
                    if (!this.cBN || this.cBO) {
                        return false;
                    }
                } else if (!this.cBO) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cBQ != null) {
            this.cBQ.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cBQ = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cBN = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cBO = z;
    }
}
