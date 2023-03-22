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
import com.baidu.tieba.ap2;
import com.baidu.tieba.ar2;
import com.baidu.tieba.b93;
import com.baidu.tieba.ce2;
import com.baidu.tieba.dm2;
import com.baidu.tieba.do1;
import com.baidu.tieba.fz1;
import com.baidu.tieba.g13;
import com.baidu.tieba.ge2;
import com.baidu.tieba.gt2;
import com.baidu.tieba.h92;
import com.baidu.tieba.hn3;
import com.baidu.tieba.i83;
import com.baidu.tieba.i92;
import com.baidu.tieba.im2;
import com.baidu.tieba.j42;
import com.baidu.tieba.jm2;
import com.baidu.tieba.ke2;
import com.baidu.tieba.km2;
import com.baidu.tieba.ku1;
import com.baidu.tieba.l62;
import com.baidu.tieba.m62;
import com.baidu.tieba.ne2;
import com.baidu.tieba.nk3;
import com.baidu.tieba.o62;
import com.baidu.tieba.oo2;
import com.baidu.tieba.px2;
import com.baidu.tieba.rb3;
import com.baidu.tieba.sl2;
import com.baidu.tieba.su2;
import com.baidu.tieba.t42;
import com.baidu.tieba.t73;
import com.baidu.tieba.tx2;
import com.baidu.tieba.uh2;
import com.baidu.tieba.uk3;
import com.baidu.tieba.y03;
import com.baidu.tieba.zd2;
import com.baidu.tieba.zo2;
import com.baidu.tieba.zt1;
import com.baidu.tieba.zx2;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements zt1<NgWebView> {
    public static final boolean M = do1.a;
    public hn3 A;
    @Nullable
    public j42 B;
    public i92 C;
    public FrameLayout D;
    public h92 E;
    public h92 F;
    public String G;
    public ku1 H;
    public zd2 I;
    public boolean J;
    public boolean K;
    public ge2 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    @Override // com.baidu.tieba.it1
    public double A() {
        return 1.0d;
    }

    @Override // com.baidu.tieba.zt1
    public int Q() {
        return 0;
    }

    /* loaded from: classes3.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes3.dex */
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
            t42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.H.b = currentTimeMillis;
            g13.h().l().a(SwanAppSlaveManager.this.H.b);
            long b = SwanAppSlaveManager.this.H.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
            }
            HybridUbcFlow p = y03.p("startup");
            if (SwanAppSlaveManager.this.m1()) {
                SwanAppSlaveManager.this.L.e(true);
                p.b("fmp_data_record", SwanAppSlaveManager.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            fz1.d().f();
            SwanAppSlaveManager.this.I.a();
            if (SwanAppSlaveManager.this.H.c == 0) {
                SwanAppSlaveManager.this.H.c = b;
                ku1 ku1Var = SwanAppSlaveManager.this.H;
                ku1Var.g = ku1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppSlaveManager.this.L.f("1", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = ar2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            nk3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.c = System.currentTimeMillis();
            SwanAppSlaveManager.this.H.g = "0";
            g13.h().l().c(SwanAppSlaveManager.this.H.c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.H.c);
            }
            HybridUbcFlow d = y03.d("startup");
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
                ku1 ku1Var = SwanAppSlaveManager.this.H;
                t42.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.H.c), " , fmpType=", ku1Var.g, " , fmpTypeName=", ku1Var.a());
                y03.t();
            }
            fz1.d().g();
            SwanAppSlaveManager.this.I.g();
            SwanAppSlaveManager.this.I.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.e = System.currentTimeMillis();
            g13.h().l().e(SwanAppSlaveManager.this.H.e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.H.e);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.e);
                HybridUbcFlow p = y03.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppSlaveManager.this.L.f("3", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.d = System.currentTimeMillis();
            g13.h().l().d(SwanAppSlaveManager.this.H.d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.H.d);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.d);
                HybridUbcFlow p = y03.p("startup");
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

    /* loaded from: classes3.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
        }

        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            gt2.U().m(SwanAppSlaveManager.this.a(), new uh2("PullDownRefresh"));
        }
    }

    @Override // com.baidu.tieba.zt1
    public boolean I() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r().canGoBack()) {
            this.y.r().goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.zt1
    public boolean J() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.tieba.zt1
    public ku1 M() {
        return this.H;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        super.S0();
    }

    @Override // com.baidu.tieba.zt1
    public void T() {
        SwanAppActivity activity = gt2.U().getActivity();
        if (activity == null) {
            return;
        }
        uk3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        super.V0();
        l1();
        b93 b93Var = new b93(this.h);
        b93Var.j(this);
        this.h.b(b93Var);
        this.H = new ku1();
        Z0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public String a() {
        return this.w;
    }

    @Override // com.baidu.tieba.zt1
    public boolean c() {
        if (r().getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.zt1
    @Nullable
    public j42 c0() {
        return this.B;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void destroy() {
        X(null);
        T();
        super.destroy();
        ar2.J().i(this);
        hn3 hn3Var = this.A;
        if (hn3Var != null) {
            hn3Var.f();
        }
        j42 j42Var = this.B;
        if (j42Var != null) {
            j42Var.b();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void e0() {
        su2.d(this.w);
        km2.a().c(this.w);
    }

    @Override // com.baidu.tieba.zt1
    public int f0() {
        return l62.b(this.J, this.K);
    }

    @Override // com.baidu.tieba.zt1
    public PullToRefreshBaseWebView h0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    @Override // com.baidu.tieba.zt1
    public boolean i0() {
        ku1 ku1Var;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            ku1Var = swanAppWebViewWidget.M();
        } else {
            ku1Var = this.H;
        }
        if (ku1Var != null && TextUtils.equals(ku1Var.g, "0") && ku1Var.c > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zt1
    @Nullable
    /* renamed from: i1 */
    public SwanAppWebViewWidget k() {
        return this.y;
    }

    @Override // com.baidu.tieba.zt1
    public String j0() {
        return this.G;
    }

    public void j1() {
        this.I.c();
    }

    public final void l1() {
        this.w = ce2.a();
    }

    @Override // com.baidu.tieba.zt1
    public String m() {
        return this.x;
    }

    public final boolean m1() {
        return !this.I.c;
    }

    @NonNull
    public SwanAppWebViewWidget n1() {
        return new SwanAppWebViewWidget(this.a.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void onJSLoaded() {
        ne2.U().w0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void onPause() {
        super.onPause();
        this.I.d();
        ar2.J().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (t73.M() != null) {
            t73.M().P().y(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void onResume() {
        super.onResume();
        this.I.e();
        ar2.J().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (t73.M() != null) {
            t73.M().P().y(true);
        }
        q1();
    }

    public final void q1() {
        NgWebView ngWebView;
        if (px2.e() || px2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            ngWebView = this.y.r();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(px2.a(px2.b()));
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.I = new zd2(this);
        this.L = new ge2();
    }

    @Override // com.baidu.tieba.zt1
    public void L(ke2 ke2Var) {
        if (ke2Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + ke2Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(m62.a("appjs", ke2Var.a));
    }

    @Override // com.baidu.tieba.zt1
    public void R(String str) {
        this.x = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        super.U0(dVar);
        dVar.a = true;
    }

    @Override // com.baidu.tieba.zt1
    public void Y(h92 h92Var) {
        this.E = h92Var;
    }

    @Override // com.baidu.tieba.zt1
    public void Z(i92 i92Var) {
        this.C = i92Var;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.attachActivity(activity);
        }
    }

    @Override // com.baidu.tieba.zt1
    public void h(tx2 tx2Var) {
        this.I.h(tx2Var);
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.b.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (t42.f()) {
            o62.b();
        }
    }

    public void p1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a());
    }

    public void r1(h92 h92Var) {
        this.F = h92Var;
    }

    @Override // com.baidu.tieba.zt1
    public boolean s(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i);
    }

    @Override // com.baidu.tieba.zt1
    public void x(String str) {
        this.G = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.x(str);
        }
    }

    @Override // com.baidu.tieba.zt1
    public void j(ViewGroup viewGroup, View view2) {
        if (viewGroup == null || view2 == null || k1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    public final boolean k1(ViewGroup viewGroup, View view2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view2) {
                return true;
            }
        }
        return false;
    }

    public final void o1(ViewGroup viewGroup, View view2) {
        if (viewGroup == null || view2 == null || !k1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    @Override // com.baidu.tieba.zt1
    public void z(FrameLayout frameLayout, i83 i83Var) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(i83Var.e);
    }

    @Override // com.baidu.tieba.zt1
    public void C(int i) {
        boolean z;
        r().setVisibility(i);
        hn3 hn3Var = this.A;
        if (hn3Var != null) {
            hn3Var.h(i);
        }
        if (h0() != null) {
            h0().setVisibility(i);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            rb3 params = this.y.getParams();
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

    @Override // com.baidu.tieba.zt1
    public boolean X(rb3 rb3Var) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            i92 i92Var = this.C;
            if (i92Var != null) {
                i92Var.b(swanAppWebViewWidget);
            }
            if (this.E != null) {
                this.E = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            o1(this.D, this.y.r());
            this.y.S1(rb3Var);
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
    public void L0() {
        String a2 = a();
        this.b.getCurrentWebView().addZeusPluginFactory(new ap2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new sl2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new oo2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new zo2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new dm2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new jm2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new im2(a2));
    }

    @Override // com.baidu.tieba.zt1
    public void O(FrameLayout frameLayout, i83 i83Var) {
        if (frameLayout == null) {
            return;
        }
        if (i83Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            s(SwanAppConfigData.t(i83Var.d));
            p1(this.z);
            j(frameLayout, this.z);
        } else {
            j(frameLayout, r());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new hn3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new j42(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.tieba.zt1
    public boolean W(rb3 rb3Var) {
        int i = 0;
        if (this.y == null) {
            return false;
        }
        if (!TextUtils.isEmpty(rb3Var.k)) {
            this.y.b1(rb3Var.k);
        }
        this.y.Q1(rb3Var.m);
        this.y.loadUrl(rb3Var.j);
        this.y.S1(rb3Var);
        if (rb3Var.h == null) {
            rb3Var.h = zx2.a();
        }
        if (this.y.r() != null) {
            NgWebView r = this.y.r();
            if (rb3Var.f) {
                i = 8;
            }
            r.setVisibility(i);
        }
        h92 h92Var = this.E;
        if (h92Var != null) {
            this.y.Y(h92Var);
        }
        h92 h92Var2 = this.F;
        if (h92Var2 != null) {
            this.y.r1(h92Var2);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.zt1
    public boolean y(rb3 rb3Var) {
        int i = 0;
        if (rb3Var != null && this.D != null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.w(false);
                this.z.setPullRefreshEnabled(false);
            }
            if (this.y == null) {
                if (M && !(this.a.getBaseContext() instanceof Activity)) {
                    Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                }
                SwanAppWebViewWidget n1 = n1();
                this.y = n1;
                n1.x(this.G);
                this.y.R1(this);
                if (!TextUtils.isEmpty(rb3Var.k)) {
                    this.y.b1(rb3Var.k);
                }
                if (rb3Var.h == null) {
                    rb3Var.h = zx2.a();
                }
                j(this.D, this.y.r());
                if (this.y.r() != null) {
                    NgWebView r = this.y.r();
                    if (rb3Var.f) {
                        i = 8;
                    }
                    r.setVisibility(i);
                    q1();
                }
                this.y.Q1(rb3Var.m);
                this.y.loadUrl(rb3Var.j);
                this.y.S1(rb3Var);
                i92 i92Var = this.C;
                if (i92Var != null) {
                    i92Var.a(this.y);
                }
                h92 h92Var = this.E;
                if (h92Var != null) {
                    this.y.Y(h92Var);
                }
                h92 h92Var2 = this.F;
                if (h92Var2 != null) {
                    this.y.r1(h92Var2);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
