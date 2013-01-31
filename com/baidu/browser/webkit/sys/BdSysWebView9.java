package com.baidu.browser.webkit.sys;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdSysWebView9 extends BdSysWebView {
    public BdSysWebView9(BdWebView bdWebView, Context context) {
        super(bdWebView, context);
    }

    public BdSysWebView9(BdWebView bdWebView, Context context, AttributeSet attributeSet) {
        super(bdWebView, context, attributeSet);
    }

    public BdSysWebView9(BdWebView bdWebView, Context context, AttributeSet attributeSet, int i) {
        super(bdWebView, context, attributeSet, i);
    }

    @Override // android.webkit.WebView
    public final boolean canZoomIn() {
        return reflectGetActualScale() < reflectGetMaxZoomScale();
    }

    @Override // android.webkit.WebView
    public final boolean canZoomOut() {
        return reflectGetActualScale() > reflectGetMinZoomScale() && !reflectGetInZoomOverview();
    }
}
