package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bDh;
    private WebView bDi;
    private BaiduHybridAdViewListener bDg = new d(this);
    private boolean e = false;
    IOAdEventListener bDa = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bDg = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bDi = webView;
            this.bDh = new com.baidu.mobads.production.d.a(this.bDi);
            this.bDh.addEventListener(IXAdEvent.AD_LOADED, this.bDa);
            this.bDh.addEventListener(IXAdEvent.AD_ERROR, this.bDa);
            this.bDh.addEventListener(IXAdEvent.AD_STARTED, this.bDa);
            this.bDh.addEventListener("AdUserClick", this.bDa);
            this.bDh.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bDa);
            this.bDh.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bDh != null) {
            this.bDh.a(webView, str);
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
