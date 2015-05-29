package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    protected BaseWebView mWebView = null;

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2001315, (Class) null);
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
            this.mWebView.setWebViewClient(new n(this));
            this.mWebView.setDownloadListener(new o(this, null));
            this.mWebView.setWebChromeClient(new m(this));
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
        }
        return this.mWebView;
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
            this.mWebView.destroy();
            this.mWebView = null;
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
        f.U(getPageContext().getPageActivity());
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
}
