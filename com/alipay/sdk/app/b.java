package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.util.n;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public Activity f1800a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1801b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f1802c;

    /* renamed from: d  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1803d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1804e;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f1805a;

        public a(b bVar) {
            this.f1805a = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f1805a.get();
            if (bVar != null) {
                bVar.d();
            }
        }
    }

    public b(Activity activity) {
        this.f1800a = activity;
        this.f1802c = new Handler(this.f1800a.getMainLooper());
    }

    private void c() {
        Activity activity = this.f1800a;
        if (activity == null) {
            return;
        }
        if (this.f1803d == null) {
            com.alipay.sdk.widget.a aVar = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f2014a);
            this.f1803d = aVar;
            aVar.a(true);
        }
        this.f1803d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.alipay.sdk.widget.a aVar = this.f1803d;
        if (aVar != null) {
            aVar.c();
        }
        this.f1803d = null;
    }

    public boolean b() {
        return this.f1804e;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Activity activity = this.f1800a;
        if (this.f1802c == null || activity == null || activity.isFinishing()) {
            return;
        }
        d();
        this.f1802c.removeCallbacksAndMessages(null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Activity activity = this.f1800a;
        if (this.f1802c != null && activity != null && !activity.isFinishing()) {
            c();
            this.f1802c.postDelayed(new a(this), StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f1804e = true;
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f1800a;
        if (activity == null) {
            return;
        }
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.r, "1" + sslError);
        if (this.f1801b) {
            sslErrorHandler.proceed();
            this.f1801b = false;
            return;
        }
        activity.runOnUiThread(new c(this, activity, sslErrorHandler));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return n.a(webView, str, this.f1800a);
    }

    public void a() {
        this.f1802c = null;
        this.f1800a = null;
    }
}
