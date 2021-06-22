package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class ScrollBridgeWebview extends BridgeWebView {

    /* renamed from: e  reason: collision with root package name */
    public a f12273e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12274f;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, int i3, int i4, int i5);

        void b(int i2, int i3, int i4, int i5);

        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.f12274f = false;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.f12273e != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.f12273e.b(i2, i3, i4, i5);
            } else if (getScrollY() == 0) {
                this.f12273e.a(i2, i3, i4, i5);
            } else {
                this.f12273e.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.f12274f) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.f12274f = z;
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f12273e = aVar;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12274f = false;
    }
}
