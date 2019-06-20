package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ScrollBridgeWebview extends BridgeWebView {
    private a bOA;
    private boolean bOB;

    /* loaded from: classes.dex */
    public interface a {
        void h(int i, int i2, int i3, int i4);

        void i(int i, int i2, int i3, int i4);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.bOB = false;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOB = false;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bOA != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.bOA.h(i, i2, i3, i4);
            } else if (getScrollY() == 0) {
                this.bOA.i(i, i2, i3, i4);
            } else {
                this.bOA.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.bOA = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.bOB) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.bOB = z;
    }
}
