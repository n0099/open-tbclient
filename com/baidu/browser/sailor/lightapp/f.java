package com.baidu.browser.sailor.lightapp;

import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
class f implements Runnable {
    final /* synthetic */ BdLightappKernelClient acL;
    final /* synthetic */ String val$callback;
    final /* synthetic */ String val$result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BdLightappKernelClient bdLightappKernelClient, String str, String str2) {
        this.acL = bdLightappKernelClient;
        this.val$callback = str;
        this.val$result = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebView webView;
        WebView webView2;
        String format = String.format("javascript:%s(%s);", this.val$callback, this.val$result);
        webView = this.acL.mWebView;
        if (webView == null) {
            Log.w("BdLightappKernelClient", "webview is null");
            return;
        }
        webView2 = this.acL.mWebView;
        webView2.loadUrl(format);
        Log.d("BdLightappKernelClient", "load js:" + format);
    }
}
