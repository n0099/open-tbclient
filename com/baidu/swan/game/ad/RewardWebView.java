package com.baidu.swan.game.ad;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class RewardWebView extends WebView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f12322e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f12323f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12324e;

        public a(String str) {
            this.f12324e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadUrl(this.f12324e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f12328g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f12329h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f12330i;

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f12326e = str;
            this.f12327f = str2;
            this.f12328g = str3;
            this.f12329h = str4;
            this.f12330i = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadDataWithBaseURL(this.f12326e, this.f12327f, this.f12328g, this.f12329h, this.f12330i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f12332f;

        public c(String str, ValueCallback valueCallback) {
            this.f12331e = str;
            this.f12332f = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.evaluateJavascript(this.f12331e, this.f12332f);
        }
    }

    public RewardWebView(Context context) {
        super(context);
        this.f12322e = false;
        this.f12323f = new Handler(Looper.getMainLooper());
        d();
        setClickable(true);
        setBackgroundColor(0);
        setFocusable(true);
        setScrollBarStyle(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(true);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(path);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        settings.setAppCacheMaxSize(5242880L);
        f();
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 14) {
            setLayerType(1, null);
        }
    }

    public final void d() {
        try {
            if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT > 17) {
                return;
            }
            Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", String.class);
            declaredMethod.invoke(this, "searchBoxJavaBridge_");
            declaredMethod.invoke(this, "accessibility");
            declaredMethod.invoke(this, "accessibilityTraversal");
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f12322e) {
                return;
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            super.destroy();
            this.f12322e = true;
        } catch (Exception unused) {
        }
    }

    public final void e(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f12323f.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f12322e) {
            return;
        }
        e(new c(str, valueCallback));
    }

    public final void f() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(d.a.h0.a.g2.a.b(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f12322e) {
            return;
        }
        e(new b(str, str2, str3, str4, str5));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (this.f12322e) {
                return;
            }
            e(new a(str));
        } catch (Exception unused) {
        }
    }
}
