package com.baidu.tbadk.browser;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.atomData.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import java.util.Date;
import java.util.HashMap;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.g {
    public static final int DELAY_MILLIS = 1000;
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final int REQUEST_CODE_PLUGIN_DOWNLOAD_ACTIVITY = 1;
    private static final long THREE_DAYS = 259200000;
    private static HashMap<String, u> mJsInterfaces = null;
    private ImageView mBottomBack;
    private ImageView mBottomInstallPlugin;
    private ImageView mBottomRefresh;
    protected RelativeLayout mBottomTool;
    private com.baidu.tbadk.c.g mCookieInfo;
    private View mCopyLink;
    private boolean mEnableJs;
    private com.baidu.adp.lib.guide.d mInstallGuide;
    protected NavigationBar mNavigationBar;
    private View mOpenBrowser;
    protected com.baidu.tbadk.core.view.m mPopWindow;
    protected View mShareFriends;
    private String mCommonTitle = null;
    private String mUrl = null;
    private boolean mNeedCookie = false;
    protected RelativeLayout mParent = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    protected LinearLayout mWebViewContainer = null;
    private TextView mWebViewCrashTip = null;
    private final Handler mHandler = new Handler();
    private final Runnable mRunnable = new h(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(cb.class, TbWebViewActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.tb_webview_activity);
        Intent intent = getIntent();
        this.mCommonTitle = intent.getStringExtra("tag_title");
        this.mUrl = intent.getStringExtra("tag_url");
        if (this.mUrl != null && !this.mUrl.startsWith("http://") && !this.mUrl.startsWith("https://")) {
            this.mUrl = "http://".concat(this.mUrl);
        }
        this.mNeedCookie = intent.getBooleanExtra("tag_cookie", false);
        this.mEnableJs = intent.getBooleanExtra("tag_enable_js", false);
        if (ba.c(this.mUrl)) {
            com.baidu.adp.lib.util.j.a((Context) this, getResources().getString(com.baidu.tieba.x.url_is_null));
            return;
        }
        initUI();
        if (this.mNeedCookie) {
            a.a(this);
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
        this.mUrl = intent.getStringExtra("tag_url");
        refresh();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.u.parent);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.mNavigationBar.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.a(this.mCommonTitle);
        this.mBottomTool = (RelativeLayout) findViewById(com.baidu.tieba.u.webview_bottom_navigation_bar);
        View inflate = getLayoutInflater().inflate(com.baidu.tieba.v.tb_webview_pop_more, (ViewGroup) null);
        this.mPopWindow = new com.baidu.tbadk.core.view.m(this, inflate, this.mNavigationBar, getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), new l(this));
        this.mShareFriends = inflate.findViewById(com.baidu.tieba.u.webview_more_pop_item_share_friend_layout);
        this.mShareFriends.setOnClickListener(this);
        this.mOpenBrowser = inflate.findViewById(com.baidu.tieba.u.webview_more_pop_item_open_browser_layout);
        this.mOpenBrowser.setOnClickListener(this);
        this.mCopyLink = inflate.findViewById(com.baidu.tieba.u.webview_more_pop_item_copy_link_layout);
        this.mCopyLink.setOnClickListener(this);
        this.mNavigationBar.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_more, new m(this));
        this.mWebViewContainer = (LinearLayout) findViewById(com.baidu.tieba.u.webview_container);
        this.mWebViewCrashTip = (TextView) this.mWebViewContainer.findViewById(com.baidu.tieba.u.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(com.baidu.tieba.u.webview_progress);
        if (createWebView()) {
            this.mWebViewCrashTip.setVisibility(8);
        } else {
            this.mWebViewCrashTip.setVisibility(0);
        }
        this.mBottomBack = (ImageView) findViewById(com.baidu.tieba.u.tb_webview_bottom_back_button);
        this.mBottomBack.setEnabled(false);
        this.mBottomBack.setOnClickListener(new n(this));
        this.mBottomRefresh = (ImageView) findViewById(com.baidu.tieba.u.tb_webview_bottom_refresh_button);
        this.mBottomRefresh.setOnClickListener(new o(this));
        this.mBottomInstallPlugin = (ImageView) findViewById(com.baidu.tieba.u.tb_webview_bottom_install_button);
        this.mBottomInstallPlugin.setOnClickListener(this);
    }

    public void showPopMenu() {
        if (this.mPopWindow != null) {
            this.mPopWindow.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        this.mPopWindow.dismiss();
        if (view == this.mShareFriends) {
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.b = this.mCommonTitle;
            hVar.c = this.mUrl;
            if (hVar != null) {
                showShareDialog(hVar);
            }
        } else if (view == this.mOpenBrowser) {
            a.c(this, this.mUrl);
        } else if (view == this.mCopyLink) {
            com.baidu.adp.lib.util.a.a(this.mUrl);
            com.baidu.adp.lib.util.j.a(view.getContext(), view.getResources().getString(com.baidu.tieba.x.copy_pb_url_success));
        } else if (view == this.mBottomInstallPlugin && !this.mBottomInstallPlugin.isSelected()) {
            this.mBottomInstallPlugin.setSelected(true);
            if (this.mBottomInstallPlugin.isSelected()) {
                showInstallGuide();
            }
        }
    }

    private void initData() {
        if (!ba.c(this.mUrl)) {
            if (this.mUrl.indexOf("_client_version") < 0) {
                if (ba.c(Uri.parse(this.mUrl).getQuery())) {
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

    public static void startActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, u> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.j.a(context, context.getString(com.baidu.tieba.x.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_navigation_bar", true);
        intent.putExtra("tag_back", z);
        intent.putExtra("tag_refresh", z2);
        intent.putExtra("tag_cookie", z3);
        intent.putExtra("tag_enable_js", z4);
        mJsInterfaces = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityForResult(Activity activity, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, u> hashMap, int i) {
        if (UtilHelper.webViewIsProbablyCorrupt(activity)) {
            com.baidu.adp.lib.util.j.a((Context) activity, activity.getString(com.baidu.tieba.x.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(activity, TbWebViewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_navigation_bar", true);
        intent.putExtra("tag_back", z);
        intent.putExtra("tag_refresh", z2);
        intent.putExtra("tag_cookie", z3);
        intent.putExtra("tag_enable_js", z4);
        mJsInterfaces = hashMap;
        activity.startActivityForResult(intent, i);
    }

    public static void startActivityWithoutNavBar(Context context, String str, boolean z, HashMap<String, u> hashMap) {
        if (UtilHelper.webViewIsProbablyCorrupt(context)) {
            com.baidu.adp.lib.util.j.a(context, context.getString(com.baidu.tieba.x.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_url", str);
        intent.putExtra("tag_navigation_bar", false);
        intent.putExtra("tag_cookie", z);
        intent.putExtra("tag_enable_js", true);
        mJsInterfaces = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityWithJsInterface(Context context, String str, String str2, boolean z, HashMap<String, u> hashMap) {
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
                com.baidu.adp.lib.util.j.a(context, context.getString(com.baidu.tieba.x.web_view_corrupted));
                return;
            }
            Intent intent = new Intent(context, TbWebViewActivity.class);
            intent.putExtra("tag_url", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.addFlags(603979776);
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ay.a(this.mParent, i);
        if (this.mWebView != null) {
            ay.a(this.mWebView, i);
        }
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.c(i);
        }
        if (i == 1) {
            this.mBottomTool.setBackgroundResource(com.baidu.tieba.t.bg_bar_1);
            if (this.mWebView != null && this.mWebView.canGoBack()) {
                this.mBottomBack.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_n_1));
            } else {
                this.mBottomBack.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_dd));
            }
            this.mBottomBack.setBackgroundResource(com.baidu.tieba.t.title_icon_bg_1);
            this.mBottomRefresh.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_webview_refresh_n_1));
            this.mBottomRefresh.setBackgroundResource(com.baidu.tieba.t.title_icon_bg_1);
        } else {
            this.mBottomTool.setBackgroundResource(com.baidu.tieba.t.bg_bar);
            if (this.mWebView != null && this.mWebView.canGoBack()) {
                this.mBottomBack.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_n));
            } else {
                this.mBottomBack.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_dd));
            }
            this.mBottomBack.setBackgroundResource(com.baidu.tieba.t.title_icon_bg);
            this.mBottomRefresh.setImageDrawable(getResources().getDrawable(com.baidu.tieba.t.icon_webview_refresh_n));
            this.mBottomRefresh.setBackgroundResource(com.baidu.tieba.t.title_icon_bg);
        }
        this.mPopWindow.a(this, i, getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n), getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_right_n_1));
    }

    @Override // com.baidu.tbadk.coreExtra.view.g
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (ba.c(str)) {
            return false;
        }
        new Thread(new p(this, str)).start();
        if (com.baidu.tbadk.c.f.a(this, str)) {
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
            mJsInterfaces.put("TbJsBridge", new q(this));
        }
        for (String str : mJsInterfaces.keySet()) {
            this.mWebView.addJavascriptInterface(mJsInterfaces.get(str).a(this), str);
        }
    }

    private boolean createWebView() {
        if (this.mWebView == null) {
            try {
                this.mWebView = new BaseWebView(this);
                ay.a(this.mWebView, TbadkApplication.m252getInst().getSkinType());
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
                this.mWebView.setWebViewClient(new r(this));
                this.mWebView.setWebChromeClient(new s(this));
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
            dVar.a();
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
                    com.baidu.tbadk.c.g gVar = new com.baidu.tbadk.c.g(str, str2);
                    if (this.mCookieInfo == null && (this.mCookieInfo == null || !this.mCookieInfo.equals(gVar))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mCookieInfo = gVar;
                    if (this.mWebView == null && z) {
                        a.a(this);
                        this.mHandler.postDelayed(this.mRunnable, 100L);
                        return;
                    }
                }
            }
            str = str3;
            str2 = "";
            com.baidu.tbadk.c.g gVar2 = new com.baidu.tbadk.c.g(str, str2);
            if (this.mCookieInfo == null) {
            }
            z = false;
            this.mCookieInfo = gVar2;
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
        TbadkApplication.m252getInst().delRemoteActivity(this);
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
        gVar.a(0).a(false).b(com.baidu.tieba.u.webview_bottom_navigation_bar).c(true);
        gVar.a(new i(this));
        this.mInstallGuide = gVar.a();
        this.mInstallGuide.a(this);
        this.mBottomInstallPlugin.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouldShowInstallPluginDialog() {
        com.baidu.tbadk.pluginArch.d a = com.baidu.tbadk.pluginArch.d.a();
        if (a != null && !a.c("browser") && a.b("browser") != null) {
            this.mBottomInstallPlugin.setVisibility(0);
            if (!com.baidu.tbadk.core.sharedPref.b.a().a(KEY_INSTALL_PLUGIN_DIALOG_CLOSED, false)) {
                showInstallGuide();
                return;
            }
            if (new Date().getTime() - com.baidu.tbadk.core.sharedPref.b.a().a(KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime()) > THREE_DAYS) {
                showInstallGuide();
                return;
            }
            return;
        }
        this.mBottomInstallPlugin.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (this.mInstallGuide != null) {
                this.mInstallGuide.a();
                this.mBottomInstallPlugin.setSelected(false);
            }
            if (i2 == -1) {
                this.mBottomInstallPlugin.setVisibility(8);
            }
        }
    }
}
