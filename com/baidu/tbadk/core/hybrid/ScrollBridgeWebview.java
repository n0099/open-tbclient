package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class ScrollBridgeWebview extends BridgeWebView {

    /* renamed from: e  reason: collision with root package name */
    public a f13291e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13292f;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, int i2, int i3, int i4);

        void b(int i, int i2, int i3, int i4);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    public ScrollBridgeWebview(Context context) {
        super(context);
        this.f13292f = false;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f13291e != null) {
            if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                this.f13291e.b(i, i2, i3, i4);
            } else if (getScrollY() == 0) {
                this.f13291e.a(i, i2, i3, i4);
            } else {
                this.f13291e.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.f13292f) {
            if (motionEvent.getAction() == 0) {
                requestDisallowInterceptTouchEvent(false);
            } else {
                requestDisallowInterceptTouchEvent(true);
            }
        }
        return onTouchEvent;
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        this.f13292f = z;
    }

    public void setOnScrollChangeListener(a aVar) {
        this.f13291e = aVar;
    }

    public ScrollBridgeWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13292f = false;
    }
}
