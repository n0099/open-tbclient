package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class ScrollBridgeWebview extends f {
    private a adu;
    private boolean adv;

    /* loaded from: classes.dex */
    public interface a {
        void d(int i, int i2, int i3, int i4);

        void e(int i, int i2, int i3, int i4);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.adv = false;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adv = false;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.adu != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.adu.d(i, i2, i3, i4);
            } else if (getScrollY() == 0) {
                this.adu.e(i, i2, i3, i4);
            } else {
                this.adu.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public void setOnScrollChangeListener(a aVar) {
        this.adu = aVar;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.adv) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.adv = z;
    }
}
