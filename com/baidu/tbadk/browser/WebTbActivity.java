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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class WebTbActivity extends BaseActivity {
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
    protected y f = null;
    private final Handler m = new Handler();
    private final Runnable n = new s(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.k.a(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebTbActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(SapiAccountManager.SESSION_BDUSS, str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.m252getInst().addRemoteActivity(this);
        UtilHelper.openGpu(this);
        b();
        if (bundle == null) {
            this.d = getIntent().getStringExtra(SapiAccountManager.SESSION_BDUSS);
        } else {
            this.d = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        }
        if (bundle == null) {
            this.e = getIntent().getStringExtra(SapiAccountManager.SESSION_PTOKEN);
        } else {
            this.e = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        }
        a();
        a(bundle);
    }

    private void a() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.d + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.e + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    private void b() {
        setContentView(com.baidu.tieba.w.web_activity);
        this.l = (LinearLayout) findViewById(com.baidu.tieba.v.softkey);
        this.j = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.a = (WebView) findViewById(com.baidu.tieba.v.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.a);
        this.a.setWebViewClient(new t(this));
        this.k = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.a.setWebChromeClient(this.k);
        WebSettings settings = this.a.getSettings();
        try {
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            settings.setPluginsEnabled(true);
            a.a(settings);
        } catch (Throwable th) {
            BdLog.e(WebTbActivity.class.getName(), "set webview settings.", th);
        }
        this.g = (ImageView) findViewById(com.baidu.tieba.v.webBack);
        this.g.setEnabled(false);
        this.g.setOnClickListener(new u(this));
        this.h = (ImageView) findViewById(com.baidu.tieba.v.webForward);
        this.h.setEnabled(false);
        this.h.setOnClickListener(new v(this));
        this.i = (ImageView) findViewById(com.baidu.tieba.v.refresh);
        this.i.setOnClickListener(new w(this));
        this.b = (ImageView) findViewById(com.baidu.tieba.v.back);
        this.b.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        a("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.m.removeCallbacks(this.n);
        TbadkApplication.m252getInst().delRemoteActivity(this);
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.k != null && (this.k instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.k).hideCustomView();
        }
    }

    private void a(Bundle bundle) {
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

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.c);
        bundle.putString(SapiAccountManager.SESSION_BDUSS, this.d);
        bundle.putString(SapiAccountManager.SESSION_PTOKEN, this.e);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.d = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        this.e = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
    }

    private void a(String str) {
        if (this.a != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.a, new Object[0]);
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }
}
