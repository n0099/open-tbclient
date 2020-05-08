package com.baidu.sapi2.utils;

import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f extends WebViewClient {
    final /* synthetic */ WebView a;
    final /* synthetic */ String b;
    final /* synthetic */ com.baidu.sapi2.callback.a.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WebView webView, String str, com.baidu.sapi2.callback.a.a aVar) {
        this.a = webView;
        this.b = str;
        this.c = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.evaluateJavascript(this.b, new e(this));
            return;
        }
        this.c.a(null);
        this.a.destroy();
    }
}
