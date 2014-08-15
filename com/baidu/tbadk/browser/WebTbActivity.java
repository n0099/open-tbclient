package com.baidu.tbadk.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.Date;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class WebTbActivity extends BaseActivity {
    private ImageView p;
    protected WebView a = null;
    private RelativeLayout i = null;
    private ImageView j = null;
    private ImageView k = null;
    private ImageView l = null;
    protected ImageView b = null;
    private ProgressBar m = null;
    protected String c = null;
    private WebChromeClient n = null;
    private LinearLayout o = null;
    protected String d = null;
    protected String e = null;
    protected boolean f = false;
    protected boolean g = false;
    protected ae h = null;
    private final Handler q = new Handler();
    private final Runnable r = new w(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.j.a(context, context.getString(com.baidu.tieba.x.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebTbActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(SapiAccountManager.SESSION_BDUSS, str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        intent.putExtra("autoOrientaion", z);
        intent.putExtra("fullScreen", z2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    protected void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.f = bundle.getBoolean("autoOrientaion", false);
            this.g = bundle.getBoolean("fullScreen", false);
        } else if (intent != null) {
            this.f = intent.getBooleanExtra("autoOrientaion", false);
            this.g = intent.getBooleanExtra("fullScreen", false);
        }
        if (this.g) {
            getWindow().setFlags(1024, 1024);
        }
        if (this.f && getRequestedOrientation() != 4) {
            setRequestedOrientation(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        a(getIntent(), bundle);
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
        if (this.c != null) {
            int indexOf = this.c.indexOf(47, 8);
            if (indexOf > 8) {
                str = this.c.substring(0, indexOf);
            } else {
                str = this.c;
            }
            if (!str.contains("lecai.com") && !str.contains("baidu.com")) {
                c();
            }
        }
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
        setContentView(com.baidu.tieba.v.web_activity);
        this.o = (LinearLayout) findViewById(com.baidu.tieba.u.softkey);
        this.m = (ProgressBar) findViewById(com.baidu.tieba.u.progress);
        this.a = (WebView) findViewById(com.baidu.tieba.u.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.a);
        this.a.setWebViewClient(new x(this));
        this.n = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.a.setWebChromeClient(this.n);
        WebSettings settings = this.a.getSettings();
        try {
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            settings.setPluginsEnabled(true);
            a.a(settings);
        } catch (Throwable th) {
            BdLog.e(th);
        }
        this.j = (ImageView) findViewById(com.baidu.tieba.u.webBack);
        this.j.setEnabled(false);
        this.j.setOnClickListener(new y(this));
        this.k = (ImageView) findViewById(com.baidu.tieba.u.webForward);
        this.k.setEnabled(false);
        this.k.setOnClickListener(new z(this));
        this.l = (ImageView) findViewById(com.baidu.tieba.u.refresh);
        this.l.setOnClickListener(new aa(this));
        this.b = (ImageView) findViewById(com.baidu.tieba.u.back);
        this.b.setOnClickListener(new ab(this));
        this.p = (ImageView) findViewById(com.baidu.tieba.u.tb_webview_bottom_install_button);
        this.p.setOnClickListener(this);
        this.i = (RelativeLayout) findViewById(com.baidu.tieba.u.float_tip);
        this.i.findViewById(com.baidu.tieba.u.install).setOnClickListener(new ac(this));
        this.i.setOnClickListener(new ad(this));
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.removeCallbacks(this.r);
        TbadkApplication.m252getInst().delRemoteActivity(this);
        if (this.m != null) {
            this.m.setVisibility(8);
        }
        if (this.n != null && (this.n instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.n).hideCustomView();
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
            this.q.postDelayed(this.r, 150L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.c);
        bundle.putString(SapiAccountManager.SESSION_BDUSS, this.d);
        bundle.putString(SapiAccountManager.SESSION_PTOKEN, this.e);
        bundle.putBoolean("autoOrientaion", this.f);
        bundle.putBoolean("fullScreen", this.g);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.d = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        this.e = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        this.f = bundle.getBoolean("autoOrientaion", false);
        this.g = bundle.getBoolean("fullScreen", false);
    }

    private void a(String str) {
        if (this.a != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.a, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.p && !this.p.isSelected()) {
            this.p.setSelected(true);
            if (this.p.isSelected()) {
                d();
            }
        }
    }

    private void c() {
        com.baidu.tbadk.pluginArch.d a = com.baidu.tbadk.pluginArch.d.a();
        if (a != null && !a.c("browser") && a.b("browser") != null) {
            this.p.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.a().a(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, false)) {
                d();
                return;
            }
            if (new Date().getTime() - com.baidu.tbadk.core.sharedPref.b.a().a(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime()) > 259200000) {
                d();
                return;
            }
            return;
        }
        this.p.setVisibility(8);
    }

    private void d() {
        this.i.setVisibility(0);
        this.p.setSelected(true);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.i.isShown()) {
                this.i.setVisibility(8);
                this.p.setSelected(false);
            }
            if (i2 == -1) {
                this.p.setVisibility(8);
            }
        }
    }
}
