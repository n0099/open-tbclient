package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class WebTbActivity extends BaseActivity {
    private ImageView mBottomInstallPlugin;
    protected WebView xG = null;
    private RelativeLayout xH = null;
    private ImageView xI = null;
    private ImageView xJ = null;
    private ImageView xK = null;
    protected ImageView xL = null;
    private ProgressBar xM = null;
    protected String url = null;
    private WebChromeClient xN = null;
    private LinearLayout xO = null;
    protected String xP = null;
    protected String mPtoken = null;
    protected boolean xC = false;
    protected boolean xD = false;
    protected ab xQ = null;
    private final Handler mHandler = new Handler();
    private final Runnable mRunnable = new s(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str, String str2, String str3, boolean z, boolean z2) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.m.showToast(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebTbActivity.class);
        intent.putExtra(ImageViewerConfig.URL, str);
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
            this.xC = bundle.getBoolean("autoOrientaion", false);
            this.xD = bundle.getBoolean("fullScreen", false);
        } else if (intent != null) {
            this.xC = intent.getBooleanExtra("autoOrientaion", false);
            this.xD = intent.getBooleanExtra("fullScreen", false);
        }
        if (this.xD) {
            getWindow().setFlags(1024, 1024);
        }
        if (this.xC && getRequestedOrientation() != 4) {
            setRequestedOrientation(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        a(getIntent(), bundle);
        TbadkApplication.m251getInst().addRemoteActivity(this);
        UtilHelper.openGpu(this);
        iT();
        if (bundle == null) {
            this.xP = getIntent().getStringExtra(SapiAccountManager.SESSION_BDUSS);
        } else {
            this.xP = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        }
        if (bundle == null) {
            this.mPtoken = getIntent().getStringExtra(SapiAccountManager.SESSION_PTOKEN);
        } else {
            this.mPtoken = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        }
        initCookie();
        a(bundle);
        if (this.url != null) {
            int indexOf = this.url.indexOf(47, 8);
            if (indexOf > 8) {
                str = this.url.substring(0, indexOf);
            } else {
                str = this.url;
            }
            if (!str.contains("lecai.com") && !str.contains("baidu.com")) {
                shouldShowInstallPluginDialog();
            }
        }
    }

    private void initCookie() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.xP + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.mPtoken + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    private void iT() {
        setContentView(com.baidu.tieba.w.web_activity);
        this.xO = (LinearLayout) findViewById(com.baidu.tieba.v.softkey);
        this.xM = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.xG = (WebView) findViewById(com.baidu.tieba.v.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.xG);
        this.xG.setWebViewClient(new t(this));
        this.xN = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.xG.setWebChromeClient(this.xN);
        this.xG.setDownloadListener(new u(this));
        WebSettings settings = this.xG.getSettings();
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
        this.xI = (ImageView) findViewById(com.baidu.tieba.v.webBack);
        this.xI.setEnabled(false);
        this.xI.setOnClickListener(new v(this));
        this.xJ = (ImageView) findViewById(com.baidu.tieba.v.webForward);
        this.xJ.setEnabled(false);
        this.xJ.setOnClickListener(new w(this));
        this.xK = (ImageView) findViewById(com.baidu.tieba.v.refresh);
        this.xK.setOnClickListener(new x(this));
        this.xL = (ImageView) findViewById(com.baidu.tieba.v.back);
        this.xL.setOnClickListener(new y(this));
        this.mBottomInstallPlugin = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_install_button);
        this.mBottomInstallPlugin.setOnClickListener(this);
        this.xH = (RelativeLayout) findViewById(com.baidu.tieba.v.float_tip);
        this.xH.findViewById(com.baidu.tieba.v.install).setOnClickListener(new z(this));
        this.xH.setOnClickListener(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aR(String str) {
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
        if (this.xN != null && (this.xN instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.xN).hideCustomView();
        }
        if (this.xG != null) {
            if (this.xG.getSettings() != null) {
                try {
                    this.xG.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
                    this.xG.getSettings().setJavaScriptEnabled(false);
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            try {
                this.xG.clearView();
            } catch (Exception e2) {
            }
            if (this.xG.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.xG.getParent()).removeView(this.xG);
            }
            this.xG.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mRunnable);
        TbadkApplication.m251getInst().delRemoteActivity(this);
        if (this.xM != null) {
            this.xM.setVisibility(8);
        }
    }

    private void a(Bundle bundle) {
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
        bundle.putString(SapiAccountManager.SESSION_BDUSS, this.xP);
        bundle.putString(SapiAccountManager.SESSION_PTOKEN, this.mPtoken);
        bundle.putBoolean("autoOrientaion", this.xC);
        bundle.putBoolean("fullScreen", this.xD);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.xP = bundle.getString(SapiAccountManager.SESSION_BDUSS);
        this.mPtoken = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        this.xC = bundle.getBoolean("autoOrientaion", false);
        this.xD = bundle.getBoolean("fullScreen", false);
    }

    private void callHiddenWebViewMethod(String str) {
        if (this.xG != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.xG, new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBottomInstallPlugin && !this.mBottomInstallPlugin.isSelected()) {
            this.mBottomInstallPlugin.setSelected(true);
            if (this.mBottomInstallPlugin.isSelected()) {
                showInstallGuide();
            }
        }
    }

    private void shouldShowInstallPluginDialog() {
        PluginCenter pluginCenter = PluginCenter.getInstance();
        if (pluginCenter != null && !pluginCenter.checkPluginInstalled(PluginNameList.NAME_BROWSER) && pluginCenter.getNetConfigInfo(PluginNameList.NAME_BROWSER) != null) {
            this.mBottomInstallPlugin.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, false)) {
                showInstallGuide();
                return;
            }
            if (new Date().getTime() - com.baidu.tbadk.core.sharedPref.b.lk().getLong(TbWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime()) > 259200000) {
                showInstallGuide();
                return;
            }
            return;
        }
        this.mBottomInstallPlugin.setVisibility(8);
    }

    private void showInstallGuide() {
        this.xH.setVisibility(0);
        this.mBottomInstallPlugin.setSelected(true);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.xH.isShown()) {
                this.xH.setVisibility(8);
                this.mBottomInstallPlugin.setSelected(false);
            }
            if (i2 == -1) {
                this.mBottomInstallPlugin.setVisibility(8);
            }
        }
    }
}
