package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes7.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a aJJ;
    private WebView aJK;
    private BaiduHybridAdViewListener aJI = new d(this);
    private boolean e = false;
    IOAdEventListener aJC = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.aJI = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.aJK = webView;
            this.aJJ = new com.baidu.mobads.production.d.a(this.aJK);
            this.aJJ.addEventListener(IXAdEvent.AD_LOADED, this.aJC);
            this.aJJ.addEventListener(IXAdEvent.AD_ERROR, this.aJC);
            this.aJJ.addEventListener(IXAdEvent.AD_STARTED, this.aJC);
            this.aJJ.addEventListener("AdUserClick", this.aJC);
            this.aJJ.addEventListener(IXAdEvent.AD_USER_CLOSE, this.aJC);
            this.aJJ.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.aJJ != null) {
            this.aJJ.a(webView, str);
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
