package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ScrollBridgeWebview extends BridgeWebView {
    private a amQ;
    private boolean amR;

    /* loaded from: classes.dex */
    public interface a {
        void d(int i, int i2, int i3, int i4);

        void e(int i, int i2, int i3, int i4);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.amR = false;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amR = false;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.amQ != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.amQ.d(i, i2, i3, i4);
            } else if (getScrollY() == 0) {
                this.amQ.e(i, i2, i3, i4);
            } else {
                this.amQ.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.amQ = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.amR) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.amR = z;
    }
}
