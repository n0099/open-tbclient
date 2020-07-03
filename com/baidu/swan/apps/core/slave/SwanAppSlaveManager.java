package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshNgWebView;
import com.baidu.swan.apps.core.f.d;
import com.baidu.swan.apps.core.f.e;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.l;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.w.f;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cex = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bUj;
    private FrameLayout caj;
    protected PullToRefreshNgWebView ceA;
    private com.baidu.swan.apps.view.narootview.a ceB;
    private e ceC;
    private d ceD;
    protected String ceE;
    protected com.baidu.swan.apps.adaptation.b.a.d ceF;
    private String cey;
    private SwanAppWebViewWidget cez;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bYH = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Yt() {
        super.Yt();
        acc();
        l lVar = new l(this.bYv);
        lVar.f(this);
        this.bYv.a(lVar);
        this.ceF = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Yq() {
        this.bYq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.e.d(Up()));
        this.bYq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.a.b(Up()));
        this.bYq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.c.b(Up()));
        this.bYq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.e.c(Up()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.agi().c(this);
        if (this.cez != null) {
            this.cez.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.apM() != null) {
            com.baidu.swan.apps.runtime.e.apM().aqd().ej(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.agi().d(this);
        if (this.cez != null) {
            this.cez.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.apM() != null) {
            com.baidu.swan.apps.runtime.e.apM().aqd().ej(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cez != null ? this.cez.isSlidable(motionEvent) : this.bYq.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ai
    public double Ua() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.WX()) {
            com.baidu.swan.apps.core.c.b.YO();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Un().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Ul() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Uf() {
        return Un().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.cFQ) {
                this.ceA = new PullToRefreshNgWebView(this.bYp.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                eu(SwanAppConfigData.dV(cVar.cFP));
                a(this.ceA);
                a(frameLayout, this.ceA);
            } else {
                a(frameLayout, Un());
            }
            this.caj = frameLayout;
            if (this.ceB == null) {
                this.ceB = new com.baidu.swan.apps.view.narootview.a(this.bYp.getBaseContext(), this, frameLayout);
            }
            if (this.bUj == null) {
                this.bUj = new com.baidu.swan.apps.component.c.a(this.bYp.getBaseContext(), this.ceB);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void b(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(cVar.backgroundColor);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean eu(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.ceA != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.ceA.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.eu(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.er(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.bYq.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.aY("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.ceA.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.ajb().a(SwanAppSlaveManager.this.Up(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView Ug() {
        if (this.ceA == null) {
            return null;
        }
        return this.ceA;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !b(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void c(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && b(viewGroup, view)) {
            viewGroup.removeView(view);
        }
    }

    private boolean b(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    private void acc() {
        this.cey = String.valueOf(cex);
        cex++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Up() {
        return this.cey;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cez != null) {
            this.cez.attachActivity(activity);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.caj == null) {
            return false;
        }
        if (this.ceA != null) {
            this.ceA.eP(false);
            this.ceA.setPullRefreshEnabled(false);
        }
        if (this.cez == null) {
            if (DEBUG && !(this.bYp.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cez = acd();
            this.cez.hh(this.ceE);
            this.cez.jU(this.cey);
            if (dVar.bUx == null) {
                dVar.bUx = com.baidu.swan.apps.model.a.a.a.ald();
            }
            a(this.caj, this.cez.Un());
            if (this.cez.Un() != null) {
                this.cez.Un().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.cez.loadUrl(dVar.mSrc);
            this.cez.d(dVar);
            if (this.ceC != null) {
                this.ceC.a(this.cez);
            }
            if (this.ceD != null) {
                this.cez.a(this.ceD);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget acd() {
        return new SwanAppWebViewWidget(this.bYp.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cez != null) {
            this.cez.loadUrl(dVar.mSrc);
            this.cez.d(dVar);
            if (dVar.bUx == null) {
                dVar.bUx = com.baidu.swan.apps.model.a.a.a.ald();
            }
            if (this.cez.Un() != null) {
                this.cez.Un().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cez != null) {
            if (this.ceC != null) {
                this.ceC.b(this.cez);
            }
            if (this.ceD != null) {
                this.ceD = null;
            }
            c(this.caj, this.cez.Un());
            this.cez.d(dVar);
            this.cez.destroy();
            this.cez = null;
            if (this.ceA != null) {
                this.ceA.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Ui() {
        if (this.cez == null || !this.cez.Un().canGoBack()) {
            return false;
        }
        this.cez.Un().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Uq() {
        com.baidu.swan.apps.media.b.destroy(this.cey);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        Uj();
        super.destroy();
        com.baidu.swan.apps.u.a.agi().e(this);
        if (this.ceB != null) {
            this.ceB.destroy();
        }
        if (this.bUj != null) {
            this.bUj.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void Uj() {
        SwanAppActivity aiL = f.ajb().aiL();
        if (aiL != null) {
            u.forceHiddenSoftInput(aiL, aiL.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void et(int i) {
        Un().setVisibility(i);
        if (this.ceB != null) {
            this.ceB.ic(i);
        }
        if (Ug() != null) {
            Ug().setVisibility(i);
        }
        if (this.cez != null && this.cez.Un() != null) {
            com.baidu.swan.apps.scheme.actions.m.d Ur = this.cez.Ur();
            this.cez.Un().setVisibility(i == 0 && Ur != null && !Ur.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a Uk() {
        return this.bUj;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.ceC = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.ceD = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: ace */
    public SwanAppWebViewWidget Uh() {
        return this.cez;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        private SwanAppSlaveWebviewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
            }
            super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            super.onPreloadUrlFoundExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPageCanBeScaledEx");
            }
            super.onPageCanBeScaledExt(bdSailorWebView, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstPaintDidEx");
            }
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.ceF.bME = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            HybridUbcFlow mz;
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.ceF.bMG = System.currentTimeMillis();
            SwanAppSlaveManager.this.ceF.bMK = "0";
            if (g.cwr && (mz = g.mz("startup")) != null) {
                mz.bF("fmp_type", "0");
                mz.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.ceF.bMG).a(UbcFlowEvent.RecordType.UPDATE)).aml();
                g.VO();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cLt = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
            }
            super.onPageBackOrForwardExt(bdSailorWebView, i);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::canHandleImageEx");
            }
            return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onSecurityCheckResultEx");
            }
            super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onUrlRedirected");
            }
            super.onUrlRedirectedExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.ceF.bMF = System.currentTimeMillis();
            final long Uy = SwanAppSlaveManager.this.ceF.Uy();
            final HybridUbcFlow mx = g.mx("startup");
            mx.f(new UbcFlowEvent("na_first_paint").bg(Uy));
            if (SwanAppSlaveManager.this.ceF.bMG == 0) {
                SwanAppSlaveManager.this.ceF.bMG = Uy;
                SwanAppSlaveManager.this.ceF.bMK = SwanAppSlaveManager.this.ceF.aL(Uy);
                if (g.cwr) {
                    mx.bF("fmp_type", "1");
                    mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.ceF.bMF));
                    return;
                }
            }
            long SF = com.baidu.swan.apps.u.a.aga().SF();
            if (SF < 0) {
                SF = 3000;
            }
            n.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.ceF.bMG <= 0) {
                        j = Uy;
                    } else {
                        j = SwanAppSlaveManager.this.ceF.bMG;
                    }
                    mx.bF("fmp_type", SwanAppSlaveManager.this.ceF.bMK);
                    mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(j)).aml();
                }
            }, "fmp record", SF, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            }
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.ceF.bMH = System.currentTimeMillis();
            if (SwanAppSlaveManager.this.ceF.bMG == 0 && g.cwr) {
                HybridUbcFlow mx = g.mx("startup");
                mx.bF("fmp_type", "2");
                mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.ceF.bMH));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            }
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.ceF.bMI = System.currentTimeMillis();
            if (SwanAppSlaveManager.this.ceF.bMG == 0 && g.cwr) {
                HybridUbcFlow mx = g.mx("startup");
                mx.bF("fmp_type", "3");
                mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.ceF.bMI));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.acr().dR(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hh(String str) {
        this.ceE = str;
        if (this.cez != null) {
            this.cez.hh(this.ceE);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d Um() {
        return this.ceF;
    }
}
