package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.Toast;
import com.baidu.android.common.security.MD5Util;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.receiver.SMSReceiver;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.webkit.internal.ETAG;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.huawei.hwid.openapi.OpenHwID;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.tencent.connect.UnionInfo;
import com.tencent.connect.common.Constants;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.open.SocialOperation;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    private static final String A = "未登录魅族帐号";
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    private static final String B = "QQ未安装";
    private static final String C = "系统时间错误";
    private static final String D = "证书安全警告";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final String DEFAULT_WEIXIN_NOT_INSTALL_ERROR = "微信未安装";
    private static final String E = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String F = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    private static final String G = "取消";
    private static final String H = "立即设置时间";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    static final int a = 1;
    private static final String aq = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String ar = "function(){if(window.Pass&&Pass.client&&Pass.client.pageGoBack){Pass.client.pageGoBack()}else{history.go(-1)}}()";
    static final int b = 0;
    private static final String c = "prompt_on_cancel";
    private static final String d = "css/sapi_theme/style.css";
    private static final String e = "__wp-action";
    private static final String f = "renren-offline";
    private static final String g = "auth-widget";
    private static final String h = "forget-pwd";
    private static final String i = "modify-pwd";
    private static final String j = "text/html";
    private static final String k = "UTF-8";
    private static final String l = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    private static final String m = "#login";
    private static final String n = "#canshareAi";
    private static final String o = "#authPwd";
    private static final String p = "#reg";
    private static final String q = "#canshare_accounts";
    private static final String r = "#sms_login";
    private static final String s = "#fastReg";
    public static StatLoadLogin statLoadLogin = null;
    private static final String t = "#fastRegSuccess";
    private static final String u = "#fastRegVerify";
    private static final String v = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    private static final String w = "发送一条短信，即可完成注册。";
    private static final String x = "服务错误，请稍后重试";
    private static final String y = "未登录华为帐号";
    private static final String z = "未登录QQ帐号";
    private SapiConfiguration I;
    private IUiListener J;
    private WeixinHandler K;
    private HuaweiHandler L;
    private QQSSOHandler M;
    private MeizuHandler N;
    private WebviewClientCallback O;
    private WebChromeClientCallback P;
    private FileChooserCallback Q;
    private ChangePwdCallback R;
    private AuthWidgetCallback S;
    private AccountChangeCallback T;
    private String U;
    private SsoHandler V;
    private ReloadConfig W;
    private SapiJsInterpreters aa;
    private SapiJsCallBacks.CallBacks ab;
    private View ac;
    private View ad;
    private View ae;
    private ProgressBar af;
    private ProgressDialog ag;
    private Dialog ah;
    private boolean ai;
    private long aj;
    private Handler ak;
    private TimeoutTask al;
    private BroadcastReceiver am;
    private OnFinishCallback an;
    private OnBackCallback ao;
    private OnNewBackCallback ap;
    private SapiCallback<LoginResult> as;
    private String at;
    private boolean au;
    private int av;
    private boolean aw;
    private boolean ax;
    public boolean shareV2Disable;
    public static final NameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new BasicNameValuePair("smsfastlogin", "1");
    public static final NameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new BasicNameValuePair("bindToSmsLogin", "1");
    public static final NameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new BasicNameValuePair("overseas", "1");

    /* loaded from: classes.dex */
    public interface AccountChangeCallback {
        void onAccountChange();
    }

    /* loaded from: classes.dex */
    public static abstract class AccountDestoryCallback {

        /* loaded from: classes.dex */
        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
    }

    /* loaded from: classes.dex */
    public static abstract class AccountFreezeCallback {

        /* loaded from: classes.dex */
        public static class AccountFreezeResult {
        }

        public abstract void onAccountFreeze(AccountFreezeResult accountFreezeResult);
    }

    /* loaded from: classes.dex */
    public interface AuthWidgetCallback {
        void onSuccess(String str);
    }

    /* loaded from: classes.dex */
    public interface BdussChangeCallback {
        void onBdussChange();
    }

    /* loaded from: classes.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes.dex */
    public interface BioScanFaceCallback {
        public static final int BIO_SCAN_FACE_LOGIN = 2;
        public static final int BIO_SCAN_FACE_REG = 1;

        /* loaded from: classes.dex */
        public static abstract class BioScanFaceResult {
            public int showGuidePage;
            public String subpro;
            public List<NameValuePair> transParamsList = new ArrayList();
            public int type;
            public String uid;

            public abstract void setScanFaceIdentifyResult(String str);
        }

        void onBioScanFace(BioScanFaceResult bioScanFaceResult);
    }

    /* loaded from: classes.dex */
    public interface BiometricsIdentifyCallback {
        public static final int LIVENESS_RECOG = 1;
        public static final int RECORD_VIDEO = 1;

        void onBiometricsIdentify(BiometricsIdentifyResult biometricsIdentifyResult);
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface CoverWebBdussCallback {
        void onCoverBduss(String str, CoverWebBdussResult coverWebBdussResult);
    }

    /* loaded from: classes.dex */
    public static abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);
    }

    /* loaded from: classes.dex */
    interface ErrorCode {
        public static final int WEIXIN_NOT_INTALL = -404;
    }

    /* loaded from: classes.dex */
    public interface FastRegHandler {
        void handleFastReg();
    }

    /* loaded from: classes.dex */
    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    /* loaded from: classes.dex */
    public interface HuaweiHandler {
        void handleHuaweiLoginFailure();
    }

    /* loaded from: classes.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes.dex */
        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<NameValuePair> list, InvokeScAppResult invokeScAppResult);
    }

    /* loaded from: classes.dex */
    public interface LeftBtnVisibleCallback {
        public static final int LEFT_BTN_INVISIBLE = 0;
        public static final int LEFT_BTN_VISIBLE = 1;

        void onLeftBtnVisible(int i);
    }

    /* loaded from: classes.dex */
    public interface LoadExternalWebViewCallback {
        void loadExternalWebview(LoadExternalWebViewResult loadExternalWebViewResult);
    }

    /* loaded from: classes.dex */
    public static class LoadExternalWebViewResult {
        public String defaultTitle;
        public String externalUrl;
    }

    /* loaded from: classes.dex */
    public interface LocalConfigCallback {
        List<FastLoginFeature> getFastLoginFeatureList();
    }

    /* loaded from: classes.dex */
    public interface MeizuHandler {
        void handleMeizuLoginFailure();
    }

    /* loaded from: classes.dex */
    public interface NMLoginHandler {
        void handleNMLogin();
    }

    /* loaded from: classes.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes.dex */
    public interface OnNewBackCallback {
        boolean onBack();
    }

    /* loaded from: classes.dex */
    public interface PickPhotoCallback {
        public static final int PICK_IMAGE_ALBUM = 2;
        public static final int PICK_IMAGE_PHOTO = 1;

        void onPickImage(int i, PickPhotoResult pickPhotoResult);
    }

    /* loaded from: classes.dex */
    public static abstract class PreFillUserNameCallback {

        /* loaded from: classes.dex */
        public static class PreFillUserNameResult {
            public String userName;
        }

        public abstract void onPreFillUserName(PreFillUserNameResult preFillUserNameResult);
    }

    /* loaded from: classes.dex */
    public interface QQSSOHandler {
        void handleQQSSOLoginFailure();
    }

    /* loaded from: classes.dex */
    public interface QrLoginCallback {
        void loginStatusChange(boolean z);
    }

    /* loaded from: classes.dex */
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface ShareAccountClickCallback {
        void onClick(String str, String str2);
    }

    /* loaded from: classes.dex */
    public static abstract class SystemUpwardSmsCallback {

        /* loaded from: classes.dex */
        public static abstract class Result {
            public String content;
            public String destination;

            public abstract void onFinish();
        }

        public abstract void onResult(Result result);
    }

    /* loaded from: classes.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* loaded from: classes.dex */
    public interface UniteVerifyHandler {
        void handleUniteVerify(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface UpwardSmsCallback {
        void onResult(boolean z, boolean z2, boolean z3);
    }

    /* loaded from: classes.dex */
    public interface WebChromeClientCallback {
        boolean isSubClassHandleMessage(String str);

        void onConsoleMessage(String str, int i, String str2);

        boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes.dex */
    public interface WebviewClientCallback {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* loaded from: classes.dex */
    public interface WeixinHandler {
        void handleNotInstall();

        void handleServerError(String str);

        void onFinish();
    }

    /* loaded from: classes.dex */
    private class TimeoutTask implements Runnable {
        private String b;

        private TimeoutTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.b;
                SapiWebView.this.ak.sendMessage(message);
                SapiWebView.this.ak.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.an = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ao = onBackCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.ap = onNewBackCallback;
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.ab.D = webviewPageFinishCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.W = new ReloadConfig();
        this.ak = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.r();
                }
            }
        };
        this.al = new TimeoutTask();
        this.av = 1;
        this.aw = false;
        m();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.W = new ReloadConfig();
        this.ak = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.r();
                }
            }
        };
        this.al = new TimeoutTask();
        this.av = 1;
        this.aw = false;
        m();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shareV2Disable = false;
        this.W = new ReloadConfig();
        this.ak = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.r();
                }
            }
        };
        this.al = new TimeoutTask();
        this.av = 1;
        this.aw = false;
        m();
    }

    public final void setNoNetworkView(View view) {
        if (this.ad == null) {
            this.ad = view;
            this.ad.setVisibility(4);
            addView(this.ad, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.ae == null) {
            this.ae = view;
            this.ae.setVisibility(4);
            addView(this.ae, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.af == null) {
            this.af = progressBar;
            if (this.af != null) {
                addView(progressBar);
            }
        }
    }

    public void setWebviewLoadingView(View view) {
        if (this.ac == null) {
            this.ac = view;
            this.ac.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void m() {
        this.ab = new SapiJsCallBacks.CallBacks();
        this.aa = new SapiJsInterpreters(this, this.ab);
        this.aj = DEFAULT_TIMEOUT_MILLIS;
        this.I = SapiAccountManager.getInstance().getSapiConfiguration();
        o();
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new AnonymousClass2());
        setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.SapiWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton(AiAppsBluetoothConstants.ERROR_OK, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        jsResult.confirm();
                    }
                });
                positiveButton.setCancelable(false);
                positiveButton.create();
                positiveButton.show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i2, String str2) {
                Log.d(str + " -- From line " + i2 + " of " + str2, new Object[0]);
                if (SapiWebView.this.P != null) {
                    SapiWebView.this.P.onConsoleMessage(str, i2, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.af != null) {
                    if (i2 == 100) {
                        SapiWebView.this.af.setVisibility(8);
                    } else {
                        if (SapiWebView.this.af.getVisibility() == 8) {
                            SapiWebView.this.af.setVisibility(0);
                        }
                        SapiWebView.this.af.setProgress(i2);
                    }
                }
                super.onProgressChanged(webView, i2);
            }

            @Override // android.webkit.WebChromeClient
            @TargetApi(5)
            public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * j2);
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.onFileChooser(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.P != null && SapiWebView.this.P.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.P.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.e(Log.TAG, "webview", str2);
                final String[] strArr = {""};
                SapiWebView.this.ab.H = jsPromptResult;
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiJsInterpreters.AbstractInterpreter a2;
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if ("sapi_action_pick_image".equals(actionName) || "sapi_action_pick_date".equals(actionName) || "sapi_biometrics_identification".equals(actionName) || "sapi_biometrics_identification_no_bduss".equals(actionName) || "sapi_biometrics_identification_with_authtoken".equals(actionName) || "sapi_biometrics_identification_with_uid".equals(actionName) || "sapi_action_sc_app_invoke".equals(actionName) || "sapi_action_upsms".equals(actionName)) {
                                SapiWebView.this.ab.H = jsPromptResult;
                            }
                            if (!TextUtils.isEmpty(actionName) && (a2 = SapiWebView.this.aa.a(actionName)) != null) {
                                strArr[0] = a2.interpret(parse);
                            }
                            if (parse.getActionParams().size() > 2 && SapiWebView.c.equals(parse.getActionParams().get(2))) {
                                jsPromptResult.cancel();
                                return;
                            } else if (!"sapi_action_pick_image".equals(actionName) && !"sapi_action_pick_date".equals(actionName) && !"sapi_biometrics_identification".equals(actionName) && !"sapi_biometrics_identification_no_bduss".equals(actionName) && !"sapi_biometrics_identification_with_authtoken".equals(actionName) && !"sapi_biometrics_identification_with_uid".equals(actionName) && !"sapi_action_sc_app_invoke".equals(actionName) && !"sapi_action_upsms".equals(actionName)) {
                                jsPromptResult.confirm(strArr[0]);
                                return;
                            } else {
                                return;
                            }
                        }
                        jsPromptResult.cancel();
                    }
                });
                return true;
            }
        });
        if (this.ab.F == null) {
            this.ab.F = new DefaultAuthorizationListener();
        }
        if (this.K == null) {
            this.K = new DefaultWeixinHandler();
        }
        this.ab.e = new SmsHandler();
        this.ab.G = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.u();
            }
        };
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        if (statLoadLogin != null) {
            statLoadLogin.tWebviewInitDone = System.currentTimeMillis();
        }
        PluginFacade.notify(11002, IEventCenterService.EventResult.PHASE.SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (webResourceRequest.getUrl().toString().contains(SapiWebView.d)) {
                        String str = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str)) {
                            return new WebResourceResponse("text/css", IoUtils.UTF_8, SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str));
                        }
                    }
                } catch (Exception e) {
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21) {
                try {
                    if (str.contains(SapiWebView.d)) {
                        String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
                        if (!TextUtils.isEmpty(str2)) {
                            return new WebResourceResponse("text/css", IoUtils.UTF_8, SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str2));
                        }
                    }
                } catch (Exception e) {
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null) {
                if (str.startsWith("sms") || str.startsWith("tel") || str.startsWith("bdscenter")) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        SapiWebView.this.getContext().startActivity(intent);
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                    return true;
                } else if (str.startsWith("wtloginmqq")) {
                    return true;
                } else {
                    if (SapiWebView.this.as != null) {
                        Uri parse = Uri.parse(str);
                        if (SapiWebView.this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").equals(parse.getHost() + (parse.getPort() == -1 ? "" : ":" + parse.getPort())) && SapiEnv.LOGIN_PROXY_URI.equals(parse.getPath())) {
                            SapiAccountManager.getInstance().getAccountService().a(SapiWebView.this.as, str);
                            return true;
                        }
                    }
                    if (SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL).equals(str)) {
                        SapiWebView.this.finish();
                    }
                }
            }
            if (SapiWebView.this.O != null) {
                SapiWebView.this.O.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.ab.B != null) {
                Uri parse = Uri.parse(SapiWebView.this.l());
                Uri parse2 = Uri.parse(str);
                if (parse2 == null || !(parse2.getHost() + parse2.getPath()).equals(parse.getHost() + parse.getPath())) {
                    SapiWebView.this.ab.B.pageState(2);
                } else {
                    SapiWebView.this.ab.B.pageState(1);
                }
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.s();
            }
            SapiWebView.this.al.setUrl(str);
            SapiWebView.this.ak.postDelayed(SapiWebView.this.al, SapiWebView.this.aj);
            SapiWebView.this.t();
            if (str != null) {
                if (str.contains("__wp-action=auth-widget")) {
                    final String queryParameter = Uri.parse(str).getQueryParameter("authsid");
                    if (!TextUtils.isEmpty(queryParameter) && SapiWebView.this.S != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.S != null) {
                                    SapiWebView.this.S.onSuccess(queryParameter);
                                }
                            }
                        });
                    }
                }
                if (str.contains(SapiWebView.h) || str.contains(SapiWebView.i)) {
                    String queryParameter2 = Uri.parse(str).getQueryParameter(SapiWebView.e);
                    if (SapiWebView.h.equals(queryParameter2) && SapiWebView.this.R != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.R != null) {
                                    SapiWebView.this.R.onSuccess();
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.SUCCESS);
                                }
                            }
                        });
                    }
                    if (SapiWebView.i.equals(queryParameter2) && SapiWebView.this.R != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.R != null) {
                                        SapiWebView.this.R.onSuccess();
                                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                        return;
                                    }
                                    return;
                                }
                                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.3.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.R != null) {
                                            SapiWebView.this.R.onSuccess();
                                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                                        if (session != null) {
                                            if (session.uid.equals(getUserInfoResult.uid)) {
                                                session.bduss = cookieBduss;
                                            }
                                            if (!TextUtils.isEmpty(cookiePtoken)) {
                                                session.ptoken = cookiePtoken;
                                            }
                                            session.deleteStokens();
                                        }
                                        SapiAccountManager.getInstance().validate(session);
                                        SapiAccountManager.getInstance().preFetchStoken(session, true);
                                        if (SapiWebView.this.R != null) {
                                            SapiWebView.this.R.onSuccess();
                                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.SUCCESS);
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.R != null) {
                                            SapiWebView.this.R.onSuccess();
                                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onStart() {
                                        try {
                                            SapiWebView.this.ag = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                                        } catch (Throwable th) {
                                            Log.e(th);
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFinish() {
                                        if (SapiWebView.this.ag != null) {
                                            try {
                                                SapiWebView.this.ag.dismiss();
                                            } catch (Throwable th) {
                                                Log.e(th);
                                            }
                                        }
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.f.equals(Uri.parse(str).getQueryParameter(SapiWebView.e))) {
                    if (SapiWebView.this.ab.M == null) {
                        if (SapiWebView.this.ab.F != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.ab.F != null) {
                                        SapiWebView.this.ab.F.onFailed(-100, "登录失败");
                                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                                    }
                                }
                            });
                        }
                    } else {
                        SapiWebView.this.a(SapiWebView.this.ab.M);
                    }
                }
            }
            if (SapiWebView.this.O != null) {
                SapiWebView.this.O.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""), false);
            if (SapiWebView.this.I.environment == Domain.DOMAIN_QA || SapiWebView.this.I.environment == Domain.DOMAIN_RD) {
                sslErrorHandler.proceed();
                return;
            }
            if ((sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) && !SapiWebView.this.I.forbidSslErrorDialog) {
                if (SapiWebView.this.ah == null) {
                    if (Build.VERSION.SDK_INT > 17) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SapiWebView.E);
                        Date date = new Date(System.currentTimeMillis());
                        str = SapiWebView.C;
                        str2 = simpleDateFormat.format(date);
                    } else {
                        str = SapiWebView.D;
                        str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(SapiWebView.H, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SapiWebView.this.getContext().startActivity(new Intent("android.settings.DATE_SETTINGS"));
                            dialogInterface.dismiss();
                            StatService.onEvent("sslerr_date_setting", null, false);
                        }
                    });
                    builder.setNegativeButton(SapiWebView.G, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            StatService.onEvent("sslerr_date_cancel", null, false);
                        }
                    });
                    SapiWebView.this.ah = builder.create();
                }
                if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.ah.isShowing()) {
                    SapiWebView.this.ah.show();
                }
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            }
            if (SapiWebView.this.ac != null) {
                SapiWebView.this.ac.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.ad != null && SapiWebView.this.ad.getVisibility() != 4) {
                SapiWebView.this.ad.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.aq);
            if (SapiWebView.this.ab.g != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().l());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().m());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(SapiEnv.ACCOUNT_CENTER_EDITUSER) || str.contains(SapiEnv.ACCOUNT_CENTER_ACCOUNT_BIND)) {
                SapiWebView.this.at = Uri.parse(str).getQueryParameter("gotoUrl");
            } else if (!str.contains(SapiEnv.ACCOUNT_CENTER_MODIFY_PWD_RESULT)) {
                SapiWebView.this.at = null;
            } else {
                SapiWebView.this.at = Uri.parse(str).getQueryParameter("refer");
            }
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.au = true;
            } else {
                SapiWebView.this.au = false;
            }
            if ((str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) && !"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().h())) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '0', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.ak.removeCallbacks(SapiWebView.this.al);
            if (SapiWebView.this.O != null) {
                SapiWebView.this.O.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i == -8 || i == -6 || i == -2 || i == -5) {
                SapiWebView.this.r();
            }
        }
    }

    private void a(ValueCallback<Uri[]> valueCallback) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.ai = true;
        this.ak.removeCallbacks(this.al);
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.W.b) {
            loadWeixinSSOLogin(this.W.c, this.W.d, this.W.e);
        } else if (this.W.a != null) {
            loadUrl(this.W.a);
        } else {
            super.reload();
        }
        this.W.a();
    }

    /* loaded from: classes.dex */
    private class ReloadConfig {
        String a;
        boolean b;
        boolean c;
        String d;
        List<NameValuePair> e;

        private ReloadConfig() {
            this.a = null;
            this.b = false;
        }

        void a() {
            this.a = null;
            this.b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SmsHandler extends Handler {
        String a;
        String b;

        SmsHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj != null) {
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                    SapiWebView.this.loadUrl(String.format("javascript:%s('%s','%s');", this.a, str, this.b));
                }
                SapiWebView.this.u();
                removeCallbacks(SapiWebView.this.ab.G);
            }
        }
    }

    public String getUaInfo() {
        String encode = URLEncoder.encode("Sapi_8.7.5.1.2_Android_" + SapiUtils.getAppName(getContext()) + BaseRequestAction.SPLITE + SapiUtils.getVersionName(getContext()) + BaseRequestAction.SPLITE + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + BaseRequestAction.SPLITE + (!TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "") + "_Sapi");
        if (n() && !TextUtils.isEmpty(this.I.userAgent)) {
            return encode + " " + this.I.userAgent;
        }
        return encode;
    }

    private boolean n() {
        for (String str : SapiContext.getInstance(getContext()).getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void o() {
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            Log.e(e2);
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " " + getUaInfo());
        getSettings().setTextSize(WebSettings.TextSize.NORMAL);
        getSettings().setDomStorageEnabled(true);
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.5
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        if ((this.ad == null || this.ad.getVisibility() != 0) && (this.ae == null || this.ae.getVisibility() != 0)) {
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if ((this.ad != null && this.ad.getVisibility() == 0) || (this.ae != null && this.ae.getVisibility() == 0)) {
            super.scrollTo(0, 0);
        }
        super.scrollTo(i2, i3);
    }

    /* loaded from: classes.dex */
    public enum ActivityLifeCycle {
        ON_RESUME("webViewWillAppear"),
        ON_PAUSE("webViewWillDisappear");
        
        String a;

        ActivityLifeCycle(String str) {
            this.a = str;
        }
    }

    @TargetApi(8)
    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (!getSettings().getBlockNetworkLoads()) {
            loadUrl(b(activityLifeCycle.a));
        }
    }

    private String b(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.ab.F = authorizationListener;
    }

    public void setFastRegHandler(FastRegHandler fastRegHandler) {
        this.ab.d = fastRegHandler;
    }

    public void setNmLoginHandler(NMLoginHandler nMLoginHandler) {
        this.ab.b = nMLoginHandler;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.K = weixinHandler;
    }

    public void setQQSSOHandler(QQSSOHandler qQSSOHandler) {
        this.M = qQSSOHandler;
    }

    public void setHuaweiHandler(HuaweiHandler huaweiHandler) {
        this.L = huaweiHandler;
    }

    public void setMeizuHandler(MeizuHandler meizuHandler) {
        this.N = meizuHandler;
    }

    public void setUniteVerifyHandler(UniteVerifyHandler uniteVerifyHandler) {
        this.ab.c = uniteVerifyHandler;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.ab.m = loadExternalWebViewCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.O = webviewClientCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.P = webChromeClientCallback;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.Q = fileChooserCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.ab.n = pickPhotoCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.R = changePwdCallback;
    }

    public void setAuthWidgetCallback(AuthWidgetCallback authWidgetCallback) {
        this.S = authWidgetCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.ab.l = bindWidgetCallback;
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.ab.j = uniteVerifyCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.ab.r = realnameAuthenticateCallback;
    }

    public void setSystemUpwardSmsCallback(SystemUpwardSmsCallback systemUpwardSmsCallback) {
        this.ab.y = systemUpwardSmsCallback;
    }

    public void setSocialBindHandler(Handler handler) {
        this.ab.f = handler;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.ab.a = handler;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.ab.g = webViewTitleCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.ab.i = biometricsIdentifyCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.ab.h = bioScanFaceCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.ab.z = invokeScAppCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.ab.s = coverWebBdussCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.ab.p = switchAccountCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.ab.t = preFillUserNameCallback;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.ab.o = bdussChangeCallback;
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.T = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.ab.u = accountDestoryCallback;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.ab.q = leftBtnVisibleCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.ab.w = shareAccountClickCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.ab.P = joinLoginParams;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.ab.A = localConfigCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.ab.B = pageStateCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.ab.v = accountFreezeCallback;
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback) {
        this.ab.C = normalizeGuestAccountCallback;
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.ab.E = realNameStatusCallback;
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadLogin(int i2) {
        loadLogin(i2, null);
    }

    public void loadLogin(List<NameValuePair> list) {
        loadLogin(0, list);
    }

    public void loadLogin(int i2, List<NameValuePair> list) {
        boolean z2 = true;
        if (this.I.supportFaceLogin && this.ab.i == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        if (!"com.baidu.sapi2.activity.LoginActivity".equals(getContext().getClass().getName())) {
            throw new RuntimeException("please update to V8 mode for access the pass sdk, if you have any problem you can access the following documents ：http://wiki.baidu.com/pages/viewpage.action?pageId=325878724");
        }
        if (statLoadLogin != null) {
            statLoadLogin.tBeforeLogin = System.currentTimeMillis();
        }
        this.ax = true;
        if (4 == i2) {
            b(list);
        } else {
            if (this.I.supportSpecialLogin) {
                String string = SapiContext.getInstance(this.I.context).getString(SapiContext.KEY_PRE_LOGIN_TYPE);
                if ("password".equals(string)) {
                    i2 = 0;
                } else if ("sms".equals(string)) {
                    i2 = 1;
                }
            }
            List<ShareStorage.StorageModel> a2 = com.baidu.sapi2.share.a.a().a(this.I.context);
            if (!com.baidu.sapi2.share.a.e() || !this.shareV2Disable) {
                z2 = false;
            }
            this.shareV2Disable = z2;
            if (this.ab.w != null && a2 != null && a2.size() > 0 && !this.shareV2Disable) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new BasicNameValuePair("share_version", "2"));
                a(i2, list, this.I.customActionBarEnabled);
            } else if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
                a(i2, list, this.I.customActionBarEnabled);
            } else {
                a(i2, list);
            }
        }
        SapiStatUtil.statLoadLogin();
    }

    private void a(int i2, List<NameValuePair> list) {
        this.U = q();
        String a2 = a(l(), list);
        switch (i2) {
            case 0:
                if (this.ab.m != null) {
                    a2 = a2 + "&enableExternalWeb=1";
                }
                if (this.I.supportFaceLogin) {
                    a2 = a2 + "&liveAbility=1";
                }
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN, IEventCenterService.EventResult.PHASE.START);
                if (TextUtils.isEmpty(this.U) || !this.I.supportFaceLogin) {
                    loadUrl(a2 + m);
                    return;
                } else {
                    loadUrl(a2 + "#" + this.U);
                    return;
                }
            case 1:
                if (this.ab.m != null) {
                    a2 = a2 + "&enableExternalWeb=1";
                }
                if (this.I.supportFaceLogin) {
                    a2 = a2 + "&liveAbility=1";
                }
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_SMS_LOGIN, IEventCenterService.EventResult.PHASE.START);
                if (SapiContext.getInstance(getContext()).smsFaceLoginEnable() && !TextUtils.isEmpty(this.U) && this.I.supportFaceLogin) {
                    loadUrl(a2 + "#" + this.U);
                    return;
                } else {
                    loadUrl(a2 + r);
                    return;
                }
            case 2:
                this.ax = false;
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG, IEventCenterService.EventResult.PHASE.START);
                if (this.ab.d != null) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.ab.d != null) {
                                SapiWebView.this.ab.d.handleFastReg();
                            }
                        }
                    });
                    return;
                } else {
                    loadFastReg();
                    return;
                }
            default:
                loadUrl(a2 + m);
                return;
        }
    }

    private void b(List<NameValuePair> list) {
        String a2 = a(l(), list);
        if (this.ab.m != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        if (this.I.supportFaceLogin) {
            a2 = a2 + "&liveAbility=1";
        }
        loadUrl(a2 + n);
    }

    public void loadLoginWithUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            loadLogin();
            return;
        }
        String str2 = "";
        try {
            str2 = "disusername=" + URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            loadUrl(l() + ETAG.ITEM_SEPARATOR + str2 + o);
        } else {
            loadLogin();
        }
    }

    public void loadQuickLogin(QuickLoginHandler quickLoginHandler) {
        if (quickLoginHandler == null) {
            throw new IllegalArgumentException(QuickLoginHandler.class.getSimpleName() + " can't be null");
        }
        this.ab.k = quickLoginHandler;
        a(3, (List<NameValuePair>) null, true);
    }

    private void p() {
        a(0, (List<NameValuePair>) null, this.I.customActionBarEnabled);
    }

    private void a(int i2, List<NameValuePair> list, boolean z2) {
        String str;
        String l2 = l();
        if (z2 && !this.I.customActionBarEnabled) {
            l2 = l2 + "&adapter=3";
        }
        if (this.ab.m != null) {
            l2 = l2 + "&enableExternalWeb=1";
        }
        if (this.I.supportFaceLogin) {
            l2 = l2 + "&liveAbility=1";
        }
        if (TextUtils.isEmpty(q()) || this.ab.i == null) {
            str = l2 + "&loginInitType=" + a(i2);
        } else {
            str = l2 + "&loginInitType=4";
        }
        loadUrl(a(str, list) + q);
    }

    private int a(int i2) {
        if (i2 == 0) {
            return this.I.smsLoginConfig.flagLoginBtnType.ordinal();
        }
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            return 0;
        }
        return i2;
    }

    public void loadLoginProxy(SapiCallback<LoginResult> sapiCallback, String str) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("actionUrl can't be empty");
        }
        this.as = sapiCallback;
        loadUrl(str);
    }

    public void loadRegist() {
        loadRegist(null);
    }

    public void loadRegist(List<NameValuePair> list) {
        String l2 = l();
        if (this.I.quickUserEnabled && this.I.registMode == RegistMode.QUICK_USER) {
            l2 = l2.replace("regtype=2", "regtype=1");
        }
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG, IEventCenterService.EventResult.PHASE.START);
        loadUrl(a(l2, list) + p);
        this.ax = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, List<NameValuePair> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    try {
                        arrayList.add(new BasicNameValuePair(URLEncoder.encode(nameValuePair.getName(), "UTF-8"), URLEncoder.encode(nameValuePair.getValue(), "UTF-8")));
                    } catch (UnsupportedEncodingException e2) {
                        Log.e(e2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return str + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
            }
            return str;
        }
        return str;
    }

    public void loadQuickUserReg() {
        loadQuickUserReg(null);
    }

    public void loadQuickUserReg(List<NameValuePair> list) {
        if (!this.I.quickUserEnabled) {
            loadRegist(list);
            return;
        }
        String l2 = l();
        if (this.I.registMode != RegistMode.QUICK_USER) {
            l2 = l2 + "&regtype=2";
        }
        loadUrl(a(l2, list) + p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str) {
        SapiAccountManager.getInstance().getAccountService().webLogin(context, str);
    }

    public void loadModifyPwd(String str) {
        loadModifyPwd(str, null);
    }

    public void loadModifyPwd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        a(getContext(), str);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + e + ETAG.EQUAL + i, "UTF-8")));
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new BasicNameValuePair("skin", str2));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String f2 = f();
        if (arrayList.size() > 0) {
            f2 = f2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        String b2 = b();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled()), b2));
        loadUrl(f2, arrayList2);
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.START);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z2) {
        this.ab.x = qrLoginCallback;
        this.ab.K = z2;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadExternalUrl(String str) {
        loadExternalUrl(str, null);
    }

    public void loadExternalUrl(String str, List<NameValuePair> list) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("externalUrl can't be empty");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new BasicNameValuePair("clientfrom", "native"));
        list.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        list.add(new BasicNameValuePair("deliverParams", "1"));
        if (this.I.supportFaceLogin) {
            list.add(new BasicNameValuePair("scanface", "1"));
        }
        if (this.ab.n != null && this.I.supportPhoto) {
            list.add(new BasicNameValuePair("support_photo", "1"));
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf + 1) + SapiUtils.createRequestParams(list) + ETAG.ITEM_SEPARATOR + str.substring(indexOf + 1, str.length());
        } else {
            str2 = str + "?" + SapiUtils.createRequestParams(list);
        }
        loadUrl(str2);
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + e + ETAG.EQUAL + h, "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new BasicNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String e3 = e();
        if (arrayList.size() > 0) {
            e3 = e3 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(e3);
    }

    public void loadUserAgreement() {
        loadUrl(this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled()) + "/passport/agreement?adapter=3");
    }

    public void loadOperationRecord(String str) {
        loadOperationRecord(str, null);
    }

    public void loadOperationRecord(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        a(getContext(), str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        String g2 = g();
        if (arrayList.size() > 0) {
            g2 = g2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(g2);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str) {
        loadBindWidget(bindWidgetAction, str, null, true, null);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, List<NameValuePair> list) {
        loadBindWidget(bindWidgetAction, str, null, true, list);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, boolean z2) {
        loadBindWidget(bindWidgetAction, str, null, z2, null);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z2, List<NameValuePair> list) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        a(getContext(), str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        if (z2) {
            arrayList.add(new BasicNameValuePair(FreeSpaceBox.TYPE, "1"));
        }
        if (this.I.supportFaceLogin) {
            arrayList.add(new BasicNameValuePair("liveAbility", "1"));
        }
        String a2 = a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        String a3 = a(a2, list);
        String b2 = b();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled()), b2));
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BIND_WIDGET, IEventCenterService.EventResult.PHASE.START);
        loadUrl(a3, arrayList2);
    }

    public void loadAuthWidget(String str) {
        loadAuthWidget(null, str, null);
    }

    @Deprecated
    public void loadAuthWidget(String str, String str2) {
        loadAuthWidget(str, str2, null);
    }

    @Deprecated
    public void loadAuthWidget(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("authToken can't be empty");
        }
        a(getContext(), str);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("token", URLEncoder.encode(str2, "UTF-8")));
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + e + ETAG.EQUAL + g, "UTF-8")));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new BasicNameValuePair("skin", str3));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String h2 = h();
        if (arrayList.size() > 0) {
            h2 = h2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(h2);
    }

    public void loadFillUProfile(String str) {
        loadFillUProfile(str, false);
    }

    public void loadFillUProfile(String str, boolean z2) {
        loadFillUProfile(str, z2, null);
    }

    public void loadFillUProfile(String str, boolean z2, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        a(getContext(), str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        if (z2) {
            arrayList.add(new BasicNameValuePair("simplify", "1"));
        }
        String j2 = j();
        if (arrayList.size() > 0) {
            j2 = j2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(j2);
    }

    public void loadRealnameAuthenticate(final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(this.I.realnameAuthenticateStoken)) {
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String k2 = SapiWebView.this.k();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new BasicNameValuePair("bduss", str));
                arrayList2.add(new BasicNameValuePair(ISapiAccount.SAPI_ACCOUNT_STOKEN, getTplStokenResult.tplStokenMap.get("pp")));
                arrayList2.add(new BasicNameValuePair("bdstoken", SapiWebView.this.I.realnameAuthenticateStoken));
                SapiWebView.this.loadUrl(k2 + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (SapiWebView.this.ab.r != null) {
                    SapiWebView.this.ab.r.onFailure();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REALNAME_AUTHENTICATE, IEventCenterService.EventResult.PHASE.FAILURE);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REALNAME_AUTHENTICATE, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REALNAME_AUTHENTICATE, IEventCenterService.EventResult.PHASE.FINISH);
            }
        }, str, arrayList);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("token", URLEncoder.encode(str, "UTF-8")));
            if (str2 != null) {
                arrayList.add(new BasicNameValuePair("u", str2));
            }
            if (str3 != null) {
                arrayList.add(new BasicNameValuePair("adtext", URLEncoder.encode(str3, "UTF-8")));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(i() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList));
    }

    public void loadFastReg() {
        loadFastReg(null);
    }

    public void loadFastReg(List<NameValuePair> list) {
        if (!SapiUtils.isSimReady(getContext()) || !SapiUtils.hasActiveNetwork(getContext())) {
            loadUrl(a(l() + "&regLink=0", list) + r);
        } else {
            loadUrl(a(l(), list) + s);
            this.ab.O = new FastRegAction();
            this.ab.O.b();
        }
        this.ax = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.ab.N = sapiAccountResponse;
        loadUrl(l() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + t);
    }

    public void loadNormalizeGuestAccount(List<NameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(a(a(socialType), list));
    }

    public void loadAccountCenter(String str) {
        loadAccountCenter(null, str);
    }

    public void loadAccountCenter(List<NameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadAccountCenter(List<NameValuePair> list, String str, String str2) {
        SapiAccountService.a(getContext(), str);
        String a2 = a(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.ab.n != null && this.I.supportPhoto) {
            list.add(new BasicNameValuePair("support_photo", "1"));
        }
        if (this.ab.i != null && this.I.supportFaceLogin) {
            list.add(new BasicNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(a(a2, list));
    }

    public void loadAccountRealName(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("scene", str2));
        }
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public boolean notifyKefuBack() {
        boolean z2 = this.ab.J;
        if (this.ab.J) {
            loadUrl(ar);
            this.ab.J = false;
        }
        return z2;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    public long getTimeoutMillis() {
        return this.aj;
    }

    public void setTimeoutMillis(long j2) {
        this.aj = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<NameValuePair> list) {
        c(str);
        a(list);
        String a2 = SapiCache.a(getContext(), str);
        String a3 = !TextUtils.isEmpty(a2) ? a(a2, str) : str;
        if (!TextUtils.isEmpty(a2)) {
            loadDataWithBaseURL(a3, a2, j, "UTF-8", a3);
        } else {
            d(a3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // java.lang.Runnable
            public void run() {
                String str6;
                if (!SapiWebView.this.ai) {
                    String[] split = str.split("#");
                    if (split != null && split.length > 0) {
                        str6 = split[0] + "&loadDataWithBaseUrl=1#" + split[1];
                    } else {
                        str6 = str + "&loadDataWithBaseUrl=1";
                    }
                    SapiWebView.this.a(str, true);
                    SapiWebView.super.loadDataWithBaseURL(str6, str2, str3, str4, str5);
                }
            }
        });
    }

    public void back() {
        if (this.at != null) {
            loadUrl(this.at);
        } else if (this.au) {
            finish();
        } else if (this.ap != null && this.ab.N == null && this.ab.M == null) {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.ap.onBack();
        } else {
            c(this.ab.N);
            super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
            a(this.ab.M);
        }
        if ((this.ad != null && this.ad.getVisibility() == 0) || (this.ae != null && this.ae.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        u();
        if (this.ab.O != null) {
            this.ab.O.f = true;
            this.ab.O.k.removeCallbacks(this.ab.O.l);
        }
        if (this.an != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (SapiWebView.this.an != null) {
                        SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                        SapiWebView.this.an.onFinish();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FINISH, IEventCenterService.EventResult.PHASE.SUCCESS);
                    }
                }
            });
        }
    }

    private String q() {
        if (TextUtils.isEmpty(this.U)) {
            this.U = SapiContext.getInstance(getContext()).geSupFaceLoginType();
        }
        return this.U;
    }

    private void c(String str) {
        if (statLoadLogin != null) {
            String q2 = q();
            if (str.contains(m) || str.contains(q) || str.contains(n) || str.contains(s) || str.contains(r) || (!TextUtils.isEmpty(q2) && str.contains(q2))) {
                statLoadLogin.tStartLogin = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2) {
        if (statLoadLogin != null) {
            String q2 = q();
            if (str.contains(m) || str.contains(q) || str.contains(n) || str.contains(s) || str.contains(r) || (!TextUtils.isEmpty(q2) && str.contains(q2))) {
                statLoadLogin.tLoadLogin = System.currentTimeMillis();
                statLoadLogin.isLoadCache = z2;
            }
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (this.V != null) {
            this.V.authorizeCallBack(i2, i3, intent);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (onKeyUp(i2)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public boolean onKeyUp(int i2) {
        if (i2 == 4 && this.av == 1) {
            if (this.aw) {
                notifyKefuBack();
                return true;
            }
            if (this.ao != null && this.ab.N == null && this.ab.M == null) {
                this.ao.onBack();
            }
            back();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccountResponse a(String str, Context context) {
        SapiAccountResponse sapiAccountResponse;
        Throwable th;
        XmlPullParser newPullParser;
        boolean z2;
        int eventType;
        boolean z3;
        SapiAccountResponse sapiAccountResponse2 = null;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b2)) {
            try {
                newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
                z2 = false;
                eventType = newPullParser.getEventType();
                sapiAccountResponse = null;
            } catch (Throwable th2) {
                sapiAccountResponse = null;
                th = th2;
            }
            while (eventType != 1) {
                switch (eventType) {
                    case 2:
                        try {
                            String name = newPullParser.getName();
                            if (name.equalsIgnoreCase("data")) {
                                if (sapiAccountResponse == null) {
                                    sapiAccountResponse = new SapiAccountResponse();
                                    z3 = z2;
                                    continue;
                                    eventType = newPullParser.next();
                                    z2 = z3;
                                }
                            } else {
                                if (sapiAccountResponse == null && name.equalsIgnoreCase("error_code")) {
                                    SapiAccountResponse sapiAccountResponse3 = new SapiAccountResponse();
                                    try {
                                        sapiAccountResponse3.errorCode = Integer.parseInt(newPullParser.nextText());
                                        sapiAccountResponse = sapiAccountResponse3;
                                        z3 = z2;
                                        continue;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sapiAccountResponse = sapiAccountResponse3;
                                    }
                                } else if (sapiAccountResponse == null && name.equalsIgnoreCase("error_description")) {
                                    SapiAccountResponse sapiAccountResponse4 = new SapiAccountResponse();
                                    try {
                                        sapiAccountResponse4.errorMsg = newPullParser.nextText();
                                        sapiAccountResponse = sapiAccountResponse4;
                                        z3 = z2;
                                        continue;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        sapiAccountResponse = sapiAccountResponse4;
                                    }
                                } else if (sapiAccountResponse != null) {
                                    if (name.equalsIgnoreCase("errno")) {
                                        sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("uname")) {
                                        sapiAccountResponse.username = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("errmsg")) {
                                        sapiAccountResponse.errorMsg = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("bduss")) {
                                        sapiAccountResponse.bduss = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase(ISapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                                        sapiAccountResponse.ptoken = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase(ISapiAccount.SAPI_ACCOUNT_STOKEN)) {
                                        if (z2) {
                                            String[] split = newPullParser.nextText().split("#");
                                            sapiAccountResponse.tplStokenMap.put(split[0], split[1]);
                                            z3 = z2;
                                            continue;
                                        } else {
                                            sapiAccountResponse.stoken = newPullParser.nextText();
                                            z3 = z2;
                                            continue;
                                        }
                                    } else if (name.equalsIgnoreCase("displayname")) {
                                        sapiAccountResponse.displayname = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("uid")) {
                                        sapiAccountResponse.uid = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("authsid")) {
                                        sapiAccountResponse.authSid = newPullParser.nextText();
                                        sapiAccountResponse.newReg = !TextUtils.isEmpty(sapiAccountResponse.authSid);
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("account")) {
                                        sapiAccountResponse.reloginCredentials.account = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("accounttype")) {
                                        sapiAccountResponse.reloginCredentials.accountType = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("password")) {
                                        sapiAccountResponse.reloginCredentials.password = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("ubi")) {
                                        sapiAccountResponse.reloginCredentials.ubi = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("stoken_list")) {
                                        z3 = true;
                                        continue;
                                    } else if (name.equalsIgnoreCase("os_headurl")) {
                                        sapiAccountResponse.socialPortraitUrl = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("os_type")) {
                                        sapiAccountResponse.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("incomplete_user")) {
                                        String nextText = newPullParser.nextText();
                                        if ("0".equals(nextText)) {
                                            sapiAccountResponse.accountType = AccountType.NORMAL;
                                        } else if ("1".equals(nextText)) {
                                            sapiAccountResponse.accountType = AccountType.INCOMPLETE_USER;
                                        } else {
                                            sapiAccountResponse.accountType = AccountType.UNKNOWN;
                                        }
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("actiontype")) {
                                        sapiAccountResponse.actionType = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equals("livinguname")) {
                                        sapiAccountResponse.livingUname = URLDecoder.decode(newPullParser.nextText());
                                        z3 = z2;
                                        continue;
                                    } else if ("loginType".equals(name)) {
                                        SapiContext.getInstance(context).put(SapiContext.KEY_PRE_LOGIN_TYPE, newPullParser.nextText());
                                        z3 = z2;
                                        continue;
                                    } else if (name.equals("mobilephone")) {
                                        SapiContext.getInstance(context).putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, newPullParser.nextText());
                                        z3 = z2;
                                        continue;
                                    } else if (name.equals("app")) {
                                        sapiAccountResponse.app = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equals("extra")) {
                                        sapiAccountResponse.extra = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    }
                                }
                                eventType = newPullParser.next();
                                z2 = z3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        th = th5;
                        Log.e(th);
                        sapiAccountResponse2 = sapiAccountResponse;
                        if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
                            sapiAccountResponse2.errorCode = 0;
                            break;
                        }
                        break;
                    case 3:
                        z3 = z2;
                        continue;
                        eventType = newPullParser.next();
                        z2 = z3;
                }
                z3 = z2;
                continue;
                eventType = newPullParser.next();
                z2 = z3;
            }
            sapiAccountResponse2 = sapiAccountResponse;
            if (sapiAccountResponse2 != null) {
                sapiAccountResponse2.errorCode = 0;
            }
        }
        return sapiAccountResponse2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2841=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SocialResponse b(String str, Context context) {
        SocialResponse socialResponse;
        SocialResponse socialResponse2 = null;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b2)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    switch (eventType) {
                        case 2:
                            String name = newPullParser.getName();
                            if (name.equalsIgnoreCase("data")) {
                                if (socialResponse2 == null) {
                                    socialResponse = new SocialResponse();
                                    break;
                                }
                                socialResponse = socialResponse2;
                                break;
                            } else if (socialResponse2 == null && name.equalsIgnoreCase("error_code")) {
                                socialResponse = new SocialResponse();
                                try {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                    break;
                                } catch (Exception e2) {
                                    socialResponse2 = socialResponse;
                                    e = e2;
                                    Log.e(e);
                                    return socialResponse2;
                                }
                            } else if (socialResponse2 == null && name.equalsIgnoreCase("error_description")) {
                                socialResponse = new SocialResponse();
                                try {
                                    socialResponse.errorMsg = newPullParser.nextText();
                                    break;
                                } catch (Exception e3) {
                                    socialResponse2 = socialResponse;
                                    e = e3;
                                    Log.e(e);
                                    return socialResponse2;
                                }
                            } else {
                                if (socialResponse2 != null) {
                                    if (name.equalsIgnoreCase("error_code")) {
                                        socialResponse2.errorCode = Integer.parseInt(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("error_description")) {
                                        socialResponse2.errorMsg = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("is_binded")) {
                                        socialResponse2.isBinded = "1".equals(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("display_name")) {
                                        socialResponse2.displayname = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("passport_uname")) {
                                        socialResponse2.username = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("bduid")) {
                                        socialResponse2.uid = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("bduss")) {
                                        socialResponse2.bduss = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase(ISapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                                        socialResponse2.ptoken = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("os_username")) {
                                        socialResponse2.socialUname = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("os_headurl")) {
                                        socialResponse2.socialPortraitUrl = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("os_type")) {
                                        socialResponse2.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("notice_offline")) {
                                        socialResponse2.offlineNotice = "1".equals(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("guidebind")) {
                                        socialResponse2.bindGuide = "1".equals(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("bind_conflict")) {
                                        socialResponse2.bindConflict = "1".equals(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("wapsec")) {
                                        socialResponse2.accountCenterFlag = "center".equals(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("next_url_related")) {
                                        String nextText = newPullParser.nextText();
                                        if (socialResponse2.accountCenterFlag) {
                                            socialResponse2.nextUrl = nextText;
                                        }
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("incomplete_user")) {
                                        String nextText2 = newPullParser.nextText();
                                        if ("0".equals(nextText2)) {
                                            socialResponse2.accountType = AccountType.NORMAL;
                                        } else if ("1".equals(nextText2)) {
                                            socialResponse2.accountType = AccountType.INCOMPLETE_USER;
                                        } else {
                                            socialResponse2.accountType = AccountType.UNKNOWN;
                                        }
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase(ISapiAccount.SAPI_ACCOUNT_STOKEN)) {
                                        String[] split = newPullParser.nextText().split("#");
                                        socialResponse2.tplStokenMap.put(split[0], split[1]);
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equalsIgnoreCase("actiontype")) {
                                        socialResponse2.actionType = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equals("livinguname")) {
                                        socialResponse2.livingUname = URLDecoder.decode(newPullParser.nextText());
                                        socialResponse = socialResponse2;
                                        break;
                                    } else if (name.equals("guest_account")) {
                                        socialResponse2.isGuestAccount = newPullParser.nextText();
                                        socialResponse = socialResponse2;
                                        break;
                                    }
                                }
                                socialResponse = socialResponse2;
                            }
                            break;
                        case 3:
                            socialResponse = socialResponse2;
                            break;
                        default:
                            socialResponse = socialResponse2;
                            break;
                    }
                    try {
                        socialResponse2 = socialResponse;
                    } catch (Exception e4) {
                        socialResponse2 = socialResponse;
                        e = e4;
                        Log.e(e);
                        return socialResponse2;
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return socialResponse2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.af != null) {
                    SapiWebView.this.af.setVisibility(8);
                }
                if (SapiWebView.this.ac != null) {
                    SapiWebView.this.ac.setVisibility(8);
                }
                SapiWebView.this.W.a = SapiWebView.this.al.b;
                if (SapiWebView.this.ae != null) {
                    SapiWebView.this.ae.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.af != null) {
                    SapiWebView.this.af.setVisibility(8);
                }
                if (SapiWebView.this.ac != null) {
                    SapiWebView.this.ac.setVisibility(8);
                }
                if (SapiWebView.this.ad != null) {
                    SapiWebView.this.ad.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.ad == null || this.ad.getVisibility() != 0) {
            if (this.ae == null || this.ae.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.ac != null) {
                            SapiWebView.this.ac.setVisibility(0);
                            if (SapiWebView.this.af != null) {
                                SapiWebView.this.af.setVisibility(8);
                            }
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public class DefaultAuthorizationListener extends AuthorizationListener {
        public DefaultAuthorizationListener() {
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess() {
            SapiWebView.this.finish();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            SapiWebView.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class DefaultWeixinHandler implements WeixinHandler {
        public DefaultWeixinHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleNotInstall() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleServerError(String str) {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.x, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void onFinish() {
            if (SapiWebView.this.getContext() instanceof Activity) {
                ((Activity) SapiWebView.this.getContext()).finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class DefaultHuaweiHandler implements HuaweiHandler {
        public DefaultHuaweiHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.HuaweiHandler
        public void handleHuaweiLoginFailure() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.y, 1).show();
            SapiWebView.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class DefaultQQSSOHandler implements QQSSOHandler {
        public DefaultQQSSOHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.QQSSOHandler
        public void handleQQSSOLoginFailure() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.z, 1).show();
            SapiWebView.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class DefaultMeizuHandler implements MeizuHandler {
        public DefaultMeizuHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.MeizuHandler
        public void handleMeizuLoginFailure() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.A, 1).show();
            SapiWebView.this.finish();
        }
    }

    public void loadSinaSSOLogin(List<NameValuePair> list) {
        a(true, list);
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.I.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(this.I.environment.getURL(SapiUtils.getDefaultHttpsEnabled()), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    void a(final boolean z2, final List<NameValuePair> list) {
        WbSdk.install(getContext(), new AuthInfo(getContext(), this.I.sinaAppId, this.I.sinaRedirectUri, "email"));
        this.V = new SsoHandler((Activity) getContext());
        this.V.authorize(new WbAuthListener() { // from class: com.baidu.sapi2.SapiWebView.13
            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                SapiWebView.this.loadUrl(SapiWebView.this.a(SapiWebView.this.a(SocialType.SINA_WEIBO, oauth2AccessToken.getToken(), oauth2AccessToken.getUid(), SapiWebView.this.I.sinaAppId), list));
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void cancel() {
                if (z2 && (SapiWebView.this.getContext() instanceof Activity)) {
                    SapiWebView.this.finish();
                }
            }

            @Override // com.sina.weibo.sdk.auth.WbAuthListener
            public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
                Log.e(wbConnectErrorMessage.getErrorMessage(), new Object[0]);
                Toast.makeText(SapiWebView.this.getContext(), wbConnectErrorMessage.getErrorMessage(), 0).show();
            }
        });
    }

    public void loadWeixinSSOLogin(final boolean z2, final String str, final List<NameValuePair> list) {
        if (!WXAPIFactory.createWXAPI(getContext(), this.I.wxAppID).isWXAppInstalled()) {
            if (this.K != null) {
                this.K.handleNotInstall();
                Toast.makeText(getContext(), DEFAULT_WEIXIN_NOT_INSTALL_ERROR, 1).show();
                return;
            }
            return;
        }
        String a2 = a(a(z2, str), list);
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.setUserAgent(getUaInfo());
        CookieStore basicCookieStore = new BasicCookieStore();
        BasicClientCookie basicClientCookie = new BasicClientCookie("cuid", SapiUtils.getClientId(this.I.context));
        basicClientCookie.setDomain(this.I.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""));
        basicClientCookie.setPath("/");
        basicCookieStore.addCookie(basicClientCookie);
        asyncHttpClient.setCookieStore(basicCookieStore);
        asyncHttpClient.get(getContext(), a2, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiWebView.14
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                try {
                    SapiWebView.this.ag = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                if (SapiWebView.this.ag != null) {
                    try {
                        SapiWebView.this.ag.dismiss();
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (SapiWebView.this.ad != null) {
                    SapiWebView.this.W.b = true;
                    SapiWebView.this.W.c = z2;
                    SapiWebView.this.W.d = str;
                    SapiWebView.this.W.e = list;
                    SapiWebView.this.ad.setVisibility(0);
                    return;
                }
                SapiWebView.this.K.handleServerError(str2);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i2, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("mkey", "");
                    if (!TextUtils.isEmpty(optString)) {
                        SapiWebView.this.K.onFinish();
                        SendAuth.Req req = new SendAuth.Req();
                        req.scope = ScopeInfo.SCOPE_ID_USERINFO;
                        req.state = optString;
                        WXAPIFactory.createWXAPI(SapiWebView.this.getContext(), SapiWebView.this.I.wxAppID).sendReq(req);
                    } else {
                        String optString2 = jSONObject.optString("error_code", "");
                        if (SapiWebView.this.K != null) {
                            SapiWebView.this.K.handleServerError(optString2);
                        }
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        });
    }

    public void loadWeixinSSOLogin(List<NameValuePair> list) {
        loadWeixinSSOLogin(false, null, list);
    }

    public void onActivityResultData(int i2, int i3, Intent intent) {
        if (i2 == 11101 || i2 == 10102) {
            Tencent.onActivityResultData(i2, i3, intent, this.J);
        }
    }

    public void loadQQSSOLogin(final List<NameValuePair> list) {
        final Tencent createInstance = Tencent.createInstance(this.I.qqAppID, getContext());
        if (!SapiUtils.isAppInstalled(getContext(), "com.tencent.mobileqq")) {
            Toast.makeText(getContext(), B, 1).show();
            this.M.handleQQSSOLoginFailure();
            return;
        }
        this.J = new IUiListener() { // from class: com.baidu.sapi2.SapiWebView.15
            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                if (obj == null) {
                    SapiWebView.this.M.handleQQSSOLoginFailure();
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null || jSONObject.length() == 0) {
                    SapiWebView.this.M.handleQQSSOLoginFailure();
                    return;
                }
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                        SapiWebView.this.M.handleQQSSOLoginFailure();
                    } else {
                        createInstance.setAccessToken(string, string2);
                        createInstance.setOpenId(string3);
                        SapiWebView.this.a(createInstance, list);
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    SapiWebView.this.M.handleQQSSOLoginFailure();
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                SapiWebView.this.M.handleQQSSOLoginFailure();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                SapiWebView.this.M.handleQQSSOLoginFailure();
                SapiWebView.this.finish();
            }
        };
        if (this.M == null) {
            this.M = new DefaultQQSSOHandler();
        }
        createInstance.login((Activity) getContext(), "all", this.J);
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            Toast.makeText(getContext(), v, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Tencent tencent, final List<NameValuePair> list) {
        if (tencent != null && tencent.isSessionValid()) {
            new UnionInfo(getContext(), tencent.getQQToken()).getUnionId(new IUiListener() { // from class: com.baidu.sapi2.SapiWebView.16
                @Override // com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    SapiWebView.this.M.handleQQSSOLoginFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    if (obj == null) {
                        SapiWebView.this.M.handleQQSSOLoginFailure();
                        return;
                    }
                    SapiWebView.this.loadUrl(SapiWebView.this.a(SapiWebView.this.a(tencent.getAccessToken(), tencent.getOpenId(), ((JSONObject) obj).optString(SocialOperation.GAME_UNION_ID)), list));
                }

                @Override // com.tencent.tauth.IUiListener
                public void onCancel() {
                    SapiWebView.this.M.handleQQSSOLoginFailure();
                }
            });
            return;
        }
        this.M.handleQQSSOLoginFailure();
    }

    public void loadXiaomiSSOLogin() {
        loadXiaomiSSOLogin(null);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.baidu.sapi2.SapiWebView$17] */
    public void loadXiaomiSSOLogin(final List<NameValuePair> list) {
        final XiaomiOAuthFuture startGetAccessToken = new XiaomiOAuthorize().setAppId(this.I.xiaomiAppID.longValue()).setRedirectUrl(this.I.xiaomiRedirectUri).setScope(new int[]{1, 3, 4}).startGetAccessToken((Activity) getContext());
        new Thread() { // from class: com.baidu.sapi2.SapiWebView.17
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3 = null;
                try {
                    XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) startGetAccessToken.getResult();
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                SapiWebView.this.ag = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                        }
                    });
                    if (xiaomiOAuthResults == null || xiaomiOAuthResults.getAccessToken() == null) {
                        SapiWebView.this.v();
                        SapiWebView.this.finish();
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject((String) new XiaomiOAuthorize().callOpenApi(SapiWebView.this.getContext(), SapiWebView.this.I.xiaomiAppID.longValue(), "/user/profile", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult());
                        String optString = jSONObject.optString("result");
                        if (AiAppsBluetoothConstants.ERROR_OK.equals(optString)) {
                            str2 = jSONObject.getJSONObject("data").optString("userId");
                        } else if (AiAppsTouchHelper.TouchEventName.TOUCH_ERROR.equals(optString)) {
                            Log.e(jSONObject.optString("description") + "(" + jSONObject.optString("code") + ")", new Object[0]);
                            SapiWebView.this.v();
                            SapiWebView.this.finish();
                            return;
                        } else {
                            str2 = null;
                        }
                        str = str2;
                    } catch (Exception e2) {
                        SapiWebView.this.v();
                        SapiWebView.this.finish();
                        Log.e(e2);
                        str = null;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject((String) new XiaomiOAuthorize().callOpenApi(SapiWebView.this.getContext(), SapiWebView.this.I.xiaomiAppID.longValue(), "/user/phone", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult());
                        String optString2 = jSONObject2.optString("result");
                        if (AiAppsBluetoothConstants.ERROR_OK.equals(optString2)) {
                            str3 = jSONObject2.getJSONObject("data").optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
                        } else if (AiAppsTouchHelper.TouchEventName.TOUCH_ERROR.equals(optString2)) {
                            Log.e(jSONObject2.optString("description") + "(" + jSONObject2.optString("code") + ")", new Object[0]);
                            SapiWebView.this.v();
                            SapiWebView.this.finish();
                            return;
                        }
                    } catch (Exception e3) {
                        SapiWebView.this.v();
                        SapiWebView.this.finish();
                        Log.e(e3);
                    }
                    SapiWebView.this.loadUrl(SapiWebView.this.a(SapiWebView.this.b(xiaomiOAuthResults.getAccessToken(), str, str3), list));
                    SapiWebView.this.v();
                } catch (Exception e4) {
                    Log.e(e4);
                    SapiWebView.this.finish();
                }
            }
        }.start();
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            Toast.makeText(getContext(), v, 0).show();
        }
    }

    public void weixinSSOLogin(String str, String str2) {
        weixinSSOLogin(str, str2, false);
    }

    public void weixinSSOLogin(String str, String str2, boolean z2) {
        weixinSSOLogin(str, str2, z2, null);
    }

    public void weixinSSOLogin(String str, String str2, boolean z2, List<NameValuePair> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        String a2 = a(a(str, str2, z2), list);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BasicNameValuePair(this.I.environment.getURL(SapiUtils.getDefaultHttpsEnabled()), "mkey=" + str2 + ";domain=." + this.I.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/;httponly"));
        loadUrl(a2, arrayList);
    }

    private void a(Activity activity, boolean z2, IHwIDCallBack iHwIDCallBack, String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                bundle.putInt("loginChannel", Integer.valueOf(str).intValue());
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
        bundle.putBoolean("showLogin", false);
        bundle.putInt("forceLogin", 2);
        bundle.putBoolean("isErrCallback", z2);
        bundle.putBoolean("AIDL", z2);
        OpenHwID.setLoginProxy(activity, this.I.hwAppId, iHwIDCallBack, bundle);
    }

    public void loadHuaWeiSSOLogin() {
        loadHuaWeiSSOLogin(null);
    }

    public void loadHuaWeiSSOLogin(final List<NameValuePair> list) {
        if (getContext() instanceof Activity) {
            a((Activity) getContext(), false, new IHwIDCallBack() { // from class: com.baidu.sapi2.SapiWebView.18
                public void onUserInfo(HashMap hashMap) {
                    String obj = hashMap.get("loginStatus").toString();
                    if (obj != null && obj.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                        SapiWebView.this.c(list);
                    } else {
                        Toast.makeText(SapiWebView.this.getContext(), "请下载华为移动服务APP并安装", 0).show();
                    }
                }
            }, this.I.hwLoginChannelId);
            OpenHwID.initial(getContext(), new Bundle());
            return;
        }
        throw new IllegalStateException("context not Activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final List<NameValuePair> list) {
        if (getContext() instanceof Activity) {
            a((Activity) getContext(), false, new IHwIDCallBack() { // from class: com.baidu.sapi2.SapiWebView.19
                public void onUserInfo(HashMap hashMap) {
                    try {
                        String str = (String) hashMap.get("accesstoken");
                        String str2 = (String) hashMap.get("userID");
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            if (SapiWebView.this.L == null) {
                                SapiWebView.this.L = new DefaultHuaweiHandler();
                            }
                            SapiWebView.this.L.handleHuaweiLoginFailure();
                            return;
                        }
                        SapiWebView.this.loadUrl(SapiWebView.this.a(SapiWebView.this.a(SocialType.HUAWEI, URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), (String) null), list));
                    } catch (UnsupportedEncodingException e2) {
                        Log.e(e2);
                    }
                }
            }, this.I.hwLoginChannelId);
            OpenHwID.login(new Bundle());
            if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.20
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 0).show();
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalStateException("context not Activity");
    }

    public void loadHuaWeiSSOLogin(String str, String str2, List<NameValuePair> list) {
        String str3 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("AccessToken or uid can't be null");
        }
        try {
            str3 = a(SocialType.HUAWEI, URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), (String) null);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        loadUrl(a(str3, list));
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 0).show();
                }
            });
        }
    }

    public void loadMeizuSSOLogin() {
        loadMeizuSSOLogin(null);
    }

    public void loadMeizuSSOLogin(final List<NameValuePair> list) {
        if (getContext() instanceof Activity) {
            new MzAuthenticator(this.I.mzAppID, this.I.meizuRedirectUri).requestImplictAuth((Activity) getContext(), "uc_basic_info", new ImplictCallback() { // from class: com.baidu.sapi2.SapiWebView.22
                public void onError(OAuthError oAuthError) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.N == null) {
                                SapiWebView.this.N = new DefaultMeizuHandler();
                            }
                            SapiWebView.this.N.handleMeizuLoginFailure();
                        }
                    });
                }

                public void onGetToken(OAuthToken oAuthToken) {
                    String str = null;
                    String accessToken = oAuthToken.getAccessToken();
                    String openId = oAuthToken.getOpenId();
                    if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId)) {
                        if (SapiWebView.this.N == null) {
                            SapiWebView.this.N = new DefaultMeizuHandler();
                        }
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.22.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.N.handleMeizuLoginFailure();
                            }
                        });
                        return;
                    }
                    try {
                        str = SapiWebView.this.a(SocialType.MEIZU, URLEncoder.encode(accessToken, "UTF-8"), URLEncoder.encode(openId, "UTF-8"), (String) null);
                    } catch (UnsupportedEncodingException e2) {
                        Log.e(e2);
                    }
                    SapiWebView.this.loadUrl(SapiWebView.this.a(str, list));
                }
            });
            if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
                Toast.makeText(getContext(), v, 0).show();
                return;
            }
            return;
        }
        throw new IllegalStateException("context not Activity");
    }

    public void loadSocialLogin(SocialType socialType) {
        loadSocialLogin(socialType, false);
    }

    public void loadSocialLogin(SocialType socialType, boolean z2) {
        loadSocialLogin(socialType, z2, null);
    }

    public void loadSocialLogin(SocialType socialType, boolean z2, List<NameValuePair> list) {
        if (socialType == null) {
            throw new IllegalArgumentException("SocialType can't be null");
        }
        if (socialType == SocialType.UNKNOWN) {
            throw new IllegalArgumentException("Unknown SocialType");
        }
        String b2 = b(socialType);
        if (z2) {
            b2 = b2 + "&is_force_login=1";
        }
        loadUrl(a(b2, list));
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 0).show();
                }
            });
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.af != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.af.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.af.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void d(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.24
            @Override // java.lang.Runnable
            public void run() {
                if (!SapiWebView.this.ai) {
                    SapiWebView.this.a(str, false);
                    SapiWebView.super.loadUrl(str);
                }
            }
        });
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            s();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PickPhotoResult {
        public void setImageData(String str) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SwitchAccountCallback {

        /* loaded from: classes.dex */
        public static class Result {
            public String userName;
        }

        public abstract void onAccountSwitch();

        public void onAccountSwitch(Result result) {
        }
    }

    /* loaded from: classes.dex */
    static class Command {
        private String a;
        private List<String> b = new ArrayList();
        private String c;

        Command() {
        }

        public String getActionName() {
            return this.a;
        }

        public List<String> getActionParams() {
            return this.b;
        }

        public String getCallbackName() {
            return this.c;
        }

        public static Command parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str.toString());
                Command command = new Command();
                JSONObject optJSONObject = jSONObject.optJSONObject("action");
                if (optJSONObject != null) {
                    command.a = optJSONObject.optString("name");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("params");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            command.b.add(optJSONArray.optString(i));
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("callback");
                if (optJSONObject2 != null) {
                    command.c = optJSONObject2.optString("name");
                }
                return command;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount b(SapiAccountResponse sapiAccountResponse) {
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
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance(this.I.context).put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra(BaiduRimConstants.TPL_INIT_KEY, this.I.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance(this.I.context).setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(getContext(), sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount b2 = b(sapiAccountResponse);
            SapiContext.getInstance(getContext()).addReloginCredentials(sapiAccountResponse.uid, sapiAccountResponse.reloginCredentials);
            if (this.ab.F != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.25
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SapiWebView.this.ab.F.beforeSuccess(b2);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        com.baidu.sapi2.share.a.a().a(b2);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(SapiWebView.this.getContext(), b2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SocialResponse socialResponse) {
        if (socialResponse != null) {
            final SapiAccount b2 = b(socialResponse);
            if (SapiUtils.isValidAccount(b2)) {
                socialResponse.errorCode = 0;
            }
            if (socialResponse.accountCenterFlag && (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000)) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.26
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.sapi2.share.a.a().a(b2);
                        if (SapiWebView.this.T != null && !session.uid.equals(b2.uid)) {
                            SapiWebView.this.T.onAccountChange();
                        }
                    }
                });
            } else if (this.ab.F != null) {
                if (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.27
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.ab.F != null) {
                                    SapiWebView.this.ab.F.beforeSuccess(b2);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            com.baidu.sapi2.share.a.a().a(b2);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.ab.M = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.28
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.ab.F != null) {
                                SapiWebView.this.ab.F.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                            }
                            SapiWebView.this.ab.M = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        SapiUtils.reportGid(this.ax ? 10002 : 10003);
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.SUCCESS);
        if (this.ab.F != null) {
            try {
                if (!AuthorizationListener.class.equals(this.ab.F.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.ab.F.onSuccess(accountType);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.SUCCESS, accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.ab.F.onSuccess();
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.SUCCESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class FastRegAction {
        private static final int b = 0;
        private static final int c = 1;
        private String d;
        private Handler g;
        private Runnable h;
        private Handler i;
        private Runnable l;
        private boolean e = true;
        private boolean f = false;
        private int j = 0;
        private Handler k = new Handler();

        public FastRegAction() {
            this.g = new Handler() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    FastRegAction.this.e = true;
                }
            };
            this.h = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.2
                @Override // java.lang.Runnable
                public void run() {
                    FastRegAction.this.g.sendMessage(new Message());
                }
            };
            this.i = new Handler() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.obj != null) {
                        String str = (String) message.obj;
                        String a = SapiWebView.this.a();
                        if (!TextUtils.isEmpty(a) && FastRegAction.this.j == 1) {
                            FastRegAction.this.a(a, str);
                        }
                        SapiWebView.this.u();
                        FastRegAction.this.k.removeCallbacks(FastRegAction.this.l);
                    }
                }
            };
            this.l = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.4
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.u();
                    FastRegAction.this.a(SapiWebView.this.a());
                }
            };
        }

        private String a() {
            return UUID.randomUUID().toString() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + System.currentTimeMillis() + ",点击发送直接登录";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                this.d = a();
            }
            if (!SapiUtils.isSimReady(SapiWebView.this.getContext())) {
                e();
            } else if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                if (SapiWebView.this.I.fastRegConfirm) {
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.w).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", SapiWebView.this.getContext()) ? SapiCoreUtil.sendSms(FastRegAction.this.d, SapiUtils.getFastRegChannel(SapiWebView.this.getContext())) : false) {
                                FastRegAction.this.g.postDelayed(FastRegAction.this.h, 15000L);
                                FastRegAction.this.e = false;
                                FastRegAction.this.d();
                                return;
                            }
                            FastRegAction.this.e();
                        }
                    }).setNegativeButton(SapiWebView.G, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SapiWebView.this.loadUrl(SapiWebView.this.l() + "&regLink=0" + SapiWebView.r);
                        }
                    }).create();
                    if (!TextUtils.isEmpty(SapiWebView.this.I.fastRegConfirmMsg)) {
                        create.setMessage(SapiWebView.this.I.fastRegConfirmMsg);
                    }
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                    return;
                }
                if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", SapiWebView.this.getContext()) ? SapiCoreUtil.sendSms(this.d, SapiUtils.getFastRegChannel(SapiWebView.this.getContext())) : false) {
                    this.g.postDelayed(this.h, 15000L);
                    this.e = false;
                    d();
                    return;
                }
                e();
            } else {
                e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.g.removeCallbacks(this.h);
            this.e = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.f) {
                c();
            } else if (this.e) {
                this.g.removeCallbacks(this.h);
                e();
            } else {
                SapiAccountManager.getInstance().getAccountService().a(new SapiCallBack<SapiAccountResponse>() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSuccess(SapiAccountResponse sapiAccountResponse) {
                        if (sapiAccountResponse.newReg) {
                            SapiWebView.this.a(sapiAccountResponse);
                        } else {
                            SapiWebView.this.c(sapiAccountResponse);
                        }
                        FastRegAction.this.c();
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onNetworkFailed() {
                        FastRegAction.this.e();
                        FastRegAction.this.c();
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSystemError(int i) {
                        switch (i) {
                            case 2:
                                SapiWebView.this.postDelayed(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        FastRegAction.this.d();
                                    }
                                }, 400L);
                                return;
                            default:
                                FastRegAction.this.e();
                                FastRegAction.this.c();
                                return;
                        }
                    }
                }, this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            String a = SapiWebView.this.a();
            if (!TextUtils.isEmpty(a)) {
                this.j = 1;
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new SapiCallBack<SapiResponse>() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.8
                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSuccess(SapiResponse sapiResponse) {
                        SapiWebView.this.a(FastRegAction.this.i);
                        FastRegAction.this.k.postDelayed(FastRegAction.this.l, 15000L);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onNetworkFailed() {
                        SapiWebView.this.loadUrl(SapiWebView.this.l() + "&regLink=0" + SapiWebView.r);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSystemError(int i) {
                        SapiWebView.this.loadUrl(SapiWebView.this.l() + "&regLink=0" + SapiWebView.r);
                    }
                }, a);
                return;
            }
            SapiWebView.this.loadUrl(SapiWebView.this.l() + "&regLink=0" + SapiWebView.r);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            SapiAccountManager.getInstance().getAccountService().a(new SapiCallBack<SapiAccountResponse>() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                public void onSuccess(SapiAccountResponse sapiAccountResponse) {
                    SapiAccountResponse sapiAccountResponse2 = new SapiAccountResponse();
                    sapiAccountResponse2.displayname = sapiAccountResponse.displayname;
                    sapiAccountResponse2.username = sapiAccountResponse.username;
                    sapiAccountResponse2.uid = sapiAccountResponse.uid;
                    sapiAccountResponse2.bduss = sapiAccountResponse.bduss;
                    sapiAccountResponse2.ptoken = sapiAccountResponse.ptoken;
                    sapiAccountResponse2.stoken = sapiAccountResponse.stoken;
                    sapiAccountResponse2.email = sapiAccountResponse.email;
                    sapiAccountResponse2.newReg = !TextUtils.isEmpty(sapiAccountResponse.authSid);
                    sapiAccountResponse2.authSid = sapiAccountResponse.authSid;
                    if (sapiAccountResponse2.newReg) {
                        SapiWebView.this.a(sapiAccountResponse2);
                        return;
                    }
                    SapiWebView.this.c(sapiAccountResponse2);
                    SapiWebView.this.finish();
                }

                @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                public void onNetworkFailed() {
                    FastRegAction.this.a(SapiWebView.this.a());
                }

                @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                public void onSystemError(int i) {
                    FastRegAction.this.a(SapiWebView.this.a());
                }
            }, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            SapiWebView.this.loadUrl(SapiWebView.this.l() + "&username=" + str + SapiWebView.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        String line1Number = SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext()) ? ((TelephonyManager) getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getLine1Number() : null;
        if (TextUtils.isEmpty(line1Number)) {
            return null;
        }
        return line1Number.replace("+86", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler) {
        if (this.am == null) {
            this.am = new SMSReceiver(handler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            getContext().registerReceiver(this.am, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.am != null) {
            try {
                getContext().unregisterReceiver(this.am);
            } catch (Throwable th) {
            }
        }
        this.am = null;
    }

    String a(String str, String str2) {
        String str3;
        String[] split = str2.split("#");
        if (split != null && split.length > 0) {
            SapiOptions sapiOptions = SapiContext.getInstance(getContext()).getSapiOptions();
            String c2 = SapiCache.c(str2);
            if (SapiCache.c(getContext(), c2) != null) {
                String str4 = SapiCache.c(getContext(), c2).hash;
                String md5 = MD5Util.toMd5(str.getBytes(), false);
                String version = sapiOptions.getCache().getVersion();
                if (!str4.equals(md5)) {
                    str3 = "&passAppHash=" + MD5Util.toMd5(str.getBytes(), false);
                } else {
                    str3 = (TextUtils.isEmpty(version) ? "" : "" + ETAG.ITEM_SEPARATOR + "passAppVersion=" + version) + "&passAppHash=" + SapiCache.c(getContext(), c2).hash;
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    String b() {
        return SapiUtils.buildBDUSSCookie(this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    void a(List<NameValuePair> list) {
        List<NameValuePair> c2 = c();
        if (list != null && !list.isEmpty()) {
            c2.addAll(list);
        }
        SapiUtils.syncCookies(getContext(), c2);
    }

    List<NameValuePair> c() {
        String diCookieInfo;
        List<String> loginCookieDiKeys = SapiContext.getInstance(getContext()).getSapiOptions().getLoginCookieDiKeys();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        String wap = this.I.environment.getWap(SapiUtils.getDefaultHttpsEnabled());
        if (diCookieInfo == null) {
            diCookieInfo = "";
        }
        arrayList.add(new BasicNameValuePair(wap, SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo)));
        return arrayList;
    }

    static String b(String str, String str2) {
        String str3 = "";
        Pattern compile = Pattern.compile(str);
        if (!TextUtils.isEmpty(str2)) {
            Matcher matcher = compile.matcher(str2);
            while (matcher.find()) {
                str3 = matcher.group();
            }
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.29
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.ag != null && SapiWebView.this.ag.isShowing()) {
                    try {
                        SapiWebView.this.ag.dismiss();
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (NullPointerException e2) {
        }
    }

    List<NameValuePair> d() {
        ArrayList arrayList = new ArrayList();
        if (this.I.supportFaceLogin && this.ab.h != null && this.ab.i != null) {
            arrayList.add(new BasicNameValuePair("liveAbility", "1"));
        }
        return arrayList;
    }

    String e() {
        return SapiAccountManager.getInstance().getAccountService().b() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String f() {
        return SapiAccountManager.getInstance().getAccountService().c() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String g() {
        return SapiAccountManager.getInstance().getAccountService().d() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(BindWidgetAction bindWidgetAction) {
        return SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String h() {
        return SapiAccountManager.getInstance().getAccountService().e() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String i() {
        return SapiAccountManager.getInstance().getAccountService().f() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(String str) {
        return SapiAccountManager.getInstance().getAccountService().a(str) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String j() {
        return SapiAccountManager.getInstance().getAccountService().g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String k() {
        return SapiAccountManager.getInstance().getAccountService().i() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String l() {
        return SapiAccountManager.getInstance().getAccountService().a();
    }

    String b(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().b(socialType) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(SocialType socialType, String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType, str, str2, str3) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().a(str, str2, str3) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(boolean z2, String str) {
        return SapiAccountManager.getInstance().getAccountService().a(z2, str) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String b(String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().b(str, str2, str3) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }

    String a(String str, String str2, boolean z2) {
        return SapiAccountManager.getInstance().getAccountService().a(str, str2, z2) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(d());
    }
}
