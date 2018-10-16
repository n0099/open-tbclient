package com.baidu.browser.sailor.feature.a;

import android.webkit.JavascriptInterface;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class a {
    private com.baidu.browser.sailor.a.a VO;

    public a(WebView webView, com.baidu.browser.sailor.a.a aVar) {
        this.VO = aVar;
        aVar.a(webView);
    }

    @JavascriptInterface
    public final synchronized void addWz(String str) {
        this.VO.addWz(str);
    }

    @JavascriptInterface
    public final synchronized void addseniorWz(String str, String str2) {
        this.VO.addseniorWz(str, str2);
    }

    @JavascriptInterface
    public final void consult(String str, String str2) {
        this.VO.consult(str, str2);
    }

    @JavascriptInterface
    public final synchronized void deleteWz(String str, String str2) {
        this.VO.deleteWz(str, str2);
    }

    @JavascriptInterface
    public final void follow(String str, String str2) {
        this.VO.follow(str, str2);
    }

    @JavascriptInterface
    public final synchronized void invokeWz(String str, String str2) {
        this.VO.invokeWz(str, str2);
    }

    @JavascriptInterface
    public final synchronized int queryWzStatus(String str) {
        return this.VO.queryWzStatus(str);
    }

    @JavascriptInterface
    public final void queryZhidaStatus(String str, String str2) {
        this.VO.queryZhidaStatus(str, str2);
    }
}
