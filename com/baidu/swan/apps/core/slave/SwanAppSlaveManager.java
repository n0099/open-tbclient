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
/* loaded from: classes3.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int coC = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a ccP;
    private FrameLayout cjS;
    private String clA;
    private String coD;
    private SwanAppWebViewWidget coE;
    protected PullToRefreshNgWebView coF;
    private com.baidu.swan.apps.view.narootview.a coG;
    private e coH;
    private d coI;
    protected d coJ;
    protected String coK;
    protected com.baidu.swan.apps.adaptation.b.a.d coL;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.chV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void agc() {
        super.agc();
        akk();
        l lVar = new l(this.chH);
        lVar.f(this);
        this.chH.a(lVar);
        this.coL = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afZ() {
        String abD = abD();
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(abD));
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(abD));
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(abD));
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(abD));
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(abD));
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(abD));
        this.chC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(abD));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.apF().c(this);
        if (this.coE != null) {
            this.coE.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aAr() != null) {
            com.baidu.swan.apps.runtime.e.aAr().aAI().eG(true);
        }
        akl();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.apF().d(this);
        if (this.coE != null) {
            this.coE.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aAr() != null) {
            com.baidu.swan.apps.runtime.e.aAr().aAI().eG(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.coE != null ? this.coE.isSlidable(motionEvent) : this.chC.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double abm() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.aet()) {
            com.baidu.swan.apps.core.c.b.agz();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aby() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean abs() {
        return abB().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.cTL) {
                this.coF = new PullToRefreshNgWebView(this.chB.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                gD(SwanAppConfigData.fq(cVar.cTK));
                a(this.coF);
                a(frameLayout, this.coF);
            } else {
                a(frameLayout, abB());
            }
            this.cjS = frameLayout;
            if (this.coG == null) {
                this.coG = new com.baidu.swan.apps.view.narootview.a(this.chB.getBaseContext(), this, frameLayout);
            }
            if (this.ccP == null) {
                this.ccP = new com.baidu.swan.apps.component.c.a(this.chB.getBaseContext(), this.coG);
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
    public void jd(String str) {
        this.coD = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String abA() {
        return this.coD;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean gD(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.coF != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.coF.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.gD(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.gA(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.chC.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bh("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.coF.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.asJ().a(SwanAppSlaveManager.this.abD(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView abt() {
        if (this.coF == null) {
            return null;
        }
        return this.coF;
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

    private void akk() {
        this.clA = String.valueOf(coC);
        coC++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String abD() {
        return this.clA;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.coE != null) {
            this.coE.attachActivity(activity);
        }
    }

    private void akl() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.auO() && !com.baidu.swan.apps.menu.fontsize.b.auM()) {
            if (this.coE != null && this.coE.abB() != null) {
                ngWebView = this.coE.abB();
            } else {
                ngWebView = this.chC;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.iF(com.baidu.swan.apps.menu.fontsize.b.auN()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cjS == null) {
            return false;
        }
        if (this.coF != null) {
            this.coF.fq(false);
            this.coF.setPullRefreshEnabled(false);
        }
        if (this.coE == null) {
            if (DEBUG && !(this.chB.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.coE = akm();
            this.coE.jc(this.coK);
            this.coE.mk(this.clA);
            if (!TextUtils.isEmpty(dVar.amP)) {
                this.coE.lo(dVar.amP);
            }
            if (dVar.cdd == null) {
                dVar.cdd = com.baidu.swan.apps.model.a.a.a.auZ();
            }
            a(this.cjS, this.coE.abB());
            if (this.coE.abB() != null) {
                this.coE.abB().setVisibility(dVar.hidden ? 8 : 0);
                akl();
            }
            this.coE.ef(dVar.cWe);
            this.coE.loadUrl(dVar.mSrc);
            this.coE.d(dVar);
            if (this.coH != null) {
                this.coH.a(this.coE);
            }
            if (this.coI != null) {
                this.coE.a(this.coI);
            }
            if (this.coJ != null) {
                this.coE.b(this.coJ);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget akm() {
        return new SwanAppWebViewWidget(this.chB.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.coE != null) {
            if (!TextUtils.isEmpty(dVar.amP)) {
                this.coE.lo(dVar.amP);
            }
            this.coE.ef(dVar.cWe);
            this.coE.loadUrl(dVar.mSrc);
            this.coE.d(dVar);
            if (dVar.cdd == null) {
                dVar.cdd = com.baidu.swan.apps.model.a.a.a.auZ();
            }
            if (this.coE.abB() != null) {
                this.coE.abB().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.coI != null) {
                this.coE.a(this.coI);
            }
            if (this.coJ != null) {
                this.coE.b(this.coJ);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.coE != null) {
            if (this.coH != null) {
                this.coH.b(this.coE);
            }
            if (this.coI != null) {
                this.coI = null;
            }
            if (this.coJ != null) {
                this.coJ = null;
            }
            c(this.cjS, this.coE.abB());
            this.coE.d(dVar);
            this.coE.destroy();
            this.coE = null;
            if (this.coF != null) {
                this.coF.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean abv() {
        if (this.coE == null || !this.coE.abB().canGoBack()) {
            return false;
        }
        this.coE.abB().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void abE() {
        com.baidu.swan.apps.media.b.he(this.clA);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.aoE().nj(this.clA);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        abw();
        super.destroy();
        com.baidu.swan.apps.t.a.apF().e(this);
        if (this.coG != null) {
            this.coG.destroy();
        }
        if (this.ccP != null) {
            this.ccP.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void abw() {
        SwanAppActivity ast = f.asJ().ast();
        if (ast != null) {
            w.forceHiddenSoftInput(ast, ast.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gC(int i) {
        abB().setVisibility(i);
        if (this.coG != null) {
            this.coG.kG(i);
        }
        if (abt() != null) {
            abt().setVisibility(i);
        }
        if (this.coE != null && this.coE.abB() != null) {
            com.baidu.swan.apps.scheme.actions.m.d abH = this.coE.abH();
            this.coE.abB().setVisibility(i == 0 && abH != null && !abH.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a abx() {
        return this.ccP;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.coH = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.coI = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: akn */
    public SwanAppWebViewWidget abu() {
        return this.coE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
            SwanAppSlaveManager.this.coL.bUX = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.coL.bUZ = System.currentTimeMillis();
            SwanAppSlaveManager.this.coL.bVd = "0";
            com.baidu.swan.apps.performance.a.f.awK().awL().aT(SwanAppSlaveManager.this.coL.bUZ);
            com.baidu.swan.apps.core.f.aT(SwanAppSlaveManager.this.coL.bUZ);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.coL.bUZ);
            }
            HybridUbcFlow ps = i.ps("startup");
            if (ps != null) {
                ps.bW("webviewComponent", "1");
                ps.bW("fmp_type", "0");
                ps.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppSlaveManager.this.coL.bUZ).a(UbcFlowEvent.RecordType.UPDATE)).awj();
                ps.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.coL.bUZ), " , fmpType=", SwanAppSlaveManager.this.coL.bVd, " , fmpTypeName=", SwanAppSlaveManager.this.coL.abQ());
                i.adk();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cZS = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.coL.bUY = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.awK().awL().bw(SwanAppSlaveManager.this.coL.bUY);
            final long abO = i.cID ? currentTimeMillis : SwanAppSlaveManager.this.coL.abO();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + abO + " , aligned search=" + i.cID);
            }
            final HybridUbcFlow pq = i.pq("startup");
            pq.f(new UbcFlowEvent("na_first_paint").bs(abO));
            if (SwanAppSlaveManager.this.coL.bUZ == 0) {
                SwanAppSlaveManager.this.coL.bUZ = abO;
                SwanAppSlaveManager.this.coL.bVd = SwanAppSlaveManager.this.coL.aN(abO);
                pq.bW("fmp_type", "1");
                pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppSlaveManager.this.coL.bUY));
            }
            long Zz = com.baidu.swan.apps.t.a.apx().Zz();
            if (Zz < 0) {
                Zz = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.cID) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.ee(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.coL.bUZ <= 0) {
                        j = abO;
                    } else {
                        j = SwanAppSlaveManager.this.coL.bUZ;
                    }
                    pq.bW("fmp_type", SwanAppSlaveManager.this.coL.bVd);
                    pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(j)).awj();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.coL.bVd + " , fmpTypeName=" + SwanAppSlaveManager.this.coL.abQ());
                    }
                }
            }, "fmp record", Zz, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.coL.bVa = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awK().awL().aU(SwanAppSlaveManager.this.coL.bVa);
            com.baidu.swan.apps.core.f.aU(SwanAppSlaveManager.this.coL.bVa);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.coL.bVa);
            }
            if (i.cID) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.ee(false);
            } else if (SwanAppSlaveManager.this.coL.bUZ == 0) {
                HybridUbcFlow pq = i.pq("startup");
                pq.bW("fmp_type", "2");
                pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppSlaveManager.this.coL.bVa));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.coL.bVb = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awK().awL().bv(SwanAppSlaveManager.this.coL.bVb);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.coL.bVb);
            }
            if (i.cID) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.ee(false);
            } else if (SwanAppSlaveManager.this.coL.bUZ == 0) {
                HybridUbcFlow pq = i.pq("startup");
                pq.bW("fmp_type", "3");
                pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppSlaveManager.this.coL.bVb));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ee(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.coL.toString());
        }
        this.coL.abP();
        long j = this.coL.bUZ;
        String str = this.coL.bVd;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.coL.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.coL.toString());
        }
        HybridUbcFlow pq = i.pq("startup");
        pq.bW("fmp_type", str);
        pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(j).a(UbcFlowEvent.RecordType.UPDATE));
        pq.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.coL.abQ());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.coL.abQ());
            }
            pq.awj();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.akC().eh(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void jc(String str) {
        this.coK = str;
        if (this.coE != null) {
            this.coE.jc(this.coK);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d abz() {
        return this.coL;
    }

    public void b(d dVar) {
        this.coJ = dVar;
    }
}
