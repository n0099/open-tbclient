package com.baidu.swan.apps.adlanding.customer;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
/* loaded from: classes7.dex */
public class CustomerAdScrollView extends ScrollView {
    private boolean bOm;
    private boolean bOn;
    private a bOo;
    private float mDownY;

    public CustomerAdScrollView(Context context) {
        super(context);
        this.bOm = false;
        this.bOn = false;
        this.bOo = null;
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
                    if (!this.bOm || this.bOn) {
                        return false;
                    }
                } else if (!this.bOn) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bOo != null) {
            this.bOo.onScrollChanged(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.bOo = aVar;
    }

    public void setIsWebViewOnBottom(boolean z) {
        this.bOm = z;
    }

    public void setIsFooterLayoutShow(boolean z) {
        this.bOn = z;
    }
}
