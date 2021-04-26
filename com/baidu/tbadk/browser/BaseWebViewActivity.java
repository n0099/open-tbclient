package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.l.a;
import d.a.i0.s.c.i;
import d.a.i0.z0.n0;
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
/* loaded from: classes3.dex */
public abstract class BaseWebViewActivity extends BaseActivity<BaseWebViewActivity> {
    public static final String BOOLEAN_VALUE_CONFIG = "1";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_CLOSED = "install_plugin_dialog_closed";
    public static final String KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME = "install_plugin_dialog_shown_time";
    public static final String KEY_NO_MENU = "nomenu";
    public static final String KEY_NO_NAVIGATIONBAR = "nonavigationbar";
    public static final String KEY_NO_SHARE = "noshare";
    public static final String KEY_SHOW_FRS_TAB_AD = "showad";
    public static final String QUERY_NO_SHARE = "noshare=1";
    public static final String SHARE_CONTENT_START = "<meta name=\"description\" content=\"";
    public static final String SHARE_END = "\"";
    public static final String SHARE_IMG_START = "<img src=\"";
    public static final String SHARE_URL_START = "<meta name=\"shareurl\" content=\"";
    public static final int TIME_OUT_MSG_CODE = 555;
    public static final int URL_LOAD_TIME_OUT = 10000;
    public static final int URL_NOT_FOUND_ERROR_CODE = -2;
    public n0.b mCookieInfo;
    public boolean mEnableJs;
    public boolean mFixTitle;
    public boolean mIsFromPush;
    public boolean mIsShowNavBar;
    public boolean mNeedCookie;
    public boolean mNoMenu;
    public boolean mNoShare;
    public String mSource;
    public Timer mTimer;
    public String mUrl;
    public String mUrlTitle;
    public d.a.i0.l.e mView;
    public static final String SHOUBAI_SCHEME = "baiduboxapp";
    public static final String[] ALLOWED_NATIVE_SCHEME = {SHOUBAI_SCHEME, "com.baidu.nani"};
    public final String SHOW_MORE_FORUM_ICON = "1";
    public final Runnable mShareRunnable = new a();
    public final CustomMessageListener webviewLoginListener = new b(2921024);
    public final Runnable mRunnable = new c();
    public final View.OnClickListener mOnRefreshClickListener = new d();
    public boolean mAutoChangeStyle = true;
    public boolean mShareResultToFe = false;
    public boolean isNeedRefresh = true;
    public boolean mIsFromSchema = false;
    public HashMap<String, f> mJsInterfaces = null;
    public boolean mIsTranslucent = false;

    /* loaded from: classes3.dex */
    public final class InJavaScriptLocalObj {
        public InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void getIfFullScreen(String str) {
            if ("yes".equals(str)) {
                BaseWebViewActivity.this.setFullScreen();
            }
        }

