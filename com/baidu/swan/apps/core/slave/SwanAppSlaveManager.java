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
/* loaded from: classes25.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cUp = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cIL;
    private FrameLayout cPI;
    private String cRq;
    private String cUq;
    private SwanAppWebViewWidget cUr;
    protected PullToRefreshNgWebView cUs;
    private com.baidu.swan.apps.view.narootview.a cUt;
    private e cUu;
    private d cUv;
    protected d cUw;
    protected String cUx;
    protected com.baidu.swan.apps.adaptation.b.a.d cUy;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cNO = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void apH() {
        super.apH();
        atQ();
        l lVar = new l(this.cNA);
        lVar.f(this);
        this.cNA.a(lVar);
        this.cUy = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void apE() {
        String alj = alj();
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(alj));
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(alj));
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(alj));
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(alj));
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(alj));
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(alj));
        this.cNv.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(alj));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.azl().c(this);
        if (this.cUr != null) {
            this.cUr.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aJU() != null) {
            com.baidu.swan.apps.runtime.e.aJU().aKl().fQ(true);
        }
        atR();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.azl().d(this);
        if (this.cUr != null) {
            this.cUr.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aJU() != null) {
            com.baidu.swan.apps.runtime.e.aJU().aKl().fQ(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cUr != null ? this.cUr.isSlidable(motionEvent) : this.cNv.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double akS() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.anY()) {
            com.baidu.swan.apps.core.c.b.aqe();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ale() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean akY() {
        return alh().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dzI) {
                this.cUs = new PullToRefreshNgWebView(this.cNu.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                hP(SwanAppConfigData.sI(cVar.dzH));
                a(this.cUs);
                b(frameLayout, this.cUs);
            } else {
                b(frameLayout, alh());
            }
            this.cPI = frameLayout;
            if (this.cUt == null) {
                this.cUt = new com.baidu.swan.apps.view.narootview.a(this.cNu.getBaseContext(), this, frameLayout);
            }
            if (this.cIL == null) {
                this.cIL = new com.baidu.swan.apps.component.c.a(this.cNu.getBaseContext(), this.cUt);
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
    public void kY(String str) {
        this.cUq = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String alg() {
        return this.cUq;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean hP(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cUs != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cUs.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.hP(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.hM(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cNv.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bz("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cUs.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.aCp().a(SwanAppSlaveManager.this.alj(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView akZ() {
        if (this.cUs == null) {
            return null;
        }
        return this.cUs;
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

    private void atQ() {
        this.cRq = String.valueOf(cUp);
        cUp++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String alj() {
        return this.cRq;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cUr != null) {
            this.cUr.attachActivity(activity);
        }
    }

    private void atR() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aEu() && !com.baidu.swan.apps.menu.fontsize.b.aEs()) {
            if (this.cUr != null && this.cUr.alh() != null) {
                ngWebView = this.cUr.alh();
            } else {
                ngWebView = this.cNv;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jR(com.baidu.swan.apps.menu.fontsize.b.aEt()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cPI == null) {
            return false;
        }
        if (this.cUs != null) {
            this.cUs.gA(false);
            this.cUs.setPullRefreshEnabled(false);
        }
        if (this.cUr == null) {
            if (DEBUG && !(this.cNu.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cUr = atS();
            this.cUr.kX(this.cUx);
            this.cUr.og(this.cRq);
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cUr.nj(dVar.mUa);
            }
            if (dVar.cIZ == null) {
                dVar.cIZ = com.baidu.swan.apps.model.a.a.a.aEF();
            }
            b(this.cPI, this.cUr.alh());
            if (this.cUr.alh() != null) {
                this.cUr.alh().setVisibility(dVar.hidden ? 8 : 0);
                atR();
            }
            this.cUr.fp(dVar.dCa);
            this.cUr.loadUrl(dVar.mSrc);
            this.cUr.d(dVar);
            if (this.cUu != null) {
                this.cUu.a(this.cUr);
            }
            if (this.cUv != null) {
                this.cUr.a(this.cUv);
            }
            if (this.cUw != null) {
                this.cUr.b(this.cUw);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget atS() {
        return new SwanAppWebViewWidget(this.cNu.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cUr != null) {
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cUr.nj(dVar.mUa);
            }
            this.cUr.fp(dVar.dCa);
            this.cUr.loadUrl(dVar.mSrc);
            this.cUr.d(dVar);
            if (dVar.cIZ == null) {
                dVar.cIZ = com.baidu.swan.apps.model.a.a.a.aEF();
            }
            if (this.cUr.alh() != null) {
                this.cUr.alh().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cUv != null) {
                this.cUr.a(this.cUv);
            }
            if (this.cUw != null) {
                this.cUr.b(this.cUw);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cUr != null) {
            if (this.cUu != null) {
                this.cUu.b(this.cUr);
            }
            if (this.cUv != null) {
                this.cUv = null;
            }
            if (this.cUw != null) {
                this.cUw = null;
            }
            d(this.cPI, this.cUr.alh());
            this.cUr.d(dVar);
            this.cUr.destroy();
            this.cUr = null;
            if (this.cUs != null) {
                this.cUs.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean alb() {
        if (this.cUr == null || !this.cUr.alh().canGoBack()) {
            return false;
        }
        this.cUr.alh().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void alk() {
        com.baidu.swan.apps.media.b.ie(this.cRq);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.ayl().pf(this.cRq);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        alc();
        super.destroy();
        com.baidu.swan.apps.t.a.azl().e(this);
        if (this.cUt != null) {
            this.cUt.destroy();
        }
        if (this.cIL != null) {
            this.cIL.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void alc() {
        SwanAppActivity aBZ = f.aCp().aBZ();
        if (aBZ != null) {
            w.forceHiddenSoftInput(aBZ, aBZ.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hO(int i) {
        alh().setVisibility(i);
        if (this.cUt != null) {
            this.cUt.lS(i);
        }
        if (akZ() != null) {
            akZ().setVisibility(i);
        }
        if (this.cUr != null && this.cUr.alh() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aln = this.cUr.aln();
            this.cUr.alh().setVisibility(i == 0 && aln != null && !aln.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a ald() {
        return this.cIL;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cUu = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cUv = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: atT */
    public SwanAppWebViewWidget ala() {
        return this.cUr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
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
            SwanAppSlaveManager.this.cUy.cAS = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cUy.cAU = System.currentTimeMillis();
            SwanAppSlaveManager.this.cUy.cAY = "0";
            com.baidu.swan.apps.performance.a.f.aGp().aGq().bY(SwanAppSlaveManager.this.cUy.cAU);
            com.baidu.swan.apps.core.f.bY(SwanAppSlaveManager.this.cUy.cAU);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cUy.cAU);
            }
            HybridUbcFlow rm = i.rm("startup");
            if (rm != null) {
                rm.co("webviewComponent", "1");
                rm.co("fmp_type", "0");
                rm.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppSlaveManager.this.cUy.cAU).a(UbcFlowEvent.RecordType.UPDATE)).aFO();
                rm.q("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cUy.cAU), " , fmpType=", SwanAppSlaveManager.this.cUy.cAY, " , fmpTypeName=", SwanAppSlaveManager.this.cUy.alw());
                i.amQ();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dFO = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bt("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cUy.cAT = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aGp().aGq().cB(SwanAppSlaveManager.this.cUy.cAT);
            final long alu = i.dou ? currentTimeMillis : SwanAppSlaveManager.this.cUy.alu();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + alu + " , aligned search=" + i.dou);
            }
            final HybridUbcFlow rk = i.rk("startup");
            rk.f(new UbcFlowEvent("na_first_paint").cx(alu));
            if (SwanAppSlaveManager.this.cUy.cAU == 0) {
                SwanAppSlaveManager.this.cUy.cAU = alu;
                SwanAppSlaveManager.this.cUy.cAY = SwanAppSlaveManager.this.cUy.bS(alu);
                rk.co("fmp_type", "1");
                rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppSlaveManager.this.cUy.cAT));
            }
            long ajf = com.baidu.swan.apps.t.a.azd().ajf();
            if (ajf < 0) {
                ajf = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.dou) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.fo(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cUy.cAU <= 0) {
                        j = alu;
                    } else {
                        j = SwanAppSlaveManager.this.cUy.cAU;
                    }
                    rk.co("fmp_type", SwanAppSlaveManager.this.cUy.cAY);
                    rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(j)).aFO();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cUy.cAY + " , fmpTypeName=" + SwanAppSlaveManager.this.cUy.alw());
                    }
                }
            }, "fmp record", ajf, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cUy.cAV = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aGp().aGq().bZ(SwanAppSlaveManager.this.cUy.cAV);
            com.baidu.swan.apps.core.f.bZ(SwanAppSlaveManager.this.cUy.cAV);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cUy.cAV);
            }
            if (i.dou) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.fo(false);
            } else if (SwanAppSlaveManager.this.cUy.cAU == 0) {
                HybridUbcFlow rk = i.rk("startup");
                rk.co("fmp_type", "2");
                rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppSlaveManager.this.cUy.cAV));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cUy.cAW = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aGp().aGq().cA(SwanAppSlaveManager.this.cUy.cAW);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cUy.cAW);
            }
            if (i.dou) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.fo(false);
            } else if (SwanAppSlaveManager.this.cUy.cAU == 0) {
                HybridUbcFlow rk = i.rk("startup");
                rk.co("fmp_type", "3");
                rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppSlaveManager.this.cUy.cAW));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void fo(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cUy.toString());
        }
        this.cUy.alv();
        long j = this.cUy.cAU;
        String str = this.cUy.cAY;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cUy.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cUy.toString());
        }
        HybridUbcFlow rk = i.rk("startup");
        rk.co("fmp_type", str);
        rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(j).a(UbcFlowEvent.RecordType.UPDATE));
        rk.q("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cUy.alw());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cUy.alw());
            }
            rk.aFO();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.aui().fr(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void kX(String str) {
        this.cUx = str;
        if (this.cUr != null) {
            this.cUr.kX(this.cUx);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d alf() {
        return this.cUy;
    }

    public void b(d dVar) {
        this.cUw = dVar;
    }
}
