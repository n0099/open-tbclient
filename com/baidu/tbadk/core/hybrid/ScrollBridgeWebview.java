package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ScrollBridgeWebview extends BridgeWebView {
    private a dXT;
    private boolean dXU;

    /* loaded from: classes.dex */
    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);

        void p(int i, int i2, int i3, int i4);

        void q(int i, int i2, int i3, int i4);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.dXU = false;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXU = false;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.dXT != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.dXT.p(i, i2, i3, i4);
            } else if (getScrollY() == 0) {
                this.dXT.q(i, i2, i3, i4);
            } else {
                this.dXT.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.dXT = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.dXU) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.dXU = z;
    }
}
