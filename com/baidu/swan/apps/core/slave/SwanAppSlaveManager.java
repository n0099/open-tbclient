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
import com.baidu.tieba.a52;
import com.baidu.tieba.bd2;
import com.baidu.tieba.bj3;
import com.baidu.tieba.c52;
import com.baidu.tieba.cn2;
import com.baidu.tieba.dw2;
import com.baidu.tieba.fa3;
import com.baidu.tieba.gk2;
import com.baidu.tieba.gt2;
import com.baidu.tieba.h32;
import com.baidu.tieba.h63;
import com.baidu.tieba.hw2;
import com.baidu.tieba.ig2;
import com.baidu.tieba.ij3;
import com.baidu.tieba.mz2;
import com.baidu.tieba.nc2;
import com.baidu.tieba.nn2;
import com.baidu.tieba.nw2;
import com.baidu.tieba.on2;
import com.baidu.tieba.op2;
import com.baidu.tieba.os1;
import com.baidu.tieba.p73;
import com.baidu.tieba.qc2;
import com.baidu.tieba.rk2;
import com.baidu.tieba.sm1;
import com.baidu.tieba.uc2;
import com.baidu.tieba.ur2;
import com.baidu.tieba.ux1;
import com.baidu.tieba.uz2;
import com.baidu.tieba.v72;
import com.baidu.tieba.vl3;
import com.baidu.tieba.w63;
import com.baidu.tieba.w72;
import com.baidu.tieba.wk2;
import com.baidu.tieba.x22;
import com.baidu.tieba.xk2;
import com.baidu.tieba.yc2;
import com.baidu.tieba.yk2;
import com.baidu.tieba.z42;
import com.baidu.tieba.zs1;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements os1<NgWebView> {
    public static final boolean M = sm1.a;
    public vl3 A;
    @Nullable
    public x22 B;
    public w72 C;
    public FrameLayout D;
    public v72 E;
    public v72 F;
    public String G;
    public zs1 H;
    public nc2 I;
    public boolean J;
    public boolean K;
    public uc2 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    @Override // com.baidu.tieba.os1
    public int O() {
        return 0;
    }

    @Override // com.baidu.tieba.xr1
    public double y() {
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
            h32.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.H.b = currentTimeMillis;
            uz2.h().l().a(SwanAppSlaveManager.this.H.b);
            long b = SwanAppSlaveManager.this.H.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
            }
            HybridUbcFlow p = mz2.p("startup");
            if (SwanAppSlaveManager.this.j1()) {
                SwanAppSlaveManager.this.L.e(true);
                p.b("fmp_data_record", SwanAppSlaveManager.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            ux1.d().f();
            SwanAppSlaveManager.this.I.a();
            if (SwanAppSlaveManager.this.H.c == 0) {
                SwanAppSlaveManager.this.H.c = b;
                zs1 zs1Var = SwanAppSlaveManager.this.H;
                zs1Var.g = zs1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppSlaveManager.this.L.f("1", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = op2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            bj3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            h32.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.c = System.currentTimeMillis();
            SwanAppSlaveManager.this.H.g = "0";
            uz2.h().l().c(SwanAppSlaveManager.this.H.c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.H.c);
            }
            HybridUbcFlow d = mz2.d("startup");
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
                zs1 zs1Var = SwanAppSlaveManager.this.H;
                h32.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.H.c), " , fmpType=", zs1Var.g, " , fmpTypeName=", zs1Var.a());
                mz2.t();
            }
            ux1.d().g();
            SwanAppSlaveManager.this.I.g();
            SwanAppSlaveManager.this.I.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            h32.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.e = System.currentTimeMillis();
            uz2.h().l().e(SwanAppSlaveManager.this.H.e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.H.e);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.e);
                HybridUbcFlow p = mz2.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppSlaveManager.this.L.f("3", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            h32.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.d = System.currentTimeMillis();
            uz2.h().l().d(SwanAppSlaveManager.this.H.d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.H.d);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.d);
                HybridUbcFlow p = mz2.p("startup");
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
            ur2.V().n(SwanAppSlaveManager.this.a(), new ig2("PullDownRefresh"));
        }
    }

    @Override // com.baidu.tieba.os1
    public boolean G() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.getWebView().canGoBack()) {
            this.y.getWebView().goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.os1
    public boolean I() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.tieba.os1
    public zs1 K() {
        return this.H;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
        super.P0();
    }

    @Override // com.baidu.tieba.os1
    public void Q() {
        SwanAppActivity activity = ur2.V().getActivity();
        if (activity == null) {
            return;
        }
        ij3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        super.S0();
        i1();
        p73 p73Var = new p73(this.h);
        p73Var.j(this);
        this.h.b(p73Var);
        this.H = new zs1();
        W0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // com.baidu.tieba.os1
    @Nullable
    public x22 Z() {
        return this.B;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public String a() {
        return this.w;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void b0() {
        gt2.d(this.w);
        yk2.a().c(this.w);
    }

    @Override // com.baidu.tieba.os1
    public boolean c() {
        if (getWebView().getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.os1
    public int c0() {
        return z42.b(this.J, this.K);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void destroy() {
        U(null);
        Q();
        super.destroy();
        op2.J().i(this);
        vl3 vl3Var = this.A;
        if (vl3Var != null) {
            vl3Var.f();
        }
        x22 x22Var = this.B;
        if (x22Var != null) {
            x22Var.c();
        }
    }

    @Override // com.baidu.tieba.os1
    public PullToRefreshBaseWebView e0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    @Override // com.baidu.tieba.os1
    public boolean f0() {
        zs1 zs1Var;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            zs1Var = swanAppWebViewWidget.K();
        } else {
            zs1Var = this.H;
        }
        if (zs1Var != null && TextUtils.equals(zs1Var.g, "0") && zs1Var.c > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.os1
    @Nullable
    /* renamed from: f1 */
    public SwanAppWebViewWidget j() {
        return this.y;
    }

    @Override // com.baidu.tieba.os1
    public String g0() {
        return this.G;
    }

    public void g1() {
        this.I.c();
    }

    public final void i1() {
        this.w = qc2.a();
    }

    public final boolean j1() {
        return !this.I.c;
    }

    @NonNull
    public SwanAppWebViewWidget k1() {
        return new SwanAppWebViewWidget(this.a.getBaseContext());
    }

    @Override // com.baidu.tieba.os1
    public String l() {
        return this.x;
    }

    public final void n1() {
        NgWebView ngWebView;
        if (dw2.e() || dw2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.getWebView() != null) {
            ngWebView = this.y.getWebView();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(dw2.a(dw2.b()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void onJSLoaded() {
        bd2.V().x0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void onPause() {
        super.onPause();
        this.I.d();
        op2.J().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (h63.M() != null) {
            h63.M().Q().y(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void onResume() {
        super.onResume();
        this.I.e();
        op2.J().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (h63.M() != null) {
            h63.M().Q().y(true);
        }
        n1();
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.I = new nc2(this);
        this.L = new uc2();
    }

    @Override // com.baidu.tieba.os1
    public void J(yc2 yc2Var) {
        if (yc2Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + yc2Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(a52.a("appjs", yc2Var.a));
    }

    @Override // com.baidu.tieba.os1
    public void P(String str) {
        this.x = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void R0(SwanAppWebViewManager.d dVar) {
        super.R0(dVar);
        dVar.a = true;
    }

    @Override // com.baidu.tieba.os1
    public void V(v72 v72Var) {
        this.E = v72Var;
    }

    @Override // com.baidu.tieba.os1
    public void W(w72 w72Var) {
        this.C = w72Var;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.attachActivity(activity);
        }
    }

    @Override // com.baidu.tieba.os1
    public void g(hw2 hw2Var) {
        this.I.h(hw2Var);
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.b.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.qs1
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (h32.f()) {
            c52.b();
        }
    }

    public void m1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a());
    }

    public void o1(v72 v72Var) {
        this.F = v72Var;
    }

    @Override // com.baidu.tieba.os1
    public boolean q(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i);
    }

    @Override // com.baidu.tieba.os1
    public void t(String str) {
        this.G = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.t(str);
        }
    }

    public final boolean h1(ViewGroup viewGroup, View view2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.os1
    public void i(ViewGroup viewGroup, View view2) {
        if (viewGroup == null || view2 == null || h1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void l1(ViewGroup viewGroup, View view2) {
        if (viewGroup == null || view2 == null || !h1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    @Override // com.baidu.tieba.os1
    public void x(FrameLayout frameLayout, w63 w63Var) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(w63Var.e);
    }

    @Override // com.baidu.tieba.os1
    public void A(int i) {
        boolean z;
        getWebView().setVisibility(i);
        vl3 vl3Var = this.A;
        if (vl3Var != null) {
            vl3Var.h(i);
        }
        if (e0() != null) {
            e0().setVisibility(i);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.getWebView() != null) {
            fa3 params = this.y.getParams();
            int i2 = 0;
            if (i == 0 && params != null && !params.f) {
                z = true;
            } else {
                z = false;
            }
            NgWebView webView = this.y.getWebView();
            if (!z) {
                i2 = 8;
            }
            webView.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.os1
    public boolean U(fa3 fa3Var) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            w72 w72Var = this.C;
            if (w72Var != null) {
                w72Var.b(swanAppWebViewWidget);
            }
            if (this.E != null) {
                this.E = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            l1(this.D, this.y.getWebView());
            this.y.P1(fa3Var);
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
    public void I0() {
        String a2 = a();
        this.b.getCurrentWebView().addZeusPluginFactory(new on2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new gk2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new cn2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new nn2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new rk2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new xk2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new wk2(a2));
    }

    @Override // com.baidu.tieba.os1
    public void M(FrameLayout frameLayout, w63 w63Var) {
        if (frameLayout == null) {
            return;
        }
        if (w63Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            q(SwanAppConfigData.t(w63Var.d));
            m1(this.z);
            i(frameLayout, this.z);
        } else {
            i(frameLayout, getWebView());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new vl3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new x22(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.tieba.os1
    public boolean T(fa3 fa3Var) {
        int i = 0;
        if (this.y == null) {
            return false;
        }
        if (!TextUtils.isEmpty(fa3Var.k)) {
            this.y.Y0(fa3Var.k);
        }
        this.y.N1(fa3Var.m);
        this.y.loadUrl(fa3Var.j);
        this.y.P1(fa3Var);
        if (fa3Var.h == null) {
            fa3Var.h = nw2.a();
        }
        if (this.y.getWebView() != null) {
            NgWebView webView = this.y.getWebView();
            if (fa3Var.f) {
                i = 8;
            }
            webView.setVisibility(i);
        }
        v72 v72Var = this.E;
        if (v72Var != null) {
            this.y.V(v72Var);
        }
        v72 v72Var2 = this.F;
        if (v72Var2 != null) {
            this.y.o1(v72Var2);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.os1
    public boolean u(fa3 fa3Var) {
        int i = 0;
        if (fa3Var != null && this.D != null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.w(false);
                this.z.setPullRefreshEnabled(false);
            }
            if (this.y == null) {
                if (M && !(this.a.getBaseContext() instanceof Activity)) {
                    Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                }
                SwanAppWebViewWidget k1 = k1();
                this.y = k1;
                k1.t(this.G);
                this.y.O1(this);
                if (!TextUtils.isEmpty(fa3Var.k)) {
                    this.y.Y0(fa3Var.k);
                }
                if (fa3Var.h == null) {
                    fa3Var.h = nw2.a();
                }
                i(this.D, this.y.getWebView());
                if (this.y.getWebView() != null) {
                    NgWebView webView = this.y.getWebView();
                    if (fa3Var.f) {
                        i = 8;
                    }
                    webView.setVisibility(i);
                    n1();
                }
                this.y.N1(fa3Var.m);
                this.y.loadUrl(fa3Var.j);
                this.y.P1(fa3Var);
                w72 w72Var = this.C;
                if (w72Var != null) {
                    w72Var.a(this.y);
                }
                v72 v72Var = this.E;
                if (v72Var != null) {
                    this.y.V(v72Var);
                }
                v72 v72Var2 = this.F;
                if (v72Var2 != null) {
                    this.y.o1(v72Var2);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
