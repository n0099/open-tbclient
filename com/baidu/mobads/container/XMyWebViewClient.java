package com.baidu.mobads.container;

import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes2.dex */
public class XMyWebViewClient extends WebViewClient {
    private void myLoadUrl(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        myLoadUrl(webView, str);
        return true;
    }
}
