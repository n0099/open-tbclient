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
    public boolean f12769e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f12770f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12771e;

        public a(String str) {
            this.f12771e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadUrl(this.f12771e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12774f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f12775g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f12776h;
        public final /* synthetic */ String i;

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f12773e = str;
            this.f12774f = str2;
            this.f12775g = str3;
            this.f12776h = str4;
            this.i = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadDataWithBaseURL(this.f12773e, this.f12774f, this.f12775g, this.f12776h, this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f12778f;

        public c(String str, ValueCallback valueCallback) {
            this.f12777e = str;
            this.f12778f = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.evaluateJavascript(this.f12777e, this.f12778f);
        }
    }

    public RewardWebView(Context context) {
        super(context);
        this.f12769e = false;
        this.f12770f = new Handler(Looper.getMainLooper());
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
            if (this.f12769e) {
                return;
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            super.destroy();
            this.f12769e = true;
        } catch (Exception unused) {
        }
    }

    public final void e(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f12770f.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f12769e) {
            return;
        }
        e(new c(str, valueCallback));
    }

    public final void f() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(d.b.g0.a.g2.a.b(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f12769e) {
            return;
        }
        e(new b(str, str2, str3, str4, str5));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (this.f12769e) {
                return;
            }
            e(new a(str));
        } catch (Exception unused) {
        }
    }
}
