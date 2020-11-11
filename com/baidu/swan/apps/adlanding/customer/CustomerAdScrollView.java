package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes10.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cwB;
    private boolean cwC;
    private float cwD;
    private a cwE;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cwB = false;
        this.cwC = false;
        this.cwE = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cwD = y;
                break;
            case 2:
                if (y - this.cwD < 0.0f) {
                    if (!this.cwB || this.cwC) {
                        return false;
                    }
                } else if (!this.cwC) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cwE != null) {
            this.cwE.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cwE = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cwB = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cwC = z;
    }
}
