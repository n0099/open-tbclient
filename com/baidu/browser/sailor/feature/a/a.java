package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.browser.sailor.a.a VZ;

    public a(WebView webView, com.baidu.browser.sailor.a.a aVar) {
        this.VZ = aVar;
        aVar.a(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.VZ.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.VZ.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.VZ.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.VZ.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.VZ.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.VZ.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.VZ.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.VZ.queryZhidaStatus(str, str2);
    }
}
