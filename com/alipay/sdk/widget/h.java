package com.alipay.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: b  reason: collision with root package name */
    public com.alipay.sdk.app.b f2025b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f2026c;

    public h(Activity activity) {
        super(activity);
        WebView webView = new WebView(activity);
        this.f2026c = webView;
        a(webView, activity);
        addView(this.f2026c);
        com.alipay.sdk.app.b bVar = new com.alipay.sdk.app.b(activity);
        this.f2025b = bVar;
        this.f2026c.setWebViewClient(bVar);
    }

    @Override // com.alipay.sdk.widget.g
    public void a() {
        this.f2025b.a();
        removeAllViews();
    }

    @Override // com.alipay.sdk.widget.g
    public boolean b() {
        if (this.f2026c.canGoBack()) {
            if (this.f2025b.b()) {
                com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.NETWORK_ERROR.a());
                com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b2.a(), b2.b(), ""));
                this.f2024a.finish();
                return true;
            }
            return true;
        }
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f2024a.finish();
        return true;
    }

    private void a(WebView webView, Context context) {
        WebSettings settings = this.f2026c.getSettings();
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
        this.f2026c.resumeTimers();
        this.f2026c.setVerticalScrollbarOverlay(true);
        this.f2026c.setDownloadListener(new i(this));
        try {
            try {
                this.f2026c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f2026c.removeJavascriptInterface("accessibility");
                this.f2026c.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
                Method method = this.f2026c.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f2026c, "searchBoxJavaBridge_");
                    method.invoke(this.f2026c, "accessibility");
                    method.invoke(this.f2026c, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.alipay.sdk.widget.g
    public void a(String str) {
        this.f2026c.loadUrl(str);
    }
}
