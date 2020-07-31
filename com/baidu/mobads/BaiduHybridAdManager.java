package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bxw;
    private WebView bxx;
    private BaiduHybridAdViewListener bxv = new d(this);
    private boolean e = false;
    IOAdEventListener bxp = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bxv = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bxx = webView;
            this.bxw = new com.baidu.mobads.production.d.a(this.bxx);
            this.bxw.addEventListener(IXAdEvent.AD_LOADED, this.bxp);
            this.bxw.addEventListener(IXAdEvent.AD_ERROR, this.bxp);
            this.bxw.addEventListener(IXAdEvent.AD_STARTED, this.bxp);
            this.bxw.addEventListener("AdUserClick", this.bxp);
            this.bxw.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bxp);
            this.bxw.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bxw != null) {
            this.bxw.a(webView, str);
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
