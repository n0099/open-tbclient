package com.baidu.ar.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ARWebView extends RelativeLayout implements View.OnClickListener {
    private WebView a;
    private RelativeLayout b;
    private ImageView c;
    private TextView d;
    private c e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            if (TextUtils.isEmpty(str) || !ARWebView.this.b(str)) {
                super.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message())) {
                return false;
            }
            return ARWebView.this.b(consoleMessage.message());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (ARWebView.this.e != null) {
                ARWebView.this.e.d();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            ARWebView.this.b.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            ARWebView.this.b.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void b();

        void c();

        void d();
    }

    public ARWebView(Context context) {
        super(context);
        a(context);
    }

    public ARWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ARWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a() {
        WebSettings settings = this.a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAppCachePath(getContext().getDir("appcache", 0).getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(getContext().getApplicationContext().getDir("database", 0).getPath());
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setUserAgentString(settings.getUserAgentString() + " " + f.a(getContext()) + "_baiduar/" + com.baidu.ar.util.c.b());
        this.a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
    }

    private void a(Context context) {
        this.a = new WebView(getContext());
        this.a.setWebChromeClient(new a());
        this.a.setWebViewClient(new b());
        this.a.setBackgroundColor(0);
        Res.addResource(context);
        LayoutInflater.from(getContext());
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.b = (RelativeLayout) Res.inflate("bdar_layout_webview_error", this, false);
        addView(this.b, layoutParams);
        this.d = (TextView) this.b.findViewById(Res.id("ar_error_button_reload"));
        this.d.setOnClickListener(this);
        this.c = (ImageView) this.b.findViewById(Res.id("ar_error_button_back"));
        this.c.setOnClickListener(this);
        this.b.setVisibility(8);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String substring;
        if (str == null || !str.contains("dz3m9ncbi8de3dfk0jeruqi")) {
            return false;
        }
        try {
            substring = str.substring(str.indexOf("{"), str.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(substring);
        if (jSONObject.has("callKey")) {
            jSONObject.getString("callKey");
        }
        if ((jSONObject.has("method") ? jSONObject.getString("method") : "").equalsIgnoreCase("close") && this.e != null) {
            this.e.c();
        }
        return true;
    }

    public void a(String str) {
        this.a.loadUrl(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == Res.id("ar_error_button_back")) {
            if (this.e != null) {
                this.e.b();
            }
            this.b.setVisibility(8);
        } else if (id == Res.id("ar_error_button_reload")) {
            this.a.reload();
        }
    }

    public void setWebViewCallcack(c cVar) {
        this.e = cVar;
    }
}
