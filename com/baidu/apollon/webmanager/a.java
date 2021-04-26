package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.base.ApollonBaseActivity;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import java.io.File;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4147a = "AbstractWebViewPage";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4148b = ApollonConstants.DEBUG & false;

    /* renamed from: c  reason: collision with root package name */
    public static final String f4149c = "appcache";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4150d = "databases";

    /* renamed from: e  reason: collision with root package name */
    public static final String f4151e = "geolocation";

    /* renamed from: f  reason: collision with root package name */
    public static final String f4152f = "page load success";

    /* renamed from: g  reason: collision with root package name */
    public static final String f4153g = "page load failure";

    /* renamed from: h  reason: collision with root package name */
    public final View f4154h;

    /* renamed from: i  reason: collision with root package name */
    public final View f4155i;
    public ViewGroup j;
    public SafeWebView k;
    public boolean l;
    public int m;
    public ApollonBaseActivity o;
    public EventBus q;
    public String n = "";
    public boolean p = false;

    public a(ApollonBaseActivity apollonBaseActivity, ViewGroup viewGroup, View view, View view2, int i2) {
        this.j = null;
        this.l = false;
        this.m = 0;
        this.o = null;
        this.o = apollonBaseActivity;
        this.j = viewGroup;
        this.f4154h = view;
        this.f4155i = view2;
        this.l = false;
        this.m = i2;
        String[] strArr = {f4152f, f4153g};
        EventBus eventBus = EventBus.getInstance();
        this.q = eventBus;
        eventBus.register(this, strArr, 0, EventBus.ThreadMode.MainThread);
        n();
    }

    private void j() {
        ViewGroup viewGroup;
        View view = this.f4154h;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(this.f4154h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View view = this.f4155i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        j();
        View view = this.f4155i;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f4155i);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.j.addView(this.f4155i, layoutParams);
            this.f4155i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        EventBus eventBus = this.q;
        eventBus.getClass();
        eventBus.post(new EventBus.Event(f4152f, null));
    }

    private void n() {
        this.k = new SafeWebView(this.o.getApplicationContext());
        if (this.l) {
            File file = new File(this.o.getApplicationContext().getCacheDir(), "webviewCacheChromium");
            if (!file.exists()) {
                file = new File(this.o.getApplicationContext().getCacheDir(), "webviewCache");
            }
            if (file.exists()) {
                if (NetworkUtils.isNetworkConnected(this.o.getApplicationContext())) {
                    this.k.getSettings().setCacheMode(-1);
                } else {
                    this.k.getSettings().setCacheMode(1);
                }
            } else {
                this.k.getSettings().setCacheMode(1);
            }
        }
        this.k.setScrollBarStyle(0);
        this.k.getSettings().setBlockNetworkImage(true);
        this.k.setLongClickable(true);
        a(this.k);
        this.k.setWebViewClient(new SafeWebView.SafeWebViewClient() { // from class: com.baidu.apollon.webmanager.a.1
            @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
                if (a.f4148b) {
                    Log.d(a.f4147a, "onLoadResource is called, url is " + str);
                }
            }

            @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                if (a.f4148b) {
                    Log.d(a.f4147a, "onPageFinished, url is " + str + " original url is " + webView.getOriginalUrl());
                }
                super.onPageFinished(webView, str);
                Object tag = webView.getTag(a.this.m);
                int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                if (a.f4148b) {
                    Log.d(a.f4147a, "onPageFinished errorTagCode is " + intValue);
                }
                if (TextUtils.equals(str, a.this.n) || TextUtils.equals(webView.getOriginalUrl(), a.this.n) || (str != null && str.contains(a.this.n))) {
                    if (intValue == 0) {
                        a.this.m();
                    } else {
                        a.this.b(intValue);
                    }
                }
                a.this.k();
                a.this.k.getSettings().setBlockNetworkImage(false);
            }

            @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (a.f4148b) {
                    Log.d(a.f4147a, "onPageStarted is called, url is " + str);
                }
                if (a.this.p) {
                    a.this.k.getSettings().setBlockNetworkImage(true);
                    if (Build.VERSION.SDK_INT >= 16) {
                        a.this.k.clearView();
                    }
                }
                a.this.p = false;
                a.this.n = str;
                WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                if (a.this.f4154h == null || a.this.f4154h.getVisibility() != 0) {
                    if (copyBackForwardList == null || copyBackForwardList.getCurrentIndex() == copyBackForwardList.getSize() - 1) {
                        a.this.l();
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                if (a.f4148b) {
                    Log.d(a.f4147a, "onReceivedError is called, errorCode is  " + i2 + " failingUrl is " + str2);
                }
                webView.setTag(a.this.m, Integer.valueOf(i2));
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (a.f4148b) {
                    Log.d(a.f4147a, "shouldOverrideUrlLoading, url is " + str);
                }
                a.this.p = true;
                a.this.n = str;
                a.this.l();
                return false;
            }
        });
        this.k.setWebChromeClient(new SafeWebView.SafeChromeClient() { // from class: com.baidu.apollon.webmanager.a.2
            @Override // android.webkit.WebChromeClient
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(j * 2);
            }
        });
    }

    public void b() {
        this.k.goBack();
        this.p = true;
    }

    public void c() {
        this.k.goForward();
        this.p = true;
    }

    public boolean d() {
        return this.k.canGoBack();
    }

    @SuppressLint({"NewApi"})
    public void e() {
        SafeWebView safeWebView;
        if (Build.VERSION.SDK_INT < 11 || (safeWebView = this.k) == null) {
            return;
        }
        safeWebView.onPause();
    }

    @SuppressLint({"NewApi"})
    public void f() {
        SafeWebView safeWebView;
        if (Build.VERSION.SDK_INT < 11 || (safeWebView = this.k) == null) {
            return;
        }
        safeWebView.onResume();
    }

    public void g() {
        ViewGroup viewGroup = (ViewGroup) this.k.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.k);
        }
        this.k.destroy();
        this.k = null;
    }

    public void h() {
        String str = Uri.parse(this.n).getScheme() + "://" + Uri.parse(this.n).getHost();
        if (f4148b) {
            Log.d(f4147a, "delOrigin is " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WebStorage.getInstance().deleteOrigin(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f4148b) {
            Log.d(f4147a, "delOrigin is " + str);
        }
        WebStorage.getInstance().deleteOrigin(str);
    }

    public SafeWebView a() {
        return this.k;
    }

    public void a(String str) {
        this.n = str;
        this.p = true;
        this.k.loadUrl(str);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        EventBus eventBus = this.q;
        eventBus.getClass();
        eventBus.post(new EventBus.Event(f4153g, Integer.valueOf(i2)));
    }

    public void a(EventBus.Event event) {
        if (event.mEventKey.equals(f4152f)) {
            j();
            k();
            this.k.setVisibility(0);
        } else if (event.mEventKey.equals(f4153g)) {
            a(((Integer) event.mEventObj).intValue());
            this.k.setVisibility(8);
        }
    }

    public a(ApollonBaseActivity apollonBaseActivity, ViewGroup viewGroup, View view, View view2, boolean z, int i2) {
        this.j = null;
        this.l = false;
        this.m = 0;
        this.o = null;
        this.o = apollonBaseActivity;
        this.j = viewGroup;
        this.f4154h = view;
        this.f4155i = view2;
        this.l = z;
        this.m = i2;
        n();
    }

    private void a(int i2) {
        if (i2 == 0) {
            j();
            return;
        }
        k();
        View view = this.f4154h;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f4154h);
            }
            this.j.addView(this.f4154h, this.j.getLayoutParams());
            this.f4154h.setVisibility(0);
        }
    }

    private void a(SafeWebView safeWebView) {
        WebSettings settings = safeWebView.getSettings();
        if (this.l) {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setDatabasePath(this.o.getApplicationContext().getDir("databases", 0).getPath());
            if (this.l) {
                settings.setAppCacheEnabled(true);
                settings.setAppCachePath(this.o.getApplicationContext().getDir("appcache", 0).getPath());
            }
        }
        settings.setGeolocationDatabasePath(this.o.getApplicationContext().getDir("geolocation", 0).getPath());
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }
}
