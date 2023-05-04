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
import com.baidu.tieba.c13;
import com.baidu.tieba.de2;
import com.baidu.tieba.dp2;
import com.baidu.tieba.du1;
import com.baidu.tieba.dy2;
import com.baidu.tieba.ep2;
import com.baidu.tieba.er2;
import com.baidu.tieba.f93;
import com.baidu.tieba.ge2;
import com.baidu.tieba.hm2;
import com.baidu.tieba.ho1;
import com.baidu.tieba.jz1;
import com.baidu.tieba.k13;
import com.baidu.tieba.ke2;
import com.baidu.tieba.kt2;
import com.baidu.tieba.l92;
import com.baidu.tieba.ln3;
import com.baidu.tieba.m83;
import com.baidu.tieba.m92;
import com.baidu.tieba.mm2;
import com.baidu.tieba.n42;
import com.baidu.tieba.nm2;
import com.baidu.tieba.oe2;
import com.baidu.tieba.om2;
import com.baidu.tieba.ou1;
import com.baidu.tieba.p62;
import com.baidu.tieba.q62;
import com.baidu.tieba.re2;
import com.baidu.tieba.rk3;
import com.baidu.tieba.s62;
import com.baidu.tieba.so2;
import com.baidu.tieba.tx2;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wl2;
import com.baidu.tieba.wu2;
import com.baidu.tieba.x42;
import com.baidu.tieba.x73;
import com.baidu.tieba.xx2;
import com.baidu.tieba.yh2;
import com.baidu.tieba.yk3;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements du1<NgWebView> {
    public static final boolean M = ho1.a;
    public ln3 A;
    @Nullable
    public n42 B;
    public m92 C;
    public FrameLayout D;
    public l92 E;
    public l92 F;
    public String G;
    public ou1 H;
    public de2 I;
    public boolean J;
    public boolean K;
    public ke2 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    @Override // com.baidu.tieba.mt1
    public double A() {
        return 1.0d;
    }

    @Override // com.baidu.tieba.du1
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
            x42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.H.b = currentTimeMillis;
            k13.h().l().a(SwanAppSlaveManager.this.H.b);
            long b = SwanAppSlaveManager.this.H.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
            }
            HybridUbcFlow p = c13.p("startup");
            if (SwanAppSlaveManager.this.m1()) {
                SwanAppSlaveManager.this.L.e(true);
                p.b("fmp_data_record", SwanAppSlaveManager.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            jz1.d().f();
            SwanAppSlaveManager.this.I.a();
            if (SwanAppSlaveManager.this.H.c == 0) {
                SwanAppSlaveManager.this.H.c = b;
                ou1 ou1Var = SwanAppSlaveManager.this.H;
                ou1Var.g = ou1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppSlaveManager.this.L.f("1", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = er2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            rk3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            x42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.c = System.currentTimeMillis();
            SwanAppSlaveManager.this.H.g = "0";
            k13.h().l().c(SwanAppSlaveManager.this.H.c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.H.c);
            }
            HybridUbcFlow d = c13.d("startup");
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
                ou1 ou1Var = SwanAppSlaveManager.this.H;
                x42.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.H.c), " , fmpType=", ou1Var.g, " , fmpTypeName=", ou1Var.a());
                c13.t();
            }
            jz1.d().g();
            SwanAppSlaveManager.this.I.g();
            SwanAppSlaveManager.this.I.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            x42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.e = System.currentTimeMillis();
            k13.h().l().e(SwanAppSlaveManager.this.H.e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.H.e);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.e);
                HybridUbcFlow p = c13.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppSlaveManager.this.L.f("3", false);
                SwanAppSlaveManager.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            x42.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.H.d = System.currentTimeMillis();
            k13.h().l().d(SwanAppSlaveManager.this.H.d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.H.d);
            }
            if (SwanAppSlaveManager.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.H.d);
                HybridUbcFlow p = c13.p("startup");
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
            kt2.U().m(SwanAppSlaveManager.this.a(), new yh2("PullDownRefresh"));
        }
    }

    @Override // com.baidu.tieba.du1
    public boolean I() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.s().canGoBack()) {
            this.y.s().goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.du1
    public boolean J() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.tieba.du1
    public ou1 M() {
        return this.H;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        super.S0();
    }

    @Override // com.baidu.tieba.du1
    public void T() {
        SwanAppActivity activity = kt2.U().getActivity();
        if (activity == null) {
            return;
        }
        yk3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        super.V0();
        l1();
        f93 f93Var = new f93(this.h);
        f93Var.j(this);
        this.h.b(f93Var);
        this.H = new ou1();
        Z0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public String a() {
        return this.w;
    }

    @Override // com.baidu.tieba.du1
    public boolean c() {
        if (s().getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.du1
    @Nullable
    public n42 c0() {
        return this.B;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void destroy() {
        X(null);
        T();
        super.destroy();
        er2.J().i(this);
        ln3 ln3Var = this.A;
        if (ln3Var != null) {
            ln3Var.f();
        }
        n42 n42Var = this.B;
        if (n42Var != null) {
            n42Var.b();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void e0() {
        wu2.d(this.w);
        om2.a().c(this.w);
    }

    @Override // com.baidu.tieba.du1
    public int f0() {
        return p62.b(this.J, this.K);
    }

    @Override // com.baidu.tieba.du1
    public PullToRefreshBaseWebView h0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    @Override // com.baidu.tieba.du1
    public boolean i0() {
        ou1 ou1Var;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            ou1Var = swanAppWebViewWidget.M();
        } else {
            ou1Var = this.H;
        }
        if (ou1Var != null && TextUtils.equals(ou1Var.g, "0") && ou1Var.c > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.du1
    @Nullable
    /* renamed from: i1 */
    public SwanAppWebViewWidget k() {
        return this.y;
    }

    @Override // com.baidu.tieba.du1
    public String j0() {
        return this.G;
    }

    public void j1() {
        this.I.c();
    }

    public final void l1() {
        this.w = ge2.a();
    }

    @Override // com.baidu.tieba.du1
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void onJSLoaded() {
        re2.U().w0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void onPause() {
        super.onPause();
        this.I.d();
        er2.J().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (x73.M() != null) {
            x73.M().P().y(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void onResume() {
        super.onResume();
        this.I.e();
        er2.J().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (x73.M() != null) {
            x73.M().P().y(true);
        }
        q1();
    }

    public final void q1() {
        NgWebView ngWebView;
        if (tx2.e() || tx2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.s() != null) {
            ngWebView = this.y.s();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(tx2.a(tx2.b()));
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.I = new de2(this);
        this.L = new ke2();
    }

    @Override // com.baidu.tieba.du1
    public void K(oe2 oe2Var) {
        if (oe2Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + oe2Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(q62.a("appjs", oe2Var.a));
    }

    @Override // com.baidu.tieba.du1
    public void R(String str) {
        this.x = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        super.U0(dVar);
        dVar.a = true;
    }

    @Override // com.baidu.tieba.du1
    public void Y(l92 l92Var) {
        this.E = l92Var;
    }

    @Override // com.baidu.tieba.du1
    public void Z(m92 m92Var) {
        this.C = m92Var;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.attachActivity(activity);
        }
    }

    @Override // com.baidu.tieba.du1
    public void h(xx2 xx2Var) {
        this.I.h(xx2Var);
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.b.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.fu1
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (x42.f()) {
            s62.b();
        }
    }

    public void p1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a());
    }

    @Override // com.baidu.tieba.du1
    public boolean r(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i);
    }

    public void r1(l92 l92Var) {
        this.F = l92Var;
    }

    @Override // com.baidu.tieba.du1
    public void x(String str) {
        this.G = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.x(str);
        }
    }

    @Override // com.baidu.tieba.du1
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

    @Override // com.baidu.tieba.du1
    public void z(FrameLayout frameLayout, m83 m83Var) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(m83Var.e);
    }

    @Override // com.baidu.tieba.du1
    public void C(int i) {
        boolean z;
        s().setVisibility(i);
        ln3 ln3Var = this.A;
        if (ln3Var != null) {
            ln3Var.h(i);
        }
        if (h0() != null) {
            h0().setVisibility(i);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.s() != null) {
            vb3 params = this.y.getParams();
            int i2 = 0;
            if (i == 0 && params != null && !params.f) {
                z = true;
            } else {
                z = false;
            }
            NgWebView s = this.y.s();
            if (!z) {
                i2 = 8;
            }
            s.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.du1
    public boolean X(vb3 vb3Var) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null) {
            m92 m92Var = this.C;
            if (m92Var != null) {
                m92Var.b(swanAppWebViewWidget);
            }
            if (this.E != null) {
                this.E = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            o1(this.D, this.y.s());
            this.y.S1(vb3Var);
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
        this.b.getCurrentWebView().addZeusPluginFactory(new ep2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new wl2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new so2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new dp2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new hm2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new nm2(a2));
        this.b.getCurrentWebView().addZeusPluginFactory(new mm2(a2));
    }

    @Override // com.baidu.tieba.du1
    public void O(FrameLayout frameLayout, m83 m83Var) {
        if (frameLayout == null) {
            return;
        }
        if (m83Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            r(SwanAppConfigData.t(m83Var.d));
            p1(this.z);
            j(frameLayout, this.z);
        } else {
            j(frameLayout, s());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new ln3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new n42(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.tieba.du1
    public boolean W(vb3 vb3Var) {
        int i = 0;
        if (this.y == null) {
            return false;
        }
        if (!TextUtils.isEmpty(vb3Var.k)) {
            this.y.b1(vb3Var.k);
        }
        this.y.Q1(vb3Var.m);
        this.y.loadUrl(vb3Var.j);
        this.y.S1(vb3Var);
        if (vb3Var.h == null) {
            vb3Var.h = dy2.a();
        }
        if (this.y.s() != null) {
            NgWebView s = this.y.s();
            if (vb3Var.f) {
                i = 8;
            }
            s.setVisibility(i);
        }
        l92 l92Var = this.E;
        if (l92Var != null) {
            this.y.Y(l92Var);
        }
        l92 l92Var2 = this.F;
        if (l92Var2 != null) {
            this.y.r1(l92Var2);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.du1
    public boolean y(vb3 vb3Var) {
        int i = 0;
        if (vb3Var != null && this.D != null) {
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
                if (!TextUtils.isEmpty(vb3Var.k)) {
                    this.y.b1(vb3Var.k);
                }
                if (vb3Var.h == null) {
                    vb3Var.h = dy2.a();
                }
                j(this.D, this.y.s());
                if (this.y.s() != null) {
                    NgWebView s = this.y.s();
                    if (vb3Var.f) {
                        i = 8;
                    }
                    s.setVisibility(i);
                    q1();
                }
                this.y.Q1(vb3Var.m);
                this.y.loadUrl(vb3Var.j);
                this.y.S1(vb3Var);
                m92 m92Var = this.C;
                if (m92Var != null) {
                    m92Var.a(this.y);
                }
                l92 l92Var = this.E;
                if (l92Var != null) {
                    this.y.Y(l92Var);
                }
                l92 l92Var2 = this.F;
                if (l92Var2 != null) {
                    this.y.r1(l92Var2);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
