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
/* loaded from: classes7.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cNw = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cBQ;
    private FrameLayout cIP;
    private String cKx;
    private com.baidu.swan.apps.view.narootview.a cNA;
    private e cNB;
    private d cNC;
    protected d cND;
    protected String cNE;
    protected com.baidu.swan.apps.adaptation.b.a.d cNF;
    private String cNx;
    private SwanAppWebViewWidget cNy;
    protected PullToRefreshNgWebView cNz;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cGU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void amz() {
        super.amz();
        aqI();
        l lVar = new l(this.cGG);
        lVar.f(this);
        this.cGG.a(lVar);
        this.cNF = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amw() {
        String aib = aib();
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aib));
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aib));
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aib));
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aib));
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aib));
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aib));
        this.cGB.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aib));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.awd().c(this);
        if (this.cNy != null) {
            this.cNy.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aGM() != null) {
            com.baidu.swan.apps.runtime.e.aGM().aHd().fB(true);
        }
        aqJ();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.awd().d(this);
        if (this.cNy != null) {
            this.cNy.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aGM() != null) {
            com.baidu.swan.apps.runtime.e.aGM().aHd().fB(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cNy != null ? this.cNy.isSlidable(motionEvent) : this.cGB.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double ahK() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.akQ()) {
            com.baidu.swan.apps.core.c.b.amW();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ahW() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ahQ() {
        return ahZ().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dsI) {
                this.cNz = new PullToRefreshNgWebView(this.cGA.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                hr(SwanAppConfigData.sa(cVar.dsH));
                a(this.cNz);
                b(frameLayout, this.cNz);
            } else {
                b(frameLayout, ahZ());
            }
            this.cIP = frameLayout;
            if (this.cNA == null) {
                this.cNA = new com.baidu.swan.apps.view.narootview.a(this.cGA.getBaseContext(), this, frameLayout);
            }
            if (this.cBQ == null) {
                this.cBQ = new com.baidu.swan.apps.component.c.a(this.cGA.getBaseContext(), this.cNA);
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
    public void kr(String str) {
        this.cNx = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String ahY() {
        return this.cNx;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean hr(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cNz != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cNz.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.hr(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.ho(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cGB.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bs("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cNz.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.azg().a(SwanAppSlaveManager.this.aib(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView ahR() {
        if (this.cNz == null) {
            return null;
        }
        return this.cNz;
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

    private void aqI() {
        this.cKx = String.valueOf(cNw);
        cNw++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aib() {
        return this.cKx;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cNy != null) {
            this.cNy.attachActivity(activity);
        }
    }

    private void aqJ() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aBl() && !com.baidu.swan.apps.menu.fontsize.b.aBj()) {
            if (this.cNy != null && this.cNy.ahZ() != null) {
                ngWebView = this.cNy.ahZ();
            } else {
                ngWebView = this.cGB;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jt(com.baidu.swan.apps.menu.fontsize.b.aBk()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cIP == null) {
            return false;
        }
        if (this.cNz != null) {
            this.cNz.gl(false);
            this.cNz.setPullRefreshEnabled(false);
        }
        if (this.cNy == null) {
            if (DEBUG && !(this.cGA.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cNy = aqK();
            this.cNy.kq(this.cNE);
            this.cNy.ny(this.cKx);
            if (!TextUtils.isEmpty(dVar.anF)) {
                this.cNy.mC(dVar.anF);
            }
            if (dVar.cCe == null) {
                dVar.cCe = com.baidu.swan.apps.model.a.a.a.aBw();
            }
            b(this.cIP, this.cNy.ahZ());
            if (this.cNy.ahZ() != null) {
                this.cNy.ahZ().setVisibility(dVar.hidden ? 8 : 0);
                aqJ();
            }
            this.cNy.fa(dVar.dvb);
            this.cNy.loadUrl(dVar.mSrc);
            this.cNy.d(dVar);
            if (this.cNB != null) {
                this.cNB.a(this.cNy);
            }
            if (this.cNC != null) {
                this.cNy.a(this.cNC);
            }
            if (this.cND != null) {
                this.cNy.b(this.cND);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget aqK() {
        return new SwanAppWebViewWidget(this.cGA.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cNy != null) {
            if (!TextUtils.isEmpty(dVar.anF)) {
                this.cNy.mC(dVar.anF);
            }
            this.cNy.fa(dVar.dvb);
            this.cNy.loadUrl(dVar.mSrc);
            this.cNy.d(dVar);
            if (dVar.cCe == null) {
                dVar.cCe = com.baidu.swan.apps.model.a.a.a.aBw();
            }
            if (this.cNy.ahZ() != null) {
                this.cNy.ahZ().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cNC != null) {
                this.cNy.a(this.cNC);
            }
            if (this.cND != null) {
                this.cNy.b(this.cND);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cNy != null) {
            if (this.cNB != null) {
                this.cNB.b(this.cNy);
            }
            if (this.cNC != null) {
                this.cNC = null;
            }
            if (this.cND != null) {
                this.cND = null;
            }
            d(this.cIP, this.cNy.ahZ());
            this.cNy.d(dVar);
            this.cNy.destroy();
            this.cNy = null;
            if (this.cNz != null) {
                this.cNz.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ahT() {
        if (this.cNy == null || !this.cNy.ahZ().canGoBack()) {
            return false;
        }
        this.cNy.ahZ().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aic() {
        com.baidu.swan.apps.media.b.hE(this.cKx);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.avd().oy(this.cKx);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        ahU();
        super.destroy();
        com.baidu.swan.apps.t.a.awd().e(this);
        if (this.cNA != null) {
            this.cNA.destroy();
        }
        if (this.cBQ != null) {
            this.cBQ.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ahU() {
        SwanAppActivity ayQ = f.azg().ayQ();
        if (ayQ != null) {
            w.forceHiddenSoftInput(ayQ, ayQ.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hq(int i) {
        ahZ().setVisibility(i);
        if (this.cNA != null) {
            this.cNA.lu(i);
        }
        if (ahR() != null) {
            ahR().setVisibility(i);
        }
        if (this.cNy != null && this.cNy.ahZ() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aif = this.cNy.aif();
            this.cNy.ahZ().setVisibility(i == 0 && aif != null && !aif.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a ahV() {
        return this.cBQ;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cNB = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cNC = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: aqL */
    public SwanAppWebViewWidget ahS() {
        return this.cNy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
            SwanAppSlaveManager.this.cNF.ctY = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cNF.cua = System.currentTimeMillis();
            SwanAppSlaveManager.this.cNF.cue = "0";
            com.baidu.swan.apps.performance.a.f.aDh().aDi().bz(SwanAppSlaveManager.this.cNF.cua);
            com.baidu.swan.apps.core.f.bz(SwanAppSlaveManager.this.cNF.cua);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cNF.cua);
            }
            HybridUbcFlow qF = i.qF("startup");
            if (qF != null) {
                qF.ch("webviewComponent", "1");
                qF.ch("fmp_type", "0");
                qF.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cNF.cua).a(UbcFlowEvent.RecordType.UPDATE)).aCG();
                qF.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cNF.cua), " , fmpType=", SwanAppSlaveManager.this.cNF.cue, " , fmpTypeName=", SwanAppSlaveManager.this.cNF.aio());
                i.ajI();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dyP = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bm("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cNF.ctZ = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aDh().aDi().cc(SwanAppSlaveManager.this.cNF.ctZ);
            final long aim = i.dhs ? currentTimeMillis : SwanAppSlaveManager.this.cNF.aim();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + aim + " , aligned search=" + i.dhs);
            }
            final HybridUbcFlow qD = i.qD("startup");
            qD.f(new UbcFlowEvent("na_first_paint").bY(aim));
            if (SwanAppSlaveManager.this.cNF.cua == 0) {
                SwanAppSlaveManager.this.cNF.cua = aim;
                SwanAppSlaveManager.this.cNF.cue = SwanAppSlaveManager.this.cNF.bt(aim);
                qD.ch("fmp_type", "1");
                qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cNF.ctZ));
            }
            long afX = com.baidu.swan.apps.t.a.avV().afX();
            if (afX < 0) {
                afX = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.dhs) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.eZ(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cNF.cua <= 0) {
                        j = aim;
                    } else {
                        j = SwanAppSlaveManager.this.cNF.cua;
                    }
                    qD.ch("fmp_type", SwanAppSlaveManager.this.cNF.cue);
                    qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(j)).aCG();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cNF.cue + " , fmpTypeName=" + SwanAppSlaveManager.this.cNF.aio());
                    }
                }
            }, "fmp record", afX, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cNF.cub = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDh().aDi().bA(SwanAppSlaveManager.this.cNF.cub);
            com.baidu.swan.apps.core.f.bA(SwanAppSlaveManager.this.cNF.cub);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cNF.cub);
            }
            if (i.dhs) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.eZ(false);
            } else if (SwanAppSlaveManager.this.cNF.cua == 0) {
                HybridUbcFlow qD = i.qD("startup");
                qD.ch("fmp_type", "2");
                qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cNF.cub));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cNF.cuc = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDh().aDi().cb(SwanAppSlaveManager.this.cNF.cuc);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cNF.cuc);
            }
            if (i.dhs) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.eZ(false);
            } else if (SwanAppSlaveManager.this.cNF.cua == 0) {
                HybridUbcFlow qD = i.qD("startup");
                qD.ch("fmp_type", "3");
                qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppSlaveManager.this.cNF.cuc));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eZ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cNF.toString());
        }
        this.cNF.ain();
        long j = this.cNF.cua;
        String str = this.cNF.cue;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cNF.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cNF.toString());
        }
        HybridUbcFlow qD = i.qD("startup");
        qD.ch("fmp_type", str);
        qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(j).a(UbcFlowEvent.RecordType.UPDATE));
        qD.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cNF.aio());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cNF.aio());
            }
            qD.aCG();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ara().fc(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void kq(String str) {
        this.cNE = str;
        if (this.cNy != null) {
            this.cNy.kq(this.cNE);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d ahX() {
        return this.cNF;
    }

    public void b(d dVar) {
        this.cND = dVar;
    }
}
