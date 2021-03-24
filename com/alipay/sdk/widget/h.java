package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.sdk.app.b f2028b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f2029c;

    public h(Activity activity) {
        super(activity);
        WebView webView = new WebView(activity);
        this.f2029c = webView;
        a(webView, activity);
        addView(this.f2029c);
        com.alipay.sdk.app.b bVar = new com.alipay.sdk.app.b(activity);
        this.f2028b = bVar;
        this.f2029c.setWebViewClient(bVar);
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.f2028b.a();
        removeAllViews();
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (this.f2029c.canGoBack()) {
            if (this.f2028b.b()) {
                com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.NETWORK_ERROR.a());
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b2.a(), b2.b(), ""));
                this.f2027a.finish();
                return true;
            }
            return true;
        }
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f2027a.finish();
        return true;
    }

    private void a(WebView webView, Context context) {
        WebSettings settings = this.f2029c.getSettings();
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
        this.f2029c.resumeTimers();
        this.f2029c.setVerticalScrollbarOverlay(true);
        this.f2029c.setDownloadListener(new i(this));
        try {
            try {
                this.f2029c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f2029c.removeJavascriptInterface("accessibility");
                this.f2029c.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            Method method = this.f2029c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (method != null) {
                method.invoke(this.f2029c, "searchBoxJavaBridge_");
                method.invoke(this.f2029c, "accessibility");
                method.invoke(this.f2029c, "accessibilityTraversal");
            }
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        this.f2029c.loadUrl(str);
    }
}
