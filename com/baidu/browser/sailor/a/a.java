package com.baidu.browser.sailor.a;

import com.baidu.browser.sailor.a.n;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public abstract class a implements n.a {
    private WebView mWebView;

    public void a(WebView webView) {
        this.mWebView = webView;
    }

    @Deprecated
    public abstract void addWz(String str);

    @Deprecated
    public abstract void addseniorWz(String str, String str2);

    public abstract void consult(String str, String str2);

    @Deprecated
    public abstract void deleteWz(String str, String str2);

    public abstract void follow(String str, String str2);

    public abstract void invokeWz(String str, String str2);

    @Deprecated
    public abstract int queryWzStatus(String str);

    public abstract void queryZhidaStatus(String str, String str2);
}
