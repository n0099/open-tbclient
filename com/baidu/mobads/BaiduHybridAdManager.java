package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bkR;
    private WebView bkS;
    private BaiduHybridAdViewListener bkQ = new d(this);
    private boolean e = false;
    IOAdEventListener bkK = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bkQ = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bkS = webView;
            this.bkR = new com.baidu.mobads.production.d.a(this.bkS);
            this.bkR.addEventListener(IXAdEvent.AD_LOADED, this.bkK);
            this.bkR.addEventListener(IXAdEvent.AD_ERROR, this.bkK);
            this.bkR.addEventListener(IXAdEvent.AD_STARTED, this.bkK);
            this.bkR.addEventListener("AdUserClick", this.bkK);
            this.bkR.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bkK);
            this.bkR.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bkR != null) {
            this.bkR.a(webView, str);
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
