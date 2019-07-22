package com.baidu.swan.apps.core.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.b.c.d;
/* loaded from: classes2.dex */
public class SystemWebViewImpl extends WebView implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b aqt;
    private c aqu;
    private boolean mDestroyed;

    public SystemWebViewImpl(Context context) {
        super(context);
    }

    public SystemWebViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SystemWebViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.mDestroyed = true;
    }

    @Override // com.baidu.swan.apps.b.c.d
    public AbsoluteLayout getCurrentWebView() {
        return this;
    }

    @Override // com.baidu.swan.apps.b.c.d
    public View xs() {
        return this;
    }

    @Override // com.baidu.swan.apps.b.c.d
    public int getWebViewScrollX() {
        return getScrollX();
    }

    @Override // com.baidu.swan.apps.b.c.d
    public int getWebViewScrollY() {
        return getScrollY();
    }

    @Override // com.baidu.swan.apps.b.c.d
    public void A(int i, int i2) {
        scrollTo(i, i2);
    }

    public void setOnCommonEventHandler(b bVar) {
        this.aqt = bVar;
    }

    public void setOnWebViewHookHandler(c cVar) {
        this.aqu = cVar;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean zq() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    @Override // android.webkit.WebView, com.baidu.swan.apps.b.c.d
    public boolean canGoBack() {
        boolean canGoBack = super.canGoBack();
        if (this.aqu != null) {
            return this.aqu.aY(canGoBack);
        }
        return canGoBack;
    }

    @Override // android.webkit.WebView, com.baidu.swan.apps.b.c.d
    public void goBack() {
        if (this.aqu != null) {
            this.aqu.yS();
        }
        super.goBack();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aqt == null || !this.aqt.onTouchEvent(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.aqt == null || !this.aqt.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        return this.aqt != null && this.aqt.onKeyDown(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.aqt != null) {
            this.aqt.onScrollChanged(i, i2, i3, i4);
        }
    }
}
