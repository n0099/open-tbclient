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
    private b apE;
    private c apF;
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
    public View wa() {
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
    public void z(int i, int i2) {
        scrollTo(i, i2);
    }

    public void setOnCommonEventHandler(b bVar) {
        this.apE = bVar;
    }

    public void setOnWebViewHookHandler(c cVar) {
        this.apF = cVar;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean xR() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.container.a
    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    @Override // android.webkit.WebView, com.baidu.swan.apps.b.c.d
    public boolean canGoBack() {
        boolean canGoBack = super.canGoBack();
        if (this.apF != null) {
            return this.apF.aT(canGoBack);
        }
        return canGoBack;
    }

    @Override // android.webkit.WebView, com.baidu.swan.apps.b.c.d
    public void goBack() {
        if (this.apF != null) {
            this.apF.xv();
        }
        super.goBack();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.apE == null || !this.apE.onTouchEvent(motionEvent)) {
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
        if (this.apE == null || !this.apE.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        return this.apE != null && this.apE.onKeyDown(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.apE != null) {
            this.apE.onScrollChanged(i, i2, i3, i4);
        }
    }
}
