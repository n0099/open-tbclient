package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a aOH;
    private WebView aOI;
    private BaiduHybridAdViewListener aOG = new d(this);
    private boolean e = false;
    IOAdEventListener aOA = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.aOG = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.aOI = webView;
            this.aOH = new com.baidu.mobads.production.d.a(this.aOI);
            this.aOH.addEventListener(IXAdEvent.AD_LOADED, this.aOA);
            this.aOH.addEventListener(IXAdEvent.AD_ERROR, this.aOA);
            this.aOH.addEventListener(IXAdEvent.AD_STARTED, this.aOA);
            this.aOH.addEventListener("AdUserClick", this.aOA);
            this.aOH.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOA);
            this.aOH.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.aOH != null) {
            this.aOH.a(webView, str);
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
