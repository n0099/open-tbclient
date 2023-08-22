package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshNgWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.bf3;
import com.baidu.tieba.cp2;
import com.baidu.tieba.cy2;
import com.baidu.tieba.d13;
import com.baidu.tieba.d82;
import com.baidu.tieba.db3;
import com.baidu.tieba.el2;
import com.baidu.tieba.eo3;
import com.baidu.tieba.i43;
import com.baidu.tieba.j13;
import com.baidu.tieba.jh2;
import com.baidu.tieba.js2;
import com.baidu.tieba.jx1;
import com.baidu.tieba.ks2;
import com.baidu.tieba.ku2;
import com.baidu.tieba.lc3;
import com.baidu.tieba.mh2;
import com.baidu.tieba.np2;
import com.baidu.tieba.nr1;
import com.baidu.tieba.p22;
import com.baidu.tieba.q43;
import com.baidu.tieba.qh2;
import com.baidu.tieba.qw2;
import com.baidu.tieba.rc2;
import com.baidu.tieba.rq3;
import com.baidu.tieba.sb3;
import com.baidu.tieba.sc2;
import com.baidu.tieba.sp2;
import com.baidu.tieba.t72;
import com.baidu.tieba.tp2;
import com.baidu.tieba.uh2;
import com.baidu.tieba.up2;
import com.baidu.tieba.ux1;
import com.baidu.tieba.v92;
import com.baidu.tieba.w92;
import com.baidu.tieba.xh2;
import com.baidu.tieba.xn3;
import com.baidu.tieba.y92;
import com.baidu.tieba.yr2;
import com.baidu.tieba.z03;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements jx1<NgWebView> {
    public static final boolean M = nr1.a;
    public rq3 A;
    @Nullable
    public t72 B;
    public sc2 C;
    public FrameLayout D;
    public rc2 E;
    public rc2 F;
    public String G;
    public ux1 H;
    public jh2 I;
    public boolean J;
    public boolean K;
    public qh2 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    @Override // com.baidu.tieba.jx1
    public int P() {
        return 0;
    }

    @Override // com.baidu.tieba.sw1
    public double z() {
        return 1.0d;
    }

    /* loaded from: classes4.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {

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
                if (SwanAppSlaveManager.this.H.c <= 0) {
                    j = this.a;
                } else {
                    j = SwanAppSlaveManager.this.H.c;
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                SwanAppSlaveManager swanAppSlaveManager = SwanAppSlaveManager.this;
                swanAppSlaveManager.L.f(swanAppSlaveManager.H.g, true);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
                this.b.D("fmp_type", SwanAppSlaveManager.this.H.g);
                HybridUbcFlow hybridUbcFlow = this.b;
                hybridUbcFlow.F(ubcFlowEvent);
                hybridUbcFlow.C(SwanAppSlaveManager.this);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.H.g + " , fmpTypeName=" + SwanAppSlaveManager.this.H.a());
                }
            }
        }

        public SwanAppSlaveWebviewClientExt() {
        }

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstPaintDidEx");
            }
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.a = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
            }
            super.onPageBackOrForwardExt(bdSailorWebView, i);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPageCanBeScaledEx");
            }
            super.onPageCanBeScaledExt(bdSailorWebView, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            super.onPreloadUrlFoundExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.H.b = currentTimeMillis;
            q43.h().l().a(SwanAppSlaveManager.this.H.b);
            long b = SwanAppSlaveManager.this.H.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
            }
            HybridUbcFlow p = i43.p("startup");
            if (SwanAppSlaveManager.this.k1()) {
                SwanAppSlaveManager.this.L.e(true);
                p.b("fmp_data_record", SwanAppSlaveManager.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            p22.d().f();
            SwanAppSlaveManager.this.I.a();
            if (SwanAppSlaveManager.this.H.c == 0) {
                SwanAppSlaveManager.this.H.c = b;
                ux1 ux1Var = SwanAppSlaveManager.this.H;
                ux1Var.g = ux1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppSlaveManager.this.L.f("1", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = ku2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            xn3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            d82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.c = System.currentTimeMillis();
            SwanAppSlaveManager.this.H.g = "0";
            q43.h().l().c(SwanAppSlaveManager.this.H.c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.H.c);
            }
            HybridUbcFlow d = i43.d("startup");
            if (d != null) {
                d.D("webviewComponent", "1");
                d.D("fmp_type", "0");
                d.E("value", "arrive_success");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                SwanAppSlaveManager.this.L.f("0", true);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, true);
                d.F(ubcFlowEvent);
                d.C(SwanAppSlaveManager.this);
                ux1 ux1Var = SwanAppSlaveManager.this.H;
                d82.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.H.c), " , fmpType=", ux1Var.g, " , fmpTypeName=", ux1Var.a());
                i43.t();
            }
            p22.d().g();
            SwanAppSlaveManager.this.I.g();
            SwanAppSlaveManager.this.I.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            d82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.e = System.currentTimeMillis();
            q43.h().l().e(SwanAppSlaveManager.this.H.e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.H.e);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.e);
                HybridUbcFlow p = i43.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppSlaveManager.this.L.f("3", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.d = System.currentTimeMillis();
            q43.h().l().d(SwanAppSlaveManager.this.H.d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.H.d);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.d);
                HybridUbcFlow p = i43.p("startup");
                p.D("fmp_type", "2");
                p.F(ubcFlowEvent);
                SwanAppSlaveManager.this.L.f("2", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
            }
            super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            String str;
            if (SwanAppSlaveManager.M) {
                if (jsCodeCacheResult != null) {
                    str = jsCodeCacheResult.toString();
                } else {
                    str = StringUtil.NULL_STRING;
                }
                Log.d("SwanAppSlaveManager", str);
            }
            if (jsCodeCacheResult != null && jsCodeCacheResult.isCacheUsed) {
                if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                    SwanAppSlaveManager.this.J = true;
                } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                    SwanAppSlaveManager.this.K = true;
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onSecurityCheckResultEx");
            }
            super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onUrlRedirected");
            }
            super.onUrlRedirectedExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::canHandleImageEx");
            }
            return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
        }

        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            qw2.T().m(SwanAppSlaveManager.this.a(), new el2("PullDownRefresh"));
        }
    }

    @Override // com.baidu.tieba.jx1
    public boolean H() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r().canGoBack()) {
            this.y.r().goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.jx1
    public boolean I() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.tieba.jx1
    public ux1 L() {
        return this.H;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0() {
        super.Q0();
    }

    @Override // com.baidu.tieba.jx1
    public void R() {
        SwanAppActivity activity = qw2.T().getActivity();
        if (activity == null) {
            return;
        }
        eo3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0() {
        super.T0();
        j1();
        lc3 lc3Var = new lc3(this.h);
        lc3Var.j(this);
        this.h.b(lc3Var);
        this.H = new ux1();
        X0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public String a() {
        return this.w;
    }

    @Override // com.baidu.tieba.jx1
    @Nullable
    public t72 a0() {
        return this.B;
    }

    @Override // com.baidu.tieba.jx1
    public boolean c() {
        if (r().getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void c0() {
        cy2.d(this.w);
        up2.a().c(this.w);
    }

    @Override // com.baidu.tieba.jx1
    public int d0() {
        return v92.b(this.J, this.K);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void destroy() {
        W(null);
        R();
        super.destroy();
        ku2.J().i(this);
        rq3 rq3Var = this.A;
        if (rq3Var != null) {
            rq3Var.f();
        }
        t72 t72Var = this.B;
        if (t72Var != null) {
            t72Var.b();
        }
    }

    @Override // com.baidu.tieba.jx1
    public PullToRefreshBaseWebView f0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    @Override // com.baidu.tieba.jx1
    public boolean g0() {
        ux1 ux1Var;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            ux1Var = swanAppWebViewWidget.L();
        } else {
            ux1Var = this.H;
        }
        if (ux1Var != null && TextUtils.equals(ux1Var.g, "0") && ux1Var.c > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jx1
    @Nullable
    /* renamed from: g1 */
    public SwanAppWebViewWidget j() {
        return this.y;
    }

    @Override // com.baidu.tieba.jx1
    public String h0() {
        return this.G;
    }

    public void h1() {
        this.I.c();
    }

    public final void j1() {
        this.w = mh2.a();
    }

    public final boolean k1() {
        return !this.I.c;
    }

    @Override // com.baidu.tieba.jx1
    public String l() {
        return this.x;
    }

    @NonNull
    public SwanAppWebViewWidget l1() {
        return new SwanAppWebViewWidget(this.a.getBaseContext());
    }

    public final void o1() {
        NgWebView ngWebView;
        if (z03.e() || z03.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            ngWebView = this.y.r();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(z03.a(z03.b()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void onJSLoaded() {
        xh2.U().w0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void onPause() {
        super.onPause();
        this.I.d();
        ku2.J().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (db3.M() != null) {
            db3.M().P().y(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void onResume() {
        super.onResume();
        this.I.e();
        ku2.J().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (db3.M() != null) {
            db3.M().P().y(true);
        }
        o1();
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.I = new jh2(this);
        this.L = new qh2();
    }

    @Override // com.baidu.tieba.jx1
    public void J(uh2 uh2Var) {
        if (uh2Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + uh2Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(w92.a("appjs", uh2Var.a));
    }

    @Override // com.baidu.tieba.jx1
    public void Q(String str) {
        this.x = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0(SwanAppWebViewManager.d dVar) {
        super.S0(dVar);
        dVar.a = true;
    }

    @Override // com.baidu.tieba.jx1
    public void X(rc2 rc2Var) {
        this.E = rc2Var;
    }

    @Override // com.baidu.tieba.jx1
    public void Y(sc2 sc2Var) {
        this.C = sc2Var;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.attachActivity(activity);
        }
    }

    @Override // com.baidu.tieba.jx1
    public void g(d13 d13Var) {
        this.I.h(d13Var);
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.b.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.lx1
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (d82.f()) {
            y92.b();
        }
    }

    public void n1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a());
    }

    public void p1(rc2 rc2Var) {
        this.F = rc2Var;
    }

    @Override // com.baidu.tieba.jx1
    public boolean q(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i);
    }

    @Override // com.baidu.tieba.jx1
    public void u(String str) {
        this.G = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.u(str);
        }
    }

    @Override // com.baidu.tieba.jx1
    public void i(ViewGroup viewGroup, View view2) {
        if (viewGroup == null || view2 == null || i1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    public final boolean i1(ViewGroup viewGroup, View view2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view2) {
                return true;
            }
        }
        return false;
    }

    public final void m1(ViewGroup viewGroup, View view2) {
        if (viewGroup == null || view2 == null || !i1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    @Override // com.baidu.tieba.jx1
    public void y(FrameLayout frameLayout, sb3 sb3Var) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(sb3Var.e);
    }

    @Override // com.baidu.tieba.jx1
    public void B(int i) {
        boolean z;
        r().setVisibility(i);
        rq3 rq3Var = this.A;
        if (rq3Var != null) {
            rq3Var.h(i);
        }
        if (f0() != null) {
            f0().setVisibility(i);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            bf3 params = this.y.getParams();
            int i2 = 0;
            if (i == 0 && params != null && !params.f) {
                z = true;
            } else {
                z = false;
            }
            NgWebView r = this.y.r();
            if (!z) {
                i2 = 8;
            }
            r.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.jx1
    public boolean W(bf3 bf3Var) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            sc2 sc2Var = this.C;
            if (sc2Var != null) {
                sc2Var.b(swanAppWebViewWidget);
            }
            if (this.E != null) {
                this.E = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            m1(this.D, this.y.r());
            this.y.Q1(bf3Var);
            this.y.destroy();
            this.y = null;
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.setPullRefreshEnabled(true);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0() {
        String a2 = a();
        this.b.getCurrentWebView().addZeusPluginFactory(new ks2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new cp2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new yr2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new js2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new np2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new tp2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new sp2(a2));
    }

    @Override // com.baidu.tieba.jx1
    public void N(FrameLayout frameLayout, sb3 sb3Var) {
        if (frameLayout == null) {
            return;
        }
        if (sb3Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            q(SwanAppConfigData.t(sb3Var.d));
            n1(this.z);
            i(frameLayout, this.z);
        } else {
            i(frameLayout, r());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new rq3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new t72(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.tieba.jx1
    public boolean U(bf3 bf3Var) {
        int i = 0;
        if (this.y == null) {
            return false;
        }
        if (!TextUtils.isEmpty(bf3Var.k)) {
            this.y.Z0(bf3Var.k);
        }
        this.y.O1(bf3Var.m);
        this.y.loadUrl(bf3Var.j);
        this.y.Q1(bf3Var);
        if (bf3Var.h == null) {
            bf3Var.h = j13.a();
        }
        if (this.y.r() != null) {
            NgWebView r = this.y.r();
            if (bf3Var.f) {
                i = 8;
            }
            r.setVisibility(i);
        }
        rc2 rc2Var = this.E;
        if (rc2Var != null) {
            this.y.X(rc2Var);
        }
        rc2 rc2Var2 = this.F;
        if (rc2Var2 != null) {
            this.y.p1(rc2Var2);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.jx1
    public boolean x(bf3 bf3Var) {
        int i = 0;
        if (bf3Var != null && this.D != null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.w(false);
                this.z.setPullRefreshEnabled(false);
            }
            if (this.y == null) {
                if (M && !(this.a.getBaseContext() instanceof Activity)) {
                    Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                }
                SwanAppWebViewWidget l1 = l1();
                this.y = l1;
                l1.u(this.G);
                this.y.P1(this);
                if (!TextUtils.isEmpty(bf3Var.k)) {
                    this.y.Z0(bf3Var.k);
                }
                if (bf3Var.h == null) {
                    bf3Var.h = j13.a();
                }
                i(this.D, this.y.r());
                if (this.y.r() != null) {
                    NgWebView r = this.y.r();
                    if (bf3Var.f) {
                        i = 8;
                    }
                    r.setVisibility(i);
                    o1();
                }
                this.y.O1(bf3Var.m);
                this.y.loadUrl(bf3Var.j);
                this.y.Q1(bf3Var);
                sc2 sc2Var = this.C;
                if (sc2Var != null) {
                    sc2Var.a(this.y);
                }
                rc2 rc2Var = this.E;
                if (rc2Var != null) {
                    this.y.X(rc2Var);
                }
                rc2 rc2Var2 = this.F;
                if (rc2Var2 != null) {
                    this.y.p1(rc2Var2);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
