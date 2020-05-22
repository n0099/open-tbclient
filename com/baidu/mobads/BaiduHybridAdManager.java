package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes10.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a bsn;
    private WebView bso;
    private BaiduHybridAdViewListener bsm = new d(this);
    private boolean e = false;
    IOAdEventListener bsg = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.bsm = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.bso = webView;
            this.bsn = new com.baidu.mobads.production.d.a(this.bso);
            this.bsn.addEventListener(IXAdEvent.AD_LOADED, this.bsg);
            this.bsn.addEventListener(IXAdEvent.AD_ERROR, this.bsg);
            this.bsn.addEventListener(IXAdEvent.AD_STARTED, this.bsg);
            this.bsn.addEventListener("AdUserClick", this.bsg);
            this.bsn.addEventListener(IXAdEvent.AD_USER_CLOSE, this.bsg);
            this.bsn.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.bsn != null) {
            this.bsn.a(webView, str);
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
