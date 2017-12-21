package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
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
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.plugin.SSOError;
import com.baidu.sapi2.plugin.SSOListener;
import com.baidu.sapi2.plugin.sso.SsoHandler;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.BiometricType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.huawei.hwid.openapi.OpenHwID;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
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
    private static final String A = "系统时间错误";
    private static final String B = "证书安全警告";
    private static final String C = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String D = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    private static final String E = "取消";
    private static final String F = "立即设置时间";
    public static final String PARAMS_LOGIN_WITH_USER_NAME = "loginUserName";
    public static final String QR_FACE_AUTH_PASS_PRODUCT_ID = "pp";
    private static final String a = "prompt_on_cancel";
    private static final String aG = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String aH = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.pageGoBack){Pass.client.pageGoBack()}}())";
    private static final int b = 1;
    private static final int c = 0;
    private static final String d = "__wp-action";
    private static final String e = "renren-offline";
    private static final String f = "auth-widget";
    private static final String g = "forget-pwd";
    private static final String h = "modify-pwd";
    private static final String i = "text/html";
    private static final String j = "UTF-8";
    private static final String k = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    private static final String l = "file:///android_asset";
    private static final String m = "#login";
    private static final String n = "#authPwd";
    private static final String o = "#reg";
    private static final String p = "#canshare_accounts";
    private static final String q = "#sms_login";
    private static final String r = "#fastReg";
    private static final String s = "#fastRegSuccess";
    private static final String t = "#fastRegVerify";
    private static final String u = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    private static final String v = "发送一条短信，即可完成注册。";
    private static final String w = "服务错误，请稍后重试";
    private static final String x = "微信未安装";
    private static final String y = "未登录华为帐号";
    private static final String z = "未登录魅族帐号";
    private Map<String, AbstractInterpreter> G;
    private SapiConfiguration H;
    private AuthorizationListener I;
    private Handler J;
    private Handler K;
    private FastRegHandler L;
    private VoiceLoginHandler M;
    private NMLoginHandler N;
    private LCLoginHandler O;
    private UniteVerifyHandler P;
    private WeixinHandler Q;
    private HuaweiHandler R;
    private MeizuHandler S;
    private QuickLoginHandler T;
    private Handler U;
    private LoadExternalWebViewCallback V;
    private FileChooserCallback W;
    private BroadcastReceiver aA;
    private SmsHandler aB;
    private Runnable aC;
    private OnFinishCallback aD;
    private OnBackCallback aE;
    private OnNewBackCallback aF;
    private FastRegAction aI;
    private SapiAccountResponse aJ;
    private SapiCallback<LoginResult> aK;
    private SocialResponse aL;
    private JsPromptResult aM;
    private String aN;
    private boolean aO;
    private String aP;
    private int aQ;
    private boolean aR;
    private PickPhotoCallback aa;
    private ChangePwdCallback ab;
    private AuthWidgetCallback ac;
    private BindWidgetCallback ad;
    private UniteVerifyCallback ae;
    private WebViewTitleCallback af;
    private BiometricsIdentifyCallback ag;
    private BioScanFaceCallback ah;
    private CoverWebBdussCallback ai;
    private SwitchAccountCallback aj;
    private PreFillUserNameCallback ak;
    private BdussChangeCallback al;
    private AccountDestoryCallback am;
    private LeftBtnVisibleCallback an;
    private RealnameAuthenticateCallback ao;
    private SystemUpwardSmsCallback ap;
    private SsoHandler aq;
    private ReloadConfig ar;
    private View as;
    private View at;
    private ProgressBar au;
    private ProgressDialog av;
    private Dialog aw;
    private long ax;
    private Handler ay;
    private TimeoutTask az;
    public static final NameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new BasicNameValuePair("smsfastlogin", "1");
    public static final NameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new BasicNameValuePair("bindToSmsLogin", "1");
    public static final NameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new BasicNameValuePair("overseas", "1");
    public static final NameValuePair EXTRA_SUPPORT_VOICE_CODE = new BasicNameValuePair("is_voice_sms", "1");

    /* loaded from: classes.dex */
    public static abstract class AccountDestoryCallback {

        /* loaded from: classes.dex */
        public static class AccountDestoryResult {
        }

        public abstract void onAccountDestory(AccountDestoryResult accountDestoryResult);
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
        public static final int VOICE_VERIFICATION = 2;

        void onBiometricsIdentify(int i, int i2, String str, BiometricsIdentifyResult biometricsIdentifyResult);

        void onBiometricsIdentify(int i, int i2, String str, String str2, BiometricsIdentifyResult biometricsIdentifyResult);

        void onBiometricsIdentify(int i, int i2, String str, String str2, String str3, String str4, BiometricsIdentifyResult biometricsIdentifyResult);
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
    public interface LCLoginHandler {
        void handleLCLogin();
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
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes.dex */
    public interface RealnameAuthenticateCallback {
        void onFailure();

        void onSuccess();
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
    public interface VoiceLoginHandler {
        void handleVoiceLogin();
    }

    /* loaded from: classes.dex */
    public interface WebViewTitleCallback {
        void onTitleChange(String str);
    }

    /* loaded from: classes.dex */
    public interface WeixinHandler {
        void handleNotInstall();

        void handleServerError(String str);
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
                SapiWebView.this.ay.sendMessage(message);
                SapiWebView.this.ay.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.aD = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.aE = onBackCallback;
    }

    public void setOnNewBackCallback(OnNewBackCallback onNewBackCallback) {
        this.aF = onNewBackCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.G = new HashMap();
        this.ar = new ReloadConfig();
        this.ay = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.g();
                }
            }
        };
        this.az = new TimeoutTask();
        this.aQ = 1;
        this.aR = false;
        c();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = new HashMap();
        this.ar = new ReloadConfig();
        this.ay = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.g();
                }
            }
        };
        this.az = new TimeoutTask();
        this.aQ = 1;
        this.aR = false;
        c();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.G = new HashMap();
        this.ar = new ReloadConfig();
        this.ay = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.g();
                }
            }
        };
        this.az = new TimeoutTask();
        this.aQ = 1;
        this.aR = false;
        c();
    }

    public final void setNoNetworkView(View view) {
        if (this.as == null) {
            this.as = view;
            this.as.setVisibility(4);
            addView(this.as, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.at == null) {
            this.at = view;
            this.at.setVisibility(4);
            addView(this.at, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.au == null) {
            this.au = progressBar;
            if (this.au != null) {
                addView(progressBar);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.H.isNightMode) {
            canvas.drawColor(Color.parseColor("#7f000000"));
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    @TargetApi(11)
    private void c() {
        this.ax = DEFAULT_TIMEOUT_MILLIS;
        this.H = SapiAccountManager.getInstance().getSapiConfiguration();
        e();
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
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                if (SapiWebView.this.au != null) {
                    if (i2 == 100) {
                        SapiWebView.this.au.setVisibility(8);
                    } else {
                        if (SapiWebView.this.au.getVisibility() == 8) {
                            SapiWebView.this.au.setVisibility(0);
                        }
                        SapiWebView.this.au.setProgress(i2);
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
                if (SapiWebView.this.W != null) {
                    SapiWebView.this.W.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (SapiWebView.this.W != null) {
                    SapiWebView.this.W.onFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (SapiWebView.this.W != null) {
                    SapiWebView.this.W.onFileChooser(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (SapiWebView.this.W != null) {
                    SapiWebView.this.W.onFileChooserForOSVersion5(valueCallback);
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                final String[] strArr = {""};
                SapiWebView.this.aM = jsPromptResult;
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            String actionName = parse.getActionName();
                            if ("sapi_action_pick_image".equals(actionName) || "sapi_action_pick_date".equals(actionName) || "sapi_biometrics_identification".equals(actionName) || "sapi_biometrics_identification_no_bduss".equals(actionName) || "sapi_biometrics_identification_with_authtoken".equals(actionName) || "sapi_biometrics_identification_with_uid".equals(actionName) || "sapi_action_upsms".equals(actionName)) {
                                SapiWebView.this.aM = jsPromptResult;
                            }
                            if (!TextUtils.isEmpty(actionName) && SapiWebView.this.G.get(actionName) != null) {
                                strArr[0] = ((AbstractInterpreter) SapiWebView.this.G.get(actionName)).interpret(parse);
                            }
                            if (parse.getActionParams().size() > 2 && SapiWebView.a.equals(parse.getActionParams().get(2))) {
                                jsPromptResult.cancel();
                                return;
                            } else if (!"sapi_action_pick_image".equals(actionName) && !"sapi_action_pick_date".equals(actionName) && !"sapi_biometrics_identification".equals(actionName) && !"sapi_biometrics_identification_no_bduss".equals(actionName) && !"sapi_biometrics_identification_with_authtoken".equals(actionName) && !"sapi_biometrics_identification_with_uid".equals(actionName) && !"sapi_action_upsms".equals(actionName)) {
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
        if (this.I == null) {
            this.I = new DefaultAuthorizationListener();
        }
        if (this.Q == null) {
            this.Q = new DefaultWeixinHandler();
        }
        this.aB = new SmsHandler();
        this.aC = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.j();
            }
        };
        try {
            resumeTimers();
        } catch (Throwable th) {
            Log.e(th);
        }
        d();
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED, IEventCenterService.EventResult.PHASE.SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.SapiWebView$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
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
                    if (SapiWebView.this.aK != null) {
                        Uri parse = Uri.parse(str);
                        if (SapiWebView.this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").equals(parse.getHost() + (parse.getPort() == -1 ? "" : ":" + parse.getPort())) && SapiEnv.LOGIN_PROXY_URI.equals(parse.getPath())) {
                            SapiAccountManager.getInstance().getAccountService().a(SapiWebView.this.aK, str);
                            return true;
                        }
                    }
                    if (SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL).equals(str)) {
                        SapiWebView.this.finish();
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && !str.startsWith("javascript:") && !str.contains("loadDataWithBaseUrl")) {
                SapiWebView.this.h();
            }
            SapiWebView.this.az.setUrl(str);
            SapiWebView.this.ay.postDelayed(SapiWebView.this.az, SapiWebView.this.ax);
            if (str != null) {
                if (str.contains("__wp-action=auth-widget")) {
                    final String queryParameter = Uri.parse(str).getQueryParameter("authsid");
                    if (!TextUtils.isEmpty(queryParameter) && SapiWebView.this.ac != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.ac != null) {
                                    SapiWebView.this.ac.onSuccess(queryParameter);
                                }
                            }
                        });
                    }
                }
                if (str.contains(SapiWebView.g) || str.contains(SapiWebView.h)) {
                    String queryParameter2 = Uri.parse(str).getQueryParameter(SapiWebView.d);
                    if (SapiWebView.g.equals(queryParameter2) && SapiWebView.this.ab != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.ab != null) {
                                    SapiWebView.this.ab.onSuccess();
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.SUCCESS);
                                }
                            }
                        });
                    }
                    if (SapiWebView.h.equals(queryParameter2) && SapiWebView.this.ab != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.ab != null) {
                                        SapiWebView.this.ab.onSuccess();
                                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                        return;
                                    }
                                    return;
                                }
                                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.3.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.ab != null) {
                                            SapiWebView.this.ab.onSuccess();
                                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                                        if (session != null && session.uid.equals(getUserInfoResult.uid)) {
                                            session.bduss = cookieBduss;
                                        }
                                        if (!TextUtils.isEmpty(cookiePtoken)) {
                                            session.ptoken = cookiePtoken;
                                        }
                                        session.deleteStokens();
                                        SapiAccountManager.getInstance().validate(session);
                                        SapiAccountManager.getInstance().preFetchStoken(session, true);
                                        if (SapiWebView.this.ab != null) {
                                            SapiWebView.this.ab.onSuccess();
                                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.SUCCESS);
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.ab != null) {
                                            SapiWebView.this.ab.onSuccess();
                                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onStart() {
                                        try {
                                            SapiWebView.this.av = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                                        } catch (Throwable th) {
                                            Log.e(th);
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFinish() {
                                        if (SapiWebView.this.av != null) {
                                            try {
                                                SapiWebView.this.av.dismiss();
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
                if (str.contains("__wp-action=renren-offline") && SapiWebView.e.equals(Uri.parse(str).getQueryParameter(SapiWebView.d))) {
                    if (SapiWebView.this.aL == null) {
                        if (SapiWebView.this.I != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.I != null) {
                                        SapiWebView.this.I.onFailed(-100, "登录失败");
                                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    SapiWebView.this.a(SapiWebView.this.aL);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            StatService.onEvent("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""), false);
            if (SapiWebView.this.H.environment == Domain.DOMAIN_QA || SapiWebView.this.H.environment == Domain.DOMAIN_RD) {
                sslErrorHandler.proceed();
                return;
            }
            if ((sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) && !SapiWebView.this.H.forbidSslErrorDialog) {
                if (SapiWebView.this.aw == null) {
                    if (Build.VERSION.SDK_INT > 17) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SapiWebView.C);
                        Date date = new Date(System.currentTimeMillis());
                        str = SapiWebView.A;
                        str2 = simpleDateFormat.format(date);
                    } else {
                        str = SapiWebView.B;
                        str2 = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext());
                    builder.setTitle(str);
                    builder.setMessage(str2);
                    builder.setPositiveButton(SapiWebView.F, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SapiWebView.this.getContext().startActivity(new Intent("android.settings.DATE_SETTINGS"));
                            dialogInterface.dismiss();
                            StatService.onEvent("sslerr_date_setting", null, false);
                        }
                    });
                    builder.setNegativeButton(SapiWebView.E, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            StatService.onEvent("sslerr_date_cancel", null, false);
                        }
                    });
                    SapiWebView.this.aw = builder.create();
                }
                if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !SapiWebView.this.aw.isShowing()) {
                    SapiWebView.this.aw.show();
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
            if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext()) && SapiWebView.this.as != null && SapiWebView.this.as.getVisibility() != 4) {
                SapiWebView.this.as.setVisibility(4);
            }
            SapiWebView.this.loadUrl(SapiWebView.aG);
            if (SapiWebView.this.af != null) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({action:{name:'action_set_title',params:[document.title, 'prompt_on_cancel', 'prompt_on_cancel']}}));");
            }
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().l());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().m());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            Uri parse4 = Uri.parse(SapiAccountManager.getInstance().getAccountService().a(false));
            if (str.contains(SapiEnv.ACCOUNT_CENTER_EDITUSER) || str.contains(SapiEnv.ACCOUNT_CENTER_ACCOUNT_BIND)) {
                SapiWebView.this.aN = Uri.parse(str).getQueryParameter("gotoUrl");
            } else if (!str.contains(SapiEnv.ACCOUNT_CENTER_MODIFY_PWD_RESULT)) {
                SapiWebView.this.aN = null;
            } else {
                SapiWebView.this.aN = Uri.parse(str).getQueryParameter("refer");
            }
            if (str.contains(parse4.getHost() + parse4.getPath())) {
                SapiWebView.this.aO = true;
            } else {
                SapiWebView.this.aO = false;
            }
            if ((str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) && !"center".equals(Uri.parse(str).getQueryParameter("wapsec"))) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().h())) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '0', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.ay.removeCallbacks(SapiWebView.this.az);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i == -8) {
                SapiWebView.this.g();
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

    private void d() {
        this.G.put("sapi_action_check_method_support", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.5
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                boolean z2;
                String str = command.getActionParams().get(0);
                boolean containsKey = SapiWebView.this.G.containsKey(str);
                if (str.equals("sapi_biometrics_identification_with_uid")) {
                    z2 = SapiWebView.this.ah != null;
                } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                    z2 = SapiWebView.this.ag != null;
                } else {
                    z2 = containsKey;
                }
                return z2 ? "1" : "0";
            }
        });
        this.G.put("config_fastlogin_features", new ConfigFastloginFeaturesInterpreter());
        this.G.put("action_feifan_login", new FeifanWebviewInterpreter());
        this.G.put("action_chuanke_login", new ChuankeWebviewInterpreter());
        this.G.put("action_social_sina_sso", new SinaSSOInterpreter());
        this.G.put("action_social_weixin_sso", new WeiXinSSOInterpreter());
        this.G.put("action_social_meizu_sso", new MeiZuSSOInterpreter());
        this.G.put("action_social_qzone_webview", new QzoneWebviewInterpreter());
        this.G.put("action_social_tx_weibo_webview", new TXWeiboWebviewInterpreter());
        this.G.put("action_social_sina_weibo_webview", new SinaWeiboWebviewInterpreter());
        this.G.put("action_huawei_login", new HuaweiSSOintrpreter());
        this.G.put("action_nuomi_login", new NuomiLoginInterpreter());
        this.G.put("action_lecai_login", new LecaiLoginInterpreter());
        this.G.put("action_voice_login", new VoiceLoginInterpreter());
        this.G.put("action_unite_verify", new UniteVerifyInterpreter());
        this.G.put("loginWithQRCode", new QRcodeLoginInterpreter());
        this.G.put("authorized_response", new AuthorizedResponseInterpreter());
        this.G.put("config_login_share_strategy", new ShareStrategyConfigInterpreter());
        this.G.put("config_canshare_accounts", new ShareAccountsConfigInterpreter());
        this.G.put("action_remove_share_account", new ShareAccountsRemoveInterpreter());
        this.G.put("unite_verify_result", new UniteVerifyResultInterpreter());
        this.G.put("action_share_accounts_view_btn_clicked", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.6
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.T != null) {
                    SapiWebView.this.T.handleOtherLogin();
                    return null;
                }
                return null;
            }
        });
        this.G.put("action_bind_widget_phone_number_exist", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str = command.getActionParams().get(0);
                if (SapiWebView.this.ad != null) {
                    SapiWebView.this.ad.onPhoneNumberExist(str);
                    return null;
                }
                return null;
            }
        });
        this.G.put("finish", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.a(SapiWebView.this.aL);
                SapiWebView.this.finish();
                return null;
            }
        });
        this.G.put("back", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.back();
                return null;
            }
        });
        this.G.put("action_fast_reg", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.10
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.L != null) {
                    SapiWebView.this.L.handleFastReg();
                    return null;
                }
                SapiWebView.this.loadFastReg();
                return null;
            }
        });
        this.G.put("action_forget_pwd", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                boolean z2 = false;
                if (SapiWebView.this.I != null) {
                    z2 = SapiWebView.this.I.onForgetPwd();
                }
                return z2 ? "1" : "0";
            }
        });
        this.G.put("action_received_sms_code", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.12
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.a(SapiWebView.this.aB);
                SapiWebView.this.aB.a = command.getActionParams().get(0);
                SapiWebView.this.aB.b = command.getActionParams().get(1);
                SapiWebView.this.aB.postDelayed(SapiWebView.this.aC, 15000L);
                return null;
            }
        });
        this.G.put("set_pass_canceled", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.13
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.b(SapiWebView.this.aJ);
                return null;
            }
        });
        this.G.put("get_preset_phone_number", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.14
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (!SapiWebView.this.H.forbidPresetPhoneNumber) {
                    if (SapiUtils.isValidPhoneNumber(SapiWebView.this.H.presetPhoneNumber)) {
                        return SapiWebView.this.H.presetPhoneNumber;
                    }
                    String i2 = SapiWebView.this.i();
                    return !SapiUtils.isValidPhoneNumber(i2) ? "" : i2;
                }
                return "";
            }
        });
        this.G.put("action_generate_sign", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.15
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str = command.getActionParams().get(0);
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.optString(next));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return SapiAccountManager.getInstance().getAccountService().a(hashMap, SapiWebView.this.H.appSignKey);
            }
        });
        this.G.put("sapi_action_pick_date", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.16
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str = command.getActionParams().get(0);
                Calendar calendar = Calendar.getInstance();
                Date time = calendar.getTime();
                try {
                    calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(str));
                } catch (Exception e2) {
                    Log.e(e2);
                }
                int i2 = calendar.get(1);
                int i3 = calendar.get(2);
                int i4 = calendar.get(5);
                calendar.setTime(time);
                int i5 = calendar.get(1);
                int i6 = calendar.get(2);
                int i7 = calendar.get(5);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SapiWebView.this.getContext(), 3, new DatePickerDialog.OnDateSetListener() { // from class: com.baidu.sapi2.SapiWebView.16.1
                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int i8, int i9, int i10) {
                        SapiWebView.this.aM.confirm(i8 + String.format("%02d", Integer.valueOf(i9 + 1)) + String.format("%02d", Integer.valueOf(i10)) + "");
                    }
                }, i2, i3, i4);
                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiWebView.16.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SapiWebView.this.aM.confirm("");
                    }
                });
                datePickerDialog.setTitle("");
                calendar.set(i5, i6, i7, 23, 59, 59);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                calendar.set(i5 - 100, i6, i7, 0, 0, 0);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.show();
                datePickerDialog.setCustomTitle(null);
                return null;
            }
        });
        this.G.put("action_load_external_webview", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.17
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.V != null) {
                    LoadExternalWebViewResult loadExternalWebViewResult = new LoadExternalWebViewResult();
                    loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                    loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                    SapiWebView.this.V.loadExternalWebview(loadExternalWebViewResult);
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_action_pick_image", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.18
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                int i2;
                try {
                    i2 = Integer.parseInt(command.getActionParams().get(0));
                } catch (Exception e2) {
                    Log.e(e2);
                    i2 = 0;
                }
                SapiWebView.this.aa.onPickImage(i2, new PickPhotoResult() { // from class: com.baidu.sapi2.SapiWebView.18.1
                    {
                        SapiWebView sapiWebView = SapiWebView.this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                    public void setImageData(String str) {
                        if (SapiWebView.this.aM != null) {
                            SapiWebView.this.aM.confirm(str);
                        }
                    }
                });
                return null;
            }
        });
        this.G.put("sapi_action_bduss_changed", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.19
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.al != null) {
                    SapiWebView.this.al.onBdussChange();
                    return null;
                }
                SapiWebView.this.k();
                return null;
            }
        });
        this.G.put("sapi_action_switch_account", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.20
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.aj != null) {
                    List<String> actionParams = command.getActionParams();
                    if (actionParams != null && actionParams.size() > 0) {
                        SwitchAccountCallback.Result result = new SwitchAccountCallback.Result();
                        result.userName = actionParams.get(0);
                        try {
                            if (!SwitchAccountCallback.class.equals(SapiWebView.this.aj.getClass().getMethod("onAccountSwitch", SwitchAccountCallback.Result.class).getDeclaringClass())) {
                                SapiWebView.this.aj.onAccountSwitch(result);
                            }
                        } catch (NoSuchMethodException e2) {
                            Log.e(e2);
                        }
                    }
                    SapiWebView.this.aj.onAccountSwitch();
                }
                return null;
            }
        });
        this.G.put("sapi_action_relate_weixin", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.21
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (!WXAPIFactory.createWXAPI(SapiWebView.this.getContext(), SapiWebView.this.H.wxAppID).isWXAppInstalled()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("error", ErrorCode.WEIXIN_NOT_INTALL);
                        jSONObject.put("errmsg", SapiWebView.x);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    return jSONObject.toString();
                }
                SapiWebView.this.aP = command.getActionParams().get(0);
                if (SapiWebView.this.U != null) {
                    Message message = new Message();
                    message.what = SocialType.WEIXIN.getType();
                    message.obj = SapiWebView.this.aP;
                    SapiWebView.this.U.sendMessage(message);
                }
                return null;
            }
        });
        this.G.put("action_set_title", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.22
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str = command.getActionParams().get(0);
                if (SapiWebView.this.af != null) {
                    SapiWebView.this.af.onTitleChange(str);
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_biometrics_identification", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.23
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str;
                int parseInt = Integer.parseInt(command.getActionParams().get(0));
                int parseInt2 = command.getActionParams().size() > 1 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
                if (command.getActionParams().size() <= 2) {
                    str = SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID;
                } else {
                    str = command.getActionParams().get(2).toString();
                }
                if (TextUtils.isEmpty(str)) {
                    str = SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID;
                }
                if (SapiWebView.this.ag != null) {
                    SapiWebView.this.ag.onBiometricsIdentify(parseInt, parseInt2, str, new BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiWebView.23.1
                        {
                            SapiWebView sapiWebView = SapiWebView.this;
                        }

                        @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                        public void setIdentifyToken(String str2) {
                            if (SapiWebView.this.aM != null) {
                                SapiWebView.this.aM.confirm(str2);
                            }
                        }
                    });
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_biometrics_identification_no_bduss", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.24
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                int parseInt = Integer.parseInt(command.getActionParams().get(0));
                String str = command.getActionParams().get(1);
                String str2 = command.getActionParams().get(2);
                String str3 = "";
                int parseInt2 = command.getActionParams().size() > 3 ? Integer.parseInt(command.getActionParams().get(3)) : 0;
                if (command.getActionParams().size() > 4) {
                    str3 = command.getActionParams().get(4);
                }
                String str4 = SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID;
                if (command.getActionParams().size() > 5) {
                    str4 = command.getActionParams().get(5);
                }
                String str5 = TextUtils.isEmpty(str4) ? SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID : str4;
                if (SapiWebView.this.ag != null) {
                    SapiWebView.this.ag.onBiometricsIdentify(parseInt, parseInt2, str, str2, str3, str5, new BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiWebView.24.1
                        {
                            SapiWebView sapiWebView = SapiWebView.this;
                        }

                        @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                        public void setIdentifyToken(String str6) {
                            if (SapiWebView.this.aM != null) {
                                SapiWebView.this.aM.confirm(str6);
                            }
                        }
                    });
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_biometrics_identification_with_authtoken", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.25
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str;
                int parseInt = Integer.parseInt(command.getActionParams().get(0));
                String str2 = command.getActionParams().get(1);
                int parseInt2 = command.getActionParams().size() > 2 ? Integer.parseInt(command.getActionParams().get(2)) : 0;
                if (command.getActionParams().size() <= 3) {
                    str = SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID;
                } else {
                    str = command.getActionParams().get(3).toString();
                }
                String str3 = TextUtils.isEmpty(str) ? SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID : str;
                if (SapiWebView.this.ag != null) {
                    SapiWebView.this.ag.onBiometricsIdentify(parseInt, parseInt2, str2, str3, new BiometricsIdentifyResult() { // from class: com.baidu.sapi2.SapiWebView.25.1
                        {
                            SapiWebView sapiWebView = SapiWebView.this;
                        }

                        @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                        public void setIdentifyToken(String str4) {
                            if (SapiWebView.this.aM != null) {
                                SapiWebView.this.aM.confirm(str4);
                            }
                        }
                    });
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_action_handle_back_button", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.26
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.aQ = Integer.parseInt(command.getActionParams().get(0));
                if (SapiWebView.this.an != null) {
                    SapiWebView.this.an.onLeftBtnVisible(SapiWebView.this.aQ);
                    return null;
                }
                return null;
            }
        });
        this.G.put("realNameVerifySucceed", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.27
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.ao != null) {
                    SapiWebView.this.ao.onSuccess();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REALNAME_AUTHENTICATE, IEventCenterService.EventResult.PHASE.SUCCESS);
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_action_cover_web_bduss", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.28
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String cookieBduss = SapiUtils.getCookieBduss();
                if (SapiWebView.this.ai != null) {
                    SapiWebView.this.ai.onCoverBduss(cookieBduss, new CoverWebBdussResult() { // from class: com.baidu.sapi2.SapiWebView.28.1
                        {
                            SapiWebView sapiWebView = SapiWebView.this;
                        }

                        @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussResult
                        public void setWebBduss(String str) {
                            SapiWebView.this.a(SapiWebView.this.getContext(), str);
                            SapiWebView.this.reload();
                        }
                    });
                    return null;
                }
                return null;
            }
        });
        this.G.put("sapi_action_get_app_tpl", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.29
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                return SapiWebView.this.H.getTpl();
            }
        });
        this.G.put("sapi_action_upsms", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.30
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                new SendUpwardSms(command.getActionParams().get(0), command.getActionParams().get(1), command.getActionParams().get(2), command.getActionParams().get(3), new UpwardSmsCallback() { // from class: com.baidu.sapi2.SapiWebView.30.1
                    @Override // com.baidu.sapi2.SapiWebView.UpwardSmsCallback
                    public void onResult(boolean z2, boolean z3, boolean z4) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("with_permision", z2);
                            jSONObject.put("send_suc", z3);
                            jSONObject.put("cancel", z4);
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        SapiWebView.this.aM.confirm(jSONObject.toString());
                    }
                }).a();
                return null;
            }
        });
        this.G.put("sapi_kefu_in", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.31
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.aR = true;
                return null;
            }
        });
        this.G.put("sapi_goBack", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.32
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.canGoBack()) {
                    SapiWebView.this.goBack();
                    return null;
                }
                SapiWebView.this.finish();
                return null;
            }
        });
        this.G.put("sapi_action_deliver_params", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.33
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_USERNAME);
                    boolean equals = jSONObject.optString(IntentConfig.CLOSE, "0").equals("1");
                    PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult = new PreFillUserNameCallback.PreFillUserNameResult();
                    preFillUserNameResult.userName = optString;
                    if (SapiWebView.this.ak != null) {
                        SapiWebView.this.ak.onPreFillUserName(preFillUserNameResult);
                    }
                    if (equals) {
                        SapiWebView.this.finish();
                        return null;
                    }
                    return null;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
        });
        this.G.put("getFaceLoginInfo", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.34
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livinguname", SapiContext.getInstance(SapiWebView.this.getContext()).getFaceLoginUid());
                    jSONObject.put("queryRes", SapiContext.getInstance(SapiWebView.this.getContext()).getFaceLoginContainHashJson());
                } catch (Exception e2) {
                    Log.e(e2);
                }
                SapiWebView.this.aM.confirm(jSONObject.toString());
                return null;
            }
        });
        this.G.put("sapi_action_account_destroy", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.35
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.am != null) {
                    SapiWebView.this.am.onAccountDestory(new AccountDestoryCallback.AccountDestoryResult());
                }
                SapiWebView.this.finish();
                return null;
            }
        });
        this.G.put("sapi_biometrics_identification_with_uid", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.36
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.ah != null) {
                    BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new BioScanFaceCallback.BioScanFaceResult() { // from class: com.baidu.sapi2.SapiWebView.36.1
                        @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                        public void setScanFaceIdentifyResult(String str) {
                            SapiWebView.this.aM.confirm(str);
                        }
                    };
                    try {
                        JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                        bioScanFaceResult.uid = jSONObject.optString("uid");
                        bioScanFaceResult.type = jSONObject.optInt("type");
                        bioScanFaceResult.subpro = jSONObject.optString("subpro");
                        bioScanFaceResult.showGuidePage = 1 - jSONObject.optInt("hideGuidePage", 0);
                        if (TextUtils.isEmpty(bioScanFaceResult.subpro)) {
                            bioScanFaceResult.subpro = SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                bioScanFaceResult.transParamsList.add(new BasicNameValuePair(next, optJSONObject.optString(next)));
                            }
                        }
                        SapiWebView.this.ah.onBioScanFace(bioScanFaceResult);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
                return null;
            }
        });
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.ar.b) {
            loadWeixinSSOLogin(this.ar.c, this.ar.d);
        } else if (this.ar.a != null) {
            loadUrl(this.ar.a);
        } else {
            super.reload();
        }
        this.ar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ReloadConfig {
        String a;
        boolean b;
        boolean c;
        String d;

        private ReloadConfig() {
            this.a = null;
            this.b = false;
        }

        void a() {
            this.a = null;
            this.b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SmsHandler extends Handler {
        String a;
        String b;

        private SmsHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj != null) {
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                    SapiWebView.this.loadUrl(String.format("javascript:%s('%s','%s');", this.a, str, this.b));
                }
                SapiWebView.this.j();
                removeCallbacks(SapiWebView.this.aC);
            }
        }
    }

    /* loaded from: classes.dex */
    private class SendUpwardSms {
        static final String a = "收不到短信验证码?";
        static final String b = "我们邀请您发送一条短信至百度账号后台（10698000036592）以验证您的身份，预计花费0.1元短信费用";
        static final String c = "确定";
        static final String d = "发送上行短信";
        static final String e = "10698000036592";
        static final String f = "SENT_SMS_ACTION";
        String g;
        String h;
        String i;
        String j;
        UpwardSmsCallback k;
        boolean l;
        boolean m;
        Runnable n;
        private BroadcastReceiver p;

        private SendUpwardSms(String str, String str2, String str3, String str4, UpwardSmsCallback upwardSmsCallback) {
            this.l = false;
            this.m = false;
            this.n = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SendUpwardSms.1
                @Override // java.lang.Runnable
                public void run() {
                    SendUpwardSms.this.d();
                    SendUpwardSms.this.f();
                }
            };
            this.p = new BroadcastReceiver() { // from class: com.baidu.sapi2.SapiWebView.SendUpwardSms.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    SapiWebView.this.removeCallbacks(SendUpwardSms.this.n);
                    SendUpwardSms.this.d();
                    if (getResultCode() != -1) {
                        SendUpwardSms.this.f();
                        return;
                    }
                    SendUpwardSms.this.l = true;
                    SendUpwardSms.this.m = true;
                    SendUpwardSms.this.k.onResult(SendUpwardSms.this.l, SendUpwardSms.this.m, false);
                }
            };
            if (TextUtils.isEmpty(str)) {
                this.g = "10698000036592";
            } else {
                this.g = str;
            }
            if (TextUtils.isEmpty(str2)) {
                this.h = d;
            } else {
                this.h = str2;
            }
            if (TextUtils.isEmpty(str3)) {
                this.i = a;
            } else {
                this.i = str3;
            }
            if (TextUtils.isEmpty(str4)) {
                this.j = b;
            } else {
                this.j = str4;
            }
            this.k = upwardSmsCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Build.VERSION.SDK_INT >= 23 && SapiWebView.this.getContext().checkSelfPermission("android.permission.SEND_SMS") == -1) {
                f();
            } else if (Build.VERSION.SDK_INT < 23 && SapiWebView.this.getContext().checkCallingOrSelfPermission("android.permission.SEND_SMS") == -1) {
                f();
            } else {
                c();
            }
        }

        private String b() {
            return this.j;
        }

        private void c() {
            AlertDialog.Builder builder = new AlertDialog.Builder(SapiWebView.this.getContext(), 3);
            builder.setTitle(this.i);
            builder.setMessage(b());
            builder.setPositiveButton(c, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.SendUpwardSms.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!SendUpwardSms.this.e()) {
                        SendUpwardSms.this.f();
                    }
                }
            });
            builder.setNegativeButton(SapiWebView.E, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.SendUpwardSms.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SendUpwardSms.this.k.onResult(false, false, true);
                }
            });
            builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.sapi2.SapiWebView.SendUpwardSms.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    SendUpwardSms.this.k.onResult(false, false, true);
                }
            });
            AlertDialog create = builder.create();
            if (!((Activity) SapiWebView.this.getContext()).isFinishing() && !create.isShowing()) {
                create.show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.p != null) {
                try {
                    SapiWebView.this.getContext().unregisterReceiver(this.p);
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiWebView.this.getContext(), 0, new Intent(f), 0);
            SapiWebView.this.getContext().registerReceiver(this.p, new IntentFilter(f));
            try {
                SmsManager.getDefault().sendTextMessage(this.g, null, this.h, broadcast, null);
                SapiWebView.this.postDelayed(this.n, 500L);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            if (SapiWebView.this.ap != null) {
                SystemUpwardSmsCallback.Result result = new SystemUpwardSmsCallback.Result() { // from class: com.baidu.sapi2.SapiWebView.SendUpwardSms.6
                    @Override // com.baidu.sapi2.SapiWebView.SystemUpwardSmsCallback.Result
                    public void onFinish() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("with_permision", false);
                            jSONObject.put("send_suc", false);
                            jSONObject.put("cancel", false);
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                        if (SapiWebView.this.aM != null) {
                            SapiWebView.this.aM.confirm(jSONObject.toString());
                        }
                        SendUpwardSms.this.k.onResult(SendUpwardSms.this.l, SendUpwardSms.this.m, false);
                    }
                };
                result.content = this.h;
                result.destination = this.g;
                SapiWebView.this.ap.onResult(result);
            }
        }
    }

    public String getUaInfo() {
        return "Sapi_8.2.1_Android_" + SapiUtils.getAppName(getContext()) + "_" + SapiUtils.getVersionName(getContext()) + "_" + (!TextUtils.isEmpty(Build.MODEL) ? Build.MODEL : "") + "_" + (!TextUtils.isEmpty(Build.VERSION.RELEASE) ? Build.VERSION.RELEASE : "") + "_Sapi";
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void e() {
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            Log.e(e2);
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " " + getUaInfo());
        getSettings().setDomStorageEnabled(true);
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.37
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
        if ((this.as == null || this.as.getVisibility() != 0) && (this.at == null || this.at.getVisibility() != 0)) {
            return super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z2);
        }
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        if ((this.as != null && this.as.getVisibility() == 0) || (this.at != null && this.at.getVisibility() == 0)) {
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

    public void asyncNaLifeCycle2H5(ActivityLifeCycle activityLifeCycle) {
        if (!getSettings().getBlockNetworkLoads()) {
            loadUrl(b(activityLifeCycle.a));
        }
    }

    private String b(String str) {
        return String.format("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.%s){ Pass.client.%s()}}())", str, str);
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.I = authorizationListener;
    }

    public void setQrAppLoginHandler(Handler handler) {
        this.K = handler;
    }

    public void setFastRegHandler(FastRegHandler fastRegHandler) {
        this.L = fastRegHandler;
    }

    public void setVoiceLoginHandler(VoiceLoginHandler voiceLoginHandler) {
        this.M = voiceLoginHandler;
    }

    public void setNmLoginHandler(NMLoginHandler nMLoginHandler) {
        this.N = nMLoginHandler;
    }

    public void setLcLoginHandler(LCLoginHandler lCLoginHandler) {
        this.O = lCLoginHandler;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.Q = weixinHandler;
    }

    public void setHuaweiHandler(HuaweiHandler huaweiHandler) {
        this.R = huaweiHandler;
    }

    public void setMeizuHandler(MeizuHandler meizuHandler) {
        this.S = meizuHandler;
    }

    public void setUniteVerifyHandler(UniteVerifyHandler uniteVerifyHandler) {
        this.P = uniteVerifyHandler;
    }

    public void setLoadExternalWebViewCallback(LoadExternalWebViewCallback loadExternalWebViewCallback) {
        this.V = loadExternalWebViewCallback;
    }

    public void setFileChooserCallback(FileChooserCallback fileChooserCallback) {
        this.W = fileChooserCallback;
    }

    public void setPickPhotoCallback(PickPhotoCallback pickPhotoCallback) {
        this.aa = pickPhotoCallback;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.ab = changePwdCallback;
    }

    public void setAuthWidgetCallback(AuthWidgetCallback authWidgetCallback) {
        this.ac = authWidgetCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.ad = bindWidgetCallback;
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.ae = uniteVerifyCallback;
    }

    public void setRealnameAuthenticateCallback(RealnameAuthenticateCallback realnameAuthenticateCallback) {
        this.ao = realnameAuthenticateCallback;
    }

    public void setSystemUpwardSmsCallback(SystemUpwardSmsCallback systemUpwardSmsCallback) {
        this.ap = systemUpwardSmsCallback;
    }

    public void setSocialBindHandler(Handler handler) {
        this.U = handler;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.J = handler;
    }

    public void setWebViewTitleCallback(WebViewTitleCallback webViewTitleCallback) {
        this.af = webViewTitleCallback;
    }

    public void setBiometricsIdentifyCallback(BiometricsIdentifyCallback biometricsIdentifyCallback) {
        this.ag = biometricsIdentifyCallback;
    }

    public void setBioScanFaceCallback(BioScanFaceCallback bioScanFaceCallback) {
        this.ah = bioScanFaceCallback;
    }

    public void setCoverWebBdussCallback(CoverWebBdussCallback coverWebBdussCallback) {
        this.ai = coverWebBdussCallback;
    }

    public void setSwitchAccountCallback(SwitchAccountCallback switchAccountCallback) {
        this.aj = switchAccountCallback;
    }

    public void setPreFillUserNameCallback(PreFillUserNameCallback preFillUserNameCallback) {
        this.ak = preFillUserNameCallback;
    }

    public void setBdussChangeCallback(BdussChangeCallback bdussChangeCallback) {
        this.al = bdussChangeCallback;
    }

    public void setAccountDestoryCallback(AccountDestoryCallback accountDestoryCallback) {
        this.am = accountDestoryCallback;
    }

    public void setLeftBtnVisibleCallback(LeftBtnVisibleCallback leftBtnVisibleCallback) {
        this.an = leftBtnVisibleCallback;
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
        if (this.H.supportFaceLogin && this.ag == null && i2 == 0) {
            throw new RuntimeException("face login is support, but the biometricsIdentifyCallback is null");
        }
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            a(i2, list, this.H.customActionBarEnabled);
            return;
        }
        String faceLoginHash = SapiContext.getInstance(getContext()).getFaceLoginHash();
        String a2 = a(SapiAccountManager.getInstance().getAccountService().a(), list);
        switch (i2) {
            case 0:
                if (this.V != null) {
                    a2 = a2 + "&enableExternalWeb=1";
                }
                if (this.H.supportFaceLogin) {
                    a2 = a2 + "&liveAbility=1";
                }
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_LOGIN, IEventCenterService.EventResult.PHASE.START);
                if (TextUtils.isEmpty(faceLoginHash) || !this.H.supportFaceLogin) {
                    loadUrl(a2 + m);
                    return;
                } else {
                    loadUrl(a2 + "#" + faceLoginHash);
                    return;
                }
            case 1:
                if (this.V != null) {
                    a2 = a2 + "&enableExternalWeb=1";
                }
                if (this.H.supportFaceLogin) {
                    a2 = a2 + "&liveAbility=1";
                }
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_SMS_LOGIN, IEventCenterService.EventResult.PHASE.START);
                if (SapiContext.getInstance(getContext()).smsFaceLoginEnable() && !TextUtils.isEmpty(faceLoginHash) && this.H.supportFaceLogin) {
                    loadUrl(a2 + "#" + faceLoginHash);
                    return;
                } else {
                    loadUrl(a2 + q);
                    return;
                }
            case 2:
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG, IEventCenterService.EventResult.PHASE.START);
                if (this.L != null) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.38
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.L != null) {
                                SapiWebView.this.L.handleFastReg();
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

    public void loadLoginWithUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            loadLogin();
            return;
        }
        String str2 = "";
        try {
            str2 = "disusername=" + URLEncoder.encode(str, j);
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&" + str2 + n);
        } else {
            loadLogin();
        }
    }

    @Deprecated
    public void loadSmsLogin() {
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            f();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + q);
        }
    }

    public void loadQuickLogin(QuickLoginHandler quickLoginHandler) {
        if (quickLoginHandler == null) {
            throw new IllegalArgumentException(QuickLoginHandler.class.getSimpleName() + " can't be null");
        }
        this.T = quickLoginHandler;
        a(3, (List<NameValuePair>) null, true);
    }

    private void f() {
        a(0, (List<NameValuePair>) null, this.H.customActionBarEnabled);
    }

    private void a(int i2, List<NameValuePair> list, boolean z2) {
        String str;
        String a2 = SapiAccountManager.getInstance().getAccountService().a();
        if (z2 && !this.H.customActionBarEnabled) {
            a2 = a2 + "&adapter=3";
        }
        if (this.V != null) {
            a2 = a2 + "&enableExternalWeb=1";
        }
        if (this.ag != null) {
            a2 = a2 + "&liveAbility=1";
        }
        if (TextUtils.isEmpty(SapiContext.getInstance(getContext()).getFaceLoginHash()) || this.ag == null) {
            str = a2 + "&loginInitType=" + a(i2);
        } else {
            str = a2 + "&loginInitType=4";
        }
        loadUrl(a(str, list) + p);
    }

    private int a(int i2) {
        if (i2 == 0) {
            return this.H.smsLoginConfig.flagLoginBtnType.ordinal();
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
        this.aK = sapiCallback;
        loadUrl(str);
    }

    public void loadRegist() {
        loadRegist(null);
    }

    public void loadRegist(List<NameValuePair> list) {
        String a2 = SapiAccountManager.getInstance().getAccountService().a();
        if (this.H.quickUserEnabled && this.H.registMode == RegistMode.QUICK_USER) {
            a2 = a2.replace("regtype=2", "regtype=1");
        }
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG, IEventCenterService.EventResult.PHASE.START);
        loadUrl(a(a2, list) + o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, List<NameValuePair> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    try {
                        arrayList.add(new BasicNameValuePair(URLEncoder.encode(nameValuePair.getName(), j), URLEncoder.encode(nameValuePair.getValue(), j)));
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

    public void loadQuickUserReg() {
        loadQuickUserReg(null);
    }

    public void loadQuickUserReg(List<NameValuePair> list) {
        if (!this.H.quickUserEnabled) {
            loadRegist(list);
            return;
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a();
        if (this.H.registMode != RegistMode.QUICK_USER) {
            a2 = a2 + "&regtype=2";
        }
        loadUrl(a(a2, list) + o);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + d + "=" + h, j)));
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new BasicNameValuePair("skin", str2));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String c2 = SapiAccountManager.getInstance().getAccountService().c();
        if (arrayList.size() > 0) {
            c2 = c2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String a2 = a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled()), a2));
        loadUrl(c2, arrayList2);
        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_CHANGE_PWD, IEventCenterService.EventResult.PHASE.START);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadExternalUrl(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("externalUrl can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", "native"));
        arrayList.add(new BasicNameValuePair("client", "android"));
        arrayList.add(new BasicNameValuePair("deliverParams", "1"));
        List<BiometricType> list = this.H.biometricTypeList;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) == BiometricType.LIVENESS_RECOG) {
                arrayList.add(new BasicNameValuePair("scanface", "1"));
            } else if (list.get(i2) == BiometricType.VOICE_IDENTIFY) {
                arrayList.add(new BasicNameValuePair("voiceidentify", "1"));
            }
        }
        if (this.aa != null && this.H.supportPhoto) {
            arrayList.add(new BasicNameValuePair("support_photo", "1"));
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf + 1) + SapiUtils.createRequestParams(arrayList) + "&" + str.substring(indexOf + 1, str.length());
        } else {
            str2 = str + "?" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(str2);
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + d + "=" + g, j)));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new BasicNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String b2 = SapiAccountManager.getInstance().getAccountService().b();
        if (arrayList.size() > 0) {
            b2 = b2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(b2);
    }

    public void loadUserAgreement() {
        loadUrl(this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled()) + "/passport/agreement?adapter=3");
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
        String d2 = SapiAccountManager.getInstance().getAccountService().d();
        if (arrayList.size() > 0) {
            d2 = d2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(d2);
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
        if (this.H.biometricTypeList.contains(BiometricType.LIVENESS_RECOG)) {
            arrayList.add(new BasicNameValuePair("liveAbility", "1"));
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String a3 = a(a2, list);
        String a4 = a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled()), a4));
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
            arrayList.add(new BasicNameValuePair(Constants.EXTRA_KEY_TOKEN, URLEncoder.encode(str2, j)));
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?" + d + "=" + f, j)));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new BasicNameValuePair("skin", str3));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        String e3 = SapiAccountManager.getInstance().getAccountService().e();
        if (arrayList.size() > 0) {
            e3 = e3 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(e3);
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
        String g2 = SapiAccountManager.getInstance().getAccountService().g();
        if (arrayList.size() > 0) {
            g2 = g2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(g2);
    }

    public void loadRealnameAuthenticate(final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(this.H.realnameAuthenticateStoken)) {
            throw new IllegalArgumentException("realnameAuthenticateStoken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(QR_FACE_AUTH_PASS_PRODUCT_ID);
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiWebView.39
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String i2 = SapiAccountManager.getInstance().getAccountService().i();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new BasicNameValuePair("bduss", str));
                arrayList2.add(new BasicNameValuePair(ISapiAccount.SAPI_ACCOUNT_STOKEN, getTplStokenResult.tplStokenMap.get(SapiWebView.QR_FACE_AUTH_PASS_PRODUCT_ID)));
                arrayList2.add(new BasicNameValuePair("bdstoken", SapiWebView.this.H.realnameAuthenticateStoken));
                SapiWebView.this.loadUrl(i2 + "&" + SapiUtils.createRequestParams(arrayList2) + "#idcardverify");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                if (SapiWebView.this.ao != null) {
                    SapiWebView.this.ao.onFailure();
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
            arrayList.add(new BasicNameValuePair(Constants.EXTRA_KEY_TOKEN, URLEncoder.encode(str, j)));
            if (str2 != null) {
                arrayList.add(new BasicNameValuePair("u", str2));
            }
            if (str3 != null) {
                arrayList.add(new BasicNameValuePair("adtext", URLEncoder.encode(str3, j)));
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e(e2);
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().f() + "&" + SapiUtils.createRequestParams(arrayList));
    }

    public void loadFastReg() {
        loadFastReg(null);
    }

    public void loadFastReg(List<NameValuePair> list) {
        if (!SapiUtils.isSimReady(getContext()) || !SapiUtils.hasActiveNetwork(getContext())) {
            loadUrl(a(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0", list) + q);
            return;
        }
        loadUrl(a(SapiAccountManager.getInstance().getAccountService().a(), list) + r);
        this.aI = new FastRegAction();
        this.aI.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.aJ = sapiAccountResponse;
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + s);
    }

    public void loadAccountCenter(String str) {
        loadAccountCenter(null, str);
    }

    public void loadAccountCenter(List<NameValuePair> list, String str) {
        a(list, str, false);
    }

    private void a(List<NameValuePair> list, String str, boolean z2) {
        b(getContext(), str);
        String a2 = SapiAccountManager.getInstance().getAccountService().a(z2);
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.aa != null && this.H.supportPhoto) {
            list.add(new BasicNameValuePair("support_photo", "1"));
        }
        if (this.ag != null && this.H.supportFaceLogin) {
            list.add(new BasicNameValuePair("supFaceLogin", "1"));
        }
        loadUrl(a(a2, list));
    }

    public void loadAccountRealName(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("okU", SapiHost.getHost(SapiHost.ACTION_INTERCEPT_URL)));
        a((List<NameValuePair>) arrayList, str, true);
    }

    public boolean notifyKefuBack() {
        boolean z2 = this.aR;
        if (this.aR) {
            loadUrl(aH);
            this.aR = false;
        }
        return z2;
    }

    public void preSetUserName(String str) {
        loadUrl("javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.fillLoginNameFn){Pass.client.fillLoginNameFn('" + str + "')}}())");
    }

    public long getTimeoutMillis() {
        return this.ax;
    }

    public void setTimeoutMillis(long j2) {
        this.ax = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<NameValuePair> list) {
        SapiUtils.syncCookies(getContext(), list);
        b();
        String a2 = SapiCache.a(getContext(), str);
        String a3 = !TextUtils.isEmpty(a2) ? a(a2, str) : str;
        String a4 = a(a2);
        if (!TextUtils.isEmpty(a4)) {
            loadDataWithBaseURL(a3, a4, i, j, a3);
        } else {
            c(a3);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        if (Build.VERSION.SDK_INT > 7) {
            getSettings().setBlockNetworkLoads(true);
        }
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.40
            @Override // java.lang.Runnable
            public void run() {
                String str6;
                String[] split = str.split("#");
                if (split != null && split.length > 0) {
                    str6 = split[0] + "&loadDataWithBaseUrl=1#" + split[1];
                } else {
                    str6 = str + "&loadDataWithBaseUrl=1";
                }
                SapiWebView.super.loadDataWithBaseURL(str6, str2, str3, str4, str5);
            }
        });
    }

    public void back() {
        if (this.aN != null) {
            loadUrl(this.aN);
        } else if (this.aO) {
            finish();
        } else if (this.aF != null) {
            SapiUtils.hideSoftInput((Activity) getContext());
            this.aF.onBack();
        } else {
            b(this.aJ);
            super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
            a(this.aL);
        }
        if ((this.as != null && this.as.getVisibility() == 0) || (this.at != null && this.at.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        j();
        if (this.aI != null) {
            this.aI.f = true;
            this.aI.k.removeCallbacks(this.aI.l);
        }
        if (this.aD != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.41
                @Override // java.lang.Runnable
                public void run() {
                    if (SapiWebView.this.aD != null) {
                        SapiUtils.hideSoftInput((Activity) SapiWebView.this.getContext());
                        SapiWebView.this.aD.onFinish();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FINISH, IEventCenterService.EventResult.PHASE.SUCCESS);
                    }
                }
            });
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (this.aq != null) {
            this.aq.authorizeCallBack(i2, i3, intent);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.aQ == 1) {
            if (this.aR) {
                notifyKefuBack();
                return true;
            }
            if (this.aE != null) {
                this.aE.onBack();
            }
            back();
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ConfigFastloginFeaturesInterpreter extends AbstractInterpreter {
        ConfigFastloginFeaturesInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            List<FastLoginFeature> list = SapiWebView.this.H.fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance(SapiWebView.this.getContext()).isHostsHijacked()) {
                return sb.toString();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    FastLoginFeature fastLoginFeature = list.get(i2);
                    if (i2 == 0) {
                        sb.append(fastLoginFeature.getStrValue());
                    } else {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(fastLoginFeature.getStrValue());
                    }
                    i = i2 + 1;
                } else {
                    return sb.toString();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class FeifanWebviewInterpreter extends AbstractInterpreter {
        FeifanWebviewInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.WANDA_FEIFAN.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChuankeWebviewInterpreter extends AbstractInterpreter {
        ChuankeWebviewInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.CHUANKE.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SinaSSOInterpreter extends AbstractInterpreter {
        SinaSSOInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            SapiWebView.this.a(false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class WeiXinSSOInterpreter extends AbstractInterpreter {
        WeiXinSSOInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MeiZuSSOInterpreter extends AbstractInterpreter {
        MeiZuSSOInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.MEIZU.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class QzoneWebviewInterpreter extends AbstractInterpreter {
        QzoneWebviewInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.QZONE.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class TXWeiboWebviewInterpreter extends AbstractInterpreter {
        TXWeiboWebviewInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.TENCENT_WEIBO.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SinaWeiboWebviewInterpreter extends AbstractInterpreter {
        SinaWeiboWebviewInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class HuaweiSSOintrpreter extends AbstractInterpreter {
        HuaweiSSOintrpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.J != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                SapiWebView.this.J.sendMessage(message);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class QRcodeLoginInterpreter extends AbstractInterpreter {
        QRcodeLoginInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.K != null) {
                SapiWebView.this.K.sendMessage(new Message());
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class NuomiLoginInterpreter extends AbstractInterpreter {
        NuomiLoginInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.N != null) {
                SapiWebView.this.N.handleNMLogin();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LecaiLoginInterpreter extends AbstractInterpreter {
        LecaiLoginInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.O != null) {
                SapiWebView.this.O.handleLCLogin();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class VoiceLoginInterpreter extends AbstractInterpreter {
        VoiceLoginInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.M != null) {
                SapiWebView.this.M.handleVoiceLogin();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class UniteVerifyInterpreter extends AbstractInterpreter {
        UniteVerifyInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            String str = command.getActionParams().get(0);
            if (SapiWebView.this.P != null && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    SapiWebView.this.P.handleUniteVerify(jSONObject.optString(Constants.EXTRA_KEY_TOKEN), jSONObject.optString("adtext"));
                    return null;
                } catch (JSONException e) {
                    Log.e(e);
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AuthorizedResponseInterpreter extends AbstractInterpreter {
        AuthorizedResponseInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            String str = command.getActionParams().get(0);
            int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
            if (parseInt == 1) {
                SocialResponse b = SapiWebView.b(str, SapiWebView.this.getContext());
                if (b == null) {
                    if (SapiWebView.this.I != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.AuthorizedResponseInterpreter.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.I != null) {
                                    SapiWebView.this.I.onFailed(-100, "登录失败");
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                                }
                            }
                        });
                    }
                } else if (b.offlineNotice || b.bindGuide || b.errorCode == 21 || b.bindConflict) {
                    SapiWebView.this.aL = b;
                } else {
                    SapiWebView.this.a(b);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a = SapiWebView.a(str, SapiWebView.this.getContext());
                if (a == null) {
                    if (SapiWebView.this.I != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.AuthorizedResponseInterpreter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.I != null) {
                                    SapiWebView.this.I.onFailed(-100, "登录失败");
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                                }
                            }
                        });
                        return null;
                    }
                    return null;
                } else if (SapiWebView.this.aI != null && a.newReg) {
                    SapiWebView.this.aJ = a;
                    SapiWebView.this.a(a);
                    return null;
                } else if (a.errorCode == 0 || a.errorCode == 110000) {
                    SapiWebView.this.b(a);
                    return null;
                } else if (SapiWebView.this.I != null) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.AuthorizedResponseInterpreter.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.I != null) {
                                SapiWebView.this.I.onFailed(a.errorCode, a.errorMsg);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                            }
                        }
                    });
                    return null;
                } else {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ShareStrategyConfigInterpreter extends AbstractInterpreter {
        ShareStrategyConfigInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            return SapiWebView.this.H.loginShareStrategy().getStrValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ShareAccountsConfigInterpreter extends AbstractInterpreter {
        ShareAccountsConfigInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            JSONArray jSONArray = SapiAccount.toJSONArray(SapiAccountManager.getInstance().getShareAccounts());
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ShareAccountsRemoveInterpreter extends AbstractInterpreter {
        ShareAccountsRemoveInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            String str = command.getActionParams().get(0);
            if (!TextUtils.isEmpty(str)) {
                Iterator<SapiAccount> it = SapiAccountManager.getInstance().getShareAccounts().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (str.equals(next.uid)) {
                        com.baidu.sapi2.share.a.a().b(next);
                        break;
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class UniteVerifyResultInterpreter extends AbstractInterpreter {
        UniteVerifyResultInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString(LoginActivityConfig.INFO);
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString("passuid");
                sapiAccount.username = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_USERNAME);
                sapiAccount.displayname = jSONObject.optString("displayname");
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                sapiAccount.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
                if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount) && SapiWebView.this.ae != null) {
                    SapiWebView.this.ae.onSuccess(optString, optString2, sapiAccount);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_UNITEVERIFY, IEventCenterService.EventResult.PHASE.SUCCESS);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    static SapiAccountResponse a(String str, Context context) {
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
                newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), j);
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
                                    } else if (name.equalsIgnoreCase(LoginActivityConfig.ACCOUNT)) {
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
                                        SapiContext.getInstance(context).setFaceLoginUid(URLDecoder.decode(newPullParser.nextText()));
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3698=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SocialResponse b(String str, Context context) {
        SocialResponse socialResponse;
        SocialResponse socialResponse2 = null;
        String b2 = b("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(b2)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(b2.getBytes()), j);
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
                                        SapiContext.getInstance(context).setFaceLoginUid(URLDecoder.decode(newPullParser.nextText()));
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
    public void g() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.42
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.au != null) {
                    SapiWebView.this.au.setVisibility(8);
                }
                SapiWebView.this.ar.a = SapiWebView.this.az.b;
                if (SapiWebView.this.at != null) {
                    SapiWebView.this.at.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.43
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.au != null) {
                    SapiWebView.this.au.setVisibility(8);
                }
                if (SapiWebView.this.as != null) {
                    SapiWebView.this.as.setVisibility(0);
                }
            }
        });
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
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.x, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleServerError(String str) {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.w, 1).show();
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
    public class DefaultMeizuHandler implements MeizuHandler {
        public DefaultMeizuHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.MeizuHandler
        public void handleMeizuLoginFailure() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.z, 1).show();
            SapiWebView.this.finish();
        }
    }

    public void loadSinaSSOLogin() {
        a(true);
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.H.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(this.H.environment.getURL(SapiUtils.getDefaultHttpsEnabled()), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    void a(final boolean z2) {
        this.aq = new SsoHandler((Activity) getContext(), SapiEnv.SINA_APP_KEY, SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL));
        this.aq.authorize(new SSOListener() { // from class: com.baidu.sapi2.SapiWebView.44
            public void onComplete(Bundle bundle) {
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.SINA_WEIBO, bundle.getString("access_token"), bundle.getString("uid")));
            }

            public void onJumpNormal() {
                if (SapiWebView.this.J != null) {
                    Message message = new Message();
                    message.what = SocialType.SINA_WEIBO.getType();
                    SapiWebView.this.J.sendMessage(message);
                }
            }

            public void onError(SSOError sSOError) {
                Log.e(sSOError);
                Toast.makeText(SapiWebView.this.getContext(), sSOError.getMessage(), 0).show();
            }

            public void onCancel() {
                if (z2 && (SapiWebView.this.getContext() instanceof Activity)) {
                    ((Activity) SapiWebView.this.getContext()).finish();
                }
            }
        });
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.45
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.u, 0).show();
                }
            });
        }
    }

    public void loadWeixinSSOLogin(final boolean z2, final String str) {
        if (!WXAPIFactory.createWXAPI(getContext(), this.H.wxAppID).isWXAppInstalled()) {
            if (this.Q != null) {
                this.Q.handleNotInstall();
                return;
            }
            return;
        }
        new AsyncHttpClient().get(getContext(), SapiAccountManager.getInstance().getAccountService().a(z2, str), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiWebView.46
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                try {
                    SapiWebView.this.av = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                if (SapiWebView.this.av != null) {
                    try {
                        SapiWebView.this.av.dismiss();
                    } catch (Throwable th) {
                        Log.e(th);
                    }
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (SapiWebView.this.as != null) {
                    SapiWebView.this.ar.b = true;
                    SapiWebView.this.ar.c = z2;
                    SapiWebView.this.ar.d = str;
                    SapiWebView.this.as.setVisibility(0);
                    return;
                }
                SapiWebView.this.Q.handleServerError(str2);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i2, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("mkey", "");
                    if (!TextUtils.isEmpty(optString)) {
                        SendAuth.Req req = new SendAuth.Req();
                        req.scope = "snsapi_userinfo";
                        req.state = optString;
                        WXAPIFactory.createWXAPI(SapiWebView.this.getContext(), SapiWebView.this.H.wxAppID).sendReq(req);
                        SapiWebView.this.finish();
                    } else {
                        String optString2 = jSONObject.optString("error_code", "");
                        if (SapiWebView.this.Q != null) {
                            SapiWebView.this.Q.handleServerError(optString2);
                        }
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        });
    }

    public void loadWeixinSSOLogin() {
        loadWeixinSSOLogin(false, null);
    }

    public void loadXiaomiSSOLogin() {
        loadXiaomiSSOLogin(null);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.baidu.sapi2.SapiWebView$47] */
    public void loadXiaomiSSOLogin(final List<NameValuePair> list) {
        final XiaomiOAuthFuture startGetAccessToken = new XiaomiOAuthorize().setAppId(this.H.xiaomiAppID.longValue()).setRedirectUrl(this.H.xiaomiRedirectUri).setScope(new int[]{1, 3, 4}).startGetAccessToken((Activity) getContext());
        new Thread() { // from class: com.baidu.sapi2.SapiWebView.47
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3 = null;
                try {
                    XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) startGetAccessToken.getResult();
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.47.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                SapiWebView.this.av = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                        }
                    });
                    if (xiaomiOAuthResults == null || xiaomiOAuthResults.getAccessToken() == null) {
                        SapiWebView.this.l();
                        SapiWebView.this.finish();
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject((String) new XiaomiOAuthorize().callOpenApi(SapiWebView.this.getContext(), SapiWebView.this.H.xiaomiAppID.longValue(), "/user/profile", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult());
                        String optString = jSONObject.optString("result");
                        if ("ok".equals(optString)) {
                            str2 = jSONObject.getJSONObject("data").optString("userId");
                        } else if ("error".equals(optString)) {
                            Log.e(jSONObject.optString("description") + "(" + jSONObject.optString("code") + ")", new Object[0]);
                            SapiWebView.this.l();
                            SapiWebView.this.finish();
                            return;
                        } else {
                            str2 = null;
                        }
                        str = str2;
                    } catch (Exception e2) {
                        SapiWebView.this.l();
                        SapiWebView.this.finish();
                        Log.e(e2);
                        str = null;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject((String) new XiaomiOAuthorize().callOpenApi(SapiWebView.this.getContext(), SapiWebView.this.H.xiaomiAppID.longValue(), "/user/phone", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult());
                        String optString2 = jSONObject2.optString("result");
                        if ("ok".equals(optString2)) {
                            str3 = jSONObject2.getJSONObject("data").optString(ISapiAccount.SAPI_ACCOUNT_PHONE);
                        } else if ("error".equals(optString2)) {
                            Log.e(jSONObject2.optString("description") + "(" + jSONObject2.optString("code") + ")", new Object[0]);
                            SapiWebView.this.l();
                            SapiWebView.this.finish();
                            return;
                        }
                    } catch (Exception e3) {
                        SapiWebView.this.l();
                        SapiWebView.this.finish();
                        Log.e(e3);
                    }
                    SapiWebView.this.loadUrl(SapiWebView.this.a(SapiAccountManager.getInstance().getAccountService().a(xiaomiOAuthResults.getAccessToken(), str, str3), list));
                    SapiWebView.this.l();
                } catch (Exception e4) {
                    Log.e(e4);
                    SapiWebView.this.finish();
                }
            }
        }.start();
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            Toast.makeText(getContext(), u, 0).show();
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
        String a2 = a(SapiAccountManager.getInstance().getAccountService().a(str, str2, z2), list);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BasicNameValuePair(this.H.environment.getURL(SapiUtils.getDefaultHttpsEnabled()), "mkey=" + str2 + ";domain=." + this.H.environment.getURL(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/;httponly"));
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
        OpenHwID.setLoginProxy(activity, this.H.hwAppId, iHwIDCallBack, bundle);
    }

    public void loadHuaWeiSSOLogin() {
        loadHuaWeiSSOLogin(null);
    }

    public void loadHuaWeiSSOLogin(final List<NameValuePair> list) {
        if (getContext() instanceof Activity) {
            a((Activity) getContext(), false, new IHwIDCallBack() { // from class: com.baidu.sapi2.SapiWebView.48
                public void onUserInfo(HashMap hashMap) {
                    String obj = hashMap.get("loginStatus").toString();
                    if (obj != null && obj.equals("11")) {
                        SapiWebView.this.a(list);
                    } else if (obj != null && obj.equals("9")) {
                        Toast.makeText(SapiWebView.this.getContext(), "请下载华为移动服务APP并安装", 0).show();
                    } else {
                        Toast.makeText(SapiWebView.this.getContext(), "请下载华为移动服务APP并安装", 0).show();
                    }
                }
            }, this.H.hwLoginChannelId);
            OpenHwID.initial(getContext(), new Bundle());
            return;
        }
        throw new IllegalStateException("context not Activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<NameValuePair> list) {
        if (getContext() instanceof Activity) {
            a((Activity) getContext(), false, new IHwIDCallBack() { // from class: com.baidu.sapi2.SapiWebView.49
                public void onUserInfo(HashMap hashMap) {
                    try {
                        String str = (String) hashMap.get("accesstoken");
                        String str2 = (String) hashMap.get("userID");
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            if (SapiWebView.this.R == null) {
                                SapiWebView.this.R = new DefaultHuaweiHandler();
                            }
                            SapiWebView.this.R.handleHuaweiLoginFailure();
                            return;
                        }
                        SapiWebView.this.loadUrl(SapiWebView.this.a(SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, SapiWebView.j), URLEncoder.encode(str2, SapiWebView.j)), list));
                    } catch (UnsupportedEncodingException e2) {
                        Log.e(e2);
                    }
                }
            }, this.H.hwLoginChannelId);
            OpenHwID.login(new Bundle());
            if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.50
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(SapiWebView.this.getContext(), SapiWebView.u, 0).show();
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalStateException("context not Activity");
    }

    public void loadHuaWeiSSOLogin(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("AccessToken or uid can't be null");
        }
        String str3 = null;
        try {
            str3 = SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, j), URLEncoder.encode(str2, j));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        loadUrl(str3);
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.51
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.u, 0).show();
                }
            });
        }
    }

    public void loadMeizuSSOLogin() {
        loadMeizuSSOLogin(null);
    }

    public void loadMeizuSSOLogin(final List<NameValuePair> list) {
        if (getContext() instanceof Activity) {
            new MzAuthenticator(this.H.mzAppID, this.H.meizuRedirectUri).requestImplictAuth((Activity) getContext(), "uc_basic_info", new ImplictCallback() { // from class: com.baidu.sapi2.SapiWebView.52
                public void onError(OAuthError oAuthError) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.52.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.S == null) {
                                SapiWebView.this.S = new DefaultMeizuHandler();
                            }
                            SapiWebView.this.S.handleMeizuLoginFailure();
                        }
                    });
                }

                public void onGetToken(OAuthToken oAuthToken) {
                    String accessToken = oAuthToken.getAccessToken();
                    String openId = oAuthToken.getOpenId();
                    if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId)) {
                        if (SapiWebView.this.S == null) {
                            SapiWebView.this.S = new DefaultMeizuHandler();
                        }
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.52.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.S.handleMeizuLoginFailure();
                            }
                        });
                        return;
                    }
                    String str = null;
                    try {
                        str = SapiAccountManager.getInstance().getAccountService().a(SocialType.MEIZU, URLEncoder.encode(accessToken, SapiWebView.j), URLEncoder.encode(openId, SapiWebView.j));
                    } catch (UnsupportedEncodingException e2) {
                        Log.e(e2);
                    }
                    SapiWebView.this.loadUrl(SapiWebView.this.a(str, list));
                }
            });
            if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
                Toast.makeText(getContext(), u, 0).show();
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
        String a2 = SapiAccountManager.getInstance().getAccountService().a(socialType);
        if (z2) {
            a2 = a2 + "&is_force_login=1";
        }
        loadUrl(a(a2, list));
        if (SapiContext.getInstance(getContext()).isHostsHijacked()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.53
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.u, 0).show();
                }
            });
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.au != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.au.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.au.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void c(final String str) {
        Log.e(SapiWebView.class.getSimpleName(), "url:" + str);
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.54
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.super.loadUrl(str);
            }
        });
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            h();
        }
    }

    /* loaded from: classes.dex */
    public abstract class PickPhotoResult {
        public PickPhotoResult() {
        }

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
    public abstract class CoverWebBdussResult {
        public abstract void setWebBduss(String str);

        public CoverWebBdussResult() {
        }
    }

    /* loaded from: classes.dex */
    public abstract class BiometricsIdentifyResult {
        public static final int ERROR_CODE_CANCEL_VOICE_REG = -401;
        public static final int ERROR_CODE_GET_STOKEN_FAILED = -402;

        public abstract void setIdentifyToken(String str);

        public BiometricsIdentifyResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class AbstractInterpreter {
        public abstract String interpret(Command command);

        AbstractInterpreter() {
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
                    JSONArray optJSONArray = optJSONObject.optJSONArray(LegoListActivityConfig.PARAMS);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            final SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = sapiAccountResponse.uid;
            sapiAccount.bduss = sapiAccountResponse.bduss;
            sapiAccount.displayname = sapiAccountResponse.displayname;
            sapiAccount.stoken = sapiAccountResponse.stoken;
            sapiAccount.ptoken = sapiAccountResponse.ptoken;
            sapiAccount.email = sapiAccountResponse.email;
            sapiAccount.username = sapiAccountResponse.username;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
                sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
                sapiAccount.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(sapiAccountResponse.accountType.getType()));
            }
            SapiContext.getInstance(this.H.context).setAccountActionType(sapiAccountResponse.actionType);
            if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
                sapiAccount.putExtra("stoken_list", new JSONObject(sapiAccountResponse.tplStokenMap));
            }
            SapiContext.getInstance(getContext()).addReloginCredentials(sapiAccountResponse.uid, sapiAccountResponse.reloginCredentials);
            if (this.I != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.55
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (SapiWebView.this.I != null) {
                                SapiWebView.this.I.beforeSuccess(sapiAccount);
                            }
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                        com.baidu.sapi2.share.a.a().a(sapiAccount);
                        SapiWebView.this.a(sapiAccountResponse.accountType);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SocialResponse socialResponse) {
        if (socialResponse != null) {
            final SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = socialResponse.uid;
            sapiAccount.bduss = socialResponse.bduss;
            sapiAccount.displayname = socialResponse.displayname;
            sapiAccount.username = socialResponse.username;
            sapiAccount.stoken = socialResponse.stoken;
            sapiAccount.ptoken = socialResponse.ptoken;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            sapiAccount.addSocialInfo(socialResponse.socialType, socialResponse.socialPortraitUrl);
            sapiAccount.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(socialResponse.accountType.getType()));
            if (!socialResponse.tplStokenMap.isEmpty()) {
                sapiAccount.putExtra("stoken_list", new JSONObject(socialResponse.tplStokenMap));
            }
            SapiContext.getInstance(this.H.context).setAccountActionType(socialResponse.actionType);
            if (SapiUtils.isValidAccount(sapiAccount)) {
                socialResponse.errorCode = 0;
            }
            if (socialResponse.accountCenterFlag && (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000)) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.56
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.loadUrl(socialResponse.nextUrl);
                        com.baidu.sapi2.share.a.a().a(sapiAccount);
                    }
                });
            } else if (this.I != null) {
                if (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.57
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.I != null) {
                                    SapiWebView.this.I.beforeSuccess(sapiAccount);
                                }
                            } catch (Throwable th) {
                                Log.e(th);
                            }
                            com.baidu.sapi2.share.a.a().a(sapiAccount);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.aL = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.58
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.I != null) {
                                SapiWebView.this.I.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.FAILURE);
                            }
                            SapiWebView.this.aL = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (this.I != null) {
            try {
                if (!AuthorizationListener.class.equals(this.I.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.I.onSuccess(accountType);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.SUCCESS, accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.I.onSuccess();
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIWEBVIEW_AUTHORIZATION, IEventCenterService.EventResult.PHASE.SUCCESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                        String i = SapiWebView.this.i();
                        if (!TextUtils.isEmpty(i) && FastRegAction.this.j == 1) {
                            FastRegAction.this.a(i, str);
                        }
                        SapiWebView.this.j();
                        FastRegAction.this.k.removeCallbacks(FastRegAction.this.l);
                    }
                }
            };
            this.l = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.4
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.j();
                    FastRegAction.this.a(SapiWebView.this.i());
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
            if (!SapiUtils.isSimReady(SapiWebView.this.getContext())) {
                e();
            } else if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                if (SapiWebView.this.H.fastRegConfirm) {
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.v).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", SapiWebView.this.getContext()) ? SapiUtils.sendSms(SapiWebView.this.getContext(), FastRegAction.this.d, SapiUtils.getFastRegChannel(SapiWebView.this.getContext())) : false) {
                                FastRegAction.this.g.postDelayed(FastRegAction.this.h, 15000L);
                                FastRegAction.this.e = false;
                                FastRegAction.this.d();
                                return;
                            }
                            FastRegAction.this.e();
                        }
                    }).setNegativeButton(SapiWebView.E, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.q);
                        }
                    }).create();
                    if (!TextUtils.isEmpty(SapiWebView.this.H.fastRegConfirmMsg)) {
                        create.setMessage(SapiWebView.this.H.fastRegConfirmMsg);
                    }
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                    return;
                }
                if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", SapiWebView.this.getContext()) ? SapiUtils.sendSms(SapiWebView.this.getContext(), this.d, SapiUtils.getFastRegChannel(SapiWebView.this.getContext())) : false) {
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
                            SapiWebView.this.b(sapiAccountResponse);
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
            String i = SapiWebView.this.i();
            if (!TextUtils.isEmpty(i)) {
                this.j = 1;
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new SapiCallBack<SapiResponse>() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.8
                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSuccess(SapiResponse sapiResponse) {
                        SapiWebView.this.a(FastRegAction.this.i);
                        FastRegAction.this.k.postDelayed(FastRegAction.this.l, 15000L);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onNetworkFailed() {
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.q);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSystemError(int i2) {
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.q);
                    }
                }, i);
                return;
            }
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.q);
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
                    SapiWebView.this.b(sapiAccountResponse2);
                    SapiWebView.this.finish();
                }

                @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                public void onNetworkFailed() {
                    FastRegAction.this.a(SapiWebView.this.i());
                }

                @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                public void onSystemError(int i) {
                    FastRegAction.this.a(SapiWebView.this.i());
                }
            }, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&username=" + str + SapiWebView.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        String line1Number = SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext()) ? ((TelephonyManager) getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getLine1Number() : null;
        if (TextUtils.isEmpty(line1Number)) {
            return null;
        }
        return line1Number.replace("+86", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.aA == null) {
            this.aA = new SMSReceiver(handler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(this.aA, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.aA != null) {
            try {
                getContext().unregisterReceiver(this.aA);
            } catch (Throwable th) {
            }
        }
        this.aA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SMSReceiver extends BroadcastReceiver {
        private Handler a;

        public SMSReceiver(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.BroadcastReceiver
        @TargetApi(4)
        public void onReceive(Context context, Intent intent) {
            try {
                Object[] objArr = (Object[]) intent.getExtras().get("pdus");
                SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                        String a = a(smsMessageArr[i2].getMessageBody());
                        if (this.a != null) {
                            Message obtainMessage = this.a.obtainMessage();
                            obtainMessage.obj = a;
                            this.a.sendMessage(obtainMessage);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }

        private String a(String str) {
            String[] split;
            for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                if (str2.length() == 6) {
                    return str2;
                }
            }
            return "";
        }
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
                    str3 = (TextUtils.isEmpty(version) ? "" : "&passAppVersion=" + version) + "&passAppHash=" + SapiCache.c(getContext(), c2).hash;
                }
            }
            return split[0] + str3 + "#" + split[1];
        }
        return str2;
    }

    static String a(String str) {
        try {
            String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(l)) {
                    str = str.replace(k, "<link type=\"text/css\" rel=\"stylesheet\" href=\"" + str2 + "\">");
                } else {
                    str = str.replace(k, "");
                }
            }
        } catch (Throwable th) {
            Log.e(th);
        }
        return str;
    }

    String a() {
        return SapiUtils.buildBDUSSCookie(this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    void b() {
        String diCookieInfo;
        List<String> loginCookieDiKeys = SapiContext.getInstance(getContext()).getSapiOptions().getLoginCookieDiKeys();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled()).replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        if (loginCookieDiKeys.size() == 1 && loginCookieDiKeys.get(0).equals("di")) {
            diCookieInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.SAPI_CONFIG_URI);
        } else {
            diCookieInfo = SapiDeviceInfo.getDiCookieInfo(loginCookieDiKeys);
        }
        String wap = this.H.environment.getWap(SapiUtils.getDefaultHttpsEnabled());
        if (diCookieInfo == null) {
            diCookieInfo = "";
        }
        arrayList.add(new BasicNameValuePair(wap, SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", diCookieInfo)));
        SapiUtils.syncCookies(getContext(), arrayList);
    }

    private static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : SapiUtils.getAuthorizedDomainsForPtoken(context)) {
                    arrayList.add(new BasicNameValuePair("https://www." + str2, SapiUtils.buildStokenCookie(str2, str)));
                }
            }
            SapiUtils.syncCookies(context, arrayList);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.sapi2.SapiWebView.59
            @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, true);
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
    public void l() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.60
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.av != null && SapiWebView.this.av.isShowing()) {
                    try {
                        SapiWebView.this.av.dismiss();
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
}
