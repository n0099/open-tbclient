package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a aOV;
    private WebView aOW;
    private BaiduHybridAdViewListener aOU = new d(this);
    private boolean e = false;
    IOAdEventListener aOO = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.aOU = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.aOW = webView;
            this.aOV = new com.baidu.mobads.production.d.a(this.aOW);
            this.aOV.addEventListener(IXAdEvent.AD_LOADED, this.aOO);
            this.aOV.addEventListener(IXAdEvent.AD_ERROR, this.aOO);
            this.aOV.addEventListener(IXAdEvent.AD_STARTED, this.aOO);
            this.aOV.addEventListener("AdUserClick", this.aOO);
            this.aOV.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOO);
            this.aOV.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.aOV != null) {
            this.aOV.a(webView, str);
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
