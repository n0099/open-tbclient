package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.w;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshNgWebView;
import com.baidu.swan.apps.core.f.d;
import com.baidu.swan.apps.core.f.e;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.l;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cAR = 10;
    private String cAS;
    private SwanAppWebViewWidget cAT;
    protected PullToRefreshNgWebView cAU;
    private com.baidu.swan.apps.view.narootview.a cAV;
    private e cAW;
    private d cAX;
    protected d cAY;
    protected String cAZ;
    protected com.baidu.swan.apps.adaptation.b.a.d cBa;
    @Nullable
    private com.baidu.swan.apps.component.c.a cpf;
    private FrameLayout cwk;
    private String cxS;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cun = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void aiN() {
        super.aiN();
        amV();
        l lVar = new l(this.ctZ);
        lVar.f(this);
        this.ctZ.a(lVar);
        this.cBa = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aiK() {
        String aep = aep();
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aep));
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aep));
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aep));
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aep));
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aep));
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aep));
        this.ctU.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aep));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.asr().c(this);
        if (this.cAT != null) {
            this.cAT.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aDa() != null) {
            com.baidu.swan.apps.runtime.e.aDa().aDr().fc(true);
        }
        amW();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.asr().d(this);
        if (this.cAT != null) {
            this.cAT.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aDa() != null) {
            com.baidu.swan.apps.runtime.e.aDa().aDr().fc(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cAT != null ? this.cAT.isSlidable(motionEvent) : this.ctU.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double adY() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.ahe()) {
            com.baidu.swan.apps.core.c.b.ajk();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aek() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aee() {
        return aen().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dfT) {
                this.cAU = new PullToRefreshNgWebView(this.ctT.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                ha(SwanAppConfigData.fv(cVar.dfS));
                a(this.cAU);
                a(frameLayout, this.cAU);
            } else {
                a(frameLayout, aen());
            }
            this.cwk = frameLayout;
            if (this.cAV == null) {
                this.cAV = new com.baidu.swan.apps.view.narootview.a(this.ctT.getBaseContext(), this, frameLayout);
            }
            if (this.cpf == null) {
                this.cpf = new com.baidu.swan.apps.component.c.a(this.ctT.getBaseContext(), this.cAV);
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
    public void jP(String str) {
        this.cAS = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aem() {
        return this.cAS;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ha(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cAU != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cAU.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.ha(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.gX(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.ctU.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bm("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cAU.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.avu().a(SwanAppSlaveManager.this.aep(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView aef() {
        if (this.cAU == null) {
            return null;
        }
        return this.cAU;
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

    private void amV() {
        this.cxS = String.valueOf(cAR);
        cAR++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aep() {
        return this.cxS;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cAT != null) {
            this.cAT.attachActivity(activity);
        }
    }

    private void amW() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.axz() && !com.baidu.swan.apps.menu.fontsize.b.axx()) {
            if (this.cAT != null && this.cAT.aen() != null) {
                ngWebView = this.cAT.aen();
            } else {
                ngWebView = this.ctU;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jc(com.baidu.swan.apps.menu.fontsize.b.axy()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cwk == null) {
            return false;
        }
        if (this.cAU != null) {
            this.cAU.fM(false);
            this.cAU.setPullRefreshEnabled(false);
        }
        if (this.cAT == null) {
            if (DEBUG && !(this.ctT.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cAT = amX();
            this.cAT.jO(this.cAZ);
            this.cAT.mW(this.cxS);
            if (!TextUtils.isEmpty(dVar.any)) {
                this.cAT.ma(dVar.any);
            }
            if (dVar.cpt == null) {
                dVar.cpt = com.baidu.swan.apps.model.a.a.a.axK();
            }
            a(this.cwk, this.cAT.aen());
            if (this.cAT.aen() != null) {
                this.cAT.aen().setVisibility(dVar.hidden ? 8 : 0);
                amW();
            }
            this.cAT.eB(dVar.dim);
            this.cAT.loadUrl(dVar.mSrc);
            this.cAT.d(dVar);
            if (this.cAW != null) {
                this.cAW.a(this.cAT);
            }
            if (this.cAX != null) {
                this.cAT.a(this.cAX);
            }
            if (this.cAY != null) {
                this.cAT.b(this.cAY);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget amX() {
        return new SwanAppWebViewWidget(this.ctT.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cAT != null) {
            if (!TextUtils.isEmpty(dVar.any)) {
                this.cAT.ma(dVar.any);
            }
            this.cAT.eB(dVar.dim);
            this.cAT.loadUrl(dVar.mSrc);
            this.cAT.d(dVar);
            if (dVar.cpt == null) {
                dVar.cpt = com.baidu.swan.apps.model.a.a.a.axK();
            }
            if (this.cAT.aen() != null) {
                this.cAT.aen().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cAX != null) {
                this.cAT.a(this.cAX);
            }
            if (this.cAY != null) {
                this.cAT.b(this.cAY);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cAT != null) {
            if (this.cAW != null) {
                this.cAW.b(this.cAT);
            }
            if (this.cAX != null) {
                this.cAX = null;
            }
            if (this.cAY != null) {
                this.cAY = null;
            }
            c(this.cwk, this.cAT.aen());
            this.cAT.d(dVar);
            this.cAT.destroy();
            this.cAT = null;
            if (this.cAU != null) {
                this.cAU.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aeh() {
        if (this.cAT == null || !this.cAT.aen().canGoBack()) {
            return false;
        }
        this.cAT.aen().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aeq() {
        com.baidu.swan.apps.media.b.hv(this.cxS);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.arq().nV(this.cxS);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        aei();
        super.destroy();
        com.baidu.swan.apps.t.a.asr().e(this);
        if (this.cAV != null) {
            this.cAV.destroy();
        }
        if (this.cpf != null) {
            this.cpf.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void aei() {
        SwanAppActivity ave = f.avu().ave();
        if (ave != null) {
            w.forceHiddenSoftInput(ave, ave.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gZ(int i) {
        aen().setVisibility(i);
        if (this.cAV != null) {
            this.cAV.ld(i);
        }
        if (aef() != null) {
            aef().setVisibility(i);
        }
        if (this.cAT != null && this.cAT.aen() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aet = this.cAT.aet();
            this.cAT.aen().setVisibility(i == 0 && aet != null && !aet.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aej() {
        return this.cpf;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cAW = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cAX = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: amY */
    public SwanAppWebViewWidget aeg() {
        return this.cAT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
            SwanAppSlaveManager.this.cBa.chl = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cBa.chn = System.currentTimeMillis();
            SwanAppSlaveManager.this.cBa.chr = "0";
            com.baidu.swan.apps.performance.a.f.azv().azw().bb(SwanAppSlaveManager.this.cBa.chn);
            com.baidu.swan.apps.core.f.bb(SwanAppSlaveManager.this.cBa.chn);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cBa.chn);
            }
            HybridUbcFlow qe = i.qe("startup");
            if (qe != null) {
                qe.cb("webviewComponent", "1");
                qe.cb("fmp_type", "0");
                qe.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppSlaveManager.this.cBa.chn).a(UbcFlowEvent.RecordType.UPDATE)).ayU();
                qe.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cBa.chn), " , fmpType=", SwanAppSlaveManager.this.cBa.chr, " , fmpTypeName=", SwanAppSlaveManager.this.cBa.aeC());
                i.afW();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dmc = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bg("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cBa.chm = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.azv().azw().bE(SwanAppSlaveManager.this.cBa.chm);
            final long aeA = i.cUG ? currentTimeMillis : SwanAppSlaveManager.this.cBa.aeA();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + aeA + " , aligned search=" + i.cUG);
            }
            final HybridUbcFlow qc = i.qc("startup");
            qc.f(new UbcFlowEvent("na_first_paint").bA(aeA));
            if (SwanAppSlaveManager.this.cBa.chn == 0) {
                SwanAppSlaveManager.this.cBa.chn = aeA;
                SwanAppSlaveManager.this.cBa.chr = SwanAppSlaveManager.this.cBa.aV(aeA);
                qc.cb("fmp_type", "1");
                qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppSlaveManager.this.cBa.chm));
            }
            long acl = com.baidu.swan.apps.t.a.asi().acl();
            if (acl < 0) {
                acl = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.cUG) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.eA(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cBa.chn <= 0) {
                        j = aeA;
                    } else {
                        j = SwanAppSlaveManager.this.cBa.chn;
                    }
                    qc.cb("fmp_type", SwanAppSlaveManager.this.cBa.chr);
                    qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(j)).ayU();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cBa.chr + " , fmpTypeName=" + SwanAppSlaveManager.this.cBa.aeC());
                    }
                }
            }, "fmp record", acl, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cBa.cho = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.azv().azw().bc(SwanAppSlaveManager.this.cBa.cho);
            com.baidu.swan.apps.core.f.bc(SwanAppSlaveManager.this.cBa.cho);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cBa.cho);
            }
            if (i.cUG) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.eA(false);
            } else if (SwanAppSlaveManager.this.cBa.chn == 0) {
                HybridUbcFlow qc = i.qc("startup");
                qc.cb("fmp_type", "2");
                qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppSlaveManager.this.cBa.cho));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cBa.chp = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.azv().azw().bD(SwanAppSlaveManager.this.cBa.chp);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cBa.chp);
            }
            if (i.cUG) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.eA(false);
            } else if (SwanAppSlaveManager.this.cBa.chn == 0) {
                HybridUbcFlow qc = i.qc("startup");
                qc.cb("fmp_type", "3");
                qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppSlaveManager.this.cBa.chp));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eA(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cBa.toString());
        }
        this.cBa.aeB();
        long j = this.cBa.chn;
        String str = this.cBa.chr;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cBa.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cBa.toString());
        }
        HybridUbcFlow qc = i.qc("startup");
        qc.cb("fmp_type", str);
        qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(j).a(UbcFlowEvent.RecordType.UPDATE));
        qc.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cBa.aeC());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cBa.aeC());
            }
            qc.ayU();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ann().eD(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void jO(String str) {
        this.cAZ = str;
        if (this.cAT != null) {
            this.cAT.jO(this.cAZ);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d ael() {
        return this.cBa;
    }

    public void b(d dVar) {
        this.cAY = dVar;
    }
}
