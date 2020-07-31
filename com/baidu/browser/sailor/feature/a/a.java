package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.browser.sailor.lightapp.BdLightappActionClient;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes8.dex */
public final class a {
    private BdLightappActionClient adb;

    public a(WebView webView, BdLightappActionClient bdLightappActionClient) {
        this.adb = bdLightappActionClient;
        bdLightappActionClient.setCurrentWebiew(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.adb.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.adb.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.adb.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.adb.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.adb.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.adb.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.adb.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.adb.queryZhidaStatus(str, str2);
    }
}
