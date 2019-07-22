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
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiJsInterpreters;
import com.baidu.sapi2.a.c;
import com.baidu.sapi2.a.e;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.callback.SapiCallBack;
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
import com.xiaomi.mipush.sdk.Constants;
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
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    private static final String A = "取消";
    public static final String ACCOUNT_CENTER = "account_center";
    public static final String ACCOUNT_CENTER_CHECK = "account_check";
    public static final String ACCOUNT_CENTER_REAL_NAME = "account_realname";
    private static final String B = "立即设置时间";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    public static final String DEFAULT_WEIXIN_NOT_INSTALL_ERROR = "微信未安装";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    static final int a = 1;
    private static final String ag = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String ah = "function(){if(window.Pass&&Pass.client&&Pass.client.pageGoBack){Pass.client.pageGoBack()}else{history.go(-1)}}()";
    static final int b = 0;
    private static final String c = "prompt_on_cancel";
    private static final String d = "css/sapi_theme/style.css";
    private static final String e = "__wp-action";
    private static final String f = "forget-pwd";
    private static final String g = "modify-pwd";
    private static final String h = "text/html";
    private static final String i = "UTF-8";
    private static final String j = "#login";
    private static final String k = "#canshareAi";
    private static final String l = "#authPwd";
    private static final String m = "#reg";
    private static final String n = "#canshare_accounts";
    private static final String o = "#sms_login";
    private static final String p = "#fastReg";
    private static final String q = "#fastRegSuccess";
    private static final String r = "#fastRegVerify";
    private static final String s = "#oneKeyLogin";
    public static StatLoadLogin statLoadLogin = null;
    private static final String t = "#share_auth";
    private static final String u = "发送一条短信，即可完成注册。";
    private static final String v = "服务错误，请稍后重试";
    private static final String w = "系统时间错误";
    private static final String x = "证书安全警告";
    private static final String y = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String z = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    private SapiConfiguration C;
    private WeixinHandler D;
    private WebviewClientCallback E;
    private WebChromeClientCallback F;
    private FileChooserCallback G;
    private ChangePwdCallback H;
    private AccountChangeCallback I;
    private String J;
    private ReloadConfig K;
    private SapiJsInterpreters L;
    private SapiJsCallBacks.CallBacks M;
    private List<String> N;
    private View O;
    private View P;
    private View Q;
    private ProgressBar R;
    private ProgressDialog S;
    private Dialog T;
    private SapiCache U;
    private boolean V;
    private long W;
    private Handler aa;
    private TimeoutTask ab;
    private BroadcastReceiver ac;
    private OnFinishCallback ad;
    private OnBackCallback ae;
    private OnNewBackCallback af;
    private String ai;
    private boolean aj;
    private int ak;
    private boolean al;
    private boolean am;
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
    public interface FastRegHandler {
        void handleFastReg();
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
                SapiWebView.this.aa.sendMessage(message);
                SapiWebView.this.aa.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.ad = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ae = onBackCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.af = onNewBackCallback;
    }

    public void setWebviewPageFinishCallback(SapiJsCallBacks.WebviewPageFinishCallback webviewPageFinishCallback) {
        this.M.A = webviewPageFinishCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.shareV2Disable = false;
        this.K = new ReloadConfig();
        this.aa = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.q();
                }
            }
        };
        this.ab = new TimeoutTask();
        this.ak = 1;
        this.al = false;
        l();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareV2Disable = false;
        this.K = new ReloadConfig();
        this.aa = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.q();
                }
            }
        };
        this.ab = new TimeoutTask();
        this.ak = 1;
        this.al = false;
        l();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.shareV2Disable = false;
        this.K = new ReloadConfig();
        this.aa = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.q();
                }
            }
        };
        this.ab = new TimeoutTask();
        this.ak = 1;
        this.al = false;
        l();
    }

    public final void setNoNetworkView(View view) {
        if (this.P == null) {
            this.P = view;
            this.P.setVisibility(4);
            addView(this.P, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.Q == null) {
            this.Q = view;
            this.Q.setVisibility(4);
            addView(this.Q, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.R == null) {
            this.R = progressBar;
            if (this.R != null) {
                addView(progressBar);
            }
        }
    }

    public void setWebviewLoadingView(View view) {
        if (this.O == null) {
            this.O = view;
            this.O.setVisibility(4);
            addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void l() {
        this.M = new SapiJsCallBacks.CallBacks();
        this.L = new SapiJsInterpreters(this, this.M);
        this.W = DEFAULT_TIMEOUT_MILLIS;
        this.C = SapiAccountManager.getInstance().getSapiConfiguration();
        this.U = new SapiCache();
        o();
        n();
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
                if (SapiWebView.this.F != null) {
                    SapiWebView.this.F.onConsoleMessage(str, i2, str2);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.R != null) {
                    if (i2 == 100) {
                        SapiWebView.this.R.setVisibility(8);
                    } else {
                        if (SapiWebView.this.R.getVisibility() == 8) {
                            SapiWebView.this.R.setVisibility(0);
                        }
                        SapiWebView.this.R.setProgress(i2);
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
                if (SapiWebView.this.G != null) {
                    SapiWebView.this.G.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.G != null) {
                    SapiWebView.this.G.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.G != null) {
                    SapiWebView.this.G.onFileChooser(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.G != null) {
                    SapiWebView.this.G.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                if (SapiWebView.this.F != null && SapiWebView.this.F.isSubClassHandleMessage(str2)) {
                    return SapiWebView.this.F.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                Log.e(Log.TAG, "webview", str2);
                final String[] strArr = {""};
                SapiWebView.this.M.G = jsPromptResult;
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if (SapiWebView.this.N.contains(actionName)) {
                                SapiWebView.this.M.G = jsPromptResult;
                            }
                            SapiJsInterpreters.AbstractInterpreter a2 = SapiWebView.this.L.a(actionName);
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
                                if (!SapiWebView.this.N.contains(actionName)) {
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
        if (this.M.D == null) {
            this.M.D = new DefaultAuthorizationListener();
        }
        if (this.D == null) {
            this.D = new DefaultWeixinHandler();
        }
        this.M.c = new SmsHandler();
        this.M.F = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.t();
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
                    if (SapiWebView.this.M.S != null && SapiWebView.this.M.S.redirectUrl != null && str.contains(SapiWebView.this.M.S.redirectUrl)) {
                        SapiWebView.this.M.S.callback.onCallback(str);
                        return true;
                    }
                }
            }
            if (SapiWebView.this.E != null) {
                SapiWebView.this.E.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (SapiWebView.this.M.E != null) {
                Uri parse = Uri.parse(SapiWebView.this.k());
                Uri parse2 = Uri.parse(str);
                if (parse2 == null || !(parse2.getHost() + parse2.getPath()).equals(parse.getHost() + parse.getPath())) {
                    SapiWebView.this.M.E.pageState(2);
                } else {
                    SapiWebView.this.M.E.pageState(1);
                }
            }
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !TextUtils.isEmpty(str) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.r();
            }
            SapiWebView.this.ab.setUrl(str);
            SapiWebView.this.aa.postDelayed(SapiWebView.this.ab, SapiWebView.this.W);
            SapiWebView.this.s();
            if (str != null && (str.contains(SapiWebView.f) || str.contains(SapiWebView.g))) {
                String queryParameter = Uri.parse(str).getQueryParameter(SapiWebView.e);
                if (SapiWebView.f.equals(queryParameter) && SapiWebView.this.H != null) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SapiWebView.this.stopLoading();
                            if (SapiWebView.this.H != null) {
                                SapiWebView.this.H.onSuccess();
                            }
                        }
                    });
                }
                if (SapiWebView.g.equals(queryParameter) && SapiWebView.this.H != null) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SapiWebView.this.stopLoading();
                            final String cookieBduss = SapiUtils.getCookieBduss();
                            final String cookiePtoken = SapiUtils.getCookiePtoken();
                            if (TextUtils.isEmpty(cookieBduss)) {
                                if (SapiWebView.this.H != null) {
                                    SapiWebView.this.H.onSuccess();
                                    return;
                                }
                                return;
                            }
                            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.2.1
                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.sapi2.callback.LoginStatusAware
                                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                    if (SapiWebView.this.H != null) {
                                        SapiWebView.this.H.onSuccess();
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
                                    if (SapiWebView.this.H != null) {
                                        SapiWebView.this.H.onSuccess();
                                    }
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // com.baidu.sapi2.callback.SapiCallback
                                public void onFailure(GetUserInfoResult getUserInfoResult) {
                                    if (SapiWebView.this.H != null) {
                                        SapiWebView.this.H.onSuccess();
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
            if (SapiWebView.this.E != null) {
                SapiWebView.this.E.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""));
            if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                if (!(!SapiWebView.this.C.forbidSslErrorDialog)) {
                    if (SapiWebView.this.T == null) {
                        if (Build.VERSION.SDK_INT > 17) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SapiWebView.y);
                            Date date = new Date(System.currentTimeMillis());
                            str = SapiWebView.w;
                            str2 = simpleDateFormat.format(date);
                        } else {
                            str = SapiWebView.x;
                            str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                        builder.setTitle(str);
                        builder.setMessage(str2);
                        builder.setPositiveButton(SapiWebView.B, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.settings.DATE_SETTINGS");
                                intent.setFlags(268435456);
                                SapiWebView.this.getContext().startActivity(intent);
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_setting", null);
                            }
                        });
                        builder.setNegativeButton(SapiWebView.A, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.4
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                StatService.onEvent("sslerr_date_cancel", null);
                            }
                        });
                        SapiWebView.this.T = builder.create();
                    }
                    if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.T.isShowing()) {
                        SapiWebView.this.T.show();
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
            if (SapiWebView.this.O != null) {
                SapiWebView.this.O.setVisibility(8);
            }
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.P != null && SapiWebView.this.P.getVisibility() != 4) {
                SapiWebView.this.P.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.ag);
            if (SapiWebView.this.M.e != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().l());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().m());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(SapiWebView.ACCOUNT_CENTER));
            if (str.contains(SapiEnv.ACCOUNT_CENTER_EDITUSER) || str.contains(SapiEnv.ACCOUNT_CENTER_ACCOUNT_BIND)) {
                SapiWebView.this.ai = Uri.parse(str).getQueryParameter("gotoUrl");
            } else if (!str.contains(SapiEnv.ACCOUNT_CENTER_MODIFY_PWD_RESULT)) {
                SapiWebView.this.ai = null;
            } else {
                SapiWebView.this.ai = Uri.parse(str).getQueryParameter("refer");
            }
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.aj = true;
            } else {
                SapiWebView.this.aj = false;
            }
            if ((str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) && !"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().h())) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '0', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.aa.removeCallbacks(SapiWebView.this.ab);
            if (SapiWebView.this.E != null) {
                SapiWebView.this.E.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i == -8 || i == -6 || i == -2 || i == -5) {
                SapiWebView.this.q();
            }
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.V = true;
        this.aa.removeCallbacks(this.ab);
        t();
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.K.b) {
            loadWeixinSSOLogin(this.K.c, this.K.d, this.K.e);
        } else if (this.K.a != null) {
            loadUrl(this.K.a);
        } else {
            super.reload();
        }
        this.K.a();
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
                SapiWebView.this.t();
                removeCallbacks(SapiWebView.this.M.F);
            }
        }
    }

    public String getUaInfo() {
        String encode = URLEncoder.encode("Sapi_8.7.17_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + "_" + (!TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "") + "_Sapi");
        if (m() && !TextUtils.isEmpty(this.C.userAgent)) {
            return encode + " " + this.C.userAgent;
        }
        return encode;
    }

    private boolean m() {
        for (String str : SapiContext.getInstance(getContext()).getAuthorizedPackagesForUA()) {
            if (getContext().getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }

    private void n() {
        this.N = new ArrayList();
        this.N.add("sapi_action_pick_image");
        this.N.add("sapi_action_pick_date");
        this.N.add("sapi_biometrics_identification");
        this.N.add("sapi_biometrics_identification_no_bduss");
        this.N.add("sapi_biometrics_identification_with_authtoken");
        this.N.add("sapi_biometrics_identification_with_uid");
        this.N.add("sapi_action_sc_app_invoke");
        this.N.add("oauth_sso_hash");
        this.N.add("sapi_action_china_mobile_oauth");
        this.N.add("sapi_action_upsms");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(7)
    private void o() {
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
        if ((this.P == null || this.P.getVisibility() != 0) && (this.Q == null || this.Q.getVisibility() != 0)) {
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if ((this.P != null && this.P.getVisibility() == 0) || (this.Q != null && this.Q.getVisibility() == 0)) {
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
        this.M.D = authorizationListener;
    }

    public void setFastRegHandler(FastRegHandler fastRegHandler) {
        this.M.b = fastRegHandler;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.D = weixinHandler;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.M.k = loadExternalWebViewCallback;
    }

    public void setWebviewClientCallback(WebviewClientCallback webviewClientCallback) {
        this.E = webviewClientCallback;
    }

    public void setWebChromeClientCallback(WebChromeClientCallback webChromeClientCallback) {
        this.F = webChromeClientCallback;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.G = fileChooserCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.M.l = pickPhotoCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.H = changePwdCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.M.j = bindWidgetCallback;
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.M.h = uniteVerifyCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.M.p = realnameAuthenticateCallback;
    }

    public void setSystemUpwardSmsCallback(SystemUpwardSmsCallback systemUpwardSmsCallback) {
        this.M.w = systemUpwardSmsCallback;
    }

    public void setSocialBindHandler(Handler handler) {
        this.M.d = handler;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.M.a = handler;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.M.e = webViewTitleCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.M.g = biometricsIdentifyCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.M.f = bioScanFaceCallback;
    }

    public void setInvokeScAppCallback(InvokeScAppCallback invokeScAppCallback) {
        this.M.x = invokeScAppCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.M.q = coverWebBdussCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.M.n = switchAccountCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.M.r = preFillUserNameCallback;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.M.m = bdussChangeCallback;
    }

    public void setAccountChangeCallback(AccountChangeCallback accountChangeCallback) {
        this.I = accountChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.M.s = accountDestoryCallback;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.M.o = leftBtnVisibleCallback;
    }

    public void setShareAccountClickCallback(ShareAccountClickCallback shareAccountClickCallback) {
        this.M.u = shareAccountClickCallback;
    }

    public void setJoinLoingParams(SapiJsCallBacks.JoinLoginParams joinLoginParams) {
        this.M.O = joinLoginParams;
    }

    public void setDirectedLoginParams(SapiJsCallBacks.DirectedLoginParams directedLoginParams) {
        this.M.Q = directedLoginParams;
    }

    public void setHideSuccessTip(boolean z2) {
        this.M.R = z2;
    }

    public void setLocalConfigCallback(LocalConfigCallback localConfigCallback) {
        this.M.y = localConfigCallback;
    }

    public void setPageStateCallback(SapiJsCallBacks.PageStateCallback pageStateCallback) {
        this.M.E = pageStateCallback;
    }

    public void setAccountFreezeCallback(AccountFreezeCallback accountFreezeCallback) {
        this.M.t = accountFreezeCallback;
    }

    public void setNormalizeGuestAccountCallback(SapiJsCallBacks.NormalizeGuestAccountCallback normalizeGuestAccountCallback, String str) {
        this.M.z = normalizeGuestAccountCallback;
        this.M.P = str;
    }

    public void setRealNameStateCallback(SapiJsCallBacks.RealNameStatusCallback realNameStatusCallback) {
        this.M.B = realNameStatusCallback;
    }

    public void setLoginStatusChangeCallback(SapiJsCallBacks.LoginStatusChangeCallback loginStatusChangeCallback) {
        this.M.C = loginStatusChangeCallback;
    }

    public void setBdOauthLoginParams(SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams) {
        this.M.S = bdOauthLoginParams;
    }

    public void setShareV2LoginParams(SapiJsCallBacks.ShareV2LoginParams shareV2LoginParams) {
        this.M.T = shareV2LoginParams;
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
        if (this.C.supportFaceLogin && this.M.g == null) {
            throw new RuntimeException("face login is support, the biometricsIdentifyCallback can't be null");
        }
        if (statLoadLogin != null) {
            statLoadLogin.tBeforeLogin = System.currentTimeMillis();
        }
        this.extras = list;
        this.am = true;
        if (list.contains(EXTRA_SUPPORT_DIRECT_LOGIN)) {
            b(i2, list);
        } else if (4 == i2) {
            b(list);
        } else {
            if (this.C.supportSpecialLogin) {
                String string = SapiContext.getInstance(this.C.context).getString(SapiContext.KEY_PRE_LOGIN_TYPE);
                if ("password".equals(string)) {
                    i2 = 0;
                } else if ("sms".equals(string)) {
                    i2 = 1;
                }
            }
            List<ShareStorage.StorageModel> a2 = com.baidu.sapi2.share.a.a().a(this.C.context);
            if (!com.baidu.sapi2.share.a.e() || !this.shareV2Disable) {
                z2 = false;
            }
            this.shareV2Disable = z2;
            if (this.M.u != null && a2 != null && a2.size() > 0 && !this.shareV2Disable) {
                list.add(new PassNameValuePair("share_version", "2"));
                c(i2, list);
            } else if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
                c(i2, list);
            } else {
                this.J = p();
                if (!TextUtils.isEmpty(this.J) && this.C.supportFaceLogin) {
                    a(this.J, list);
                } else if (new c().b(getContext())) {
                    a(i2, list);
                } else {
                    b(i2, list);
                }
            }
        }
        SapiStatUtil.statLoadLogin(null);
    }

    private void a(String str, List<PassNameValuePair> list) {
        String b2 = b(k(), list);
        if (this.M.k != null) {
            b2 = b2 + "&enableExternalWeb=1";
        }
        if (this.C.supportFaceLogin) {
            b2 = b2 + "&liveAbility=1";
        }
        loadUrl(b2 + "#" + str);
    }

    private void a(int i2, List<PassNameValuePair> list) {
        String str = b(k(), list) + "&loginInitType=" + i2;
        if (this.M.k != null) {
            str = str + "&enableExternalWeb=1";
        }
        if (this.C.supportFaceLogin) {
            str = str + "&liveAbility=1";
        }
        loadUrl(str + s);
    }

    public void loadShareV2Login() {
        loadUrl((SapiAccountManager.getInstance().getAccountService().a() + "&adapter=3") + t);
    }

    private void b(int i2, List<PassNameValuePair> list) {
        this.J = p();
        String str = b(k(), list) + "&loginInitType=" + i2;
        switch (i2) {
            case 0:
                if (this.M.k != null) {
                    str = str + "&enableExternalWeb=1";
                }
                if (this.C.supportFaceLogin) {
                    str = str + "&liveAbility=1";
                }
                loadUrl(str + j);
                return;
            case 1:
                if (this.M.k != null) {
                    str = str + "&enableExternalWeb=1";
                }
                if (this.C.supportFaceLogin) {
                    str = str + "&liveAbility=1";
                }
                loadUrl(str + o);
                return;
            case 2:
                this.am = false;
                if (this.M.b != null) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.M.b != null) {
                                SapiWebView.this.M.b.handleFastReg();
                            }
                        }
                    });
                    return;
                } else {
                    loadFastReg();
                    return;
                }
            default:
                loadUrl(str + j);
                return;
        }
    }

    private void b(List<PassNameValuePair> list) {
        String b2 = b(k(), list);
        if (this.M.k != null) {
            b2 = b2 + "&enableExternalWeb=1";
        }
        if (this.C.supportFaceLogin) {
            b2 = b2 + "&liveAbility=1";
        }
        loadUrl(b2 + k);
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
            loadUrl(k() + "&" + str2 + l);
        } else {
            loadLogin();
        }
    }

    private void c(int i2, List<PassNameValuePair> list) {
        String str;
        String k2 = k();
        if (this.M.k != null) {
            k2 = k2 + "&enableExternalWeb=1";
        }
        if (this.C.supportFaceLogin) {
            k2 = k2 + "&liveAbility=1";
        }
        if (!TextUtils.isEmpty(p()) && this.M.g != null) {
            str = k2 + "&loginInitType=4";
        } else if (new c().b(getContext())) {
            str = k2 + "&loginInitType=5";
        } else {
            str = k2 + "&loginInitType=" + i2;
        }
        loadUrl(b(str, list) + n);
    }

    public void loadRegist(List<PassNameValuePair> list) {
        loadUrl(b(k(), list) + m);
        this.am = false;
    }

    private String b(String str, List<PassNameValuePair> list) {
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
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + e + "=" + g, "UTF-8")));
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
        arrayList2.add(new PassNameValuePair(this.C.environment.getWap(), b2));
        loadUrl(f2, arrayList2);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, boolean z2) {
        this.M.v = qrLoginCallback;
        this.M.J = z2;
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
        if (this.C.supportFaceLogin) {
            list.add(new PassNameValuePair("scanface", "1"));
        }
        if (this.M.l != null && this.C.supportPhoto) {
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
            arrayList.add(new PassNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + e + "=" + f, "UTF-8")));
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
        if (this.C.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("liveAbility", "1"));
        }
        String a2 = a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String b2 = b(a2, list);
        String b3 = b();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new PassNameValuePair(this.C.environment.getWap(), b3));
        loadUrl(b2, arrayList2);
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
        String i2 = i();
        if (arrayList.size() > 0) {
            i2 = i2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(i2);
    }

    public void loadRealnameAuthenticate(final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(this.C.realnameAuthenticateStoken)) {
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String j2 = SapiWebView.this.j();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new PassNameValuePair("bduss", str));
                arrayList2.add(new PassNameValuePair("stoken", getTplStokenResult.tplStokenMap.get("pp")));
                arrayList2.add(new PassNameValuePair("bdstoken", SapiWebView.this.C.realnameAuthenticateStoken));
                SapiWebView.this.loadUrl(j2 + "&" + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (SapiWebView.this.M.p != null) {
                    SapiWebView.this.M.p.onFailure();
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

    public void loadFastReg() {
        loadFastReg(null);
    }

    public void loadFastReg(List<PassNameValuePair> list) {
        if (!SapiUtils.isSimReady(getContext()) || !SapiUtils.hasActiveNetwork(getContext())) {
            loadUrl(b(k() + "&regLink=0", list) + o);
        } else {
            loadUrl(b(k(), list) + p);
            this.M.N = new FastRegAction();
            this.M.N.b();
        }
        this.am = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.M.M = sapiAccountResponse;
        loadUrl(k() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + q);
    }

    public void loadNormalizeGuestAccount(List<PassNameValuePair> list, String str, SocialType socialType) {
        a(getContext(), str);
        loadUrl(b(a(socialType), list));
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
        if (this.M.l != null && this.C.supportPhoto) {
            list.add(new PassNameValuePair("support_photo", "1"));
        }
        if (this.M.g != null && this.C.supportFaceLogin) {
            list.add(new PassNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(b(a2, list));
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

    public boolean notifyKefuBack() {
        boolean z2 = this.M.I;
        if (this.M.I) {
            loadUrl(ah);
            this.M.I = false;
        }
        return z2;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    public long getTimeoutMillis() {
        return this.W;
    }

    public void setTimeoutMillis(long j2) {
        this.W = j2;
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
            str2 = this.U.a(getContext(), str);
        }
        if (!TextUtils.isEmpty(str2)) {
            String a2 = a(str2, str);
            loadDataWithBaseURL(a2, str2, h, "UTF-8", a2);
            return;
        }
        d(str);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // java.lang.Runnable
            public void run() {
                String[] split;
                String str6;
                if (!SapiWebView.this.V) {
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
        if (this.ai != null) {
            loadUrl(this.ai);
        } else if (this.aj) {
            finish();
        } else if (this.af != null && this.M.M == null && this.M.L == null) {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.af.onBack();
        } else {
            c(this.M.M);
            super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
            a(this.M.L);
        }
        if ((this.P != null && this.P.getVisibility() == 0) || (this.Q != null && this.Q.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        t();
        if (this.M.N != null) {
            this.M.N.f = true;
            this.M.N.k.removeCallbacks(this.M.N.l);
        }
        if (this.ad != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (SapiWebView.this.ad != null && !SapiWebView.this.V) {
                        SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                        SapiWebView.this.ad.onFinish();
                    }
                }
            });
        }
    }

    private String p() {
        if (TextUtils.isEmpty(this.J)) {
            this.J = SapiContext.getInstance(getContext()).geSupFaceLoginType();
        }
        return this.J;
    }

    private void c(String str) {
        if (statLoadLogin != null) {
            String p2 = p();
            if (str.contains(j) || str.contains(n) || str.contains(k) || str.contains(p) || str.contains(o) || (!TextUtils.isEmpty(p2) && str.contains(p2))) {
                statLoadLogin.tStartLogin = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z2) {
        if (statLoadLogin != null) {
            String p2 = p();
            if (str.contains(j) || str.contains(n) || str.contains(k) || str.contains(p) || str.contains(o) || (!TextUtils.isEmpty(p2) && str.contains(p2))) {
                statLoadLogin.tLoadLogin = System.currentTimeMillis();
                statLoadLogin.isLoadCache = z2;
            }
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
        if (i2 == 4 && this.ak == 1) {
            if (this.al) {
                notifyKefuBack();
                return true;
            }
            if (this.ae != null && this.M.M == null && this.M.L == null) {
                this.ae.onBack();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2603=4] */
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
    public void q() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.10
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.R != null) {
                    SapiWebView.this.R.setVisibility(8);
                }
                if (SapiWebView.this.O != null) {
                    SapiWebView.this.O.setVisibility(8);
                }
                SapiWebView.this.K.a = SapiWebView.this.ab.b;
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.R != null) {
                    SapiWebView.this.R.setVisibility(8);
                }
                if (SapiWebView.this.O != null) {
                    SapiWebView.this.O.setVisibility(8);
                }
                if (SapiWebView.this.P != null) {
                    SapiWebView.this.P.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.P == null || this.P.getVisibility() != 0) {
            if (this.Q == null || this.Q.getVisibility() != 0) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SapiWebView.this.O != null) {
                            SapiWebView.this.O.setVisibility(0);
                            if (SapiWebView.this.R != null) {
                                SapiWebView.this.R.setVisibility(8);
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
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 1).show();
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
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.C.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.C.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    public void loadSinaSSOLogin(List<PassNameValuePair> list, String str, String str2) {
        loadUrl(b(a(SocialType.SINA_WEIBO_SSO, str, str2, this.C.sinaAppId), list));
    }

    @TargetApi(9)
    public void loadWeixinSSOLogin(final boolean z2, final String str, final List<PassNameValuePair> list) {
        if (this.D == null) {
            this.D = new DefaultWeixinHandler();
        }
        new e().a(getContext(), this.C, this.P, this.D, b(a(z2, str), list), getUaInfo(), new e.a() { // from class: com.baidu.sapi2.SapiWebView.13
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
                SapiWebView.this.K.b = true;
                SapiWebView.this.K.c = z2;
                SapiWebView.this.K.d = str;
                SapiWebView.this.K.e = list;
                SapiWebView.this.P.setVisibility(0);
            }
        });
    }

    public void loadWeixinSSOLogin(List<PassNameValuePair> list) {
        loadWeixinSSOLogin(false, null, list);
    }

    public void loadQQSSOLogin(List<PassNameValuePair> list, String str, String str2, String str3) {
        loadUrl(b(a(str, str2, str3), list));
    }

    public void loadXiaomiSSOLogin(List<PassNameValuePair> list, String str, String str2, String str3) {
        loadUrl(b(b(str, str2, str3), list));
    }

    public void weixinSSOLogin(String str, String str2, boolean z2) {
        weixinSSOLogin(str, str2, z2, null);
    }

    public void weixinSSOLogin(String str, String str2, boolean z2, List<PassNameValuePair> list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        String b2 = b(a(str, str2, z2), list);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair(this.C.environment.getURL(), "mkey=" + str2 + ";domain=." + this.C.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/;httponly"));
        loadUrl(b2, arrayList);
    }

    public void loadHuaWeiSSOLogin(String str, List<PassNameValuePair> list) {
        String str2 = null;
        try {
            str2 = SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, "UTF-8"), "");
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(b(str2, list));
    }

    public void loadMeizuSSOLogin(List<PassNameValuePair> list, String str, String str2) {
        String str3 = null;
        try {
            str3 = a(SocialType.MEIZU, URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"), null);
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(b(str3, list));
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
        loadUrl(b(b2, list));
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.R != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.R.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.R.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void d(final String str) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
            @Override // java.lang.Runnable
            public void run() {
                if (!SapiWebView.this.V) {
                    SapiWebView.this.a(str, false);
                    SapiWebView.super.loadUrl(str);
                }
            }
        });
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            r();
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
            SapiContext.getInstance(this.C.context).put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.C.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance(this.C.context).setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new com.baidu.sapi2.share.a.c().a(getContext(), sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount b2 = b(sapiAccountResponse);
            if (this.M.D != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            SapiWebView.this.M.D.beforeSuccess(b2);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        com.baidu.sapi2.share.a.a().a(b2);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                        SapiStatUtil.statShareV1Login(SapiWebView.this.getContext(), b2, SapiWebView.this.extras);
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
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.sapi2.share.a.a().a(b2);
                        if (SapiWebView.this.I != null && !session.uid.equals(b2.uid)) {
                            SapiWebView.this.I.onAccountChange();
                        }
                    }
                });
            } else if (this.M.D != null) {
                if (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.17
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.M.D != null) {
                                    SapiWebView.this.M.D.beforeSuccess(b2);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            com.baidu.sapi2.share.a.a().a(b2);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.M.L = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.18
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.M.D != null) {
                                SapiWebView.this.M.D.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                            }
                            SapiWebView.this.M.L = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        SapiUtils.reportGid(this.am ? 10002 : 10003);
        if (this.M.D != null) {
            try {
                if (!AuthorizationListener.class.equals(this.M.D.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.M.D.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.M.D.onSuccess();
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
                        SapiWebView.this.t();
                        FastRegAction.this.k.removeCallbacks(FastRegAction.this.l);
                    }
                }
            };
            this.l = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.4
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.t();
                    FastRegAction.this.a(SapiWebView.this.a());
                }
            };
        }

        private String a() {
            return UUID.randomUUID().toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + System.currentTimeMillis() + Constants.ACCEPT_TIME_SEPARATOR_SP + "点击发送直接登录";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                this.d = a();
            }
            if (SapiUtils.isSimReady(SapiWebView.this.getContext()) && SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                if (SapiWebView.this.C.fastRegConfirm) {
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.u).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.6
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
                    }).setNegativeButton(SapiWebView.A, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SapiWebView.this.loadUrl(SapiWebView.this.k() + "&regLink=0" + SapiWebView.o);
                        }
                    }).create();
                    if (!TextUtils.isEmpty(SapiWebView.this.C.fastRegConfirmMsg)) {
                        create.setMessage(SapiWebView.this.C.fastRegConfirmMsg);
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
                return;
            }
            e();
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
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new GetDynamicPwdCallback() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.8
                    /* JADX DEBUG: Method merged with bridge method */
                    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
                        SapiWebView.this.loadUrl(SapiWebView.this.k() + "&regLink=0" + SapiWebView.o);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
                        SapiWebView.this.a(FastRegAction.this.i);
                        FastRegAction.this.k.postDelayed(FastRegAction.this.l, 15000L);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
                        SapiWebView.this.loadUrl(SapiWebView.this.k() + "&regLink=0" + SapiWebView.o);
                    }

                    public void onStart() {
                    }

                    public void onFinish() {
                    }
                }, a, null, null);
                return;
            }
            SapiWebView.this.loadUrl(SapiWebView.this.k() + "&regLink=0" + SapiWebView.o);
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
            SapiWebView.this.loadUrl(SapiWebView.this.k() + "&username=" + str + SapiWebView.r);
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
        if (this.ac == null) {
            this.ac = SapiCoreUtil.registerReceiver(getContext(), handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.ac != null) {
            try {
                getContext().unregisterReceiver(this.ac);
            } catch (Throwable th) {
            }
        }
        this.ac = null;
    }

    String a(String str, String str2) {
        String[] split;
        String str3;
        if (str2.split("#").length > 1) {
            SapiOptions sapiOptions = SapiContext.getInstance(getContext()).getSapiOptions();
            String c2 = this.U.c(str2);
            if (this.U.c(getContext(), c2) != null) {
                String str4 = this.U.c(getContext(), c2).hash;
                String md5 = MD5Util.toMd5(str.getBytes(), false);
                String version = sapiOptions.getCache().getVersion();
                if (!str4.equals(md5)) {
                    str3 = "&passAppHash=" + MD5Util.toMd5(str.getBytes(), false);
                } else {
                    str3 = (TextUtils.isEmpty(version) ? "" : "&passAppVersion=" + version) + "&passAppHash=" + this.U.c(getContext(), c2).hash;
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    String b() {
        return SapiUtils.buildBDUSSCookie(this.C.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
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
        String replaceAll = this.C.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals(AppIconSetting.DEFAULT_LARGE_ICON)) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        String wap = this.C.environment.getWap();
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
                    SapiWebView.this.S = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
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
                if (SapiWebView.this.S != null && SapiWebView.this.S.isShowing()) {
                    try {
                        SapiWebView.this.S.dismiss();
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
        if (this.C.supportFaceLogin && this.M.f != null && this.M.g != null) {
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

    String a(String str) {
        return SapiAccountManager.getInstance().getAccountService().a(str) + "&" + SapiUtils.createRequestParams(d());
    }

    String i() {
        return SapiAccountManager.getInstance().getAccountService().g() + "&" + SapiUtils.createRequestParams(d());
    }

    String j() {
        return SapiAccountManager.getInstance().getAccountService().i() + "&" + SapiUtils.createRequestParams(d());
    }

    String k() {
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
}
