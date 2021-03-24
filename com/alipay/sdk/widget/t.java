package com.alipay.sdk.widget;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.widget.WebViewWindow;
/* loaded from: classes.dex */
public class t extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2053a;

    public t(WebViewWindow webViewWindow) {
        this.f2053a = webViewWindow;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        WebViewWindow.b bVar;
        bVar = this.f2053a.f2013h;
        if (bVar.c(this.f2053a, str)) {
            return;
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        WebViewWindow.b bVar;
        bVar = this.f2053a.f2013h;
        if (bVar.a(this.f2053a, i, str, str2)) {
            return;
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewWindow.b bVar;
        bVar = this.f2053a.f2013h;
        if (bVar.a(this.f2053a, sslErrorHandler, sslError)) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewWindow.b bVar;
        bVar = this.f2053a.f2013h;
        if (bVar.b(this.f2053a, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
