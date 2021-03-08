package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes8.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cFJ;
    private boolean cFK;
    private float cFL;
    private a cFM;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cFJ = false;
        this.cFK = false;
        this.cFM = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cFL = y;
                break;
            case 2:
                if (y - this.cFL < 0.0f) {
                    if (!this.cFJ || this.cFK) {
                        return false;
                    }
                } else if (!this.cFK) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cFM != null) {
            this.cFM.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cFM = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cFJ = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cFK = z;
    }
}
