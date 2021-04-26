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
    public Activity f1770a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1771b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f1772c;

    /* renamed from: d  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1773d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1774e;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f1775a;

        public a(b bVar) {
            this.f1775a = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f1775a.get();
            if (bVar != null) {
                bVar.d();
            }
        }
    }

    public b(Activity activity) {
        this.f1770a = activity;
        this.f1772c = new Handler(this.f1770a.getMainLooper());
    }

    private void c() {
        Activity activity = this.f1770a;
        if (activity == null) {
            return;
        }
        if (this.f1773d == null) {
            com.alipay.sdk.widget.a aVar = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f1997a);
            this.f1773d = aVar;
            aVar.a(true);
        }
        this.f1773d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.alipay.sdk.widget.a aVar = this.f1773d;
        if (aVar != null) {
            aVar.c();
        }
        this.f1773d = null;
    }

    public boolean b() {
        return this.f1774e;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Activity activity = this.f1770a;
        if (this.f1772c == null || activity == null || activity.isFinishing()) {
            return;
        }
        d();
        this.f1772c.removeCallbacksAndMessages(null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Activity activity = this.f1770a;
        if (this.f1772c != null && activity != null && !activity.isFinishing()) {
            c();
            this.f1772c.postDelayed(new a(this), StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        this.f1774e = true;
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f1770a;
        if (activity == null) {
            return;
        }
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.r, "1" + sslError);
        if (this.f1771b) {
            sslErrorHandler.proceed();
            this.f1771b = false;
            return;
        }
        activity.runOnUiThread(new c(this, activity, sslErrorHandler));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return n.a(webView, str, this.f1770a);
    }

    public void a() {
        this.f1772c = null;
        this.f1770a = null;
    }
}
