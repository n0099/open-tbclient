package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a aOF;
    private WebView aOG;
    private BaiduHybridAdViewListener aOE = new d(this);
    private boolean e = false;
    IOAdEventListener aOy = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.aOE = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.aOG = webView;
            this.aOF = new com.baidu.mobads.production.d.a(this.aOG);
            this.aOF.addEventListener(IXAdEvent.AD_LOADED, this.aOy);
            this.aOF.addEventListener(IXAdEvent.AD_ERROR, this.aOy);
            this.aOF.addEventListener(IXAdEvent.AD_STARTED, this.aOy);
            this.aOF.addEventListener("AdUserClick", this.aOy);
            this.aOF.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOy);
            this.aOF.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.aOF != null) {
            this.aOF.a(webView, str);
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
