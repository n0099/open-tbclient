package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.f {
    public static final int DELAY_MILLIS = 1000;
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final int REQUEST_CODE_PLUGIN_DOWNLOAD_ACTIVITY = 1;
    private static final long THREE_DAYS = 259200000;
    private static HashMap<String, p> mJsInterfaces = null;
    private ImageView mBottomBack;
    private ImageView mBottomInstallPlugin;
    private ImageView mBottomRefresh;
    protected RelativeLayout mBottomTool;
    private com.baidu.tbadk.util.j mCookieInfo;
    private View mCopyLink;
    private boolean mEnableJs;
    private com.baidu.adp.lib.guide.d mInstallGuide;
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
        TbadkApplication.m251getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.tb_webview_activity);
        Intent intent = getIntent();
        this.mCommonTitle = intent.getStringExtra(TbWebViewActivityConfig.TAG_TITLE);
        this.mUrl = intent.getStringExtra(TbWebViewActivityConfig.TAG_URL);
        if (this.mUrl != null && !this.mUrl.startsWith("http://") && !this.mUrl.startsWith("https://")) {
            this.mUrl = "http://".concat(this.mUrl);
        }
        this.mNeedCookie = intent.getBooleanExtra(TbWebViewActivityConfig.TAG_COOKIE, false);
        this.mEnableJs = intent.getBooleanExtra(TbWebViewActivityConfig.TAG_ENABLE_JS, false);
        if (ay.aA(this.mUrl)) {
            com.baidu.adp.lib.util.m.showToast(this, getResources().getString(com.baidu.tieba.y.url_is_null));
            return;
        }
        initUI();
        if (this.mNeedCookie) {
            a.s(this);
        }
        initData();
        if (this.mUrl != null) {
            int indexOf = this.mUrl.indexOf(47, 8);
            if (indexOf > 8) {
                str = this.mUrl.substring(0, indexOf);
            } else {
                str = this.mUrl;
            }
            if (!str.contains("lecai.com") && !str.contains("baidu.com")) {
                shouldShowInstallPluginDialog();
            }
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra(TbWebViewActivityConfig.TAG_URL);
        refresh();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mCommonTitle);
        this.mBottomTool = (RelativeLayout) findViewById(com.baidu.tieba.v.webview_bottom_navigation_bar);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.tb_webview_pop_more, null);
        this.mPopWindow = new MorePopupWindow(this, inflate, this.mNavigationBar, getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_right_n), new g(this));
        this.mShareFriends = inflate.findViewById(com.baidu.tieba.v.webview_more_pop_item_share_friend_layout);
        this.mShareFriends.setOnClickListener(this);
        this.mOpenBrowser = inflate.findViewById(com.baidu.tieba.v.webview_more_pop_item_open_browser_layout);
        this.mOpenBrowser.setOnClickListener(this);
        this.mCopyLink = inflate.findViewById(com.baidu.tieba.v.webview_more_pop_item_copy_link_layout);
        this.mCopyLink.setOnClickListener(this);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_more, new h(this));
        this.mWebViewContainer = (LinearLayout) findViewById(com.baidu.tieba.v.webview_container);
        this.mWebViewCrashTip = (TextView) this.mWebViewContainer.findViewById(com.baidu.tieba.v.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.v.webview_progress);
        if (createWebView()) {
            this.mWebViewCrashTip.setVisibility(8);
        } else {
            this.mWebViewCrashTip.setVisibility(0);
        }
        this.mBottomBack = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_back_button);
        this.mBottomBack.setEnabled(false);
        this.mBottomBack.setOnClickListener(new i(this));
        this.mBottomRefresh = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_refresh_button);
        this.mBottomRefresh.setOnClickListener(new j(this));
        this.mBottomInstallPlugin = (ImageView) findViewById(com.baidu.tieba.v.tb_webview_bottom_install_button);
        this.mBottomInstallPlugin.setOnClickListener(this);
    }

    public void showPopMenu() {
        if (this.mPopWindow != null) {
            this.mPopWindow.showWindowInRightBottomOfHost();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this);
        if (view == this.mShareFriends) {
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.content = this.mCommonTitle;
            hVar.MW = this.mUrl;
            if (hVar != null) {
                showShareDialog(hVar);
            }
        } else if (view == this.mOpenBrowser) {
            a.k(this, this.mUrl);
        } else if (view == this.mCopyLink) {
            com.baidu.adp.lib.util.a.an(this.mUrl);
            com.baidu.adp.lib.util.m.showToast(view.getContext(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
        } else if (view == this.mBottomInstallPlugin && !this.mBottomInstallPlugin.isSelected()) {
            this.mBottomInstallPlugin.setSelected(true);
            if (this.mBottomInstallPlugin.isSelected()) {
                showInstallGuide();
            }
        }
    }

    private void initData() {
        if (!ay.aA(this.mUrl)) {
            if (this.mUrl.indexOf("_client_version") < 0) {
                if (ay.aA(Uri.parse(this.mUrl).getQuery())) {
                    this.mUrl = String.valueOf(this.mUrl) + "?_client_version=" + TbConfig.getVersion();
                } else {
                    this.mUrl = String.valueOf(this.mUrl) + "&_client_version=" + TbConfig.getVersion();
                }
            }
            if (this.mUrl.indexOf("nohead=1") < 0) {
                this.mUrl = String.valueOf(this.mUrl) + "&nohead=1";
            }
        }
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    public static void startActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, p> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.m.showToast(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra(TbWebViewActivityConfig.TAG_TITLE, str);
        intent.putExtra(TbWebViewActivityConfig.TAG_URL, str2);
        intent.putExtra(TbWebViewActivityConfig.TAG_NAV_BAR, true);
        intent.putExtra(TbWebViewActivityConfig.TAG_BACK, z);
        intent.putExtra(TbWebViewActivityConfig.TAG_REFRESH, z2);
        intent.putExtra(TbWebViewActivityConfig.TAG_COOKIE, z3);
        intent.putExtra(TbWebViewActivityConfig.TAG_ENABLE_JS, z4);
        mJsInterfaces = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityForResult(Activity activity, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, p> hashMap, int i) {
        if (UtilHelper.webViewIsProbablyCorrupt(activity)) {
            com.baidu.adp.lib.util.m.showToast(activity, activity.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(activity, TbWebViewActivity.class);
        intent.putExtra(TbWebViewActivityConfig.TAG_TITLE, str);
        intent.putExtra(TbWebViewActivityConfig.TAG_URL, str2);
        intent.putExtra(TbWebViewActivityConfig.TAG_NAV_BAR, true);
        intent.putExtra(TbWebViewActivityConfig.TAG_BACK, z);
        intent.putExtra(TbWebViewActivityConfig.TAG_REFRESH, z2);
        intent.putExtra(TbWebViewActivityConfig.TAG_COOKIE, z3);
        intent.putExtra(TbWebViewActivityConfig.TAG_ENABLE_JS, z4);
        mJsInterfaces = hashMap;
        activity.startActivityForResult(intent, i);
    }

    public static void startActivityWithoutNavBar(Context context, String str, boolean z, HashMap<String, p> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.m.showToast(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra(TbWebViewActivityConfig.TAG_URL, str);
        intent.putExtra(TbWebViewActivityConfig.TAG_NAV_BAR, false);
        intent.putExtra(TbWebViewActivityConfig.TAG_COOKIE, z);
        intent.putExtra(TbWebViewActivityConfig.TAG_ENABLE_JS, true);
        mJsInterfaces = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityWithoutNavBar(Context context, String str, String str2, boolean z, HashMap<String, p> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.m.showToast(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra(TbWebViewActivityConfig.TAG_URL, str2);
        intent.putExtra(TbWebViewActivityConfig.TAG_NAV_BAR, false);
        intent.putExtra(TbWebViewActivityConfig.TAG_COOKIE, z);
        intent.putExtra(TbWebViewActivityConfig.TAG_ENABLE_JS, true);
        intent.putExtra(TbWebViewActivityConfig.TAG_TITLE, str);
        mJsInterfaces = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityWithJsInterface(Context context, String str, String str2, boolean z, HashMap<String, p> hashMap) {
        startActivity(context, str, str2, true, true, z, true, hashMap);
    }

    public static void startActivityWithCookie(Context context, String str, String str2, boolean z) {
        startActivity(context, str, str2, true, z, true, false, null);
    }

    public static void startActivityWithCookie(Context context, String str, String str2) {
        startActivityWithCookie(context, str, str2, false);
    }

    public static void startActivityWithRefreshButton(Context context, String str, String str2) {
        startActivity(context, str, str2, true, true, false, false, null);
    }

    public static void startActivity(Context context, String str, String str2) {
        startActivity(context, str, str2, true, false, false, false, null);
    }

    public static void startActivity(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (UtilHelper.webViewIsProbablyCorrupt(context)) {
                com.baidu.adp.lib.util.m.showToast(context, context.getString(com.baidu.tieba.y.web_view_corrupted));
                return;
            }
            Intent intent = new Intent(context, TbWebViewActivity.class);
            intent.putExtra(TbWebViewActivityConfig.TAG_URL, str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.addFlags(603979776);
            context.startActivity(intent);
        }
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
        aw.d(this.mParent, i);
        if (this.mWebView != null) {
            aw.d(this.mWebView, i);
        }
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.onChangeSkinType(i);
        }
        aw.h(this.mBottomTool, com.baidu.tieba.u.bg_bar);
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            aw.c(this.mBottomBack, com.baidu.tieba.u.icon_webview_return_n);
        } else {
            aw.c(this.mBottomBack, com.baidu.tieba.u.icon_webview_return_dd);
        }
        aw.h(this.mBottomBack, com.baidu.tieba.u.title_icon_bg);
        aw.c(this.mBottomRefresh, com.baidu.tieba.u.icon_webview_refresh_n);
        aw.h(this.mBottomRefresh, com.baidu.tieba.u.title_icon_bg);
        this.mPopWindow.onChangeSkinType(this, i, aw.getDrawable(com.baidu.tieba.u.bg_pull_down_right_n));
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (ay.aA(str)) {
            return false;
        }
        if (com.baidu.tbadk.util.i.r(this, str)) {
            return true;
        }
        this.mUrl = str;
        refresh();
        return true;
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
            this.mWebView.addJavascriptInterface(mJsInterfaces.get(str).g(this), str);
        }
    }

    private boolean createWebView() {
        if (this.mWebView == null) {
            try {
                this.mWebView = new BaseWebView(this);
                aw.d(this.mWebView, TbadkApplication.m251getInst().getSkinType());
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.getSettings().setAllowFileAccess(true);
                this.mWebView.getSettings().setDatabaseEnabled(true);
                this.mWebView.getSettings().setDomStorageEnabled(true);
                this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
                this.mWebView.setOnLoadUrlListener(this);
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setInitialScale(100);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mWebView.setWebViewClient(genWebViewClient());
                this.mWebView.setWebChromeClient(new l(this));
                this.mWebViewContainer.addView(this.mWebView);
                if (this.mEnableJs) {
                    addJavascriptInterface();
                    return true;
                }
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    protected WebViewClient genWebViewClient() {
        return new q(this);
    }

    public void refresh() {
        this.mWebViewCrashTip.setVisibility(8);
        if (this.mWebView != null && URLUtil.isNetworkUrl(this.mUrl)) {
            this.mProgressBar.setVisibility(0);
            this.mWebView.loadUrl(this.mUrl);
        }
    }

    private void showShareDialog(com.baidu.tbadk.coreExtra.share.h hVar) {
        if (hVar != null) {
            TiebaStatic.eventStat(this, TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(hVar, true);
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
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            if (parseBDUSS != null) {
                if (parseBDUSS.mBduss != null) {
                    str3 = parseBDUSS.mBduss;
                }
                if (parseBDUSS.mPtoken != null) {
                    str = str3;
                    str2 = parseBDUSS.mPtoken;
                    com.baidu.tbadk.util.j jVar = new com.baidu.tbadk.util.j(str, str2);
                    if (this.mCookieInfo == null && (this.mCookieInfo == null || !this.mCookieInfo.equals(jVar))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mCookieInfo = jVar;
                    if (this.mWebView == null && z) {
                        a.s(this);
                        this.mHandler.postDelayed(this.mRunnable, 100L);
                        return;
                    }
                }
            }
            str = str3;
            str2 = "";
            com.baidu.tbadk.util.j jVar2 = new com.baidu.tbadk.util.j(str, str2);
            if (this.mCookieInfo == null) {
            }
            z = false;
            this.mCookieInfo = jVar2;
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
        TbadkApplication.m251getInst().delRemoteActivity(this);
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

    private void showInstallGuide() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.A(0).q(false).B(com.baidu.tieba.v.webview_bottom_navigation_bar).s(true);
        gVar.a(new m(this));
        this.mInstallGuide = gVar.dA();
        this.mInstallGuide.c(this);
        this.mBottomInstallPlugin.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouldShowInstallPluginDialog() {
        PluginCenter pluginCenter = PluginCenter.getInstance();
        if (pluginCenter != null && !pluginCenter.checkPluginInstalled(PluginNameList.NAME_BROWSER) && pluginCenter.getNetConfigInfo(PluginNameList.NAME_BROWSER) != null) {
            this.mBottomInstallPlugin.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.lk().getBoolean(KEY_INSTALL_PLUGIN_DIALOG_CLOSED, false)) {
                showInstallGuide();
                return;
            }
            if (new Date().getTime() - com.baidu.tbadk.core.sharedPref.b.lk().getLong(KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime()) > THREE_DAYS) {
                showInstallGuide();
                return;
            }
            return;
        }
        this.mBottomInstallPlugin.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.mInstallGuide != null) {
                this.mInstallGuide.dismiss();
                this.mBottomInstallPlugin.setSelected(false);
            }
            if (i2 == -1) {
                this.mBottomInstallPlugin.setVisibility(8);
            }
        }
    }
}
