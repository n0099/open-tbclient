package com.baidu.android.pushservice.richmedia;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class MediaViewActivity extends Activity {
    public WebView a;
    private RelativeLayout b;
    private WebChromeClient c = new WebChromeClient() { // from class: com.baidu.android.pushservice.richmedia.MediaViewActivity.1
        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        }
    };
    private WebViewClient d = new WebViewClient() { // from class: com.baidu.android.pushservice.richmedia.MediaViewActivity.2
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String substring;
            if (str.startsWith("tel:")) {
                try {
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(str));
                    MediaViewActivity.this.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                }
            } else if (str.startsWith("geo:")) {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    MediaViewActivity.this.startActivity(intent2);
                } catch (ActivityNotFoundException e2) {
                }
            } else if (str.startsWith("mailto:")) {
                try {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setData(Uri.parse(str));
                    MediaViewActivity.this.startActivity(intent3);
                } catch (ActivityNotFoundException e3) {
                }
            } else if (str.startsWith("sms:")) {
                try {
                    Intent intent4 = new Intent("android.intent.action.VIEW");
                    int indexOf = str.indexOf(63);
                    if (indexOf == -1) {
                        substring = str.substring(4);
                    } else {
                        substring = str.substring(4, indexOf);
                        String query = Uri.parse(str).getQuery();
                        if (query != null && query.startsWith("body=")) {
                            intent4.putExtra("sms_body", query.substring(5));
                        }
                    }
                    intent4.setData(Uri.parse("sms:" + substring));
                    intent4.putExtra("address", substring);
                    intent4.setType("vnd.android-dir/mms-sms");
                    MediaViewActivity.this.startActivity(intent4);
                } catch (ActivityNotFoundException e4) {
                }
            }
            if (Build.VERSION.SDK_INT <= 17) {
                webView.loadUrl(str);
                return true;
            }
            try {
                Intent intent5 = new Intent("android.intent.action.VIEW");
                intent5.setData(Uri.parse(str));
                MediaViewActivity.this.startActivity(intent5);
                return true;
            } catch (ActivityNotFoundException e5) {
                return true;
            }
        }
    };

    @TargetApi(11)
    private void a() {
        this.a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 0.0f);
        this.b = new RelativeLayout(this);
        this.b.setLayoutParams(layoutParams);
        this.b.setGravity(1);
        this.a = new WebView(this);
        if (Build.VERSION.SDK_INT >= 11) {
            a();
        }
        this.a.requestFocusFromTouch();
        this.a.setLongClickable(true);
        WebSettings settings = this.a.getSettings();
        settings.setCacheMode(1);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setSavePassword(false);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.a.setWebChromeClient(this.c);
        this.a.setWebViewClient(this.d);
        this.b.addView(this.a);
        setContentView(this.b);
        if (this.b == null || this.a == null) {
            finish();
        }
        Uri data = getIntent().getData();
        if (data != null) {
            this.a.loadUrl(data.toString());
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Uri data = intent.getData();
        if (data != null) {
            this.a.loadUrl(data.toString());
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
