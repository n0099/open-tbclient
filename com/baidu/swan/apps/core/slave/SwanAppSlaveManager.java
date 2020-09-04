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
/* loaded from: classes8.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cmz = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a caN;
    private FrameLayout chQ;
    private String cjz;
    private String cmA;
    private SwanAppWebViewWidget cmB;
    protected PullToRefreshNgWebView cmC;
    private com.baidu.swan.apps.view.narootview.a cmD;
    private e cmE;
    private d cmF;
    protected d cmG;
    protected String cmH;
    protected com.baidu.swan.apps.adaptation.b.a.d cmI;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cfU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void afs() {
        super.afs();
        ajA();
        l lVar = new l(this.cfG);
        lVar.f(this);
        this.cfG.a(lVar);
        this.cmI = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
        String aaU = aaU();
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aaU));
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aaU));
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aaU));
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aaU));
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aaU));
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aaU));
        this.cfB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aaU));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.aoU().c(this);
        if (this.cmB != null) {
            this.cmB.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            com.baidu.swan.apps.runtime.e.azI().azZ().eI(true);
        }
        ajB();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.aoU().d(this);
        if (this.cmB != null) {
            this.cmB.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            com.baidu.swan.apps.runtime.e.azI().azZ().eI(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cmB != null ? this.cmB.isSlidable(motionEvent) : this.cfB.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double aaD() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.adJ()) {
            com.baidu.swan.apps.core.c.b.afP();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aaP() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aaJ() {
        return aaS().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.cRL) {
                this.cmC = new PullToRefreshNgWebView(this.cfA.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                gu(SwanAppConfigData.fo(cVar.cRK));
                a(this.cmC);
                a(frameLayout, this.cmC);
            } else {
                a(frameLayout, aaS());
            }
            this.chQ = frameLayout;
            if (this.cmD == null) {
                this.cmD = new com.baidu.swan.apps.view.narootview.a(this.cfA.getBaseContext(), this, frameLayout);
            }
            if (this.caN == null) {
                this.caN = new com.baidu.swan.apps.component.c.a(this.cfA.getBaseContext(), this.cmD);
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
    public void iK(String str) {
        this.cmA = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aaR() {
        return this.cmA;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean gu(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cmC != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cmC.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.gu(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.gr(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cfB.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bh("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cmC.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.arY().a(SwanAppSlaveManager.this.aaU(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView aaK() {
        if (this.cmC == null) {
            return null;
        }
        return this.cmC;
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

    private void ajA() {
        this.cjz = String.valueOf(cmz);
        cmz++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaU() {
        return this.cjz;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cmB != null) {
            this.cmB.attachActivity(activity);
        }
    }

    private void ajB() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.auf() && !com.baidu.swan.apps.menu.fontsize.b.aud()) {
            if (this.cmB != null && this.cmB.aaS() != null) {
                ngWebView = this.cmB.aaS();
            } else {
                ngWebView = this.cfB;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.iv(com.baidu.swan.apps.menu.fontsize.b.aue()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.chQ == null) {
            return false;
        }
        if (this.cmC != null) {
            this.cmC.fs(false);
            this.cmC.setPullRefreshEnabled(false);
        }
        if (this.cmB == null) {
            if (DEBUG && !(this.cfA.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cmB = ajC();
            this.cmB.iJ(this.cmH);
            this.cmB.lR(this.cjz);
            if (!TextUtils.isEmpty(dVar.amn)) {
                this.cmB.kV(dVar.amn);
            }
            if (dVar.cbb == null) {
                dVar.cbb = com.baidu.swan.apps.model.a.a.a.auq();
            }
            a(this.chQ, this.cmB.aaS());
            if (this.cmB.aaS() != null) {
                this.cmB.aaS().setVisibility(dVar.hidden ? 8 : 0);
                ajB();
            }
            this.cmB.eh(dVar.cUe);
            this.cmB.loadUrl(dVar.mSrc);
            this.cmB.d(dVar);
            if (this.cmE != null) {
                this.cmE.a(this.cmB);
            }
            if (this.cmF != null) {
                this.cmB.a(this.cmF);
            }
            if (this.cmG != null) {
                this.cmB.b(this.cmG);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget ajC() {
        return new SwanAppWebViewWidget(this.cfA.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cmB != null) {
            if (!TextUtils.isEmpty(dVar.amn)) {
                this.cmB.kV(dVar.amn);
            }
            this.cmB.eh(dVar.cUe);
            this.cmB.loadUrl(dVar.mSrc);
            this.cmB.d(dVar);
            if (dVar.cbb == null) {
                dVar.cbb = com.baidu.swan.apps.model.a.a.a.auq();
            }
            if (this.cmB.aaS() != null) {
                this.cmB.aaS().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cmF != null) {
                this.cmB.a(this.cmF);
            }
            if (this.cmG != null) {
                this.cmB.b(this.cmG);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cmB != null) {
            if (this.cmE != null) {
                this.cmE.b(this.cmB);
            }
            if (this.cmF != null) {
                this.cmF = null;
            }
            if (this.cmG != null) {
                this.cmG = null;
            }
            c(this.chQ, this.cmB.aaS());
            this.cmB.d(dVar);
            this.cmB.destroy();
            this.cmB = null;
            if (this.cmC != null) {
                this.cmC.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aaM() {
        if (this.cmB == null || !this.cmB.aaS().canGoBack()) {
            return false;
        }
        this.cmB.aaS().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aaV() {
        com.baidu.swan.apps.media.b.destroy(this.cjz);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.anU().mQ(this.cjz);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        aaN();
        super.destroy();
        com.baidu.swan.apps.t.a.aoU().e(this);
        if (this.cmD != null) {
            this.cmD.destroy();
        }
        if (this.caN != null) {
            this.caN.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void aaN() {
        SwanAppActivity arI = f.arY().arI();
        if (arI != null) {
            w.forceHiddenSoftInput(arI, arI.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gt(int i) {
        aaS().setVisibility(i);
        if (this.cmD != null) {
            this.cmD.kv(i);
        }
        if (aaK() != null) {
            aaK().setVisibility(i);
        }
        if (this.cmB != null && this.cmB.aaS() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aaY = this.cmB.aaY();
            this.cmB.aaS().setVisibility(i == 0 && aaY != null && !aaY.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aaO() {
        return this.caN;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cmE = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cmF = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: ajD */
    public SwanAppWebViewWidget aaL() {
        return this.cmB;
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
            SwanAppSlaveManager.this.cmI.bSX = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cmI.bSZ = System.currentTimeMillis();
            SwanAppSlaveManager.this.cmI.bTd = "0";
            com.baidu.swan.apps.performance.a.f.awb().awc().aS(SwanAppSlaveManager.this.cmI.bSZ);
            com.baidu.swan.apps.core.f.aS(SwanAppSlaveManager.this.cmI.bSZ);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cmI.bSZ);
            }
            HybridUbcFlow oZ = i.oZ("startup");
            if (oZ != null) {
                oZ.bW("webviewComponent", "1");
                oZ.bW("fmp_type", "0");
                oZ.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmI.bSZ).a(UbcFlowEvent.RecordType.UPDATE)).avA();
                oZ.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cmI.bSZ), " , fmpType=", SwanAppSlaveManager.this.cmI.bTd, " , fmpTypeName=", SwanAppSlaveManager.this.cmI.abh());
                i.acB();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cXS = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cmI.bSY = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.awb().awc().bv(SwanAppSlaveManager.this.cmI.bSY);
            final long abf = i.cGD ? currentTimeMillis : SwanAppSlaveManager.this.cmI.abf();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + abf + " , aligned search=" + i.cGD);
            }
            final HybridUbcFlow oX = i.oX("startup");
            oX.f(new UbcFlowEvent("na_first_paint").br(abf));
            if (SwanAppSlaveManager.this.cmI.bSZ == 0) {
                SwanAppSlaveManager.this.cmI.bSZ = abf;
                SwanAppSlaveManager.this.cmI.bTd = SwanAppSlaveManager.this.cmI.aM(abf);
                oX.bW("fmp_type", "1");
                oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmI.bSY));
            }
            long YQ = com.baidu.swan.apps.t.a.aoM().YQ();
            if (YQ < 0) {
                YQ = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.cGD) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.eg(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cmI.bSZ <= 0) {
                        j = abf;
                    } else {
                        j = SwanAppSlaveManager.this.cmI.bSZ;
                    }
                    oX.bW("fmp_type", SwanAppSlaveManager.this.cmI.bTd);
                    oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(j)).avA();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cmI.bTd + " , fmpTypeName=" + SwanAppSlaveManager.this.cmI.abh());
                    }
                }
            }, "fmp record", YQ, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cmI.bTa = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().aT(SwanAppSlaveManager.this.cmI.bTa);
            com.baidu.swan.apps.core.f.aT(SwanAppSlaveManager.this.cmI.bTa);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cmI.bTa);
            }
            if (i.cGD) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.eg(false);
            } else if (SwanAppSlaveManager.this.cmI.bSZ == 0) {
                HybridUbcFlow oX = i.oX("startup");
                oX.bW("fmp_type", "2");
                oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmI.bTa));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cmI.bTb = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().bu(SwanAppSlaveManager.this.cmI.bTb);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cmI.bTb);
            }
            if (i.cGD) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.eg(false);
            } else if (SwanAppSlaveManager.this.cmI.bSZ == 0) {
                HybridUbcFlow oX = i.oX("startup");
                oX.bW("fmp_type", "3");
                oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmI.bTb));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eg(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cmI.toString());
        }
        this.cmI.abg();
        long j = this.cmI.bSZ;
        String str = this.cmI.bTd;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cmI.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cmI.toString());
        }
        HybridUbcFlow oX = i.oX("startup");
        oX.bW("fmp_type", str);
        oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(j).a(UbcFlowEvent.RecordType.UPDATE));
        oX.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cmI.abh());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cmI.abh());
            }
            oX.avA();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ajS().ej(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void iJ(String str) {
        this.cmH = str;
        if (this.cmB != null) {
            this.cmB.iJ(this.cmH);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d aaQ() {
        return this.cmI;
    }

    public void b(d dVar) {
        this.cmG = dVar;
    }
}
