package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes3.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean bVO;
    private boolean bVP;
    private float bVQ;
    private a bVR;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.bVO = false;
        this.bVP = false;
        this.bVR = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.bVQ = y;
                break;
            case 2:
                if (y - this.bVQ < 0.0f) {
                    if (!this.bVO || this.bVP) {
                        return false;
                    }
                } else if (!this.bVP) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bVR != null) {
            this.bVR.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.bVR = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.bVO = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.bVP = z;
    }
}
