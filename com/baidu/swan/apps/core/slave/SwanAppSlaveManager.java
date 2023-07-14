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
import com.baidu.tieba.a53;
import com.baidu.tieba.b23;
import com.baidu.tieba.bi2;
import com.baidu.tieba.bt2;
import com.baidu.tieba.by1;
import com.baidu.tieba.ct2;
import com.baidu.tieba.cv2;
import com.baidu.tieba.dd3;
import com.baidu.tieba.ei2;
import com.baidu.tieba.fq2;
import com.baidu.tieba.fs1;
import com.baidu.tieba.h32;
import com.baidu.tieba.i53;
import com.baidu.tieba.ii2;
import com.baidu.tieba.ix2;
import com.baidu.tieba.jd2;
import com.baidu.tieba.jr3;
import com.baidu.tieba.kc3;
import com.baidu.tieba.kd2;
import com.baidu.tieba.kq2;
import com.baidu.tieba.l82;
import com.baidu.tieba.lq2;
import com.baidu.tieba.mi2;
import com.baidu.tieba.mq2;
import com.baidu.tieba.my1;
import com.baidu.tieba.na2;
import com.baidu.tieba.oa2;
import com.baidu.tieba.pi2;
import com.baidu.tieba.po3;
import com.baidu.tieba.qa2;
import com.baidu.tieba.qs2;
import com.baidu.tieba.r13;
import com.baidu.tieba.tf3;
import com.baidu.tieba.up2;
import com.baidu.tieba.uy2;
import com.baidu.tieba.v13;
import com.baidu.tieba.v82;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wl2;
import com.baidu.tieba.wo3;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements by1<NgWebView> {
    public static final boolean M = fs1.a;
    public jr3 A;
    @Nullable
    public l82 B;
    public kd2 C;
    public FrameLayout D;
    public jd2 E;
    public jd2 F;
    public String G;
    public my1 H;
    public bi2 I;
    public boolean J;
    public boolean K;
    public ii2 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    @Override // com.baidu.tieba.by1
    public int P() {
        return 0;
    }

    @Override // com.baidu.tieba.kx1
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
            v82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.H.b = currentTimeMillis;
            i53.h().l().a(SwanAppSlaveManager.this.H.b);
            long b = SwanAppSlaveManager.this.H.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
            }
            HybridUbcFlow p = a53.p("startup");
            if (SwanAppSlaveManager.this.k1()) {
                SwanAppSlaveManager.this.L.e(true);
                p.b("fmp_data_record", SwanAppSlaveManager.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            h32.d().f();
            SwanAppSlaveManager.this.I.a();
            if (SwanAppSlaveManager.this.H.c == 0) {
                SwanAppSlaveManager.this.H.c = b;
                my1 my1Var = SwanAppSlaveManager.this.H;
                my1Var.g = my1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppSlaveManager.this.L.f("1", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = cv2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            po3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            v82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.c = System.currentTimeMillis();
            SwanAppSlaveManager.this.H.g = "0";
            i53.h().l().c(SwanAppSlaveManager.this.H.c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.H.c);
            }
            HybridUbcFlow d = a53.d("startup");
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
                my1 my1Var = SwanAppSlaveManager.this.H;
                v82.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.H.c), " , fmpType=", my1Var.g, " , fmpTypeName=", my1Var.a());
                a53.t();
            }
            h32.d().g();
            SwanAppSlaveManager.this.I.g();
            SwanAppSlaveManager.this.I.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            v82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.e = System.currentTimeMillis();
            i53.h().l().e(SwanAppSlaveManager.this.H.e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.H.e);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.e);
                HybridUbcFlow p = a53.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppSlaveManager.this.L.f("3", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            v82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.d = System.currentTimeMillis();
            i53.h().l().d(SwanAppSlaveManager.this.H.d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.H.d);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.d);
                HybridUbcFlow p = a53.p("startup");
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
            ix2.T().m(SwanAppSlaveManager.this.a(), new wl2("PullDownRefresh"));
        }
    }

    @Override // com.baidu.tieba.by1
    public boolean H() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r().canGoBack()) {
            this.y.r().goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.by1
    public boolean I() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.tieba.by1
    public my1 L() {
        return this.H;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0() {
        super.Q0();
    }

    @Override // com.baidu.tieba.by1
    public void R() {
        SwanAppActivity activity = ix2.T().getActivity();
        if (activity == null) {
            return;
        }
        wo3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0() {
        super.T0();
        j1();
        dd3 dd3Var = new dd3(this.h);
        dd3Var.j(this);
        this.h.b(dd3Var);
        this.H = new my1();
        X0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public String a() {
        return this.w;
    }

    @Override // com.baidu.tieba.by1
    @Nullable
    public l82 a0() {
        return this.B;
    }

    @Override // com.baidu.tieba.by1
    public boolean c() {
        if (r().getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void c0() {
        uy2.d(this.w);
        mq2.a().c(this.w);
    }

    @Override // com.baidu.tieba.by1
    public int d0() {
        return na2.b(this.J, this.K);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void destroy() {
        V(null);
        R();
        super.destroy();
        cv2.J().i(this);
        jr3 jr3Var = this.A;
        if (jr3Var != null) {
            jr3Var.f();
        }
        l82 l82Var = this.B;
        if (l82Var != null) {
            l82Var.b();
        }
    }

    @Override // com.baidu.tieba.by1
    public PullToRefreshBaseWebView f0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    @Override // com.baidu.tieba.by1
    public boolean g0() {
        my1 my1Var;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            my1Var = swanAppWebViewWidget.L();
        } else {
            my1Var = this.H;
        }
        if (my1Var != null && TextUtils.equals(my1Var.g, "0") && my1Var.c > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.by1
    @Nullable
    /* renamed from: g1 */
    public SwanAppWebViewWidget j() {
        return this.y;
    }

    @Override // com.baidu.tieba.by1
    public String h0() {
        return this.G;
    }

    public void h1() {
        this.I.c();
    }

    public final void j1() {
        this.w = ei2.a();
    }

    public final boolean k1() {
        return !this.I.c;
    }

    @Override // com.baidu.tieba.by1
    public String l() {
        return this.x;
    }

    @NonNull
    public SwanAppWebViewWidget l1() {
        return new SwanAppWebViewWidget(this.a.getBaseContext());
    }

    public final void o1() {
        NgWebView ngWebView;
        if (r13.e() || r13.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            ngWebView = this.y.r();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(r13.a(r13.b()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void onJSLoaded() {
        pi2.U().w0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void onPause() {
        super.onPause();
        this.I.d();
        cv2.J().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (vb3.M() != null) {
            vb3.M().P().y(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void onResume() {
        super.onResume();
        this.I.e();
        cv2.J().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (vb3.M() != null) {
            vb3.M().P().y(true);
        }
        o1();
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.I = new bi2(this);
        this.L = new ii2();
    }

    @Override // com.baidu.tieba.by1
    public void J(mi2 mi2Var) {
        if (mi2Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + mi2Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(oa2.a("appjs", mi2Var.a));
    }

    @Override // com.baidu.tieba.by1
    public void Q(String str) {
        this.x = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0(SwanAppWebViewManager.d dVar) {
        super.S0(dVar);
        dVar.a = true;
    }

    @Override // com.baidu.tieba.by1
    public void W(jd2 jd2Var) {
        this.E = jd2Var;
    }

    @Override // com.baidu.tieba.by1
    public void X(kd2 kd2Var) {
        this.C = kd2Var;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.attachActivity(activity);
        }
    }

    @Override // com.baidu.tieba.by1
    public void g(v13 v13Var) {
        this.I.h(v13Var);
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.b.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.dy1
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (v82.f()) {
            qa2.b();
        }
    }

    public void n1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a());
    }

    public void p1(jd2 jd2Var) {
        this.F = jd2Var;
    }

    @Override // com.baidu.tieba.by1
    public boolean q(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i);
    }

    @Override // com.baidu.tieba.by1
    public void u(String str) {
        this.G = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.u(str);
        }
    }

    @Override // com.baidu.tieba.by1
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

    @Override // com.baidu.tieba.by1
    public void y(FrameLayout frameLayout, kc3 kc3Var) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(kc3Var.e);
    }

    @Override // com.baidu.tieba.by1
    public void B(int i) {
        boolean z;
        r().setVisibility(i);
        jr3 jr3Var = this.A;
        if (jr3Var != null) {
            jr3Var.h(i);
        }
        if (f0() != null) {
            f0().setVisibility(i);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            tf3 params = this.y.getParams();
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

    @Override // com.baidu.tieba.by1
    public boolean V(tf3 tf3Var) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            kd2 kd2Var = this.C;
            if (kd2Var != null) {
                kd2Var.b(swanAppWebViewWidget);
            }
            if (this.E != null) {
                this.E = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            m1(this.D, this.y.r());
            this.y.Q1(tf3Var);
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
        this.b.getCurrentWebView().addZeusPluginFactory(new ct2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new up2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new qs2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new bt2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new fq2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new lq2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new kq2(a2));
    }

    @Override // com.baidu.tieba.by1
    public void N(FrameLayout frameLayout, kc3 kc3Var) {
        if (frameLayout == null) {
            return;
        }
        if (kc3Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            q(SwanAppConfigData.t(kc3Var.d));
            n1(this.z);
            i(frameLayout, this.z);
        } else {
            i(frameLayout, r());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new jr3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new l82(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.tieba.by1
    public boolean U(tf3 tf3Var) {
        int i = 0;
        if (this.y == null) {
            return false;
        }
        if (!TextUtils.isEmpty(tf3Var.k)) {
            this.y.Z0(tf3Var.k);
        }
        this.y.O1(tf3Var.m);
        this.y.loadUrl(tf3Var.j);
        this.y.Q1(tf3Var);
        if (tf3Var.h == null) {
            tf3Var.h = b23.a();
        }
        if (this.y.r() != null) {
            NgWebView r = this.y.r();
            if (tf3Var.f) {
                i = 8;
            }
            r.setVisibility(i);
        }
        jd2 jd2Var = this.E;
        if (jd2Var != null) {
            this.y.W(jd2Var);
        }
        jd2 jd2Var2 = this.F;
        if (jd2Var2 != null) {
            this.y.p1(jd2Var2);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.by1
    public boolean x(tf3 tf3Var) {
        int i = 0;
        if (tf3Var != null && this.D != null) {
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
                if (!TextUtils.isEmpty(tf3Var.k)) {
                    this.y.Z0(tf3Var.k);
                }
                if (tf3Var.h == null) {
                    tf3Var.h = b23.a();
                }
                i(this.D, this.y.r());
                if (this.y.r() != null) {
                    NgWebView r = this.y.r();
                    if (tf3Var.f) {
                        i = 8;
                    }
                    r.setVisibility(i);
                    o1();
                }
                this.y.O1(tf3Var.m);
                this.y.loadUrl(tf3Var.j);
                this.y.Q1(tf3Var);
                kd2 kd2Var = this.C;
                if (kd2Var != null) {
                    kd2Var.a(this.y);
                }
                jd2 jd2Var = this.E;
                if (jd2Var != null) {
                    this.y.W(jd2Var);
                }
                jd2 jd2Var2 = this.F;
                if (jd2Var2 != null) {
                    this.y.p1(jd2Var2);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
