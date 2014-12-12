package com.baidu.tbadk.browser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class WebTbActivity extends BaseActivity<WebTbActivity> {
    private ImageView Bw;
    protected WebView mWebView = null;
    private RelativeLayout Bn = null;
    private ImageView Bo = null;
    private ImageView Bp = null;
    private ImageView Bq = null;
    protected ImageView Br = null;
    private ProgressBar Bs = null;
    protected String url = null;
    private WebChromeClient Bt = null;
    private LinearLayout Bu = null;
    protected String Bv = null;
    protected String mPtoken = null;
    protected boolean Bk = false;
    protected boolean Bl = false;
    protected y Bx = null;
    private final Handler mHandler = new Handler();
    private final Runnable mRunnable = new p(this);

    protected void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.Bk = bundle.getBoolean("autoOrientaion", false);
            this.Bl = bundle.getBoolean("fullScreen", false);
        } else if (intent != null) {
            this.Bk = intent.getBooleanExtra("autoOrientaion", false);
            this.Bl = intent.getBooleanExtra("fullScreen", false);
        }
        if (this.Bl) {
            getWindow().setFlags(1024, 1024);
        }
        if (this.Bk && getRequestedOrientation() != 4) {
            setRequestedOrientation(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        a(getIntent(), bundle);
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        UtilHelper.openGpu(getPageContext().getPageActivity());
        InitUI();
        if (bundle == null) {
            this.Bv = getIntent().getStringExtra(SapiAccountManager.SESSION_BDUSS);
        } else {
            this.Bv = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        }
        if (bundle == null) {
            this.mPtoken = getIntent().getStringExtra(SapiAccountManager.SESSION_PTOKEN);
        } else {
            this.mPtoken = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        }
        initCookie();
        h(bundle);
        if (this.url != null) {
            int indexOf = this.url.indexOf(47, 8);
            if (indexOf > 8) {
                str = this.url.substring(0, indexOf);
            } else {
                str = this.url;
            }
            if (!str.contains("lecai.com") && !str.contains("baidu.com")) {
                lz();
            }
        }
    }

    private void initCookie() {
        CookieSyncManager.createInstance(getPageContext().getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.Bv + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.mPtoken + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    private void InitUI() {
        setContentView(com.baidu.tieba.x.web_activity);
        this.Bu = (LinearLayout) findViewById(com.baidu.tieba.w.softkey);
        this.Bs = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.mWebView = (WebView) findViewById(com.baidu.tieba.w.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
        this.mWebView.setWebViewClient(new q(this));
        this.Bt = CompatibleUtile.getInstance().getWebChromeClient(getPageContext().getPageActivity());
        this.mWebView.setWebChromeClient(this.Bt);
        this.mWebView.setDownloadListener(new r(this));
        WebSettings settings = this.mWebView.getSettings();
        try {
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            CompatibleUtile.dealWebView(settings);
            settings.setDomStorageEnabled(true);
            settings.setAppCacheMaxSize(8388608L);
            settings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
            settings.setAllowFileAccess(true);
            settings.setAppCacheEnabled(true);
            a.WebViewNoDataBase(settings);
        } catch (Throwable th) {
            BdLog.e(th);
        }
        this.Bo = (ImageView) findViewById(com.baidu.tieba.w.webBack);
        this.Bo.setEnabled(false);
        this.Bo.setOnClickListener(new s(this));
        this.Bp = (ImageView) findViewById(com.baidu.tieba.w.webForward);
        this.Bp.setEnabled(false);
        this.Bp.setOnClickListener(new t(this));
        this.Bq = (ImageView) findViewById(com.baidu.tieba.w.refresh);
        this.Bq.setOnClickListener(new u(this));
        this.Br = (ImageView) findViewById(com.baidu.tieba.w.back);
        this.Br.setOnClickListener(new v(this));
        this.Bw = (ImageView) findViewById(com.baidu.tieba.w.tb_webview_bottom_install_button);
        this.Bw.setOnClickListener(this);
        this.Bn = (RelativeLayout) findViewById(com.baidu.tieba.w.float_tip);
        this.Bn.findViewById(com.baidu.tieba.w.install).setOnClickListener(new w(this));
        this.Bn.setOnClickListener(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bI(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("/")) == null || split.length <= 0) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\w+.apk)").matcher(split[split.length - 1]);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
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
        callHiddenWebViewMethod("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        callHiddenWebViewMethod("onResume");
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.Bt != null && (this.Bt instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.Bt).hideCustomView();
        }
        if (this.mWebView != null) {
            if (this.mWebView.getSettings() != null) {
                try {
                    this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
                    this.mWebView.getSettings().setJavaScriptEnabled(false);
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            try {
                this.mWebView.clearView();
            } catch (Exception e2) {
            }
            if (this.mWebView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            }
            this.mWebView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mRunnable);
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
        if (this.Bs != null) {
            this.Bs.setVisibility(8);
        }
    }

    private void h(Bundle bundle) {
        if (bundle != null) {
            this.url = bundle.getString(ImageViewerConfig.URL);
        } else {
            this.url = getIntent().getStringExtra(ImageViewerConfig.URL);
        }
        if (this.url == null) {
            finish();
        } else {
            this.mHandler.postDelayed(this.mRunnable, 150L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.URL, this.url);
        bundle.putString(SapiAccountManager.SESSION_BDUSS, this.Bv);
        bundle.putString(SapiAccountManager.SESSION_PTOKEN, this.mPtoken);
        bundle.putBoolean("autoOrientaion", this.Bk);
        bundle.putBoolean("fullScreen", this.Bl);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.Bv = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        this.mPtoken = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        this.Bk = bundle.getBoolean("autoOrientaion", false);
        this.Bl = bundle.getBoolean("fullScreen", false);
    }

    private void callHiddenWebViewMethod(String str) {
        if (this.mWebView != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.mWebView, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.Bw && !this.Bw.isSelected()) {
            this.Bw.setSelected(true);
            if (this.Bw.isSelected()) {
                lA();
            }
        }
    }

    private void lz() {
        this.Bw.setVisibility(8);
    }

    private void lA() {
        this.Bn.setVisibility(0);
        this.Bw.setSelected(true);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.Bn.isShown()) {
                this.Bn.setVisibility(8);
                this.Bw.setSelected(false);
            }
            if (i2 == -1) {
                this.Bw.setVisibility(8);
            }
        }
    }
}
