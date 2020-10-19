package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes10.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean cic;
    private boolean cie;
    private float cif;
    private a cig;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.cic = false;
        this.cie = false;
        this.cig = null;
        setVerticalScrollBarEnabled(false);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.cif = y;
                break;
            case 2:
                if (y - this.cif < 0.0f) {
                    if (!this.cic || this.cie) {
                        return false;
                    }
                } else if (!this.cie) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.cig != null) {
            this.cig.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.cig = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.cic = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.cie = z;
    }
}
