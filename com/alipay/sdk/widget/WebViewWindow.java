package com.alipay.sdk.widget;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class WebViewWindow extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    public static Handler f2001f = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public ImageView f2002a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f2003b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f2004c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f2005d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f2006e;

    /* renamed from: g  reason: collision with root package name */
    public a f2007g;

    /* renamed from: h  reason: collision with root package name */
    public b f2008h;

    /* renamed from: i  reason: collision with root package name */
    public c f2009i;
    public View.OnClickListener j;
    public final float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(WebViewWindow webViewWindow, String str);

        boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(WebViewWindow webViewWindow, int i2, String str, String str2);

        boolean a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean b(WebViewWindow webViewWindow, String str);

        boolean c(WebViewWindow webViewWindow, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(WebViewWindow webViewWindow);

        void b(WebViewWindow webViewWindow);
    }

    public WebViewWindow(Context context) {
        this(context, null);
    }

    public ImageView getBackButton() {
        return this.f2002a;
    }

    public ProgressBar getProgressbar() {
        return this.f2005d;
    }

    public ImageView getRefreshButton() {
        return this.f2004c;
    }

    public TextView getTitle() {
        return this.f2003b;
    }

    public String getUrl() {
        return this.f2006e.getUrl();
    }

    public WebView getWebView() {
        return this.f2006e;
    }

    public void setChromeProxy(a aVar) {
        this.f2007g = aVar;
        if (aVar == null) {
            this.f2006e.setWebChromeClient(null);
        } else {
            this.f2006e.setWebChromeClient(new s(this));
        }
    }

    public void setWebClientProxy(b bVar) {
        this.f2008h = bVar;
        if (bVar == null) {
            this.f2006e.setWebViewClient(null);
        } else {
            this.f2006e.setWebViewClient(new t(this));
        }
    }

    public void setWebEventProxy(c cVar) {
        this.f2009i = cVar;
    }

    public WebViewWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new q(this);
        this.k = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        this.f2002a = imageView;
        imageView.setOnClickListener(this.j);
        this.f2002a.setScaleType(ImageView.ScaleType.CENTER);
        this.f2002a.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.f1984a, context));
        this.f2002a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f2002a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.f2003b = textView;
        textView.setTextColor(-15658735);
        this.f2003b.setTextSize(17.0f);
        this.f2003b.setMaxLines(1);
        this.f2003b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f2003b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f2004c = imageView2;
        imageView2.setOnClickListener(this.j);
        this.f2004c.setScaleType(ImageView.ScaleType.CENTER);
        this.f2004c.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.f1985b, context));
        this.f2004c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f2004c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void c(Context context) {
        WebView webView = new WebView(context);
        this.f2006e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.f2006e, context);
        WebSettings settings = this.f2006e.getSettings();
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        try {
            this.f2006e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f2006e.removeJavascriptInterface("accessibility");
            this.f2006e.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception unused) {
        }
        addView(this.f2006e, new LinearLayout.LayoutParams(-1, -1));
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, 16973855);
        this.f2005d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
        this.f2005d.setMax(100);
        this.f2005d.setBackgroundColor(-218103809);
        addView(this.f2005d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        String packageName = context.getPackageName();
        String h2 = com.alipay.sdk.util.n.h(context);
        webView.getSettings().setUserAgentString(userAgentString + " AlipaySDK(" + packageName + "/" + h2 + "/15.6.5" + SmallTailInfo.EMOTION_SUFFIX);
    }

    public void a(String str) {
        this.f2006e.loadUrl(str);
    }

    public void a(String str, byte[] bArr) {
        this.f2006e.postUrl(str, bArr);
    }

    public void a() {
        removeAllViews();
        this.f2006e.removeAllViews();
        this.f2006e.setWebViewClient(null);
        this.f2006e.setWebChromeClient(null);
        this.f2006e.destroy();
    }

    private int a(int i2) {
        return (int) (i2 * this.k);
    }
}
