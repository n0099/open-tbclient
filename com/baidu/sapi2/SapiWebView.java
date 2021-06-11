package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.alibaba.fastjson.asm.Label;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.FromType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.wallet.api.IWalletLoginListener;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.yy.hiidostatis.defs.controller.SensorController;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes2.dex */
public class SapiWebView extends WebView {
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    public static final String ACTION_FORGET_PWD = "forget-pwd";
    public static final String ACTION_MODIFY_PWD = "modify-pwd";
    public static final String ACTION_RENREN_OFFLINE = "renren-offline";
    public static final int AUTHORIZATION_TYPE_OPEN = 1;
    public static final int AUTHORIZATION_TYPE_PASS = 0;
    public static final String BROWSE_MODE_AGREEMENT_HOST = "https://s.bdstatic.com";
    public static final String CALLBACK_PARAM_KEY = "__wp-action";
    public static final String CUSTOM_CSS_INTERPRETER_URL = "css/sapi_theme/style.css";
    public static final String DATA_ENCODING = "UTF-8";
    public static final String DATA_MIME_TYPE = "text/html";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final String FN_GUIDE_PROCESS = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.setXml){Pass.client.setXml('%s')}}())";
    public static final String FN_NET_AVAILABLE = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    public static final String FN_SWITCH_VIEW = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL = "取消";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_MSG = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_SET_TIME = "立即设置时间";
    public static final String HTTPS_SSL_DATE_INVALID_DIALOG_TITLE = "系统时间错误";
    public static final String HTTPS_SSL_UNTRUSTED_DIALOG_MSG = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String HTTPS_SSL_UNTRUSTED_DIALOG_TITLE = "证书安全警告";
    public static final String PARAMS_IS_ACCEPT_BROWSEMODE_AGREEMENT = "isAcceptBrowseModeAgreement";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String PARAMS_SCREEN_TYPE = "screenType";
    public static final String PROMPT_ON_CANCEL = "prompt_on_cancel";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    public static final String SWITCH_ACCOUNT_PAGE = "switch_account";
    public static final String URL_HASH_CHINA_MOBILE_OAUTH = "#oneKeyLogin";
    public static final String URL_HASH_FACE_LOGIN = "#face_login";
    public static final String URL_HASH_FAST_REG = "#fastReg";
    public static final String URL_HASH_INSERT_LOGIN = "#insert_account";
    public static final String URL_HASH_JOIN_LOGIN = "#canshareAi";
    public static final String URL_HASH_LOGIN = "#login";
    public static final String URL_HASH_LOGIN_WITH_USERNAME = "#authPwd";
    public static final String URL_HASH_REG = "#reg";
    public static final String URL_HASH_SHARE = "#canshare_accounts";
    public static final String URL_HASH_SHARE_OAUTH = "#share_auth";
    public static final String URL_HASH_SMS_LOGIN = "#sms_login";
    public static StatLoadLogin statLoadLogin;
    public AccountChangeCallback accountChangeCallback;
    public List<String> asynJsMehodName;
    public ChangePwdCallback changePwdCallback;
    public SapiConfiguration configuration;
    public Dialog dateInvalidDialog;
    public List<PassNameValuePair> extras;
    public FileChooserCallback fileChooserCallback;
    public boolean isDestory;
    public volatile boolean isLoadThirdPartyUrl;
    public boolean isSupFaceLogin;
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public SapiJsInterpreters jsInterpreters;
    public int leftBtnIsVisible;
    public LoginTypes mExcludeTypes;
    public boolean mHadMakeBarHide;
    public View noNetworkView;
    public OnBackCallback onBackCallback;
    public OnFinishCallback onFinishCallback;
    public OnNewBackCallback onNewBackCallback;
    public ProgressBar progressBar;
    public ProgressDialog progressDialog;
    public ReloadConfig reloadConfig;
    public SapiCache sapiCache;
    public boolean shareV2Disable;
    public boolean shouldClose;
    public boolean showLinkAccount;
    public boolean showSwitchAccount;
    public boolean supportTouchGuide;
    public Handler timeoutHandler;
    public long timeoutMillis;
    public TimeoutTask timeoutTask;
    public View timeoutView;
    public String[] touchidPortraitAndSign;
    public volatile String userInfoXmlContent;
    public WebChromeClientCallback webChromeClientCallback;
    public WebviewClientCallback webviewClientCallback;
    public View webviewLoadingView;
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair("direct", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_PHONE = new PassNameValuePair("supportPhone", "1");
    public static final PassNameValuePair EXTRA_ERROR_ONE_KEY_LOGIN_FAIL = new PassNameValuePair("sdkError", "oneKeyLoginFail");

    /* loaded from: classes2.dex */
    public interface AccountChangeCallback {
        void onAccountChange();
    }

    /* loaded from: classes2.dex */
    public static abstract class AccountDestoryCallback {

        /* loaded from: classes2.dex */
        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class AccountFreezeCallback {

        /* loaded from: classes2.dex */
        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    /* loaded from: classes2.dex */
    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        
        public String methodName;

        ActivityLifeCycle(String str) {
            this.methodName = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface BdussChangeCallback {
        void onBdussChange();
    }

    /* loaded from: classes2.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes2.dex */
    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        /* loaded from: classes2.dex */
        public static abstract class BioScanFaceResult {
            public int showGuidePage;
            public String subpro;
            public int type;
            public String uid;
            public Map<String, String> transParamsMap = new HashMap();
            public List<PassNameValuePair> transParamsList = new ArrayList();

            public abstract void setScanFaceIdentifyResult(String str);
        }

        void onBioScanFace(BioScanFaceResult bioScanFaceResult);
    }

    /* loaded from: classes2.dex */
    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class BiometricsIdentifyResult {
        public static final int ERROR_CODE_GET_STOKEN_FAILED = -402;
        public static final String ERROR_MSG_GET_STOKEN_FAILED = "服务异常，请稍后再试";
        public static final String LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN = "authtoken";
        public static final String LIVENESS_RECOGNIZE_TYPE_BDUSS = "bduss";
        public static final String LIVENESS_RECOGNIZE_TYPE_CERTINFO = "certinfo";
        public String authToken;
        public int biometricType;
        public String idCardNum;
        public String livenessRecogType;
        public String phoneNum;
        public String realName;
        public int recordVideo;
        public int showGuidePage;
        public String subPro;

        public abstract void setIdentifyToken(String str);
    }

    /* loaded from: classes2.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public static class Command {
        public String actionName;
        public List<String> actionParams = new ArrayList();

        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                Command command = new Command();
                JSONObject optJSONObject = jSONObject.optJSONObject("action");
                if (optJSONObject != null) {
                    command.actionName = optJSONObject.optString("name");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            command.actionParams.add(optJSONArray.optString(i2));
                        }
                    }
                }
                return command;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }

        public String getActionName() {
            return this.actionName;
        }

        public List<String> getActionParams() {
            return this.actionParams;
        }
    }

    /* loaded from: classes2.dex */
    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    /* loaded from: classes2.dex */
    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    /* loaded from: classes2.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes2.dex */
        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    /* loaded from: classes2.dex */
    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i2);
    }

    /* loaded from: classes2.dex */
    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    /* loaded from: classes2.dex */
    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    /* loaded from: classes2.dex */
    public interface LoadSlideWebViewCallback {
        void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult);
    }

    /* loaded from: classes2.dex */
    public static class LoadSlideWebViewResult {
        public String adapter;
        public String page;
        public String placeholderTitle;
        public String url;
    }

    /* loaded from: classes2.dex */
    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    /* loaded from: classes2.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes2.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes2.dex */
    public interface OnNewBackCallback {
        boolean onBack();
    }

    /* loaded from: classes2.dex */
    public interface OnSlidePageFinishCallback {
        void onFinish(String str);
    }

    /* loaded from: classes2.dex */
    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i2, int i3, int i4, PickPhotoResult pickPhotoResult);
    }

    /* loaded from: classes2.dex */
    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class PreFillUserNameCallback {

        /* loaded from: classes2.dex */
        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    /* loaded from: classes2.dex */
    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes2.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes2.dex */
    public class ReloadConfig {
        public boolean bindAccount;
        public List<PassNameValuePair> paramsList;
        public String timeoutUrl;
        public String weixinBindUrl;
        public boolean wxSsoReload;

        public ReloadConfig() {
            this.timeoutUrl = null;
            this.wxSsoReload = false;
        }

        public void reset() {
            this.timeoutUrl = null;
            this.wxSsoReload = false;
        }
    }

    /* loaded from: classes2.dex */
    public interface ShareAccountClickCallback {
        void onClick(String str, String str2, String str3, String str4, String str5);
    }

    /* loaded from: classes2.dex */
    public static abstract class SwitchAccountCallback {

        /* loaded from: classes2.dex */
        public static class Result {
            public String displayName;
            public String encryptedUid;
            public String extraJson;
            public int loginType;
            public int switchAccountType;
            public String userName;
        }

        public abstract void onAccountSwitch(Result result);
    }

    /* loaded from: classes2.dex */
    public class TimeoutTask implements Runnable {
        public String url;

        public TimeoutTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.url;
                SapiWebView.this.timeoutHandler.sendMessage(message);
                SapiWebView.this.timeoutHandler.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes2.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* loaded from: classes2.dex */
    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i2, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes2.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes2.dex */
    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.reloadConfig = new ReloadConfig();
        this.timeoutHandler = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.handleTimeout();
                }
            }
        };
        this.timeoutTask = new TimeoutTask();
        this.leftBtnIsVisible = 1;
        this.touchidPortraitAndSign = new String[2];
        init();
    }

    private String addExtras(String str, List<PassNameValuePair> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (PassNameValuePair passNameValuePair : list) {
                if (!TextUtils.isEmpty(passNameValuePair.getName()) && !TextUtils.isEmpty(passNameValuePair.getValue())) {
                    try {
                        arrayList.add(new PassNameValuePair(URLEncoder.encode(passNameValuePair.getName(), "UTF-8"), URLEncoder.encode(passNameValuePair.getValue(), "UTF-8")));
                    } catch (UnsupportedEncodingException e2) {
                        Log.e(e2);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return str;
            }
            return str + "&" + SapiUtils.createRequestParams(arrayList);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authorizeSuccess(AccountType accountType) {
        if (!TextUtils.isEmpty(this.jsCallBacks.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.jsCallBacks.touchidPortraitAndSign;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        AuthorizationListener authorizationListener = this.jsCallBacks.authorizationListener;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.jsCallBacks.authorizationListener.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.jsCallBacks.authorizationListener.onSuccess();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void configSapiWebView() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            Log.e(e2);
        }
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + " " + getUaInfo());
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        setScrollBarStyle(0);
        settings.setSaveFormData(false);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null) {
            settings.setTextZoom(sapiConfiguration.textZoom);
        }
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fixAdapterParamValue(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        boolean z2 = false;
        if (confignation == null) {
            z = false;
        } else {
            if (!this.mHadMakeBarHide && confignation.customActionBarEnabled) {
                z2 = true;
            }
            z = confignation.showBottomBack;
        }
        return replaceParams(str, "adapter", ParamsUtil.getAdapterParamValue(z2, z));
    }

    private String generateJSStr(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    public static String getMatcher(String str, String str2) {
        Pattern compile = Pattern.compile(str);
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        Matcher matcher = compile.matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadingView() {
        View view = this.noNetworkView;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.timeoutView;
            if (view2 == null || view2.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.webviewLoadingView != null) {
                            SapiWebView.this.webviewLoadingView.setVisibility(0);
                            if (SapiWebView.this.progressBar != null) {
                                SapiWebView.this.progressBar.setVisibility(8);
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkUnavailable() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.progressBar != null) {
                    SapiWebView.this.progressBar.setVisibility(8);
                }
                if (SapiWebView.this.webviewLoadingView != null) {
                    SapiWebView.this.webviewLoadingView.setVisibility(8);
                }
                if (SapiWebView.this.noNetworkView != null) {
                    SapiWebView.this.noNetworkView.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTimeout() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.progressBar != null) {
                    SapiWebView.this.progressBar.setVisibility(8);
                }
                if (SapiWebView.this.webviewLoadingView != null) {
                    SapiWebView.this.webviewLoadingView.setVisibility(8);
                }
                SapiWebView.this.reloadConfig.timeoutUrl = SapiWebView.this.timeoutTask.url;
                if (SapiWebView.this.timeoutView != null) {
                    SapiWebView.this.timeoutView.setVisibility(0);
                }
            }
        });
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void init() {
        SapiJsCallBacks.CallBacks callBacks = new SapiJsCallBacks.CallBacks();
        this.jsCallBacks = callBacks;
        this.jsInterpreters = new SapiJsInterpreters(this, callBacks);
        this.timeoutMillis = DEFAULT_TIMEOUT_MILLIS;
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
        this.sapiCache = new SapiCache();
        this.isSupFaceLogin = new FaceLoginService().isSupFaceLogin();
        configSapiWebView();
        setAsynJsMehodName();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new AnonymousClass2());
        setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.SapiWebView.3
            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i3, String str2) {
                Log.d(str + " -- From line " + i3 + " of " + str2, new Object[0]);
                if (SapiWebView.this.webChromeClientCallback != null) {
                    SapiWebView.this.webChromeClientCallback.onConsoleMessage(str, i3, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        jsResult.confirm();
                    }
                });
                positiveButton.setCancelable(false);
                positiveButton.create();
                positiveButton.show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.webChromeClientCallback != null && SapiWebView.this.webChromeClientCallback.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.webChromeClientCallback.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.i(Log.TAG, "webview", str2);
                final String[] strArr = {""};
                SapiWebView.this.jsCallBacks.promptResult = jsPromptResult;
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if (SapiWebView.this.asynJsMehodName.contains(actionName)) {
                                SapiWebView.this.jsCallBacks.promptResult = jsPromptResult;
                            }
                            SapiJsInterpreters.AbstractInterpreter interpreter = SapiWebView.this.jsInterpreters.getInterpreter(actionName);
                            if (interpreter != null) {
                                try {
                                    strArr[0] = interpreter.interpret(parse);
                                } catch (Throwable th) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("errno", 0);
                                        jSONObject.put("msg", "native function error");
                                        strArr[0] = jSONObject.toString();
                                        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                                        linkedHashMap.put("name", "native_fun_error");
                                        HashMap hashMap = new HashMap(2);
                                        hashMap.put("msg", android.util.Log.getStackTraceString(th));
                                        hashMap.put("action_name", actionName);
                                        StatService.onEventAutoStatistic(linkedHashMap, hashMap);
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            if (parse.getActionParams().size() <= 2 || !SapiWebView.PROMPT_ON_CANCEL.equals(parse.getActionParams().get(2))) {
                                if (SapiWebView.this.asynJsMehodName.contains(actionName)) {
                                    return;
                                }
                                jsPromptResult.confirm(strArr[0]);
                                return;
                            }
                            jsPromptResult.cancel();
                            return;
                        }
                        jsPromptResult.cancel();
                    }
                });
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                if (SapiWebView.this.progressBar != null) {
                    if (i3 == 100) {
                        SapiWebView.this.progressBar.setVisibility(8);
                    } else {
                        if (SapiWebView.this.progressBar.getVisibility() == 8) {
                            SapiWebView.this.progressBar.setVisibility(0);
                        }
                        SapiWebView.this.progressBar.setProgress(i3);
                    }
                }
                super.onProgressChanged(webView, i3);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(5)
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(j * 2);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.fileChooserCallback != null) {
                    SapiWebView.this.fileChooserCallback.onFileChooser(valueCallback);
                }
            }
        });
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        StatLoadLogin statLoadLogin2 = statLoadLogin;
        if (statLoadLogin2 != null) {
            statLoadLogin2.tWebviewInitDone = System.currentTimeMillis();
        }
    }

    private boolean isValidPackage() {
        for (String str : SapiContext.getInstance().getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    private void loadChinaMobileLogin(int i2, List<PassNameValuePair> list) {
        String str = addExtras(getLoginUrl(), list) + "&loginInitType=" + i2;
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            str = str + "&hideHelp=1";
        }
        loadUrl(str + URL_HASH_CHINA_MOBILE_OAUTH);
    }

    private void loadFaceLogin(List<PassNameValuePair> list) {
        String addExtras = addExtras(getLoginUrl(), list);
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            addExtras = addExtras + "&enableExternalWeb=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            addExtras = addExtras + "&hideHelp=1";
        }
        loadUrl((addExtras + "&liveAbility=1") + URL_HASH_FACE_LOGIN);
    }

    private void loadJoinLogin(List<PassNameValuePair> list) {
        String addExtras = addExtras(getLoginUrl(), list);
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            addExtras = addExtras + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            addExtras = addExtras + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            addExtras = addExtras + "&hideHelp=1";
        }
        loadUrl(addExtras + URL_HASH_JOIN_LOGIN);
    }

    private void loadNameLogin(int i2) {
        String str = addExtras(getLoginUrl(), this.extras) + "&loginInitType=" + i2;
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            str = str + "&hideHelp=1";
        }
        loadUrl(str + URL_HASH_INSERT_LOGIN);
    }

    private void loadNormalLogin(int i2, List<PassNameValuePair> list) {
        String str = addExtras(getLoginUrl(), list) + "&loginInitType=" + i2;
        if (i2 == 0) {
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                str = str + "&hideHelp=1";
            }
            loadUrl(str + URL_HASH_LOGIN);
        } else if (i2 != 1) {
            loadUrl(str + URL_HASH_LOGIN);
        } else {
            if (this.jsCallBacks.loadExternalWebViewCallback != null) {
                str = str + "&enableExternalWeb=1";
            }
            if (this.configuration.supportFaceLogin) {
                str = str + "&liveAbility=1";
            }
            if (this.configuration.isHideLoginHelpEntrance) {
                str = str + "&hideHelp=1";
            }
            loadUrl(str + URL_HASH_SMS_LOGIN);
        }
    }

    private void loadShareAccounts(int i2, List<PassNameValuePair> list) {
        String str;
        String loginUrl = getLoginUrl();
        if (this.jsCallBacks.loadExternalWebViewCallback != null) {
            loginUrl = loginUrl + "&enableExternalWeb=1";
        }
        if (this.configuration.supportFaceLogin) {
            loginUrl = loginUrl + "&liveAbility=1";
        }
        if (this.configuration.isHideLoginHelpEntrance) {
            loginUrl = loginUrl + "&hideHelp=1";
        }
        if (this.isSupFaceLogin && this.jsCallBacks.biometricsIdentifyCallback != null) {
            str = loginUrl + "&loginInitType=4";
        } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
            str = loginUrl + "&loginInitType=5";
        } else {
            str = loginUrl + "&loginInitType=" + i2;
        }
        loadUrl(addExtras(str, list) + URL_HASH_SHARE);
    }

    private void loadUrlFromNetwork(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.isDestory) {
                    return;
                }
                String fixAdapterParamValue = SapiWebView.this.fixAdapterParamValue(str);
                SapiWebView.this.statLoadLogin(fixAdapterParamValue, false);
                SapiWebView.super.loadUrl(fixAdapterParamValue);
            }
        });
        if (SapiUtils.hasActiveNetwork(getContext()) || str.startsWith("javascript:")) {
            return;
        }
        handleNetworkUnavailable();
    }

    public static SocialResponse parseOpenApiAuthorizedResult(String str, Context context) {
        SocialResponse socialResponse;
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
        SocialResponse socialResponse2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType != 2) {
                    continue;
                } else {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase("data")) {
                        if (socialResponse2 == null && name.equalsIgnoreCase("error_code")) {
                            socialResponse = new SocialResponse();
                            try {
                                socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            } catch (Exception e2) {
                                socialResponse2 = socialResponse;
                                e = e2;
                                Log.e(e);
                                return socialResponse2;
                            }
                        } else if (socialResponse2 == null && name.equalsIgnoreCase("error_description")) {
                            socialResponse = new SocialResponse();
                            socialResponse.errorMsg = newPullParser.nextText();
                        } else if (socialResponse2 == null) {
                            continue;
                        } else if (name.equalsIgnoreCase("error_code")) {
                            socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("error_description")) {
                            socialResponse2.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("is_binded")) {
                            socialResponse2.isBinded = "1".equals(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("display_name")) {
                            socialResponse2.displayname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("passport_uname")) {
                            socialResponse2.username = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduid")) {
                            socialResponse2.uid = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduss")) {
                            socialResponse2.bduss = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                            socialResponse2.ptoken = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_username")) {
                            socialResponse2.socialUname = newPullParser.nextText();
                            socialResponse2.socialNickname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_headurl")) {
                            socialResponse2.socialPortraitUrl = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_name")) {
                            socialResponse2.socialNickname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SearchJsBridge.COOKIE_OS_TYPE)) {
                            socialResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            continue;
                        } else if (name.equalsIgnoreCase("notice_offline")) {
                            socialResponse2.offlineNotice = "1".equals(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("guidebind")) {
                            socialResponse2.bindGuide = "1".equals(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("bind_conflict")) {
                            socialResponse2.bindConflict = "1".equals(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("wapsec")) {
                            socialResponse2.accountCenterFlag = "center".equals(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("next_url_related")) {
                            String nextText = newPullParser.nextText();
                            if (socialResponse2.accountCenterFlag) {
                                socialResponse2.nextUrl = nextText;
                                continue;
                            } else {
                                continue;
                            }
                        } else if (name.equalsIgnoreCase("incomplete_user")) {
                            String nextText2 = newPullParser.nextText();
                            if ("0".equals(nextText2)) {
                                socialResponse2.accountType = AccountType.NORMAL;
                                continue;
                            } else if ("1".equals(nextText2)) {
                                socialResponse2.accountType = AccountType.INCOMPLETE_USER;
                                continue;
                            } else {
                                socialResponse2.accountType = AccountType.UNKNOWN;
                                continue;
                            }
                        } else if (name.equalsIgnoreCase("stoken")) {
                            String[] split = newPullParser.nextText().split("#");
                            socialResponse2.tplStokenMap.put(split[0], split[1]);
                            continue;
                        } else if (name.equalsIgnoreCase("actiontype")) {
                            socialResponse2.actionType = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                            socialResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                            continue;
                        } else if (name.equals("livinguname")) {
                            socialResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            continue;
                        } else if (name.equals("guest_account")) {
                            socialResponse2.isGuestAccount = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                        socialResponse2 = socialResponse;
                        continue;
                    } else if (socialResponse2 == null) {
                        socialResponse = new SocialResponse();
                        socialResponse2 = socialResponse;
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return socialResponse2;
    }

    public static String replaceParams(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int indexOf = str.indexOf(str2 + "=");
                if (indexOf != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(0, indexOf));
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                    int indexOf2 = str.indexOf("&", indexOf);
                    if (indexOf2 != -1) {
                        sb.append(str.substring(indexOf2));
                    } else {
                        int indexOf3 = str.indexOf("#", indexOf);
                        if (indexOf3 != -1) {
                            sb.append(str.substring(indexOf3));
                        }
                    }
                    return sb.toString();
                }
                return str;
            }
        } catch (Exception e2) {
            Log.e(Log.TAG, e2.getMessage());
        }
        return str;
    }

    private void setAsynJsMehodName() {
        ArrayList arrayList = new ArrayList();
        this.asynJsMehodName = arrayList;
        arrayList.add("sapi_action_pick_image");
        this.asynJsMehodName.add("sapi_action_pick_date");
        this.asynJsMehodName.add("sapi_action_third_safety_verification");
        this.asynJsMehodName.add("sapi_biometrics_identification");
        this.asynJsMehodName.add("sapi_biometrics_identification_no_bduss");
        this.asynJsMehodName.add("sapi_biometrics_identification_with_authtoken");
        this.asynJsMehodName.add("sapi_biometrics_identification_with_uid");
        this.asynJsMehodName.add("sapi_action_sc_app_invoke");
        this.asynJsMehodName.add("oauth_sso_hash");
        this.asynJsMehodName.add("sapi_action_china_mobile_oauth");
        this.asynJsMehodName.add("address_manage_get_contact");
        this.asynJsMehodName.add("touchid_open_guide");
        this.asynJsMehodName.add("touchid_change_status");
        this.asynJsMehodName.add("touchid_login");
        this.asynJsMehodName.add("speech_recognition_get_content");
        this.asynJsMehodName.add("sapi_onekey_oauth_token");
        this.asynJsMehodName.add("sapi_biometrics_identification_live");
        this.asynJsMehodName.add("sapi_idcard_ocr_image");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statLoadLogin(String str, boolean z) {
        if (statLoadLogin == null) {
            return;
        }
        if (str.contains(URL_HASH_LOGIN) || str.contains(URL_HASH_SHARE) || str.contains(URL_HASH_JOIN_LOGIN) || str.contains(URL_HASH_FAST_REG) || str.contains(URL_HASH_SMS_LOGIN) || (this.isSupFaceLogin && str.contains(URL_HASH_FACE_LOGIN))) {
            statLoadLogin.tLoadLogin = System.currentTimeMillis();
            statLoadLogin.isLoadCache = z;
        }
    }

    private void statStartLogin(String str) {
        if (statLoadLogin == null) {
            return;
        }
        if (str.contains(URL_HASH_LOGIN) || str.contains(URL_HASH_SHARE) || str.contains(URL_HASH_JOIN_LOGIN) || str.contains(URL_HASH_FAST_REG) || str.contains(URL_HASH_SMS_LOGIN) || (this.isSupFaceLogin && str.contains(URL_HASH_FACE_LOGIN))) {
            statLoadLogin.tStartLogin = System.currentTimeMillis();
        }
    }

    public void asyncCommonCookie(List<PassNameValuePair> list) {
        List<PassNameValuePair> buildDeviceInfoCookie = buildDeviceInfoCookie();
        List<PassNameValuePair> buildDarkModeCookie = buildDarkModeCookie();
        if (list != null && !list.isEmpty()) {
            buildDeviceInfoCookie.addAll(list);
        }
        if (buildDarkModeCookie != null && !buildDarkModeCookie.isEmpty()) {
            buildDeviceInfoCookie.addAll(buildDarkModeCookie);
        }
        SapiUtils.syncCookies(getContext(), buildDeviceInfoCookie);
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (getSettings().getBlockNetworkLoads()) {
            return;
        }
        loadUrl(generateJSStr(activityLifeCycle.methodName));
    }

    public void back() {
        View view;
        View view2;
        ProgressBar progressBar;
        if (this.shouldClose && (progressBar = this.progressBar) != null && progressBar.getVisibility() == 0) {
            finish();
        } else if (this.shouldClose && (view = this.webviewLoadingView) != null && view.getVisibility() == 0) {
            finish();
        } else if (this.onNewBackCallback == null || this.jsCallBacks.rrLoginResponse != null) {
            super.loadUrl(FN_SWITCH_VIEW);
            handleOpenApiAuthorizeResponse(this.jsCallBacks.rrLoginResponse);
        } else {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.onNewBackCallback.onBack();
        }
        View view3 = this.noNetworkView;
        if ((view3 == null || view3.getVisibility() != 0) && ((view2 = this.timeoutView) == null || view2.getVisibility() != 0)) {
            return;
        }
        finish();
    }

    public String buildBindBdussCookie() {
        return SapiUtils.buildBDUSSCookie(this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    public List<PassNameValuePair> buildCommonParams() {
        ArrayList arrayList = new ArrayList();
        if (this.configuration.supportFaceLogin) {
            SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
            if (callBacks.bioScanFaceCallback != null && callBacks.biometricsIdentifyCallback != null) {
                arrayList.add(new PassNameValuePair("liveAbility", "1"));
            }
        }
        return arrayList;
    }

    public List<PassNameValuePair> buildDarkModeCookie() {
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        if (this.configuration.isDarkMode) {
            arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, SkinManager.SKIN_TYPE_STR_DARK)));
            arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, SkinManager.SKIN_TYPE_STR_DARK)));
        } else {
            arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDarkModeCookie(replaceAll, SensorController.KEY_LIGHT)));
            arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDarkModeCookie(replaceAll2, SensorController.KEY_LIGHT)));
        }
        return arrayList;
    }

    public List<PassNameValuePair> buildDeviceInfoCookie() {
        String diCookieInfo;
        List<String> loginCookieDiKeys = SapiContext.getInstance().getSapiOptions().getLoginCookieDiKeys();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.configuration.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        String replaceAll2 = this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        Log.e("APP_VERSION", "wap_pass=" + replaceAll, ", passport=" + replaceAll2);
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo("/static/appsapi/conf/android-conf.txt");
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo == null ? "" : diCookieInfo)));
        arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), SapiUtils.buildDeviceInfoCookie(replaceAll2, "DVIF", diCookieInfo != null ? diCookieInfo : "")));
        return arrayList;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.isDestory = true;
        this.timeoutHandler.removeCallbacks(this.timeoutTask);
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
    }

    public void dismissProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.17
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.progressDialog == null || !SapiWebView.this.progressDialog.isShowing()) {
                    return;
                }
                try {
                    SapiWebView.this.progressDialog.dismiss();
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void finish() {
        finish("");
    }

    public String getAccountCenterUrl(String str) {
        return SapiAccountManager.getInstance().getAccountService().getAccountCenterUrl(str) + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getAddressManageUrl() {
        return SapiAccountManager.getInstance().getAccountService().getAddressManageUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        return SapiAccountManager.getInstance().getAccountService().getBindWidgetUrl(bindWidgetAction) + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getForgetPwdUrl() {
        return SapiAccountManager.getInstance().getAccountService().getForgetPwdUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getHashUrl(String str, String str2) {
        String[] split;
        if (str2.split("#").length > 1) {
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            String cacheModuleId = this.sapiCache.getCacheModuleId(str2);
            String str3 = "";
            if (this.sapiCache.getModuleById(cacheModuleId) != null) {
                String str4 = this.sapiCache.getModuleById(cacheModuleId).hash;
                String md5 = SecurityUtil.md5(str.getBytes(), false);
                SapiOptions.Cache cache = sapiOptions.getCache();
                String version = cache != null ? cache.getVersion() : "";
                if (str4.equals(md5)) {
                    if (!TextUtils.isEmpty(version)) {
                        str3 = "&passAppVersion=" + version;
                    }
                    str3 = str3 + "&passAppHash=" + this.sapiCache.getModuleById(cacheModuleId).hash;
                } else {
                    str3 = "&passAppHash=" + SecurityUtil.md5(str.getBytes(), false);
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    public String getInvoiceBuildUrl() {
        return SapiAccountManager.getInstance().getAccountService().getInvoiceBuildUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public SapiJsCallBacks.CallBacks getJsCallBacks() {
        return this.jsCallBacks;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getLocalPhoneNumber() {
        String line1Number;
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService("phone");
        if (SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext())) {
            try {
                line1Number = telephonyManager.getLine1Number();
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(line1Number)) {
                return line1Number.replace("+86", "");
            }
            return null;
        }
        line1Number = null;
        if (TextUtils.isEmpty(line1Number)) {
        }
    }

    public String getLoginUrl() {
        return SapiAccountManager.getInstance().getAccountService().getLoginUrl();
    }

    public String getNormalizeGuestAccountUrl(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().getNormalizeGuestAccountUrl(socialType) + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getRealnameAuthenticateUrl() {
        return SapiAccountManager.getInstance().getAccountService().getRealnameAuthenticateUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public String getSwitchAccountUrl() {
        return SapiAccountManager.getInstance().getAccountService().getSwitchAccountUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public String getUaInfo() {
        String str = !TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "";
        String str2 = TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE;
        String encode = URLEncoder.encode("Sapi_9.3.2.5_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + str + "_" + str2 + "_Sapi");
        if (!isValidPackage() || TextUtils.isEmpty(this.configuration.userAgent)) {
            return encode;
        }
        return encode + " " + this.configuration.userAgent;
    }

    public String getUniteVerifyUrl() {
        return SapiAccountManager.getInstance().getAccountService().getUniteVerifyUrl() + "&" + SapiUtils.createRequestParams(buildCommonParams());
    }

    public void handleAuthorizeResponse(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse == null) {
            return;
        }
        final SapiAccount sapiAccountResponseToAccount = sapiAccountResponseToAccount(sapiAccountResponse);
        if (this.jsCallBacks.authorizationListener != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SapiWebView.this.jsCallBacks.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                    SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                    SapiWebView.this.authorizeSuccess(sapiAccountResponse.accountType);
                    SapiStatUtil.statShareV1Login(sapiAccountResponseToAccount, SapiWebView.this.extras);
                }
            });
        }
    }

    public void handleOpenApiAuthorizeResponse(final SocialResponse socialResponse) {
        int i2;
        if (socialResponse == null) {
            return;
        }
        final SapiAccount sapiAccountResponseToAccount = sapiAccountResponseToAccount(socialResponse);
        if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (socialResponse.accountCenterFlag && ((i2 = socialResponse.errorCode) == 0 || i2 == 110000)) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.loadUrl(socialResponse.nextUrl);
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                    if (SapiWebView.this.accountChangeCallback == null || currentAccount.uid.equals(sapiAccountResponseToAccount.uid)) {
                        return;
                    }
                    SapiWebView.this.accountChangeCallback.onAccountChange();
                }
            });
        } else if (this.jsCallBacks.authorizationListener != null) {
            int i3 = socialResponse.errorCode;
            if (i3 != 0 && i3 != 110000) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                            AuthorizationListener authorizationListener = SapiWebView.this.jsCallBacks.authorizationListener;
                            SocialResponse socialResponse2 = socialResponse;
                            authorizationListener.onFailed(socialResponse2.errorCode, socialResponse2.errorMsg);
                        }
                        SapiWebView.this.jsCallBacks.rrLoginResponse = null;
                    }
                });
            } else {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                                SapiWebView.this.jsCallBacks.authorizationListener.beforeSuccess(sapiAccountResponseToAccount);
                            }
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        SapiWebView.this.authorizeSuccess(AccountType.UNKNOWN);
                        SapiWebView.this.jsCallBacks.rrLoginResponse = null;
                    }
                });
            }
        }
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadAccountRealName(String str, String str2, boolean z, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair("scene", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new PassNameValuePair("customLink", str3));
        }
        arrayList.add(new PassNameValuePair("needcbkey", z ? "1" : "0"));
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        loadUrl(addExtras(getAddressManageUrl(), list));
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z, List<PassNameValuePair> list) {
        if (bindWidgetAction != null) {
            if (!TextUtils.isEmpty(str)) {
                webLogin(getContext(), str);
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(new PassNameValuePair("skin", str2));
                }
                if (z) {
                    arrayList.add(new PassNameValuePair(FreeSpaceBox.TYPE, "1"));
                }
                if (this.configuration.supportFaceLogin) {
                    arrayList.add(new PassNameValuePair("liveAbility", "1"));
                }
                String bindWidgetUrl = getBindWidgetUrl(bindWidgetAction);
                if (arrayList.size() > 0) {
                    bindWidgetUrl = bindWidgetUrl + "&" + SapiUtils.createRequestParams(arrayList);
                }
                String addExtras = addExtras(bindWidgetUrl, list);
                String buildBindBdussCookie = buildBindBdussCookie();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair(this.configuration.environment.getWap(), buildBindBdussCookie));
                loadUrl(addExtras, arrayList2);
                return;
            }
            throw new IllegalArgumentException("bduss can't be empty");
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.6
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                String str6;
                if (SapiWebView.this.isDestory) {
                    return;
                }
                if (str.split("#").length > 0) {
                    str6 = split[0] + "&loadDataWithBaseUrl=1#" + split[1];
                } else {
                    str6 = str + "&loadDataWithBaseUrl=1";
                }
                SapiWebView.this.statLoadLogin(str, true);
                SapiWebView.super.loadDataWithBaseURL(str6, str2, str3, str4, str5);
            }
        });
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains(BROWSE_MODE_AGREEMENT_HOST)) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new PassNameValuePair("clientfrom", "native"));
                list.add(new PassNameValuePair("client", "android"));
                list.add(new PassNameValuePair("deliverParams", "1"));
                if (this.configuration.supportFaceLogin) {
                    list.add(new PassNameValuePair("scanface", "1"));
                }
                if (this.jsCallBacks.pickPhotoCallback != null && this.configuration.supportPhoto) {
                    list.add(new PassNameValuePair("support_photo", "1"));
                }
                int indexOf = str.indexOf("?");
                if (indexOf > 0) {
                    int i2 = indexOf + 1;
                    str = str.substring(0, i2) + SapiUtils.createRequestParams(list) + "&" + str.substring(i2, str.length());
                } else {
                    str = str + "?" + SapiUtils.createRequestParams(list);
                }
            }
            loadUrl(str);
            return;
        }
        throw new IllegalArgumentException("externalUrl can't be empty");
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        loadUrl(addExtras(ParamsUtil.getUrlBind(this.configuration, SocialType.HUAWEI, str, null, null), list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(addExtras(getInvoiceBuildUrl(), list));
    }

    public void loadIqiyiBindServer(String str) {
        if (str == null) {
            return;
        }
        String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.configuration.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.configuration.environment.getURL(), buildIqiyiCookie));
        loadUrl(str, arrayList);
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        webLogin(getContext(), str);
        loadUrl(addExtras(getNormalizeGuestAccountUrl(socialType), list));
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z) {
        SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
        callBacks.qrLoginCallback = qrLoginCallback;
        callBacks.finishPage = z;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadRealnameAuthenticate(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.configuration.realnameAuthenticateStoken)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.5
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetTplStokenResult getTplStokenResult) {
                        if (SapiWebView.this.jsCallBacks.realnameAuthenticateCallback != null) {
                            SapiWebView.this.jsCallBacks.realnameAuthenticateCallback.onFailure();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        String realnameAuthenticateUrl = SapiWebView.this.getRealnameAuthenticateUrl();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new PassNameValuePair("bduss", str));
                        arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                        arrayList2.add(new PassNameValuePair("bdstoken", SapiWebView.this.configuration.realnameAuthenticateStoken));
                        SapiWebView.this.loadUrl(realnameAuthenticateUrl + "&" + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
                    }
                }, str, arrayList);
                return;
            }
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        throw new IllegalArgumentException("bduss can't be empty");
    }

    public void loadRegist(List<PassNameValuePair> list) {
        String loginUrl = getLoginUrl();
        loadUrl(addExtras(loginUrl, list) + URL_HASH_REG);
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().getWapShareLoginUrl() + "&adapter=3") + URL_HASH_SHARE_OAUTH);
    }

    public void loadSwitchAccount(List<PassNameValuePair> list) {
        loadUrl(addExtras(getSwitchAccountUrl(), list));
    }

    public void loadThirdPartySSOLogin(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.isLoadThirdPartyUrl = true;
        this.userInfoXmlContent = str2;
        ArrayList arrayList = new ArrayList();
        String url = this.configuration.environment.getURL();
        arrayList.add(new PassNameValuePair(url, str3));
        arrayList.add(new PassNameValuePair("https://baidu.com", str4));
        arrayList.add(new PassNameValuePair("https://baidu.com", str5));
        arrayList.add(new PassNameValuePair(url, str6));
        arrayList.add(new PassNameValuePair(url, str7));
        loadUrl(str, arrayList);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(new PassNameValuePair("token", URLEncoder.encode(str, "UTF-8")));
                if (str2 != null) {
                    arrayList.add(new PassNameValuePair("u", str2));
                }
                if (str3 != null) {
                    arrayList.add(new PassNameValuePair("adtext", URLEncoder.encode(str3, "UTF-8")));
                }
            } catch (UnsupportedEncodingException e2) {
                Log.e(e2);
            }
            String uniteVerifyUrl = getUniteVerifyUrl();
            loadUrl(uniteVerifyUrl + "&" + SapiUtils.createRequestParams(arrayList));
            return;
        }
        throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        loadUrl(fixAdapterParamValue(str), Collections.emptyList());
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onKeyUp(int i2) {
        if (i2 == 4 && this.leftBtnIsVisible == 1) {
            OnBackCallback onBackCallback = this.onBackCallback;
            if (onBackCallback != null && this.jsCallBacks.rrLoginResponse == null) {
                onBackCallback.onBack();
            }
            back();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) progressBar.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.progressBar.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    @Override // android.view.View
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        View view = this.noNetworkView;
        if (view == null || view.getVisibility() != 0) {
            View view2 = this.timeoutView;
            if (view2 == null || view2.getVisibility() != 0) {
                return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
            }
            return false;
        }
        return false;
    }

    public SapiAccountResponse parseAuthorizedResult(String str, Context context) {
        SapiAccountResponse sapiAccountResponse;
        String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
        SapiAccountResponse sapiAccountResponse2 = null;
        if (TextUtils.isEmpty(matcher)) {
            return null;
        }
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            boolean z = false;
            while (true) {
                boolean z2 = true;
                if (eventType == 1) {
                    break;
                }
                if (eventType != 2) {
                    continue;
                } else {
                    String name = newPullParser.getName();
                    if (!name.equalsIgnoreCase("data")) {
                        if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_code")) {
                            sapiAccountResponse = new SapiAccountResponse();
                            try {
                                sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            } catch (Throwable th) {
                                sapiAccountResponse2 = sapiAccountResponse;
                                th = th;
                                Log.e(th);
                                if (sapiAccountResponse2 != null) {
                                    sapiAccountResponse2.errorCode = 0;
                                }
                                return sapiAccountResponse2;
                            }
                        } else if (sapiAccountResponse2 == null && name.equalsIgnoreCase("error_description")) {
                            sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse.errorMsg = newPullParser.nextText();
                        } else if (sapiAccountResponse2 == null) {
                            continue;
                        } else if (name.equalsIgnoreCase("errno")) {
                            sapiAccountResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("uname")) {
                            sapiAccountResponse2.username = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("errmsg")) {
                            sapiAccountResponse2.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduss")) {
                            sapiAccountResponse2.bduss = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                            sapiAccountResponse2.ptoken = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("stoken")) {
                            if (z) {
                                String[] split = newPullParser.nextText().split("#");
                                if (split != null && split.length > 1) {
                                    sapiAccountResponse2.tplStokenMap.put(split[0], split[1]);
                                    continue;
                                }
                            } else {
                                sapiAccountResponse2.stoken = newPullParser.nextText();
                                continue;
                            }
                        } else if (name.equalsIgnoreCase("displayname")) {
                            sapiAccountResponse2.displayname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("uid")) {
                            sapiAccountResponse2.uid = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("authsid")) {
                            String nextText = newPullParser.nextText();
                            sapiAccountResponse2.authSid = nextText;
                            if (TextUtils.isEmpty(nextText)) {
                                z2 = false;
                            }
                            sapiAccountResponse2.newReg = z2;
                            continue;
                        } else if (name.equalsIgnoreCase("stoken_list")) {
                            z = true;
                            continue;
                        } else if (name.equalsIgnoreCase("os_headurl")) {
                            sapiAccountResponse2.socialPortraitUrl = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_name")) {
                            sapiAccountResponse2.socialNickname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SearchJsBridge.COOKIE_OS_TYPE)) {
                            sapiAccountResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            continue;
                        } else if (name.equalsIgnoreCase("incomplete_user")) {
                            String nextText2 = newPullParser.nextText();
                            if ("0".equals(nextText2)) {
                                sapiAccountResponse2.accountType = AccountType.NORMAL;
                                continue;
                            } else if ("1".equals(nextText2)) {
                                sapiAccountResponse2.accountType = AccountType.INCOMPLETE_USER;
                                continue;
                            } else {
                                sapiAccountResponse2.accountType = AccountType.UNKNOWN;
                                continue;
                            }
                        } else if (name.equalsIgnoreCase("actiontype")) {
                            sapiAccountResponse2.actionType = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccount.SAPI_ACCOUNT_FROMTYPE)) {
                            sapiAccountResponse2.fromType = FromType.getFromType(newPullParser.nextText());
                            continue;
                        } else if (name.equals("livinguname")) {
                            sapiAccountResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                            continue;
                        } else if (IWalletLoginListener.KEY_LOGIN_TYPE.equals(name)) {
                            String nextText3 = newPullParser.nextText();
                            if ("oneKeyLogin".equals(nextText3)) {
                                nextText3 = new OneKeyLoginSdkCall().getOperatorType();
                            }
                            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, nextText3);
                            continue;
                        } else if (name.equals("mobilephone")) {
                            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                            continue;
                        } else if (name.equals("app")) {
                            sapiAccountResponse2.app = newPullParser.nextText();
                            continue;
                        } else if (name.equals("extra")) {
                            sapiAccountResponse2.extra = newPullParser.nextText();
                            continue;
                        } else if (name.equals("portraitSign")) {
                            sapiAccountResponse2.portraitSign = newPullParser.nextText();
                            continue;
                        } else if (name.equals("portrait")) {
                            sapiAccountResponse2.portraitSign = newPullParser.nextText().replace("https://himg.bdimg.com/sys/portrait/item/", "").replace("http://himg.bdimg.com/sys/portrait/item/", "").replace(".jpg", "");
                            continue;
                        } else if (name.equals("guest_account")) {
                            sapiAccountResponse2.isGuestAccount = newPullParser.nextText();
                            continue;
                        } else {
                            continue;
                        }
                        sapiAccountResponse2 = sapiAccountResponse;
                        continue;
                    } else if (sapiAccountResponse2 == null) {
                        sapiAccountResponse = new SapiAccountResponse();
                        sapiAccountResponse2 = sapiAccountResponse;
                        continue;
                    } else {
                        continue;
                    }
                }
                eventType = newPullParser.next();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
            sapiAccountResponse2.errorCode = 0;
        }
        return sapiAccountResponse2;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    @Override // android.webkit.WebView
    public void reload() {
        String str = this.reloadConfig.timeoutUrl;
        if (str != null) {
            loadUrl(str);
        } else {
            super.reload();
        }
        this.reloadConfig.reset();
    }

    public SapiAccount sapiAccountResponseToAccount(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(getContext()) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        sapiAccount.portrait = sapiAccountResponse.portraitSign;
        sapiAccount.fromType = sapiAccountResponse.fromType.getValue();
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.configuration.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(getContext(), sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        View view;
        View view2 = this.noNetworkView;
        if ((view2 != null && view2.getVisibility() == 0) || ((view = this.timeoutView) != null && view.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i2, i3);
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.accountChangeCallback = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.jsCallBacks.accountDestoryCallback = accountDestoryCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.jsCallBacks.accountFreezeCallback = accountFreezeCallback;
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.jsCallBacks.authorizationListener = authorizationListener;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.jsCallBacks.bdOauthLoginParams = bdOauthLoginParams;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.jsCallBacks.bdussChangeCallback = bdussChangeCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.jsCallBacks.bindWidgetCallback = bindWidgetCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.jsCallBacks.bioScanFaceCallback = bioScanFaceCallback;
    }

    public void setBiometricsIdentificationLiveCallBack(SapiJsCallBacks.BiometricsIdentificationLiveCallBack biometricsIdentificationLiveCallBack) {
        this.jsCallBacks.biometricsIdentificationLiveCallBack = biometricsIdentificationLiveCallBack;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.jsCallBacks.biometricsIdentifyCallback = biometricsIdentifyCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.changePwdCallback = changePwdCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.jsCallBacks.coverWebBdussCallback = coverWebBdussCallback;
    }

    public void setCurrentAccountBdussExpiredCallback(SapiJsCallBacks.CurrentAccountBdussExpiredCallback currentAccountBdussExpiredCallback) {
        this.jsCallBacks.currentAccountBdussExpiredCallback = currentAccountBdussExpiredCallback;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.jsCallBacks.directedLoginParams = directedLoginParams;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.fileChooserCallback = fileChooserCallback;
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        this.jsCallBacks.fingerprintCallback = fingerprintCallback;
    }

    public void setFocusEdittextCoordinateYCallBack(SapiJsCallBacks.FocusEdittextCoordinateYCallBack focusEdittextCoordinateYCallBack) {
        this.jsCallBacks.focusEdittextCoordinateYCallBack = focusEdittextCoordinateYCallBack;
    }

    public void setGetCurrentPageNameCallback(SapiJsCallBacks.GetCurrentPageNameCallback getCurrentPageNameCallback) {
        this.jsCallBacks.getCurrentPageNameCallback = getCurrentPageNameCallback;
    }

    public void setGrantWebCallback(SapiJsCallBacks.GrantWebCallback grantWebCallback) {
        this.jsCallBacks.grantWebCallback = grantWebCallback;
    }

    public void setHadMakeBarHide(boolean z) {
        this.mHadMakeBarHide = z;
    }

    public void setHideSuccessTip(boolean z) {
        this.jsCallBacks.hideSuccessTip = z;
    }

    public void setIdcardOcrImageCallBack(SapiJsCallBacks.IdcardOcrImageCallBack idcardOcrImageCallBack) {
        this.jsCallBacks.idcardOcrImageCallBack = idcardOcrImageCallBack;
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        this.jsCallBacks.invoiceBuildCallback = invoiceBuildCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.jsCallBacks.invokeScAppCallback = invokeScAppCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.jsCallBacks.joinLoginParams = joinLoginParams;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.jsCallBacks.leftBtnVisibleCallback = leftBtnVisibleCallback;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.jsCallBacks.loadExternalWebViewCallback = loadExternalWebViewCallback;
    }

    public void setLoadSlideWebViewCallback(LoadSlideWebViewCallback loadSlideWebViewCallback) {
        this.jsCallBacks.loadSlideWebViewCallback = loadSlideWebViewCallback;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.jsCallBacks.localConfigCallback = localConfigCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.jsCallBacks.loginStatusChangeCallback = loginStatusChangeCallback;
    }

    public void setMakeVibrateCallBack(SapiJsCallBacks.MakeVibrateCallBack makeVibrateCallBack) {
        this.jsCallBacks.makeVibrateCallBack = makeVibrateCallBack;
    }

    public final void setNoNetworkView(View view) {
        if (this.noNetworkView == null) {
            this.noNetworkView = view;
            view.setVisibility(4);
            addView(this.noNetworkView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        SapiJsCallBacks.CallBacks callBacks = this.jsCallBacks;
        callBacks.normalizeGuestAccountCallback = normalizeGuestAccountCallback;
        callBacks.normalizeGuestAccountDesc = str;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.onBackCallback = onBackCallback;
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.onFinishCallback = onFinishCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.onNewBackCallback = onNewBackCallback;
    }

    public void setOnSlidePageFinishCallback(OnSlidePageFinishCallback onSlidePageFinishCallback) {
        this.jsCallBacks.onSlidePageFinishCallback = onSlidePageFinishCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.jsCallBacks.pageStateCallback = pageStateCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.jsCallBacks.pickPhotoCallback = pickPhotoCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.jsCallBacks.prefillUserNameCallback = preFillUserNameCallback;
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.progressBar != null) {
            return;
        }
        this.progressBar = progressBar;
        if (progressBar != null) {
            addView(progressBar);
        }
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.jsCallBacks.realNameStatusCallback = realNameStatusCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.jsCallBacks.realnameAuthenticateCallback = realnameAuthenticateCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.jsCallBacks.shareAccountClickCallback = shareAccountClickCallback;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.jsCallBacks.shareV2LoginParams = shareV2LoginParams;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.jsCallBacks.socialLoginHandler = handler;
    }

    public void setSocialVerificationHandler(Handler handler) {
        this.jsCallBacks.socialVerificationHandler = handler;
    }

    public void setSpeechRecognitionCallback(SapiJsCallBacks.SpeechRecognitionCallback speechRecognitionCallback) {
        this.jsCallBacks.speechRecognitionCallback = speechRecognitionCallback;
    }

    public void setStopSlideWebviewCallback(SapiJsCallBacks.StopSlideWebviewCallback stopSlideWebviewCallback) {
        this.jsCallBacks.stopSlideWebviewCallback = stopSlideWebviewCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.jsCallBacks.switchAccountCallback = switchAccountCallback;
    }

    public void setSwitchStyleForCloseBtnAndStatusBarCallBack(SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack switchStyleForCloseBtnAndStatusBarCallBack) {
        this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack = switchStyleForCloseBtnAndStatusBarCallBack;
    }

    public void setTimeoutMillis(long j) {
        this.timeoutMillis = j;
    }

    public final void setTimeoutView(View view) {
        if (this.timeoutView == null) {
            this.timeoutView = view;
            view.setVisibility(4);
            addView(this.timeoutView, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.jsCallBacks.uniteVerifyCallback = uniteVerifyCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.webChromeClientCallback = webChromeClientCallback;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.jsCallBacks.webViewTitleCallback = webViewTitleCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.webviewClientCallback = webviewClientCallback;
    }

    public void setWebviewLoadingView(View view) {
        if (this.webviewLoadingView == null) {
            this.webviewLoadingView = view;
            view.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.jsCallBacks.webviewPageFinishCallback = webviewPageFinishCallback;
    }

    public void showProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SapiWebView.this.progressDialog = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException unused) {
        }
    }

    public void webLogin(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    public void finish(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.isDestory) {
                    return;
                }
                SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                if (TextUtils.isEmpty(str)) {
                    if (SapiWebView.this.onFinishCallback != null) {
                        SapiWebView.this.onFinishCallback.onFinish();
                    }
                } else if (SapiWebView.this.jsCallBacks.onSlidePageFinishCallback != null) {
                    SapiWebView.this.jsCallBacks.onSlidePageFinishCallback.onFinish(str);
                }
            }
        });
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.asyncStoken2Web(getContext(), str);
        String accountCenterUrl = getAccountCenterUrl(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.jsCallBacks.pickPhotoCallback != null && this.configuration.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.jsCallBacks.biometricsIdentifyCallback != null && this.configuration.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(addExtras(accountCenterUrl, list));
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + CALLBACK_PARAM_KEY + "=" + ACTION_FORGET_PWD, "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String forgetPwdUrl = getForgetPwdUrl();
        if (arrayList.size() > 0) {
            forgetPwdUrl = forgetPwdUrl + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(forgetPwdUrl);
    }

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    public void loadLogin(int i2, List<PassNameValuePair> list) {
        if (this.configuration.supportFaceLogin && this.jsCallBacks.biometricsIdentifyCallback == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        StatLoadLogin statLoadLogin2 = statLoadLogin;
        if (statLoadLogin2 != null) {
            statLoadLogin2.tBeforeLogin = System.currentTimeMillis();
        }
        this.extras = list;
        if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
            loadNormalLogin(i2, list);
        } else if (4 == i2) {
            loadJoinLogin(list);
        } else if (i2 == 6) {
            loadNameLogin(i2);
        } else {
            boolean z = ShareUtils.isInV2ShareDisableWhiteList(this.configuration) && this.shareV2Disable;
            this.shareV2Disable = z;
            if (this.jsCallBacks.shareAccountClickCallback != null && !z) {
                list.add(new PassNameValuePair(ShareCallPacking.StatModel.KEY_SHARE_VERSION, "2"));
                loadShareAccounts(i2, list);
            } else if (this.isSupFaceLogin) {
                loadFaceLogin(list);
            } else if (new OneKeyLoginSdkCall().checkSupOauth()) {
                loadChinaMobileLogin(i2, list);
            } else {
                loadNormalLogin(i2, list);
            }
        }
        SapiStatUtil.statLoadLogin(null);
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        String str2;
        statStartLogin(str);
        if (TextUtils.isEmpty(str) || str.contains("javascript:")) {
            str2 = null;
        } else {
            asyncCommonCookie(list);
            str2 = this.sapiCache.getCacheData(getContext(), str);
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
            String hashUrl = getHashUrl(str3, str);
            loadDataWithBaseURL(hashUrl, str3, DATA_MIME_TYPE, "UTF-8", hashUrl);
            return;
        }
        loadUrlFromNetwork(str);
    }

    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 extends WebViewClient {
        public AnonymousClass2() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0159, code lost:
            if (r10.contains(r4.getHost() + r4.getPath()) != false) goto L37;
         */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            }
            if (SapiWebView.this.webviewLoadingView != null) {
                SapiWebView.this.webviewLoadingView.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.noNetworkView != null && SapiWebView.this.noNetworkView.getVisibility() != 4) {
                SapiWebView.this.noNetworkView.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.FN_NET_AVAILABLE);
            if (SapiWebView.this.jsCallBacks.webViewTitleCallback != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            if (SapiWebView.this.isLoadThirdPartyUrl && !TextUtils.isEmpty(SapiWebView.this.userInfoXmlContent)) {
                SapiWebView sapiWebView = SapiWebView.this;
                SapiWebView.super.loadUrl(String.format(SapiWebView.FN_GUIDE_PROCESS, sapiWebView.userInfoXmlContent));
                SapiWebView.this.isLoadThirdPartyUrl = false;
                SapiWebView.this.userInfoXmlContent = null;
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().getUrlAfterAuth());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().getUrlFinishBind());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().getUrlSSOFinish());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().getAccountCenterUrl(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.shouldClose = true;
            } else {
                SapiWebView.this.shouldClose = false;
            }
            if (!str.contains(parse.getHost() + parse.getPath())) {
                if (!str.contains(parse2.getHost() + parse2.getPath())) {
                }
            }
            if (!"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.timeoutHandler.removeCallbacks(SapiWebView.this.timeoutTask);
            if (SapiWebView.this.webviewClientCallback != null) {
                SapiWebView.this.webviewClientCallback.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Uri parse;
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.jsCallBacks.pageStateCallback != null) {
                Uri parse2 = Uri.parse(SapiWebView.this.getLoginUrl());
                if (Uri.parse(str) != null) {
                    if ((parse.getHost() + parse.getPath()).equals(parse2.getHost() + parse2.getPath())) {
                        SapiWebView.this.jsCallBacks.pageStateCallback.pageState(1);
                    }
                }
                SapiWebView.this.jsCallBacks.pageStateCallback.pageState(2);
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.handleNetworkUnavailable();
            }
            SapiWebView.this.timeoutTask.setUrl(str);
            SapiWebView.this.timeoutHandler.postDelayed(SapiWebView.this.timeoutTask, SapiWebView.this.timeoutMillis);
            SapiWebView.this.handleLoadingView();
            if (str != null) {
                if (str.contains(SapiWebView.ACTION_FORGET_PWD) || str.contains(SapiWebView.ACTION_MODIFY_PWD)) {
                    String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.CALLBACK_PARAM_KEY);
                    if (SapiWebView.ACTION_FORGET_PWD.equals(queryParameter) && SapiWebView.this.changePwdCallback != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.changePwdCallback != null) {
                                    SapiWebView.this.changePwdCallback.onSuccess();
                                }
                            }
                        });
                    }
                    if (SapiWebView.ACTION_MODIFY_PWD.equals(queryParameter) && SapiWebView.this.changePwdCallback != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.changePwdCallback != null) {
                                        SapiWebView.this.changePwdCallback.onSuccess();
                                        return;
                                    }
                                    return;
                                }
                                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.2.1
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFinish() {
                                        SapiWebView.this.dismissProgress();
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onStart() {
                                        SapiWebView.this.showProgress();
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.changePwdCallback != null) {
                                            SapiWebView.this.changePwdCallback.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.changePwdCallback != null) {
                                            SapiWebView.this.changePwdCallback.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                                        if (currentAccount != null) {
                                            if (currentAccount.uid.equals(getUserInfoResult.uid)) {
                                                currentAccount.bduss = cookieBduss;
                                            }
                                            if (!TextUtils.isEmpty(cookiePtoken)) {
                                                currentAccount.ptoken = cookiePtoken;
                                            }
                                            currentAccount.deleteStokens();
                                        }
                                        SapiAccountManager.getInstance().validate(currentAccount);
                                        if (SapiWebView.this.changePwdCallback != null) {
                                            SapiWebView.this.changePwdCallback.onSuccess();
                                        }
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.ACTION_RENREN_OFFLINE.equals(Uri.parse(str).getQueryParameter(SapiWebView.CALLBACK_PARAM_KEY))) {
                    if (SapiWebView.this.jsCallBacks.rrLoginResponse == null) {
                        if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.jsCallBacks.authorizationListener != null) {
                                        SapiWebView.this.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                        }
                    } else {
                        SapiWebView sapiWebView = SapiWebView.this;
                        sapiWebView.handleOpenApiAuthorizeResponse(sapiWebView.jsCallBacks.rrLoginResponse);
                    }
                }
            }
            if (SapiWebView.this.webviewClientCallback != null) {
                SapiWebView.this.webviewClientCallback.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            if (i2 == -8 || i2 == -6 || i2 == -2 || i2 == -5) {
                SapiWebView.this.handleTimeout();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
            if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                sslErrorHandler.cancel();
                if (!(!SapiWebView.this.configuration.forbidSslErrorDialog)) {
                    if (SapiWebView.this.dateInvalidDialog == null) {
                        if (Build.VERSION.SDK_INT > 17) {
                            str2 = new SimpleDateFormat(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_MSG).format(new Date(System.currentTimeMillis()));
                            str = SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_TITLE;
                        } else {
                            str = SapiWebView.HTTPS_SSL_UNTRUSTED_DIALOG_TITLE;
                            str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                        builder.setTitle(str);
                        builder.setMessage(str2);
                        builder.setPositiveButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_SET_TIME, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                                SapiWebView.this.getContext().startActivity(intent);
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_setting", null);
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_cancel", null);
                            }
                        });
                        SapiWebView.this.dateInvalidDialog = builder.create();
                    }
                    if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.dateInvalidDialog.isShowing()) {
                        SapiWebView.this.dateInvalidDialog.show();
                    }
                } else {
                    sslErrorHandler.proceed();
                }
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (webResourceRequest.getUrl().toString().contains(SapiWebView.CUSTOM_CSS_INTERPRETER_URL)) {
                        String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str)) {
                            return new WebResourceResponse("text/css", "utf-8", SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null) {
                if (!str.startsWith("sms") && !str.startsWith("tel") && !str.startsWith("bdscenter")) {
                    if (str.startsWith("wtloginmqq")) {
                        return true;
                    }
                    if (SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL).equals(str)) {
                        SapiWebView.this.finish();
                    }
                    if (SapiWebView.this.jsCallBacks.bdOauthLoginParams != null && SapiWebView.this.jsCallBacks.bdOauthLoginParams.redirectUrl != null && str.contains(SapiWebView.this.jsCallBacks.bdOauthLoginParams.redirectUrl)) {
                        SapiWebView.this.jsCallBacks.bdOauthLoginParams.callback.onCallback(str);
                        return true;
                    }
                } else {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        SapiWebView.this.getContext().startActivity(intent);
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                    return true;
                }
            }
            if (SapiWebView.this.webviewClientCallback != null) {
                SapiWebView.this.webviewClientCallback.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    if (str.contains(SapiWebView.CUSTOM_CSS_INTERPRETER_URL)) {
                        String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str2)) {
                            return new WebResourceResponse("text/css", "utf-8", SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str2));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.reloadConfig = new ReloadConfig();
        this.timeoutHandler = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.handleTimeout();
                }
            }
        };
        this.timeoutTask = new TimeoutTask();
        this.leftBtnIsVisible = 1;
        this.touchidPortraitAndSign = new String[2];
        init();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shareV2Disable = false;
        this.supportTouchGuide = true;
        this.reloadConfig = new ReloadConfig();
        this.timeoutHandler = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.handleTimeout();
                }
            }
        };
        this.timeoutTask = new TimeoutTask();
        this.leftBtnIsVisible = 1;
        this.touchidPortraitAndSign = new String[2];
        init();
    }
}
