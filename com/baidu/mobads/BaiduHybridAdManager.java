package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes2.dex */
public class BaiduHybridAdManager {

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mobads.production.c.a f8116c;

    /* renamed from: d  reason: collision with root package name */
    public WebView f8117d;

    /* renamed from: b  reason: collision with root package name */
    public BaiduHybridAdViewListener f8115b = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public boolean f8118e = false;

    /* renamed from: a  reason: collision with root package name */
    public IOAdEventListener f8114a = new e(this);

    public void injectJavaScriptBridge(WebView webView) {
        if (this.f8118e) {
            return;
        }
        this.f8117d = webView;
        com.baidu.mobads.production.c.a aVar = new com.baidu.mobads.production.c.a(this.f8117d);
        this.f8116c = aVar;
        aVar.addEventListener(IXAdEvent.AD_LOADED, this.f8114a);
        this.f8116c.addEventListener(IXAdEvent.AD_ERROR, this.f8114a);
        this.f8116c.addEventListener(IXAdEvent.AD_STARTED, this.f8114a);
        this.f8116c.addEventListener("AdUserClick", this.f8114a);
        this.f8116c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f8114a);
        this.f8116c.request();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f8118e = false;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f8118e = true;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f8115b = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.baidu.mobads.production.c.a aVar;
        if (!this.f8118e && (aVar = this.f8116c) != null) {
            aVar.a(webView, str);
        }
        try {
            Uri parse = Uri.parse(str);
            if ("mobadssdk".equals(parse.getScheme())) {
                return true;
            }
            return "mobads".equals(parse.getScheme());
        } catch (Exception e2) {
            System.err.println(e2);
            return false;
        }
    }
}
