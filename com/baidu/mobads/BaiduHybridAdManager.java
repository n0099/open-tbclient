package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes7.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.d.a c;
    private WebView d;
    private BaiduHybridAdViewListener b = new d(this);
    private boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    IOAdEventListener f2302a = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.b = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.d = webView;
            this.c = new com.baidu.mobads.production.d.a(this.d);
            this.c.addEventListener(IXAdEvent.AD_LOADED, this.f2302a);
            this.c.addEventListener(IXAdEvent.AD_ERROR, this.f2302a);
            this.c.addEventListener(IXAdEvent.AD_STARTED, this.f2302a);
            this.c.addEventListener("AdUserClick", this.f2302a);
            this.c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f2302a);
            this.c.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.e && this.c != null) {
            this.c.a(webView, str);
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
