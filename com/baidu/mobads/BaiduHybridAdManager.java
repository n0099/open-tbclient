package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes5.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.production.c.a c;
    private WebView d;

    /* renamed from: b  reason: collision with root package name */
    private BaiduHybridAdViewListener f3271b = new d(this);
    private boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    IOAdEventListener f3270a = new e(this);

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f3271b = baiduHybridAdViewListener;
    }

    public void injectJavaScriptBridge(WebView webView) {
        if (!this.e) {
            this.d = webView;
            this.c = new com.baidu.mobads.production.c.a(this.d);
            this.c.addEventListener(IXAdEvent.AD_LOADED, this.f3270a);
            this.c.addEventListener(IXAdEvent.AD_ERROR, this.f3270a);
            this.c.addEventListener(IXAdEvent.AD_STARTED, this.f3270a);
            this.c.addEventListener("AdUserClick", this.f3270a);
            this.c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f3270a);
            this.c.request();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.e = false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse;
        if (!this.e && this.c != null) {
            this.c.a(webView, str);
        }
        try {
            parse = Uri.parse(str);
        } catch (Exception e) {
            System.err.println(e);
        }
        if (!"mobadssdk".equals(parse.getScheme())) {
            if (!"mobads".equals(parse.getScheme())) {
                return false;
            }
        }
        return true;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.e = true;
    }
}
