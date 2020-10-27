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
    private static int cJn = 10;
    private FrameLayout cEG;
    private String cGo;
    private String cJo;
    private SwanAppWebViewWidget cJp;
    protected PullToRefreshNgWebView cJq;
    private com.baidu.swan.apps.view.narootview.a cJr;
    private e cJs;
    private d cJt;
    protected d cJu;
    protected String cJv;
    protected com.baidu.swan.apps.adaptation.b.a.d cJw;
    @Nullable
    private com.baidu.swan.apps.component.c.a cxH;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cCL = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void akH() {
        super.akH();
        aoP();
        l lVar = new l(this.cCx);
        lVar.f(this);
        this.cCx.a(lVar);
        this.cJw = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akE() {
        String agj = agj();
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(agj));
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(agj));
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(agj));
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(agj));
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(agj));
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(agj));
        this.cCs.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(agj));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.aul().c(this);
        if (this.cJp != null) {
            this.cJp.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aEU() != null) {
            com.baidu.swan.apps.runtime.e.aEU().aFl().fp(true);
        }
        aoQ();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.aul().d(this);
        if (this.cJp != null) {
            this.cJp.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aEU() != null) {
            com.baidu.swan.apps.runtime.e.aEU().aFl().fp(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cJp != null ? this.cJp.isSlidable(motionEvent) : this.cCs.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double afS() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.aiY()) {
            com.baidu.swan.apps.core.c.b.ale();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean age() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean afY() {
        return agh().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dov) {
                this.cJq = new PullToRefreshNgWebView(this.cCr.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                hl(SwanAppConfigData.fv(cVar.dou));
                a(this.cJq);
                a(frameLayout, this.cJq);
            } else {
                a(frameLayout, agh());
            }
            this.cEG = frameLayout;
            if (this.cJr == null) {
                this.cJr = new com.baidu.swan.apps.view.narootview.a(this.cCr.getBaseContext(), this, frameLayout);
            }
            if (this.cxH == null) {
                this.cxH = new com.baidu.swan.apps.component.c.a(this.cCr.getBaseContext(), this.cJr);
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
    public void ki(String str) {
        this.cJo = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String agg() {
        return this.cJo;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean hl(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cJq != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cJq.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.hl(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.hi(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cCs.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bt("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cJq.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.axo().a(SwanAppSlaveManager.this.agj(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView afZ() {
        if (this.cJq == null) {
            return null;
        }
        return this.cJq;
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

    private void aoP() {
        this.cGo = String.valueOf(cJn);
        cJn++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String agj() {
        return this.cGo;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cJp != null) {
            this.cJp.attachActivity(activity);
        }
    }

    private void aoQ() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.azt() && !com.baidu.swan.apps.menu.fontsize.b.azr()) {
            if (this.cJp != null && this.cJp.agh() != null) {
                ngWebView = this.cJp.agh();
            } else {
                ngWebView = this.cCs;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jn(com.baidu.swan.apps.menu.fontsize.b.azs()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cEG == null) {
            return false;
        }
        if (this.cJq != null) {
            this.cJq.fZ(false);
            this.cJq.setPullRefreshEnabled(false);
        }
        if (this.cJp == null) {
            if (DEBUG && !(this.cCr.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cJp = aoR();
            this.cJp.kh(this.cJv);
            this.cJp.np(this.cGo);
            if (!TextUtils.isEmpty(dVar.anz)) {
                this.cJp.mt(dVar.anz);
            }
            if (dVar.cxV == null) {
                dVar.cxV = com.baidu.swan.apps.model.a.a.a.azE();
            }
            a(this.cEG, this.cJp.agh());
            if (this.cJp.agh() != null) {
                this.cJp.agh().setVisibility(dVar.hidden ? 8 : 0);
                aoQ();
            }
            this.cJp.eO(dVar.dqN);
            this.cJp.loadUrl(dVar.mSrc);
            this.cJp.d(dVar);
            if (this.cJs != null) {
                this.cJs.a(this.cJp);
            }
            if (this.cJt != null) {
                this.cJp.a(this.cJt);
            }
            if (this.cJu != null) {
                this.cJp.b(this.cJu);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget aoR() {
        return new SwanAppWebViewWidget(this.cCr.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cJp != null) {
            if (!TextUtils.isEmpty(dVar.anz)) {
                this.cJp.mt(dVar.anz);
            }
            this.cJp.eO(dVar.dqN);
            this.cJp.loadUrl(dVar.mSrc);
            this.cJp.d(dVar);
            if (dVar.cxV == null) {
                dVar.cxV = com.baidu.swan.apps.model.a.a.a.azE();
            }
            if (this.cJp.agh() != null) {
                this.cJp.agh().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cJt != null) {
                this.cJp.a(this.cJt);
            }
            if (this.cJu != null) {
                this.cJp.b(this.cJu);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cJp != null) {
            if (this.cJs != null) {
                this.cJs.b(this.cJp);
            }
            if (this.cJt != null) {
                this.cJt = null;
            }
            if (this.cJu != null) {
                this.cJu = null;
            }
            c(this.cEG, this.cJp.agh());
            this.cJp.d(dVar);
            this.cJp.destroy();
            this.cJp = null;
            if (this.cJq != null) {
                this.cJq.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean agb() {
        if (this.cJp == null || !this.cJp.agh().canGoBack()) {
            return false;
        }
        this.cJp.agh().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void agk() {
        com.baidu.swan.apps.media.b.hD(this.cGo);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.atl().oq(this.cGo);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        agc();
        super.destroy();
        com.baidu.swan.apps.t.a.aul().e(this);
        if (this.cJr != null) {
            this.cJr.destroy();
        }
        if (this.cxH != null) {
            this.cxH.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void agc() {
        SwanAppActivity awY = f.axo().awY();
        if (awY != null) {
            w.forceHiddenSoftInput(awY, awY.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hk(int i) {
        agh().setVisibility(i);
        if (this.cJr != null) {
            this.cJr.lo(i);
        }
        if (afZ() != null) {
            afZ().setVisibility(i);
        }
        if (this.cJp != null && this.cJp.agh() != null) {
            com.baidu.swan.apps.scheme.actions.m.d agn = this.cJp.agn();
            this.cJp.agh().setVisibility(i == 0 && agn != null && !agn.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a agd() {
        return this.cxH;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cJs = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cJt = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: aoS */
    public SwanAppWebViewWidget aga() {
        return this.cJp;
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
            SwanAppSlaveManager.this.cJw.cpM = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cJw.cpO = System.currentTimeMillis();
            SwanAppSlaveManager.this.cJw.cpS = "0";
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bd(SwanAppSlaveManager.this.cJw.cpO);
            com.baidu.swan.apps.core.f.bd(SwanAppSlaveManager.this.cJw.cpO);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cJw.cpO);
            }
            HybridUbcFlow qx = i.qx("startup");
            if (qx != null) {
                qx.ci("webviewComponent", "1");
                qx.ci("fmp_type", "0");
                qx.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppSlaveManager.this.cJw.cpO).a(UbcFlowEvent.RecordType.UPDATE)).aAO();
                qx.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cJw.cpO), " , fmpType=", SwanAppSlaveManager.this.cJw.cpS, " , fmpTypeName=", SwanAppSlaveManager.this.cJw.agw());
                i.ahQ();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.duE = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.cJw.cpN = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bG(SwanAppSlaveManager.this.cJw.cpN);
            final long agu = i.ddf ? currentTimeMillis : SwanAppSlaveManager.this.cJw.agu();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + agu + " , aligned search=" + i.ddf);
            }
            final HybridUbcFlow qv = i.qv("startup");
            qv.f(new UbcFlowEvent("na_first_paint").bC(agu));
            if (SwanAppSlaveManager.this.cJw.cpO == 0) {
                SwanAppSlaveManager.this.cJw.cpO = agu;
                SwanAppSlaveManager.this.cJw.cpS = SwanAppSlaveManager.this.cJw.aX(agu);
                qv.ci("fmp_type", "1");
                qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppSlaveManager.this.cJw.cpN));
            }
            long aef = com.baidu.swan.apps.t.a.aud().aef();
            if (aef < 0) {
                aef = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.ddf) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.eN(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cJw.cpO <= 0) {
                        j = agu;
                    } else {
                        j = SwanAppSlaveManager.this.cJw.cpO;
                    }
                    qv.ci("fmp_type", SwanAppSlaveManager.this.cJw.cpS);
                    qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(j)).aAO();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cJw.cpS + " , fmpTypeName=" + SwanAppSlaveManager.this.cJw.agw());
                    }
                }
            }, "fmp record", aef, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cJw.cpP = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aBp().aBq().be(SwanAppSlaveManager.this.cJw.cpP);
            com.baidu.swan.apps.core.f.be(SwanAppSlaveManager.this.cJw.cpP);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cJw.cpP);
            }
            if (i.ddf) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.eN(false);
            } else if (SwanAppSlaveManager.this.cJw.cpO == 0) {
                HybridUbcFlow qv = i.qv("startup");
                qv.ci("fmp_type", "2");
                qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppSlaveManager.this.cJw.cpP));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cJw.cpQ = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bF(SwanAppSlaveManager.this.cJw.cpQ);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cJw.cpQ);
            }
            if (i.ddf) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.eN(false);
            } else if (SwanAppSlaveManager.this.cJw.cpO == 0) {
                HybridUbcFlow qv = i.qv("startup");
                qv.ci("fmp_type", "3");
                qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppSlaveManager.this.cJw.cpQ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eN(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cJw.toString());
        }
        this.cJw.agv();
        long j = this.cJw.cpO;
        String str = this.cJw.cpS;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cJw.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cJw.toString());
        }
        HybridUbcFlow qv = i.qv("startup");
        qv.ci("fmp_type", str);
        qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(j).a(UbcFlowEvent.RecordType.UPDATE));
        qv.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cJw.agw());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cJw.agw());
            }
            qv.aAO();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.aph().eQ(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void kh(String str) {
        this.cJv = str;
        if (this.cJp != null) {
            this.cJp.kh(this.cJv);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d agf() {
        return this.cJw;
    }

    public void b(d dVar) {
        this.cJu = dVar;
    }
}
