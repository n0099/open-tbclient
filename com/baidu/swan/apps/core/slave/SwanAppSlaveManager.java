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
import d.b.g0.a.c0.c;
import d.b.g0.a.e0.i.a;
import d.b.g0.a.e0.n.d;
import d.b.g0.a.e0.n.e;
import d.b.g0.a.i2.p;
import d.b.g0.a.i2.w;
import d.b.g0.a.j1.i;
import d.b.g0.a.j1.l.f;
import d.b.g0.a.k;
import d.b.g0.a.p.d.b;
import d.b.g0.a.t1.k.l;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements b<NgWebView> {
    public static final boolean M = k.f45050a;
    public static int N = 10;
    public String A;
    public String B;
    public SwanAppWebViewWidget C;
    public PullToRefreshNgWebView D;
    public d.b.g0.a.j2.i.a E;
    @Nullable
    public d.b.g0.a.a0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public d.b.g0.a.p.d.j.d L;

    /* loaded from: classes3.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f12183e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f12184f;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.f12183e = j;
                this.f12184f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (i.f44883b) {
                    if (SwanAppSlaveManager.M) {
                        Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                    }
                    SwanAppSlaveManager.this.c1(true);
                    return;
                }
                if (SwanAppSlaveManager.this.L.f45453c <= 0) {
                    j = this.f12183e;
                } else {
                    j = SwanAppSlaveManager.this.L.f45453c;
                }
                this.f12184f.y("fmp_type", SwanAppSlaveManager.this.L.f45457g);
                HybridUbcFlow hybridUbcFlow = this.f12184f;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.A(ubcFlowEvent);
                hybridUbcFlow.x();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.L.f45457g + " , fmpTypeName=" + SwanAppSlaveManager.this.L.a());
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
            SwanAppSlaveManager.this.L.f45452b = currentTimeMillis;
            f.h().l().a(SwanAppSlaveManager.this.L.f45452b);
            long b2 = i.f44883b ? currentTimeMillis : SwanAppSlaveManager.this.L.b();
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=" + i.f44883b);
            }
            HybridUbcFlow o = i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b2);
            o.A(ubcFlowEvent);
            if (SwanAppSlaveManager.this.L.f45453c == 0) {
                SwanAppSlaveManager.this.L.f45453c = b2;
                d.b.g0.a.p.d.j.d dVar = SwanAppSlaveManager.this.L;
                dVar.f45457g = dVar.c(b2);
                o.y("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppSlaveManager.this.L.f45452b);
                o.A(ubcFlowEvent2);
            }
            long I = d.b.g0.a.w0.a.N().I();
            if (I < 0) {
                I = 3000;
            }
            p.c(new a(b2, o), "fmp record", I, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f45455e = System.currentTimeMillis();
            f.h().l().d(SwanAppSlaveManager.this.L.f45455e);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.L.f45455e);
            }
            if (i.f44883b) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.c1(false);
            } else if (SwanAppSlaveManager.this.L.f45453c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f45455e);
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
            SwanAppSlaveManager.this.L.f45451a = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f45453c = System.currentTimeMillis();
            SwanAppSlaveManager.this.L.f45457g = "0";
            f.h().l().g(SwanAppSlaveManager.this.L.f45453c);
            d.b.g0.a.e0.f.e(SwanAppSlaveManager.this.L.f45453c);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.L.f45453c);
            }
            HybridUbcFlow d2 = i.d("startup");
            if (d2 != null) {
                d2.y("webviewComponent", "1");
                d2.y("fmp_type", "0");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f45453c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d2.A(ubcFlowEvent);
                d2.x();
                d2.z("value", "arrive_success");
                d.b.g0.a.p.d.j.d dVar = SwanAppSlaveManager.this.L;
                c.a("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.L.f45453c), " , fmpType=", dVar.f45457g, " , fmpTypeName=", dVar.a());
                i.s();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.f12654e = SearchFlowEvent.EventType.END;
            d.b.g0.a.z1.l.b.a(searchFlowEvent);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            c.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.L.f45454d = System.currentTimeMillis();
            f.h().l().c(SwanAppSlaveManager.this.L.f45454d);
            d.b.g0.a.e0.f.f(SwanAppSlaveManager.this.L.f45454d);
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.L.f45454d);
            }
            if (i.f44883b) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.c1(false);
            } else if (SwanAppSlaveManager.this.L.f45453c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppSlaveManager.this.L.f45454d);
                o.A(ubcFlowEvent);
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
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.M) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
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

    /* loaded from: classes3.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        public a() {
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            d.b.g0.a.z0.f.V().z(SwanAppSlaveManager.this.c(), new d.b.g0.a.k0.b.b("PullDownRefresh"));
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
        }
    }

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    @Override // d.b.g0.a.p.d.b
    public boolean B(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
        if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
            return false;
        }
        return neutralHeaderLoadingLayout.p(i);
    }

    @Override // d.b.g0.a.p.d.b
    public void E(FrameLayout frameLayout, d.b.g0.a.r1.n.c cVar) {
        if (frameLayout == null) {
            return;
        }
        if (cVar.f45775f) {
            this.D = new PullToRefreshNgWebView(this.f12152e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            B(SwanAppConfigData.s(cVar.f45773d));
            e1(this.D);
            m(frameLayout, this.D);
        } else {
            m(frameLayout, getWebView());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new d.b.g0.a.j2.i.a(this.f12152e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new d.b.g0.a.a0.e.a(this.f12152e.getBaseContext(), this.E);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void E0() {
        String c2 = c();
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.k.d(c2));
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.e.b(c2));
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.i.b(c2));
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.k.c(c2));
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.f.c(c2));
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.g.d(c2));
        this.f12153f.getCurrentWebView().addZeusPluginFactory(new d.b.g0.a.s0.g.c(c2));
    }

    @Override // d.b.g0.a.p.d.b
    public void I() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null) {
            return;
        }
        w.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // d.b.g0.a.p.d.b
    public boolean K(d.b.g0.a.t1.k.r0.d dVar) {
        if (this.C != null) {
            if (!TextUtils.isEmpty(dVar.o)) {
                this.C.U0(dVar.o);
            }
            this.C.C1(dVar.q);
            this.C.loadUrl(dVar.n);
            this.C.D1(dVar);
            if (dVar.l == null) {
                dVar.l = d.b.g0.a.e1.d.a.a.b();
            }
            if (this.C.getWebView() != null) {
                this.C.getWebView().setVisibility(dVar.j ? 8 : 0);
            }
            d dVar2 = this.I;
            if (dVar2 != null) {
                this.C.P(dVar2);
            }
            d dVar3 = this.J;
            if (dVar3 != null) {
                this.C.g1(dVar3);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // d.b.g0.a.p.d.b
    public boolean L(d.b.g0.a.t1.k.r0.d dVar) {
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
            d1(this.H, this.C.getWebView());
            this.C.D1(dVar);
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        super.L0();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0(SwanAppWebViewManager.d dVar) {
        super.N0(dVar);
        dVar.f12180a = true;
    }

    @Override // d.b.g0.a.p.d.b
    public void O(String str) {
        this.K = str;
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.O(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0() {
        super.O0();
        a1();
        l lVar = new l(this.l);
        lVar.j(this);
        this.l.b(lVar);
        this.L = new d.b.g0.a.p.d.j.d();
        S0(new SwanAppSlaveWebviewClientExt(this, null));
    }

    @Override // d.b.g0.a.p.d.b
    public void P(d dVar) {
        this.I = dVar;
    }

    @Override // d.b.g0.a.p.d.b
    public void Q(e eVar) {
        this.G = eVar;
    }

    @Override // d.b.g0.a.p.d.b
    public String R() {
        return this.B;
    }

    @Override // d.b.g0.a.p.d.b
    @Nullable
    public d.b.g0.a.a0.e.a T() {
        return this.F;
    }

    @Override // d.b.g0.a.p.d.b
    public boolean U(d.b.g0.a.t1.k.r0.d dVar) {
        if (dVar != null && this.H != null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView != null) {
                pullToRefreshNgWebView.w(false);
                this.D.setPullRefreshEnabled(false);
            }
            if (this.C == null) {
                if (M && !(this.f12152e.getBaseContext() instanceof Activity)) {
                    Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                }
                SwanAppWebViewWidget b1 = b1();
                this.C = b1;
                b1.O(this.K);
                this.C.E1(this.A);
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.U0(dVar.o);
                }
                if (dVar.l == null) {
                    dVar.l = d.b.g0.a.e1.d.a.a.b();
                }
                m(this.H, this.C.getWebView());
                if (this.C.getWebView() != null) {
                    this.C.getWebView().setVisibility(dVar.j ? 8 : 0);
                    f1();
                }
                this.C.C1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.D1(dVar);
                e eVar = this.G;
                if (eVar != null) {
                    eVar.a(this.C);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.P(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.g1(dVar3);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void W() {
        d.b.g0.a.b1.b.d(this.A);
        d.b.g0.a.s0.g.e.a().c(this.A);
    }

    @Override // d.b.g0.a.p.d.b
    public PullToRefreshBaseWebView Y() {
        PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
        if (pullToRefreshNgWebView == null) {
            return null;
        }
        return pullToRefreshNgWebView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.p.d.b
    @Nullable
    /* renamed from: Y0 */
    public SwanAppWebViewWidget n() {
        return this.C;
    }

    public final boolean Z0(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    @Override // d.b.g0.a.p.d.b
    public boolean a() {
        return getWebView().getParent() != null;
    }

    public final void a1() {
        this.A = String.valueOf(N);
        N++;
    }

    @Override // d.b.g0.a.p.d.b
    public void b0(FrameLayout frameLayout, d.b.g0.a.r1.n.c cVar) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(cVar.f45774e);
    }

    @NonNull
    public SwanAppWebViewWidget b1() {
        return new SwanAppWebViewWidget(this.f12152e.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public String c() {
        return this.A;
    }

    @Override // d.b.g0.a.p.c.o0
    public double c0() {
        return 1.0d;
    }

    public final void c1(boolean z) {
        if (M) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.L.toString());
        }
        this.L.d();
        long j = this.L.f45453c;
        String str = this.L.f45457g;
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void d(Activity activity) {
        super.d(activity);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.d(activity);
        }
    }

    public final void d1(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || !Z0(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void destroy() {
        L(null);
        I();
        super.destroy();
        d.b.g0.a.w0.a.x().e(this);
        d.b.g0.a.j2.i.a aVar = this.E;
        if (aVar != null) {
            aVar.f();
        }
        d.b.g0.a.a0.e.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void e1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a());
    }

    @Override // d.b.g0.a.p.d.b
    public void f0(int i) {
        getWebView().setVisibility(i);
        d.b.g0.a.j2.i.a aVar = this.E;
        if (aVar != null) {
            aVar.h(i);
        }
        if (Y() != null) {
            Y().setVisibility(i);
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget == null || swanAppWebViewWidget.getWebView() == null) {
            return;
        }
        d.b.g0.a.t1.k.r0.d params = this.C.getParams();
        this.C.getWebView().setVisibility(i == 0 && params != null && !params.j ? 0 : 8);
    }

    public final void f1() {
        NgWebView ngWebView;
        if (d.b.g0.a.c1.c.b.d() || d.b.g0.a.c1.c.b.e()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.getWebView() != null) {
            ngWebView = this.C.getWebView();
        } else {
            ngWebView = this.f12153f;
        }
        ngWebView.getSettings().setTextZoom(d.b.g0.a.c1.c.b.a(d.b.g0.a.c1.c.b.b()));
    }

    public void g1(d dVar) {
        this.J = dVar;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            return swanAppWebViewWidget.isSlidable(motionEvent);
        }
        return this.f12153f.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (c.d()) {
            d.b.g0.a.e0.j.b.b();
        }
    }

    @Override // d.b.g0.a.p.d.b
    public void m(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || Z0(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void onJSLoaded() {
        d.b.g0.a.e0.w.d.L().g0(false);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void onPause() {
        super.onPause();
        d.b.g0.a.w0.a.x().m(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onPause();
        }
        if (d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().C().x(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void onResume() {
        super.onResume();
        d.b.g0.a.w0.a.x().i(this);
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null) {
            swanAppWebViewWidget.onResume();
        }
        if (d.b.g0.a.r1.e.y() != null) {
            d.b.g0.a.r1.e.y().C().x(true);
        }
        f1();
    }

    @Override // d.b.g0.a.p.d.b
    public void s(String str) {
        this.B = str;
    }

    @Override // d.b.g0.a.p.d.b
    public boolean v() {
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget == null || !swanAppWebViewWidget.getWebView().canGoBack()) {
            return false;
        }
        this.C.getWebView().goBack();
        return true;
    }

    @Override // d.b.g0.a.p.d.b
    public boolean w() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // d.b.g0.a.p.d.b
    public void x(d.b.g0.a.e0.w.b bVar) {
        if (bVar != null && a.b.h(0)) {
            if (M) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.f44316a);
            }
            this.f12153f.getSettings().setCodeCacheSetting(d.b.g0.a.e0.i.b.a("appjs", bVar.f44316a));
        }
    }

    @Override // d.b.g0.a.p.d.b
    public d.b.g0.a.p.d.j.d z() {
        return this.L;
    }
}