        @JavascriptInterface
        public void getSource(String str) {
            BaseWebViewActivity.this.mSource = str;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(BaseWebViewActivity.this.getShareInfo())) {
                BaseWebViewActivity baseWebViewActivity = BaseWebViewActivity.this;
                ThreadAchievementShareDialogView threadAchievementShareDialogView = new ThreadAchievementShareDialogView(baseWebViewActivity, baseWebViewActivity.getShareInfo());
                ThreadAchievementShareInfo threadAchievementShareInfo = threadAchievementShareDialogView.f12713e;
                if (threadAchievementShareInfo != null && threadAchievementShareInfo.getParams() != null) {
                    d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(BaseWebViewActivity.this);
                    if (threadAchievementShareDialogView.h(BaseWebViewActivity.this.getPageContext(), aVar)) {
                        aVar.setContentViewSize(2);
                        aVar.setContentView(threadAchievementShareDialogView);
                        aVar.create(BaseWebViewActivity.this.getPageContext()).show();
                        return;
                    }
                    return;
                }
            }
            ShareItem createShareContent = BaseWebViewActivity.this.createShareContent(null, null, null, null);
            if (createShareContent != null) {
                BaseWebViewActivity.this.mView.I(createShareContent);
                StatisticItem statisticItem = new StatisticItem("c10898");
                statisticItem.param("obj_source", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921024 && (customResponsedMessage.getData() instanceof Boolean)) {
                BaseWebViewActivity.this.onWebViewLogin(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseWebViewActivity.this.refresh();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.z()) {
                BaseWebViewActivity.this.showToast(R.string.neterror);
                return;
            }
            d.a.i0.l.e eVar = BaseWebViewActivity.this.mView;
            if (eVar != null) {
                eVar.i();
            }
            BaseWebViewActivity.this.refresh();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends TimerTask {
        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 555;
            BaseWebViewActivity.this.mHandler.sendMessage(message);
            if (BaseWebViewActivity.this.mTimer != null) {
                BaseWebViewActivity.this.mTimer.cancel();
                BaseWebViewActivity.this.mTimer.purge();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        Object a(TbPageContext<?> tbPageContext);
    }

    private String findSubString(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.mSource.indexOf(str)) < 0) {
            return null;
        }
        int length = indexOf + str.length();
        String str3 = this.mSource;
        String substring = str3.substring(length, str3.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 < 0) {
            return null;
        }
        return substring.substring(0, indexOf2);
    }

    private String getShareInfoUrl() {
        String shareInfo = getShareInfo();
        if (k.isEmpty(shareInfo)) {
            return "";
        }
        try {
            return new JSONObject(shareInfo).optString("url");
        } catch (JSONException e2) {
            BdLog.e(e2);
            return "";
        }
    }

    private void initData() {
        Map<String, String> paramPair;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        String uri2 = uri != null ? uri.toString() : null;
        if (uri != null && !StringUtils.isNull(uri2) && uri2.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
            String decode = Uri.decode(uri.getEncodedPath());
            if (StringUtils.isNull(decode)) {
                return;
            }
            if (decode.startsWith("//")) {
                decode = decode.substring(2);
            }
            if (StringUtils.isNull(decode) || (paramPair = UrlManager.getParamPair(decode)) == null) {
                return;
            }
            this.mUrl = paramPair.get("url");
            this.mIsShowNavBar = true;
            this.mEnableJs = true;
        } else {
            this.mUrlTitle = intent.getStringExtra(WebViewActivityConfig.TAG_TITLE);
            this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
            this.mFixTitle = intent.getBooleanExtra(WebViewActivityConfig.TAG_FIX_TITLE, false);
            this.mUrl = parseWebViewUrl(this.mUrl);
            this.mNeedCookie = intent.getBooleanExtra(WebViewActivityConfig.TAG_COOKIE, false);
            this.mEnableJs = intent.getBooleanExtra(WebViewActivityConfig.TAG_ENABLE_JS, false);
            this.mIsShowNavBar = intent.getBooleanExtra(WebViewActivityConfig.TAG_NAV_BAR, true);
            this.mNoShare = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_SHARE, false);
            this.mNoMenu = intent.getBooleanExtra(WebViewActivityConfig.TAG_NO_MENU, false);
        }
        this.mIsShowNavBar = this.mIsShowNavBar && isNeedShowNavigationBar();
        if (isTranslucent()) {
            this.mView.t(false);
        } else {
            this.mView.t(this.mIsShowNavBar);
        }
        setUseStyleImmersiveSticky(intent.getBooleanExtra(WebViewActivityConfig.TAG_NEED_STYLE_IMMERSIVE_STICKY, true));
        if (TextUtils.isEmpty(this.mUrl)) {
            l.M(getPageContext().getPageActivity(), getResources().getString(R.string.url_is_null));
            return;
        }
        if (this.mUrl.contains("useImmersive=0") && "Meizu".equalsIgnoreCase(Build.BRAND)) {
            this.mView.B(false);
        }
        if (this.mUrl.contains("custompagestyle") && this.mUrl.contains(OpenFlutter.EXTRA_TRANSPARANT)) {
            this.mView.z();
        }
        this.mHandler.postDelayed(this.mRunnable, 500L);
    }

