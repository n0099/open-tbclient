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
    public boolean f11706e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f11707f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11708e;

        public a(String str) {
            this.f11708e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadUrl(this.f11708e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11711f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11712g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f11713h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f11714i;

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f11710e = str;
            this.f11711f = str2;
            this.f11712g = str3;
            this.f11713h = str4;
            this.f11714i = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadDataWithBaseURL(this.f11710e, this.f11711f, this.f11712g, this.f11713h, this.f11714i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11715e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f11716f;

        public c(String str, ValueCallback valueCallback) {
            this.f11715e = str;
            this.f11716f = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.evaluateJavascript(this.f11715e, this.f11716f);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public RewardWebView(Context context) {
        super(context);
        this.f11706e = false;
        this.f11707f = new Handler(Looper.getMainLooper());
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
            this.f11707f.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f11706e) {
                return;
            }
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            super.destroy();
            this.f11706e = true;
        } catch (Exception unused) {
        }
    }

    public final void e() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(d.a.m0.f.i.m.a.b().o(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f11706e) {
            return;
        }
        d(new c(str, valueCallback));
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.f11706e) {
            return;
        }
        d(new b(str, str2, str3, str4, str5));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (this.f11706e) {
                return;
            }
            d(new a(str));
        } catch (Exception unused) {
        }
    }
}
