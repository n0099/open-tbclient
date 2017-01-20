package com.baidu.tbadk.core.d;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class f extends BaseWebView {
    protected WebChromeClient chromeClient;
    protected WebViewClient webViewClient;

    public f(Context context) {
        super(context);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.chromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }
}
