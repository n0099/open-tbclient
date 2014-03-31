package com.baidu.tbadk.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class WebTbActivity extends com.baidu.tbadk.a {
    protected WebView a = null;
    private ImageView g = null;
    private ImageView h = null;
    private ImageView i = null;
    protected ImageView b = null;
    private ProgressBar j = null;
    protected String c = null;
    private WebChromeClient k = null;
    private LinearLayout l = null;
    protected String d = null;
    protected String e = null;
    protected w f = null;
    private final Handler m = new Handler();
    private final Runnable n = new q(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.h(context)) {
            com.baidu.adp.lib.util.i.a(context, context.getString(com.baidu.tbadk.l.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebTbActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("bduss", str2);
        intent.putExtra("ptoken", str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.j().a(this);
        UtilHelper.a((Activity) this);
        setContentView(com.baidu.tbadk.k.web_activity);
        this.l = (LinearLayout) findViewById(com.baidu.tbadk.j.softkey);
        this.j = (ProgressBar) findViewById(com.baidu.tbadk.j.progress);
        this.a = (WebView) findViewById(com.baidu.tbadk.j.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.a);
        this.a.setWebViewClient(new r(this));
        this.k = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.a.setWebChromeClient(this.k);
        WebSettings settings = this.a.getSettings();
        try {
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            settings.setPluginsEnabled(true);
            CompatibleUtile.getInstance().WebViewNoDataBase(settings);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.a(WebTbActivity.class.getName(), "set webview settings.", th);
        }
        this.g = (ImageView) findViewById(com.baidu.tbadk.j.webBack);
        this.g.setEnabled(false);
        this.g.setOnClickListener(new s(this));
        this.h = (ImageView) findViewById(com.baidu.tbadk.j.webForward);
        this.h.setEnabled(false);
        this.h.setOnClickListener(new t(this));
        this.i = (ImageView) findViewById(com.baidu.tbadk.j.refresh);
        this.i.setOnClickListener(new u(this));
        this.b = (ImageView) findViewById(com.baidu.tbadk.j.back);
        this.b.setOnClickListener(new v(this));
        if (bundle == null) {
            this.d = getIntent().getStringExtra("bduss");
        } else {
            this.d = bundle.getString("bduss");
        }
        if (bundle == null) {
            this.e = getIntent().getStringExtra("ptoken");
        } else {
            this.e = bundle.getString("ptoken");
        }
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.d + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.e + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
        if (bundle != null) {
            this.c = bundle.getString("url");
        } else {
            this.c = getIntent().getStringExtra("url");
        }
        if (this.c == null) {
            finish();
        } else {
            this.m.postDelayed(this.n, 150L);
        }
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.pauseTimers();
        a("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.resumeTimers();
        a("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.m.removeCallbacks(this.n);
        TbadkApplication.j().b(this);
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.k != null && (this.k instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.k).hideCustomView();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.c);
        bundle.putString("bduss", this.d);
        bundle.putString("ptoken", this.e);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.d = bundle.getString("bduss");
        this.e = bundle.getString("ptoken");
    }

    private void a(String str) {
        if (this.a != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.a, new Object[0]);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }
}
