package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.alipay.sdk.widget.WebViewWindow;
/* loaded from: classes.dex */
public class s extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewWindow f2037a;

    public s(WebViewWindow webViewWindow) {
        this.f2037a = webViewWindow;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        WebViewWindow.a aVar;
        aVar = this.f2037a.f1994g;
        return aVar.a(this.f2037a, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        if (i2 == 100) {
            progressBar4 = this.f2037a.f1992d;
            progressBar4.setVisibility(4);
            return;
        }
        progressBar = this.f2037a.f1992d;
        if (4 == progressBar.getVisibility()) {
            progressBar3 = this.f2037a.f1992d;
            progressBar3.setVisibility(0);
        }
        progressBar2 = this.f2037a.f1992d;
        progressBar2.setProgress(i2);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        WebViewWindow.a aVar;
        aVar = this.f2037a.f1994g;
        aVar.a(this.f2037a, str);
    }
}
