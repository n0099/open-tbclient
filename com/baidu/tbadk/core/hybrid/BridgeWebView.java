package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes2.dex */
public class BridgeWebView extends BaseWebView {
    protected WebChromeClient chromeClient;
    protected WebViewClient webViewClient;

    public BridgeWebView(Context context) {
        super(context);
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.chromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }
}
