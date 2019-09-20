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
import android.widget.Toast;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.a.c;
import com.baidu.sapi2.a.e;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.RequestSMSCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.a.b;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
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
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
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
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    private static final String A = "立即设置时间";
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final String DEFAULT_WEIXIN_NOT_INSTALL_ERROR = "微信未安装";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    static final int a = 1;
    private static final String af = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String ag = "javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}else{window.history.go(-1)}}())";
    static final int b = 0;
    private static final String c = "prompt_on_cancel";
    private static final String d = "css/sapi_theme/style.css";
    private static final String e = "renren-offline";
    private static final String f = "__wp-action";
    private static final String g = "forget-pwd";
    private static final String h = "modify-pwd";
    private static final String i = "text/html";
    private static final String j = "UTF-8";
    private static final String k = "#login";
    private static final String l = "#canshareAi";
    private static final String m = "#authPwd";
    private static final String n = "#reg";
    private static final String o = "#canshare_accounts";
    private static final String p = "#sms_login";
    private static final String q = "#fastReg";
    private static final String r = "#oneKeyLogin";
    private static final String s = "#share_auth";
    public static StatLoadLogin statLoadLogin = null;
    private static final String t = "#face_login";
    private static final String u = "服务错误，请稍后重试";
    private static final String v = "系统时间错误";
    private static final String w = "证书安全警告";
    private static final String x = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String y = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    private static final String z = "取消";
    private SapiConfiguration B;
    private WeixinHandler C;
    private WebviewClientCallback D;
    private WebChromeClientCallback E;
    private FileChooserCallback F;
    private ChangePwdCallback G;
    private AccountChangeCallback H;
    private boolean I;
    private ReloadConfig J;
    private SapiJsInterpreters K;
    private SapiJsCallBacks.CallBacks L;
    private List<String> M;
    private View N;
    private View O;
    private View P;
    private ProgressBar Q;
    private ProgressDialog R;
    private Dialog S;
    private SapiCache T;
    private boolean U;
    private long V;
    private Handler W;
    private TimeoutTask aa;
    private BroadcastReceiver ab;
    private OnFinishCallback ac;
    private OnBackCallback ad;
    private OnNewBackCallback ae;
    private String ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    public List<PassNameValuePair> extras;
    public boolean shareV2Disable;
    public static final PassNameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new PassNameValuePair("smsfastlogin", "1");
    public static final PassNameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new PassNameValuePair("bindToSmsLogin", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new PassNameValuePair("overseas", "1");
    public static final PassNameValuePair EXTRA_SUPPORT_DIRECT_LOGIN = new PassNameValuePair("direct", "1");

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
            public int type;
            public String uid;
            public Map<String, String> transParamsMap = new HashMap();
            public List<PassNameValuePair> transParamsList = new ArrayList();

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
    public interface FileChooserCallback {
        void onFileChooser(ValueCallback<Uri> valueCallback);

        void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback);
    }

    /* loaded from: classes.dex */
    public interface InvokeScAppCallback {

        /* loaded from: classes.dex */
        public static abstract class InvokeScAppResult {
            public abstract void setInvokeResult(String str);
        }

        void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, InvokeScAppResult invokeScAppResult);
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

        void onPickImage(int i, int i2, int i3, PickPhotoResult pickPhotoResult);
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
        void onClick(String str, String str2, String str3, String str4);
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
                SapiWebView.this.W.sendMessage(message);
                SapiWebView.this.W.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.ac = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ad = onBackCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.ae = onNewBackCallback;
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.L.z = webviewPageFinishCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.J = new ReloadConfig();
        this.W = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.r();
                }
            }
        };
        this.aa = new TimeoutTask();
        this.aj = 1;
        n();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.J = new ReloadConfig();
        this.W = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.r();
                }
            }
        };
        this.aa = new TimeoutTask();
        this.aj = 1;
        n();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shareV2Disable = false;
        this.J = new ReloadConfig();
        this.W = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.r();
                }
            }
        };
        this.aa = new TimeoutTask();
        this.aj = 1;
        n();
    }

    public final void setNoNetworkView(View view) {
        if (this.O == null) {
            this.O = view;
            this.O.setVisibility(4);
            addView(this.O, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.P == null) {
            this.P = view;
            this.P.setVisibility(4);
            addView(this.P, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.Q == null) {
            this.Q = progressBar;
            if (this.Q != null) {
                addView(progressBar);
            }
        }
    }

    public void setWebviewLoadingView(View view) {
        if (this.N == null) {
            this.N = view;
            this.N.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void n() {
        this.L = new SapiJsCallBacks.CallBacks();
        this.K = new SapiJsInterpreters(this, this.L);
        this.V = DEFAULT_TIMEOUT_MILLIS;
        this.B = SapiAccountManager.getInstance().getSapiConfiguration();
        this.T = new SapiCache();
        this.I = new b().a();
        q();
        p();
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        setWebViewClient(new AnonymousClass2());
        setWebChromeClient(new WebChromeClient() { // from class: com.baidu.sapi2.SapiWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.3.1
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
                if (SapiWebView.this.E != null) {
                    SapiWebView.this.E.onConsoleMessage(str, i2, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.Q != null) {
                    if (i2 == 100) {
                        SapiWebView.this.Q.setVisibility(8);
                    } else {
                        if (SapiWebView.this.Q.getVisibility() == 8) {
                            SapiWebView.this.Q.setVisibility(0);
                        }
                        SapiWebView.this.Q.setProgress(i2);
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
                if (SapiWebView.this.F != null) {
                    SapiWebView.this.F.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.F != null) {
                    SapiWebView.this.F.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.F != null) {
                    SapiWebView.this.F.onFileChooser(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.F != null) {
                    SapiWebView.this.F.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.E != null && SapiWebView.this.E.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.E.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.e(Log.TAG, "webview", str2);
                final String[] strArr = {""};
                SapiWebView.this.L.K = jsPromptResult;
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if (SapiWebView.this.M.contains(actionName)) {
                                SapiWebView.this.L.K = jsPromptResult;
                            }
                            SapiJsInterpreters.AbstractInterpreter a2 = SapiWebView.this.K.a(actionName);
                            if (a2 != null) {
                                try {
                                    strArr[0] = a2.interpret(parse);
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
                                    } catch (JSONException e2) {
                                    }
                                }
                            }
                            if (parse.getActionParams().size() <= 2 || !SapiWebView.c.equals(parse.getActionParams().get(2))) {
                                if (!SapiWebView.this.M.contains(actionName)) {
                                    jsPromptResult.confirm(strArr[0]);
                                    return;
                                }
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
        });
        if (this.L.C == null) {
            this.L.C = new DefaultAuthorizationListener();
        }
        if (this.C == null) {
            this.C = new DefaultWeixinHandler();
        }
        this.L.b = new SmsHandler();
        this.L.J = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
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
                            return new WebResourceResponse("text/css", "utf-8", SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str));
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
                            return new WebResourceResponse("text/css", "utf-8", SapiCoreUtil.getCacheInputStream(SapiWebView.this.getContext(), str2));
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
                        return true;
                    } catch (Throwable th) {
                        Log.e(th);
                        return true;
                    }
                } else if (str.startsWith("wtloginmqq")) {
                    return true;
                } else {
                    if (SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL).equals(str)) {
                        SapiWebView.this.finish();
                    }
                    if (SapiWebView.this.L.T != null && SapiWebView.this.L.T.redirectUrl != null && str.contains(SapiWebView.this.L.T.redirectUrl)) {
                        SapiWebView.this.L.T.callback.onCallback(str);
                        return true;
                    }
                }
            }
            if (SapiWebView.this.D != null) {
                SapiWebView.this.D.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.L.D != null) {
                Uri parse = Uri.parse(SapiWebView.this.l());
                Uri parse2 = Uri.parse(str);
                if (parse2 == null || !(parse2.getHost() + parse2.getPath()).equals(parse.getHost() + parse.getPath())) {
                    SapiWebView.this.L.D.pageState(2);
                } else {
                    SapiWebView.this.L.D.pageState(1);
                }
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.s();
            }
            SapiWebView.this.aa.setUrl(str);
            SapiWebView.this.W.postDelayed(SapiWebView.this.aa, SapiWebView.this.V);
            SapiWebView.this.t();
            if (str != null) {
                if (str.contains(SapiWebView.g) || str.contains(SapiWebView.h)) {
                    String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.f);
                    if (SapiWebView.g.equals(queryParameter) && SapiWebView.this.G != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.G != null) {
                                    SapiWebView.this.G.onSuccess();
                                }
                            }
                        });
                    }
                    if (SapiWebView.h.equals(queryParameter) && SapiWebView.this.G != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.G != null) {
                                        SapiWebView.this.G.onSuccess();
                                        return;
                                    }
                                    return;
                                }
                                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.G != null) {
                                            SapiWebView.this.G.onSuccess();
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
                                        if (SapiWebView.this.G != null) {
                                            SapiWebView.this.G.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.G != null) {
                                            SapiWebView.this.G.onSuccess();
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onStart() {
                                        SapiWebView.this.showProgress();
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFinish() {
                                        SapiWebView.this.dismissProgress();
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.e.equals(Uri.parse(str).getQueryParameter(SapiWebView.f))) {
                    if (SapiWebView.this.L.O == null) {
                        if (SapiWebView.this.L.C != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.L.C != null) {
                                        SapiWebView.this.L.C.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                        }
                    } else {
                        SapiWebView.this.a(SapiWebView.this.L.O);
                    }
                }
            }
            if (SapiWebView.this.D != null) {
                SapiWebView.this.D.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
            if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                if (!(!SapiWebView.this.B.forbidSslErrorDialog)) {
                    if (SapiWebView.this.S == null) {
                        if (Build.VERSION.SDK_INT > 17) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SapiWebView.x);
                            Date date = new Date(System.currentTimeMillis());
                            str = SapiWebView.v;
                            str2 = simpleDateFormat.format(date);
                        } else {
                            str = SapiWebView.w;
                            str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                        builder.setTitle(str);
                        builder.setMessage(str2);
                        builder.setPositiveButton(SapiWebView.A, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                intent.setFlags(268435456);
                                SapiWebView.this.getContext().startActivity(intent);
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_setting", null);
                            }
                        });
                        builder.setNegativeButton(SapiWebView.z, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_cancel", null);
                            }
                        });
                        SapiWebView.this.S = builder.create();
                    }
                    if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.S.isShowing()) {
                        SapiWebView.this.S.show();
                    }
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
            if (SapiWebView.this.N != null) {
                SapiWebView.this.N.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.O != null && SapiWebView.this.O.getVisibility() != 4) {
                SapiWebView.this.O.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.af);
            if (SapiWebView.this.L.d != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().n());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().o());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().m());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(SapiEnv.ACCOUNT_CENTER_EDITUSER) || str.contains(SapiEnv.ACCOUNT_CENTER_ACCOUNT_BIND)) {
                SapiWebView.this.ah = Uri.parse(str).getQueryParameter("gotoUrl");
            } else if (!str.contains(SapiEnv.ACCOUNT_CENTER_MODIFY_PWD_RESULT)) {
                SapiWebView.this.ah = null;
            } else {
                SapiWebView.this.ah = Uri.parse(str).getQueryParameter("refer");
            }
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.ai = true;
            } else {
                SapiWebView.this.ai = false;
            }
            if ((str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) && !"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().j())) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '0', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.W.removeCallbacks(SapiWebView.this.aa);
            if (SapiWebView.this.D != null) {
                SapiWebView.this.D.onPageFinished(webView, str);
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

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.U = true;
        this.W.removeCallbacks(this.aa);
        u();
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().flush();
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.J.b) {
            loadWeixinSSOLogin(this.J.c, this.J.d, this.J.e);
        } else if (this.J.a != null) {
            loadUrl(this.J.a);
        } else {
            super.reload();
        }
        this.J.a();
    }

    /* loaded from: classes.dex */
    private class ReloadConfig {
        String a;
        boolean b;
        boolean c;
        String d;
        List<PassNameValuePair> e;

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
                removeCallbacks(SapiWebView.this.L.J);
            }
        }
    }

    public String getUaInfo() {
        String encode = URLEncoder.encode("Sapi_8.8.4_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + "_" + (!TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "") + "_Sapi");
        if (o() && !TextUtils.isEmpty(this.B.userAgent)) {
            return encode + " " + this.B.userAgent;
        }
        return encode;
    }

    private boolean o() {
        for (String str : SapiContext.getInstance(getContext()).getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    private void p() {
        this.M = new ArrayList();
        this.M.add("sapi_action_pick_image");
        this.M.add("sapi_action_pick_date");
        this.M.add("sapi_biometrics_identification");
        this.M.add("sapi_biometrics_identification_no_bduss");
        this.M.add("sapi_biometrics_identification_with_authtoken");
        this.M.add("sapi_biometrics_identification_with_uid");
        this.M.add("sapi_action_sc_app_invoke");
        this.M.add("oauth_sso_hash");
        this.M.add("sapi_action_china_mobile_oauth");
        this.M.add("sapi_action_upsms");
        this.M.add("address_manage_get_contact");
        this.M.add("touchid_open_guide");
        this.M.add("touchid_change_status");
        this.M.add("touchid_login");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void q() {
        WebSettings settings = getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            Log.e(e2);
        }
        settings.setUserAgentString(settings.getUserAgentString() + " " + getUaInfo());
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setDomStorageEnabled(true);
        setScrollBarStyle(0);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
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
        if ((this.O == null || this.O.getVisibility() != 0) && (this.P == null || this.P.getVisibility() != 0)) {
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if ((this.O != null && this.O.getVisibility() == 0) || (this.P != null && this.P.getVisibility() == 0)) {
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
        this.L.C = authorizationListener;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.C = weixinHandler;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.L.j = loadExternalWebViewCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.D = webviewClientCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.E = webChromeClientCallback;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.F = fileChooserCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.L.k = pickPhotoCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.G = changePwdCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.L.i = bindWidgetCallback;
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.L.g = uniteVerifyCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.L.o = realnameAuthenticateCallback;
    }

    public void setSystemUpwardSmsCallback(SystemUpwardSmsCallback systemUpwardSmsCallback) {
        this.L.v = systemUpwardSmsCallback;
    }

    public void setBuildCustomAlertDialog(SapiJsCallBacks.BuildCustomAlertDialog buildCustomAlertDialog) {
        this.L.E = buildCustomAlertDialog;
    }

    public void setAddressManageCallback(SapiJsCallBacks.AddressManageCallback addressManageCallback) {
        this.L.F = addressManageCallback;
    }

    public void setInvoiceBuildCallback(SapiJsCallBacks.InvoiceBuildCallback invoiceBuildCallback) {
        this.L.G = invoiceBuildCallback;
    }

    public void setSocialBindHandler(Handler handler) {
        this.L.c = handler;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.L.a = handler;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.L.d = webViewTitleCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.L.f = biometricsIdentifyCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.L.e = bioScanFaceCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.L.w = invokeScAppCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.L.p = coverWebBdussCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.L.m = switchAccountCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.L.q = preFillUserNameCallback;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.L.l = bdussChangeCallback;
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.H = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.L.r = accountDestoryCallback;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.L.n = leftBtnVisibleCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.L.t = shareAccountClickCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.L.P = joinLoginParams;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.L.R = directedLoginParams;
    }

    public void setHideSuccessTip(boolean z2) {
        this.L.S = z2;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.L.x = localConfigCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.L.D = pageStateCallback;
    }

    public void setFingerprintCallback(SapiJsCallBacks.FingerprintCallback fingerprintCallback) {
        this.L.H = fingerprintCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.L.s = accountFreezeCallback;
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        this.L.y = normalizeGuestAccountCallback;
        this.L.Q = str;
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.L.A = realNameStatusCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.L.B = loginStatusChangeCallback;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.L.T = bdOauthLoginParams;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.L.U = shareV2LoginParams;
    }

    public void loadLogin() {
        loadLogin(0, null);
    }

    public void loadLogin(int i2) {
        loadLogin(i2, null);
    }

    public void loadLogin(List<PassNameValuePair> list) {
        loadLogin(0, list);
    }

    public void loadLogin(int i2, List<PassNameValuePair> list) {
        boolean z2 = true;
        if (this.B.supportFaceLogin && this.L.f == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        if (statLoadLogin != null) {
            statLoadLogin.tBeforeLogin = System.currentTimeMillis();
        }
        this.extras = list;
        this.ak = true;
        if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
            b(i2, list);
        } else if (4 == i2) {
            c(list);
        } else {
            if (this.B.supportSpecialLogin) {
                String string = SapiContext.getInstance(this.B.context).getString(SapiContext.KEY_PRE_LOGIN_TYPE);
                if ("password".equals(string)) {
                    i2 = 0;
                } else if ("sms".equals(string)) {
                    i2 = 1;
                }
            }
            List<ShareStorage.StorageModel> a2 = com.baidu.sapi2.share.a.a().a(this.B.context);
            if (!com.baidu.sapi2.share.a.e() || !this.shareV2Disable) {
                z2 = false;
            }
            this.shareV2Disable = z2;
            if (this.L.t != null && a2 != null && a2.size() > 0 && !this.shareV2Disable) {
                list.add(new PassNameValuePair("share_version", "2"));
                c(i2, list);
            } else if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
                c(i2, list);
            } else if (this.I) {
                b(list);
            } else if (new c().b(getContext())) {
                a(i2, list);
            } else {
                b(i2, list);
            }
        }
        SapiStatUtil.statLoadLogin(null);
    }

    private void b(List<PassNameValuePair> list) {
        String a2 = a(l(), list);
        if (this.L.j != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        loadUrl((a2 + "&liveAbility=1") + t);
    }

    private void a(int i2, List<PassNameValuePair> list) {
        String str = a(l(), list) + "&loginInitType=" + i2;
        if (this.L.j != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.B.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + r);
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().a() + "&adapter=3") + s);
    }

    private void b(int i2, List<PassNameValuePair> list) {
        String str = a(l(), list) + "&loginInitType=" + i2;
        switch (i2) {
            case 0:
                if (this.L.j != null) {
                    str = str + "&enableExternalWeb=1";
                }
                if (this.B.supportFaceLogin) {
                    str = str + "&liveAbility=1";
                }
                loadUrl(str + k);
                return;
            case 1:
                if (this.L.j != null) {
                    str = str + "&enableExternalWeb=1";
                }
                if (this.B.supportFaceLogin) {
                    str = str + "&liveAbility=1";
                }
                loadUrl(str + p);
                return;
            default:
                loadUrl(str + k);
                return;
        }
    }

    private void c(List<PassNameValuePair> list) {
        String a2 = a(l(), list);
        if (this.L.j != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        if (this.B.supportFaceLogin) {
            a2 = a2 + "&liveAbility=1";
        }
        loadUrl(a2 + l);
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
            loadUrl(l() + "&" + str2 + m);
        } else {
            loadLogin();
        }
    }

    private void c(int i2, List<PassNameValuePair> list) {
        String str;
        String l2 = l();
        if (this.L.j != null) {
            l2 = l2 + "&enableExternalWeb=1";
        }
        if (this.B.supportFaceLogin) {
            l2 = l2 + "&liveAbility=1";
        }
        if (this.I && this.L.f != null) {
            str = l2 + "&loginInitType=4";
        } else if (new c().b(getContext())) {
            str = l2 + "&loginInitType=5";
        } else {
            str = l2 + "&loginInitType=" + i2;
        }
        loadUrl(a(str, list) + o);
    }

    public void loadRegist(List<PassNameValuePair> list) {
        loadUrl(a(l(), list) + n);
        this.ak = false;
    }

    private String a(String str, List<PassNameValuePair> list) {
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
            if (!arrayList.isEmpty()) {
                return str + "&" + SapiUtils.createRequestParams(arrayList);
            }
            return str;
        }
        return str;
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
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + f + "=" + h, "UTF-8")));
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new PassNameValuePair("skin", str2));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String f2 = f();
        if (arrayList.size() > 0) {
            f2 = f2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String b2 = b();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new PassNameValuePair(this.B.environment.getWap(), b2));
        loadUrl(f2, arrayList2);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z2) {
        this.L.u = qrLoginCallback;
        this.L.M = z2;
        loadUrl(str + "&suppcheck=1");
    }

    public void loadExternalUrl(String str) {
        loadExternalUrl(str, null);
    }

    public void loadExternalUrl(String str, List<PassNameValuePair> list) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("externalUrl can't be empty");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new PassNameValuePair("clientfrom", "native"));
        list.add(new PassNameValuePair("client", "android"));
        list.add(new PassNameValuePair("deliverParams", "1"));
        if (this.B.supportFaceLogin) {
            list.add(new PassNameValuePair("scanface", "1"));
        }
        if (this.L.k != null && this.B.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf + 1) + SapiUtils.createRequestParams(list) + "&" + str.substring(indexOf + 1, str.length());
        } else {
            str2 = str + "?" + SapiUtils.createRequestParams(list);
        }
        loadUrl(str2);
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + f + "=" + g, "UTF-8")));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String e3 = e();
        if (arrayList.size() > 0) {
            e3 = e3 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(e3);
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
            arrayList.add(new PassNameValuePair("skin", str2));
        }
        String g2 = g();
        if (arrayList.size() > 0) {
            g2 = g2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(g2);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str) {
        loadBindWidget(bindWidgetAction, str, null, true, null);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, List<PassNameValuePair> list) {
        loadBindWidget(bindWidgetAction, str, null, true, list);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, boolean z2) {
        loadBindWidget(bindWidgetAction, str, null, z2, null);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        a(getContext(), str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair("skin", str2));
        }
        if (z2) {
            arrayList.add(new PassNameValuePair(FreeSpaceBox.TYPE, "1"));
        }
        if (this.B.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("liveAbility", "1"));
        }
        String a2 = a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String a3 = a(a2, list);
        String b2 = b();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new PassNameValuePair(this.B.environment.getWap(), b2));
        loadUrl(a3, arrayList2);
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
            arrayList.add(new PassNameValuePair("skin", str2));
        }
        if (z2) {
            arrayList.add(new PassNameValuePair("simplify", "1"));
        }
        String j2 = j();
        if (arrayList.size() > 0) {
            j2 = j2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(j2);
    }

    public void loadRealnameAuthenticate(final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(this.B.realnameAuthenticateStoken)) {
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String k2 = SapiWebView.this.k();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair("bduss", str));
                arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                arrayList2.add(new PassNameValuePair("bdstoken", SapiWebView.this.B.realnameAuthenticateStoken));
                SapiWebView.this.loadUrl(k2 + "&" + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (SapiWebView.this.L.o != null) {
                    SapiWebView.this.L.o.onFailure();
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, str, arrayList);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
        }
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
        loadUrl(h() + "&" + SapiUtils.createRequestParams(arrayList));
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(a(a(socialType), list));
    }

    public void loadAccountCenter(String str) {
        loadAccountCenter(null, str);
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str) {
        loadAccountCenter(list, str, ACCOUNT_CENTER);
    }

    public void loadAccountCenter(List<PassNameValuePair> list, String str, String str2) {
        SapiAccountService.a(getContext(), str);
        String a2 = a(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.L.k != null && this.B.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.L.f != null && this.B.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(a(a2, list));
    }

    public void loadAddressManage(List<PassNameValuePair> list) {
        loadUrl(a(i(), list));
    }

    public void loadInvoiceBuild(List<PassNameValuePair> list) {
        loadUrl(a(m(), list));
    }

    public void loadAccountRealName(String str, String str2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new PassNameValuePair(FaceBaseDTO.KEY_BUSINESS_SCENE, str2));
        }
        arrayList.add(new PassNameValuePair("needcbkey", z2 ? "1" : "0"));
        loadAccountCenter(arrayList, str, ACCOUNT_CENTER_REAL_NAME);
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    public long getTimeoutMillis() {
        return this.V;
    }

    public void setTimeoutMillis(long j2) {
        this.V = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<PassNameValuePair> list) {
        c(str);
        String str2 = null;
        if (!TextUtils.isEmpty(str) && !str.contains("javascript:")) {
            a(list);
            str2 = this.T.a(getContext(), str);
        }
        if (!TextUtils.isEmpty(str2)) {
            String a2 = a(str2, str);
            loadDataWithBaseURL(a2, str2, i, "UTF-8", a2);
            return;
        }
        d(str);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                String str6;
                if (!SapiWebView.this.U) {
                    if (str.split("#").length > 0) {
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
        if (this.ah != null) {
            loadUrl(this.ah);
        } else if (this.ai && this.Q != null && this.Q.getVisibility() == 0) {
            finish();
        } else if (this.ai && this.N != null && this.N.getVisibility() == 0) {
            finish();
        } else if (this.ae == null || this.L.O != null) {
            super.loadUrl(ag);
            a(this.L.O);
        } else {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.ae.onBack();
        }
        if ((this.O != null && this.O.getVisibility() == 0) || (this.P != null && this.P.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        u();
        if (this.ac != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (SapiWebView.this.ac != null && !SapiWebView.this.U) {
                        SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                        SapiWebView.this.ac.onFinish();
                    }
                }
            });
        }
    }

    private void c(String str) {
        if (statLoadLogin != null) {
            if (str.contains(k) || str.contains(o) || str.contains(l) || str.contains(q) || str.contains(p) || (this.I && str.contains(t))) {
                statLoadLogin.tStartLogin = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2) {
        if (statLoadLogin != null) {
            if (str.contains(k) || str.contains(o) || str.contains(l) || str.contains(q) || str.contains(p) || (this.I && str.contains(t))) {
                statLoadLogin.tLoadLogin = System.currentTimeMillis();
                statLoadLogin.isLoadCache = z2;
            }
        }
    }

    public boolean onKeyUp(int i2) {
        if (i2 == 4 && this.aj == 1) {
            if (this.ad != null && this.L.O == null) {
                this.ad.onBack();
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
                                    } else if (name.equalsIgnoreCase("ptoken")) {
                                        sapiAccountResponse.ptoken = newPullParser.nextText();
                                        z3 = z2;
                                        continue;
                                    } else if (name.equalsIgnoreCase("stoken")) {
                                        if (z2) {
                                            String[] split = newPullParser.nextText().split("#");
                                            if (split != null && split.length > 1) {
                                                sapiAccountResponse.tplStokenMap.put(split[0], split[1]);
                                            }
                                            z3 = z2;
                                            continue;
                                        } else {
                                            sapiAccountResponse.stoken = newPullParser.nextText();
                                            z3 = z2;
                                            continue;
                                        }
                                    } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2576=4] */
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
                                    } else if (name.equalsIgnoreCase("ptoken")) {
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
                                    } else if (name.equalsIgnoreCase("stoken")) {
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
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(8);
                }
                if (SapiWebView.this.N != null) {
                    SapiWebView.this.N.setVisibility(8);
                }
                SapiWebView.this.J.a = SapiWebView.this.aa.b;
                if (SapiWebView.this.P != null) {
                    SapiWebView.this.P.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(8);
                }
                if (SapiWebView.this.N != null) {
                    SapiWebView.this.N.setVisibility(8);
                }
                if (SapiWebView.this.O != null) {
                    SapiWebView.this.O.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.O == null || this.O.getVisibility() != 0) {
            if (this.P == null || this.P.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.N != null) {
                            SapiWebView.this.N.setVisibility(0);
                            if (SapiWebView.this.Q != null) {
                                SapiWebView.this.Q.setVisibility(8);
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
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.u, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void onFinish() {
            if (SapiWebView.this.getContext() instanceof Activity) {
                ((Activity) SapiWebView.this.getContext()).finish();
            }
        }
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.B.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.B.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    public void loadSinaSSOLogin(List<PassNameValuePair> list, String str, String str2) {
        loadUrl(a(a(SocialType.SINA_WEIBO_SSO, str, str2, this.B.sinaAppId), list));
    }

    @TargetApi(9)
    public void loadWeixinSSOLogin(final boolean z2, final String str, final List<PassNameValuePair> list) {
        if (this.C == null) {
            this.C = new DefaultWeixinHandler();
        }
        new e().a(getContext(), this.B, this.O, this.C, a(a(z2, str), list), getUaInfo(), new e.a() { // from class: com.baidu.sapi2.SapiWebView.12
            @Override // com.baidu.sapi2.a.e.a
            public void onStart() {
                SapiWebView.this.showProgress();
            }

            @Override // com.baidu.sapi2.a.e.a
            public void onFinish() {
                SapiWebView.this.dismissProgress();
            }

            @Override // com.baidu.sapi2.a.e.a
            public void onFailure() {
                SapiWebView.this.J.b = true;
                SapiWebView.this.J.c = z2;
                SapiWebView.this.J.d = str;
                SapiWebView.this.J.e = list;
                SapiWebView.this.O.setVisibility(0);
            }
        });
    }

    public void loadWeixinSSOLogin(List<PassNameValuePair> list) {
        loadWeixinSSOLogin(false, null, list);
    }

    public void loadQQSSOLogin(List<PassNameValuePair> list, String str, String str2, String str3) {
        loadUrl(a(a(str, str2, str3), list));
    }

    public void loadXiaomiSSOLogin(List<PassNameValuePair> list, String str, String str2, String str3) {
        loadUrl(a(b(str, str2, str3), list));
    }

    public void weixinSSOLogin(String str, String str2, boolean z2) {
        weixinSSOLogin(str, str2, z2, null);
    }

    public void weixinSSOLogin(String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        String a2 = a(a(str, str2, z2), list);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair(this.B.environment.getURL(), "mkey=" + str2 + ";domain=." + this.B.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/;httponly"));
        loadUrl(a2, arrayList);
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        String str2 = null;
        try {
            str2 = SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, "UTF-8"), "");
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(a(str2, list));
    }

    public void loadMeizuSSOLogin(List<PassNameValuePair> list, String str, String str2) {
        String str3 = null;
        try {
            str3 = a(SocialType.MEIZU, URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), null);
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(a(str3, list));
    }

    public void loadSocialLogin(SocialType socialType) {
        loadSocialLogin(socialType, false);
    }

    public void loadSocialLogin(SocialType socialType, boolean z2) {
        loadSocialLogin(socialType, z2, null);
    }

    public void loadSocialLogin(SocialType socialType, boolean z2, List<PassNameValuePair> list) {
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
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.Q != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.Q.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.Q.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void d(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.13
            @Override // java.lang.Runnable
            public void run() {
                if (!SapiWebView.this.U) {
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

        Command() {
        }

        public String getActionName() {
            return this.a;
        }

        public List<String> getActionParams() {
            return this.b;
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
                return command;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount a(SapiAccountResponse sapiAccountResponse) {
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
            SapiContext.getInstance(this.B.context).put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.B.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance(this.B.context).setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new b().a(getContext(), sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount a2 = a(sapiAccountResponse);
            if (this.L.C != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SapiWebView.this.L.C.beforeSuccess(a2);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        com.baidu.sapi2.share.a.a().a(a2);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(SapiWebView.this.getContext(), a2, SapiWebView.this.extras);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SocialResponse socialResponse) {
        if (socialResponse != null) {
            final SapiAccount a2 = a((SapiAccountResponse) socialResponse);
            if (SapiUtils.isValidAccount(a2)) {
                socialResponse.errorCode = 0;
            }
            if (socialResponse.accountCenterFlag && (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000)) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.sapi2.share.a.a().a(a2);
                        if (SapiWebView.this.H != null && !session.uid.equals(a2.uid)) {
                            SapiWebView.this.H.onAccountChange();
                        }
                    }
                });
            } else if (this.L.C != null) {
                if (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.L.C != null) {
                                    SapiWebView.this.L.C.beforeSuccess(a2);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            com.baidu.sapi2.share.a.a().a(a2);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.L.O = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.17
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.L.C != null) {
                                SapiWebView.this.L.C.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                            }
                            SapiWebView.this.L.O = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (!TextUtils.isEmpty(this.L.I[0])) {
            SapiAccount currentAccount = SapiContext.getInstance(this.B.context).getCurrentAccount();
            currentAccount.phone = this.L.I[0];
            currentAccount.email = this.L.I[1];
            SapiContext.getInstance(this.B.context).addTouchidAccounts(currentAccount);
        }
        SapiUtils.reportGid(this.ak ? 10002 : 10003);
        if (this.L.C != null) {
            try {
                if (!AuthorizationListener.class.equals(this.L.C.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.L.C.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.L.C.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        String line1Number = SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext()) ? ((TelephonyManager) getContext().getSystemService("phone")).getLine1Number() : null;
        if (TextUtils.isEmpty(line1Number)) {
            return null;
        }
        return line1Number.replace("+86", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler) {
        if (this.ab == null) {
            SapiCoreUtil.registerReceiver(getContext(), handler, new RequestSMSCallback() { // from class: com.baidu.sapi2.SapiWebView.18
                @Override // com.baidu.sapi2.callback.RequestSMSCallback
                public void receiverResult(BroadcastReceiver broadcastReceiver) {
                    SapiWebView.this.ab = broadcastReceiver;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.ab != null) {
            try {
                getContext().unregisterReceiver(this.ab);
            } catch (Throwable th) {
            }
        }
        this.ab = null;
    }

    String a(String str, String str2) {
        String[] split;
        String str3;
        if (str2.split("#").length > 1) {
            SapiOptions sapiOptions = SapiContext.getInstance(getContext()).getSapiOptions();
            String c2 = this.T.c(str2);
            if (this.T.c(getContext(), c2) != null) {
                String str4 = this.T.c(getContext(), c2).hash;
                String md5 = MD5Util.toMd5(str.getBytes(), false);
                String version = sapiOptions.getCache().getVersion();
                if (!str4.equals(md5)) {
                    str3 = "&passAppHash=" + MD5Util.toMd5(str.getBytes(), false);
                } else {
                    str3 = (TextUtils.isEmpty(version) ? "" : "&passAppVersion=" + version) + "&passAppHash=" + this.T.c(getContext(), c2).hash;
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    String b() {
        return SapiUtils.buildBDUSSCookie(this.B.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    void a(List<PassNameValuePair> list) {
        List<PassNameValuePair> c2 = c();
        if (list != null && !list.isEmpty()) {
            c2.addAll(list);
        }
        SapiUtils.syncCookies(getContext(), c2);
    }

    List<PassNameValuePair> c() {
        String diCookieInfo;
        List<String> loginCookieDiKeys = SapiContext.getInstance(getContext()).getSapiOptions().getLoginCookieDiKeys();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.B.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        String wap = this.B.environment.getWap();
        if (diCookieInfo == null) {
            diCookieInfo = "";
        }
        arrayList.add(new PassNameValuePair(wap, SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo)));
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

    public void showProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SapiWebView.this.R = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void dismissProgress() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.20
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.R != null && SapiWebView.this.R.isShowing()) {
                    try {
                        SapiWebView.this.R.dismiss();
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

    List<PassNameValuePair> d() {
        ArrayList arrayList = new ArrayList();
        if (this.B.supportFaceLogin && this.L.e != null && this.L.f != null) {
            arrayList.add(new PassNameValuePair("liveAbility", "1"));
        }
        return arrayList;
    }

    String e() {
        return SapiAccountManager.getInstance().getAccountService().c() + "&" + SapiUtils.createRequestParams(d());
    }

    String f() {
        return SapiAccountManager.getInstance().getAccountService().d() + "&" + SapiUtils.createRequestParams(d());
    }

    String g() {
        return SapiAccountManager.getInstance().getAccountService().e() + "&" + SapiUtils.createRequestParams(d());
    }

    String a(BindWidgetAction bindWidgetAction) {
        return SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction) + "&" + SapiUtils.createRequestParams(d());
    }

    String h() {
        return SapiAccountManager.getInstance().getAccountService().f() + "&" + SapiUtils.createRequestParams(d());
    }

    String a(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType) + "&" + SapiUtils.createRequestParams(d());
    }

    String i() {
        return SapiAccountManager.getInstance().getAccountService().g() + "&" + SapiUtils.createRequestParams(d());
    }

    String a(String str) {
        return SapiAccountManager.getInstance().getAccountService().a(str) + "&" + SapiUtils.createRequestParams(d());
    }

    String j() {
        return SapiAccountManager.getInstance().getAccountService().i() + "&" + SapiUtils.createRequestParams(d());
    }

    String k() {
        return SapiAccountManager.getInstance().getAccountService().k() + "&" + SapiUtils.createRequestParams(d());
    }

    String l() {
        return SapiAccountManager.getInstance().getAccountService().b();
    }

    String b(SocialType socialType) {
        return SapiAccountManager.getInstance().getAccountService().b(socialType) + "&" + SapiUtils.createRequestParams(d());
    }

    String a(SocialType socialType, String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().a(socialType, str, str2, str3) + "&" + SapiUtils.createRequestParams(d());
    }

    String a(String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().a(str, str2, str3) + "&" + SapiUtils.createRequestParams(d());
    }

    String a(boolean z2, String str) {
        return SapiAccountManager.getInstance().getAccountService().a(z2, str) + "&" + SapiUtils.createRequestParams(d());
    }

    String b(String str, String str2, String str3) {
        return SapiAccountManager.getInstance().getAccountService().b(str, str2, str3) + "&" + SapiUtils.createRequestParams(d());
    }

    String a(String str, String str2, boolean z2) {
        return SapiAccountManager.getInstance().getAccountService().a(str, str2, z2) + "&" + SapiUtils.createRequestParams(d());
    }

    String m() {
        return SapiAccountManager.getInstance().getAccountService().h() + "&" + SapiUtils.createRequestParams(d());
    }
}
