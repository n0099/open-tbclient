package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes8.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean bTK;
    private boolean bTL;
    private a bTM;
    private float mDownY;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.bTK = false;
        this.bTL = false;
        this.bTM = null;
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
                    if (!this.bTK || this.bTL) {
                        return false;
                    }
                } else if (!this.bTL) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bTM != null) {
            this.bTM.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.bTM = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.bTK = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.bTL = z;
    }
}
