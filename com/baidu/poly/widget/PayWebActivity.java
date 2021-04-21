package com.baidu.poly.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.baidu.sapi2.SapiWebView;
import d.b.a0.f;
import d.b.a0.g;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes2.dex */
public class PayWebActivity extends Activity {
    public ImageView i;
    public boolean j;
    public String k;
    public Bundle l;
    public WebView webView;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayWebActivity.this.setResult(0);
            PayWebActivity.this.finish();
        }
    }

    private void V() {
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getStringExtra("load_url");
            this.l = intent.getBundleExtra("launch_payment_data");
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void W() {
        ImageView imageView = (ImageView) findViewById(f.iv_pay_back);
        this.i = imageView;
        imageView.setOnClickListener(new a());
        WebView webView = (WebView) findViewById(f.webView);
        this.webView = webView;
        webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.webView.setWebViewClient(new b());
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        this.webView.loadUrl(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str.startsWith("cashier://closewindow")) {
            setResult(0);
            finish();
            return true;
        } else if (URLUtil.isNetworkUrl(str)) {
            return false;
        } else {
            this.j = str.contains("weixin://");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
            return true;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        finish();
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_pay_web);
        this.j = false;
        V();
        W();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.loadDataWithBaseURL(null, "", SapiWebView.K, "utf-8", null);
            this.webView.clearHistory();
            ((ViewGroup) this.webView.getParent()).removeView(this.webView);
            this.webView.destroy();
            this.webView = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.j) {
            Intent intent = new Intent();
            intent.putExtras(this.l);
            setResult(-1, intent);
            finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            return PayWebActivity.this.m(str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 24) {
                String uri = webResourceRequest.getUrl().toString();
                try {
                    uri = URLDecoder.decode(uri, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                return PayWebActivity.this.m(uri);
            }
            return true;
        }
    }
}
