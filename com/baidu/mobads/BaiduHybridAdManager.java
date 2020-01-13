package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes8.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a aKB;
    private WebView aKC;
    private BaiduHybridAdViewListener aKA = new d(this);
    private boolean e = false;
    IOAdEventListener aKu = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.aKA = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.aKC = webView;
            this.aKB = new com.baidu.mobads.production.d.a(this.aKC);
            this.aKB.addEventListener(IXAdEvent.AD_LOADED, this.aKu);
            this.aKB.addEventListener(IXAdEvent.AD_ERROR, this.aKu);
            this.aKB.addEventListener(IXAdEvent.AD_STARTED, this.aKu);
            this.aKB.addEventListener("AdUserClick", this.aKu);
            this.aKB.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aKu);
            this.aKB.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.aKB != null) {
            this.aKB.a(webView, str);
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
