package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bkM;
    private WebView bkN;
    private BaiduHybridAdViewListener bkL = new d(this);
    private boolean e = false;
    IOAdEventListener bkF = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bkL = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bkN = webView;
            this.bkM = new com.baidu.mobads.production.d.a(this.bkN);
            this.bkM.addEventListener(IXAdEvent.AD_LOADED, this.bkF);
            this.bkM.addEventListener(IXAdEvent.AD_ERROR, this.bkF);
            this.bkM.addEventListener(IXAdEvent.AD_STARTED, this.bkF);
            this.bkM.addEventListener("AdUserClick", this.bkF);
            this.bkM.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bkF);
            this.bkM.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bkM != null) {
            this.bkM.a(webView, str);
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
