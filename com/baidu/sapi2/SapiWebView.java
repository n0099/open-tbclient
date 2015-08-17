package com.baidu.sapi2;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.os.Message;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
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
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.plugin.SSOError;
import com.baidu.sapi2.plugin.SSOListener;
import com.baidu.sapi2.plugin.sso.SsoHandler;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    private static final int a = 1;
    private static final String ad = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final int b = 0;
    private static final String c = "http://www.baidu.com";
    private static final String d = "__wp-action";
    private static final String e = "auth-widget";
    private static final String f = "forget-pwd";
    private static final String g = "modify-pwd";
    private static final String h = "text/html";
    private static final String i = "UTF-8";
    private static final String j = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    private static final String k = "file:///android_asset";
    private static final String l = "#login";
    private static final String m = "#authPwd";
    private static final String n = "#reg";
    private static final String o = "#canshare_accounts";
    private static final String p = "#sms_login";
    private static final String q = "#fastReg";
    private static final String r = "#fastRegSuccess";
    private static final String s = "#fastRegVerify";
    private static final String t = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    private static final String u = "发送一条短信，即可完成注册。";
    private static final String v = "服务错误，请稍后重试";
    private static final String w = "微信未安装";
    private Handler A;
    private Handler B;
    private FastRegHandler C;
    private VoiceLoginHandler D;
    private NMLoginHandler E;
    private LCLoginHandler F;
    private UniteVerifyHandler G;
    private WeixinHandler H;
    private QuickLoginHandler I;
    private ChangePwdCallback J;
    private AuthWidgetCallback K;
    private BindWidgetCallback L;
    private UniteVerifyCallback M;
    private UniteBindCallback N;
    private SsoHandler O;
    private View P;
    private View Q;
    private ProgressBar R;
    private ProgressDialog S;
    private long T;
    private Handler U;
    private TimeoutTask V;
    private BroadcastReceiver W;
    private SmsHandler Z;
    private Runnable aa;
    private OnFinishCallback ab;
    private OnBackCallback ac;
    private FastRegAction ae;
    private SapiAccountResponse af;
    private SapiCallback<LoginResult> ag;
    private SapiConfiguration x;
    private AuthorizationListener y;
    private Handler z;
    public static final NameValuePair EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN = new BasicNameValuePair("smsfastlogin", "1");
    public static final NameValuePair EXTRA_BIND_WIDGET_CONFLICT_DETECT = new BasicNameValuePair("bindToSmsLogin", "1");

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
    public interface UniteBindCallback {
        void onSuccess(String str, String str2, SapiAccount sapiAccount);
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
                SapiWebView.this.U.sendMessage(message);
                SapiWebView.this.U.removeCallbacks(this);
            }
        }

        public void setUrl(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.ab = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.ac = onBackCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.U = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.d();
                }
            }
        };
        this.V = new TimeoutTask();
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.U = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.d();
                }
            }
        };
        this.V = new TimeoutTask();
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.U = new Handler() { // from class: com.baidu.sapi2.SapiWebView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    SapiWebView.this.d();
                }
            }
        };
        this.V = new TimeoutTask();
        a();
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

    private void a() {
        this.T = DEFAULT_TIMEOUT_MILLIS;
        this.x = SapiAccountManager.getInstance().getSapiConfiguration();
        b();
        addJavascriptInterface(new SapiWebViewShell(), "sapi_obj");
        setWebViewClient(new WebViewClient() { // from class: com.baidu.sapi2.SapiWebView.2
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
                        if (SapiWebView.this.ag != null) {
                            Uri parse = Uri.parse(str);
                            if (SapiWebView.this.x.environment.getWap().equals(parse.getScheme() + "://" + parse.getHost() + (parse.getPort() == -1 ? "" : ":" + parse.getPort())) && com.baidu.sapi2.utils.d.b.equals(parse.getPath())) {
                                SapiAccountManager.getInstance().getAccountService().a(SapiWebView.this.ag, str);
                                return true;
                            }
                        }
                    }
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Uri parse;
                Uri parse2;
                super.onPageStarted(webView, str, bitmap);
                SapiWebView.this.V.setUrl(str);
                SapiWebView.this.U.postDelayed(SapiWebView.this.V, SapiWebView.this.T);
                if (str != null) {
                    if (str.contains("__wp-action=auth-widget") && (parse2 = Uri.parse(str)) != null) {
                        final String queryParameter = parse2.getQueryParameter("authsid");
                        if (!TextUtils.isEmpty(queryParameter) && SapiWebView.this.K != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SapiWebView.this.K.onSuccess(queryParameter);
                                }
                            });
                        }
                    }
                    if ((str.contains(SapiWebView.f) || str.contains(SapiWebView.g)) && (parse = Uri.parse(str)) != null) {
                        String queryParameter2 = parse.getQueryParameter(SapiWebView.d);
                        if ((SapiWebView.f.equals(queryParameter2) || SapiWebView.g.equals(queryParameter2)) && SapiWebView.this.J != null) {
                            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    SapiWebView.this.stopLoading();
                                    SapiWebView.this.J.onSuccess();
                                }
                            });
                        }
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (Build.VERSION.SDK_INT > 7) {
                    SapiWebView.this.getSettings().setBlockNetworkLoads(false);
                }
                SapiWebView.this.loadUrl(SapiWebView.ad);
                if (str.contains(SapiAccountManager.getInstance().getAccountService().m()) || str.contains(SapiAccountManager.getInstance().getAccountService().n()) || str.contains(SapiAccountManager.getInstance().getAccountService().l())) {
                    SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.getElementsByTagName('html')[0].innerHTML, 1);");
                }
                if (str.contains(SapiAccountManager.getInstance().getAccountService().i())) {
                    SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.body.innerHTML, 0);");
                }
                SapiWebView.this.U.removeCallbacks(SapiWebView.this.V);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (Build.VERSION.SDK_INT > 10) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                } else {
                    sslErrorHandler.proceed();
                }
            }
        });
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
            public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                quotaUpdater.updateQuota(2 * j2);
            }
        });
        if (this.y == null) {
            this.y = new DefaultAuthorizationListener();
        }
        if (this.H == null) {
            this.H = new DefaultWeixinHandler();
        }
        this.Z = new SmsHandler();
        this.aa = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.4
            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.f();
            }
        };
        try {
            resumeTimers();
        } catch (Throwable th) {
            L.e(th);
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
                SapiWebView.this.f();
                removeCallbacks(SapiWebView.this.aa);
            }
        }
    }

    private void b() {
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            L.e(e2);
        }
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
                    L.e(th, th.getMessage(), new Object[0]);
                }
            }
        });
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.y = authorizationListener;
    }

    public void setQrAppLoginHandler(Handler handler) {
        this.A = handler;
    }

    public void setDeviceLoginHandler(Handler handler) {
        this.B = handler;
    }

    public void setFastRegHandler(FastRegHandler fastRegHandler) {
        this.C = fastRegHandler;
    }

    public void setVoiceLoginHandler(VoiceLoginHandler voiceLoginHandler) {
        this.D = voiceLoginHandler;
    }

    public void setNmLoginHandler(NMLoginHandler nMLoginHandler) {
        this.E = nMLoginHandler;
    }

    public void setLcLoginHandler(LCLoginHandler lCLoginHandler) {
        this.F = lCLoginHandler;
    }

    public void setWeixinHandler(WeixinHandler weixinHandler) {
        this.H = weixinHandler;
    }

    public void setUniteVerifyHandler(UniteVerifyHandler uniteVerifyHandler) {
        this.G = uniteVerifyHandler;
    }

    public void setChangePwdCallback(ChangePwdCallback changePwdCallback) {
        this.J = changePwdCallback;
    }

    public void setAuthWidgetCallback(AuthWidgetCallback authWidgetCallback) {
        this.K = authWidgetCallback;
    }

    public void setBindWidgetCallback(BindWidgetCallback bindWidgetCallback) {
        this.L = bindWidgetCallback;
    }

    public void setUniteVerifyCallback(UniteVerifyCallback uniteVerifyCallback) {
        this.M = uniteVerifyCallback;
    }

    public void setUniteBindCallback(UniteBindCallback uniteBindCallback) {
        this.N = uniteBindCallback;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.z = handler;
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
            a(i2, list, this.x.customActionBarEnabled);
            return;
        }
        String a2 = a(SapiAccountManager.getInstance().getAccountService().a(), list);
        switch (i2) {
            case 0:
                loadUrl(a2 + l);
                return;
            case 1:
                loadUrl(a2 + p);
                return;
            case 2:
                if (this.C != null) {
                    post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            SapiWebView.this.C.handleFastReg();
                        }
                    });
                    return;
                } else {
                    loadFastReg();
                    return;
                }
            default:
                loadUrl(a2 + l);
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
            str2 = "disusername=" + URLEncoder.encode(str, i);
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        if (!TextUtils.isEmpty(str2)) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&" + str2 + m);
        } else {
            loadLogin();
        }
    }

    @Deprecated
    public void loadSmsLogin() {
        if (SapiAccountManager.getInstance().getShareAccounts().size() > 0) {
            c();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + p);
        }
    }

    public void loadQuickLogin(QuickLoginHandler quickLoginHandler) {
        if (quickLoginHandler == null) {
            throw new IllegalArgumentException(QuickLoginHandler.class.getSimpleName() + " can't be null");
        }
        this.I = quickLoginHandler;
        a(3, null, true);
    }

    private void c() {
        a(0, null, this.x.customActionBarEnabled);
    }

    private void a(int i2, List<NameValuePair> list, boolean z) {
        String str = SapiAccountManager.getInstance().getAccountService().a() + "&loginInitType=" + a(i2);
        if (z && !this.x.customActionBarEnabled) {
            str = str + "&adapter=3";
        }
        loadUrl(a(str, list) + o);
    }

    private int a(int i2) {
        if (i2 == 0) {
            return this.x.smsLoginConfig.flagLoginBtnType.ordinal();
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
        this.ag = sapiCallback;
        loadUrl(str);
    }

    public void loadRegist() {
        loadRegist(null);
    }

    public void loadRegist(List<NameValuePair> list) {
        String a2 = SapiAccountManager.getInstance().getAccountService().a();
        if (this.x.quickUserEnabled && this.x.registMode == RegistMode.QUICK_USER) {
            a2 = a2.replace("regtype=2", "regtype=1");
        }
        loadUrl(a(a2, list) + n);
    }

    private String a(String str, List<NameValuePair> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    try {
                        arrayList.add(new BasicNameValuePair(URLEncoder.encode(nameValuePair.getName(), i), URLEncoder.encode(nameValuePair.getValue(), i)));
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
        if (!this.x.quickUserEnabled) {
            loadRegist();
            return;
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a();
        if (this.x.registMode != RegistMode.QUICK_USER) {
            a2 = a2 + "&regtype=2";
        }
        loadUrl(a2 + n);
    }

    public void loadModifyPwd(String str) {
        loadModifyPwd(str, null);
    }

    public void loadModifyPwd(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), str);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=modify-pwd", i)));
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
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.x.environment.getWap(), "BIND_BDUSS=" + str + ";domain=" + this.x.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/"));
        loadUrl(c2, arrayList2);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=forget-pwd", i)));
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
        loadUrl(this.x.environment.getWap() + "/passport/agreement?adapter=3");
    }

    public void loadOperationRecord(String str) {
        loadOperationRecord(str, null);
    }

    public void loadOperationRecord(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), str);
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

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, boolean z) {
        loadBindWidget(bindWidgetAction, str, null, z, null);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2, boolean z, List<NameValuePair> list) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        if (z) {
            arrayList.add(new BasicNameValuePair("skip", "1"));
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        String a3 = a(a2, list);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.x.environment.getWap(), "BIND_BDUSS=" + str + ";domain=" + this.x.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/"));
        loadUrl(a3, arrayList2);
    }

    public void loadAuthWidget(String str, String str2) {
        loadAuthWidget(str, str2, null);
    }

    public void loadAuthWidget(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("authToken can't be empty");
        }
        SapiUtils.webLogin(getContext(), str);
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair(SocialConstants.TOKEN_RESPONSE_TYPE, URLEncoder.encode(str2, i)));
            arrayList.add(new BasicNameValuePair("u", URLEncoder.encode("http://www.baidu.com?__wp-action=auth-widget", i)));
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

    public void loadFillUProfile(String str, boolean z) {
        loadFillUProfile(str, z, null);
    }

    public void loadFillUProfile(String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        SapiUtils.webLogin(getContext(), str);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        if (z) {
            arrayList.add(new BasicNameValuePair("simplify", "1"));
        }
        String h2 = SapiAccountManager.getInstance().getAccountService().h();
        if (arrayList.size() > 0) {
            h2 = h2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(h2);
    }

    public void loadUniteVerify(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid Params: verifyToken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair(SocialConstants.TOKEN_RESPONSE_TYPE, URLEncoder.encode(str, i)));
            if (str2 != null) {
                arrayList.add(new BasicNameValuePair("u", str2));
            }
            if (str3 != null) {
                arrayList.add(new BasicNameValuePair("adtext", URLEncoder.encode(str3, i)));
            }
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().f() + "&" + SapiUtils.createRequestParams(arrayList));
    }

    public void loadUniteBind(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Invalid params: bindToken can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new BasicNameValuePair(SocialConstants.TOKEN_RESPONSE_TYPE, URLEncoder.encode(str, i)));
            if (str2 != null) {
                arrayList.add(new BasicNameValuePair("u", str2));
            }
        } catch (UnsupportedEncodingException e2) {
            L.e(e2);
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().g() + "&" + SapiUtils.createRequestParams(arrayList));
    }

    public void loadFastReg() {
        if (!SapiUtils.isSimReady(getContext()) || !SapiUtils.hasActiveNetwork(getContext())) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + p);
            return;
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + q);
        this.ae = new FastRegAction();
        this.ae.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.af = sapiAccountResponse;
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + r);
    }

    public long getTimeoutMillis() {
        return this.T;
    }

    public void setTimeoutMillis(long j2) {
        this.T = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<NameValuePair> list) {
        a(getContext(), list);
        String b2 = b(SapiCache.a(getContext(), str));
        if (!TextUtils.isEmpty(b2)) {
            loadDataWithBaseURL(str, b2, h, i, str);
        } else {
            c(str);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(final String str, final String str2, final String str3, final String str4, final String str5) {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.7
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
        b(this.af);
        super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
        if ((this.P != null && this.P.getVisibility() == 0) || (this.Q != null && this.Q.getVisibility() == 0)) {
            finish();
        }
    }

    public void finish() {
        f();
        if (this.ae != null) {
            this.ae.f = true;
            this.ae.k.removeCallbacks(this.ae.l);
        }
        if (this.ab != null) {
            this.ab.onFinish();
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (this.O != null) {
            this.O.authorizeCallBack(i2, i3, intent);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.ac != null) {
                this.ac.onBack();
            }
            back();
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* loaded from: classes.dex */
    public final class SapiWebViewShell {
        public SapiWebViewShell() {
        }

        @JavascriptInterface
        public void sapi_cloud_log_op(String str, String str2, long j, long j2) {
        }

        @JavascriptInterface
        public void sapi_cloud_log_op_net(String str, String str2, long j, long j2) {
        }

        @JavascriptInterface
        public String config_fastlogin_features() {
            List<FastLoginFeature> list = SapiWebView.this.x.fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            if (!d.a(SapiWebView.this.getContext()).b() && list.contains(FastLoginFeature.DEVICE_LOGIN)) {
                list.remove(FastLoginFeature.DEVICE_LOGIN);
            }
            StringBuilder sb = new StringBuilder();
            if (d.a(SapiWebView.this.getContext()).c()) {
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

        @JavascriptInterface
        public String config_login_share_strategy() {
            return SapiWebView.this.x.loginShareStrategy().getStrValue();
        }

        @JavascriptInterface
        public String config_canshare_accounts() {
            JSONArray jSONArray = SapiAccount.toJSONArray(SapiAccountManager.getInstance().getShareAccounts());
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }

        @JavascriptInterface
        public void action_remove_share_account(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (SapiAccount sapiAccount : SapiAccountManager.getInstance().getShareAccounts()) {
                    if (str.equals(sapiAccount.uid)) {
                        com.baidu.sapi2.share.b.a().b(sapiAccount);
                        return;
                    }
                }
            }
        }

        @JavascriptInterface
        public void action_share_accounts_view_btn_clicked() {
            if (SapiWebView.this.I != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.I.handleOtherLogin();
                    }
                });
            }
        }

        @JavascriptInterface
        public void action_bind_widget_phone_number_exist(final String str) {
            if (SapiWebView.this.L != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.L.onPhoneNumberExist(str);
                    }
                });
            }
        }

        @JavascriptInterface
        public void finish() {
            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.3
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.finish();
                }
            });
        }

        @JavascriptInterface
        public void back() {
            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.4
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.back();
                }
            });
        }

        @JavascriptInterface
        public void authorized_response(String str) {
            authorized_response(str, 0);
        }

        @JavascriptInterface
        public void authorized_response(String str, int i) {
            if (i == 1) {
                final SapiAccountResponse a = SapiWebView.a(SapiWebView.this.x.context, str);
                if (a == null) {
                    if (SapiWebView.this.y != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.5
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.y.onFailed(-100, "登录失败");
                            }
                        });
                    }
                } else if (a.errorCode == 0 || a.errorCode == 110000) {
                    if (SapiWebView.this.y != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.6
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.y.onSuccess();
                            }
                        });
                    }
                } else if (SapiWebView.this.y != null) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.7
                        @Override // java.lang.Runnable
                        public void run() {
                            SapiWebView.this.y.onFailed(a.errorCode, a.errorMsg);
                        }
                    });
                }
            }
            if (i == 0) {
                final SapiAccountResponse a2 = SapiWebView.a(str);
                if (a2 == null) {
                    if (SapiWebView.this.y != null) {
                        SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.8
                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView.this.y.onFailed(-100, "登录失败");
                            }
                        });
                    }
                } else if (SapiWebView.this.ae != null && a2.newReg) {
                    SapiWebView.this.af = a2;
                    SapiWebView.this.a(a2);
                } else if (a2.errorCode == 0 || a2.errorCode == 110000) {
                    SapiWebView.this.b(a2);
                } else if (SapiWebView.this.y != null) {
                    SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.9
                        @Override // java.lang.Runnable
                        public void run() {
                            SapiWebView.this.y.onFailed(a2.errorCode, a2.errorMsg);
                        }
                    });
                }
            }
        }

        @JavascriptInterface
        public void unite_verify_result(final String str) {
            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String optString = jSONObject.optString(LoginActivityConfig.INFO);
                        String optString2 = jSONObject.optString("u");
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.uid = jSONObject.optString("passuid");
                        sapiAccount.username = jSONObject.optString("username");
                        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        sapiAccount.bduss = jSONObject.optString("bduss");
                        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                        sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                        if (!TextUtils.isEmpty(optString) && SapiUtils.isValidAccount(sapiAccount)) {
                            if (SapiWebView.this.M != null) {
                                SapiWebView.this.M.onSuccess(optString, optString2, sapiAccount);
                            }
                            if (SapiWebView.this.N != null) {
                                SapiWebView.this.N.onSuccess(optString, optString2, sapiAccount);
                            }
                        }
                    } catch (JSONException e) {
                        L.e(e);
                    }
                }
            });
        }

        @JavascriptInterface
        public void action_fast_reg() {
            if (SapiWebView.this.C != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.11
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.C.handleFastReg();
                    }
                });
            } else {
                SapiWebView.this.loadFastReg();
            }
        }

        @JavascriptInterface
        public String action_forget_pwd() {
            final boolean[] zArr = {false};
            final boolean[] zArr2 = {false};
            SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.12
                @Override // java.lang.Runnable
                public void run() {
                    if (SapiWebView.this.y != null) {
                        zArr[0] = SapiWebView.this.y.onForgetPwd();
                    }
                    zArr2[0] = true;
                }
            });
            while (!zArr2[0]) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    L.e(e);
                }
            }
            return zArr[0] ? "1" : "0";
        }

        @JavascriptInterface
        public void action_received_sms_code(String str, String str2) {
            SapiWebView.this.a(SapiWebView.this.Z);
            SapiWebView.this.Z.a = str;
            SapiWebView.this.Z.b = str2;
            SapiWebView.this.Z.postDelayed(SapiWebView.this.aa, 15000L);
        }

        @JavascriptInterface
        public void set_pass_canceled() {
            SapiWebView.this.b(SapiWebView.this.af);
        }

        @JavascriptInterface
        public String get_preset_phone_number() {
            return SapiUtils.isValidPhoneNumber(SapiWebView.this.x.presetPhoneNumber) ? SapiWebView.this.x.presetPhoneNumber : "";
        }

        @JavascriptInterface
        public void action_social_sina_sso() {
            SapiWebView.this.loadSinaSSOLogin();
        }

        @JavascriptInterface
        public void action_social_weixin_sso() {
            if (SapiWebView.this.z != null) {
                Message message = new Message();
                message.what = SocialType.WEIXIN.getType();
                SapiWebView.this.z.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_qzone_webview() {
            if (SapiWebView.this.z != null) {
                Message message = new Message();
                message.what = SocialType.QZONE.getType();
                SapiWebView.this.z.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_tx_weibo_webview() {
            if (SapiWebView.this.z != null) {
                Message message = new Message();
                message.what = SocialType.TENCENT_WEIBO.getType();
                SapiWebView.this.z.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_sina_weibo_webview() {
            if (SapiWebView.this.z != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                SapiWebView.this.z.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_renren_webview() {
            if (SapiWebView.this.z != null) {
                Message message = new Message();
                message.what = SocialType.RENREN.getType();
                SapiWebView.this.z.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_nuomi_login() {
            if (SapiWebView.this.E != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.13
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.E.handleNMLogin();
                    }
                });
            }
        }

        @JavascriptInterface
        public void action_lecai_login() {
            if (SapiWebView.this.F != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.14
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.F.handleLCLogin();
                    }
                });
            }
        }

        @JavascriptInterface
        public void action_voice_login() {
            if (SapiWebView.this.D != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.15
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.D.handleVoiceLogin();
                    }
                });
            }
        }

        @JavascriptInterface
        public void action_unite_verify(final String str) {
            if (SapiWebView.this.G != null) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.SapiWebViewShell.16
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            SapiWebView.this.G.handleUniteVerify(jSONObject.optString(SocialConstants.TOKEN_RESPONSE_TYPE), jSONObject.optString("adtext"));
                        } catch (JSONException e) {
                            L.e(e);
                        }
                    }
                });
            }
        }

        @JavascriptInterface
        public void loginWithQRCode() {
            if (SapiWebView.this.A != null) {
                SapiWebView.this.A.sendMessage(new Message());
            }
        }

        @JavascriptInterface
        public void loginWithDeviceId() {
            if (SapiWebView.this.B != null) {
                SapiWebView.this.B.sendMessage(new Message());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static SapiAccountResponse a(String str) {
        SapiAccountResponse sapiAccountResponse;
        Throwable th;
        SapiAccountResponse sapiAccountResponse2 = null;
        String a2 = a("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(a2)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), i);
                sapiAccountResponse = null;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    switch (eventType) {
                        case 2:
                            try {
                                String name = newPullParser.getName();
                                if (name.equalsIgnoreCase("data")) {
                                    if (sapiAccountResponse == null) {
                                        sapiAccountResponse = new SapiAccountResponse();
                                        continue;
                                    } else {
                                        continue;
                                    }
                                } else if (sapiAccountResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                                    SapiAccountResponse sapiAccountResponse3 = new SapiAccountResponse();
                                    try {
                                        sapiAccountResponse3.errorCode = Integer.parseInt(newPullParser.nextText());
                                        sapiAccountResponse = sapiAccountResponse3;
                                        continue;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        sapiAccountResponse = sapiAccountResponse3;
                                        L.e(th);
                                        sapiAccountResponse2 = sapiAccountResponse;
                                        if (sapiAccountResponse2 != null) {
                                        }
                                        return sapiAccountResponse2;
                                    }
                                } else if (sapiAccountResponse == null && name.equalsIgnoreCase("error_description")) {
                                    SapiAccountResponse sapiAccountResponse4 = new SapiAccountResponse();
                                    try {
                                        sapiAccountResponse4.errorMsg = newPullParser.nextText();
                                        sapiAccountResponse = sapiAccountResponse4;
                                        continue;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sapiAccountResponse = sapiAccountResponse4;
                                        L.e(th);
                                        sapiAccountResponse2 = sapiAccountResponse;
                                        if (sapiAccountResponse2 != null) {
                                            sapiAccountResponse2.errorCode = 0;
                                            break;
                                        }
                                        return sapiAccountResponse2;
                                    }
                                } else if (sapiAccountResponse == null) {
                                    continue;
                                } else if (name.equalsIgnoreCase("errno")) {
                                    sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                    continue;
                                } else if (name.equalsIgnoreCase("uname")) {
                                    sapiAccountResponse.username = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("errmsg")) {
                                    sapiAccountResponse.errorMsg = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("bduss")) {
                                    sapiAccountResponse.bduss = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                    sapiAccountResponse.ptoken = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_STOKEN)) {
                                    sapiAccountResponse.stoken = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                    sapiAccountResponse.displayname = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("uid")) {
                                    sapiAccountResponse.uid = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("authsid")) {
                                    sapiAccountResponse.authSid = newPullParser.nextText();
                                    sapiAccountResponse.newReg = !TextUtils.isEmpty(sapiAccountResponse.authSid);
                                    continue;
                                } else if (name.equalsIgnoreCase(LoginActivityConfig.ACCOUNT)) {
                                    sapiAccountResponse.reloginCredentials.account = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("accounttype")) {
                                    sapiAccountResponse.reloginCredentials.accountType = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("password")) {
                                    sapiAccountResponse.reloginCredentials.password = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("ubi")) {
                                    sapiAccountResponse.reloginCredentials.ubi = newPullParser.nextText();
                                    continue;
                                } else {
                                    continue;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            break;
                    }
                }
                sapiAccountResponse2 = sapiAccountResponse;
            } catch (Throwable th5) {
                sapiAccountResponse = null;
                th = th5;
            }
            if (sapiAccountResponse2 != null && !TextUtils.isEmpty(sapiAccountResponse2.bduss) && sapiAccountResponse2.errorCode == -100) {
                sapiAccountResponse2.errorCode = 0;
            }
        }
        return sapiAccountResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static SapiAccountResponse a(Context context, String str) {
        SocialResponse socialResponse;
        Exception e2;
        SocialResponse socialResponse2 = null;
        String a2 = a("<client>([\\S\\s]*?)</client>", str);
        if (!TextUtils.isEmpty(a2)) {
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), i);
                socialResponse = null;
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    switch (eventType) {
                        case 2:
                            try {
                                String name = newPullParser.getName();
                                if (name.equalsIgnoreCase("data")) {
                                    if (socialResponse == null) {
                                        socialResponse = new SocialResponse();
                                        continue;
                                    } else {
                                        continue;
                                    }
                                } else if (socialResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                                    SocialResponse socialResponse3 = new SocialResponse();
                                    try {
                                        socialResponse3.errorCode = Integer.parseInt(newPullParser.nextText());
                                        socialResponse = socialResponse3;
                                        continue;
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        socialResponse = socialResponse3;
                                        L.e(e2);
                                        socialResponse2 = socialResponse;
                                        if (socialResponse2 != null) {
                                        }
                                        return socialResponse2;
                                    }
                                } else if (socialResponse == null && name.equalsIgnoreCase("error_description")) {
                                    SocialResponse socialResponse4 = new SocialResponse();
                                    try {
                                        socialResponse4.errorMsg = newPullParser.nextText();
                                        socialResponse = socialResponse4;
                                        continue;
                                    } catch (Exception e4) {
                                        e2 = e4;
                                        socialResponse = socialResponse4;
                                        L.e(e2);
                                        socialResponse2 = socialResponse;
                                        if (socialResponse2 != null) {
                                        }
                                        return socialResponse2;
                                    }
                                } else if (socialResponse == null) {
                                    continue;
                                } else if (name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                    continue;
                                } else if (name.equalsIgnoreCase("error_description")) {
                                    socialResponse.errorMsg = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("is_binded")) {
                                    socialResponse.isBinded = newPullParser.nextText().equals("1");
                                    continue;
                                } else if (name.equalsIgnoreCase("display_name")) {
                                    socialResponse.displayname = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("passport_uname")) {
                                    socialResponse.username = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("bduid")) {
                                    socialResponse.uid = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("bduss")) {
                                    socialResponse.bduss = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                    socialResponse.ptoken = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("os_username")) {
                                    socialResponse.socialUname = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("os_headurl")) {
                                    socialResponse.socialPortraitUrl = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("os_type")) {
                                    socialResponse.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                    continue;
                                } else {
                                    continue;
                                }
                            } catch (Exception e5) {
                                e2 = e5;
                            }
                            break;
                    }
                }
                socialResponse2 = socialResponse;
            } catch (Exception e6) {
                socialResponse = null;
                e2 = e6;
            }
            if (socialResponse2 != null) {
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = socialResponse2.uid;
                sapiAccount.bduss = socialResponse2.bduss;
                sapiAccount.displayname = socialResponse2.displayname;
                sapiAccount.username = socialResponse2.username;
                sapiAccount.stoken = socialResponse2.stoken;
                sapiAccount.ptoken = socialResponse2.ptoken;
                sapiAccount.app = SapiUtils.getAppName(context);
                com.baidu.sapi2.utils.c.a(sapiAccount, socialResponse2.socialType, socialResponse2.socialPortraitUrl);
                if (SapiUtils.isValidAccount(sapiAccount)) {
                    socialResponse2.errorCode = 0;
                }
                com.baidu.sapi2.share.b.a().a(sapiAccount);
            }
        }
        return socialResponse2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        stopLoading();
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.R != null) {
                    SapiWebView.this.R.setVisibility(8);
                }
                if (SapiWebView.this.Q != null) {
                    SapiWebView.this.Q.setVisibility(0);
                }
            }
        });
    }

    private void e() {
        post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.9
            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.R != null) {
                    SapiWebView.this.R.setVisibility(8);
                }
                if (SapiWebView.this.P != null) {
                    SapiWebView.this.P.setVisibility(0);
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
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.w, 1).show();
        }

        @Override // com.baidu.sapi2.SapiWebView.WeixinHandler
        public void handleServerError(String str) {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.v, 1).show();
        }
    }

    public void loadSinaSSOLogin() {
        this.O = new SsoHandler((Activity) getContext(), com.baidu.sapi2.utils.d.j, c);
        this.O.authorize(new SSOListener() { // from class: com.baidu.sapi2.SapiWebView.10
            public void onComplete(Bundle bundle) {
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.SINA_WEIBO, bundle.getString(SocialConstants.PARAM_ACCESS_TOKEN), bundle.getString("uid")));
            }

            public void onJumpNormal() {
                if (SapiWebView.this.z != null) {
                    Message message = new Message();
                    message.what = SocialType.SINA_WEIBO.getType();
                    SapiWebView.this.z.sendMessage(message);
                }
            }

            public void onError(SSOError sSOError) {
                L.e(sSOError);
                Toast.makeText(SapiWebView.this.getContext(), sSOError.getMessage(), 0).show();
            }

            public void onCancel() {
            }
        });
        if (d.a(getContext()).c()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.t, 0).show();
                }
            });
        }
    }

    public void loadWeixinSSOLogin() {
        if (!WXAPIFactory.createWXAPI(getContext(), this.x.wxAppID).isWXAppInstalled()) {
            if (this.H != null) {
                this.H.handleNotInstall();
                return;
            }
            return;
        }
        new AsyncHttpClient().get(getContext(), SapiAccountManager.getInstance().getAccountService().k(), new HttpResponseHandler() { // from class: com.baidu.sapi2.SapiWebView.12
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                try {
                    SapiWebView.this.S = ProgressDialog.show(SapiWebView.this.getContext(), null, "加载中...", true);
                } catch (Throwable th) {
                    L.e(th);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                if (SapiWebView.this.S != null) {
                    try {
                        SapiWebView.this.S.dismiss();
                    } catch (Throwable th) {
                        L.e(th);
                    }
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (SapiWebView.this.P != null) {
                    SapiWebView.this.P.setVisibility(0);
                } else {
                    SapiWebView.this.H.handleServerError(str);
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
                        WXAPIFactory.createWXAPI(SapiWebView.this.getContext(), SapiWebView.this.x.wxAppID).sendReq(req);
                        SapiWebView.this.finish();
                    } else {
                        String optString2 = jSONObject.optString(SocialConstants.PARAM_ERROR_CODE, "");
                        if (SapiWebView.this.H != null) {
                            SapiWebView.this.H.handleServerError(optString2);
                        }
                    }
                } catch (JSONException e2) {
                    L.e(e2);
                }
            }
        });
    }

    public void weixinSSOLogin(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a(str, str2);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BasicNameValuePair(this.x.environment.getURL(), "mkey=" + str2 + ";domain=." + this.x.environment.getURL().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/"));
        loadUrl(a2, arrayList);
    }

    public void loadSocialLogin(SocialType socialType) {
        loadSocialLogin(socialType, false);
    }

    public void loadSocialLogin(SocialType socialType, boolean z) {
        if (socialType == null) {
            throw new IllegalArgumentException("SocialType can't be null");
        }
        if (socialType == SocialType.UNKNOWN) {
            throw new IllegalArgumentException("Unknown SocialType");
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a(socialType);
        if (z) {
            a2 = a2 + "&is_force_login=1";
        }
        loadUrl(a2);
        if (d.a(getContext()).c()) {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(SapiWebView.this.getContext(), SapiWebView.t, 0).show();
                }
            });
        }
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

    private void c(final String str) {
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            e();
        } else {
            post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.super.loadUrl(str);
                }
            });
        }
    }

    void a(Context context, List<NameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        if (TextUtils.isEmpty(this.x.clientId)) {
            this.x.clientId = SapiUtils.getClientId(getContext());
        }
        cookieManager.setCookie(this.x.environment.getWap(), "cuid=" + this.x.clientId + ";domain=" + this.x.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/");
        if (list != null) {
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    cookieManager.setCookie(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        CookieSyncManager.getInstance().sync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SapiAccountResponse sapiAccountResponse) {
        if (sapiAccountResponse != null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = sapiAccountResponse.uid;
            sapiAccount.bduss = sapiAccountResponse.bduss;
            sapiAccount.displayname = sapiAccountResponse.displayname;
            sapiAccount.stoken = sapiAccountResponse.stoken;
            sapiAccount.ptoken = sapiAccountResponse.ptoken;
            sapiAccount.email = sapiAccountResponse.email;
            sapiAccount.username = sapiAccountResponse.username;
            sapiAccount.app = SapiUtils.getAppName(getContext());
            d.a(getContext()).a(sapiAccountResponse.uid, sapiAccountResponse.reloginCredentials);
            com.baidu.sapi2.share.b.a().a(sapiAccount);
            if (this.y != null) {
                post(new Runnable() { // from class: com.baidu.sapi2.SapiWebView.15
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView.this.y.onSuccess();
                    }
                });
            }
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
                        String f = FastRegAction.this.f();
                        if (!TextUtils.isEmpty(f) && FastRegAction.this.j == 1) {
                            FastRegAction.this.a(f, str);
                        }
                        SapiWebView.this.f();
                        FastRegAction.this.k.removeCallbacks(FastRegAction.this.l);
                    }
                }
            };
            this.l = new Runnable() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.4
                @Override // java.lang.Runnable
                public void run() {
                    SapiWebView.this.f();
                    FastRegAction.this.a(FastRegAction.this.f());
                }
            };
        }

        private String a() {
            return UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + ",点击发送直接注册";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                this.d = a();
            }
            if (!SapiUtils.isSimReady(SapiWebView.this.getContext())) {
                e();
            } else if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                if (SapiWebView.this.x.fastRegConfirm) {
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.u).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (SapiUtils.sendSms(SapiWebView.this.getContext(), FastRegAction.this.d, SapiUtils.getFastRegChannel(SapiWebView.this.getContext()))) {
                                FastRegAction.this.g.postDelayed(FastRegAction.this.h, 15000L);
                                FastRegAction.this.e = false;
                                FastRegAction.this.d();
                                return;
                            }
                            FastRegAction.this.e();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.p);
                        }
                    }).create();
                    if (!TextUtils.isEmpty(SapiWebView.this.x.fastRegConfirmMsg)) {
                        create.setMessage(SapiWebView.this.x.fastRegConfirmMsg);
                    }
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                } else if (SapiUtils.sendSms(SapiWebView.this.getContext(), this.d, SapiUtils.getFastRegChannel(SapiWebView.this.getContext()))) {
                    this.g.postDelayed(this.h, 15000L);
                    this.e = false;
                    d();
                } else {
                    e();
                }
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
            String f = f();
            if (!TextUtils.isEmpty(f)) {
                this.j = 1;
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new SapiCallBack<SapiResponse>() { // from class: com.baidu.sapi2.SapiWebView.FastRegAction.8
                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSuccess(SapiResponse sapiResponse) {
                        SapiWebView.this.a(FastRegAction.this.i);
                        FastRegAction.this.k.postDelayed(FastRegAction.this.l, 15000L);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onNetworkFailed() {
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.p);
                    }

                    @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                    public void onSystemError(int i) {
                        SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.p);
                    }
                }, f);
                return;
            }
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.p);
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
                    FastRegAction.this.a(FastRegAction.this.f());
                }

                @Override // com.baidu.sapi2.shell.callback.SapiCallBack
                public void onSystemError(int i) {
                    FastRegAction.this.a(FastRegAction.this.f());
                }
            }, str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&username=" + str + SapiWebView.s);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String f() {
            String line1Number = ((TelephonyManager) SapiWebView.this.getContext().getSystemService("phone")).getLine1Number();
            if (TextUtils.isEmpty(line1Number)) {
                return null;
            }
            return line1Number.replace("+86", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.W == null) {
            this.W = new SMSReceiver(handler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(this.W, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.W != null) {
            try {
                getContext().unregisterReceiver(this.W);
            } catch (Throwable th) {
            }
        }
        this.W = null;
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

    static String b(String str) {
        try {
            String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(k)) {
                    str = str.replace(j, "<link type=\"text/css\" rel=\"stylesheet\" href=\"" + str2 + "\">");
                } else {
                    str = str.replace(j, "");
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return str;
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
}
