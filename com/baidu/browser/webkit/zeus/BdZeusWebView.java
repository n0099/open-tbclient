package com.baidu.browser.webkit.zeus;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.zeus.WebView;
/* loaded from: classes.dex */
public class BdZeusWebView extends WebView implements BdNoProGuard {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdZeusWebView";
    private BdWebView mWebView;

    public BdZeusWebView(BdWebView bdWebView, Context context) {
        super(context);
        onInit(bdWebView, context);
    }

    public BdZeusWebView(BdWebView bdWebView, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        onInit(bdWebView, context);
    }

    public BdZeusWebView(BdWebView bdWebView, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        onInit(bdWebView, context);
    }

    public void onInit(BdWebView bdWebView, Context context) {
        setTag(bdWebView);
        this.mWebView = bdWebView;
    }

    public boolean superPerformLongClick() {
        return super.performLongClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.zeus.WebView, android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return this.mWebView.drawChild(canvas, view, j);
    }

    public boolean superDrawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    @Override // com.baidu.zeus.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mWebView.onTouchEvent(motionEvent);
    }

    public boolean superOnTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.zeus.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mWebView.onScrollChanged(i, i2, i3, i4);
    }

    public void superOnScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
