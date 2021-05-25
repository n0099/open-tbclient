package com.baidu.swan.game.ad.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public class RewardWebView extends WebView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f11562e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f11563f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11564e;

        public a(String str) {
            this.f11564e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadUrl(this.f11564e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11567f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11568g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11569h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f11570i;

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f11566e = str;
            this.f11567f = str2;
            this.f11568g = str3;
            this.f11569h = str4;
            this.f11570i = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadDataWithBaseURL(this.f11566e, this.f11567f, this.f11568g, this.f11569h, this.f11570i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11571e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f11572f;

        public c(String str, ValueCallback valueCallback) {
            this.f11571e = str;
            this.f11572f = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.evaluateJavascript(this.f11571e, this.f11572f);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public RewardWebView(Context context) {
        super(context);
        this.f11562e = false;
        this.f11563f = new Handler(Looper.getMainLooper());
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
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        e();
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
        } catch (Exception unused) {
        }
    }

    public final void d(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f11563f.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f11562e) {
                return;
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            super.destroy();
            this.f11562e = true;
        } catch (Exception unused) {
        }
    }

    public final void e() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(d.a.l0.f.i.m.a.b().o(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f11562e) {
            return;
        }
        d(new c(str, valueCallback));
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f11562e) {
            return;
        }
        d(new b(str, str2, str3, str4, str5));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (this.f11562e) {
                return;
            }
            d(new a(str));
        } catch (Exception unused) {
        }
    }
}
