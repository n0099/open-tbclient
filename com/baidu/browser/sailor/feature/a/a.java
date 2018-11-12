package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.browser.sailor.a.a VQ;

    public a(WebView webView, com.baidu.browser.sailor.a.a aVar) {
        this.VQ = aVar;
        aVar.a(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.VQ.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.VQ.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.VQ.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.VQ.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.VQ.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.VQ.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.VQ.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.VQ.queryZhidaStatus(str, str2);
    }
}
