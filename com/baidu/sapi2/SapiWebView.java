package com.baidu.sapi2;

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
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.plugin.SSOError;
import com.baidu.sapi2.plugin.SSOListener;
import com.baidu.sapi2.plugin.sso.SsoHandler;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.f;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.huawei.hwid.openapi.OpenHwID;
import com.huawei.hwid.openapi.out.IHwIDCallBack;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    private static final String A = "系统时间错误";
    private static final String B = "证书安全警告";
    private static final String C = "当前设备时间为yyyy年MM月dd日,请设置正确的系统时间";
    private static final String D = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    private static final String E = "取消";
    private static final String F = "立即设置时间";
    private static final String a = "prompt_on_cancel";
    private static final String aq = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final int b = 1;
    private static final int c = 0;
    private static final String d = "http://www.baidu.com";
    private static final String e = "__wp-action";
    private static final String f = "renren-offline";
    private static final String g = "auth-widget";
    private static final String h = "forget-pwd";
    private static final String i = "modify-pwd";
    private static final String j = "text/html";
    private static final String k = "UTF-8";
    private static final String l = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    private static final String m = "file:///android_asset";
    private static final String n = "#login";
    private static final String o = "#authPwd";
    private static final String p = "#reg";
    private static final String q = "#canshare_accounts";
    private static final String r = "#sms_login";
    private static final String s = "#fastReg";
    private static final String t = "#fastRegSuccess";
    private static final String u = "#fastRegVerify";
    private static final String v = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    private static final String w = "发送一条短信，即可完成注册。";
    private static final String x = "服务错误，请稍后重试";
    private static final String y = "微信未安装";
    private static final String z = "未登录华为帐号";
    private Map<String, AbstractInterpreter> G;
    private SapiConfiguration H;
    private IUiListener I;
    private AuthorizationListener J;
    private Handler K;
    private Handler L;
    private Handler M;
    private FastRegHandler N;
    private VoiceLoginHandler O;
    private NMLoginHandler P;
    private LCLoginHandler Q;
    private UniteVerifyHandler R;
    private WeixinHandler S;
    private HuaweiHandler T;
    private QuickLoginHandler U;
    private ChangePwdCallback V;
    private AuthWidgetCallback W;
    private BindWidgetCallback aa;
    private UniteVerifyCallback ab;
    private SsoHandler ac;
    private View ad;
    private View ae;
    private ProgressBar af;
    private ProgressDialog ag;
    private Dialog ah;
    private long ai;
    private Handler aj;
    private TimeoutTask ak;
    private BroadcastReceiver al;
    private SmsHandler am;
    private Runnable an;
    private OnFinishCallback ao;
    private OnBackCallback ap;
    private FastRegAction ar;
    private SapiAccountResponse as;
    private SapiCallback<LoginResult> at;
    private SocialResponse au;
    public static final NameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new BasicNameValuePair("smsfastlogin", "1");
    public static final NameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new BasicNameValuePair("bindToSmsLogin", "1");
    public static final NameValuePair EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER = new BasicNameValuePair("overseas", "1");
    public static final NameValuePair EXTRA_SUPPORT_VOICE_CODE = new BasicNameValuePair("is_voice_sms", "1");

    /* loaded from: classes.dex */
    public interface AuthWidgetCallback {
        void onSuccess(String str);
    }

    /* loaded from: classes.dex */
    public interface BindWidgetCallback {
        void onPhoneNumberExist(String str);
    }

    /* loaded from: classes.dex */
    public interface ChangePwdCallback {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface FastRegHandler {
        void handleFastReg();
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
    public interface QuickLoginHandler {
        void handleOtherLogin();
    }

    /* loaded from: classes.dex */
    public interface UniteVerifyCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
    }

    /* loaded from: classes.dex */
    public interface UniteVerifyHandler {
        void handleUniteVerify(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface VoiceLoginHandler {
        void handleVoiceLogin();
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
                SapiWebView.this.aj.sendMessage(message);
                SapiWebView.this.aj.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.ao = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ap = onBackCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.G = new HashMap();
        this.aj = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.g();
                }
            }
        };
        this.ak = new TimeoutTask();
        c();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = new HashMap();
        this.aj = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.g();
                }
            }
        };
        this.ak = new TimeoutTask();
        c();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.G = new HashMap();
        this.aj = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.g();
                }
            }
        };
        this.ak = new TimeoutTask();
        c();
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

    private void c() {
        this.ai = DEFAULT_TIMEOUT_MILLIS;
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
                L.d(str + " -- From line " + i2 + " of " + str2, new Object[0]);
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
            public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * j2);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, final String str2, String str3, final JsPromptResult jsPromptResult) {
                final String[] strArr = {""};
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Command parse = Command.parse(str2);
                        if (parse != null) {
                            if (!TextUtils.isEmpty(parse.getActionName()) && SapiWebView.this.G.get(parse.getActionName()) != null) {
                                strArr[0] = ((AbstractInterpreter) SapiWebView.this.G.get(parse.getActionName())).interpret(parse);
                            }
                            if (parse.getActionParams().size() > 2 && SapiWebView.a.equals(parse.getActionParams().get(2))) {
                                jsPromptResult.cancel();
                                return;
                            } else {
                                jsPromptResult.confirm(strArr[0]);
                                return;
                            }
                        }
                        jsPromptResult.cancel();
                    }
                });
                return true;
            }
        });
        if (this.J == null) {
            this.J = new DefaultAuthorizationListener();
        }
        if (this.S == null) {
            this.S = new DefaultWeixinHandler();
        }
        this.am = new SmsHandler();
        this.an = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.j();
            }
        };
        try {
            resumeTimers();
        } catch (Throwable th) {
            L.e(th);
        }
        d();
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
                        L.e(th, th.getMessage(), new Object[0]);
                    }
                    return true;
                } else if (str.startsWith("wtloginmqq")) {
                    return true;
                } else {
                    if (SapiWebView.this.at != null) {
                        Uri parse = Uri.parse(str);
                        if (SapiWebView.this.H.environment.getWap().replace("http://", "").replace("https://", "").equals(parse.getHost() + (parse.getPort() == -1 ? "" : ":" + parse.getPort())) && f.c.equals(parse.getPath())) {
                            SapiAccountManager.getInstance().getAccountService().a(SapiWebView.this.at, str);
                            return true;
                        }
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SapiWebView.this.ak.setUrl(str);
            SapiWebView.this.aj.postDelayed(SapiWebView.this.ak, SapiWebView.this.ai);
            if (str != null) {
                if (str.contains("__wp-action=auth-widget")) {
                    final String queryParameter = Uri.parse(str).getQueryParameter("authsid");
                    if (!TextUtils.isEmpty(queryParameter) && SapiWebView.this.W != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.W != null) {
                                    SapiWebView.this.W.onSuccess(queryParameter);
                                }
                            }
                        });
                    }
                }
                if (str.contains(SapiWebView.h) || str.contains(SapiWebView.i)) {
                    String queryParameter2 = Uri.parse(str).getQueryParameter(SapiWebView.e);
                    if (SapiWebView.h.equals(queryParameter2) && SapiWebView.this.V != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                if (SapiWebView.this.V != null) {
                                    SapiWebView.this.V.onSuccess();
                                }
                            }
                        });
                    }
                    if (SapiWebView.i.equals(queryParameter2) && SapiWebView.this.V != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.stopLoading();
                                final String cookieBduss = SapiUtils.getCookieBduss();
                                final String cookiePtoken = SapiUtils.getCookiePtoken();
                                if (TextUtils.isEmpty(cookieBduss)) {
                                    if (SapiWebView.this.V != null) {
                                        SapiWebView.this.V.onSuccess();
                                        return;
                                    }
                                    return;
                                }
                                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiWebView.2.3.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.V != null) {
                                            SapiWebView.this.V.onSuccess();
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
                                            session.k = cookiePtoken;
                                        }
                                        SapiAccountManager.getInstance().validate(session);
                                        if (SapiWebView.this.V != null) {
                                            SapiWebView.this.V.onSuccess();
                                        }
                                    }

                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                                        if (SapiWebView.this.V != null) {
                                            SapiWebView.this.V.onSuccess();
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onStart() {
                                        try {
                                            SapiWebView.this.ag = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                                        } catch (Throwable th) {
                                            L.e(th);
                                        }
                                    }

                                    @Override // com.baidu.sapi2.callback.SapiCallback
                                    public void onFinish() {
                                        if (SapiWebView.this.ag != null) {
                                            try {
                                                SapiWebView.this.ag.dismiss();
                                            } catch (Throwable th) {
                                                L.e(th);
                                            }
                                        }
                                    }
                                }, cookieBduss);
                            }
                        });
                    }
                }
                if (str.contains("__wp-action=renren-offline") && SapiWebView.f.equals(Uri.parse(str).getQueryParameter(SapiWebView.e))) {
                    if (SapiWebView.this.au == null) {
                        if (SapiWebView.this.J != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (SapiWebView.this.J != null) {
                                        SapiWebView.this.J.onFailed(-100, "登录失败");
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    SapiWebView.this.a(SapiWebView.this.au);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            String str2;
            StatService.a("sslerr_view", Collections.singletonMap("na_err_code", sslError.getPrimaryError() + ""), false);
            if (sslError.getPrimaryError() == 4 || sslError.getPrimaryError() == 3) {
                if (SapiWebView.this.ah == null) {
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
                            StatService.a("sslerr_date_setting", null, false);
                        }
                    });
                    builder.setNegativeButton(SapiWebView.E, new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.2.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            StatService.a("sslerr_date_cancel", null, false);
                        }
                    });
                    SapiWebView.this.ah = builder.create();
                }
                if (!SapiWebView.this.ah.isShowing()) {
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
            SapiWebView.this.loadUrl(SapiWebView.aq);
            Uri parse = Uri.parse(SapiAccountManager.getInstance().getAccountService().l());
            Uri parse2 = Uri.parse(SapiAccountManager.getInstance().getAccountService().m());
            Uri parse3 = Uri.parse(SapiAccountManager.getInstance().getAccountService().k());
            if (str.contains(parse.getHost() + parse.getPath()) || str.contains(parse2.getHost() + parse2.getPath()) || str.contains(parse3.getHost() + parse3.getPath())) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '1', 'prompt_on_cancel']}}));");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().h())) {
                SapiWebView.this.loadUrl("javascript:prompt(JSON.stringify({'action':{'name': 'authorized_response', 'params': [document.body.innerHTML, '0', 'prompt_on_cancel']}}));");
            }
            SapiWebView.this.aj.removeCallbacks(SapiWebView.this.ak);
        }
    }

    private void d() {
        this.G.put("config_fastlogin_features", new ConfigFastloginFeaturesInterpreter());
        this.G.put("action_feifan_login", new FeifanWebviewInterpreter());
        this.G.put("action_chuanke_login", new ChuankeWebviewInterpreter());
        this.G.put("action_social_sina_sso", new SinaSSOInterpreter());
        this.G.put("action_social_weixin_sso", new WeiXinSSOInterpreter());
        this.G.put("action_social_qzone_webview", new QzoneWebviewInterpreter());
        this.G.put("action_social_tx_weibo_webview", new TXWeiboWebviewInterpreter());
        this.G.put("action_social_sina_weibo_webview", new SinaWeiboWebviewInterpreter());
        this.G.put("action_huawei_login", new HuaweiSSOintrpreter());
        this.G.put("action_nuomi_login", new NuomiLoginInterpreter());
        this.G.put("action_lecai_login", new LecaiLoginInterpreter());
        this.G.put("action_voice_login", new VoiceLoginInterpreter());
        this.G.put("action_unite_verify", new UniteVerifyInterpreter());
        this.G.put("loginWithQRCode", new QRcodeLoginInterpreter());
        this.G.put("loginWithDeviceId", new DeviceIdLoginInterpreter());
        this.G.put("authorized_response", new AuthorizedResponseInterpreter());
        this.G.put("config_login_share_strategy", new ShareStrategyConfigInterpreter());
        this.G.put("config_canshare_accounts", new ShareAccountsConfigInterpreter());
        this.G.put("action_remove_share_account", new ShareAccountsRemoveInterpreter());
        this.G.put("unite_verify_result", new UniteVerifyResultInterpreter());
        this.G.put("action_share_accounts_view_btn_clicked", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.5
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.U != null) {
                    SapiWebView.this.U.handleOtherLogin();
                    return null;
                }
                return null;
            }
        });
        this.G.put("action_bind_widget_phone_number_exist", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.6
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                String str = command.getActionParams().get(0);
                if (SapiWebView.this.aa != null) {
                    SapiWebView.this.aa.onPhoneNumberExist(str);
                    return null;
                }
                return null;
            }
        });
        this.G.put("finish", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.7
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.a(SapiWebView.this.au);
                SapiWebView.this.finish();
                return null;
            }
        });
        this.G.put("back", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.back();
                return null;
            }
        });
        this.G.put("action_fast_reg", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiWebView.this.N != null) {
                    SapiWebView.this.N.handleFastReg();
                    return null;
                }
                SapiWebView.this.loadFastReg();
                return null;
            }
        });
        this.G.put("action_forget_pwd", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.10
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                boolean z2 = false;
                if (SapiWebView.this.J != null) {
                    z2 = SapiWebView.this.J.onForgetPwd();
                }
                return z2 ? "1" : "0";
            }
        });
        this.G.put("action_received_sms_code", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.11
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.a(SapiWebView.this.am);
                SapiWebView.this.am.a = command.getActionParams().get(0);
                SapiWebView.this.am.b = command.getActionParams().get(1);
                SapiWebView.this.am.postDelayed(SapiWebView.this.an, 15000L);
                return null;
            }
        });
        this.G.put("set_pass_canceled", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.12
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                SapiWebView.this.b(SapiWebView.this.as);
                return null;
            }
        });
        this.G.put("get_preset_phone_number", new AbstractInterpreter() { // from class: com.baidu.sapi2.SapiWebView.13
            @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
            public String interpret(Command command) {
                if (SapiUtils.isValidPhoneNumber(SapiWebView.this.H.presetPhoneNumber)) {
                    return SapiWebView.this.H.presetPhoneNumber;
                }
                String i2 = SapiWebView.this.i();
                return !SapiUtils.isValidPhoneNumber(i2) ? "" : i2;
            }
        });
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
                removeCallbacks(SapiWebView.this.an);
            }
        }
    }

    private void e() {
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            L.e(e2);
        }
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        setDownloadListener(new DownloadListener() { // from class: com.baidu.sapi2.SapiWebView.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    L.e(th, th.getMessage(), new Object[0]);
                }
            }
        });
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.J = authorizationListener;
    }

    public void setQrAppLoginHandler(Handler handler) {
        this.L = handler;
    }

    public void setDeviceLoginHandler(Handler handler) {
        this.M = handler;
    }

    public void setFastRegHandler(FastRegHandler fastRegHandler) {
        this.N = fastRegHandler;
    }

    public void setVoiceLoginHandler(VoiceLoginHandler voiceLoginHandler) {
        this.O = voiceLoginHandler;
    }

    public void setNmLoginHandler(NMLoginHandler nMLoginHandler) {
        this.P = nMLoginHandler;
    }

    public void setLcLoginHandler(LCLoginHandler lCLoginHandler) {
        this.Q = lCLoginHandler;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.S = weixinHandler;
    }

    public void setHuaweiHandler(HuaweiHandler huaweiHandler) {
        this.T = huaweiHandler;
    }

    public void setUniteVerifyHandler(UniteVerifyHandler uniteVerifyHandler) {
        this.R = uniteVerifyHandler;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.V = changePwdCallback;
    }

    public void setAuthWidgetCallback(AuthWidgetCallback authWidgetCallback) {
        this.W = authWidgetCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.aa = bindWidgetCallback;
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.ab = uniteVerifyCallback;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.K = handler;
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
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            a(i2, list, this.H.customActionBarEnabled);
            return;
        }
        String a2 = a(SapiAccountManager.getInstance().getAccountService().a(), list);
        switch (i2) {
            case 0:
                loadUrl(a2 + n);
                return;
            case 1:
                loadUrl(a2 + r);
                return;
            case 2:
                if (this.N != null) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.N != null) {
                                SapiWebView.this.N.handleFastReg();
                            }
                        }
                    });
                    return;
                } else {
                    loadFastReg();
                    return;
                }
            default:
                loadUrl(a2 + n);
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
            str2 = "disusername=" + URLEncoder.encode(str, k);
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&" + str2 + o);
        } else {
            loadLogin();
        }
    }

    @Deprecated
    public void loadSmsLogin() {
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            f();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + r);
        }
    }

    public void loadQuickLogin(QuickLoginHandler quickLoginHandler) {
        if (quickLoginHandler == null) {
            throw new IllegalArgumentException(QuickLoginHandler.class.getSimpleName() + " can't be null");
        }
        this.U = quickLoginHandler;
        a(3, null, true);
    }

    private void f() {
        a(0, null, this.H.customActionBarEnabled);
    }

    private void a(int i2, List<NameValuePair> list, boolean z2) {
        String str = SapiAccountManager.getInstance().getAccountService().a() + "&loginInitType=" + a(i2);
        if (z2 && !this.H.customActionBarEnabled) {
            str = str + "&adapter=3";
        }
        loadUrl(a(str, list) + q);
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
        this.at = sapiCallback;
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
        loadUrl(a(a2, list) + p);
    }

    private String a(String str, List<NameValuePair> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    try {
                        arrayList.add(new BasicNameValuePair(URLEncoder.encode(nameValuePair.getName(), k), URLEncoder.encode(nameValuePair.getValue(), k)));
                    } catch (UnsupportedEncodingException e2) {
                        L.e(e2);
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
        if (!this.H.quickUserEnabled) {
            loadRegist();
            return;
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a();
        if (this.H.registMode != RegistMode.QUICK_USER) {
            a2 = a2 + "&regtype=2";
        }
        loadUrl(a2 + p);
    }

    private void a(Context context, String str) {
        SapiUtils.webLogin(context, str, c.a(context).b(str).k);
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
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=modify-pwd", k)));
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new BasicNameValuePair("skin", str2));
            }
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        String c2 = SapiAccountManager.getInstance().getAccountService().c();
        if (arrayList.size() > 0) {
            c2 = c2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String a2 = a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.H.environment.getWap(), a2));
        loadUrl(c2, arrayList2);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=forget-pwd", k)));
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new BasicNameValuePair("skin", str));
            }
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        String b2 = SapiAccountManager.getInstance().getAccountService().b();
        if (arrayList.size() > 0) {
            b2 = b2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(b2);
    }

    public void loadUserAgreement() {
        loadUrl(this.H.environment.getWap() + "/passport/agreement?adapter=3");
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
            arrayList.add(new BasicNameValuePair("skip", "1"));
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String a3 = a(a2, list);
        String a4 = a();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.H.environment.getWap(), a4));
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
            arrayList.add(new BasicNameValuePair(SocialConstants.TOKEN_RESPONSE_TYPE, URLEncoder.encode(str2, k)));
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=auth-widget", k)));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new BasicNameValuePair("skin", str3));
            }
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
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

    public void loadUniteVerify(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair(SocialConstants.TOKEN_RESPONSE_TYPE, URLEncoder.encode(str, k)));
            if (str2 != null) {
                arrayList.add(new BasicNameValuePair("u", str2));
            }
            if (str3 != null) {
                arrayList.add(new BasicNameValuePair("adtext", URLEncoder.encode(str3, k)));
            }
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().f() + "&" + SapiUtils.createRequestParams(arrayList));
    }

    public void loadFastReg() {
        if (!SapiUtils.isSimReady(getContext()) || !SapiUtils.hasActiveNetwork(getContext())) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + r);
            return;
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + s);
        this.ar = new FastRegAction();
        this.ar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.as = sapiAccountResponse;
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + t);
    }

    public long getTimeoutMillis() {
        return this.ai;
    }

    public void setTimeoutMillis(long j2) {
        this.ai = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<NameValuePair> list) {
        SapiUtils.syncCookies(getContext(), list);
        b();
        String c2 = c(SapiCache.a(getContext(), str));
        if (!TextUtils.isEmpty(c2)) {
            loadDataWithBaseURL(str, c2, j, k, str);
        } else {
            d(str);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.16
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT > 7) {
                    SapiWebView.this.getSettings().setBlockNetworkLoads(true);
                }
                SapiWebView.super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        });
    }

    public void back() {
        b(this.as);
        super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
        a(this.au);
        if ((this.ad != null && this.ad.getVisibility() == 0) || (this.ae != null && this.ae.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        j();
        if (this.ar != null) {
            this.ar.f = true;
            this.ar.k.removeCallbacks(this.ar.l);
        }
        if (this.ao != null) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (SapiWebView.this.ao != null) {
                        SapiWebView.this.ao.onFinish();
                    }
                }
            });
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (this.ac != null) {
            this.ac.authorizeCallBack(i2, i3, intent);
        }
    }

    public void onActivityResultData(int i2, int i3, Intent intent) {
        if (i2 == 11101 || i2 == 10102) {
            Tencent.onActivityResultData(i2, i3, intent, this.I);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.ap != null) {
                this.ap.onBack();
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
            if (!c.a(SapiWebView.this.getContext()).b() && list.contains(FastLoginFeature.DEVICE_LOGIN)) {
                list.remove(FastLoginFeature.DEVICE_LOGIN);
            }
            StringBuilder sb = new StringBuilder();
            if (c.a(SapiWebView.this.getContext()).c()) {
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
                        sb.append(",").append(fastLoginFeature.getStrValue());
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.WANDA_FEIFAN.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.CHUANKE.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.QZONE.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.TENCENT_WEIBO.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.K != null) {
                Message message = new Message();
                message.what = SocialType.HUAWEI.getType();
                SapiWebView.this.K.sendMessage(message);
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
            if (SapiWebView.this.L != null) {
                SapiWebView.this.L.sendMessage(new Message());
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class DeviceIdLoginInterpreter extends AbstractInterpreter {
        DeviceIdLoginInterpreter() {
            super();
        }

        @Override // com.baidu.sapi2.SapiWebView.AbstractInterpreter
        public String interpret(Command command) {
            if (SapiWebView.this.M != null) {
                SapiWebView.this.M.sendMessage(new Message());
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
            if (SapiWebView.this.P != null) {
                SapiWebView.this.P.handleNMLogin();
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
            if (SapiWebView.this.Q != null) {
                SapiWebView.this.Q.handleLCLogin();
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
            if (SapiWebView.this.O != null) {
                SapiWebView.this.O.handleVoiceLogin();
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
            if (SapiWebView.this.R != null && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    SapiWebView.this.R.handleUniteVerify(jSONObject.optString(SocialConstants.TOKEN_RESPONSE_TYPE), jSONObject.optString("adtext"));
                    return null;
                } catch (JSONException e) {
                    L.e(e);
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
                SocialResponse b = SapiWebView.b(str);
                if (b == null) {
                    if (SapiWebView.this.J != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.AuthorizedResponseInterpreter.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.J != null) {
                                    SapiWebView.this.J.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (b.offlineNotice || b.bindGuide || b.errorCode == 21) {
                    SapiWebView.this.au = b;
                } else {
                    SapiWebView.this.a(b);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse a = SapiWebView.a(str);
                if (a == null) {
                    if (SapiWebView.this.J != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.AuthorizedResponseInterpreter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (SapiWebView.this.J != null) {
                                    SapiWebView.this.J.onFailed(-100, "登录失败");
                                }
                            }
                        });
                        return null;
                    }
                    return null;
                } else if (SapiWebView.this.ar != null && a.newReg) {
                    SapiWebView.this.as = a;
                    SapiWebView.this.a(a);
                    return null;
                } else if (a.errorCode == 0 || a.errorCode == 110000) {
                    SapiWebView.this.b(a);
                    return null;
                } else if (SapiWebView.this.J != null) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.AuthorizedResponseInterpreter.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.J != null) {
                                SapiWebView.this.J.onFailed(a.errorCode, a.errorMsg);
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
                sapiAccount.username = jSONObject.optString("username");
                sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.k = jSONObject.optString("ptoken");
                sapiAccount.l = jSONObject.optString("stoken");
                if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount) && SapiWebView.this.ab != null) {
                    SapiWebView.this.ab.onSuccess(optString, optString2, sapiAccount);
                    return null;
                }
                return null;
            } catch (JSONException e) {
                L.e(e);
                return null;
            }
        }
    }

    static SapiAccountResponse a(String str) {
        SapiAccountResponse sapiAccountResponse;
        Throwable th;
        XmlPullParser newPullParser;
        boolean z2;
        int eventType;
        boolean z3;
        SapiAccountResponse sapiAccountResponse2 = null;
        String a2 = a("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(a2)) {
            try {
                newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), k);
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
                                if (sapiAccountResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
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
                                            sapiAccountResponse.tplStokenMap.put(split[0], split[1]);
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
                                    }
                                }
                                eventType = newPullParser.next();
                                z2 = z3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        th = th5;
                        L.e(th);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2289=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SocialResponse b(String str) {
        SocialResponse socialResponse;
        SocialResponse socialResponse2 = null;
        String a2 = a("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(a2)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), k);
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
                            } else if (socialResponse2 == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                                socialResponse = new SocialResponse();
                                try {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                    break;
                                } catch (Exception e2) {
                                    socialResponse2 = socialResponse;
                                    e = e2;
                                    L.e(e);
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
                                    L.e(e);
                                    return socialResponse2;
                                }
                            } else {
                                if (socialResponse2 != null) {
                                    if (name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
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
                                    } else if (name.equalsIgnoreCase("incomplete_user")) {
                                        String nextText = newPullParser.nextText();
                                        if ("0".equals(nextText)) {
                                            socialResponse2.accountType = AccountType.NORMAL;
                                        } else if ("1".equals(nextText)) {
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
                        L.e(e);
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
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.18
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.af != null) {
                    SapiWebView.this.af.setVisibility(8);
                }
                if (SapiWebView.this.ae != null) {
                    SapiWebView.this.ae.setVisibility(0);
                }
            }
        });
    }

    private void h() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.19
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.af != null) {
                    SapiWebView.this.af.setVisibility(8);
                }
                if (SapiWebView.this.ad != null) {
                    SapiWebView.this.ad.setVisibility(0);
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
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.y, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleServerError(String str) {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.x, 1).show();
        }
    }

    /* loaded from: classes.dex */
    public class DefaultHuaweiHandler implements HuaweiHandler {
        public DefaultHuaweiHandler() {
        }

        @Override // com.baidu.sapi2.SapiWebView.HuaweiHandler
        public void handleHuaweiLoginFailure() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.z, 1).show();
            SapiWebView.this.finish();
        }
    }

    public void loadSinaSSOLogin() {
        a(true);
    }

    public void loadIqiyiBindServer(String str) {
        if (str != null) {
            String buildIqiyiCookie = SapiUtils.buildIqiyiCookie(this.H.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "mkey", Uri.parse(str).getQueryParameter("mkey"));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(this.H.environment.getURL(), buildIqiyiCookie));
            loadUrl(str, arrayList);
        }
    }

    void a(final boolean z2) {
        this.ac = new SsoHandler((Activity) getContext(), f.l, d);
        this.ac.authorize(new SSOListener() { // from class: com.baidu.sapi2.SapiWebView.20
            public void onComplete(Bundle bundle) {
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.SINA_WEIBO, bundle.getString(SocialConstants.PARAM_ACCESS_TOKEN), bundle.getString("uid")));
            }

            public void onJumpNormal() {
                if (SapiWebView.this.K != null) {
                    Message message = new Message();
                    message.what = SocialType.SINA_WEIBO.getType();
                    SapiWebView.this.K.sendMessage(message);
                }
            }

            public void onError(SSOError sSOError) {
                L.e(sSOError);
                Toast.makeText(SapiWebView.this.getContext(), sSOError.getMessage(), 0).show();
            }

            public void onCancel() {
                if (z2 && (SapiWebView.this.getContext() instanceof Activity)) {
                    ((Activity) SapiWebView.this.getContext()).finish();
                }
            }
        });
        if (c.a(getContext()).c()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 0).show();
                }
            });
        }
    }

    public void loadWeixinSSOLogin() {
        if (!WXAPIFactory.createWXAPI(getContext(), this.H.wxAppID).isWXAppInstalled()) {
            if (this.S != null) {
                this.S.handleNotInstall();
                return;
            }
            return;
        }
        new AsyncHttpClient().get(getContext(), SapiAccountManager.getInstance().getAccountService().j(), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiWebView.22
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                try {
                    SapiWebView.this.ag = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                if (SapiWebView.this.ag != null) {
                    try {
                        SapiWebView.this.ag.dismiss();
                    } catch (Throwable th) {
                        L.e(th);
                    }
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (SapiWebView.this.ad != null) {
                    SapiWebView.this.ad.setVisibility(0);
                } else {
                    SapiWebView.this.S.handleServerError(str);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i2, String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("mkey", "");
                    if (!TextUtils.isEmpty(optString)) {
                        SendAuth.Req req = new SendAuth.Req();
                        req.scope = "snsapi_userinfo";
                        req.state = optString;
                        WXAPIFactory.createWXAPI(SapiWebView.this.getContext(), SapiWebView.this.H.wxAppID).sendReq(req);
                        SapiWebView.this.finish();
                    } else {
                        String optString2 = jSONObject.optString(SocialConstants.PARAM_ERROR_CODE, "");
                        if (SapiWebView.this.S != null) {
                            SapiWebView.this.S.handleServerError(optString2);
                        }
                    }
                } catch (JSONException e2) {
                    L.e(e2);
                }
            }
        });
    }

    public void loadQQSSOLogin() {
        final Tencent createInstance = Tencent.createInstance(this.H.qqAppID, getContext());
        this.I = new IUiListener() { // from class: com.baidu.sapi2.SapiWebView.23
            public void onComplete(Object obj) {
                if (obj == null) {
                    SapiWebView.this.finish();
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null && jSONObject.length() == 0) {
                    SapiWebView.this.finish();
                    return;
                }
                try {
                    String string = jSONObject.getString(SocialConstants.PARAM_ACCESS_TOKEN);
                    String string2 = jSONObject.getString(SocialConstants.PARAM_EXPIRES_IN);
                    String string3 = jSONObject.getString("openid");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                        createInstance.setAccessToken(string, string2);
                        createInstance.setOpenId(string3);
                    }
                } catch (Exception e2) {
                    L.e(e2);
                }
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(createInstance.getAccessToken(), createInstance.getOpenId()));
            }

            public void onError(UiError uiError) {
                SapiWebView.this.finish();
                Toast.makeText(SapiWebView.this.getContext(), uiError.errorMessage, 1).show();
            }

            public void onCancel() {
                SapiWebView.this.finish();
            }
        };
        if (!createInstance.isSessionValid()) {
            if (createInstance.isSupportSSOLogin((Activity) getContext())) {
                createInstance.login((Activity) getContext(), "all", this.I);
            } else if (this.K != null) {
                Message message = new Message();
                message.what = SocialType.QQ.getType();
                this.K.sendMessage(message);
            }
        } else {
            createInstance.reAuth((Activity) getContext(), "all", this.I);
        }
        if (c.a(getContext()).c()) {
            Toast.makeText(getContext(), v, 0).show();
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.baidu.sapi2.SapiWebView$24] */
    public void loadXiaomiSSOLogin() {
        final XiaomiOAuthFuture startGetAccessToken = new XiaomiOAuthorize().setAppId(this.H.xiaomiAppID.longValue()).setRedirectUrl(this.H.xiaomiRedirectUri).setScope(new int[]{1, 3, 4}).startGetAccessToken((Activity) getContext());
        new Thread() { // from class: com.baidu.sapi2.SapiWebView.24
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3 = null;
                try {
                    XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) startGetAccessToken.getResult();
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.24.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                SapiWebView.this.ag = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                            } catch (Throwable th) {
                                L.e(th);
                            }
                        }
                    });
                    if (xiaomiOAuthResults == null || xiaomiOAuthResults.getAccessToken() == null) {
                        SapiWebView.this.k();
                        SapiWebView.this.finish();
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject((String) new XiaomiOAuthorize().callOpenApi(SapiWebView.this.getContext(), SapiWebView.this.H.xiaomiAppID.longValue(), "/user/profile", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult());
                        String optString = jSONObject.optString("result");
                        if ("ok".equals(optString)) {
                            str2 = jSONObject.getJSONObject("data").optString("userId");
                        } else if ("error".equals(optString)) {
                            L.e(jSONObject.optString("description") + "(" + jSONObject.optString("code") + ")", new Object[0]);
                            SapiWebView.this.k();
                            SapiWebView.this.finish();
                            return;
                        } else {
                            str2 = null;
                        }
                        str = str2;
                    } catch (Exception e2) {
                        SapiWebView.this.k();
                        SapiWebView.this.finish();
                        L.e(e2);
                        str = null;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject((String) new XiaomiOAuthorize().callOpenApi(SapiWebView.this.getContext(), SapiWebView.this.H.xiaomiAppID.longValue(), "/user/phone", xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()).getResult());
                        String optString2 = jSONObject2.optString("result");
                        if ("ok".equals(optString2)) {
                            str3 = jSONObject2.getJSONObject("data").optString("phone");
                        } else if ("error".equals(optString2)) {
                            L.e(jSONObject2.optString("description") + "(" + jSONObject2.optString("code") + ")", new Object[0]);
                            SapiWebView.this.k();
                            SapiWebView.this.finish();
                            return;
                        }
                    } catch (Exception e3) {
                        SapiWebView.this.k();
                        SapiWebView.this.finish();
                        L.e(e3);
                    }
                    SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(xiaomiOAuthResults.getAccessToken(), str, str3));
                    SapiWebView.this.k();
                } catch (Exception e4) {
                    L.e(e4);
                    SapiWebView.this.finish();
                }
            }
        }.start();
        if (c.a(getContext()).c()) {
            Toast.makeText(getContext(), v, 0).show();
        }
    }

    public void weixinSSOLogin(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        String b2 = SapiAccountManager.getInstance().getAccountService().b(str, str2);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BasicNameValuePair(this.H.environment.getURL(), "mkey=" + str2 + ";domain=." + this.H.environment.getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/;httponly"));
        loadUrl(b2, arrayList);
    }

    public void loadHuaWeiSSOLogin() {
        if (getContext() instanceof Activity) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("useSMSLogin", false);
            OpenHwID.setLoginProxy((Activity) getContext(), this.H.hwAppId, new IHwIDCallBack() { // from class: com.baidu.sapi2.SapiWebView.25
                public void onUserInfo(HashMap hashMap) {
                    try {
                        String str = (String) hashMap.get("accesstoken");
                        String str2 = (String) hashMap.get("userID");
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            if (SapiWebView.this.T == null) {
                                SapiWebView.this.T = new DefaultHuaweiHandler();
                            }
                            SapiWebView.this.T.handleHuaweiLoginFailure();
                            return;
                        }
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, SapiWebView.k), URLEncoder.encode(str2, SapiWebView.k)));
                    } catch (UnsupportedEncodingException e2) {
                        L.e(e2);
                    }
                }
            }, bundle);
            OpenHwID.logout();
            OpenHwID.login(new Bundle());
            if (c.a(getContext()).c()) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.26
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

    public void loadHuaWeiSSOLogin(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("AccessToken or uid can't be null");
        }
        String str3 = null;
        try {
            str3 = SapiAccountManager.getInstance().getAccountService().a(SocialType.HUAWEI, URLEncoder.encode(str, k), URLEncoder.encode(str2, k));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        loadUrl(str3);
        if (c.a(getContext()).c()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.27
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 0).show();
                }
            });
        }
    }

    public void loadSocialLogin(SocialType socialType) {
        loadSocialLogin(socialType, false);
    }

    public void loadSocialLogin(SocialType socialType, boolean z2) {
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
        loadUrl(a2);
        if (c.a(getContext()).c()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.28
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
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            h();
        } else {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.29
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.super.loadUrl(str);
                }
            });
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
                L.e(e);
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
            sapiAccount.l = sapiAccountResponse.stoken;
            sapiAccount.k = sapiAccountResponse.ptoken;
            sapiAccount.email = sapiAccountResponse.email;
            sapiAccount.username = sapiAccountResponse.username;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
                sapiAccount.a("stoken_list", new JSONObject(sapiAccountResponse.tplStokenMap));
            }
            c.a(getContext()).a(sapiAccountResponse.uid, sapiAccountResponse.reloginCredentials);
            if (this.J != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.30
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (SapiWebView.this.J != null) {
                                SapiWebView.this.J.beforeSuccess(sapiAccount);
                            }
                        } catch (Throwable th) {
                            L.e(th);
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
            sapiAccount.l = socialResponse.stoken;
            sapiAccount.k = socialResponse.ptoken;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            sapiAccount.a(socialResponse.socialType, socialResponse.socialPortraitUrl);
            sapiAccount.a(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(socialResponse.accountType.getType()));
            if (!socialResponse.tplStokenMap.isEmpty()) {
                sapiAccount.a("stoken_list", new JSONObject(socialResponse.tplStokenMap));
            }
            if (SapiUtils.isValidAccount(sapiAccount)) {
                socialResponse.errorCode = 0;
            }
            if (this.J != null) {
                if (socialResponse.errorCode == 0 || socialResponse.errorCode == 110000) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.31
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (SapiWebView.this.J != null) {
                                    SapiWebView.this.J.beforeSuccess(sapiAccount);
                                }
                            } catch (Throwable th) {
                                L.e(th);
                            }
                            com.baidu.sapi2.share.a.a().a(sapiAccount);
                            SapiWebView.this.a(AccountType.UNKNOWN);
                            SapiWebView.this.au = null;
                        }
                    });
                } else {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SapiWebView.this.J != null) {
                                SapiWebView.this.J.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
                            }
                            SapiWebView.this.au = null;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        if (this.J != null) {
            try {
                if (!AuthorizationListener.class.equals(this.J.getClass().getMethod("onSuccess", AccountType.class).getDeclaringClass())) {
                    this.J.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                L.e(e2);
            }
            this.J.onSuccess();
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
            return UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + ",点击发送直接登录";
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
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.w).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.6
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
                            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.r);
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
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.r);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSystemError(int i2) {
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.r);
                    }
                }, i);
                return;
            }
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.r);
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
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&username=" + str + SapiWebView.u);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        String line1Number = SapiUtils.checkRequestPermission("android.permission.READ_PHONE_STATE", getContext()) ? ((TelephonyManager) getContext().getSystemService("phone")).getLine1Number() : null;
        if (TextUtils.isEmpty(line1Number)) {
            return null;
        }
        return line1Number.replace("+86", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.al == null) {
            this.al = new SMSReceiver(handler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(this.al, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.al != null) {
            try {
                getContext().unregisterReceiver(this.al);
            } catch (Throwable th) {
            }
        }
        this.al = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SMSReceiver extends BroadcastReceiver {
        private Handler a;

        public SMSReceiver(Handler handler) {
            this.a = handler;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                Object[] objArr = (Object[]) intent.getExtras().get("pdus");
                SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                    String a = a(smsMessageArr[i].getMessageBody());
                    if (this.a != null) {
                        Message obtainMessage = this.a.obtainMessage();
                        obtainMessage.obj = a;
                        this.a.sendMessage(obtainMessage);
                    }
                }
            } catch (Throwable th) {
                L.e(th, th.getMessage(), new Object[0]);
            }
        }

        private String a(String str) {
            String[] split;
            for (String str2 : str.replaceAll("[^0-9]*([0-9]*)[^0-9]*", "$1-").split("-")) {
                if (str2.length() == 6) {
                    return str2;
                }
            }
            return "";
        }
    }

    static String c(String str) {
        try {
            String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(m)) {
                    str = str.replace(l, "<link type=\"text/css\" rel=\"stylesheet\" href=\"" + str2 + "\">");
                } else {
                    str = str.replace(l, "");
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return str;
    }

    String a() {
        return SapiUtils.buildBDUSSCookie(this.H.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", ""), "BIND_BDUSS", "");
    }

    void b() {
        List<String> g2 = c.a(getContext()).k().g();
        ArrayList arrayList = new ArrayList();
        String replaceAll = this.H.environment.getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
        if (g2.size() == 1 && g2.get(0).equals("di")) {
            String b2 = com.baidu.sapi2.utils.d.b(f.B);
            if (!TextUtils.isEmpty(b2)) {
                arrayList.add(new BasicNameValuePair(this.H.environment.getWap(), SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", b2)));
            }
        } else {
            String a2 = com.baidu.sapi2.utils.d.a(g2);
            if (!TextUtils.isEmpty(a2)) {
                arrayList.add(new BasicNameValuePair(this.H.environment.getWap(), SapiUtils.buildDeviceInfoCookie(replaceAll, "DVIF", a2)));
            }
        }
        SapiUtils.syncCookies(getContext(), arrayList);
    }

    static String a(String str, String str2) {
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
    public void k() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.33
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.ag != null && SapiWebView.this.ag.isShowing()) {
                    try {
                        SapiWebView.this.ag.dismiss();
                    } catch (Throwable th) {
                        L.e(th);
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
