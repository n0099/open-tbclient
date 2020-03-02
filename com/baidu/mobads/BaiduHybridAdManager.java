package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a aOG;
    private WebView aOH;
    private BaiduHybridAdViewListener aOF = new d(this);
    private boolean e = false;
    IOAdEventListener aOz = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.aOF = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.aOH = webView;
            this.aOG = new com.baidu.mobads.production.d.a(this.aOH);
            this.aOG.addEventListener(IXAdEvent.AD_LOADED, this.aOz);
            this.aOG.addEventListener(IXAdEvent.AD_ERROR, this.aOz);
            this.aOG.addEventListener(IXAdEvent.AD_STARTED, this.aOz);
            this.aOG.addEventListener("AdUserClick", this.aOz);
            this.aOG.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aOz);
            this.aOG.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.aOG != null) {
            this.aOG.a(webView, str);
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
