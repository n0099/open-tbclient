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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.r;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
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
    protected y mView;
    private HashMap<String, a> mJsInterfaces = null;
    protected boolean mAutoChangeStyle = true;
    protected boolean mShareResultToFe = false;
    private final Runnable mRunnable = new com.baidu.tbadk.browser.a(this);
    private final Runnable mShareRunnable = new b(this);

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
        this.mView = new y(this);
        initData();
        this.mView.ob();
        this.mView.f(new c(this));
        this.mView.ag(this.mIsLogin);
        this.mView.ag(isNeedShowMenuItem());
        if (!this.mView.nZ() && UtilHelper.canUseStyleImmersiveSticky()) {
            bh.b(this.mView.MJ, r.d.cp_link_tip_b, false);
        }
        adjustResizeForSoftInput();
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
            this.mView.ag(z);
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
            this.mIsShowNavBar = this.mIsShowNavBar && isNeedShowNavigationBar();
            this.mView.setNavBarVisibility(this.mIsShowNavBar);
            setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
            if (TextUtils.isEmpty(this.mUrl)) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), getResources().getString(r.j.url_is_null));
                return;
            }
            if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
                this.mView.ah(false);
            }
            this.mHandler.postDelayed(this.mRunnable, 500L);
        }
    }

    public boolean isNeedShowNavigationBar() {
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                return true;
            }
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if (KEY_NO_NAVIGATIONBAR.equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
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

    public boolean isNeedShowShareItem() {
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                return true;
            }
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if (KEY_NO_SHARE.equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
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

    public boolean isNeedShowMenuItem() {
        String[] split;
        if (StringUtils.isNull(this.mUrl)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                return true;
            }
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2 != null && split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if (KEY_NO_MENU.equalsIgnoreCase(str2) && "1".equalsIgnoreCase(str3)) {
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
            this.mView.od();
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
        TbadkCoreApplication.m9getInst().delRemoteActivity(this);
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
    public com.baidu.tbadk.coreExtra.share.f createShareContent(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            fVar.title = getResources().getString(r.j.share_from_tieba);
        } else {
            fVar.title = this.mUrlTitle;
        }
        fVar.linkUrl = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            fVar.content = this.mUrl;
        } else {
            String findSubString = findSubString(SHARE_CONTENT_START, SHARE_END);
            if (StringUtils.isNull(findSubString, true)) {
                fVar.content = this.mUrl;
            } else {
                fVar.content = findSubString;
            }
            String findSubString2 = findSubString(SHARE_IMG_START, SHARE_END);
            if (!StringUtils.isNull(findSubString2, true)) {
                fVar.imageUri = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString(SHARE_URL_START, SHARE_END);
            if (!StringUtils.isNull(findSubString3, true)) {
                fVar.linkUrl = findSubString3;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            fVar.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            fVar.linkUrl = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.content = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            fVar.imageUri = Uri.parse(str4);
        }
        return fVar;
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
        if (id == r.g.webview_more_pop_item_share_friend_layout) {
            this.mView.od();
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            this.mShareResultToFe = true;
        } else if (id == r.g.webview_more_pop_item_open_browser_layout) {
            this.mView.od();
            f.w(getPageContext().getPageActivity(), this.mUrl);
        } else if (id == r.g.webview_more_pop_item_copy_link_layout) {
            this.mView.od();
            com.baidu.adp.lib.util.a.az(this.mUrl);
            com.baidu.adp.lib.util.k.showToast(view.getContext(), view.getResources().getString(r.j.copy_pb_url_success));
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
        this.mTimer.schedule(new d(this), 10000L);
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
            this.mJsInterfaces.put("TbJsBridge", new e(this));
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
        a.b cg = com.baidu.tbadk.core.a.a.oR().cg(TbadkCoreApplication.getCurrentBduss());
        if (cg != null) {
            if (cg.pY != null) {
                str3 = cg.pY;
            }
            if (cg.Os != null) {
                str = str3;
                str2 = cg.Os;
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
            com.baidu.adp.lib.h.h.eG().post(BaseWebViewActivity.this.mShareRunnable);
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
}
