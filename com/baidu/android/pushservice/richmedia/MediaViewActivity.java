package com.baidu.android.pushservice.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.browser.core.util.BdUtil;
/* loaded from: classes.dex */
public class MediaViewActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public WebView f731a;
    private RelativeLayout b;
    private WebChromeClient c = new j(this);
    private WebViewClient d = new k(this);

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        getWindow().requestFeature(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 0.0f);
        this.b = new RelativeLayout(this);
        this.b.setLayoutParams(layoutParams);
        this.b.setGravity(1);
        this.f731a = new WebView(this);
        this.f731a.requestFocusFromTouch();
        this.f731a.setLongClickable(true);
        WebSettings settings = this.f731a.getSettings();
        settings.setCacheMode(1);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(true);
        settings.setDefaultTextEncodingName(BdUtil.UTF8);
        this.f731a.setWebChromeClient(this.c);
        this.f731a.setWebViewClient(this.d);
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("MediaViewActivity", "uri=" + intent.getData().toString());
        }
        this.f731a.loadUrl(intent.getData().toString());
        this.b.addView(this.f731a);
        setContentView(this.b);
        if (this.b == null || this.f731a == null) {
            Log.e("MediaViewActivity", "Set up Layout error.");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("MediaViewActivity", "uri=" + intent.getData().toString());
        }
        this.f731a.loadUrl(intent.getData().toString());
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