    private boolean isNeedUpdateCookie() {
        String str;
        a.b d2 = d.a.i0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
        String str2 = "";
        if (d2 != null) {
            String str3 = d2.f48989a;
            if (str3 == null) {
                str3 = "";
            }
            str = d2.f48990b;
            if (str == null) {
                str = "";
            }
            str2 = str3;
        } else {
            str = "";
        }
        boolean z = true;
        n0.b bVar = new n0.b(str2, str);
        n0.b bVar2 = this.mCookieInfo;
        if (bVar2 == null || (bVar2 != null && bVar2.equals(bVar))) {
            z = false;
        }
        this.mCookieInfo = bVar;
        return z;
    }

    private String parseWebViewUrl(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str);
    }

    private void updateShareItem(ShareItem shareItem) {
        if (shareItem == null) {
            return;
        }
        String shareInfo = getShareInfo();
        if (k.isEmpty(shareInfo)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(shareInfo);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("topic");
            String optString6 = jSONObject.optString("wbtitle");
            String optString7 = jSONObject.optString("wbcontent");
            String optString8 = jSONObject.optString("isShowMoreForum");
            if (!k.isEmpty(optString)) {
                shareItem.r = optString;
            }
            if (!k.isEmpty(optString4)) {
                shareItem.t = optString4;
            }
            if (!k.isEmpty(optString2)) {
                shareItem.s = optString2;
            }
            if (!k.isEmpty(optString3)) {
                shareItem.v = Uri.parse(optString3);
                shareItem.w = optString3;
            }
            if (!k.isEmpty(optString5)) {
                shareItem.O = optString5;
            }
            if (!k.isEmpty(optString6)) {
                shareItem.P = optString6;
            }
            if (!k.isEmpty(optString7)) {
                shareItem.Q = optString7;
            }
            shareItem.W = jSONObject.optInt("shareimg");
            if (!k.isEmpty(optString8) && "1".equals(optString8)) {
                shareItem.m = true;
                shareItem.r = optString + " " + optString2;
            }
            String optString9 = jSONObject.optString("extdata");
            if (StringUtils.isNull(optString9)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString9);
                String optString10 = jSONObject2.optString("activityid");
                String optString11 = jSONObject2.optString("missionid");
                if (StringUtils.isNull(optString10) || StringUtils.isNull(optString11)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(optString10, optString11);
                shareItem.S = jSONObject3.toString();
            } catch (JSONException unused) {
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
    }

    @JavascriptInterface
    public void addJavascriptInterface() {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = new HashMap<>();
        }
        for (String str : this.mJsInterfaces.keySet()) {
            addJavascriptInterface(this.mJsInterfaces.get(str).a(getPageContext()), str);
        }
        addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public void callHiddenWebViewMethod(String str) {
        if (getWebView() != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(getWebView(), new Object[0]);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            shareItem.r = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.r = this.mUrlTitle;
        }
        shareItem.t = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            shareItem.s = this.mUrl;
        } else {
            String findSubString = findSubString("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(findSubString, true)) {
                shareItem.s = this.mUrl;
            } else {
                shareItem.s = findSubString;
            }
            String findSubString2 = findSubString("<img src=\"", "\"");
            if (!StringUtils.isNull(findSubString2, true)) {
                shareItem.v = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(findSubString3, true)) {
                shareItem.t = findSubString3;
            }
        }
        updateShareItem(shareItem);
        if (!TextUtils.isEmpty(str)) {
            shareItem.r = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            shareItem.t = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            shareItem.s = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            shareItem.v = Uri.parse(str4);
        }
        shareItem.f13357g = true;
        shareItem.q = this.mUrl;
        shareItem.E = 13;
        Bundle bundle = new Bundle();
        bundle.putString(TiebaStatic.Params.OBJ_URL, shareItem.t);
        shareItem.k(bundle);
        return shareItem;
    }

    public abstract View createWebView();

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        setResult(-1);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.i0.k0.a
    public String getCurrentPageKey() {
        return "a012";
    }

    public String getShareInfo() {
        return null;
    }

    public abstract View getWebView();

    @Override // com.baidu.adp.base.BdBaseActivity, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 555) {
            onReceivedError(-2);
            return true;
        }
        return false;
    }

    public void hideCrashTip() {
        this.mView.h();
    }

    public void hideNoDataView() {
        this.mView.i();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void hideProgressBar() {
        this.mView.j();
    }

    public abstract void initCookie();

    public abstract void initWebView();

    public boolean isNeedRefresh() {
        return this.isNeedRefresh;
    }

    public boolean isNeedShowADItem() {
        return !parseUrlParam(KEY_SHOW_FRS_TAB_AD);
    }

    public boolean isNeedShowMenuItem() {
        if (this.mNoMenu) {
            return false;
        }
        return parseUrlParam("nomenu");
    }

    public boolean isNeedShowNavigationBar() {
        return parseUrlParam("nonavigationbar");
    }

    public boolean isNeedShowShareItem() {
        if (this.mNoShare || TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        return !this.mUrl.contains(QUERY_NO_SHARE);
    }

    public boolean isTranslucent() {
        return this.mIsTranslucent;
    }

    public abstract void loadUrl(String str);

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        webViewGoBack();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (!this.mAutoChangeStyle) {
            i2 = 0;
        }
        this.mView.n(i2);
        if (getWebView() instanceof BaseWebView) {
            ((BaseWebView) getWebView()).onChangeSkinType();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String[] split;
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.webview_more_pop_item_share_friend_layout) {
            this.mView.e();
            loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
            d.a.c.e.m.e.a().post(this.mShareRunnable);
            this.mShareResultToFe = true;
        } else if (id == R.id.webview_more_pop_item_open_browser_layout) {
            this.mView.e();
            String shareInfoUrl = getShareInfoUrl();
            Activity pageActivity = getPageContext().getPageActivity();
            if (k.isEmpty(shareInfoUrl)) {
                shareInfoUrl = this.mUrl;
            }
            d.a.i0.l.a.j(pageActivity, shareInfoUrl);
        } else if (id == R.id.webview_more_pop_item_copy_link_layout) {
            this.mView.e();
            String shareInfoUrl2 = getShareInfoUrl();
            String str = this.mUrl;
            if (str != null && str.contains(Config.LAUNCH_REFERER) && (split = this.mUrl.split("&")) != null && split.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!split[i2].contains(Config.LAUNCH_REFERER) && !split[i2].contains(TiebaStatic.Params.CUID_GALAXY2)) {
                        if (i2 != 0) {
                            sb.append("&");
                        }
                        sb.append(split[i2]);
                    }
                }
                str = sb.toString();
            }
            if (k.isEmpty(shareInfoUrl2)) {
                shareInfoUrl2 = str;
            }
            d.a.c.e.p.a.a(shareInfoUrl2);
            l.M(view.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
        } else if (id == R.id.root_view) {
            if (isTranslucent()) {
                finish();
            }
        } else if (id == R.id.widget_navi_share_button) {
            if (this.mView.x) {
                loadUrl("javascript:window.local_obj.getSource(document.getElementsByTagName('html')[0].innerHTML);");
                d.a.c.e.m.e.a().post(this.mShareRunnable);
                this.mShareResultToFe = true;
                return;
            }
            showShare();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (getIntent() != null && getIntent().getBooleanExtra(TbWebViewActivityConfig.KEY_IS_FROM_SCHEMA, false) && !d.a.c.a.b.f().h("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (getIntent() != null && getIntent().getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false) && !d.a.c.a.b.f().h("MainTabActivity")) {
            this.mIsFromPush = getIntent().getBooleanExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, false);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        initWebView();
        this.mView = new d.a.i0.l.e(this);
        initData();
        this.mView.l();
        this.mView.x(this.mOnRefreshClickListener);
        this.mView.s(this.mIsLogin);
        this.mView.s(isNeedShowMenuItem());
        if (!StringUtils.isNull(this.mUrlTitle)) {
            this.mView.w(this.mUrlTitle);
        }
        if (!this.mView.m() && UtilHelper.canUseStyleImmersiveSticky() && !isTranslucent()) {
            ViewHelper.addStateBarViewSpace(this.mView.f48584b, R.color.CAM_X0303, false);
        }
        if (!this.mIsTranslucent) {
            adjustResizeForSoftInput();
        }
        registerListener(this.webviewLoginListener);
        if (isNeedShowADItem()) {
            this.mView.r(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRunnable);
        }
        if (getWebView() != null) {
            getWebView().setVisibility(8);
        }
        webViewDestory();
        TbadkCoreApplication.getInst().delRemoteActivity(this);
        stopLoadTimer();
        d.a.i0.l.e eVar = this.mView;
        if (eVar != null) {
            eVar.o();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && webViewGoBack()) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mUrl = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        refresh();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (getWebView() == null) {
        }
    }

    public abstract void onReceivedError(int i2);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getWebView() == null || getWebView() == null || !isNeedUpdateCookie()) {
            return;
        }
        initCookie();
        if (isNeedRefresh()) {
            this.mHandler.postDelayed(this.mRunnable, 100L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        clearAnimatable();
        clearAnimation();
        dismissAllDialog();
        dismissAllPopupWindow();
        hideListMenu();
        d.a.i0.l.e eVar = this.mView;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        d.a.i0.l.e eVar = this.mView;
        if (eVar != null) {
            eVar.s(z);
        }
    }

    public void onWebViewLogin(boolean z) {
    }

    public Intent parseIntentFromUrl(Context context, String str) {
        Uri parse;
        if (context == null || str == null || (parse = Uri.parse(str)) == null) {
            return null;
        }
        List<String> a2 = i.a();
        if (ListUtils.isEmpty(a2)) {
            return null;
        }
        String scheme = parse.getScheme();
        boolean z = false;
        Iterator<String> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().equals(scheme)) {
                z = true;
                break;
            }
        }
        if (z) {
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public boolean parseUrlParam(String str) {
        String[] split;
        if (!StringUtils.isNull(this.mUrl) && !StringUtils.isNull(str)) {
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
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        return true;
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
            } catch (Throwable unused) {
            }
        }
    }

    public void refreshIgnoreFormat() {
        hideCrashTip();
        showProgressBar();
        loadUrl(this.mUrl);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    public void setAutoChangeStyle(boolean z) {
        this.mAutoChangeStyle = z;
    }

    public void setFullScreen() {
    }

    public void setIsTranslucent(boolean z) {
        this.mIsTranslucent = z;
    }

    public void setNavBarVisibility(boolean z) {
        this.mView.t(z);
    }

    public void showCrashTip() {
        this.mView.C();
    }

    public void showNoDataView() {
        this.mView.F();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showProgressBar() {
        this.mView.H();
    }

    public void showShare() {
    }

    public void showTipToast(boolean z, String str) {
        d.a.i0.l.e eVar = this.mView;
        if (eVar != null) {
            eVar.J(z, str);
        }
    }

    public void startLoadTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new e(), 10000L);
    }

    public void stopLoadTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }

    public abstract void webViewDestory();

    public abstract boolean webViewGoBack();

    public void finish(int i2, Intent intent) {
        setResult(i2, intent);
        super.finish();
    }
}
