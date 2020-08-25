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
    private static int cmv = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a caJ;
    private FrameLayout chM;
    private String cjv;
    private e cmA;
    private d cmB;
    protected d cmC;
    protected String cmD;
    protected com.baidu.swan.apps.adaptation.b.a.d cmE;
    private String cmw;
    private SwanAppWebViewWidget cmx;
    protected PullToRefreshNgWebView cmy;
    private com.baidu.swan.apps.view.narootview.a cmz;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cfQ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void afs() {
        super.afs();
        ajA();
        l lVar = new l(this.cfC);
        lVar.f(this);
        this.cfC.a(lVar);
        this.cmE = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
        String aaU = aaU();
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aaU));
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aaU));
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aaU));
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aaU));
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aaU));
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aaU));
        this.cfx.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aaU));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.aoU().c(this);
        if (this.cmx != null) {
            this.cmx.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            com.baidu.swan.apps.runtime.e.azI().azZ().eH(true);
        }
        ajB();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.aoU().d(this);
        if (this.cmx != null) {
            this.cmx.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            com.baidu.swan.apps.runtime.e.azI().azZ().eH(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cmx != null ? this.cmx.isSlidable(motionEvent) : this.cfx.isSlidable(motionEvent);
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
            if (cVar.cRH) {
                this.cmy = new PullToRefreshNgWebView(this.cfw.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                gu(SwanAppConfigData.fn(cVar.cRG));
                a(this.cmy);
                a(frameLayout, this.cmy);
            } else {
                a(frameLayout, aaS());
            }
            this.chM = frameLayout;
            if (this.cmz == null) {
                this.cmz = new com.baidu.swan.apps.view.narootview.a(this.cfw.getBaseContext(), this, frameLayout);
            }
            if (this.caJ == null) {
                this.caJ = new com.baidu.swan.apps.component.c.a(this.cfw.getBaseContext(), this.cmz);
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
    public void iJ(String str) {
        this.cmw = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aaR() {
        return this.cmw;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean gu(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cmy != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cmy.getHeaderLoadingLayout()) != null) {
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
            this.cfx.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bh("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cmy.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
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
        if (this.cmy == null) {
            return null;
        }
        return this.cmy;
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
        this.cjv = String.valueOf(cmv);
        cmv++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaU() {
        return this.cjv;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cmx != null) {
            this.cmx.attachActivity(activity);
        }
    }

    private void ajB() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.auf() && !com.baidu.swan.apps.menu.fontsize.b.aud()) {
            if (this.cmx != null && this.cmx.aaS() != null) {
                ngWebView = this.cmx.aaS();
            } else {
                ngWebView = this.cfx;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.iv(com.baidu.swan.apps.menu.fontsize.b.aue()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.chM == null) {
            return false;
        }
        if (this.cmy != null) {
            this.cmy.fr(false);
            this.cmy.setPullRefreshEnabled(false);
        }
        if (this.cmx == null) {
            if (DEBUG && !(this.cfw.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cmx = ajC();
            this.cmx.iI(this.cmD);
            this.cmx.lQ(this.cjv);
            if (!TextUtils.isEmpty(dVar.aml)) {
                this.cmx.kU(dVar.aml);
            }
            if (dVar.caX == null) {
                dVar.caX = com.baidu.swan.apps.model.a.a.a.auq();
            }
            a(this.chM, this.cmx.aaS());
            if (this.cmx.aaS() != null) {
                this.cmx.aaS().setVisibility(dVar.hidden ? 8 : 0);
                ajB();
            }
            this.cmx.eg(dVar.cUa);
            this.cmx.loadUrl(dVar.mSrc);
            this.cmx.d(dVar);
            if (this.cmA != null) {
                this.cmA.a(this.cmx);
            }
            if (this.cmB != null) {
                this.cmx.a(this.cmB);
            }
            if (this.cmC != null) {
                this.cmx.b(this.cmC);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget ajC() {
        return new SwanAppWebViewWidget(this.cfw.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cmx != null) {
            if (!TextUtils.isEmpty(dVar.aml)) {
                this.cmx.kU(dVar.aml);
            }
            this.cmx.eg(dVar.cUa);
            this.cmx.loadUrl(dVar.mSrc);
            this.cmx.d(dVar);
            if (dVar.caX == null) {
                dVar.caX = com.baidu.swan.apps.model.a.a.a.auq();
            }
            if (this.cmx.aaS() != null) {
                this.cmx.aaS().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cmB != null) {
                this.cmx.a(this.cmB);
            }
            if (this.cmC != null) {
                this.cmx.b(this.cmC);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cmx != null) {
            if (this.cmA != null) {
                this.cmA.b(this.cmx);
            }
            if (this.cmB != null) {
                this.cmB = null;
            }
            if (this.cmC != null) {
                this.cmC = null;
            }
            c(this.chM, this.cmx.aaS());
            this.cmx.d(dVar);
            this.cmx.destroy();
            this.cmx = null;
            if (this.cmy != null) {
                this.cmy.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aaM() {
        if (this.cmx == null || !this.cmx.aaS().canGoBack()) {
            return false;
        }
        this.cmx.aaS().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aaV() {
        com.baidu.swan.apps.media.b.destroy(this.cjv);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.anU().mP(this.cjv);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        aaN();
        super.destroy();
        com.baidu.swan.apps.t.a.aoU().e(this);
        if (this.cmz != null) {
            this.cmz.destroy();
        }
        if (this.caJ != null) {
            this.caJ.onDestroy();
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
        if (this.cmz != null) {
            this.cmz.kv(i);
        }
        if (aaK() != null) {
            aaK().setVisibility(i);
        }
        if (this.cmx != null && this.cmx.aaS() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aaY = this.cmx.aaY();
            this.cmx.aaS().setVisibility(i == 0 && aaY != null && !aaY.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aaO() {
        return this.caJ;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cmA = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cmB = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: ajD */
    public SwanAppWebViewWidget aaL() {
        return this.cmx;
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
            SwanAppSlaveManager.this.cmE.bST = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cmE.bSV = System.currentTimeMillis();
            SwanAppSlaveManager.this.cmE.bSZ = "0";
            com.baidu.swan.apps.performance.a.f.awb().awc().aS(SwanAppSlaveManager.this.cmE.bSV);
            com.baidu.swan.apps.core.f.aS(SwanAppSlaveManager.this.cmE.bSV);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cmE.bSV);
            }
            HybridUbcFlow oY = i.oY("startup");
            if (oY != null) {
                oY.bW("webviewComponent", "1");
                oY.bW("fmp_type", "0");
                oY.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmE.bSV).a(UbcFlowEvent.RecordType.UPDATE)).avA();
                oY.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cmE.bSV), " , fmpType=", SwanAppSlaveManager.this.cmE.bSZ, " , fmpTypeName=", SwanAppSlaveManager.this.cmE.abh());
                i.acB();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cXO = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.cmE.bSU = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.awb().awc().bv(SwanAppSlaveManager.this.cmE.bSU);
            final long abf = i.cGz ? currentTimeMillis : SwanAppSlaveManager.this.cmE.abf();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + abf + " , aligned search=" + i.cGz);
            }
            final HybridUbcFlow oW = i.oW("startup");
            oW.f(new UbcFlowEvent("na_first_paint").br(abf));
            if (SwanAppSlaveManager.this.cmE.bSV == 0) {
                SwanAppSlaveManager.this.cmE.bSV = abf;
                SwanAppSlaveManager.this.cmE.bSZ = SwanAppSlaveManager.this.cmE.aM(abf);
                oW.bW("fmp_type", "1");
                oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmE.bSU));
            }
            long YQ = com.baidu.swan.apps.t.a.aoM().YQ();
            if (YQ < 0) {
                YQ = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.cGz) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.ef(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cmE.bSV <= 0) {
                        j = abf;
                    } else {
                        j = SwanAppSlaveManager.this.cmE.bSV;
                    }
                    oW.bW("fmp_type", SwanAppSlaveManager.this.cmE.bSZ);
                    oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(j)).avA();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cmE.bSZ + " , fmpTypeName=" + SwanAppSlaveManager.this.cmE.abh());
                    }
                }
            }, "fmp record", YQ, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cmE.bSW = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().aT(SwanAppSlaveManager.this.cmE.bSW);
            com.baidu.swan.apps.core.f.aT(SwanAppSlaveManager.this.cmE.bSW);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cmE.bSW);
            }
            if (i.cGz) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.ef(false);
            } else if (SwanAppSlaveManager.this.cmE.bSV == 0) {
                HybridUbcFlow oW = i.oW("startup");
                oW.bW("fmp_type", "2");
                oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmE.bSW));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cmE.bSX = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().bu(SwanAppSlaveManager.this.cmE.bSX);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cmE.bSX);
            }
            if (i.cGz) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.ef(false);
            } else if (SwanAppSlaveManager.this.cmE.bSV == 0) {
                HybridUbcFlow oW = i.oW("startup");
                oW.bW("fmp_type", "3");
                oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppSlaveManager.this.cmE.bSX));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ef(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cmE.toString());
        }
        this.cmE.abg();
        long j = this.cmE.bSV;
        String str = this.cmE.bSZ;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cmE.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cmE.toString());
        }
        HybridUbcFlow oW = i.oW("startup");
        oW.bW("fmp_type", str);
        oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(j).a(UbcFlowEvent.RecordType.UPDATE));
        oW.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cmE.abh());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cmE.abh());
            }
            oW.avA();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ajS().ei(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void iI(String str) {
        this.cmD = str;
        if (this.cmx != null) {
            this.cmx.iI(this.cmD);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d aaQ() {
        return this.cmE;
    }

    public void b(d dVar) {
        this.cmC = dVar;
    }
}
