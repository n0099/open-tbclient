package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes11.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean bNw;
    private boolean bNx;
    private a bNy;
    private float mDownY;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.bNw = false;
        this.bNx = false;
        this.bNy = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownY = y;
                break;
            case 2:
                if (y - this.mDownY < 0.0f) {
                    if (!this.bNw || this.bNx) {
                        return false;
                    }
                } else if (!this.bNx) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bNy != null) {
            this.bNy.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.bNy = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.bNw = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.bNx = z;
    }
}
