package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.t;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshNgWebView;
import com.baidu.swan.apps.core.f.d;
import com.baidu.swan.apps.core.f.e;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.l;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.y.f;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bPQ = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bGy;
    private FrameLayout bMh;
    private String bPR;
    private SwanAppWebViewWidget bPS;
    protected PullToRefreshNgWebView bPT;
    private com.baidu.swan.apps.view.narootview.a bPU;
    private e bPV;
    private d bPW;
    protected String bPX;
    protected com.baidu.swan.apps.adaptation.b.a.d bPY;
    protected Context mContext;

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bKS = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void UI() {
        super.UI();
        Yc();
        l lVar = new l(this.bKF);
        lVar.f(this);
        this.bKF.a(lVar);
        this.bPY = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UF() {
        this.bKA.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.e.b(QG()));
        this.bKA.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.a.b(QG()));
        this.bKA.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.c.b(QG()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.w.a.abZ().c(this);
        if (this.bPS != null) {
            this.bPS.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.akN() != null) {
            com.baidu.swan.apps.runtime.e.akN().alc().dN(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.w.a.abZ().d(this);
        if (this.bPS != null) {
            this.bPS.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.akN() != null) {
            com.baidu.swan.apps.runtime.e.akN().alc().dN(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.bPS != null ? this.bPS.isSlidable(motionEvent) : this.bKA.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.af
    public double Qr() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Tl()) {
            com.baidu.swan.apps.core.c.b.Vd();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        QE().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean QC() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Qw() {
        return QE().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(cVar.backgroundColor);
            if (cVar.cpk) {
                this.bPT = new PullToRefreshNgWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                eb(SwanAppConfigData.dA(cVar.cpj));
                a(this.bPT);
                a(frameLayout, this.bPT);
            } else {
                a(frameLayout, QE());
            }
            this.bMh = frameLayout;
            if (this.bPU == null) {
                this.bPU = new com.baidu.swan.apps.view.narootview.a(this.mContext, this, frameLayout);
            }
            if (this.bGy == null) {
                this.bGy = new com.baidu.swan.apps.component.c.a(this.mContext, this.bPU);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean eb(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.bPT != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.bPT.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.eb(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.k.b bVar) {
        if (bVar != null && a.b.dY(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.bKA.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.aG("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.bPT.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.aeK().a(SwanAppSlaveManager.this.QG(), new com.baidu.swan.apps.n.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView Qx() {
        if (this.bPT == null) {
            return null;
        }
        return this.bPT;
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

    private void Yc() {
        this.bPR = String.valueOf(bPQ);
        bPQ++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String QG() {
        return this.bPR;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.bMh == null) {
            return false;
        }
        if (this.bPT != null) {
            this.bPT.er(false);
            this.bPT.setPullRefreshEnabled(false);
        }
        if (this.bPS == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.bPS = bM(this.mActivity != null ? this.mActivity : this.mContext);
            this.bPS.gm(this.bPX);
            this.bPS.iG(this.bPR);
            if (dVar.bGM == null) {
                dVar.bGM = com.baidu.swan.apps.model.a.a.a.agF();
            }
            a(this.bMh, this.bPS.QE());
            if (this.bPS.QE() != null) {
                this.bPS.QE().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.bPS.loadUrl(dVar.mSrc);
            this.bPS.d(dVar);
            if (this.bPV != null) {
                this.bPV.a(this.bPS);
            }
            if (this.bPW != null) {
                this.bPS.a(this.bPW);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget bM(Context context) {
        return new SwanAppWebViewWidget(context);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bPS != null) {
            this.bPS.loadUrl(dVar.mSrc);
            this.bPS.d(dVar);
            if (dVar.bGM == null) {
                dVar.bGM = com.baidu.swan.apps.model.a.a.a.agF();
            }
            if (this.bPS.QE() != null) {
                this.bPS.QE().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bPS != null) {
            if (this.bPV != null) {
                this.bPV.b(this.bPS);
            }
            if (this.bPW != null) {
                this.bPW = null;
            }
            c(this.bMh, this.bPS.QE());
            this.bPS.d(dVar);
            this.bPS.destroy();
            this.bPS = null;
            if (this.bPT != null) {
                this.bPT.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Qz() {
        if (this.bPS == null || !this.bPS.QE().canGoBack()) {
            return false;
        }
        this.bPS.QE().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void QH() {
        com.baidu.swan.apps.media.b.destroy(this.bPR);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        QA();
        super.destroy();
        com.baidu.swan.apps.w.a.abZ().e(this);
        if (this.bPU != null) {
            this.bPU.destroy();
        }
        if (this.bGy != null) {
            this.bGy.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void QA() {
        SwanAppActivity aev = f.aeK().aev();
        if (aev != null) {
            t.forceHiddenSoftInput(aev, aev.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ea(int i) {
        QE().setVisibility(i);
        if (this.bPU != null) {
            this.bPU.hs(i);
        }
        if (Qx() != null) {
            Qx().setVisibility(i);
        }
        if (this.bPS != null && this.bPS.QE() != null) {
            com.baidu.swan.apps.scheme.actions.m.d QI = this.bPS.QI();
            this.bPS.QE().setVisibility(i == 0 && QI != null && !QI.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a QB() {
        return this.bGy;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.bPV = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bPW = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: Yd */
    public SwanAppWebViewWidget Qy() {
        return this.bPS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            SwanAppSlaveManager.this.bPY.bAc = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.bPY.bAe = System.currentTimeMillis();
            SwanAppSlaveManager.this.bPY.bAf = "0";
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cuE = SearchFlowEvent.EventType.END;
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
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppSlaveManager.this.bPY.bAd = currentTimeMillis;
            if (SwanAppSlaveManager.this.bPY.bAe == 0) {
                SwanAppSlaveManager.this.bPY.bAe = currentTimeMillis;
            }
            final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            lb.f(new UbcFlowEvent("na_first_paint").aZ(currentTimeMillis));
            long Po = com.baidu.swan.apps.w.a.abR().Po();
            if (Po < 0) {
                Po = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.bPY.bAe <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppSlaveManager.this.bPY.bAe;
                    }
                    lb.bk("fmp_type", SwanAppSlaveManager.this.bPY.bAf);
                    lb.f(new UbcFlowEvent("na_first_meaningful_paint").aZ(j)).ahM();
                }
            }, "fmp record", Po, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.k.d.Yo().dx(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gm(String str) {
        this.bPX = str;
        if (this.bPS != null) {
            this.bPS.gm(this.bPX);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d QD() {
        return this.bPY;
    }
}
