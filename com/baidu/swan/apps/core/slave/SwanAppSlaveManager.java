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
    private static int cPg = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cDA;
    private FrameLayout cKz;
    private String cMh;
    private String cPh;
    private SwanAppWebViewWidget cPi;
    protected PullToRefreshNgWebView cPj;
    private com.baidu.swan.apps.view.narootview.a cPk;
    private e cPl;
    private d cPm;
    protected d cPn;
    protected String cPo;
    protected com.baidu.swan.apps.adaptation.b.a.d cPp;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cIE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void anh() {
        super.anh();
        arq();
        l lVar = new l(this.cIq);
        lVar.f(this);
        this.cIq.a(lVar);
        this.cPp = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void ane() {
        String aiJ = aiJ();
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aiJ));
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aiJ));
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aiJ));
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aiJ));
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aiJ));
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aiJ));
        this.cIl.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aiJ));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.awL().c(this);
        if (this.cPi != null) {
            this.cPi.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aHu() != null) {
            com.baidu.swan.apps.runtime.e.aHu().aHL().fy(true);
        }
        arr();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.awL().d(this);
        if (this.cPi != null) {
            this.cPi.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aHu() != null) {
            com.baidu.swan.apps.runtime.e.aHu().aHL().fy(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cPi != null ? this.cPi.isSlidable(motionEvent) : this.cIl.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double ais() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.aly()) {
            com.baidu.swan.apps.core.c.b.anE();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiE() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiy() {
        return aiH().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.duq) {
                this.cPj = new PullToRefreshNgWebView(this.cIk.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                hv(SwanAppConfigData.fv(cVar.dup));
                a(this.cPj);
                b(frameLayout, this.cPj);
            } else {
                b(frameLayout, aiH());
            }
            this.cKz = frameLayout;
            if (this.cPk == null) {
                this.cPk = new com.baidu.swan.apps.view.narootview.a(this.cIk.getBaseContext(), this, frameLayout);
            }
            if (this.cDA == null) {
                this.cDA = new com.baidu.swan.apps.component.c.a(this.cIk.getBaseContext(), this.cPk);
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
    public void kx(String str) {
        this.cPh = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aiG() {
        return this.cPh;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean hv(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cPj != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cPj.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.hv(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.hs(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cIl.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bt("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cPj.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.azO().a(SwanAppSlaveManager.this.aiJ(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView aiz() {
        if (this.cPj == null) {
            return null;
        }
        return this.cPj;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void b(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !c(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void d(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && c(viewGroup, view)) {
            viewGroup.removeView(view);
        }
    }

    private boolean c(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    private void arq() {
        this.cMh = String.valueOf(cPg);
        cPg++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiJ() {
        return this.cMh;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cPi != null) {
            this.cPi.attachActivity(activity);
        }
    }

    private void arr() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aBT() && !com.baidu.swan.apps.menu.fontsize.b.aBR()) {
            if (this.cPi != null && this.cPi.aiH() != null) {
                ngWebView = this.cPi.aiH();
            } else {
                ngWebView = this.cIl;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jx(com.baidu.swan.apps.menu.fontsize.b.aBS()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cKz == null) {
            return false;
        }
        if (this.cPj != null) {
            this.cPj.gi(false);
            this.cPj.setPullRefreshEnabled(false);
        }
        if (this.cPi == null) {
            if (DEBUG && !(this.cIk.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cPi = ars();
            this.cPi.kw(this.cPo);
            this.cPi.nE(this.cMh);
            if (!TextUtils.isEmpty(dVar.anz)) {
                this.cPi.mI(dVar.anz);
            }
            if (dVar.cDO == null) {
                dVar.cDO = com.baidu.swan.apps.model.a.a.a.aCe();
            }
            b(this.cKz, this.cPi.aiH());
            if (this.cPi.aiH() != null) {
                this.cPi.aiH().setVisibility(dVar.hidden ? 8 : 0);
                arr();
            }
            this.cPi.eX(dVar.dwI);
            this.cPi.loadUrl(dVar.mSrc);
            this.cPi.d(dVar);
            if (this.cPl != null) {
                this.cPl.a(this.cPi);
            }
            if (this.cPm != null) {
                this.cPi.a(this.cPm);
            }
            if (this.cPn != null) {
                this.cPi.b(this.cPn);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget ars() {
        return new SwanAppWebViewWidget(this.cIk.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cPi != null) {
            if (!TextUtils.isEmpty(dVar.anz)) {
                this.cPi.mI(dVar.anz);
            }
            this.cPi.eX(dVar.dwI);
            this.cPi.loadUrl(dVar.mSrc);
            this.cPi.d(dVar);
            if (dVar.cDO == null) {
                dVar.cDO = com.baidu.swan.apps.model.a.a.a.aCe();
            }
            if (this.cPi.aiH() != null) {
                this.cPi.aiH().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cPm != null) {
                this.cPi.a(this.cPm);
            }
            if (this.cPn != null) {
                this.cPi.b(this.cPn);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cPi != null) {
            if (this.cPl != null) {
                this.cPl.b(this.cPi);
            }
            if (this.cPm != null) {
                this.cPm = null;
            }
            if (this.cPn != null) {
                this.cPn = null;
            }
            d(this.cKz, this.cPi.aiH());
            this.cPi.d(dVar);
            this.cPi.destroy();
            this.cPi = null;
            if (this.cPj != null) {
                this.cPj.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiB() {
        if (this.cPi == null || !this.cPi.aiH().canGoBack()) {
            return false;
        }
        this.cPi.aiH().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiK() {
        com.baidu.swan.apps.media.b.hK(this.cMh);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.avL().oE(this.cMh);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        aiC();
        super.destroy();
        com.baidu.swan.apps.t.a.awL().e(this);
        if (this.cPk != null) {
            this.cPk.destroy();
        }
        if (this.cDA != null) {
            this.cDA.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void aiC() {
        SwanAppActivity azy = f.azO().azy();
        if (azy != null) {
            w.forceHiddenSoftInput(azy, azy.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hu(int i) {
        aiH().setVisibility(i);
        if (this.cPk != null) {
            this.cPk.ly(i);
        }
        if (aiz() != null) {
            aiz().setVisibility(i);
        }
        if (this.cPi != null && this.cPi.aiH() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aiN = this.cPi.aiN();
            this.cPi.aiH().setVisibility(i == 0 && aiN != null && !aiN.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aiD() {
        return this.cDA;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cPl = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cPm = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: art */
    public SwanAppWebViewWidget aiA() {
        return this.cPi;
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
            SwanAppSlaveManager.this.cPp.cvK = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cPp.cvM = System.currentTimeMillis();
            SwanAppSlaveManager.this.cPp.cvQ = "0";
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bz(SwanAppSlaveManager.this.cPp.cvM);
            com.baidu.swan.apps.core.f.bz(SwanAppSlaveManager.this.cPp.cvM);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cPp.cvM);
            }
            HybridUbcFlow qL = i.qL("startup");
            if (qL != null) {
                qL.ci("webviewComponent", "1");
                qL.ci("fmp_type", "0");
                qL.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cPp.cvM).a(UbcFlowEvent.RecordType.UPDATE)).aDo();
                qL.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cPp.cvM), " , fmpType=", SwanAppSlaveManager.this.cPp.cvQ, " , fmpTypeName=", SwanAppSlaveManager.this.cPp.aiW());
                i.akq();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dAw = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cPp.cvL = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cc(SwanAppSlaveManager.this.cPp.cvL);
            final long aiU = i.djc ? currentTimeMillis : SwanAppSlaveManager.this.cPp.aiU();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + aiU + " , aligned search=" + i.djc);
            }
            final HybridUbcFlow qJ = i.qJ("startup");
            qJ.f(new UbcFlowEvent("na_first_paint").bY(aiU));
            if (SwanAppSlaveManager.this.cPp.cvM == 0) {
                SwanAppSlaveManager.this.cPp.cvM = aiU;
                SwanAppSlaveManager.this.cPp.cvQ = SwanAppSlaveManager.this.cPp.bt(aiU);
                qJ.ci("fmp_type", "1");
                qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cPp.cvL));
            }
            long agF = com.baidu.swan.apps.t.a.awD().agF();
            if (agF < 0) {
                agF = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.djc) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.eW(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cPp.cvM <= 0) {
                        j = aiU;
                    } else {
                        j = SwanAppSlaveManager.this.cPp.cvM;
                    }
                    qJ.ci("fmp_type", SwanAppSlaveManager.this.cPp.cvQ);
                    qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(j)).aDo();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cPp.cvQ + " , fmpTypeName=" + SwanAppSlaveManager.this.cPp.aiW());
                    }
                }
            }, "fmp record", agF, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cPp.cvN = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bA(SwanAppSlaveManager.this.cPp.cvN);
            com.baidu.swan.apps.core.f.bA(SwanAppSlaveManager.this.cPp.cvN);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cPp.cvN);
            }
            if (i.djc) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.eW(false);
            } else if (SwanAppSlaveManager.this.cPp.cvM == 0) {
                HybridUbcFlow qJ = i.qJ("startup");
                qJ.ci("fmp_type", "2");
                qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cPp.cvN));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cPp.cvO = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cb(SwanAppSlaveManager.this.cPp.cvO);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cPp.cvO);
            }
            if (i.djc) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.eW(false);
            } else if (SwanAppSlaveManager.this.cPp.cvM == 0) {
                HybridUbcFlow qJ = i.qJ("startup");
                qJ.ci("fmp_type", "3");
                qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cPp.cvO));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eW(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cPp.toString());
        }
        this.cPp.aiV();
        long j = this.cPp.cvM;
        String str = this.cPp.cvQ;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cPp.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cPp.toString());
        }
        HybridUbcFlow qJ = i.qJ("startup");
        qJ.ci("fmp_type", str);
        qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(j).a(UbcFlowEvent.RecordType.UPDATE));
        qJ.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cPp.aiW());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cPp.aiW());
            }
            qJ.aDo();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.arI().eZ(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void kw(String str) {
        this.cPo = str;
        if (this.cPi != null) {
            this.cPi.kw(this.cPo);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d aiF() {
        return this.cPp;
    }

    public void b(d dVar) {
        this.cPn = dVar;
    }
}
