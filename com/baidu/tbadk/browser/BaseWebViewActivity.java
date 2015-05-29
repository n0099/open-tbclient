package com.baidu.tbadk.browser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.Timer;
/* loaded from: classes.dex */
public abstract class BaseWebViewActivity extends BaseActivity<BaseWebViewActivity> {
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 10000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    private com.baidu.tbadk.util.o mCookieInfo;
    protected boolean mEnableJs;
    protected boolean mIsShowNavBar;
    protected boolean mNeedCookie;
    private Timer mTimer;
    protected String mUrl;
    protected String mUrlTitle;
    protected p mView;
    private HashMap<String, e> mJsInterfaces = null;
    protected boolean mAutoChangeStyle = true;
    private final Runnable mRunnable = new a(this);

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract View createWebView();

    public abstract View getWebView();

    public abstract void initCookie();

    public abstract void initWebView();

    public abstract void loadUrl(String str);

    public abstract void onReceivedError(int i);

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 555) {
            onReceivedError(-2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initWebView();
        this.mView = new p(this);
        initData();
        this.mView.py();
        this.mView.c(new b(this));
        this.mView.aa(this.mIsLogin);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.mView != null) {
            this.mView.aa(z);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUrlTitle = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            if (this.mUrl != null && !this.mUrl.startsWith("http://") && !this.mUrl.startsWith("https://")) {
                this.mUrl = "http://".concat(this.mUrl);
            }
            this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
            this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
            this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
            this.mView.setNavBarVisibility(this.mIsShowNavBar);
            if (TextUtils.isEmpty(this.mUrl)) {
                com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), getResources().getString(t.url_is_null));
            } else {
                this.mHandler.postDelayed(this.mRunnable, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getWebView() != null && getWebView() != null && isNeedUpdateCookie()) {
            initCookie();
            this.mHandler.postDelayed(this.mRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (getWebView() == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
        if (getWebView() != null) {
            getWebView().setVisibility(8);
        }
        webViewDestory();
        TbadkCoreApplication.m411getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    public void refresh() {
        hideCrashTip();
        if (URLUtil.isNetworkUrl(this.mUrl)) {
            showProgressBar();
            loadUrl(this.mUrl);
        }
    }

    public void refreshIgnoreFormat() {
        hideCrashTip();
        showProgressBar();
        loadUrl(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callHiddenWebViewMethod(String str) {
        if (getWebView() != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == com.baidu.tieba.q.webview_more_pop_item_share_friend_layout) {
            this.mView.pA();
            com.baidu.tbadk.coreExtra.share.g gVar = new com.baidu.tbadk.coreExtra.share.g();
            gVar.content = this.mUrl;
            gVar.title = this.mUrlTitle;
            if (StringUtils.isNull(this.mUrlTitle, true)) {
                gVar.title = getResources().getString(t.share_from_tieba);
            }
            gVar.linkUrl = this.mUrl;
            if (gVar != null) {
                this.mView.a(gVar);
            }
        } else if (id == com.baidu.tieba.q.webview_more_pop_item_open_browser_layout) {
            this.mView.pA();
            f.z(getPageContext().getPageActivity(), this.mUrl);
        } else if (id == com.baidu.tieba.q.webview_more_pop_item_copy_link_layout) {
            this.mView.pA();
            com.baidu.adp.lib.util.a.copyToClipboard(this.mUrl);
            com.baidu.adp.lib.util.n.showToast(view.getContext(), view.getResources().getString(t.copy_pb_url_success));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        webViewGoBack();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && webViewGoBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoadTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new c(this), 10000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoadTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.mAutoChangeStyle) {
            i = 0;
        }
        this.mView.onChangeSkinType(i);
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        this.mView.showProgressBar();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        this.mView.hideProgressBar();
    }

    public void showCrashTip() {
        this.mView.showCrashTip();
    }

    public void hideCrashTip() {
        this.mView.hideCrashTip();
    }

    public void hideNoDataView() {
        this.mView.hideNoDataView();
    }

    public void showNoDataView() {
        this.mView.showNoDataView();
    }

    public void setNavBarVisibility(boolean z) {
        this.mView.setNavBarVisibility(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JavascriptInterface
    public void addJavascriptInterface() {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = new HashMap<>();
        }
        if (!this.mJsInterfaces.containsKey("TbJsBridge")) {
            this.mJsInterfaces.put("TbJsBridge", new d(this));
        }
        for (String str : this.mJsInterfaces.keySet()) {
            addJavascriptInterface(this.mJsInterfaces.get(str).o(getPageContext().getPageActivity()), str);
        }
    }

    private boolean isNeedUpdateCookie() {
        String str;
        String str2;
        boolean z;
        String str3 = "";
        com.baidu.tbadk.core.a.c ca = com.baidu.tbadk.core.a.a.qi().ca(TbadkCoreApplication.getCurrentBduss());
        if (ca != null) {
            if (ca.wk != null) {
                str3 = ca.wk;
            }
            if (ca.Pc != null) {
                str = str3;
                str2 = ca.Pc;
                com.baidu.tbadk.util.o oVar = new com.baidu.tbadk.util.o(str, str2);
                if (this.mCookieInfo == null && (this.mCookieInfo == null || !this.mCookieInfo.equals(oVar))) {
                    z = true;
                } else {
                    z = false;
                }
                this.mCookieInfo = oVar;
                return z;
            }
        }
        str = str3;
        str2 = "";
        com.baidu.tbadk.util.o oVar2 = new com.baidu.tbadk.util.o(str, str2);
        if (this.mCookieInfo == null) {
        }
        z = false;
        this.mCookieInfo = oVar2;
        return z;
    }
}
