package com.baidu.browser.sailor.lightapp;

import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes11.dex */
public abstract class BdLightappActionClient implements INoProGuard, BdLightappKernelJsCallback.a {
    private static final String TAG = "BdLightappActionClient";
    private WebView mWebView;

    @Deprecated
    public abstract void addWz(String str);

    @Deprecated
    public abstract void addseniorWz(String str, String str2);

    public abstract void consult(String str, String str2);

    @Deprecated
    public abstract void deleteWz(String str, String str2);

    public abstract void follow(String str, String str2);

    public String getCurrentUrl() {
        return this.mWebView != null ? this.mWebView.getUrl() : "";
    }

    public abstract void invokeWz(String str, String str2);

    @Override // com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback.a
    public void onCallBack(String str, String str2) {
        a aVar = new a(this, str, str2);
        if (this.mWebView != null) {
            this.mWebView.post(aVar);
        }
    }

    @Deprecated
    public abstract int queryWzStatus(String str);

    public abstract void queryZhidaStatus(String str, String str2);

    public void setCurrentWebiew(WebView webView) {
        this.mWebView = webView;
    }
}
