package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes20.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bDe;
    private WebView bDf;
    private BaiduHybridAdViewListener bDd = new d(this);
    private boolean e = false;
    IOAdEventListener bCX = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bDd = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bDf = webView;
            this.bDe = new com.baidu.mobads.production.d.a(this.bDf);
            this.bDe.addEventListener(IXAdEvent.AD_LOADED, this.bCX);
            this.bDe.addEventListener(IXAdEvent.AD_ERROR, this.bCX);
            this.bDe.addEventListener(IXAdEvent.AD_STARTED, this.bCX);
            this.bDe.addEventListener("AdUserClick", this.bCX);
            this.bDe.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bCX);
            this.bDe.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bDe != null) {
            this.bDe.a(webView, str);
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
