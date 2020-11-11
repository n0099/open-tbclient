package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ScrollBridgeWebview extends BridgeWebView {
    private a eKo;
    private boolean eKp;

    /* loaded from: classes.dex */
    public interface a {
        void onScrollChanged(int i, int i2, int i3, int i4);

        void p(int i, int i2, int i3, int i4);

        void q(int i, int i2, int i3, int i4);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.eKp = false;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eKp = false;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.eKo != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.eKo.p(i, i2, i3, i4);
            } else if (getScrollY() == 0) {
                this.eKo.q(i, i2, i3, i4);
            } else {
                this.eKo.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.eKo = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.eKp) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.eKp = z;
    }
}
