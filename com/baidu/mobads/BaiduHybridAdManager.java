package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bxh;
    private WebView bxi;
    private BaiduHybridAdViewListener bxg = new d(this);
    private boolean e = false;
    IOAdEventListener bxa = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bxg = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bxi = webView;
            this.bxh = new com.baidu.mobads.production.d.a(this.bxi);
            this.bxh.addEventListener(IXAdEvent.AD_LOADED, this.bxa);
            this.bxh.addEventListener(IXAdEvent.AD_ERROR, this.bxa);
            this.bxh.addEventListener(IXAdEvent.AD_STARTED, this.bxa);
            this.bxh.addEventListener("AdUserClick", this.bxa);
            this.bxh.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bxa);
            this.bxh.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bxh != null) {
            this.bxh.a(webView, str);
        }
        try {
        } catch (Exception e) {
            System.err.println(e);
        }
        if ("mobadssdk".equals(Uri.parse(str).getScheme())) {
            return true;
        }
        return false;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.e = true;
    }
}
