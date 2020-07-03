package com.baidu.browser.sailor.lightapp;

import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
class a implements Runnable {
    final /* synthetic */ BdLightappActionClient adl;
    final /* synthetic */ String val$callback;
    final /* synthetic */ String val$result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdLightappActionClient bdLightappActionClient, String str, String str2) {
        this.adl = bdLightappActionClient;
        this.val$callback = str;
        this.val$result = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebView webView;
        WebView webView2;
        String format = String.format("javascript:%s(%s);", this.val$callback, this.val$result);
        webView = this.adl.mWebView;
        if (webView == null) {
            Log.w("BdLightappActionClient", "webview is null");
            return;
        }
        webView2 = this.adl.mWebView;
        webView2.loadUrl(format);
        Log.d("BdLightappActionClient", "load js:" + format);
    }
}
