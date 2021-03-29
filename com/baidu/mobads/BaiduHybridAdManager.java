package com.baidu.mobads;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
/* loaded from: classes2.dex */
public class BaiduHybridAdManager {

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mobads.production.c.a f8117c;

    /* renamed from: d  reason: collision with root package name */
    public WebView f8118d;

    /* renamed from: b  reason: collision with root package name */
    public BaiduHybridAdViewListener f8116b = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public boolean f8119e = false;

    /* renamed from: a  reason: collision with root package name */
    public IOAdEventListener f8115a = new e(this);

    public void injectJavaScriptBridge(WebView webView) {
        if (this.f8119e) {
            return;
        }
        this.f8118d = webView;
        com.baidu.mobads.production.c.a aVar = new com.baidu.mobads.production.c.a(this.f8118d);
        this.f8117c = aVar;
        aVar.addEventListener(IXAdEvent.AD_LOADED, this.f8115a);
        this.f8117c.addEventListener(IXAdEvent.AD_ERROR, this.f8115a);
        this.f8117c.addEventListener(IXAdEvent.AD_STARTED, this.f8115a);
        this.f8117c.addEventListener("AdUserClick", this.f8115a);
        this.f8117c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f8115a);
        this.f8117c.request();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f8119e = false;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f8119e = true;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.f8116b = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.baidu.mobads.production.c.a aVar;
        if (!this.f8119e && (aVar = this.f8117c) != null) {
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
