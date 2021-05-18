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
    public boolean f11661e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f11662f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11663e;

        public a(String str) {
            this.f11663e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadUrl(this.f11663e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11666f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11667g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11668h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f11669i;

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f11665e = str;
            this.f11666f = str2;
            this.f11667g = str3;
            this.f11668h = str4;
            this.f11669i = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadDataWithBaseURL(this.f11665e, this.f11666f, this.f11667g, this.f11668h, this.f11669i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f11671f;

        public c(String str, ValueCallback valueCallback) {
            this.f11670e = str;
            this.f11671f = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.evaluateJavascript(this.f11670e, this.f11671f);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public RewardWebView(Context context) {
        super(context);
        this.f11661e = false;
        this.f11662f = new Handler(Looper.getMainLooper());
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
            this.f11662f.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f11661e) {
                return;
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            super.destroy();
            this.f11661e = true;
        } catch (Exception unused) {
        }
    }

    public final void e() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(d.a.i0.f.i.m.a.b().o(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f11661e) {
            return;
        }
        d(new c(str, valueCallback));
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f11661e) {
            return;
        }
        d(new b(str, str2, str3, str4, str5));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (this.f11661e) {
                return;
            }
            d(new a(str));
        } catch (Exception unused) {
        }
    }
}
