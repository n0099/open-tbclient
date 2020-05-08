package com.baidu.tbadk.browser;

import android.app.Activity;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseWebViewActivity extends BaseActivity<BaseWebViewActivity> {
    private static final String BOOLEAN_VALUE_CONFIG = "1";
    private static final String KEY_FOR_NATIVE_CHECK = "enable_tieba_native_open";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    private static final String KEY_NO_MENU = "nomenu";
    private static final String KEY_NO_NAVIGATIONBAR = "nonavigationbar";
    private static final String KEY_NO_SHARE = "noshare";
    private static final String KEY_SHOW_FRS_TAB_AD = "showad";
    private static final String SHARE_CONTENT_START = "<meta name=\"description\" content=\"";
    private static final String SHARE_END = "\"";
    private static final String SHARE_IMG_START = "<img src=\"";
    private static final String SHARE_URL_START = "<meta name=\"shareurl\" content=\"";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 10000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    private ag.a mCookieInfo;
    protected boolean mEnableJs;
    protected boolean mFixTitle;
    protected boolean mIsShowNavBar;
    protected boolean mNeedCookie;
    protected boolean mNoMenu;
    protected boolean mNoShare;
    protected String mSource;
    private Timer mTimer;
    protected String mUrl;
    protected String mUrlTitle;
    protected f mView;
    private static final String SHOUBAI_SCHEME = "baiduboxapp";
    private static final String[] ALLOWED_NATIVE_SCHEME = {SHOUBAI_SCHEME, "com.baidu.nani"};
    private HashMap<String, a> mJsInterfaces = null;
    protected boolean mAutoChangeStyle = true;
    private boolean mIsTranslucent = false;
    protected boolean mShareResultToFe = false;
    private final String SHOW_MORE_FORUM_ICON = "1";
    protected boolean isNeedRefresh = true;
    protected boolean mIsFromSchema = false;
    private final Runnable mRunnable = new Runnable() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.1
        @Override // java.lang.Runnable
        public void run() {
            BaseWebViewActivity.this.refresh();
        }
    };
    private final Runnable mShareRunnable = new Runnable() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.2
        @Override // java.lang.Runnable
        public void run() {
            ShareItem createShareContent = BaseWebViewActivity.this.createShareContent(null, null, null, null);
            if (createShareContent != null) {
                BaseWebViewActivity.this.mView.a(createShareContent);
            }
        }
    };
    private final View.OnClickListener mOnRefreshClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetWorkAvailable()) {
                BaseWebViewActivity.this.showToast(R.string.neterror);
                return;
            }
            if (BaseWebViewActivity.this.mView != null) {
                BaseWebViewActivity.this.mView.hideNoDataView();
            }
            BaseWebViewActivity.this.refresh();
        }
    };
    private final CustomMessageListener webviewLoginListener = new CustomMessageListener(CmdConfigCustom.CMD_WEBVIEW_LOGIN) { // from class: com.baidu.tbadk.browser.BaseWebViewActivity.5
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
        Object d(TbPageContext<?> tbPageContext);
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
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jm().bi("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (getIntent() != null && getIntent().getBooleanExtra(TbWebViewActivityConfig.KEY_IS_FROM_SCHEMA, false) && !com.baidu.adp.base.a.jm().bi("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initWebView();
        this.mView = new f(this);
        initData();
        this.mView.aHR();
        this.mView.f(this.mOnRefreshClickListener);
        this.mView.go(this.mIsLogin);
        this.mView.go(isNeedShowMenuItem());
        if (!StringUtils.isNull(this.mUrlTitle)) {
            this.mView.tF(this.mUrlTitle);
        }
        if (!this.mView.aHP() && UtilHelper.canUseStyleImmersiveSticky() && !isTranslucent()) {
            bc.addStateBarViewSpace(this.mView.mRoot, R.color.cp_link_tip_b, false);
        }
        if (!this.mIsTranslucent) {
            adjustResizeForSoftInput();
        }
        registerListener(this.webviewLoginListener);
        if (isNeedShowADItem()) {
            this.mView.gp(true);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra("tag_url");
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.mView != null) {
            this.mView.go(z);
        }
    }

    private void initData() {
        Map<String, String> paramPair;
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri != null ? uri.toString() : null;
            if (uri != null && !StringUtils.isNull(uri2) && uri2.startsWith("com.baidu.tieba://tbwebview")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    if (decode.startsWith("//")) {
                        decode = decode.substring(2);
                    }
                    if (!StringUtils.isNull(decode) && (paramPair = ba.getParamPair(decode)) != null) {
                        this.mUrl = paramPair.get("url");
                        this.mIsShowNavBar = true;
                        this.mEnableJs = true;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                this.mUrlTitle = intent.getStringExtra("tag_title");
                this.mUrl = intent.getStringExtra("tag_url");
                this.mFixTitle = intent.getBooleanExtra("tag_fix_title", false);
                this.mUrl = parseWebViewUrl(this.mUrl);
                this.mNeedCookie = intent.getBooleanExtra("tag_cookie", false);
                this.mEnableJs = intent.getBooleanExtra("tag_enable_js", false);
                this.mIsShowNavBar = intent.getBooleanExtra("tag_navigation_bar", true);
                this.mNoShare = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_SHARE, false);
                this.mNoMenu = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_MENU, false);
            }
            this.mIsShowNavBar = this.mIsShowNavBar && isNeedShowNavigationBar();
            if (isTranslucent()) {
                this.mView.setNavBarVisibility(false);
            } else {
                this.mView.setNavBarVisibility(this.mIsShowNavBar);
            }
            setUseStyleImmersiveSticky(intent.getBooleanExtra("tag_style_immersive_sticky", true));
            if (TextUtils.isEmpty(this.mUrl)) {
                l.showToast(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
                return;
            }
            if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
                this.mView.gq(false);
            }
            this.mHandler.postDelayed(this.mRunnable, 500L);
        }
    }

    private String parseWebViewUrl(String str) {
        if (str != null && !str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return "http://".concat(str);
        }
        return str;
    }

    public boolean isNeedShowNavigationBar() {
        return parseUrlParam(KEY_NO_NAVIGATIONBAR);
    }

    public boolean isNeedShowShareItem() {
        if (this.mNoShare) {
            return false;
        }
        return parseUrlParam(KEY_NO_SHARE);
    }

    public boolean isNeedShowMenuItem() {
        if (this.mNoMenu) {
            return false;
        }
        return parseUrlParam(KEY_NO_MENU);
    }

    public boolean isNeedShowADItem() {
        return !parseUrlParam(KEY_SHOW_FRS_TAB_AD);
    }

    public boolean parseUrlParam(String str) {
        String[] split;
        if (StringUtils.isNull(this.mUrl) || StringUtils.isNull(str)) {
            return true;
        }
        try {
            String query = new URL(this.mUrl).getQuery();
            if (StringUtils.isNull(query) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
                return true;
            }
            for (String str2 : split) {
                String[] split2 = str2.split(ETAG.EQUAL);
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
            if (isNeedRefresh()) {
                this.mHandler.postDelayed(this.mRunnable, 100L);
            }
        }
    }

    public boolean isNeedRefresh() {
        return this.isNeedRefresh;
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
            this.mView.aAi();
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
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
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
        if (context == null || str == null || (parse = Uri.parse(str)) == null) {
            return null;
        }
        List<String> aRK = com.baidu.tbadk.coreExtra.data.f.aRK();
        if (v.isEmpty(aRK)) {
            return null;
        }
        String scheme = parse.getScheme();
        Iterator<String> it = aRK.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().equals(scheme)) {
                z = true;
                break;
            }
        }
        if (scheme != null && !scheme.equals(SHOUBAI_SCHEME) && !scheme.equals(com.baidu.tbadk.BdToken.f.dhq)) {
            z = z && "1".equals(parse.getQueryParameter(KEY_FOR_NATIVE_CHECK));
        }
        if (z) {
            Intent intent = new Intent("android.intent.action.VIEW", parse);
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
    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            shareItem.title = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.title = this.mUrlTitle;
        }
        shareItem.linkUrl = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            shareItem.content = this.mUrl;
        } else {
            String findSubString = findSubString(SHARE_CONTENT_START, SHARE_END);
            if (StringUtils.isNull(findSubString, true)) {
                shareItem.content = this.mUrl;
            } else {
                shareItem.content = findSubString;
            }
            String findSubString2 = findSubString(SHARE_IMG_START, SHARE_END);
            if (!StringUtils.isNull(findSubString2, true)) {
                shareItem.imageUri = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString(SHARE_URL_START, SHARE_END);
            if (!StringUtils.isNull(findSubString3, true)) {
                shareItem.linkUrl = findSubString3;
            }
        }
        updateShareItem(shareItem);
        if (!TextUtils.isEmpty(str)) {
            shareItem.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            shareItem.linkUrl = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            shareItem.content = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            shareItem.imageUri = Uri.parse(str4);
        }
        shareItem.dQr = true;
        shareItem.extData = this.mUrl;
        shareItem.dQC = 13;
        Bundle bundle = new Bundle();
        bundle.putString(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
        shareItem.Y(bundle);
        return shareItem;
    }

    private void updateShareItem(ShareItem shareItem) {
        if (shareItem != null) {
            String shareInfo = getShareInfo();
            if (!aq.isEmpty(shareInfo)) {
                try {
                    JSONObject jSONObject = new JSONObject(shareInfo);
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString("img");
                    String optString4 = jSONObject.optString("url");
                    String optString5 = jSONObject.optString(UgcConstant.TOPIC);
                    String optString6 = jSONObject.optString("wbtitle");
                    String optString7 = jSONObject.optString("wbcontent");
                    String optString8 = jSONObject.optString("isShowMoreForum");
                    if (!aq.isEmpty(optString)) {
                        shareItem.title = optString;
                    }
                    if (!aq.isEmpty(optString4)) {
                        shareItem.linkUrl = optString4;
                    }
                    if (!aq.isEmpty(optString2)) {
                        shareItem.content = optString2;
                    }
                    if (!aq.isEmpty(optString3)) {
                        shareItem.imageUri = Uri.parse(optString3);
                        shareItem.imageUrl = optString3;
                    }
                    if (!aq.isEmpty(optString5)) {
                        shareItem.topic = optString5;
                    }
                    if (!aq.isEmpty(optString6)) {
                        shareItem.dQI = optString6;
                    }
                    if (!aq.isEmpty(optString7)) {
                        shareItem.dQJ = optString7;
                    }
                    shareItem.shareType = jSONObject.optInt("shareimg");
                    if (!aq.isEmpty(optString8) && "1".equals(optString8)) {
                        shareItem.dQw = true;
                        shareItem.title = optString + " " + optString2;
                    }
                    String optString9 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString9)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString9);
                            String optString10 = jSONObject2.optString("activityid");
                            String optString11 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString10) && !StringUtils.isNull(optString11)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString10, optString11);
                                shareItem.taskCompleteId = jSONObject3.toString();
                            }
                        } catch (JSONException e) {
                        }
                    }
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    private String getShareInfoUrl() {
        String shareInfo = getShareInfo();
        if (!aq.isEmpty(shareInfo)) {
            try {
                return new JSONObject(shareInfo).optString("url");
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return "";
    }

    protected String getShareInfo() {
        return null;
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
        if (id == R.id.webview_more_pop_item_share_friend_layout) {
            this.mView.aAi();
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            com.baidu.adp.lib.f.e.lb().post(this.mShareRunnable);
            this.mShareResultToFe = true;
        } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
            this.mView.aAi();
            String shareInfoUrl = getShareInfoUrl();
            Activity pageActivity = getPageContext().getPageActivity();
            if (aq.isEmpty(shareInfoUrl)) {
                shareInfoUrl = this.mUrl;
            }
            com.baidu.tbadk.browser.a.startExternWebActivity(pageActivity, shareInfoUrl);
        } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
            this.mView.aAi();
            String shareInfoUrl2 = getShareInfoUrl();
            if (aq.isEmpty(shareInfoUrl2)) {
                shareInfoUrl2 = this.mUrl;
            }
            com.baidu.adp.lib.util.a.copyToClipboard(shareInfoUrl2);
            l.showToast(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
        } else if (id == R.id.root_view) {
            if (isTranslucent()) {
                finish();
            }
        } else if (id == R.id.widget_navi_share_button) {
            showShare();
        }
    }

    protected void showShare() {
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
        if (getWebView() instanceof BaseWebView) {
            ((BaseWebView) getWebView()).onChangeSkinType();
        }
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

    @JavascriptInterface
    public void addJavascriptInterface() {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = new HashMap<>();
        }
        for (String str : this.mJsInterfaces.keySet()) {
            addJavascriptInterface(this.mJsInterfaces.get(str).d(getPageContext()), str);
        }
        addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
    }

    private boolean isNeedUpdateCookie() {
        String str;
        String str2;
        boolean z;
        String str3 = "";
        a.b tH = com.baidu.tbadk.core.a.a.aId().tH(TbadkCoreApplication.getCurrentBduss());
        if (tH != null) {
            if (tH.mBduss != null) {
                str3 = tH.mBduss;
            }
            if (tH.mPtoken != null) {
                str = str3;
                str2 = tH.mPtoken;
                ag.a aVar = new ag.a(str, str2);
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
        ag.a aVar2 = new ag.a(str, str2);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.WEBVIEW;
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
