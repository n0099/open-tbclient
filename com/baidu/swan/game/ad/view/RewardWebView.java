package com.baidu.swan.game.ad.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.tieba.hu3;
/* loaded from: classes4.dex */
public class RewardWebView extends WebView {
    public boolean a;
    public Handler b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadUrl(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public b(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.loadDataWithBaseURL(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ ValueCallback b;

        public c(String str, ValueCallback valueCallback) {
            this.a = str;
            this.b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardWebView.super.evaluateJavascript(this.a, this.b);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public RewardWebView(Context context) {
        super(context);
        this.a = false;
        this.b = new Handler(Looper.getMainLooper());
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

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.a) {
            d(new c(str, valueCallback));
        }
    }

    public final void d(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (!this.a) {
                d(new a(str));
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (!this.a) {
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                super.destroy();
                this.a = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void e() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(hu3.b().i(settings.getUserAgentString()));
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.a) {
            d(new b(str, str2, str3, str4, str5));
        }
    }
}
