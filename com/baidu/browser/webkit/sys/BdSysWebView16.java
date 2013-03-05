package com.baidu.browser.webkit.sys;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdSysWebView16 extends BdSysWebView {
    public BdSysWebView16(BdWebView bdWebView, Context context) {
        super(bdWebView, context);
    }

    public BdSysWebView16(BdWebView bdWebView, Context context, AttributeSet attributeSet) {
        super(bdWebView, context, attributeSet);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebView
    public void setDisplayZoomControls(boolean z) {
        getSettings().setDisplayZoomControls(z);
    }

    @Override // com.baidu.browser.webkit.sys.BdSysWebView, android.webkit.WebView
    public void setFindIsUp(boolean z) {
        reflectSetFindIsUp(z);
    }
}
