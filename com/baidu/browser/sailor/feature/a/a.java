package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.lightapp.BdLightappActionClient;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
public final class a {
    private BdLightappActionClient acg;

    public a(WebView webView, BdLightappActionClient bdLightappActionClient) {
        this.acg = bdLightappActionClient;
        bdLightappActionClient.setCurrentWebiew(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.acg.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.acg.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.acg.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.acg.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.acg.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.acg.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.acg.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.acg.queryZhidaStatus(str, str2);
    }
}
