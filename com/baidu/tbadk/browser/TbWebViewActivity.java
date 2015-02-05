package com.baidu.tbadk.browser;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.z;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseActivity<TbWebViewActivity> {
    public static final int DELAY_MILLIS = 1000;
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final int REQUEST_CODE_PLUGIN_DOWNLOAD_ACTIVITY = 1;
    private static HashMap<String, m> mJsInterfaces = null;
    private ImageView mBottomBack;
    private ImageView mBottomRefresh;
    protected RelativeLayout mBottomTool;
    private com.baidu.tbadk.util.p mCookieInfo;
    private View mCopyLink;
    private boolean mEnableJs;
    protected NavigationBar mNavigationBar;
    private View mOpenBrowser;
    protected MorePopupWindow mPopWindow;
    protected View mShareFriends;
    private String mCommonTitle = null;
    private String mUrl = null;
    private boolean mNeedCookie = false;
    protected RelativeLayout mParent = null;
    protected BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    protected LinearLayout mWebViewContainer = null;
    private TextView mWebViewCrashTip = null;
    private boolean mAutoChangeStyle = true;
    private final Handler mHandler = new Handler();
    private final Runnable mRunnable = new f(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.tb_webview_activity);
        Intent intent = getIntent();
        this.mCommonTitle = intent.getStringExtra(TbWebViewActivityConfig.TAG_TITLE);
        this.mUrl = intent.getStringExtra(TbWebViewActivityConfig.TAG_URL);
        if (this.mUrl != null && !this.mUrl.startsWith("http://") && !this.mUrl.startsWith("https://")) {
            this.mUrl = "http://".concat(this.mUrl);
        }
        this.mNeedCookie = intent.getBooleanExtra(TbWebViewActivityConfig.TAG_COOKIE, false);
        this.mEnableJs = intent.getBooleanExtra(TbWebViewActivityConfig.TAG_ENABLE_JS, false);
        if (bf.isEmpty(this.mUrl)) {
            com.baidu.adp.lib.util.l.showToast(getPageContext().getContext(), getResources().getString(z.url_is_null));
            return;
        }
        initUI();
        if (this.mNeedCookie) {
            a.Q(getPageContext().getContext());
        }
        initData();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra(TbWebViewActivityConfig.TAG_URL);
        refresh();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mCommonTitle);
        this.mBottomTool = (RelativeLayout) findViewById(com.baidu.tieba.w.webview_bottom_navigation_bar);
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getContext(), com.baidu.tieba.x.tb_webview_pop_more, null);
        this.mPopWindow = new MorePopupWindow(getPageContext().getPageActivity(), inflate, this.mNavigationBar, getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_right_n), new g(this));
        this.mShareFriends = inflate.findViewById(com.baidu.tieba.w.webview_more_pop_item_share_friend_layout);
        this.mShareFriends.setOnClickListener(this);
        this.mOpenBrowser = inflate.findViewById(com.baidu.tieba.w.webview_more_pop_item_open_browser_layout);
        this.mOpenBrowser.setOnClickListener(this);
        this.mCopyLink = inflate.findViewById(com.baidu.tieba.w.webview_more_pop_item_copy_link_layout);
        this.mCopyLink.setOnClickListener(this);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_more, new h(this));
        this.mWebViewContainer = (LinearLayout) findViewById(com.baidu.tieba.w.webview_container);
        this.mWebViewCrashTip = (TextView) this.mWebViewContainer.findViewById(com.baidu.tieba.w.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.w.webview_progress);
        if (createWebView()) {
            this.mWebViewCrashTip.setVisibility(8);
        } else {
            this.mWebViewCrashTip.setVisibility(0);
        }
        this.mBottomBack = (ImageView) findViewById(com.baidu.tieba.w.tb_webview_bottom_back_button);
        this.mBottomBack.setEnabled(false);
        this.mBottomBack.setOnClickListener(new i(this));
        this.mBottomRefresh = (ImageView) findViewById(com.baidu.tieba.w.tb_webview_bottom_refresh_button);
        this.mBottomRefresh.setOnClickListener(new j(this));
    }

    public void showPopMenu() {
        if (this.mPopWindow != null) {
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        com.baidu.adp.lib.g.k.a(this.mPopWindow, getPageContext().getPageActivity());
        if (view == this.mShareFriends) {
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.content = this.mCommonTitle;
            fVar.Tn = this.mUrl;
            if (fVar != null) {
                showShareDialog(fVar);
            }
        } else if (view == this.mOpenBrowser) {
            a.z(getPageContext().getPageActivity(), this.mUrl);
        } else if (view == this.mCopyLink) {
            com.baidu.adp.lib.util.a.copyToClipboard(this.mUrl);
            com.baidu.adp.lib.util.l.showToast(view.getContext(), view.getResources().getString(z.copy_pb_url_success));
        }
    }

    private void initData() {
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (!this.mAutoChangeStyle) {
            i = 0;
        }
        bc.e(this.mParent, 0);
        if (this.mWebView != null) {
            bc.e(this.mWebView, 0);
        }
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
        bc.i(this.mBottomTool, com.baidu.tieba.v.bg_bar);
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            bc.c(this.mBottomBack, com.baidu.tieba.v.icon_webview_return_n);
        } else {
            bc.c(this.mBottomBack, com.baidu.tieba.v.icon_webview_return_dd);
        }
        bc.i(this.mBottomBack, com.baidu.tieba.v.title_icon_bg);
        bc.c(this.mBottomRefresh, com.baidu.tieba.v.icon_webview_refresh_n);
        bc.i(this.mBottomRefresh, com.baidu.tieba.v.title_icon_bg);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this, i, bc.getDrawable(com.baidu.tieba.v.bg_pull_down_right_n));
        }
    }

    @JavascriptInterface
    private void addJavascriptInterface() {
        if (mJsInterfaces == null) {
            mJsInterfaces = new HashMap<>();
        }
        if (!mJsInterfaces.containsKey("TbJsBridge")) {
            mJsInterfaces.put("TbJsBridge", new k(this));
        }
        for (String str : mJsInterfaces.keySet()) {
            this.mWebView.addJavascriptInterface(mJsInterfaces.get(str).o(getPageContext().getPageActivity()), str);
        }
    }

    private boolean createWebView() {
        if (this.mWebView == null) {
            try {
                this.mWebView = new BaseWebView(getPageContext().getContext());
                bc.e(this.mWebView, TbadkCoreApplication.m255getInst().getSkinType());
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.getSettings().setAllowFileAccess(true);
                this.mWebView.getSettings().setDatabaseEnabled(true);
                this.mWebView.getSettings().setDomStorageEnabled(true);
                this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setInitialScale(100);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mWebView.setWebViewClient(genWebViewClient());
                this.mWebView.setDownloadListener(new o(this, null));
                this.mWebView.setWebChromeClient(new l(this));
                this.mWebViewContainer.addView(this.mWebView);
                if (this.mEnableJs) {
                    addJavascriptInterface();
                }
                CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    protected WebViewClient genWebViewClient() {
        return new n(this);
    }

    public void refresh() {
        this.mWebViewCrashTip.setVisibility(8);
        if (this.mWebView != null && URLUtil.isNetworkUrl(this.mUrl)) {
            this.mProgressBar.setVisibility(0);
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    private void showShareDialog(com.baidu.tbadk.coreExtra.share.f fVar) {
        if (fVar != null) {
            TiebaStatic.eventStat(getPageContext().getContext(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(getPageContext().getContext());
            dVar.a(fVar, true);
            dVar.a(getShareMtjStatInfo());
            dVar.show();
        }
    }

    private SparseArray<String> getShareMtjStatInfo() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(7);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        boolean z;
        super.onResume();
        if (this.mWebView != null) {
            callHiddenWebViewMethod("onResume");
            String str3 = "";
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkCoreApplication.getCurrentBduss());
            if (parseBDUSS != null) {
                if (parseBDUSS.mBduss != null) {
                    str3 = parseBDUSS.mBduss;
                }
                if (parseBDUSS.mPtoken != null) {
                    str = str3;
                    str2 = parseBDUSS.mPtoken;
                    com.baidu.tbadk.util.p pVar = new com.baidu.tbadk.util.p(str, str2);
                    if (this.mCookieInfo == null && (this.mCookieInfo == null || !this.mCookieInfo.equals(pVar))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mCookieInfo = pVar;
                    if (this.mWebView == null && z) {
                        a.Q(getPageContext().getContext());
                        this.mHandler.postDelayed(this.mRunnable, 100L);
                        return;
                    }
                }
            }
            str = str3;
            str2 = "";
            com.baidu.tbadk.util.p pVar2 = new com.baidu.tbadk.util.p(str, str2);
            if (this.mCookieInfo == null) {
            }
            z = false;
            this.mCookieInfo = pVar2;
            if (this.mWebView == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mWebView != null) {
            callHiddenWebViewMethod("onPause");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
        if (this.mWebView != null) {
            this.mWebView.destroy();
            this.mWebView = null;
        }
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
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
}
