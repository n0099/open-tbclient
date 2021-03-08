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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.w;
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
/* loaded from: classes8.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cYm = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cMG;
    private FrameLayout cTG;
    private String cVo;
    private String cYn;
    private SwanAppWebViewWidget cYo;
    protected PullToRefreshNgWebView cYp;
    private com.baidu.swan.apps.view.narootview.a cYq;
    private e cYr;
    private d cYs;
    protected d cYt;
    protected String cYu;
    protected com.baidu.swan.apps.adaptation.b.a.d cYv;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cRL = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void anA() {
        super.anA();
        arO();
        l lVar = new l(this.cRx);
        lVar.f(this);
        this.cRx.a(lVar);
        this.cYv = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anx() {
        String ajb = ajb();
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(ajb));
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(ajb));
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(ajb));
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(ajb));
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(ajb));
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(ajb));
        this.cRs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(ajb));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.axk().c(this);
        if (this.cYo != null) {
            this.cYo.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aIN() != null) {
            com.baidu.swan.apps.runtime.e.aIN().aJe().fX(true);
        }
        arP();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.axk().d(this);
        if (this.cYo != null) {
            this.cYo.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aIN() != null) {
            com.baidu.swan.apps.runtime.e.aIN().aJe().fX(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cYo != null ? this.cYo.isSlidable(motionEvent) : this.cRs.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double aiK() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.alR()) {
            com.baidu.swan.apps.core.c.b.anX();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiW() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiQ() {
        return aiZ().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dHg) {
                this.cYp = new PullToRefreshNgWebView(this.cRr.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                gg(SwanAppConfigData.rT(cVar.dHf));
                a(this.cYp);
                b(frameLayout, this.cYp);
            } else {
                b(frameLayout, aiZ());
            }
            this.cTG = frameLayout;
            if (this.cYq == null) {
                this.cYq = new com.baidu.swan.apps.view.narootview.a(this.cRr.getBaseContext(), this, frameLayout);
            }
            if (this.cMG == null) {
                this.cMG = new com.baidu.swan.apps.component.c.a(this.cRr.getBaseContext(), this.cYq);
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
    public void kf(String str) {
        this.cYn = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aiY() {
        return this.cYn;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean gg(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cYp != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cYp.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.gg(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.gd(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cRs.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.br("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cYp.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.aAo().a(SwanAppSlaveManager.this.ajb(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView aiR() {
        if (this.cYp == null) {
            return null;
        }
        return this.cYp;
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

    private void arO() {
        this.cVo = String.valueOf(cYm);
        cYm++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String ajb() {
        return this.cVo;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cYo != null) {
            this.cYo.attachActivity(activity);
        }
    }

    private void arP() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aCu() && !com.baidu.swan.apps.menu.fontsize.b.aCs()) {
            if (this.cYo != null && this.cYo.aiZ() != null) {
                ngWebView = this.cYo.aiZ();
            } else {
                ngWebView = this.cRs;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.ik(com.baidu.swan.apps.menu.fontsize.b.aCt()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cTG == null) {
            return false;
        }
        if (this.cYp != null) {
            this.cYp.gH(false);
            this.cYp.setPullRefreshEnabled(false);
        }
        if (this.cYo == null) {
            if (DEBUG && !(this.cRr.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cYo = arQ();
            this.cYo.ke(this.cYu);
            this.cYo.nm(this.cVo);
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cYo.mq(dVar.mUa);
            }
            if (dVar.cMU == null) {
                dVar.cMU = com.baidu.swan.apps.model.a.a.a.aCF();
            }
            b(this.cTG, this.cYo.aiZ());
            if (this.cYo.aiZ() != null) {
                this.cYo.aiZ().setVisibility(dVar.hidden ? 8 : 0);
                arP();
            }
            this.cYo.fw(dVar.dJy);
            this.cYo.loadUrl(dVar.mSrc);
            this.cYo.d(dVar);
            if (this.cYr != null) {
                this.cYr.a(this.cYo);
            }
            if (this.cYs != null) {
                this.cYo.a(this.cYs);
            }
            if (this.cYt != null) {
                this.cYo.b(this.cYt);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget arQ() {
        return new SwanAppWebViewWidget(this.cRr.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cYo != null) {
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cYo.mq(dVar.mUa);
            }
            this.cYo.fw(dVar.dJy);
            this.cYo.loadUrl(dVar.mSrc);
            this.cYo.d(dVar);
            if (dVar.cMU == null) {
                dVar.cMU = com.baidu.swan.apps.model.a.a.a.aCF();
            }
            if (this.cYo.aiZ() != null) {
                this.cYo.aiZ().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cYs != null) {
                this.cYo.a(this.cYs);
            }
            if (this.cYt != null) {
                this.cYo.b(this.cYt);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cYo != null) {
            if (this.cYr != null) {
                this.cYr.b(this.cYo);
            }
            if (this.cYs != null) {
                this.cYs = null;
            }
            if (this.cYt != null) {
                this.cYt = null;
            }
            d(this.cTG, this.cYo.aiZ());
            this.cYo.d(dVar);
            this.cYo.destroy();
            this.cYo = null;
            if (this.cYp != null) {
                this.cYp.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiT() {
        if (this.cYo == null || !this.cYo.aiZ().canGoBack()) {
            return false;
        }
        this.cYo.aiZ().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void ajc() {
        com.baidu.swan.apps.media.b.hi(this.cVo);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.awk().ol(this.cVo);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        aiU();
        super.destroy();
        com.baidu.swan.apps.t.a.axk().e(this);
        if (this.cYq != null) {
            this.cYq.destroy();
        }
        if (this.cMG != null) {
            this.cMG.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void aiU() {
        SwanAppActivity azY = f.aAo().azY();
        if (azY != null) {
            w.forceHiddenSoftInput(azY, azY.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gf(int i) {
        aiZ().setVisibility(i);
        if (this.cYq != null) {
            this.cYq.kx(i);
        }
        if (aiR() != null) {
            aiR().setVisibility(i);
        }
        if (this.cYo != null && this.cYo.aiZ() != null) {
            com.baidu.swan.apps.scheme.actions.m.d ajf = this.cYo.ajf();
            this.cYo.aiZ().setVisibility(i == 0 && ajf != null && !ajf.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aiV() {
        return this.cMG;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cYr = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cYs = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: arR */
    public SwanAppWebViewWidget aiS() {
        return this.cYo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            SwanAppSlaveManager.this.cYv.cES = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cYv.cEU = System.currentTimeMillis();
            SwanAppSlaveManager.this.cYv.cEY = "0";
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cf(SwanAppSlaveManager.this.cYv.cEU);
            com.baidu.swan.apps.core.f.cf(SwanAppSlaveManager.this.cYv.cEU);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cYv.cEU);
            }
            HybridUbcFlow qt = i.qt("startup");
            if (qt != null) {
                qt.cg("webviewComponent", "1");
                qt.cg("fmp_type", "0");
                qt.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cYv.cEU).a(UbcFlowEvent.RecordType.UPDATE)).aDO();
                qt.p("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cYv.cEU), " , fmpType=", SwanAppSlaveManager.this.cYv.cEY, " , fmpTypeName=", SwanAppSlaveManager.this.cYv.ajo());
                i.akI();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dNl = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cYv.cET = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cI(SwanAppSlaveManager.this.cYv.cET);
            final long ajm = i.dsq ? currentTimeMillis : SwanAppSlaveManager.this.cYv.ajm();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + ajm + " , aligned search=" + i.dsq);
            }
            final HybridUbcFlow qr = i.qr("startup");
            qr.f(new UbcFlowEvent("na_first_paint").cE(ajm));
            if (SwanAppSlaveManager.this.cYv.cEU == 0) {
                SwanAppSlaveManager.this.cYv.cEU = ajm;
                SwanAppSlaveManager.this.cYv.cEY = SwanAppSlaveManager.this.cYv.bZ(ajm);
                qr.cg("fmp_type", "1");
                qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cYv.cET));
            }
            long agV = com.baidu.swan.apps.t.a.axc().agV();
            if (agV < 0) {
                agV = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.dsq) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.fv(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cYv.cEU <= 0) {
                        j = ajm;
                    } else {
                        j = SwanAppSlaveManager.this.cYv.cEU;
                    }
                    qr.cg("fmp_type", SwanAppSlaveManager.this.cYv.cEY);
                    qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(j)).aDO();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cYv.cEY + " , fmpTypeName=" + SwanAppSlaveManager.this.cYv.ajo());
                    }
                }
            }, "fmp record", agV, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cYv.cEV = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cg(SwanAppSlaveManager.this.cYv.cEV);
            com.baidu.swan.apps.core.f.cg(SwanAppSlaveManager.this.cYv.cEV);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cYv.cEV);
            }
            if (i.dsq) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.fv(false);
            } else if (SwanAppSlaveManager.this.cYv.cEU == 0) {
                HybridUbcFlow qr = i.qr("startup");
                qr.cg("fmp_type", "2");
                qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cYv.cEV));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cYv.cEW = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cH(SwanAppSlaveManager.this.cYv.cEW);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cYv.cEW);
            }
            if (i.dsq) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.fv(false);
            } else if (SwanAppSlaveManager.this.cYv.cEU == 0) {
                HybridUbcFlow qr = i.qr("startup");
                qr.cg("fmp_type", "3");
                qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cYv.cEW));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void fv(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cYv.toString());
        }
        this.cYv.ajn();
        long j = this.cYv.cEU;
        String str = this.cYv.cEY;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cYv.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cYv.toString());
        }
        HybridUbcFlow qr = i.qr("startup");
        qr.cg("fmp_type", str);
        qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(j).a(UbcFlowEvent.RecordType.UPDATE));
        qr.p("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cYv.ajo());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cYv.ajo());
            }
            qr.aDO();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ash().fy(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ke(String str) {
        this.cYu = str;
        if (this.cYo != null) {
            this.cYo.ke(this.cYu);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d aiX() {
        return this.cYv;
    }

    public void b(d dVar) {
        this.cYt = dVar;
    }
}
