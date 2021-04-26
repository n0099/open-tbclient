package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.sdk.app.b f2012b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f2013c;

    public h(Activity activity) {
        super(activity);
        WebView webView = new WebView(activity);
        this.f2013c = webView;
        a(webView, activity);
        addView(this.f2013c);
        com.alipay.sdk.app.b bVar = new com.alipay.sdk.app.b(activity);
        this.f2012b = bVar;
        this.f2013c.setWebViewClient(bVar);
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.f2012b.a();
        removeAllViews();
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (this.f2013c.canGoBack()) {
            if (this.f2012b.b()) {
                com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.NETWORK_ERROR.a());
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b2.a(), b2.b(), ""));
                this.f2011a.finish();
                return true;
            }
            return true;
        }
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f2011a.finish();
        return true;
    }

    private void a(WebView webView, Context context) {
        WebSettings settings = this.f2013c.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + com.alipay.sdk.util.n.c(context));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(1);
        this.f2013c.resumeTimers();
        this.f2013c.setVerticalScrollbarOverlay(true);
        this.f2013c.setDownloadListener(new i(this));
        try {
            try {
                this.f2013c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f2013c.removeJavascriptInterface("accessibility");
                this.f2013c.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
                Method method = this.f2013c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f2013c, "searchBoxJavaBridge_");
                    method.invoke(this.f2013c, "accessibility");
                    method.invoke(this.f2013c, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        this.f2013c.loadUrl(str);
    }
}
