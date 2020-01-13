package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.lightapp.BdLightappActionClient;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes10.dex */
public final class a {
    private BdLightappActionClient IE;

    public a(WebView webView, BdLightappActionClient bdLightappActionClient) {
        this.IE = bdLightappActionClient;
        bdLightappActionClient.setCurrentWebiew(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.IE.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.IE.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.IE.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.IE.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.IE.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.IE.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.IE.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.IE.queryZhidaStatus(str, str2);
    }
}
