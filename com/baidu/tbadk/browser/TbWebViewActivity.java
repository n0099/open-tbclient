package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static final int FILECHOOSER_RESULTCODE = 1;
    private ValueCallback<Uri> mUploadMessage;
    protected BaseWebView mWebView = null;

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_WEBVIEW_PROXY, (Class) null);
        if (this.mNeedCookie) {
            initCookie();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getWebView() != null) {
            callHiddenWebViewMethod("onResume");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        callHiddenWebViewMethod("onPause");
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        if (this.mWebView == null) {
            this.mWebView = new BaseWebView(getPageContext().getPageActivity());
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.getSettings().setAllowFileAccess(true);
            this.mWebView.getSettings().setDatabaseEnabled(true);
            this.mWebView.getSettings().setDomStorageEnabled(true);
            this.mWebView.getSettings().setSupportZoom(true);
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.getSettings().setUseWideViewPort(true);
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollbarOverlay(false);
            this.mWebView.setInitialScale(100);
            this.mWebView.setScrollBarStyle(33554432);
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mWebView.setWebViewClient(new a());
            this.mWebView.setDownloadListener(new b(this, null));
            this.mWebView.setWebChromeClient(new TbWebChromeClient(this));
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
        }
        return this.mWebView;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && getUploadMessage() != null) {
            getUploadMessage().onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
            setUploadMessage(null);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        if (this.mWebView != null) {
            this.mWebView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        return this.mWebView;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void loadUrl(String str) {
        if (this.mWebView != null) {
            CompatibleUtile.getInstance().loadUrl(this.mWebView, str);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        if (this.mWebView != null) {
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            com.baidu.adp.lib.g.h.hh().postDelayed(new n(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* loaded from: classes.dex */
    protected class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mUrl = str;
                if (StringUtils.isNull(TbWebViewActivity.this.mUrlTitle)) {
                    TbWebViewActivity.this.mUrlTitle = TbWebViewActivity.this.mWebView.getTitle();
                }
                TbWebViewActivity.this.mView.bV(TbWebViewActivity.this.mUrlTitle);
                TbWebViewActivity.this.mView.setNavBarVisibility(TbWebViewActivity.this.mIsShowNavBar);
                TbWebViewActivity.this.hideProgressBar();
                TbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mWebView.stopLoading();
                TbWebViewActivity.this.stopLoadTimer();
                TbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.showProgressBar();
                TbWebViewActivity.this.startLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (com.baidu.tbadk.util.p.a(TbWebViewActivity.this, str)) {
                TbWebViewActivity.this.finish();
                return true;
            }
            TbWebViewActivity.this.mUrl = str;
            TbWebViewActivity.this.refresh();
            return true;
        }
    }

    /* loaded from: classes.dex */
    private class b implements DownloadListener {
        private b() {
        }

        /* synthetic */ b(TbWebViewActivity tbWebViewActivity, b bVar) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!StringUtils.isNull(str)) {
                TbWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        g.W(getApplicationContext());
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i) {
        if (this.mWebView != null) {
            this.mUrl = this.mWebView.getUrl();
            this.mWebView.stopLoading();
        }
        hideProgressBar();
        showNoDataView();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    public ValueCallback<Uri> getUploadMessage() {
        return this.mUploadMessage;
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
    }
}
