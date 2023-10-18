package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.common.security.SchemeCheckerHelperImpl;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.DomainErrorView;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.tieba.R;
import com.baidu.tieba.am1;
import com.baidu.tieba.cp1;
import com.baidu.tieba.cr2;
import com.baidu.tieba.cz2;
import com.baidu.tieba.d52;
import com.baidu.tieba.d72;
import com.baidu.tieba.g63;
import com.baidu.tieba.hj3;
import com.baidu.tieba.hs1;
import com.baidu.tieba.ic3;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jj3;
import com.baidu.tieba.kx2;
import com.baidu.tieba.l52;
import com.baidu.tieba.n93;
import com.baidu.tieba.o13;
import com.baidu.tieba.o53;
import com.baidu.tieba.p22;
import com.baidu.tieba.p42;
import com.baidu.tieba.p93;
import com.baidu.tieba.uy2;
import com.baidu.tieba.v42;
import com.baidu.tieba.vy2;
import com.baidu.tieba.wo2;
import com.baidu.tieba.x42;
import com.baidu.tieba.y42;
import com.baidu.tieba.yh3;
import com.baidu.tieba.zr1;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements zr1<NgWebView> {
    public static final boolean Z = am1.a;
    public static final String[] a0 = {"http", "https"};
    public g N;
    public f O;
    public e P;
    @Nullable
    public n93 Q;
    public l52 R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1072T;
    public d72 U;
    public String V;
    public SwanAppSlaveManager W;
    public boolean X;
    public boolean Y;

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void I0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
    public String Y() {
        return SchemeCheckerHelperImpl.FRAME_WHITE_LIST_SWAN_APP_WIDGET;
    }

    /* loaded from: classes4.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes4.dex */
        public class a implements l52.b {
            @Override // com.baidu.tieba.l52.b
            public void onCustomViewHidden() {
            }

            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            SwanAppWebViewWidget.this.K1();
            return true;
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (hj3.r(str)) {
                return;
            }
            SwanAppWebViewWidget.this.V = str;
            d72 d72Var = SwanAppWebViewWidget.this.U;
            if (d72Var != null) {
                d72Var.d(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (SwanAppWebViewWidget.this.R == null) {
                SwanAppWebViewWidget.this.R = new l52(SwanAppWebViewWidget.this.a.getBaseContext());
            }
            SwanAppWebViewWidget.this.R.c(view2, i, new a(this));
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            return onShowCustomView(bdSailorWebView, view2, 0, customViewCallback);
        }
    }

    /* loaded from: classes4.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ long a;
            public final /* synthetic */ HybridUbcFlow b;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.a = j;
                this.b = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (SwanAppWebViewWidget.this.H.c <= 0) {
                    j = this.a;
                } else {
                    j = SwanAppWebViewWidget.this.H.c;
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                this.b.D("fmp_type", SwanAppWebViewWidget.this.H.g);
                SwanAppWebViewWidget swanAppWebViewWidget = SwanAppWebViewWidget.this;
                swanAppWebViewWidget.L.f(swanAppWebViewWidget.H.g, true);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, false);
                HybridUbcFlow hybridUbcFlow = this.b;
                hybridUbcFlow.F(ubcFlowEvent);
                hybridUbcFlow.T();
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.H.g + " , fmpTypeName=" + SwanAppWebViewWidget.this.H.a());
                }
            }
        }

        public SwanAppWebViewWidgetClientExt() {
        }

        public /* synthetic */ SwanAppWebViewWidgetClientExt(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.G)) {
                uy2.q("route", SwanAppWebViewWidget.this.G).F(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.a = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.G)) {
                uy2.q("route", SwanAppWebViewWidget.this.G).F(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            p22.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.H.b = currentTimeMillis;
            cz2.h().l().a(SwanAppWebViewWidget.this.H.b);
            long b = SwanAppWebViewWidget.this.H.b();
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b + " , aligned search=false");
            }
            HybridUbcFlow p = uy2.p("startup");
            if (SwanAppWebViewWidget.this.j1()) {
                SwanAppWebViewWidget.this.L.e(true);
                p.b("fmp_data_record", SwanAppWebViewWidget.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            if (SwanAppWebViewWidget.this.W != null) {
                SwanAppWebViewWidget.this.W.I.a();
            }
            if (SwanAppWebViewWidget.this.H.c == 0) {
                SwanAppWebViewWidget.this.H.c = b;
                hs1 hs1Var = SwanAppWebViewWidget.this.H;
                hs1Var.g = hs1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppWebViewWidget.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppWebViewWidget.this.L.f("1", false);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = wo2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            ji3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            p22.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.c = System.currentTimeMillis();
            SwanAppWebViewWidget.this.H.g = "0";
            cz2.h().l().c(SwanAppWebViewWidget.this.H.c);
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.H.c);
            }
            HybridUbcFlow d = uy2.d("startup");
            if (d != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                d.D("webviewComponent", str);
                d.D("fmp_type", "0");
                d.E("value", "arrive_success");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.H.c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                SwanAppWebViewWidget.this.L.f("0", true);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, true);
                d.F(ubcFlowEvent);
                d.T();
                hs1 hs1Var = SwanAppWebViewWidget.this.H;
                p22.b("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.H.c), " , fmpType=", hs1Var.g, " , fmpTypeName=", hs1Var.a());
                uy2.t();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.G)) {
                vy2.f(SwanAppWebViewWidget.this.G);
                SwanAppWebViewWidget.this.G = "";
            }
            if (SwanAppWebViewWidget.this.W != null) {
                SwanAppWebViewWidget.this.W.I.g();
                SwanAppWebViewWidget.this.W.I.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            p22.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.e = System.currentTimeMillis();
            cz2.h().l().e(SwanAppWebViewWidget.this.H.e);
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.H.e);
            }
            if (SwanAppWebViewWidget.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.H.e);
                HybridUbcFlow p = uy2.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppWebViewWidget.this.L.f("3", false);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            p22.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.d = System.currentTimeMillis();
            cz2.h().l().d(SwanAppWebViewWidget.this.H.d);
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.H.d);
            }
            if (SwanAppWebViewWidget.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.H.d);
                HybridUbcFlow p = uy2.p("startup");
                p.D("fmp_type", "2");
                p.F(ubcFlowEvent);
                SwanAppWebViewWidget.this.L.f("2", false);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (wo2.g0().w() && SwanAppWebViewWidget.this.S1() && g63.k()) {
                return false;
            }
            if (wo2.g0().w() && SwanAppWebViewWidget.this.R1() && !g63.h(str)) {
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                    return true;
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements kx2.b {
        public final /* synthetic */ String a;

        /* renamed from: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0200a implements Runnable {
            public RunnableC0200a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppWebViewWidget.this.getWebView().loadUrl(a.this.a);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                SwanAppWebViewWidget.this.T1(aVar.a);
                SwanAppWebViewWidget.this.I1().c("none");
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                SwanAppWebViewWidget.this.T1(aVar.a);
                SwanAppWebViewWidget.this.I1().c("none");
            }
        }

        public a(String str) {
            this.a = str;
        }

        @Override // com.baidu.tieba.kx2.b
        public void onFail(String str) {
            p22.o("SwanAppWebViewWidget", "isblockdomain request failed, msg: " + str + ", url: " + this.a);
            jj3.a0(new c());
        }

        @Override // com.baidu.tieba.kx2.b
        public void onSuccess(JSONObject jSONObject) {
            p22.b("SwanAppWebViewWidget", "isblockdomain request success, response data: " + jSONObject + ", url: " + this.a);
            if (jSONObject != null && jSONObject.optInt("result", -1) == 0) {
                jj3.a0(new RunnableC0200a());
                return;
            }
            p22.o("SwanAppWebViewWidget", "isblockdomain request success, but check result failed: " + jSONObject + ", url: " + this.a);
            jj3.a0(new b());
        }
    }

    /* loaded from: classes4.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            ic3.W(str, bdSailorWebView.getSettings().getUserAgentString());
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            int i;
            super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            d72 d72Var = SwanAppWebViewWidget.this.U;
            if (d72Var != null) {
                if (webResourceResponse != null) {
                    i = webResourceResponse.getStatusCode();
                } else {
                    i = 0;
                }
                d72Var.b(i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            p22.b("SwanAppWebViewWidget", "onPageFinished, url: " + str);
            if (SwanAppWebViewWidget.this.S1() && g63.k()) {
                SwanAppWebViewWidget.this.I1().c(str);
            } else {
                SwanAppWebViewWidget.this.I1().b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            p22.b("SwanAppWebViewWidget", "onPageStarted, url: " + str);
            if (SwanAppWebViewWidget.this.S1() && g63.k()) {
                SwanAppWebViewWidget.this.I1().f(str);
            } else {
                SwanAppWebViewWidget.this.I1().d();
            }
            SwanAppWebViewWidget.this.E1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i == -10) {
                return;
            }
            SwanAppWebViewWidget.this.H1().c();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri A = jj3.A(str);
            if (A != null) {
                yh3.g(SwanAppWebViewWidget.this.a, new Intent("android.intent.action.DIAL", A));
                return true;
            }
            d72 d72Var = SwanAppWebViewWidget.this.F;
            if (d72Var != null) {
                return d72Var.a(str);
            }
            if (!o13.A()) {
                if (SwanAppWebViewWidget.Z) {
                    Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
                }
                return false;
            } else if (SwanAppWebViewWidget.this.F1(str)) {
                return true;
            } else {
                if (SwanAppWebViewWidget.this.R1() && !g63.h(str)) {
                    SwanAppWebViewWidget.this.T1(str);
                    return true;
                }
                return false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!SwanAppNetworkUtils.i(SwanAppWebViewWidget.this.getWebView().getContext())) {
                return;
            }
            if (SwanAppWebViewWidget.this.R1() && !g63.h(SwanAppWebViewWidget.this.getWebView().getUrl())) {
                return;
            }
            SwanAppWebViewWidget.this.getWebView().reload();
            SwanAppWebViewWidget.this.O.a();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements p42 {
        @Override // com.baidu.tieba.p42
        public boolean s(boolean z) {
            return z;
        }

        public c() {
        }

        @Override // com.baidu.tieba.p42
        public boolean n() {
            SwanAppWebViewWidget.this.G1().a();
            SwanAppWebViewWidget.this.getWebView().setOnWebViewHookHandler(SwanAppWebViewWidget.this);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ v42 b;

        public d(View view2, v42 v42Var) {
            this.a = view2;
            this.b = v42Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "onGlobalLayout");
            }
            SwanAppWebViewWidget.this.M1(this.a, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public final DomainErrorView a;

        public e(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            DomainErrorView domainErrorView = new DomainErrorView(context);
            this.a = domainErrorView;
            domainErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.setVisibility(8);
        }

        public void a() {
            this.a.setVisibility(8);
        }

        public void b(String str) {
            this.a.b(str);
            this.a.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public NetworkErrorView a;

        public f(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            NetworkErrorView networkErrorView = new NetworkErrorView(context);
            this.a = networkErrorView;
            networkErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.setVisibility(8);
        }

        public void a() {
            this.a.setVisibility(8);
        }

        public void c() {
            this.a.setVisibility(0);
        }

        public void b(View.OnClickListener onClickListener) {
            this.a.setOnClickListener(onClickListener);
            this.a.setReloadClickListener(onClickListener);
        }
    }

    /* loaded from: classes4.dex */
    public static class g {
        public EfficientProgressBar a;
        public String b;

        public g(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            this.a = null;
            EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
            this.a = efficientProgressBar;
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801ce));
            this.a.setId(R.id.obfuscated_res_0x7f0901b4);
            this.a.setVisibility(4);
            this.a.setFocusable(false);
            this.a.setClickable(false);
            viewGroup.addView(this.a);
        }

        public void c(String str) {
            String substring;
            if (TextUtils.isEmpty(str)) {
                str = "none";
            }
            int indexOf = str.indexOf("#");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = this.b.indexOf("#");
            if (indexOf2 == -1) {
                substring = this.b;
            } else {
                substring = this.b.substring(0, indexOf2);
            }
            if (str.equals(substring)) {
                b();
            }
        }

        public void e(String str) {
            f(str);
            d();
        }

        public void f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = "none";
            } else {
                this.b = str;
            }
        }

        public void g(int i) {
            this.a.setProgress(i, true);
        }

        public void b() {
            this.a.setProgress(100, true);
        }

        public void d() {
            this.a.f();
            g(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j1() {
        SwanAppSlaveManager swanAppSlaveManager = this.W;
        if (swanAppSlaveManager != null && !swanAppSlaveManager.I.c) {
            return true;
        }
        return false;
    }

    public final e G1() {
        if (this.P == null) {
            this.P = new e(getWebView().getContext(), getWebView());
        }
        return this.P;
    }

    public final f H1() {
        if (this.O == null) {
            f fVar = new f(getWebView().getContext(), getWebView());
            this.O = fVar;
            fVar.b(new b());
        }
        return this.O;
    }

    public g I1() {
        if (this.N == null) {
            this.N = new g(getWebView().getContext(), getWebView());
        }
        return this.N;
    }

    public int J1() {
        EfficientProgressBar efficientProgressBar;
        g gVar = this.N;
        if (gVar == null || (efficientProgressBar = gVar.a) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    public final void K1() {
        l52 l52Var = this.R;
        if (l52Var != null) {
            l52Var.a();
        }
    }

    public final void L1() {
        O0("document.querySelector('video').pause();");
    }

    public final void Q1() {
        this.b.getSettings().setLoadWithOverviewMode(true);
        this.b.getSettings().setUseWideViewPort(true);
        this.b.getSettings().setSupportZoom(true);
        this.b.getSettings().setBuiltInZoomControls(true);
        this.b.getSettings().setDisplayZoomControls(false);
    }

    public boolean R1() {
        return this.X;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        super.S0();
        p93 p93Var = new p93(this.h);
        p93Var.j(this);
        this.h.b(p93Var);
    }

    public boolean S1() {
        return this.Y;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
    public void b0() {
        super.b0();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
    public void destroy() {
        this.U = null;
        super.destroy();
    }

    @Override // com.baidu.tieba.zr1
    @Nullable
    public n93 getParams() {
        return this.Q;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.p42
    public boolean n() {
        I1().b();
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
    public void onPause() {
        super.onPause();
        L1();
    }

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.f1072T = 0;
        this.X = true;
        this.Y = true;
        V0(new WebViewWidgetClient());
        U0(new SwanAppWebChromeClient(this, null));
        W0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = wo2.g().b();
        if (b2 != null) {
            this.b.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        Q1();
        U1(context);
        getWebView().setOnWebViewHookHandler(this);
    }

    public final boolean F1(String str) {
        if (S1() && g63.k()) {
            if (g63.j(str)) {
                jj3.W(this.a, str);
                return true;
            } else if (!TextUtils.isEmpty(str) && !str.startsWith("http")) {
                return true;
            } else {
                kx2 kx2Var = new kx2();
                kx2Var.g(str);
                I1().e("none");
                kx2Var.d(new a(str));
                return true;
            }
        }
        return false;
    }

    public final void T1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URL url = new URL(str);
            for (String str2 : a0) {
                if (TextUtils.equals(url.getProtocol(), str2)) {
                    G1().b(str);
                    getWebView().setOnWebViewHookHandler(new c());
                    return;
                }
            }
        } catch (MalformedURLException e2) {
            if (Z) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.yr1
    public void loadUrl(String str) {
        if (!o13.A()) {
            if (Z) {
                Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
            }
            e eVar = this.P;
            if (eVar != null) {
                eVar.a();
            }
            super.loadUrl(str);
        } else if (F1(str)) {
        } else {
            if (R1() && !g63.h(str)) {
                G1().b(str);
                return;
            }
            e eVar2 = this.P;
            if (eVar2 != null) {
                eVar2.a();
            }
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0(SwanAppWebViewManager swanAppWebViewManager) {
        super.N0(swanAppWebViewManager);
    }

    public void N1(boolean z) {
        this.X = z;
    }

    public void O1(SwanAppSlaveManager swanAppSlaveManager) {
        this.W = swanAppSlaveManager;
    }

    public void P1(@Nullable n93 n93Var) {
        this.Q = n93Var;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void R0(SwanAppWebViewManager.d dVar) {
        super.R0(dVar);
        dVar.a = false;
    }

    public final void U1(Context context) {
        cp1 a2 = o53.K().x().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.tieba.wr1
    public void V(d72 d72Var) {
        this.U = d72Var;
    }

    public void E1() {
        v42 m;
        y42 W = cr2.V().W();
        if (W != null && (m = W.m()) != null && m.i0() != null) {
            View view2 = null;
            if (m instanceof x42) {
                if (((x42) m).v3().j() == null) {
                    return;
                }
                view2 = m.i0().findViewById(R.id.obfuscated_res_0x7f09018a);
            } else if (m instanceof d52) {
                if (((d52) m).j() == null || m.i0() == null) {
                    return;
                }
                view2 = m.i0().findViewById(R.id.obfuscated_res_0x7f092344);
            }
            if (view2 == null) {
                return;
            }
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new d(view2, m));
        }
    }

    public final void M1(View view2, v42 v42Var) {
        if (v42Var != null && !v42Var.o0()) {
            Rect rect = new Rect();
            view2.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int i2 = this.S;
            if (i == i2) {
                return;
            }
            if (i2 - i > 200) {
                int i3 = 0;
                if (v42Var instanceof x42) {
                    x42 x42Var = (x42) v42Var;
                    if (x42Var.l2() && x42Var.K3()) {
                        i3 = view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070101);
                    }
                }
                view2.getLayoutParams().height = i3 + i + this.f1072T;
            } else {
                view2.getLayoutParams().height = -1;
            }
            view2.requestLayout();
            this.S = i;
        }
    }
}
