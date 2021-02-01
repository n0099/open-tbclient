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
/* loaded from: classes9.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cWM = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cLg;
    private FrameLayout cSg;
    private String cTO;
    private String cWN;
    private SwanAppWebViewWidget cWO;
    protected PullToRefreshNgWebView cWP;
    private com.baidu.swan.apps.view.narootview.a cWQ;
    private e cWR;
    private d cWS;
    protected d cWT;
    protected String cWU;
    protected com.baidu.swan.apps.adaptation.b.a.d cWV;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cQl = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void anx() {
        super.anx();
        arL();
        l lVar = new l(this.cPX);
        lVar.f(this);
        this.cPX.a(lVar);
        this.cWV = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anu() {
        String aiY = aiY();
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aiY));
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aiY));
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aiY));
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aiY));
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aiY));
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aiY));
        this.cPS.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aiY));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.axh().c(this);
        if (this.cWO != null) {
            this.cWO.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aIK() != null) {
            com.baidu.swan.apps.runtime.e.aIK().aJb().fX(true);
        }
        arM();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.axh().d(this);
        if (this.cWO != null) {
            this.cWO.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aIK() != null) {
            com.baidu.swan.apps.runtime.e.aIK().aJb().fX(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cWO != null ? this.cWO.isSlidable(motionEvent) : this.cPS.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double aiH() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.alO()) {
            com.baidu.swan.apps.core.c.b.anU();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiT() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiN() {
        return aiW().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dFF) {
                this.cWP = new PullToRefreshNgWebView(this.cPR.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                gf(SwanAppConfigData.rM(cVar.dFE));
                a(this.cWP);
                b(frameLayout, this.cWP);
            } else {
                b(frameLayout, aiW());
            }
            this.cSg = frameLayout;
            if (this.cWQ == null) {
                this.cWQ = new com.baidu.swan.apps.view.narootview.a(this.cPR.getBaseContext(), this, frameLayout);
            }
            if (this.cLg == null) {
                this.cLg = new com.baidu.swan.apps.component.c.a(this.cPR.getBaseContext(), this.cWQ);
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
    public void jY(String str) {
        this.cWN = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aiV() {
        return this.cWN;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean gf(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cWP != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cWP.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.gf(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.gc(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cPS.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.br("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cWP.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.aAl().a(SwanAppSlaveManager.this.aiY(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView aiO() {
        if (this.cWP == null) {
            return null;
        }
        return this.cWP;
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

    private void arL() {
        this.cTO = String.valueOf(cWM);
        cWM++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiY() {
        return this.cTO;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cWO != null) {
            this.cWO.attachActivity(activity);
        }
    }

    private void arM() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aCr() && !com.baidu.swan.apps.menu.fontsize.b.aCp()) {
            if (this.cWO != null && this.cWO.aiW() != null) {
                ngWebView = this.cWO.aiW();
            } else {
                ngWebView = this.cPS;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.ij(com.baidu.swan.apps.menu.fontsize.b.aCq()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cSg == null) {
            return false;
        }
        if (this.cWP != null) {
            this.cWP.gH(false);
            this.cWP.setPullRefreshEnabled(false);
        }
        if (this.cWO == null) {
            if (DEBUG && !(this.cPR.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cWO = arN();
            this.cWO.jX(this.cWU);
            this.cWO.nf(this.cTO);
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cWO.mj(dVar.mUa);
            }
            if (dVar.cLu == null) {
                dVar.cLu = com.baidu.swan.apps.model.a.a.a.aCC();
            }
            b(this.cSg, this.cWO.aiW());
            if (this.cWO.aiW() != null) {
                this.cWO.aiW().setVisibility(dVar.hidden ? 8 : 0);
                arM();
            }
            this.cWO.fw(dVar.dHX);
            this.cWO.loadUrl(dVar.mSrc);
            this.cWO.d(dVar);
            if (this.cWR != null) {
                this.cWR.a(this.cWO);
            }
            if (this.cWS != null) {
                this.cWO.a(this.cWS);
            }
            if (this.cWT != null) {
                this.cWO.b(this.cWT);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget arN() {
        return new SwanAppWebViewWidget(this.cPR.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cWO != null) {
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cWO.mj(dVar.mUa);
            }
            this.cWO.fw(dVar.dHX);
            this.cWO.loadUrl(dVar.mSrc);
            this.cWO.d(dVar);
            if (dVar.cLu == null) {
                dVar.cLu = com.baidu.swan.apps.model.a.a.a.aCC();
            }
            if (this.cWO.aiW() != null) {
                this.cWO.aiW().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cWS != null) {
                this.cWO.a(this.cWS);
            }
            if (this.cWT != null) {
                this.cWO.b(this.cWT);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cWO != null) {
            if (this.cWR != null) {
                this.cWR.b(this.cWO);
            }
            if (this.cWS != null) {
                this.cWS = null;
            }
            if (this.cWT != null) {
                this.cWT = null;
            }
            d(this.cSg, this.cWO.aiW());
            this.cWO.d(dVar);
            this.cWO.destroy();
            this.cWO = null;
            if (this.cWP != null) {
                this.cWP.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiQ() {
        if (this.cWO == null || !this.cWO.aiW().canGoBack()) {
            return false;
        }
        this.cWO.aiW().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiZ() {
        com.baidu.swan.apps.media.b.hc(this.cTO);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.awh().od(this.cTO);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        aiR();
        super.destroy();
        com.baidu.swan.apps.t.a.axh().e(this);
        if (this.cWQ != null) {
            this.cWQ.destroy();
        }
        if (this.cLg != null) {
            this.cLg.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void aiR() {
        SwanAppActivity azV = f.aAl().azV();
        if (azV != null) {
            w.forceHiddenSoftInput(azV, azV.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ge(int i) {
        aiW().setVisibility(i);
        if (this.cWQ != null) {
            this.cWQ.kw(i);
        }
        if (aiO() != null) {
            aiO().setVisibility(i);
        }
        if (this.cWO != null && this.cWO.aiW() != null) {
            com.baidu.swan.apps.scheme.actions.m.d ajc = this.cWO.ajc();
            this.cWO.aiW().setVisibility(i == 0 && ajc != null && !ajc.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aiS() {
        return this.cLg;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cWR = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cWS = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: arO */
    public SwanAppWebViewWidget aiP() {
        return this.cWO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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
            SwanAppSlaveManager.this.cWV.cDs = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cWV.cDu = System.currentTimeMillis();
            SwanAppSlaveManager.this.cWV.cDy = "0";
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cf(SwanAppSlaveManager.this.cWV.cDu);
            com.baidu.swan.apps.core.f.cf(SwanAppSlaveManager.this.cWV.cDu);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cWV.cDu);
            }
            HybridUbcFlow qm = i.qm("startup");
            if (qm != null) {
                qm.cg("webviewComponent", "1");
                qm.cg("fmp_type", "0");
                qm.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cWV.cDu).a(UbcFlowEvent.RecordType.UPDATE)).aDL();
                qm.o("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cWV.cDu), " , fmpType=", SwanAppSlaveManager.this.cWV.cDy, " , fmpTypeName=", SwanAppSlaveManager.this.cWV.ajl());
                i.akF();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dLK = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.cWV.cDt = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cI(SwanAppSlaveManager.this.cWV.cDt);
            final long ajj = i.dqO ? currentTimeMillis : SwanAppSlaveManager.this.cWV.ajj();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + ajj + " , aligned search=" + i.dqO);
            }
            final HybridUbcFlow qk = i.qk("startup");
            qk.f(new UbcFlowEvent("na_first_paint").cE(ajj));
            if (SwanAppSlaveManager.this.cWV.cDu == 0) {
                SwanAppSlaveManager.this.cWV.cDu = ajj;
                SwanAppSlaveManager.this.cWV.cDy = SwanAppSlaveManager.this.cWV.bZ(ajj);
                qk.cg("fmp_type", "1");
                qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cWV.cDt));
            }
            long agS = com.baidu.swan.apps.t.a.awZ().agS();
            if (agS < 0) {
                agS = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.dqO) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.fv(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cWV.cDu <= 0) {
                        j = ajj;
                    } else {
                        j = SwanAppSlaveManager.this.cWV.cDu;
                    }
                    qk.cg("fmp_type", SwanAppSlaveManager.this.cWV.cDy);
                    qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(j)).aDL();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cWV.cDy + " , fmpTypeName=" + SwanAppSlaveManager.this.cWV.ajl());
                    }
                }
            }, "fmp record", agS, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cWV.cDv = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cg(SwanAppSlaveManager.this.cWV.cDv);
            com.baidu.swan.apps.core.f.cg(SwanAppSlaveManager.this.cWV.cDv);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cWV.cDv);
            }
            if (i.dqO) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.fv(false);
            } else if (SwanAppSlaveManager.this.cWV.cDu == 0) {
                HybridUbcFlow qk = i.qk("startup");
                qk.cg("fmp_type", "2");
                qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cWV.cDv));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cWV.cDw = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cH(SwanAppSlaveManager.this.cWV.cDw);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cWV.cDw);
            }
            if (i.dqO) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.fv(false);
            } else if (SwanAppSlaveManager.this.cWV.cDu == 0) {
                HybridUbcFlow qk = i.qk("startup");
                qk.cg("fmp_type", "3");
                qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppSlaveManager.this.cWV.cDw));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void fv(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cWV.toString());
        }
        this.cWV.ajk();
        long j = this.cWV.cDu;
        String str = this.cWV.cDy;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cWV.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cWV.toString());
        }
        HybridUbcFlow qk = i.qk("startup");
        qk.cg("fmp_type", str);
        qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(j).a(UbcFlowEvent.RecordType.UPDATE));
        qk.o("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cWV.ajl());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cWV.ajl());
            }
            qk.aDL();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.ase().fy(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void jX(String str) {
        this.cWU = str;
        if (this.cWO != null) {
            this.cWO.jX(this.cWU);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d aiU() {
        return this.cWV;
    }

    public void b(d dVar) {
        this.cWT = dVar;
    }
}
