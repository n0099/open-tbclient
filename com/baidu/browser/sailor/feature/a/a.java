package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.lightapp.BdLightappActionClient;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
public final class a {
    private BdLightappActionClient adi;

    public a(WebView webView, BdLightappActionClient bdLightappActionClient) {
        this.adi = bdLightappActionClient;
        bdLightappActionClient.setCurrentWebiew(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.adi.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.adi.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.adi.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.adi.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.adi.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.adi.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.adi.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.adi.queryZhidaStatus(str, str2);
    }
}
