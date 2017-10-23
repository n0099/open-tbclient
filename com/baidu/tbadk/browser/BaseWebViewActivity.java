package com.baidu.tbadk.browser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public abstract class BaseWebViewActivity extends BaseActivity<BaseWebViewActivity> {
    private static final String[] ALLOWED_NATIVE_SCHEME = {"baiduboxapp"};
    private static final String BOOLEAN_VALUE_CONFIG = "1";
    private static final String KEY_FOR_NATIVE_CHECK = "enable_tieba_native_open";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    private static final String KEY_NO_MENU = "nomenu";
    private static final String KEY_NO_NAVIGATIONBAR = "nonavigationbar";
    private static final String KEY_NO_SHARE = "noshare";
    private static final String SHARE_CONTENT_START = "<meta name=\"description\" content=\"";
    private static final String SHARE_END = "\"";
    private static final String SHARE_IMG_START = "<img src=\"";
    private static final String SHARE_URL_START = "<meta name=\"shareurl\" content=\"";
    private static final String TAG = "WebViewActivity";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 10000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    private x.a mCookieInfo;
    protected boolean mEnableJs;
    protected boolean mIsShowNavBar;
    protected boolean mNeedCookie;
    private String mSource;
    private Timer mTimer;
    protected String mUrl;
    protected String mUrlTitle;
    protected e mView;
    private HashMap<String, a> mJsInterfaces = null;
    protected boolean mAutoChangeStyle = true;
    private boolean mIsTranslucent = false;
    protected boolean mShareResultToFe = false;
    private final Runnable mRunnable = new Runnable() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.1
        @Override // java.lang.Runnable
        public void run() {
            BaseWebViewActivity.this.refresh();
        }
    };
    private final Runnable mShareRunnable = new Runnable() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.2
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.tbadk.coreExtra.d.d createShareContent = BaseWebViewActivity.this.createShareContent(null, null, null, null);
            if (createShareContent != null) {
                BaseWebViewActivity.this.mView.a(createShareContent);
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.hh()) {
                BaseWebViewActivity.this.showToast(d.l.neterror);
                return;
            }
            if (BaseWebViewActivity.this.mView != null) {
                BaseWebViewActivity.this.mView.hideNoDataView();
            }
            BaseWebViewActivity.this.refresh();
        }
    };
    private final CustomMessageListener webviewLoginListener = new CustomMessageListener(CmdConfigCustom.CMD_WEBVIEW_LOGIN) { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921024 && (customResponsedMessage.getData() instanceof Boolean)) {
                BaseWebViewActivity.this.onWebViewLogin(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        Object b(TbPageContext<?> tbPageContext);
    }

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
        this.mView = new e(this);
        initData();
        this.mView.od();
        this.mView.b(this.mOnRefreshClickListener);
        this.mView.af(this.mIsLogin);
        this.mView.af(isNeedShowMenuItem());
        if (!this.mView.ob() && UtilHelper.canUseStyleImmersiveSticky()) {
            ax.b(this.mView.Rh, d.e.cp_link_tip_b, false);
        }
        if (!this.mIsTranslucent) {
            adjustResizeForSoftInput();
        }
        registerListener(this.webviewLoginListener);
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
            this.mView.af(z);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUrlTitle = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            this.mUrl = parseWebViewUrl(this.mUrl);
            this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
            this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
            this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
            this.mIsShowNavBar = this.mIsShowNavBar && isNeedShowNavigationBar();
            if (isTranslucent()) {
                this.mView.setNavBarVisibility(false);
            } else {
                this.mView.setNavBarVisibility(this.mIsShowNavBar);
            }
            setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
            if (TextUtils.isEmpty(this.mUrl)) {
                l.showToast(getPageContext().getPageActivity(), getResources().getString(d.l.url_is_null));
                return;
            }
            if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
                this.mView.ag(false);
            }
            this.mHandler.postDelayed(this.mRunnable, 500L);
        }
    }

    private String parseWebViewUrl(String str) {
        if (str != null && !str.startsWith("http://") && !str.startsWith("https://")) {
            return "http://".concat(str);
        }
        return str;
    }

    public boolean isNeedShowNavigationBar() {
        return parseUrlParam(KEY_NO_NAVIGATIONBAR);
    }

    public boolean isNeedShowShareItem() {
        return parseUrlParam(KEY_NO_SHARE);
    }

    public boolean isNeedShowMenuItem() {
        return parseUrlParam(KEY_NO_MENU);
    }

    public boolean parseUrlParam(String str) {
        String[] split;
        if (StringUtils.isNull(this.mUrl) || StringUtils.isNull(str)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                return true;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2 != null && split2.length == 2) {
                    String str3 = split2[0];
                    String str4 = split2[1];
                    if (str.equalsIgnoreCase(str3) && "1".equalsIgnoreCase(str4)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
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
    public void onStop() {
        super.onStop();
        clearAnimatable();
        clearAnimation();
        dismissAllDialog();
        dismissAllPopupWindow();
        hideListMenu();
        if (this.mView != null) {
            this.mView.of();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
        }
        if (getWebView() != null) {
            getWebView().setVisibility(8);
        }
        webViewDestory();
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        stopLoadTimer();
        if (this.mView != null) {
            this.mView.release();
        }
        super.onDestroy();
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

    public void finish(int i, Intent intent) {
        setResult(i, intent);
        super.finish();
    }

    public void refresh() {
        hideCrashTip();
        if (URLUtil.isNetworkUrl(this.mUrl)) {
            showProgressBar();
            loadUrl(this.mUrl);
            return;
        }
        Intent parseIntentFromUrl = parseIntentFromUrl(getApplicationContext(), this.mUrl);
        if (parseIntentFromUrl != null) {
            try {
                startActivity(parseIntentFromUrl);
            } catch (Throwable th) {
            }
        }
    }

    private Intent parseIntentFromUrl(Context context, String str) {
        Uri parse;
        boolean z;
        boolean z2 = true;
        if (context == null || str == null || (parse = Uri.parse(str)) == null) {
            return null;
        }
        String scheme = parse.getScheme();
        String[] strArr = ALLOWED_NATIVE_SCHEME;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equals(scheme)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z || !"1".equals(parse.getQueryParameter(KEY_FOR_NATIVE_CHECK))) {
            z2 = false;
        }
        if (z2) {
            Intent intent = new Intent();
            intent.setData(parse);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    intent = null;
                }
                return intent;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.coreExtra.d.d createShareContent(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            dVar.title = getResources().getString(d.l.share_from_tieba);
        } else {
            dVar.title = this.mUrlTitle;
        }
        dVar.linkUrl = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            dVar.content = this.mUrl;
        } else {
            String findSubString = findSubString(SHARE_CONTENT_START, SHARE_END);
            if (StringUtils.isNull(findSubString, true)) {
                dVar.content = this.mUrl;
            } else {
                dVar.content = findSubString;
            }
            String findSubString2 = findSubString(SHARE_IMG_START, SHARE_END);
            if (!StringUtils.isNull(findSubString2, true)) {
                dVar.atv = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString(SHARE_URL_START, SHARE_END);
            if (!StringUtils.isNull(findSubString3, true)) {
                dVar.linkUrl = findSubString3;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            dVar.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.linkUrl = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            dVar.content = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            dVar.atv = Uri.parse(str4);
        }
        return dVar;
    }

    private String findSubString(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.mSource.indexOf(str)) < 0) {
            return null;
        }
        String substring = this.mSource.substring(indexOf + str.length(), this.mSource.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 >= 0) {
            return substring.substring(0, indexOf2);
        }
        return null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == d.h.webview_more_pop_item_share_friend_layout) {
            this.mView.of();
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            this.mShareResultToFe = true;
        } else if (id == d.h.webview_more_pop_item_open_browser_layout) {
            this.mView.of();
            com.baidu.tbadk.browser.a.Q(getPageContext().getPageActivity(), this.mUrl);
        } else if (id == d.h.webview_more_pop_item_copy_link_layout) {
            this.mView.of();
            com.baidu.adp.lib.util.a.aw(this.mUrl);
            l.showToast(view.getContext(), view.getResources().getString(d.l.copy_pb_url_success));
        } else if (id == d.h.root_view && isTranslucent()) {
            finish();
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
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Message message = new Message();
                message.what = BaseWebViewActivity.TIME_OUT_MSG_CODE;
                BaseWebViewActivity.this.mHandler.sendMessage(message);
                if (BaseWebViewActivity.this.mTimer != null) {
                    BaseWebViewActivity.this.mTimer.cancel();
                    BaseWebViewActivity.this.mTimer.purge();
                }
            }
        }, 10000L);
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
            this.mJsInterfaces.put("TbJsBridge", new a() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.5
                @Override // com.baidu.tbadk.browser.BaseWebViewActivity.a
                public Object b(TbPageContext<?> tbPageContext) {
                    return new TbJsBridge(tbPageContext);
                }
            });
        }
        for (String str : this.mJsInterfaces.keySet()) {
            addJavascriptInterface(this.mJsInterfaces.get(str).b(getPageContext()), str);
        }
        addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
    }

    private boolean isNeedUpdateCookie() {
        String str;
        String str2;
        boolean z;
        String str3 = "";
        a.b cn = com.baidu.tbadk.core.a.a.oU().cn(TbadkCoreApplication.getCurrentBduss());
        if (cn != null) {
            if (cn.wt != null) {
                str3 = cn.wt;
            }
            if (cn.SU != null) {
                str = str3;
                str2 = cn.SU;
                x.a aVar = new x.a(str, str2);
                if (this.mCookieInfo == null && (this.mCookieInfo == null || !this.mCookieInfo.equals(aVar))) {
                    z = true;
                } else {
                    z = false;
                }
                this.mCookieInfo = aVar;
                return z;
            }
        }
        str = str3;
        str2 = "";
        x.a aVar2 = new x.a(str, str2);
        if (this.mCookieInfo == null) {
        }
        z = false;
        this.mCookieInfo = aVar2;
        return z;
    }

    /* loaded from: classes.dex */
    final class InJavaScriptLocalObj {
        InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void getSource(String str) {
            BaseWebViewActivity.this.mSource = str;
            com.baidu.adp.lib.g.e.fP().post(BaseWebViewActivity.this.mShareRunnable);
        }

        @JavascriptInterface
        public void getIfFullScreen(String str) {
            if ("yes".equals(str)) {
                BaseWebViewActivity.this.setFullScreen();
            }
        }
    }

    protected void setFullScreen() {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a012";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onWebViewLogin(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIsTranslucent(boolean z) {
        this.mIsTranslucent = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTranslucent() {
        return this.mIsTranslucent;
    }
}
