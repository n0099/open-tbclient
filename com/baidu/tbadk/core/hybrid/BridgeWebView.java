package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes3.dex */
public class BridgeWebView extends BaseWebView {
    public WebChromeClient chromeClient;
    public WebViewClient webViewClient;

    public BridgeWebView(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.chromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView, android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.webViewClient = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
