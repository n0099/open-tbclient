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
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import cn.jingling.lib.file.Shared;
import com.baidu.sapi2.plugin.SSOError;
import com.baidu.sapi2.plugin.SSOListener;
import com.baidu.sapi2.plugin.sso.SsoHandler;
import com.baidu.sapi2.shell.callback.FastRegCallBack;
import com.baidu.sapi2.shell.callback.GetDynamicPwdCallBack;
import com.baidu.sapi2.shell.callback.LoginCallBack;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebViewEventListener;
import com.baidu.sapi2.shell.response.FastRegResponse;
import com.baidu.sapi2.shell.response.LoginResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    private static final String A = "2512457640";
    private static final String B = "http://www.baidu.com";
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
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
    private static final String x = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private SsoHandler C;
    private SapiConfiguration m;
    private AuthorizationListener n;
    private WebViewEventListener o;
    private View p;
    private View q;
    private ProgressBar r;
    private long s;
    private Handler t;
    private j u;
    private Stack<String> v;
    private OnFinishCallback w;
    private FastRegAction y;
    private FastRegResponse z;

    /* loaded from: classes.dex */
    public interface OnFinishCallback {
        void onFinish();
    }

    /* loaded from: classes.dex */
    class j implements Runnable {
        private String b;

        private j() {
        }

        /* synthetic */ j(SapiWebView sapiWebView, com.baidu.sapi2.c cVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.getProgress() < 100) {
                Message message = new Message();
                message.what = 1;
                message.obj = this.b;
                SapiWebView.this.t.sendMessage(message);
                SapiWebView.this.t.removeCallbacks(this);
            }
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.w = onFinishCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.t = new com.baidu.sapi2.c(this);
        this.u = new j(this, null);
        this.v = new Stack<>();
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = new com.baidu.sapi2.c(this);
        this.u = new j(this, null);
        this.v = new Stack<>();
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = new com.baidu.sapi2.c(this);
        this.u = new j(this, null);
        this.v = new Stack<>();
        a();
    }

    public final void setNoNetworkView(View view) {
        if (this.p == null) {
            this.p = view;
            this.p.setVisibility(4);
            addView(this.p, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.q == null) {
            this.q = view;
            this.q.setVisibility(4);
            addView(this.q, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.r == null) {
            this.r = progressBar;
            if (this.r != null) {
                addView(progressBar);
            }
        }
    }

    private void a() {
        this.s = DEFAULT_TIMEOUT_MILLIS;
        this.m = SapiAccountManager.getInstance().getSapiConfiguration();
        b();
        addJavascriptInterface(new SapiWebViewShell(), "sapi_obj");
        setWebViewClient(new d());
        setWebChromeClient(new c());
        setWebViewEventListener(new b());
        if (this.n == null) {
            this.n = new i();
        }
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
                }
                SapiWebView.this.loadUrl(str);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SapiWebView.this.u.a(str);
            SapiWebView.this.t.postDelayed(SapiWebView.this.u, SapiWebView.this.s);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            SapiWebView.this.loadUrl(SapiWebView.x);
            if (SapiWebView.this.o != null && a.b(str)) {
                SapiWebView.this.o.onPageFinished(webView, str);
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().getUrlAfterAuth()) || str.contains(SapiAccountManager.getInstance().getAccountService().getUrlFinishBind()) || str.contains(SapiAccountManager.getInstance().getAccountService().getUrlSSOFinish())) {
                SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.getElementsByTagName('html')[0].innerHTML, 1);");
            }
            SapiWebView.this.t.removeCallbacks(SapiWebView.this.u);
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
            if (SapiWebView.this.o != null && webView.getUrl() != null && a.c(webView.getUrl())) {
                SapiWebView.this.o.onProgressChanged(webView, i);
            }
            if (SapiWebView.this.r != null) {
                if (i == 100) {
                    SapiWebView.this.r.setVisibility(8);
                } else {
                    if (SapiWebView.this.r.getVisibility() == 8) {
                        SapiWebView.this.r.setVisibility(0);
                    }
                    SapiWebView.this.r.setProgress(i);
                }
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            quotaUpdater.updateQuota(2 * j);
        }
    }

    private void b() {
        getSettings().setJavaScriptEnabled(true);
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
    }

    public void setAuthorizationListener(AuthorizationListener authorizationListener) {
        this.n = authorizationListener;
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.o = webViewEventListener;
    }

    public void loadSmsLogin() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + i);
    }

    public void loadRegist() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + g);
    }

    public void loadFastReg() {
        switch (com.baidu.sapi2.d.a(getContext()).e().a()) {
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
        loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + j);
        this.y = new FastRegAction();
        this.y.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FastRegResponse fastRegResponse) {
        this.z = fastRegResponse;
        loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&authsid=" + fastRegResponse.authSid + "&bduss=" + fastRegResponse.bduss + "&ptoken=" + fastRegResponse.ptoken + "&stoken=" + fastRegResponse.stoken + k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&username=" + str + l);
    }

    public long getTimeoutMillis() {
        return this.s;
    }

    public void setTimeoutMillis(long j2) {
        this.s = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(getContext());
        if (this.o != null && a.a(str)) {
            this.v.push(str);
            this.o.onStartLoading(this, str);
        }
        String a2 = SapiCache.a(getContext(), str);
        if (!TextUtils.isEmpty(a2)) {
            loadDataWithBaseURL(str, a2, d, e, str);
        } else {
            c(str);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        getSettings().setBlockNetworkLoads(true);
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        b(this.z);
        super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
        if (canGoBackOrForward(-1)) {
            if (getUrl().contains("baidu.com")) {
                int abs = Math.abs(-1);
                for (int i2 = 0; i2 < abs; i2++) {
                    if (!this.v.isEmpty()) {
                        this.v.pop();
                    }
                }
                if (!this.v.isEmpty()) {
                    String pop = this.v.pop();
                    if (pop.endsWith(h)) {
                        pop = pop.replace(h, f);
                    }
                    loadUrl(pop);
                }
            } else {
                goBackOrForward(-1);
            }
        }
        if ((this.p != null && this.p.getVisibility() == 0) || (this.q != null && this.q.getVisibility() == 0)) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.y != null) {
            this.y.f = true;
            this.y.b();
            this.y.k.removeCallbacks(this.y.l);
        }
        if (this.w != null) {
            this.w.onFinish();
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (i2 == 1000 && i3 == -1) {
            e();
        }
        if (this.C != null) {
            this.C.authorizeCallBack(i2, i3, intent);
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
            List<FastLoginFeature> list = SapiWebView.this.m.fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
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
            return SapiWebView.this.m.loginShareStrategy.getStrValue();
        }

        @JavascriptInterface
        public String config_canshare_accounts() {
            List<SapiAccount> a2 = SapiAccountManager.getInstance().a();
            for (SapiAccount sapiAccount : a2) {
                if (TextUtils.isEmpty(sapiAccount.portrait)) {
                    sapiAccount.portrait = "http://wappass.bdimg.com/static/appsapi/img/default_portrait.jpg";
                }
            }
            JSONArray jSONArray = SapiAccount.toJSONArray(a2);
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }

        @JavascriptInterface
        public void finish() {
            SapiWebView.this.e();
        }

        @JavascriptInterface
        public void back() {
            SapiWebView.this.d();
        }

        @JavascriptInterface
        public void authorized_response(String str) {
            authorized_response(str, 0);
        }

        @JavascriptInterface
        public void authorized_response(String str, int i) {
            if (i == 1) {
                SapiAccountResponse a2 = SapiWebView.a(SapiWebView.this.m.context, str);
                if (a2 == null) {
                    if (SapiWebView.this.n != null) {
                        SapiWebView.this.post(new a());
                    }
                } else if (a2.errorCode == 0 || a2.errorCode == 110000) {
                    if (SapiWebView.this.n != null) {
                        SapiWebView.this.post(new e());
                    }
                } else if (SapiWebView.this.n != null) {
                    SapiWebView.this.post(new d(a2));
                }
            }
            if (i == 0) {
                FastRegResponse a3 = SapiWebView.a(str);
                if (a3 == null) {
                    if (SapiWebView.this.n != null) {
                        SapiWebView.this.post(new c());
                    }
                } else if (SapiWebView.this.y != null && a3.newReg) {
                    SapiWebView.this.z = a3;
                    SapiWebView.this.a(a3);
                } else if (a3.errorCode == 0 || a3.errorCode == 110000) {
                    SapiWebView.this.b(a3);
                } else if (SapiWebView.this.n != null) {
                    SapiWebView.this.post(new b(a3));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.n.onFailed(-100, "登录失败");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.n.onSuccess();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements Runnable {
            final /* synthetic */ SapiAccountResponse a;

            d(SapiAccountResponse sapiAccountResponse) {
                this.a = sapiAccountResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.n.onFailed(this.a.errorCode, this.a.errorMsg);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.n.onFailed(-100, "登录失败");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            final /* synthetic */ FastRegResponse a;

            b(FastRegResponse fastRegResponse) {
                this.a = fastRegResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.n.onFailed(this.a.errorCode, this.a.errorMsg);
            }
        }

        @JavascriptInterface
        public void set_pass_canceled() {
            SapiWebView.this.b(SapiWebView.this.z);
        }

        @JavascriptInterface
        public void action_social_sina_sso() {
            SapiWebView.this.loadSinaSSOLogin();
        }

        @JavascriptInterface
        public void action_social_qzone_webview() {
            SapiWebView.this.loadSocialLogin(SocialType.QZONE);
        }

        @JavascriptInterface
        public void action_social_tx_weibo_webview() {
            SapiWebView.this.loadSocialLogin(SocialType.TENCENT_WEIBO);
        }

        @JavascriptInterface
        public void action_social_sina_weibo_webview() {
            SapiWebView.this.loadSocialLogin(SocialType.SINA_WEIBO);
        }

        @JavascriptInterface
        public void action_social_renren_webview() {
            SapiWebView.this.loadSocialLogin(SocialType.RENREN);
        }
    }

    static FastRegResponse a(String str) {
        FastRegResponse a2 = com.baidu.sapi2.utils.b.a(com.baidu.sapi2.utils.b.a("<client>([\\S\\s]*?)</client>", str));
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
            sapiAccount.app = com.baidu.sapi2.utils.d.a(context);
            com.baidu.sapi2.utils.a.a(sapiAccount, b2.socialType, b2.socialPortraitUrl);
            if (SapiUtils.isValidAccount(sapiAccount)) {
                com.baidu.sapi2.b.a.a().a(sapiAccount);
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
                if (SapiWebView.this.q != null) {
                    SapiWebView.this.q.setVisibility(0);
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
        class RunnableC0008b implements Runnable {
            RunnableC0008b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SapiWebView.this.p != null) {
                    SapiWebView.this.p.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.sapi2.shell.listener.WebViewEventListener
        public void onNetworkUnavailable(WebView webView, String str) {
            SapiWebView.this.post(new RunnableC0008b());
        }
    }

    /* loaded from: classes.dex */
    public class i implements AuthorizationListener {
        public i() {
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
    public class h implements SSOListener {
        h() {
        }

        public void onComplete(Bundle bundle) {
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().getUrlBind(SocialType.SINA_WEIBO, bundle.getString("access_token"), bundle.getString(SapiAccountManager.SESSION_UID)));
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
        this.C = new SsoHandler((Activity) getContext(), "2512457640", B);
        this.C.authorize(new h());
        com.baidu.sapi2.utils.a.a.a().a("tl_sina_sso", 0L, 0L);
    }

    public void loadSocialLogin(SocialType socialType) {
        if (socialType == null) {
            throw new IllegalArgumentException("SocialType can't be null");
        }
        if (socialType == SocialType.UNKNOWN) {
            throw new IllegalArgumentException("Unknown SocialType");
        }
        loadUrl(SapiAccountManager.getInstance().getAccountService().getUrlBind(socialType));
        com.baidu.sapi2.utils.a.a.a().a("tl_" + socialType.name().toLowerCase(), 0L, 0L);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.r != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.r.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.r.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void c(String str) {
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            if (this.o != null) {
                this.o.onNetworkUnavailable(this, str);
                return;
            }
            return;
        }
        post(new g(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.super.loadUrl(this.a);
        }
    }

    static void a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieSyncManager.getInstance().sync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FastRegResponse fastRegResponse) {
        if (fastRegResponse != null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = fastRegResponse.uid;
            sapiAccount.bduss = fastRegResponse.bduss;
            sapiAccount.displayname = fastRegResponse.displayname;
            sapiAccount.stoken = fastRegResponse.stoken;
            sapiAccount.ptoken = fastRegResponse.ptoken;
            sapiAccount.email = fastRegResponse.email;
            sapiAccount.username = fastRegResponse.username;
            sapiAccount.portrait = fastRegResponse.portrait;
            sapiAccount.app = com.baidu.sapi2.utils.d.a(getContext());
            if (SapiUtils.isValidAccount(sapiAccount)) {
                com.baidu.sapi2.b.a.a().a(sapiAccount);
            }
            if (this.n != null) {
                post(new f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.this.n.onSuccess();
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
        private BroadcastReceiver i;
        private Runnable l;
        private boolean e = true;
        private boolean f = false;
        private int j = 0;
        private Handler k = new Handler();

        public FastRegAction() {
            this.g = new a(SapiWebView.this);
            this.h = new c(SapiWebView.this);
            this.l = new b(SapiWebView.this);
        }

        /* loaded from: classes.dex */
        class a extends Handler {
            final /* synthetic */ SapiWebView a;

            a(SapiWebView sapiWebView) {
                this.a = sapiWebView;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                FastRegAction.this.e = true;
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
                FastRegAction.this.g.sendMessage(new Message());
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            final /* synthetic */ SapiWebView a;

            b(SapiWebView sapiWebView) {
                this.a = sapiWebView;
            }

            @Override // java.lang.Runnable
            public void run() {
                FastRegAction.this.b();
                SapiWebView.this.b(FastRegAction.this.h());
            }
        }

        private String c() {
            return UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + ",点击发送直接注册";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.e) {
                this.d = c();
            }
            if (!j()) {
                g();
            } else if (!SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                g();
            } else if (i()) {
                this.g.postDelayed(this.h, 15000L);
                this.e = false;
                f();
            } else {
                g();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            this.g.removeCallbacks(this.h);
            this.e = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            if (this.f) {
                e();
            } else if (this.e) {
                this.g.removeCallbacks(this.h);
                g();
            } else {
                SapiAccountManager.getInstance().getAccountService().fastReg(new e(), this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class e extends FastRegCallBack {
            e() {
            }

            @Override // com.baidu.sapi2.shell.callback.FastRegCallBack
            public void onWaitingLogin() {
                FastRegAction.this.f();
            }

            @Override // com.baidu.sapi2.shell.callback.FastRegCallBack
            public void onCannotLogin() {
                FastRegAction.this.g();
                FastRegAction.this.e();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            /* renamed from: a */
            public void onSuccess(FastRegResponse fastRegResponse) {
                if (fastRegResponse.newReg) {
                    SapiWebView.this.a(fastRegResponse);
                } else {
                    SapiWebView.this.b(fastRegResponse);
                }
                FastRegAction.this.e();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                FastRegAction.this.g();
                FastRegAction.this.e();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                FastRegAction.this.g();
                FastRegAction.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            String h = h();
            if (!TextUtils.isEmpty(h)) {
                com.baidu.sapi2.utils.a.a.a().a("fr_req_sms", 0L, 0L);
                this.j = 1;
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new d(), h);
                return;
            }
            com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&regLink=0" + SapiWebView.i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d extends GetDynamicPwdCallBack {
            d() {
            }

            @Override // com.baidu.sapi2.shell.callback.GetDynamicPwdCallBack
            public void onPhoneFormatError() {
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&regLink=0" + SapiWebView.i);
            }

            @Override // com.baidu.sapi2.shell.callback.GetDynamicPwdCallBack
            public void onCannotLogin() {
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&regLink=0" + SapiWebView.i);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSuccess(SapiResponse sapiResponse) {
                FastRegAction.this.a();
                FastRegAction.this.k.postDelayed(FastRegAction.this.l, 15000L);
                com.baidu.sapi2.utils.a.a.a().a("fr_req_sms_suc", 0L, 0L);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&regLink=0" + SapiWebView.i);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                com.baidu.sapi2.utils.a.a.a().a("fr_smslogin", 0L, 0L);
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().getLoginUrl() + "&regLink=0" + SapiWebView.i);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class f extends LoginCallBack {
            f() {
            }

            @Override // com.baidu.sapi2.shell.callback.LoginCallBack
            public void onPasswordWrong() {
                SapiWebView.this.b(FastRegAction.this.h());
            }

            @Override // com.baidu.sapi2.shell.callback.LoginCallBack
            public void onCannotLogin() {
                SapiWebView.this.b(FastRegAction.this.h());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            /* renamed from: a */
            public void onSuccess(LoginResponse loginResponse) {
                FastRegResponse fastRegResponse = new FastRegResponse();
                fastRegResponse.displayname = loginResponse.displayname;
                fastRegResponse.username = loginResponse.username;
                fastRegResponse.uid = loginResponse.uid;
                fastRegResponse.bduss = loginResponse.bduss;
                fastRegResponse.ptoken = loginResponse.ptoken;
                fastRegResponse.stoken = loginResponse.stoken;
                fastRegResponse.email = loginResponse.email;
                fastRegResponse.portrait = loginResponse.portrait;
                fastRegResponse.newReg = !TextUtils.isEmpty(loginResponse.authSid);
                fastRegResponse.authSid = loginResponse.authSid;
                if (fastRegResponse.newReg) {
                    SapiWebView.this.a(fastRegResponse);
                    return;
                }
                SapiWebView.this.b(fastRegResponse);
                SapiWebView.this.e();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                SapiWebView.this.b(FastRegAction.this.h());
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                SapiWebView.this.b(FastRegAction.this.h());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin(new f(), str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String h() {
            String line1Number = ((TelephonyManager) SapiWebView.this.getContext().getSystemService("phone")).getLine1Number();
            if (TextUtils.isEmpty(line1Number)) {
                return null;
            }
            return line1Number.replace("+86", "");
        }

        private boolean i() {
            com.baidu.sapi2.utils.a.a.a().a("fr_send_sms", 0L, 0L);
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiWebView.this.getContext(), 0, new Intent(), 0);
            if (!TextUtils.isEmpty(this.d)) {
                try {
                    SmsManager.getDefault().sendTextMessage(com.baidu.sapi2.utils.h.l, null, this.d, broadcast, null);
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

        private boolean j() {
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

        public void a() {
            if (this.i == null) {
                this.i = new SMSReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
                intentFilter.setPriority(Shared.INFINITY);
                SapiWebView.this.getContext().registerReceiver(this.i, intentFilter);
            }
        }

        public void b() {
            if (this.i != null) {
                SapiWebView.this.getContext().unregisterReceiver(this.i);
            }
            this.i = null;
        }

        /* loaded from: classes.dex */
        public class SMSReceiver extends BroadcastReceiver {
            public SMSReceiver() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Object[] objArr = (Object[]) intent.getExtras().get("pdus");
                SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < objArr.length) {
                        smsMessageArr[i2] = SmsMessage.createFromPdu((byte[]) objArr[i2]);
                        String a = a(smsMessageArr[i2].getMessageBody());
                        String h = FastRegAction.this.h();
                        if (!TextUtils.isEmpty(h) && FastRegAction.this.j == 1) {
                            FastRegAction.this.a(h, a);
                        }
                        FastRegAction.this.b();
                        FastRegAction.this.k.removeCallbacks(FastRegAction.this.l);
                        i = i2 + 1;
                    } else {
                        return;
                    }
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
}
