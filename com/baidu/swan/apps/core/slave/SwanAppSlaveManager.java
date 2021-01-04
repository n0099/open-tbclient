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
    private static int cZl = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cNE;
    private FrameLayout cUF;
    private String cWn;
    private String cZm;
    private SwanAppWebViewWidget cZn;
    protected PullToRefreshNgWebView cZo;
    private com.baidu.swan.apps.view.narootview.a cZp;
    private e cZq;
    private d cZr;
    protected d cZs;
    protected String cZt;
    protected com.baidu.swan.apps.adaptation.b.a.d cZu;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cSJ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void aqT() {
        super.aqT();
        avh();
        l lVar = new l(this.cSv);
        lVar.f(this);
        this.cSv.a(lVar);
        this.cZu = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqQ() {
        String amt = amt();
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(amt));
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(amt));
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(amt));
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(amt));
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(amt));
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(amt));
        this.cSq.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(amt));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.aAC().c(this);
        if (this.cZn != null) {
            this.cZn.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aMk() != null) {
            com.baidu.swan.apps.runtime.e.aMk().aMB().fZ(true);
        }
        avi();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.aAC().d(this);
        if (this.cZn != null) {
            this.cZn.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aMk() != null) {
            com.baidu.swan.apps.runtime.e.aMk().aMB().fZ(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cZn != null ? this.cZn.isSlidable(motionEvent) : this.cSq.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double amc() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.apk()) {
            com.baidu.swan.apps.core.c.b.arq();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean amo() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ami() {
        return amr().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dIn) {
                this.cZo = new PullToRefreshNgWebView(this.cSp.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                hJ(SwanAppConfigData.sF(cVar.dIm));
                a(this.cZo);
                b(frameLayout, this.cZo);
            } else {
                b(frameLayout, amr());
            }
            this.cUF = frameLayout;
            if (this.cZp == null) {
                this.cZp = new com.baidu.swan.apps.view.narootview.a(this.cSp.getBaseContext(), this, frameLayout);
            }
            if (this.cNE == null) {
                this.cNE = new com.baidu.swan.apps.component.c.a(this.cSp.getBaseContext(), this.cZp);
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
    public void kR(String str) {
        this.cZm = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String amq() {
        return this.cZm;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean hJ(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cZo != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cZo.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.hJ(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.hG(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cSq.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.by("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cZo.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.aDG().a(SwanAppSlaveManager.this.amt(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView amj() {
        if (this.cZo == null) {
            return null;
        }
        return this.cZo;
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

    private void avh() {
        this.cWn = String.valueOf(cZl);
        cZl++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String amt() {
        return this.cWn;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cZn != null) {
            this.cZn.attachActivity(activity);
        }
    }

    private void avi() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aFN() && !com.baidu.swan.apps.menu.fontsize.b.aFL()) {
            if (this.cZn != null && this.cZn.amr() != null) {
                ngWebView = this.cZn.amr();
            } else {
                ngWebView = this.cSq;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.jM(com.baidu.swan.apps.menu.fontsize.b.aFM()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cUF == null) {
            return false;
        }
        if (this.cZo != null) {
            this.cZo.gJ(false);
            this.cZo.setPullRefreshEnabled(false);
        }
        if (this.cZn == null) {
            if (DEBUG && !(this.cSp.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cZn = avj();
            this.cZn.kQ(this.cZt);
            this.cZn.nY(this.cWn);
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cZn.nc(dVar.mUa);
            }
            if (dVar.cNS == null) {
                dVar.cNS = com.baidu.swan.apps.model.a.a.a.aFY();
            }
            b(this.cUF, this.cZn.amr());
            if (this.cZn.amr() != null) {
                this.cZn.amr().setVisibility(dVar.hidden ? 8 : 0);
                avi();
            }
            this.cZn.fy(dVar.dKF);
            this.cZn.loadUrl(dVar.mSrc);
            this.cZn.d(dVar);
            if (this.cZq != null) {
                this.cZq.a(this.cZn);
            }
            if (this.cZr != null) {
                this.cZn.a(this.cZr);
            }
            if (this.cZs != null) {
                this.cZn.b(this.cZs);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget avj() {
        return new SwanAppWebViewWidget(this.cSp.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cZn != null) {
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cZn.nc(dVar.mUa);
            }
            this.cZn.fy(dVar.dKF);
            this.cZn.loadUrl(dVar.mSrc);
            this.cZn.d(dVar);
            if (dVar.cNS == null) {
                dVar.cNS = com.baidu.swan.apps.model.a.a.a.aFY();
            }
            if (this.cZn.amr() != null) {
                this.cZn.amr().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cZr != null) {
                this.cZn.a(this.cZr);
            }
            if (this.cZs != null) {
                this.cZn.b(this.cZs);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cZn != null) {
            if (this.cZq != null) {
                this.cZq.b(this.cZn);
            }
            if (this.cZr != null) {
                this.cZr = null;
            }
            if (this.cZs != null) {
                this.cZs = null;
            }
            d(this.cUF, this.cZn.amr());
            this.cZn.d(dVar);
            this.cZn.destroy();
            this.cZn = null;
            if (this.cZo != null) {
                this.cZo.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aml() {
        if (this.cZn == null || !this.cZn.amr().canGoBack()) {
            return false;
        }
        this.cZn.amr().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void amu() {
        com.baidu.swan.apps.media.b.hP(this.cWn);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.azC().oY(this.cWn);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        amm();
        super.destroy();
        com.baidu.swan.apps.t.a.aAC().e(this);
        if (this.cZp != null) {
            this.cZp.destroy();
        }
        if (this.cNE != null) {
            this.cNE.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void amm() {
        SwanAppActivity aDq = f.aDG().aDq();
        if (aDq != null) {
            w.forceHiddenSoftInput(aDq, aDq.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hI(int i) {
        amr().setVisibility(i);
        if (this.cZp != null) {
            this.cZp.lZ(i);
        }
        if (amj() != null) {
            amj().setVisibility(i);
        }
        if (this.cZn != null && this.cZn.amr() != null) {
            com.baidu.swan.apps.scheme.actions.m.d amx = this.cZn.amx();
            this.cZn.amr().setVisibility(i == 0 && amx != null && !amx.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a amn() {
        return this.cNE;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cZq = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cZr = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: avk */
    public SwanAppWebViewWidget amk() {
        return this.cZn;
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
            SwanAppSlaveManager.this.cZu.cFI = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cZu.cFK = System.currentTimeMillis();
            SwanAppSlaveManager.this.cZu.cFO = "0";
            com.baidu.swan.apps.performance.a.f.aHI().aHJ().bZ(SwanAppSlaveManager.this.cZu.cFK);
            com.baidu.swan.apps.core.f.bZ(SwanAppSlaveManager.this.cZu.cFK);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cZu.cFK);
            }
            HybridUbcFlow rf = i.rf("startup");
            if (rf != null) {
                rf.cn("webviewComponent", "1");
                rf.cn("fmp_type", "0");
                rf.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cZu.cFK).a(UbcFlowEvent.RecordType.UPDATE)).aHi();
                rf.q("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cZu.cFK), " , fmpType=", SwanAppSlaveManager.this.cZu.cFO, " , fmpTypeName=", SwanAppSlaveManager.this.cZu.amG());
                i.aoa();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dOs = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.bs("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cZu.cFJ = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aHI().aHJ().cC(SwanAppSlaveManager.this.cZu.cFJ);
            final long amE = i.dtt ? currentTimeMillis : SwanAppSlaveManager.this.cZu.amE();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + amE + " , aligned search=" + i.dtt);
            }
            final HybridUbcFlow rd = i.rd("startup");
            rd.f(new UbcFlowEvent("na_first_paint").cy(amE));
            if (SwanAppSlaveManager.this.cZu.cFK == 0) {
                SwanAppSlaveManager.this.cZu.cFK = amE;
                SwanAppSlaveManager.this.cZu.cFO = SwanAppSlaveManager.this.cZu.bT(amE);
                rd.cn("fmp_type", "1");
                rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cZu.cFJ));
            }
            long akn = com.baidu.swan.apps.t.a.aAu().akn();
            if (akn < 0) {
                akn = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.dtt) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.fx(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cZu.cFK <= 0) {
                        j = amE;
                    } else {
                        j = SwanAppSlaveManager.this.cZu.cFK;
                    }
                    rd.cn("fmp_type", SwanAppSlaveManager.this.cZu.cFO);
                    rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(j)).aHi();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cZu.cFO + " , fmpTypeName=" + SwanAppSlaveManager.this.cZu.amG());
                    }
                }
            }, "fmp record", akn, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cZu.cFL = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aHI().aHJ().ca(SwanAppSlaveManager.this.cZu.cFL);
            com.baidu.swan.apps.core.f.ca(SwanAppSlaveManager.this.cZu.cFL);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cZu.cFL);
            }
            if (i.dtt) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.fx(false);
            } else if (SwanAppSlaveManager.this.cZu.cFK == 0) {
                HybridUbcFlow rd = i.rd("startup");
                rd.cn("fmp_type", "2");
                rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cZu.cFL));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cZu.cFM = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aHI().aHJ().cB(SwanAppSlaveManager.this.cZu.cFM);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cZu.cFM);
            }
            if (i.dtt) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.fx(false);
            } else if (SwanAppSlaveManager.this.cZu.cFK == 0) {
                HybridUbcFlow rd = i.rd("startup");
                rd.cn("fmp_type", "3");
                rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cZu.cFM));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void fx(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cZu.toString());
        }
        this.cZu.amF();
        long j = this.cZu.cFK;
        String str = this.cZu.cFO;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cZu.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cZu.toString());
        }
        HybridUbcFlow rd = i.rd("startup");
        rd.cn("fmp_type", str);
        rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(j).a(UbcFlowEvent.RecordType.UPDATE));
        rd.q("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cZu.amG());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cZu.amG());
            }
            rd.aHi();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.avA().fA(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void kQ(String str) {
        this.cZt = str;
        if (this.cZn != null) {
            this.cZn.kQ(this.cZt);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d amp() {
        return this.cZu;
    }

    public void b(d dVar) {
        this.cZs = dVar;
    }
}
