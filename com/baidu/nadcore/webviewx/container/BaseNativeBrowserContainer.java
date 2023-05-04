package com.baidu.nadcore.webviewx.container;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webarch.NadLongPressView;
import com.baidu.nadcore.webviewx.BrowserStateView;
import com.baidu.nadcore.webviewx.container.base.AbsContainer;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.R;
import com.baidu.tieba.aj0;
import com.baidu.tieba.c61;
import com.baidu.tieba.d41;
import com.baidu.tieba.di0;
import com.baidu.tieba.ea1;
import com.baidu.tieba.f41;
import com.baidu.tieba.g61;
import com.baidu.tieba.h31;
import com.baidu.tieba.i41;
import com.baidu.tieba.ii0;
import com.baidu.tieba.li0;
import com.baidu.tieba.m91;
import com.baidu.tieba.n91;
import com.baidu.tieba.na1;
import com.baidu.tieba.p91;
import com.baidu.tieba.q91;
import com.baidu.tieba.qa1;
import com.baidu.tieba.ra1;
import com.baidu.tieba.s91;
import com.baidu.tieba.sh0;
import com.baidu.tieba.u91;
import com.baidu.tieba.uh0;
import com.baidu.tieba.y41;
import com.baidu.tieba.y51;
import com.baidu.tieba.z01;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseNativeBrowserContainer extends AbsContainer {
    public n91 d;
    public FrameLayout e;
    public LinearLayout f;
    public WebView g;
    public String h;
    public String i;
    public ea1 j;
    public String k;
    public RelativeLayout l;
    public BrowserStateView m;
    public boolean n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;

    public boolean S(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public boolean b() {
        return true;
    }

    /* loaded from: classes2.dex */
    public class a implements NadLongPressView.b {
        public a() {
        }

        @Override // com.baidu.nadcore.webarch.NadLongPressView.b
        public void a() {
            y41 a = y41.a(BaseNativeBrowserContainer.this.getActivity());
            a.b("老架构，url = " + BaseNativeBrowserContainer.this.h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DownloadListener {
        public b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            BaseNativeBrowserContainer.this.R(str, str2, str3, str4, j);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements di0 {
        public c() {
        }

        @Override // com.baidu.tieba.di0
        public void a(boolean z, @Nullable Map<String, String> map) {
            String p = ii0.p(map);
            if (!TextUtils.isEmpty(p)) {
                BaseNativeBrowserContainer.this.l(p);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends ra1 {
        public final /* synthetic */ di0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WebView webView, WebViewClient webViewClient, di0 di0Var, di0 di0Var2) {
            super(webView, webViewClient, di0Var);
            this.c = di0Var2;
        }

        @Override // com.baidu.tieba.ra1, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            int intValue;
            super.onPageFinished(webView, str);
            BaseNativeBrowserContainer.this.t0(webView.getTitle());
            Object tag = webView.getTag(R.id.nad_webcontent_error_code);
            if (tag == null) {
                intValue = 0;
            } else {
                intValue = ((Integer) tag).intValue();
            }
            if (TextUtils.equals(str, BaseNativeBrowserContainer.this.h) || TextUtils.equals(webView.getOriginalUrl(), BaseNativeBrowserContainer.this.h) || (str != null && str.contains(BaseNativeBrowserContainer.this.h))) {
                if (intValue != 0 && intValue != -1) {
                    BaseNativeBrowserContainer.this.q0(intValue);
                } else {
                    BaseNativeBrowserContainer.this.i0();
                }
            }
            BaseNativeBrowserContainer.this.U();
            BaseNativeBrowserContainer.this.j.w(str);
        }

        @Override // com.baidu.tieba.ra1, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String d = na1.d(str);
            if (TextUtils.isEmpty(d) || (!d.startsWith("http://") && !d.startsWith("https://") && !d.startsWith("ftp://") && !d.startsWith("sftp://") && !d.startsWith("ftps://"))) {
                BaseNativeBrowserContainer.this.o = true;
                if (BaseNativeBrowserContainer.this.j.F(webView, BaseNativeBrowserContainer.this.O(), str) || sh0.b(BaseNativeBrowserContainer.this.getActivity(), str, false) || y51.b.a().a(BaseNativeBrowserContainer.this.getActivity(), str, webView.getUrl(), this.c) || uh0.c(str, BaseNativeBrowserContainer.this.getActivity())) {
                    return true;
                }
                BaseNativeBrowserContainer.this.r0();
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return false;
        }

        @Override // com.baidu.tieba.ra1, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (BaseNativeBrowserContainer.this.o) {
                webView.setTag(R.id.nad_webcontent_error_code, 0);
            }
            BaseNativeBrowserContainer.this.o = false;
            WebView webView2 = BaseNativeBrowserContainer.this.g;
            if (webView2 != null && !webView2.canGoBack() && !BaseNativeBrowserContainer.this.g.canGoForward()) {
                BaseNativeBrowserContainer.this.r0();
            }
            BaseNativeBrowserContainer.this.j.x(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            webView.setTag(R.id.nad_webcontent_error_code, Integer.valueOf(i));
            BaseNativeBrowserContainer.this.j.z(webView, i, str, str2);
        }
    }

    /* loaded from: classes2.dex */
    public class e extends qa1 {
        public e(Context context, BaseNativeBrowserContainer baseNativeBrowserContainer) {
            super(context, baseNativeBrowserContainer);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            BaseNativeBrowserContainer.this.j.A(str);
            BaseNativeBrowserContainer.this.t0(webView.getTitle());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public final /* synthetic */ WebView a;

        public f(WebView webView) {
            this.a = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.destroy();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            WebView webView = BaseNativeBrowserContainer.this.g;
            if (webView != null) {
                webView.loadUrl(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!NetUtil.a(li0.b())) {
                return;
            }
            BaseNativeBrowserContainer.this.j0();
            BaseNativeBrowserContainer.this.r0();
        }
    }

    public BaseNativeBrowserContainer(m91 m91Var, n91 n91Var) {
        super(m91Var);
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = new h();
        this.d = n91Var;
        c0();
    }

    @SuppressLint({"JavascriptInterface"})
    public void H(Object obj, String str) {
        WebView webView = this.g;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (s91.b.a().a(i) || S(i, keyEvent)) {
            return true;
        }
        if (i == 4) {
            z();
            return true;
        } else if (this.g.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void Z(@NonNull WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        webView.loadUrl("javascript:(function(){try{if(performance&&performance.timing){var performanceResult={};for(var key in performance.timing){if(typeof performance.timing[key]!==\"function\"){performanceResult[key]=performance.timing[key];}}var strJson=JSON.stringify(performanceResult);NadJsControl.getPerformanceTiming(strJson);}}catch(e){}})();");
        this.j.p(getActivity(), webView);
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public boolean a(MotionEvent motionEvent) {
        if (this.g != null && this.p) {
            return true;
        }
        return false;
    }

    public void h0(Map<String, String> map) {
        WebView webView = this.g;
        if (webView != null) {
            webView.loadUrl(this.h, map);
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void l(String str) {
        aj0.b(new g(str));
    }

    public final void l0(boolean z) {
        CookieManager cookieManager;
        try {
            CookieSyncManager.createInstance(getActivity());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            th.printStackTrace();
            cookieManager = null;
        }
        if (cookieManager != null && Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(this.g, z);
        }
    }

    public void m0(RelativeLayout relativeLayout) {
        this.l = relativeLayout;
    }

    public final void n0(int i) {
        getActivity().setRequestedOrientation(i);
    }

    public void o0(boolean z) {
        int i;
        this.n = z;
        BrowserStateView browserStateView = this.m;
        if (browserStateView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            browserStateView.setVisibility(i);
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void p0(String str) {
        this.k = str;
    }

    public final void q0(int i) {
        if (i == 0) {
            T();
            return;
        }
        if (this.n) {
            this.m.setVisibility(0);
        }
        this.m.e(BrowserStateView.ViewState.ERROR);
        this.m.a(BrowserStateView.ViewState.LOADING);
    }

    public void t0(String str) {
        TextView textView = (TextView) this.f.findViewById(R.id.tv_title);
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void w(View view2) {
        super.w(view2);
        this.e = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e47);
        this.f = (LinearLayout) view2.findViewById(R.id.webview_container);
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void x(String str) {
        this.i = str;
    }

    public final boolean G() {
        if (f().getExtras() != null && j()) {
            f().removeExtra("other_app_back_url");
            return true;
        }
        return false;
    }

    public final void I() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }

    public String K() {
        return this.j.k();
    }

    public String L() {
        return this.i;
    }

    public final int M() {
        return getActivity().getRequestedOrientation();
    }

    public FrameLayout N() {
        return this.e;
    }

    public String O() {
        WebView webView = this.g;
        if (webView == null) {
            return "";
        }
        String url = webView.getUrl();
        if (!TextUtils.isEmpty(url)) {
            return url;
        }
        if (TextUtils.isEmpty(this.h)) {
            return "";
        }
        return this.h;
    }

    public LinearLayout P() {
        return this.f;
    }

    public final void T() {
        this.m.a(BrowserStateView.ViewState.ERROR);
    }

    public void U() {
        this.m.a(BrowserStateView.ViewState.LOADING);
    }

    public final void W() {
        this.f.addView(V(), new LinearLayout.LayoutParams(-1, -1));
        f0(this.g);
        Z(this.g);
        if (this.b) {
            a0();
        } else {
            this.e.findViewById(R.id.obfuscated_res_0x7f092443).setVisibility(8);
        }
    }

    public void X() {
        this.h = Q(f());
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void c() {
        super.c();
    }

    public final void c0() {
        this.j = new ea1(this);
    }

    public final void d0() {
        Intent f2 = f();
        b0(f2);
        Y(f2);
        o0(!"true".equals(f().getStringExtra("hide_state_view")));
        g0();
        this.j.t(getActivity(), this.e, this.g);
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public View e() {
        return this.e;
    }

    public final void e0() {
        W();
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public int g() {
        WebView webView = this.g;
        if (webView != null) {
            return webView.getScrollY();
        }
        return 0;
    }

    public void g0() {
        n91 n91Var = this.d;
        if (n91Var != null && n91Var.i()) {
            return;
        }
        ea1 ea1Var = this.j;
        if (ea1Var != null && ea1Var.l()) {
            return;
        }
        this.o = true;
        WebView webView = this.g;
        if (webView != null) {
            webView.loadUrl(this.h);
        }
    }

    public void i0() {
        U();
        T();
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public boolean j() {
        if (f().getExtras() != null && !TextUtils.isEmpty(f().getExtras().getString("other_app_back_url"))) {
            return true;
        }
        return false;
    }

    public void j0() {
        WebView webView = this.g;
        if (webView != null) {
            webView.reload();
            this.o = true;
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void o() {
        this.j.u();
        g61.c().d(getActivity());
        super.o();
        w(View.inflate(getActivity(), R.layout.nad_light_browser_activity, null));
        X();
        e0();
        d0();
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.g.freeMemory();
        super.onLowMemory();
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void p() {
        this.j.v();
        g61.c().f(getActivity());
        k0();
        super.p();
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void q() {
        this.j.y();
        this.g.onPause();
        i41.a(d(), i().getDecorView().getWindowToken());
        super.q();
    }

    public void r0() {
        if (this.n) {
            this.m.setVisibility(0);
        }
        this.m.e(BrowserStateView.ViewState.LOADING);
        this.m.a(BrowserStateView.ViewState.ERROR);
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void s() {
        this.j.B();
        super.s();
        this.g.onResume();
        this.g.resumeTimers();
    }

    @TargetApi(23)
    public void s0() {
        if (!d41.b.d()) {
            return;
        }
        if (getActivity().checkSelfPermission(PermissionRequest.RESOURCE_AUDIO_CAPTURE) != 0 || getActivity().checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            h31.a().a(getActivity(), R.string.input_file_no_permission_note_text);
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void t() {
        this.j.C();
        super.t();
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void u() {
        this.j.D();
        super.u();
    }

    public final void J(Context context) {
        if (Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (!accessibilityManager.isEnabled()) {
                    return;
                }
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            } catch (Error e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final String Q(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(K())) {
            stringExtra = K();
        }
        String d2 = na1.d(stringExtra);
        if (!TextUtils.isEmpty(d2) && na1.g(na1.b(d2))) {
            return d2;
        }
        return "";
    }

    public final void R(String str, String str2, String str3, String str4, long j) {
        if (f41.b(f41.c(f41.e(str, str3, str4)), str4) == 3) {
            JSONObject c2 = z01.c(this.k);
            z01.f(c2, "url", str);
            z01.e(c2, BreakpointSQLiteKey.CONTENT_LENGTH, j);
            c61.a().b(getActivity(), this.l, c2.toString());
        }
    }

    public FrameLayout V() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        BrowserStateView browserStateView = new BrowserStateView(getActivity());
        this.m = browserStateView;
        browserStateView.setErrorViewClickListener(this.q);
        WebView a2 = p91.a().a(getActivity());
        this.g = a2;
        frameLayout.addView(a2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public final void k0() {
        WebView webView = this.g;
        if (webView != null) {
            if (webView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.g.getParent()).removeView(this.g);
            }
            WebView webView2 = this.g;
            if (!d41.b.c()) {
                new Handler().postDelayed(new f(webView2), 1500L);
            } else {
                try {
                    webView2.destroy();
                } catch (Exception unused) {
                }
            }
            this.g = null;
        }
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void z() {
        i41.a(d(), i().getDecorView().getWindowToken());
        if (this.g.canGoBack()) {
            this.g.goBack();
        } else if (G()) {
        } else {
            u91.b.a().a(getActivity());
        }
    }

    public final void Y(@NonNull Intent intent) {
        if (TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            i().getDecorView().setSystemUiVisibility(i().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            i().addFlags(Integer.MIN_VALUE);
            i().setStatusBarColor(getResources().getColor(R.color.nad_transparent, null));
        }
    }

    public final void a0() {
        int[] b2;
        int[] c2;
        this.e.findViewById(R.id.obfuscated_res_0x7f092443).setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.titlebar_left_layout);
        for (int i : q91.h().b()) {
            ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f10013d), null, R.style.obfuscated_res_0x7f10013d);
            imageView.setImageResource(i);
            imageView.setTag(Integer.valueOf(i));
            q91.h().a(imageView, this);
            linearLayout.addView(imageView);
        }
        LinearLayout linearLayout2 = (LinearLayout) this.e.findViewById(R.id.titlebar_right_layout);
        for (int i2 : q91.h().c()) {
            NadLongPressView nadLongPressView = new NadLongPressView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f10013d), null, R.style.obfuscated_res_0x7f10013d);
            nadLongPressView.setImageResource(i2);
            nadLongPressView.setTag(Integer.valueOf(i2));
            q91.h().a(nadLongPressView, this);
            nadLongPressView.setHandler(new a());
            linearLayout2.addView(nadLongPressView);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void b0(@NonNull Intent intent) {
        char c2;
        String stringExtra = intent.getStringExtra("forbidautorotate");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (Build.VERSION.SDK_INT == 26) {
            I();
        }
        switch (stringExtra.hashCode()) {
            case 48:
                if (stringExtra.equals("0")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 49:
                if (stringExtra.equals("1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 50:
                if (stringExtra.equals("2")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 == 2 && M() != 0) {
                    n0(0);
                }
            } else if (M() != 1) {
                n0(1);
            }
        } else if (M() != -1) {
            n0(-1);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void f0(@NonNull WebView webView) {
        J(getActivity());
        webView.setScrollbarFadingEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setLightTouchEnabled(false);
        webView.getSettings().setUserAgentString(li0.e());
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setCacheMode(-1);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        getActivity().getWindow().setFlags(16777216, 16777216);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.clearFocus();
        webView.clearHistory();
        webView.clearView();
        webView.setScrollBarStyle(0);
        l0(true);
        webView.setDownloadListener(new b());
        c cVar = new c();
        webView.setWebViewClient(new d(webView, null, cVar, cVar));
        webView.setWebChromeClient(new e(getActivity(), this));
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer
    public void m(int i, int i2, Intent intent) {
        g61.c().g(getActivity(), i, i2, intent);
        super.m(i, i2, intent);
    }

    @Override // com.baidu.nadcore.webviewx.container.base.AbsContainer, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
