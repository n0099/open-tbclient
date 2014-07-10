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
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public final class SapiWebView extends WebView {
    public static final long DEFAULT_TIMEOUT_MILLIS = 90000;
    private static final String K = "javascript:(function(){if(window.Pass&&Pass.client&&Pass.client.net){Pass.client.net()}}())";
    private static final int a = 1;
    private static final int b = 0;
    private static final String c = "2512457640";
    private static final String d = "http://www.baidu.com";
    private static final String e = "text/html";
    private static final String f = "UTF-8";
    private static final String g = "<link href=\"\" type=text/css rel=stylesheet id=product-skin>";
    private static final String h = "file:///android_asset";
    private static final String i = "#login";
    private static final String j = "#reg";
    private static final String k = "#canshare_accounts";
    private static final String l = "#sms_login";
    private static final String m = "#fastReg";
    private static final String n = "#fastRegSuccess";
    private static final String o = "#fastRegVerify";
    private static final String p = "您的手机被恶意软件篡改，可能无法使用第三方帐号登录百度，请更换其他登录方式";
    private static final String q = "已自动识别并填写短信验证码";
    private static final String r = "发送一条短信，即可完成注册。";
    private String A;
    private ProgressBar B;
    private long C;
    private Handler D;
    private q E;
    private BroadcastReceiver F;
    private p G;
    private Runnable H;
    private OnFinishCallback I;
    private OnBackCallback J;
    private m L;
    private SapiAccountResponse M;
    private SapiConfiguration s;
    private AuthorizationListener t;
    private Handler u;
    private Handler v;
    private Handler w;
    private SsoHandler x;
    private View y;
    private View z;

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
                SapiWebView.this.D.sendMessage(message);
                SapiWebView.this.D.removeCallbacks(this);
            }
        }

        public void a(String str) {
            this.b = str;
        }
    }

    public void setOnFinishCallback(OnFinishCallback onFinishCallback) {
        this.I = onFinishCallback;
    }

    public void setOnBackCallback(OnBackCallback onBackCallback) {
        this.J = onBackCallback;
    }

    public SapiWebView(Context context) {
        super(context);
        this.D = new com.baidu.sapi2.c(this);
        this.E = new q(this, null);
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new com.baidu.sapi2.c(this);
        this.E = new q(this, null);
        a();
    }

    public SapiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.D = new com.baidu.sapi2.c(this);
        this.E = new q(this, null);
        a();
    }

    public final void setNoNetworkView(View view) {
        if (this.y == null) {
            this.y = view;
            this.y.setVisibility(4);
            addView(this.y, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public final void setTimeoutView(View view) {
        if (this.z == null) {
            this.z = view;
            this.z.setVisibility(4);
            addView(this.z, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void setProgressBar(ProgressBar progressBar) {
        if (this.B == null) {
            this.B = progressBar;
            if (this.B != null) {
                addView(progressBar);
            }
        }
    }

    public void setSmsAutoCompleteHint(String str) {
        this.A = str;
    }

    private void a() {
        this.C = DEFAULT_TIMEOUT_MILLIS;
        this.A = q;
        this.s = SapiAccountManager.getInstance().getSapiConfiguration();
        b();
        addJavascriptInterface(new SapiWebViewShell(), "sapi_obj");
        setWebViewClient(new b());
        setWebChromeClient(new a());
        if (this.t == null) {
            this.t = new l();
        }
        this.G = new p(this, null);
        this.H = new f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && (str.startsWith("sms") || str.startsWith("tel") || str.startsWith("bdscenter"))) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    SapiWebView.this.getContext().startActivity(intent);
                } catch (Throwable th) {
                    L.e(th, th.getMessage(), new Object[0]);
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            SapiWebView.this.E.a(str);
            SapiWebView.this.D.postDelayed(SapiWebView.this.E, SapiWebView.this.C);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(false);
            }
            SapiWebView.this.loadUrl(SapiWebView.K);
            if (str.contains(SapiAccountManager.getInstance().getAccountService().g()) || str.contains(SapiAccountManager.getInstance().getAccountService().h()) || str.contains(SapiAccountManager.getInstance().getAccountService().f())) {
                SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.getElementsByTagName('html')[0].innerHTML, 1);");
            }
            if (str.contains(SapiAccountManager.getInstance().getAccountService().d())) {
                SapiWebView.this.loadUrl("javascript:window.sapi_obj.authorized_response(document.body.innerHTML, 0);");
            }
            SapiWebView.this.D.removeCallbacks(SapiWebView.this.E);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            AlertDialog.Builder positiveButton = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("JavaScript Message").setMessage(str2).setPositiveButton("ok", new DialogInterface$OnClickListenerC0006a(jsResult));
            positiveButton.setCancelable(false);
            positiveButton.create();
            positiveButton.show();
            return true;
        }

        /* renamed from: com.baidu.sapi2.SapiWebView$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class DialogInterface$OnClickListenerC0006a implements DialogInterface.OnClickListener {
            final /* synthetic */ JsResult a;

            DialogInterface$OnClickListenerC0006a(JsResult jsResult) {
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
            if (SapiWebView.this.B != null) {
                if (i == 100) {
                    SapiWebView.this.B.setVisibility(8);
                } else {
                    if (SapiWebView.this.B.getVisibility() == 8) {
                        SapiWebView.this.B.setVisibility(0);
                    }
                    SapiWebView.this.B.setProgress(i);
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
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiWebView.this.j();
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
                    if (!TextUtils.isEmpty(SapiWebView.this.A)) {
                        post(new a());
                    }
                }
                SapiWebView.this.j();
                removeCallbacks(SapiWebView.this.H);
            }
        }

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(SapiWebView.this.getContext(), SapiWebView.this.A, 0).show();
            }
        }
    }

    private void b() {
        getSettings().setJavaScriptEnabled(true);
        setScrollBarStyle(0);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        setDownloadListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements DownloadListener {
        e() {
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
        this.t = authorizationListener;
    }

    public void setQrAppLoginHandler(Handler handler) {
        this.v = handler;
    }

    public void setDeviceLoginHandler(Handler handler) {
        this.w = handler;
    }

    public void setSocialLoginHandler(Handler handler) {
        this.u = handler;
    }

    public void loadLogin() {
        if (c()) {
            d();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + i);
        }
    }

    public void loadSmsLogin() {
        if (c()) {
            d();
        } else {
            loadUrl(SapiAccountManager.getInstance().getAccountService().a() + l);
        }
    }

    private boolean c() {
        return (this.s.loginShareStrategy == LoginShareStrategy.CHOICE || this.s.loginShareStrategy == LoginShareStrategy.SILENT) && SapiAccountManager.getInstance().a().size() > 0;
    }

    private void d() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + k);
    }

    public void loadRegist() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + j);
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
        arrayList2.add(new BasicNameValuePair(this.s.environment.getWap(), "BIND_BDUSS=" + str + ";domain=" + this.s.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/"));
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
        switch (com.baidu.sapi2.d.a(getContext()).j().c()) {
            case FAST:
                e();
                return;
            case NORMAL:
                loadRegist();
                return;
            default:
                e();
                return;
        }
    }

    private void e() {
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + m);
        this.L = new m();
        this.L.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiAccountResponse sapiAccountResponse) {
        this.M = sapiAccountResponse;
        loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&authsid=" + sapiAccountResponse.authSid + "&bduss=" + sapiAccountResponse.bduss + "&ptoken=" + sapiAccountResponse.ptoken + "&stoken=" + sapiAccountResponse.stoken + n);
    }

    public long getTimeoutMillis() {
        return this.C;
    }

    public void setTimeoutMillis(long j2) {
        this.C = j2;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrl(str, Collections.emptyList());
    }

    public void loadUrl(String str, List<NameValuePair> list) {
        a(getContext(), list);
        String b2 = b(SapiCache.a(getContext(), str));
        if (!TextUtils.isEmpty(b2)) {
            loadDataWithBaseURL(str, b2, e, f, str);
        } else {
            c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        d(String str, String str2, String str3, String str4, String str5) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT > 7) {
                SapiWebView.this.getSettings().setBlockNetworkLoads(true);
            }
            SapiWebView.super.loadDataWithBaseURL(this.a, this.b, this.c, this.d, this.e);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        post(new d(str, str2, str3, str4, str5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.J != null) {
            this.J.onBack();
            return;
        }
        b(this.M);
        super.loadUrl("javascript:(function(){if(window.Pass&&Pass.switchView){Pass.switchView('back')}}())");
        if ((this.y != null && this.y.getVisibility() == 0) || (this.z != null && this.z.getVisibility() == 0)) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        j();
        if (this.L != null) {
            this.L.f = true;
            this.L.k.removeCallbacks(this.L.l);
        }
        if (this.I != null) {
            this.I.onFinish();
        }
    }

    public void onAuthorizedResult(int i2, int i3, Intent intent) {
        if (this.x != null) {
            this.x.authorizeCallBack(i2, i3, intent);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            f();
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
        }

        @JavascriptInterface
        public void sapi_cloud_log_op_net(String str, String str2, long j, long j2) {
        }

        @JavascriptInterface
        public String config_fastlogin_features() {
            List<FastLoginFeature> list = SapiWebView.this.s.fastLoginFeatureList;
            if (list == null) {
                return null;
            }
            if (!com.baidu.sapi2.d.a(SapiWebView.this.getContext()).b() && list.contains(FastLoginFeature.DEVICE_LOGIN)) {
                list.remove(FastLoginFeature.DEVICE_LOGIN);
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
            return SapiWebView.this.s.loginShareStrategy.getStrValue();
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
                SapiWebView.this.g();
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
                SapiWebView.this.f();
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
                SapiAccountResponse a2 = SapiWebView.a(SapiWebView.this.s.context, str);
                if (a2 == null) {
                    if (SapiWebView.this.t != null) {
                        SapiWebView.this.post(new g());
                    }
                } else if (a2.errorCode == 0 || a2.errorCode == 110000) {
                    if (SapiWebView.this.t != null) {
                        SapiWebView.this.post(new f());
                    }
                } else if (SapiWebView.this.t != null) {
                    SapiWebView.this.post(new e(a2));
                }
            }
            if (i == 0) {
                SapiAccountResponse a3 = SapiWebView.a(str);
                if (a3 == null) {
                    if (SapiWebView.this.t != null) {
                        SapiWebView.this.post(new c());
                    }
                } else if (SapiWebView.this.L != null && a3.newReg) {
                    SapiWebView.this.M = a3;
                    SapiWebView.this.a(a3);
                } else if (a3.errorCode == 0 || a3.errorCode == 110000) {
                    SapiWebView.this.b(a3);
                } else if (SapiWebView.this.t != null) {
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
                SapiWebView.this.t.onFailed(-100, "登录失败");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class f implements Runnable {
            f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.t.onSuccess();
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
                SapiWebView.this.t.onFailed(this.a.errorCode, this.a.errorMsg);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SapiWebView.this.t.onFailed(-100, "登录失败");
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
                SapiWebView.this.t.onFailed(this.a.errorCode, this.a.errorMsg);
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
                if (SapiWebView.this.t != null) {
                    this.a[0] = SapiWebView.this.t.onForgetPwd();
                }
                this.b[0] = true;
            }
        }

        @JavascriptInterface
        public void action_received_sms_code(String str, String str2) {
            SapiWebView.this.a(SapiWebView.this.G);
            SapiWebView.this.G.a = str;
            SapiWebView.this.G.b = str2;
            SapiWebView.this.G.postDelayed(SapiWebView.this.H, 15000L);
        }

        @JavascriptInterface
        public void set_pass_canceled() {
            SapiWebView.this.b(SapiWebView.this.M);
        }

        @JavascriptInterface
        public String get_preset_phone_number() {
            return SapiUtils.isValidPhoneNumber(SapiWebView.this.s.presetPhoneNumber) ? SapiWebView.this.s.presetPhoneNumber : "";
        }

        @JavascriptInterface
        public void action_social_sina_sso() {
            SapiWebView.this.loadSinaSSOLogin();
        }

        @JavascriptInterface
        public void action_social_qzone_webview() {
            if (SapiWebView.this.u != null) {
                Message message = new Message();
                message.what = SocialType.QZONE.getType();
                SapiWebView.this.u.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_tx_weibo_webview() {
            if (SapiWebView.this.u != null) {
                Message message = new Message();
                message.what = SocialType.TENCENT_WEIBO.getType();
                SapiWebView.this.u.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_sina_weibo_webview() {
            if (SapiWebView.this.u != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                SapiWebView.this.u.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void action_social_renren_webview() {
            if (SapiWebView.this.u != null) {
                Message message = new Message();
                message.what = SocialType.RENREN.getType();
                SapiWebView.this.u.sendMessage(message);
            }
        }

        @JavascriptInterface
        public void loginWithQRCode() {
            if (SapiWebView.this.v != null) {
                SapiWebView.this.v.sendMessage(new Message());
            }
        }

        @JavascriptInterface
        public void loginWithDeviceId() {
            if (SapiWebView.this.w != null) {
                SapiWebView.this.w.sendMessage(new Message());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
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
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), f);
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
                                } else if (sapiAccountResponse == null && name.equalsIgnoreCase("error_code")) {
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
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_BDUSS)) {
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
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_UID)) {
                                    sapiAccountResponse.uid = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("authsid")) {
                                    sapiAccountResponse.authSid = newPullParser.nextText();
                                    sapiAccountResponse.newReg = !TextUtils.isEmpty(sapiAccountResponse.authSid);
                                    continue;
                                } else if (name.equalsIgnoreCase("account")) {
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

    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
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
                newPullParser.setInput(new ByteArrayInputStream(a2.getBytes()), f);
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
                                } else if (socialResponse == null && name.equalsIgnoreCase("error_code")) {
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
                                } else if (name.equalsIgnoreCase("error_code")) {
                                    socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                    continue;
                                } else if (name.equalsIgnoreCase("error_description")) {
                                    socialResponse.errorMsg = newPullParser.nextText();
                                    continue;
                                } else if (name.equalsIgnoreCase("is_binded")) {
                                    socialResponse.isBinded = newPullParser.nextText().equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
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
                                } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_BDUSS)) {
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
                if (!TextUtils.isEmpty(socialResponse2.bduss) && !TextUtils.isEmpty(socialResponse2.ptoken) && socialResponse2.errorCode == -100) {
                    socialResponse2.errorCode = 0;
                }
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = socialResponse2.uid;
                sapiAccount.bduss = socialResponse2.bduss;
                sapiAccount.displayname = socialResponse2.displayname;
                sapiAccount.username = socialResponse2.username;
                sapiAccount.stoken = socialResponse2.stoken;
                sapiAccount.ptoken = socialResponse2.ptoken;
                sapiAccount.app = SapiUtils.getAppName(context);
                com.baidu.sapi2.utils.a.a(sapiAccount, socialResponse2.socialType, socialResponse2.socialPortraitUrl);
                com.baidu.sapi2.share.b.a().a(sapiAccount);
            }
        }
        return socialResponse2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.B != null) {
                SapiWebView.this.B.setVisibility(8);
            }
            if (SapiWebView.this.z != null) {
                SapiWebView.this.z.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        stopLoading();
        post(new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SapiWebView.this.B != null) {
                SapiWebView.this.B.setVisibility(8);
            }
            if (SapiWebView.this.y != null) {
                SapiWebView.this.y.setVisibility(0);
            }
        }
    }

    private void i() {
        post(new o());
    }

    /* loaded from: classes.dex */
    public class l extends AuthorizationListener {
        public l() {
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess() {
            SapiWebView.this.g();
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            SapiWebView.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements SSOListener {
        n() {
        }

        public void onComplete(Bundle bundle) {
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a(SocialType.SINA_WEIBO, bundle.getString("access_token"), bundle.getString(SapiAccountManager.SESSION_UID)));
        }

        public void onJumpNormal() {
            if (SapiWebView.this.u != null) {
                Message message = new Message();
                message.what = SocialType.SINA_WEIBO.getType();
                SapiWebView.this.u.sendMessage(message);
            }
        }

        public void onError(SSOError sSOError) {
            L.e(sSOError);
            Toast.makeText(SapiWebView.this.getContext(), sSOError.getMessage(), 0).show();
        }

        public void onCancel() {
        }
    }

    public void loadSinaSSOLogin() {
        this.x = new SsoHandler((Activity) getContext(), "2512457640", d);
        this.x.authorize(new n());
        if (com.baidu.sapi2.d.a(getContext()).c()) {
            post(new k());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.p, 0).show();
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
        if (com.baidu.sapi2.d.a(getContext()).c()) {
            post(new g());
        }
    }

    /* loaded from: classes.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(SapiWebView.this.getContext(), SapiWebView.p, 0).show();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (this.B != null) {
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.B.getLayoutParams();
            layoutParams.x = i2;
            layoutParams.y = i3;
            this.B.setLayoutParams(layoutParams);
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    private void c(String str) {
        if (!SapiUtils.hasActiveNetwork(getContext()) && !str.startsWith("javascript:")) {
            i();
        } else {
            post(new h(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        final /* synthetic */ String a;

        h(String str) {
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
        if (TextUtils.isEmpty(this.s.clientId)) {
            this.s.clientId = SapiUtils.getClientId(getContext());
        }
        cookieManager.setCookie(this.s.environment.getWap(), "cuid=" + this.s.clientId + ";domain=" + this.s.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/");
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
            com.baidu.sapi2.d.a(getContext()).a(sapiAccountResponse.uid, sapiAccountResponse.reloginCredentials);
            com.baidu.sapi2.share.b.a().a(sapiAccount);
            if (this.t != null) {
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
            SapiWebView.this.t.onSuccess();
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
                    SapiWebView.this.j();
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
                SapiWebView.this.j();
                m.this.a(m.this.f());
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
            if (!SapiUtils.isSimReady(SapiWebView.this.getContext())) {
                e();
            } else if (SapiUtils.hasActiveNetwork(SapiWebView.this.getContext())) {
                if (SapiWebView.this.s.fastRegConfirm) {
                    AlertDialog create = new AlertDialog.Builder(SapiWebView.this.getContext()).setTitle("提示").setMessage(SapiWebView.r).setPositiveButton("确定", new g()).setNegativeButton("取消", new d()).create();
                    if (!TextUtils.isEmpty(SapiWebView.this.s.fastRegConfirmMsg)) {
                        create.setMessage(SapiWebView.this.s.fastRegConfirmMsg);
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
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.l);
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
                this.j = 1;
                SapiAccountManager.getInstance().getAccountService().getDynamicPwd(new i(), f2);
                return;
            }
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.l);
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
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.l);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&regLink=0" + SapiWebView.l);
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
                SapiWebView.this.g();
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
                m.this.a(m.this.f());
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
                m.this.a(m.this.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            SapiAccountManager.getInstance().getAccountService().a(new h(), str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            SapiWebView.this.loadUrl(SapiAccountManager.getInstance().getAccountService().a() + "&username=" + str + SapiWebView.o);
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
            PendingIntent broadcast = PendingIntent.getBroadcast(SapiWebView.this.getContext(), 0, new Intent(), 0);
            if (!TextUtils.isEmpty(this.d)) {
                try {
                    SmsManager.getDefault().sendTextMessage(h(), null, this.d, broadcast, null);
                    return true;
                } catch (Throwable th) {
                }
            }
            return false;
        }

        private String h() {
            String a2 = com.baidu.sapi2.d.a(SapiWebView.this.getContext()).j().a();
            return !TextUtils.isEmpty(a2) ? a2 : com.baidu.sapi2.utils.e.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Handler handler) {
        if (this.F == null) {
            this.F = new SMSReceiver(handler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(Integer.MAX_VALUE);
            getContext().registerReceiver(this.F, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.F != null) {
            try {
                getContext().unregisterReceiver(this.F);
            } catch (Throwable th) {
            }
        }
        this.F = null;
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

    static String b(String str) {
        try {
            String str2 = SapiAccountManager.getInstance().getSapiConfiguration().skin;
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(h)) {
                    str = str.replace(g, "<link type=\"text/css\" rel=\"stylesheet\" href=\"" + str2 + "\">");
                } else {
                    str = str.replace(g, "");
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
