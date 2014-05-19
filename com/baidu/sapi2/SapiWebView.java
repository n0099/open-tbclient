package com.baidu.sapi2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.baidu.sapi2.plugin.SSOError;
import com.baidu.sapi2.plugin.SSOListener;
import com.baidu.sapi2.plugin.sso.SsoHandler;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebViewEventListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    private static final String H = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final String K = "2512457640";
    private static final String L = "http://www.baidu.com";
    private static final int a = 1000;
    private static final int b = 1;
    private static final int c = 0;
    private static final String d = "text/html";
    private static final String e = "UTF-8";
    private static final String f = "#login";
    private static final String g = "#reg";
    private static final String h = "#canshare_accounts";
    private static final String i = "#sms_login";
    private static final String j = "#fastReg";
    private static final String k = "#fastRegSuccess";
    private static final String l = "#fastRegVerify";
    private static final String m = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    private static final String n = "已自动识别并填写短信验证码";
    private static final String o = "发送一条短信，即可完成注册。";
    private q A;
    private BroadcastReceiver B;
    private p C;
    private Runnable D;
    private Stack<String> E;
    private OnFinishCallback F;
    private OnBackCallback G;
    private m I;
    private SapiAccountResponse J;
    private SsoHandler M;
    private SapiConfiguration p;
    private AuthorizationListener q;
    private WebViewEventListener r;
    private Handler s;
    private Handler t;
    private View u;
    private View v;
    private String w;
    private ProgressBar x;
    private long y;
    private Handler z;

    /* loaded from: classes.dex */
    public interface OnBackCallback {
        void onBack();
    }

    /* loaded from: classes.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes.dex */
    class q implements Runnable {
        private String b;

        private q() {
        }

        /* synthetic */ q(SapiWebView sapiWebView, com.baidu.sapi2.c cVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.b;
                SapiWebView.this.z.sendMessage(message);
                SapiWebView.this.z.removeCallbacks(this);
            }
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.F = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.G = onBackCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.z = new com.baidu.sapi2.c(this);
        this.A = new q(this, null);
        this.E = new Stack<>();
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = new com.baidu.sapi2.c(this);
        this.A = new q(this, null);
        this.E = new Stack<>();
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = new com.baidu.sapi2.c(this);
        this.A = new q(this, null);
        this.E = new Stack<>();
        a();
    }

    public final void setNoNetworkView(View view) {
        if (this.u == null) {
            this.u = view;
            this.u.setVisibility(4);
            addView(this.u, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.v == null) {
            this.v = view;
            this.v.setVisibility(4);
            addView(this.v, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.x == null) {
            this.x = progressBar;
            if (this.x != null) {
                addView(progressBar);
            }
        }
    }

    public void setSmsAutoCompleteHint(String str) {
        this.w = str;
    }

    private void a() {
        this.y = DEFAULT_TIMEOUT_MILLIS;
        this.w = n;
        this.p = SapiAccountManager.getInstance().getSapiConfiguration();
        b();
        addJavascriptInterface(new SapiWebViewShell(), "sapi_obj");
        setWebViewClient(new d());
        setWebChromeClient(new c());
        setWebViewEventListener(new b());
        if (this.q == null) {
            this.q = new l();
        }
        this.C = new p(this, null);
        this.D = new h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends WebViewClient {
        d() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (a.d(str)) {
                if (str != null && str.startsWith("sms")) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.setFlags(268435456);
                        SapiWebView.this.getContext().startActivity(intent);
                        return true;
                    } catch (Throwable th) {
                        L.e(th, th.getMessage(), new Object[0]);
                        return true;
                    }
                } else if (str != null && str.startsWith("bdscenter")) {
                    try {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent2.setFlags(268435456);
                        SapiWebView.this.getContext().startActivity(intent2);
                        return true;
                    } catch (Throwable th2) {
                        L.e(th2, th2.getMessage(), new Object[0]);
                        return true;
                    }
                } else {
                    SapiWebView.this.loadUrl(str);
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SapiWebView.this.A.a(str);
            SapiWebView.this.z.postDelayed(SapiWebView.this.A, SapiWebView.this.y);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            SapiWebView.this.loadUrl(SapiWebView.H);
            if (SapiWebView.this.r != null && a.b(str)) {
                SapiWebView.this.r.onPageFinished(webView, str);
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().g()) || str.contains(SapiAccountManager.getInstance().getAccountService().h()) || str.contains(SapiAccountManager.getInstance().getAccountService().f())) {
                SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.getElementsByTagName('html')[0].innerHTML, 1);");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().d())) {
                SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.body.innerHTML, 0);");
            }
            SapiWebView.this.z.removeCallbacks(SapiWebView.this.A);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends WebChromeClient {
        c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new a(jsResult));
            positiveButton.setCancelable(false);
            positiveButton.create();
            positiveButton.show();
            return true;
        }

        /* loaded from: classes.dex */
        class a implements DialogInterface.OnClickListener {
            final /* synthetic */ JsResult a;

            a(JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i, String str2) {
            L.d(str + " -- From line " + i + " of " + str2, new Object[0]);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (SapiWebView.this.r != null && webView.getUrl() != null && a.c(webView.getUrl())) {
                SapiWebView.this.r.onProgressChanged(webView, i);
            }
            if (SapiWebView.this.x != null) {
                if (i == 100) {
                    SapiWebView.this.x.setVisibility(8);
                } else {
                    if (SapiWebView.this.x.getVisibility() == 8) {
                        SapiWebView.this.x.setVisibility(0);
                    }
                    SapiWebView.this.x.setProgress(i);
                }
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            quotaUpdater.updateQuota(2 * j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends Handler {
        String a;
        String b;

        private p() {
        }

        /* synthetic */ p(SapiWebView sapiWebView, com.baidu.sapi2.c cVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj != null) {
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                    SapiWebView.this.loadUrl(String.format("javascript:%s('%s','%s');", this.a, str, this.b));
                    if (!TextUtils.isEmpty(SapiWebView.this.w)) {
                        post(new a());
                    }
                }
                SapiWebView.this.f();
                removeCallbacks(SapiWebView.this.D);
            }
        }

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(SapiWebView.this.getContext(), SapiWebView.this.w, 0).show();
            }
        }
    }

    private void b() {
        getSettings().setJavaScriptEnabled(true);
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        setDownloadListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements DownloadListener {
        g() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                SapiWebView.this.getContext().startActivity(intent);
            } catch (Throwable th) {
                L.e(th, th.getMessage(), new Object[0]);
            }
        }
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.q = authorizationListener;
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.r = webViewEventListener;
    }

    public void setQrAppLoginHandler(Handler handler) {
        this.t = handler;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.s = handler;
    }

    public void loadLogin() {
        if (this.p.loginShareStrategy == LoginShareStrategy.CHOICE && SapiAccountManager.getInstance().a().size() > 0) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + h);
            com.baidu.sapi2.utils.a.a.a().a("ht_triggernum", 0L, 0L);
            return;
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + f);
    }

    public void loadSmsLogin() {
        if (this.p.loginShareStrategy == LoginShareStrategy.CHOICE && SapiAccountManager.getInstance().a().size() > 0) {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + h);
            com.baidu.sapi2.utils.a.a.a().a("ht_triggernum", 0L, 0L);
            return;
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + i);
    }

    public void loadRegist() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + g);
    }

    public void loadForgetPwd() {
        loadForgetPwd(null);
    }

    public void loadForgetPwd(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new BasicNameValuePair("skin", str));
        }
        String b2 = SapiAccountManager.getInstance().getAccountService().b();
        if (arrayList.size() > 0) {
            b2 = b2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        loadUrl(b2);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str) {
        loadBindWidget(bindWidgetAction, str, null);
    }

    public void loadBindWidget(BindWidgetAction bindWidgetAction, String str, String str2) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        String a2 = SapiAccountManager.getInstance().getAccountService().a(bindWidgetAction);
        if (arrayList.size() > 0) {
            a2 = a2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(this.p.environment.getWap(), "BIND_BDUSS=" + str + ";domain=" + this.p.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/"));
        loadUrl(a2, arrayList2);
    }

    public void loadFillUProfile(String str) {
        loadFillUProfile(str, null);
    }

    public void loadFillUProfile(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new BasicNameValuePair("skin", str2));
        }
        String c2 = SapiAccountManager.getInstance().getAccountService().c();
        if (arrayList.size() > 0) {
            c2 = c2 + "&" + SapiUtils.createRequestParams(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new BasicNameValuePair(c2, d(str)));
        loadUrl(c2, arrayList2);
    }

    public void loadFastReg() {
        switch (com.baidu.sapi2.d.a(getContext()).h().a()) {
            case FAST:
                c();
                return;
            case NORMAL:
                loadRegist();
                return;
            default:
                c();
                return;
        }
    }

    private void c() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + j);
        this.I = new m();
        this.I.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.J = sapiAccountResponse;
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&username=" + str + l);
    }

    public long getTimeoutMillis() {
        return this.y;
    }

    public void setTimeoutMillis(long j2) {
        this.y = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<NameValuePair> list) {
        a(getContext(), list);
        if (this.r != null && a.a(str)) {
            this.E.push(str);
            this.r.onStartLoading(this, str);
        }
        String a2 = SapiCache.a(getContext(), str);
        if (!TextUtils.isEmpty(a2)) {
            loadDataWithBaseURL(str, a2, d, e, str);
        } else {
            c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        f(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.this.getSettings().setBlockNetworkLoads(true);
            SapiWebView.super.loadDataWithBaseURL(this.a, this.b, this.c, this.d, this.e);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        post(new f(str, str2, str3, str4, str5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.G != null) {
            this.G.onBack();
            return;
        }
        b(this.J);
        super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
        if (canGoBackOrForward(-1)) {
            if (getUrl().contains("baidu.com")) {
                int abs = Math.abs(-1);
                for (int i2 = 0; i2 < abs; i2++) {
                    if (!this.E.isEmpty()) {
                        this.E.pop();
                    }
                }
                if (!this.E.isEmpty()) {
                    String pop = this.E.pop();
                    if (pop.endsWith(h)) {
                        pop = pop.replace(h, f);
                    }
                    loadUrl(pop);
                }
            } else {
                goBackOrForward(-1);
            }
        }
        if ((this.u != null && this.u.getVisibility() == 0) || (this.v != null && this.v.getVisibility() == 0)) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        if (this.I != null) {
            this.I.f = true;
            this.I.k.removeCallbacks(this.I.l);
        }
        if (this.F != null) {
            this.F.onFinish();
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (i2 == 1000 && i3 == -1) {
            e();
        }
        if (this.M != null) {
            this.M.authorizeCallBack(i2, i3, intent);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            d();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* loaded from: classes.dex */
    public final class SapiWebViewShell {
        public SapiWebViewShell() {
        }

        @JavascriptInterface
        public void sapi_cloud_log_op(String str, String str2, long j, long j2) {
            com.baidu.sapi2.utils.a.a.a().a(str, str2, j, j2);
        }

        @JavascriptInterface
        public void sapi_cloud_log_op_net(String str, String str2, long j, long j2) {
            com.baidu.sapi2.utils.a.a.a().a(str, 0L, 0L, j, 0L, 0L, 0L, 0, j2);
        }

        @JavascriptInterface
        public String config_fastlogin_features() {
            List<FastLoginFeature> list = SapiWebView.this.p.fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (com.baidu.sapi2.d.a(SapiWebView.this.getContext()).c()) {
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
            return SapiWebView.this.p.loginShareStrategy.getStrValue();
        }

        @JavascriptInterface
        public String config_canshare_accounts() {
            JSONArray jSONArray = SapiAccount.toJSONArray(SapiAccountManager.getInstance().a());
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.e();
            }
        }

        @JavascriptInterface
        public void finish() {
            SapiWebView.this.post(new d());
        }

        /* loaded from: classes.dex */
        class h implements Runnable {
            h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.d();
            }
        }

        @JavascriptInterface
        public void back() {
            SapiWebView.this.post(new h());
        }

        @JavascriptInterface
        public void authorized_response(String str) {
            authorized_response(str, 0);
        }

        @JavascriptInterface
        public void authorized_response(String str, int i) {
            if (i == 1) {
                SapiAccountResponse a2 = SapiWebView.a(SapiWebView.this.p.context, str);
                if (a2 == null) {
                    if (SapiWebView.this.q != null) {
                        SapiWebView.this.post(new g());
                    }
                } else if (a2.errorCode == 0 || a2.errorCode == 110000) {
                    if (SapiWebView.this.q != null) {
                        SapiWebView.this.post(new f());
                    }
                } else if (SapiWebView.this.q != null) {
                    SapiWebView.this.post(new e(a2));
                }
            }
            if (i == 0) {
                SapiAccountResponse a3 = SapiWebView.a(str);
                if (a3 == null) {
                    if (SapiWebView.this.q != null) {
                        SapiWebView.this.post(new c());
                    }
                } else if (SapiWebView.this.I != null && a3.newReg) {
                    SapiWebView.this.J = a3;
                    SapiWebView.this.a(a3);
                } else if (a3.errorCode == 0 || a3.errorCode == 110000) {
                    SapiWebView.this.b(a3);
                } else if (SapiWebView.this.q != null) {
                    SapiWebView.this.post(new b(a3));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class g implements Runnable {
            g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.q.onFailed(-100, "登录失败");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class f implements Runnable {
            f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.q.onSuccess();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class e implements Runnable {
            final /* synthetic */ SapiAccountResponse a;

            e(SapiAccountResponse sapiAccountResponse) {
                this.a = sapiAccountResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.q.onFailed(this.a.errorCode, this.a.errorMsg);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.q.onFailed(-100, "登录失败");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            final /* synthetic */ SapiAccountResponse a;

            b(SapiAccountResponse sapiAccountResponse) {
                this.a = sapiAccountResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.q.onFailed(this.a.errorCode, this.a.errorMsg);
            }
        }

        @JavascriptInterface
        public void action_fast_reg() {
            SapiWebView.this.loadFastReg();
        }

        @JavascriptInterface
        public String action_forget_pwd() {
            boolean[] zArr = {false};
            boolean[] zArr2 = {false};
            SapiWebView.this.post(new a(zArr, zArr2));
            do {
            } while (!zArr2[0]);
            return zArr[0] ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0";
        }

        /* loaded from: classes.dex */
        class a implements Runnable {
            final /* synthetic */ boolean[] a;
            final /* synthetic */ boolean[] b;

            a(boolean[] zArr, boolean[] zArr2) {
                this.a = zArr;
                this.b = zArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.q != null) {
                    this.a[0] = SapiWebView.this.q.onForgetPwd();
                }
                this.b[0] = true;
            }
        }

        @JavascriptInterface
        public void action_received_sms_code(String str, String str2) {
            SapiWebView.this.a(SapiWebView.this.C);
            SapiWebView.this.C.a = str;
            SapiWebView.this.C.b = str2;
            SapiWebView.this.C.postDelayed(SapiWebView.this.D, 15000L);
        }

        @JavascriptInterface
        public void set_pass_canceled() {
            SapiWebView.this.b(SapiWebView.this.J);
        }

        @JavascriptInterface
        public String get_preset_phone_number() {
            return SapiUtils.isValidPhoneNumber(SapiWebView.this.p.presetPhoneNumber) ? SapiWebView.this.p.presetPhoneNumber : "";
        }

        @JavascriptInterface
        public void action_social_sina_sso() {
            SapiWebView.this.loadSinaSSOLogin();
        }

        @JavascriptInterface
        public void action_social_qzone_webview() {
            if (SapiWebView.this.s != null) {
                Message message = new Message();
                message.what = SocialType.QZONE.getType();
                SapiWebView.this.s.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_tx_weibo_webview() {
            if (SapiWebView.this.s != null) {
                Message message = new Message();
                message.what = SocialType.TENCENT_WEIBO.getType();
                SapiWebView.this.s.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_sina_weibo_webview() {
            if (SapiWebView.this.s != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                SapiWebView.this.s.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_renren_webview() {
            if (SapiWebView.this.s != null) {
                Message message = new Message();
                message.what = SocialType.RENREN.getType();
                SapiWebView.this.s.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void loginWithQRCode() {
            if (SapiWebView.this.t != null) {
                SapiWebView.this.t.sendMessage(new Message());
            }
        }
    }

    static SapiAccountResponse a(String str) {
        SapiAccountResponse a2 = com.baidu.sapi2.utils.b.a(com.baidu.sapi2.utils.b.a("<client>([\\S\\s]*?)</client>", str));
        if (a2 != null && !TextUtils.isEmpty(a2.bduss) && a2.errorCode == -100) {
            a2.errorCode = 0;
        }
        return a2;
    }

    static SapiAccountResponse a(Context context, String str) {
        SocialResponse b2 = com.baidu.sapi2.utils.b.b(com.baidu.sapi2.utils.b.a("<client>([\\S\\s]*?)</client>", str));
        if (b2 != null) {
            if (!TextUtils.isEmpty(b2.bduss) && !TextUtils.isEmpty(b2.ptoken) && b2.errorCode == -100) {
                b2.errorCode = 0;
            }
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = b2.uid;
            sapiAccount.bduss = b2.bduss;
            sapiAccount.displayname = b2.displayname;
            sapiAccount.username = b2.username;
            sapiAccount.stoken = b2.stoken;
            sapiAccount.ptoken = b2.ptoken;
            sapiAccount.app = com.baidu.sapi2.utils.c.a(context);
            com.baidu.sapi2.utils.a.a(sapiAccount, b2.socialType, b2.socialPortraitUrl);
            if (SapiUtils.isValidAccount(sapiAccount)) {
                com.baidu.sapi2.share.b.a().a(sapiAccount);
            }
            String str2 = "";
            switch (b2.socialType) {
                case QQ:
                    str2 = "tl_qq_suc";
                    break;
                case QZONE:
                    str2 = "tl_qq_suc";
                    break;
                case TENCENT_WEIBO:
                    str2 = "tl_tweibo_suc";
                    break;
                case RENREN:
                    str2 = "tl_renren_suc";
                    break;
                case SINA_WEIBO:
                    str2 = "tl_sina_suc";
                    break;
            }
            if (!TextUtils.isEmpty(str2)) {
                com.baidu.sapi2.utils.a.a.a().a(str2, 0L, 0L);
            }
        }
        return b2;
    }

    /* loaded from: classes.dex */
    public class b extends WebViewEventListener {
        public b() {
        }

        @Override // com.baidu.sapi2.shell.listener.WebViewEventListener
        public final void onStartLoading(WebView webView, String str) {
            super.onStartLoading(webView, str);
        }

        @Override // com.baidu.sapi2.shell.listener.WebViewEventListener
        public final void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        @Override // com.baidu.sapi2.shell.listener.WebViewEventListener
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.x != null) {
                    SapiWebView.this.x.setVisibility(8);
                }
                if (SapiWebView.this.v != null) {
                    SapiWebView.this.v.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.sapi2.shell.listener.WebViewEventListener
        public void onTimeout(String str) {
            SapiWebView.this.stopLoading();
            SapiWebView.this.post(new a());
        }

        /* renamed from: com.baidu.sapi2.SapiWebView$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0006b implements Runnable {
            RunnableC0006b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.x != null) {
                    SapiWebView.this.x.setVisibility(8);
                }
                if (SapiWebView.this.u != null) {
                    SapiWebView.this.u.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.sapi2.shell.listener.WebViewEventListener
        public void onNetworkUnavailable(WebView webView, String str) {
            SapiWebView.this.post(new RunnableC0006b());
        }
    }

    /* loaded from: classes.dex */
    public class l extends AuthorizationListener {
        public l() {
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess() {
            SapiWebView.this.e();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            SapiWebView.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a {
        private static final String a = "javascript:";
        private static final String b = "/phoenix/account/startlogin";
        private static final String c = "/phoenix/account/afterauth";
        private static final String d = "https://open.t.qq.com/cgi-bin/oauth2/authorize";
        private static final String e = "https://graph.renren.com/oauth/authorize";
        private static final String f = "https://graph.qq.com/oauth2.0/authorize";
        private static final String g = "http://graph.renren.com/oauth/grant";
        private static final String h = "http://openapi.qzone.qq.com/oauth/show";
        private static final String i = "http://ui.ptlogin2.qq.com/cgi-bin/login";
        private static final String j = "https://api.weibo.com/oauth2/authorize";

        private a() {
        }

        public static boolean a(String str) {
            return (TextUtils.isEmpty(str) || str.contains(d) || str.contains(i) || str.contains(e) || str.contains(g) || str.contains(f) || str.contains(h) || str.contains(j) || str.contains(a)) ? false : true;
        }

        public static boolean b(String str) {
            return (str.contains("/phoenix/account/startlogin") || str.contains(e) || str.contains(f) || str.contains(d)) ? false : true;
        }

        public static boolean c(String str) {
            return (str.contains("/phoenix/account/startlogin") || str.contains(e) || str.contains(f) || str.contains(d)) ? false : true;
        }

        public static boolean d(String str) {
            return (str.contains("/phoenix/account/afterauth") || str.contains(e) || str.contains(f) || str.contains(d) || str.contains(g) || str.contains(h) || str.contains(i) || str.contains(j)) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements SSOListener {
        e() {
        }

        public void onComplete(Bundle bundle) {
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.SINA_WEIBO, bundle.getString("access_token"), bundle.getString(SapiAccountManager.SESSION_UID)));
        }

        public void onJumpNormal() {
            L.d("onJumpNormal", new Object[0]);
            SapiWebView.this.loadSocialLogin(SocialType.SINA_WEIBO);
        }

        public void onError(SSOError sSOError) {
            L.e(sSOError);
            Toast.makeText(SapiWebView.this.getContext(), sSOError.getMessage(), 0).show();
        }

        public void onCancel() {
            L.d("cancelled", new Object[0]);
        }
    }

    public void loadSinaSSOLogin() {
        this.M = new SsoHandler((Activity) getContext(), "2512457640", L);
        this.M.authorize(new e());
        com.baidu.sapi2.utils.a.a.a().a("tl_sina_sso", 0L, 0L);
        if (com.baidu.sapi2.d.a(getContext()).c()) {
            post(new o());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.m, 0).show();
        }
    }

    public void loadSocialLogin(SocialType socialType) {
        if (socialType == null) {
            throw new IllegalArgumentException("SocialType can't be null");
        }
        if (socialType == SocialType.UNKNOWN) {
            throw new IllegalArgumentException("Unknown SocialType");
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().a(socialType));
        com.baidu.sapi2.utils.a.a.a().a("tl_" + socialType.name().toLowerCase(), 0L, 0L);
        if (com.baidu.sapi2.d.a(getContext()).c()) {
            post(new n());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.m, 0).show();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.x != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.x.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void c(String str) {
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            if (this.r != null) {
                this.r.onNetworkUnavailable(this, str);
                return;
            }
            return;
        }
        post(new k(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.super.loadUrl(this.a);
        }
    }

    void a(Context context, List<NameValuePair> list) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie(this.p.environment.getWap(), "cuid=" + this.p.clientId + ";domain=" + this.p.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/");
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
            sapiAccount.app = com.baidu.sapi2.utils.c.a(getContext());
            if (SapiUtils.isValidAccount(sapiAccount)) {
                com.baidu.sapi2.d.a(getContext()).a(sapiAccountResponse.uid, sapiAccountResponse.reloginCredentials);
                com.baidu.sapi2.share.b.a().a(sapiAccount);
            }
            if (this.q != null) {
                post(new i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.this.q.onSuccess();
        }
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "BDUSS=" + str + ";domain=baidu.com;path=/";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m {
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

        public m() {
            this.g = new a(SapiWebView.this);
            this.h = new c(SapiWebView.this);
            this.i = new b(SapiWebView.this);
            this.l = new e(SapiWebView.this);
        }

        /* loaded from: classes.dex */
        class a extends Handler {
            final /* synthetic */ SapiWebView a;

            a(SapiWebView sapiWebView) {
                this.a = sapiWebView;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                m.this.e = true;
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            final /* synthetic */ SapiWebView a;

            c(SapiWebView sapiWebView) {
                this.a = sapiWebView;
            }

            @Override // java.lang.Runnable
            public void run() {
                m.this.g.sendMessage(new Message());
            }
        }

        /* loaded from: classes.dex */
        class b extends Handler {
            final /* synthetic */ SapiWebView a;

            b(SapiWebView sapiWebView) {
                this.a = sapiWebView;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj != null) {
                    String str = (String) message.obj;
                    String f = m.this.f();
                    if (!TextUtils.isEmpty(f) && m.this.j == 1) {
                        m.this.a(f, str);
                    }
                    SapiWebView.this.f();
                    m.this.k.removeCallbacks(m.this.l);
                }
            }
        }

        /* loaded from: classes.dex */
        class e implements Runnable {
            final /* synthetic */ SapiWebView a;

            e(SapiWebView sapiWebView) {
                this.a = sapiWebView;
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.f();
                SapiWebView.this.b(m.this.f());
            }
        }

        private String a() {
            return UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + ",点击发送直接注册";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                this.d = a();
            }
            if (!h()) {
                e();
            } else if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                if (SapiWebView.this.p.fastRegConfirm) {
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.o).setPositiveButton("确定", new g()).setNegativeButton("取消", new d()).create();
                    if (!TextUtils.isEmpty(SapiWebView.this.p.fastRegConfirmMsg)) {
                        create.setMessage(SapiWebView.this.p.fastRegConfirmMsg);
                    }
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                } else if (g()) {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class g implements DialogInterface.OnClickListener {
            g() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (m.this.g()) {
                    m.this.g.postDelayed(m.this.h, 15000L);
                    m.this.e = false;
                    m.this.d();
                    return;
                }
                m.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements DialogInterface.OnClickListener {
            d() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.i);
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
                SapiAccountManager.getInstance().getAccountService().a(new f(), this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class f implements SapiCallBack<SapiAccountResponse> {
            f() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            /* renamed from: a */
            public void onSuccess(SapiAccountResponse sapiAccountResponse) {
                if (sapiAccountResponse.newReg) {
                    SapiWebView.this.a(sapiAccountResponse);
                } else {
                    SapiWebView.this.b(sapiAccountResponse);
                }
                m.this.c();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                m.this.e();
                m.this.c();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                switch (i) {
                    case 2:
                        m.this.d();
                        return;
                    default:
                        m.this.e();
                        m.this.c();
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            String f2 = f();
            if (!TextUtils.isEmpty(f2)) {
                com.baidu.sapi2.utils.a.a.a().a("fr_req_sms", 0L, 0L);
                this.j = 1;
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new i(), f2);
                return;
            }
            com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class i implements SapiCallBack<SapiResponse> {
            i() {
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSuccess(SapiResponse sapiResponse) {
                SapiWebView.this.a(m.this.i);
                m.this.k.postDelayed(m.this.l, 15000L);
                com.baidu.sapi2.utils.a.a.a().a("fr_req_sms_suc", 0L, 0L);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.i);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.i);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class h implements SapiCallBack<SapiAccountResponse> {
            h() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            /* renamed from: a */
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
                SapiWebView.this.e();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                SapiWebView.this.b(m.this.f());
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                SapiWebView.this.b(m.this.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            SapiAccountManager.getInstance().getAccountService().a(new h(), str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String f() {
            String line1Number = ((TelephonyManager) SapiWebView.this.getContext().getSystemService("phone")).getLine1Number();
            if (TextUtils.isEmpty(line1Number)) {
                return null;
            }
            return line1Number.replace("+86", "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() {
            com.baidu.sapi2.utils.a.a.a().a("fr_send_sms", 0L, 0L);
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiWebView.this.getContext(), 0, new Intent(), 0);
            if (!TextUtils.isEmpty(this.d)) {
                try {
                    SmsManager.getDefault().sendTextMessage(com.baidu.sapi2.utils.f.n, null, this.d, broadcast, null);
                    com.baidu.sapi2.utils.a.a.a().a("fr_send_sms_suc", 0L, 0L);
                    return true;
                } catch (Throwable th) {
                }
            }
            return false;
        }

        private boolean a(String str) {
            return SapiWebView.this.getContext().checkCallingOrSelfPermission(str) == 0;
        }

        private boolean h() {
            if (a("android.permission.SEND_SMS")) {
                switch (((TelephonyManager) SapiWebView.this.getContext().getSystemService("phone")).getSimState()) {
                    case 0:
                        return false;
                    case 1:
                        return false;
                    case 2:
                    case 3:
                    case 4:
                        return false;
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.B == null) {
            this.B = new SMSReceiver(handler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(this.B, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.B != null) {
            try {
                getContext().unregisterReceiver(this.B);
            } catch (Throwable th) {
            }
        }
        this.B = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class SMSReceiver extends BroadcastReceiver {
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
}
