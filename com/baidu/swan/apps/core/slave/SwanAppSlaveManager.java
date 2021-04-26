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
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.webkit.sdk.WebViewClient;
import d.a.h0.a.c0.c;
import d.a.h0.a.e0.i.a;
import d.a.h0.a.e0.n.d;
import d.a.h0.a.e0.n.e;
import d.a.h0.a.i2.p;
import d.a.h0.a.i2.w;
import d.a.h0.a.j1.i;
import d.a.h0.a.j1.l.f;
import d.a.h0.a.k;
import d.a.h0.a.p.d.b;
import d.a.h0.a.t1.k.l;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements b<NgWebView> {
    public static final boolean M = k.f43101a;
    public static int N = 10;
    public String A;
    public String B;
    public SwanAppWebViewWidget C;
    public PullToRefreshNgWebView D;
    public d.a.h0.a.j2.i.a E;
    @Nullable
    public d.a.h0.a.a0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public d.a.h0.a.p.d.j.d L;

    /* loaded from: classes2.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f11688e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f11689f;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.f11688e = j;
                this.f11689f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (i.f42928b) {
                    if (SwanAppSlaveManager.M) {
                        Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                    }
                    SwanAppSlaveManager.this.d1(true);
                    return;
                }
                if (SwanAppSlaveManager.this.L.f43522c <= 0) {
                    j = this.f11688e;
                } else {
                    j = SwanAppSlaveManager.this.L.f43522c;
                }
                this.f11689f.y("fmp_type", SwanAppSlaveManager.this.L.f43526g);
                HybridUbcFlow hybridUbcFlow = this.f11689f;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.A(ubcFlowEvent);
                hybridUbcFlow.x();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.L.f43526g + " , fmpTypeName=" + SwanAppSlaveManager.this.L.a());
                }
            }
        }

        public SwanAppSlaveWebviewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.L.f43521b = currentTimeMillis;
            f.h().l().a(SwanAppSlaveManager.this.L.f43521b);
            long b2 = i.f42928b ? currentTimeMillis : SwanAppSlaveManager.this.L.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=" + i.f42928b);
            }
            HybridUbcFlow o = i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b2);
            o.A(ubcFlowEvent);
            if (SwanAppSlaveManager.this.L.f43522c == 0) {
                SwanAppSlaveManager.this.L.f43522c = b2;
                d.a.h0.a.p.d.j.d dVar = SwanAppSlaveManager.this.L;
                dVar.f43526g = dVar.c(b2);
                o.y("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.L.f43521b);
                o.A(ubcFlowEvent2);
            }
            long K = d.a.h0.a.w0.a.N().K();
            if (K < 0) {
                K = 3000;
            }
            p.c(new a(b2, o), "fmp record", K, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f43524e = System.currentTimeMillis();
            f.h().l().f(SwanAppSlaveManager.this.L.f43524e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.L.f43524e);
            }
            if (i.f42928b) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.d1(false);
            } else if (SwanAppSlaveManager.this.L.f43522c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f43524e);
                o.A(ubcFlowEvent);
            }
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
            SwanAppSlaveManager.this.L.f43520a = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f43522c = System.currentTimeMillis();
            SwanAppSlaveManager.this.L.f43526g = "0";
            f.h().l().d(SwanAppSlaveManager.this.L.f43522c);
            d.a.h0.a.e0.f.e(SwanAppSlaveManager.this.L.f43522c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.L.f43522c);
            }
            HybridUbcFlow d2 = i.d("startup");
            if (d2 != null) {
                d2.y("webviewComponent", "1");
                d2.y("fmp_type", "0");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f43522c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d2.A(ubcFlowEvent);
                d2.x();
                d2.z("value", "arrive_success");
                d.a.h0.a.p.d.j.d dVar = SwanAppSlaveManager.this.L;
                c.a("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.L.f43522c), " , fmpType=", dVar.f43526g, " , fmpTypeName=", dVar.a());
                i.s();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.f12196e = SearchFlowEvent.EventType.END;
            d.a.h0.a.z1.l.b.a(searchFlowEvent);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f43523d = System.currentTimeMillis();
            f.h().l().e(SwanAppSlaveManager.this.L.f43523d);
            d.a.h0.a.e0.f.f(SwanAppSlaveManager.this.L.f43523d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.L.f43523d);
            }
            if (i.f42928b) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.d1(false);
            } else if (SwanAppSlaveManager.this.L.f43522c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f43523d);
                o.A(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
            }
            super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
            }
            super.onPageBackOrForwardExt(bdSailorWebView, i2);
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

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            d.a.h0.a.z0.f.V().o(SwanAppSlaveManager.this.c(), new d.a.h0.a.k0.b.b("PullDownRefresh"));
        }
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    @Override // d.a.h0.a.p.c.o0
    public double A() {
        return 1.0d;
    }

    @Override // d.a.h0.a.p.d.b
    public void F(int i2) {
        s().setVisibility(i2);
        d.a.h0.a.j2.i.a aVar = this.E;
        if (aVar != null) {
            aVar.h(i2);
        }
        if (f0() != null) {
            f0().setVisibility(i2);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget == null || swanAppWebViewWidget.s() == null) {
            return;
        }
        d.a.h0.a.t1.k.r0.d params = this.C.getParams();
        this.C.s().setVisibility(i2 == 0 && params != null && !params.j ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void F0() {
        String c2 = c();
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.k.d(c2));
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.e.b(c2));
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.i.b(c2));
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.k.c(c2));
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.f.c(c2));
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.g.d(c2));
        this.f11657f.getCurrentWebView().addZeusPluginFactory(new d.a.h0.a.s0.g.c(c2));
    }

    @Override // d.a.h0.a.p.d.b
    public boolean I() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget == null || !swanAppWebViewWidget.s().canGoBack()) {
            return false;
        }
        this.C.s().goBack();
        return true;
    }

    @Override // d.a.h0.a.p.d.b
    public boolean J() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // d.a.h0.a.p.d.b
    public void K(d.a.h0.a.e0.w.b bVar) {
        if (bVar != null && a.b.h(0)) {
            if (M) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.f42345a);
            }
            this.f11657f.getSettings().setCodeCacheSetting(d.a.h0.a.e0.i.b.a("appjs", bVar.f42345a));
        }
    }

    @Override // d.a.h0.a.p.d.b
    public d.a.h0.a.p.d.j.d M() {
        return this.L;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void M0() {
        super.M0();
    }

    @Override // d.a.h0.a.p.d.b
    public void O(FrameLayout frameLayout, d.a.h0.a.r1.n.c cVar) {
        if (frameLayout == null) {
            return;
        }
        if (cVar.f43861f) {
            this.D = new PullToRefreshNgWebView(this.f11656e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            r(SwanAppConfigData.s(cVar.f43859d));
            f1(this.D);
            k(frameLayout, this.D);
        } else {
            k(frameLayout, s());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new d.a.h0.a.j2.i.a(this.f11656e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new d.a.h0.a.a0.e.a(this.f11656e.getBaseContext(), this.E);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0(SwanAppWebViewManager.d dVar) {
        super.O0(dVar);
        dVar.f11685a = true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
        super.P0();
        b1();
        l lVar = new l(this.l);
        lVar.j(this);
        this.l.b(lVar);
        this.L = new d.a.h0.a.p.d.j.d();
        T0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // d.a.h0.a.p.d.b
    public void R() {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        if (activity == null) {
            return;
        }
        w.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // d.a.h0.a.p.d.b
    public boolean V(d.a.h0.a.t1.k.r0.d dVar) {
        if (this.C != null) {
            if (!TextUtils.isEmpty(dVar.o)) {
                this.C.V0(dVar.o);
            }
            this.C.D1(dVar.q);
            this.C.loadUrl(dVar.n);
            this.C.E1(dVar);
            if (dVar.l == null) {
                dVar.l = d.a.h0.a.e1.d.a.a.b();
            }
            if (this.C.s() != null) {
                this.C.s().setVisibility(dVar.j ? 8 : 0);
            }
            d dVar2 = this.I;
            if (dVar2 != null) {
                this.C.X(dVar2);
            }
            d dVar3 = this.J;
            if (dVar3 != null) {
                this.C.h1(dVar3);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // d.a.h0.a.p.d.b
    public boolean W(d.a.h0.a.t1.k.r0.d dVar) {
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
            e1(this.H, this.C.s());
            this.C.E1(dVar);
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

    @Override // d.a.h0.a.p.d.b
    public void X(d dVar) {
        this.I = dVar;
    }

    @Override // d.a.h0.a.p.d.b
    public void Y(e eVar) {
        this.G = eVar;
    }

    @Override // d.a.h0.a.p.d.b
    public String Z() {
        return this.B;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.p.d.b
    @Nullable
    /* renamed from: Z0 */
    public SwanAppWebViewWidget l() {
        return this.C;
    }

    @Override // d.a.h0.a.p.d.b
    public boolean a() {
        return s().getParent() != null;
    }

    public final boolean a1(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (viewGroup.getChildAt(i2) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.h0.a.p.d.b
    @Nullable
    public d.a.h0.a.a0.e.a b0() {
        return this.F;
    }

    public final void b1() {
        this.A = String.valueOf(N);
        N++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public String c() {
        return this.A;
    }

    @NonNull
    public SwanAppWebViewWidget c1() {
        return new SwanAppWebViewWidget(this.f11656e.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void d0() {
        d.a.h0.a.b1.b.d(this.A);
        d.a.h0.a.s0.g.e.a().c(this.A);
    }

    public final void d1(boolean z) {
        if (M) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.L.toString());
        }
        this.L.d();
        long j = this.L.f43522c;
        String str = this.L.f43526g;
        if (M) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.L.toString());
        }
        if (M && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.L.toString());
        }
        HybridUbcFlow o = i.o("startup");
        o.y("fmp_type", str);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
        ubcFlowEvent.h(j);
        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
        o.A(ubcFlowEvent);
        o.z("value", "arrive_success");
        if (M) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.L.a());
        }
        if (z) {
            if (M) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.L.a());
            }
            o.x();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void destroy() {
        W(null);
        R();
        super.destroy();
        d.a.h0.a.w0.a.x().i(this);
        d.a.h0.a.j2.i.a aVar = this.E;
        if (aVar != null) {
            aVar.f();
        }
        d.a.h0.a.a0.e.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void e(Activity activity) {
        super.e(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.e(activity);
        }
    }

    public final void e1(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || !a1(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // d.a.h0.a.p.d.b
    public PullToRefreshBaseWebView f0() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    public void f1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a());
    }

    public final void g1() {
        NgWebView ngWebView;
        if (d.a.h0.a.c1.c.b.d() || d.a.h0.a.c1.c.b.e()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.s() != null) {
            ngWebView = this.C.s();
        } else {
            ngWebView = this.f11657f;
        }
        ngWebView.getSettings().setTextZoom(d.a.h0.a.c1.c.b.a(d.a.h0.a.c1.c.b.b()));
    }

    public void h1(d dVar) {
        this.J = dVar;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.f11657f.isSlidable(motionEvent);
    }

    @Override // d.a.h0.a.p.d.b
    public void k(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || a1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (c.d()) {
            d.a.h0.a.e0.j.b.b();
        }
    }

    @Override // d.a.h0.a.p.d.b
    public void n(String str) {
        this.B = str;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void onJSLoaded() {
        d.a.h0.a.e0.w.d.L().g0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void onPause() {
        super.onPause();
        d.a.h0.a.w0.a.x().f(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (d.a.h0.a.r1.e.h() != null) {
            d.a.h0.a.r1.e.h().C().x(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void onResume() {
        super.onResume();
        d.a.h0.a.w0.a.x().d(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (d.a.h0.a.r1.e.h() != null) {
            d.a.h0.a.r1.e.h().C().x(true);
        }
        g1();
    }

    @Override // d.a.h0.a.p.d.b
    public boolean r(int i2) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i2);
    }

    @Override // d.a.h0.a.p.d.b
    public void v(String str) {
        this.K = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.v(str);
        }
    }

    @Override // d.a.h0.a.p.d.b
    public boolean w(d.a.h0.a.t1.k.r0.d dVar) {
        if (dVar != null && this.H != null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.w(false);
                this.D.setPullRefreshEnabled(false);
            }
            if (this.C == null) {
                if (M && !(this.f11656e.getBaseContext() instanceof Activity)) {
                    Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                }
                SwanAppWebViewWidget c1 = c1();
                this.C = c1;
                c1.v(this.K);
                this.C.F1(this.A);
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.V0(dVar.o);
                }
                if (dVar.l == null) {
                    dVar.l = d.a.h0.a.e1.d.a.a.b();
                }
                k(this.H, this.C.s());
                if (this.C.s() != null) {
                    this.C.s().setVisibility(dVar.j ? 8 : 0);
                    g1();
                }
                this.C.D1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.E1(dVar);
                e eVar = this.G;
                if (eVar != null) {
                    eVar.a(this.C);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.X(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.h1(dVar3);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // d.a.h0.a.p.d.b
    public void z(FrameLayout frameLayout, d.a.h0.a.r1.n.c cVar) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(cVar.f43860e);
    }
}
