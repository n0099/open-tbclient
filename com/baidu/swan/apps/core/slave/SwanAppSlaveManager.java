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
import com.baidu.webkit.sdk.WebViewClient;
import d.a.l0.a.a2.n.g;
import d.a.l0.a.h0.i.i;
import d.a.l0.a.h0.j.d;
import d.a.l0.a.h0.j.e;
import d.a.l0.a.k;
import d.a.l0.a.p.e.b;
import d.a.l0.a.r1.h;
import d.a.l0.a.r1.k.f;
import d.a.l0.a.t.a;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.x;
import d.a.l0.a.y0.k.c;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements b<NgWebView> {
    public static final boolean N = k.f46875a;
    public static int O = 10;
    public static a.f P;
    public String A;
    public String B;
    public SwanAppWebViewWidget C;
    public PullToRefreshNgWebView D;
    public d.a.l0.a.w2.k.a E;
    @Nullable
    public d.a.l0.a.c0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public d.a.l0.a.p.e.j.d L;
    public d.a.l0.a.h0.t.b M;

    /* loaded from: classes3.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f10808e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f10809f;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.f10808e = j;
                this.f10809f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (h.f48113b) {
                    if (SwanAppSlaveManager.N) {
                        Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                    }
                    SwanAppSlaveManager.this.l1(true);
                    return;
                }
                if (SwanAppSlaveManager.this.L.f47676c <= 0) {
                    j = this.f10808e;
                } else {
                    j = SwanAppSlaveManager.this.L.f47676c;
                }
                this.f10809f.A("fmp_type", SwanAppSlaveManager.this.L.f47680g);
                HybridUbcFlow hybridUbcFlow = this.f10809f;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.C(ubcFlowEvent);
                hybridUbcFlow.z(SwanAppSlaveManager.this);
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.L.f47680g + " , fmpTypeName=" + SwanAppSlaveManager.this.L.a());
                }
            }
        }

        public SwanAppSlaveWebviewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.l0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.L.f47675b = currentTimeMillis;
            f.j().n().a(SwanAppSlaveManager.this.L.f47675b);
            i.l(SwanAppSlaveManager.this.L.f47675b);
            long b2 = h.f48113b ? currentTimeMillis : SwanAppSlaveManager.this.L.b();
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=" + h.f48113b);
            }
            HybridUbcFlow p = h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b2);
            p.C(ubcFlowEvent);
            if (SwanAppSlaveManager.P != null) {
                SwanAppSlaveManager.P.a();
            }
            d.a.l0.a.u.f.a.d().f();
            SwanAppSlaveManager.this.M.a();
            if (SwanAppSlaveManager.this.L.f47676c == 0) {
                SwanAppSlaveManager.this.L.f47676c = b2;
                d.a.l0.a.p.e.j.d dVar = SwanAppSlaveManager.this.L;
                dVar.f47680g = dVar.c(b2);
                p.A("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.L.f47675b);
                p.C(ubcFlowEvent2);
                if (h.f48114c) {
                    return;
                }
            }
            long I = d.a.l0.a.c1.a.Z().I();
            if (I < 0) {
                I = 3000;
            }
            q.c(new a(b2, p), "fmp record", I, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.l0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f47678e = System.currentTimeMillis();
            f.j().n().g(SwanAppSlaveManager.this.L.f47678e);
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.L.f47678e);
            }
            if (h.f48113b) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.l1(false);
            } else if (SwanAppSlaveManager.this.L.f47676c == 0) {
                HybridUbcFlow p = h.p("startup");
                p.A("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f47678e);
                p.C(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstPaintDidEx");
            }
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f47674a = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.l0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f47676c = System.currentTimeMillis();
            SwanAppSlaveManager.this.L.f47680g = "0";
            f.j().n().e(SwanAppSlaveManager.this.L.f47676c);
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.L.f47676c);
            }
            HybridUbcFlow d2 = h.d("startup");
            if (d2 != null) {
                d2.A("webviewComponent", "1");
                d2.A("fmp_type", "0");
                d2.B("value", "arrive_success");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f47676c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d2.C(ubcFlowEvent);
                d2.z(SwanAppSlaveManager.this);
                d.a.l0.a.p.e.j.d dVar = SwanAppSlaveManager.this.L;
                d.a.l0.a.e0.d.a("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.L.f47676c), " , fmpType=", dVar.f47680g, " , fmpTypeName=", dVar.a());
                h.t();
            }
            d.a.l0.a.u.f.a.d().g();
            SwanAppSlaveManager.this.M.g();
            SwanAppSlaveManager.this.M.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.l0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f47677d = System.currentTimeMillis();
            f.j().n().f(SwanAppSlaveManager.this.L.f47677d);
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.L.f47677d);
            }
            if (h.f48113b) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.l1(false);
            } else if (SwanAppSlaveManager.this.L.f47676c == 0) {
                HybridUbcFlow p = h.p("startup");
                p.A("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f47677d);
                p.C(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
            }
            super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
            }
            super.onPageBackOrForwardExt(bdSailorWebView, i2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPageCanBeScaledEx");
            }
            super.onPageCanBeScaledExt(bdSailorWebView, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            super.onPreloadUrlFoundExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onSecurityCheckResultEx");
            }
            super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onUrlRedirected");
            }
            super.onUrlRedirectedExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppSlaveManager.N) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::canHandleImageEx");
            }
            return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
        }

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            d.a.l0.a.g1.f.V().m(SwanAppSlaveManager.this.b(), new d.a.l0.a.o0.d.b("PullDownRefresh"));
        }
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.M = new d.a.l0.a.h0.t.b(this);
    }

    public static void m1(a.f fVar) {
        P = fVar;
    }

    @Override // d.a.l0.a.p.e.b
    public void B(FrameLayout frameLayout, g gVar) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(gVar.f44472e);
    }

    @Override // d.a.l0.a.p.d.z0
    public double F() {
        return 1.0d;
    }

    @Override // d.a.l0.a.p.e.b
    public void G(int i2) {
        u().setVisibility(i2);
        d.a.l0.a.w2.k.a aVar = this.E;
        if (aVar != null) {
            aVar.h(i2);
        }
        if (h0() != null) {
            h0().setVisibility(i2);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget == null || swanAppWebViewWidget.u() == null) {
            return;
        }
        d.a.l0.a.c2.f.r0.d params = this.C.getParams();
        this.C.u().setVisibility(i2 == 0 && params != null && !params.j ? 0 : 8);
    }

    @Override // d.a.l0.a.p.e.b
    public boolean K() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget == null || !swanAppWebViewWidget.u().canGoBack()) {
            return false;
        }
        this.C.u().goBack();
        return true;
    }

    @Override // d.a.l0.a.p.e.b
    public boolean L() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        String b2 = b();
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new d.a.l0.a.y0.k.d(b2));
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new d.a.l0.a.y0.e.b(b2));
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new d.a.l0.a.y0.i.b(b2));
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new c(b2));
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new d.a.l0.a.y0.f.c(b2));
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new d.a.l0.a.y0.g.d(b2));
        this.f10766f.getCurrentWebView().addZeusPluginFactory(new d.a.l0.a.y0.g.c(b2));
    }

    @Override // d.a.l0.a.p.e.b
    public void M(d.a.l0.a.h0.u.d dVar) {
        if (dVar == null) {
            return;
        }
        if (N) {
            Log.d("SwanAppSlaveManager", "pathList item: " + dVar.f46288a);
        }
        this.f10766f.getSettings().setCodeCacheSetting(d.a.l0.a.h0.d.b.a("appjs", dVar.f46288a));
    }

    @Override // d.a.l0.a.p.e.b
    public d.a.l0.a.p.e.j.d O() {
        return this.L;
    }

    @Override // d.a.l0.a.p.e.b
    public void Q(FrameLayout frameLayout, g gVar) {
        if (frameLayout == null) {
            return;
        }
        if (gVar.f44473f) {
            this.D = new PullToRefreshNgWebView(this.f10765e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            t(SwanAppConfigData.s(gVar.f44471d));
            o1(this.D);
            l(frameLayout, this.D);
        } else {
            l(frameLayout, u());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new d.a.l0.a.w2.k.a(this.f10765e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new d.a.l0.a.c0.e.a(this.f10765e.getBaseContext(), this.E);
        }
    }

    @Override // d.a.l0.a.p.e.b
    public void S(String str) {
        this.B = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        super.S0();
    }

    @Override // d.a.l0.a.p.e.b
    public void U() {
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null) {
            return;
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.e eVar) {
        super.U0(eVar);
        eVar.f10797a = true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        super.V0();
        j1();
        d.a.l0.a.c2.f.k kVar = new d.a.l0.a.c2.f.k(this.l);
        kVar.j(this);
        this.l.b(kVar);
        this.L = new d.a.l0.a.p.e.j.d();
        Z0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // d.a.l0.a.p.e.b
    public boolean X(d.a.l0.a.c2.f.r0.d dVar) {
        if (this.C != null) {
            if (!TextUtils.isEmpty(dVar.o)) {
                this.C.b1(dVar.o);
            }
            this.C.N1(dVar.q);
            this.C.loadUrl(dVar.n);
            this.C.P1(dVar);
            if (dVar.l == null) {
                dVar.l = d.a.l0.a.l1.e.a.a.b();
            }
            if (this.C.u() != null) {
                this.C.u().setVisibility(dVar.j ? 8 : 0);
            }
            d dVar2 = this.I;
            if (dVar2 != null) {
                this.C.Z(dVar2);
            }
            d dVar3 = this.J;
            if (dVar3 != null) {
                this.C.q1(dVar3);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // d.a.l0.a.p.e.b
    public boolean Y(d.a.l0.a.c2.f.r0.d dVar) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            e eVar = this.G;
            if (eVar != null) {
                eVar.b(swanAppWebViewWidget);
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.J != null) {
                this.J = null;
            }
            n1(this.H, this.C.u());
            this.C.P1(dVar);
            this.C.destroy();
            this.C = null;
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.setPullRefreshEnabled(true);
            }
            return true;
        }
        return false;
    }

    @Override // d.a.l0.a.p.e.b
    public void Z(d dVar) {
        this.I = dVar;
    }

    @Override // d.a.l0.a.p.e.b
    public void a0(e eVar) {
        this.G = eVar;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public String b() {
        return this.A;
    }

    @Override // d.a.l0.a.p.e.b
    public boolean d() {
        return u().getParent() != null;
    }

    @Override // d.a.l0.a.p.e.b
    @Nullable
    public d.a.l0.a.c0.e.a d0() {
        return this.F;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void destroy() {
        Y(null);
        U();
        super.destroy();
        d.a.l0.a.c1.a.F().i(this);
        d.a.l0.a.w2.k.a aVar = this.E;
        if (aVar != null) {
            aVar.f();
        }
        d.a.l0.a.c0.e.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void e(Activity activity) {
        super.e(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.e(activity);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void f0() {
        d.a.l0.a.i1.b.d(this.A);
        d.a.l0.a.y0.g.e.a().c(this.A);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.p.e.b
    @Nullable
    /* renamed from: g1 */
    public SwanAppWebViewWidget m() {
        return this.C;
    }

    @Override // d.a.l0.a.p.e.b
    public PullToRefreshBaseWebView h0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    public void h1() {
        this.M.c();
    }

    @Override // d.a.l0.a.p.e.b
    public void i(d.a.l0.a.l1.b bVar) {
        this.M.h(bVar);
    }

    @Override // d.a.l0.a.p.e.b
    public boolean i0() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        d.a.l0.a.p.e.j.d O2 = swanAppWebViewWidget != null ? swanAppWebViewWidget.O() : this.L;
        return O2 != null && TextUtils.equals(O2.f47680g, "0") && O2.f47676c > 0;
    }

    public final boolean i1(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (viewGroup.getChildAt(i2) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.f10766f.isSlidable(motionEvent);
    }

    @Override // d.a.l0.a.p.e.b
    public String j0() {
        return this.K;
    }

    public final void j1() {
        this.A = String.valueOf(O);
        O++;
    }

    @NonNull
    public SwanAppWebViewWidget k1() {
        return new SwanAppWebViewWidget(this.f10765e.getBaseContext());
    }

    @Override // d.a.l0.a.p.e.b
    public void l(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || i1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void l1(boolean z) {
        if (N) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.L.toString());
        }
        this.L.d();
        long j = this.L.f47676c;
        String str = this.L.f47680g;
        if (N) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.L.toString());
        }
        if (N && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.L.toString());
        }
        HybridUbcFlow p = h.p("startup");
        p.A("fmp_type", str);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
        ubcFlowEvent.h(j);
        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
        p.C(ubcFlowEvent);
        p.B("value", "arrive_success");
        if (N) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.L.a());
        }
        if (z) {
            if (N) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.L.a());
            }
            p.z(this);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (d.a.l0.a.e0.d.d()) {
            d.a.l0.a.h0.e.b.b();
        }
    }

    public final void n1(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || !i1(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // d.a.l0.a.p.e.b
    public String o() {
        return this.B;
    }

    public void o1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void onJSLoaded() {
        d.a.l0.a.h0.u.g.N().m0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void onPause() {
        super.onPause();
        this.M.d();
        d.a.l0.a.c1.a.F().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (d.a.l0.a.a2.e.i() != null) {
            d.a.l0.a.a2.e.i().E().y(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.l0.a.p.e.d
    public void onResume() {
        super.onResume();
        this.M.e();
        d.a.l0.a.c1.a.F().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (d.a.l0.a.a2.e.i() != null) {
            d.a.l0.a.a2.e.i().E().y(true);
        }
        p1();
    }

    public final void p1() {
        NgWebView ngWebView;
        if (d.a.l0.a.j1.e.b.d() || d.a.l0.a.j1.e.b.e()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.u() != null) {
            ngWebView = this.C.u();
        } else {
            ngWebView = this.f10766f;
        }
        ngWebView.getSettings().setTextZoom(d.a.l0.a.j1.e.b.a(d.a.l0.a.j1.e.b.b()));
    }

    public void q1(d dVar) {
        this.J = dVar;
    }

    @Override // d.a.l0.a.p.e.b
    public boolean t(int i2) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i2);
    }

    @Override // d.a.l0.a.p.e.b
    public void x(String str) {
        this.K = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.x(str);
        }
    }

    @Override // d.a.l0.a.p.e.b
    public boolean y(d.a.l0.a.c2.f.r0.d dVar) {
        if (dVar != null && this.H != null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.w(false);
                this.D.setPullRefreshEnabled(false);
            }
            if (this.C == null) {
                if (N && !(this.f10765e.getBaseContext() instanceof Activity)) {
                    Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                }
                SwanAppWebViewWidget k1 = k1();
                this.C = k1;
                k1.x(this.K);
                this.C.O1(this);
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.b1(dVar.o);
                }
                if (dVar.l == null) {
                    dVar.l = d.a.l0.a.l1.e.a.a.b();
                }
                l(this.H, this.C.u());
                if (this.C.u() != null) {
                    this.C.u().setVisibility(dVar.j ? 8 : 0);
                    p1();
                }
                this.C.N1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.P1(dVar);
                e eVar = this.G;
                if (eVar != null) {
                    eVar.a(this.C);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.Z(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.q1(dVar3);
                    return true;
                }
                return true;
            }
        }
        return false;
    }
}
