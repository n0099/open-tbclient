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
    private static int bPV = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bGD;
    private FrameLayout bMm;
    private String bPW;
    private SwanAppWebViewWidget bPX;
    protected PullToRefreshNgWebView bPY;
    private com.baidu.swan.apps.view.narootview.a bPZ;
    private e bQa;
    private d bQb;
    protected String bQc;
    protected com.baidu.swan.apps.adaptation.b.a.d bQd;
    protected Context mContext;

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bKX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void UH() {
        super.UH();
        Yb();
        l lVar = new l(this.bKK);
        lVar.f(this);
        this.bKK.a(lVar);
        this.bQd = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UE() {
        this.bKF.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.e.b(QF()));
        this.bKF.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.a.b(QF()));
        this.bKF.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.c.b(QF()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.w.a.abY().c(this);
        if (this.bPX != null) {
            this.bPX.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.akM() != null) {
            com.baidu.swan.apps.runtime.e.akM().alb().dN(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.w.a.abY().d(this);
        if (this.bPX != null) {
            this.bPX.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.akM() != null) {
            com.baidu.swan.apps.runtime.e.akM().alb().dN(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.bPX != null ? this.bPX.isSlidable(motionEvent) : this.bKF.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.af
    public double Qq() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Tk()) {
            com.baidu.swan.apps.core.c.b.Vc();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        QD().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean QB() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Qv() {
        return QD().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(cVar.backgroundColor);
            if (cVar.cpq) {
                this.bPY = new PullToRefreshNgWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                eb(SwanAppConfigData.dA(cVar.cpp));
                a(this.bPY);
                a(frameLayout, this.bPY);
            } else {
                a(frameLayout, QD());
            }
            this.bMm = frameLayout;
            if (this.bPZ == null) {
                this.bPZ = new com.baidu.swan.apps.view.narootview.a(this.mContext, this, frameLayout);
            }
            if (this.bGD == null) {
                this.bGD = new com.baidu.swan.apps.component.c.a(this.mContext, this.bPZ);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean eb(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.bPY != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.bPY.getHeaderLoadingLayout()) != null) {
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
            this.bKF.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.aG("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.bPY.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.aeJ().a(SwanAppSlaveManager.this.QF(), new com.baidu.swan.apps.n.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView Qw() {
        if (this.bPY == null) {
            return null;
        }
        return this.bPY;
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

    private void Yb() {
        this.bPW = String.valueOf(bPV);
        bPV++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String QF() {
        return this.bPW;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.bMm == null) {
            return false;
        }
        if (this.bPY != null) {
            this.bPY.er(false);
            this.bPY.setPullRefreshEnabled(false);
        }
        if (this.bPX == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.bPX = bA(this.mActivity != null ? this.mActivity : this.mContext);
            this.bPX.gm(this.bQc);
            this.bPX.iG(this.bPW);
            if (dVar.bGR == null) {
                dVar.bGR = com.baidu.swan.apps.model.a.a.a.agE();
            }
            a(this.bMm, this.bPX.QD());
            if (this.bPX.QD() != null) {
                this.bPX.QD().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.bPX.loadUrl(dVar.mSrc);
            this.bPX.d(dVar);
            if (this.bQa != null) {
                this.bQa.a(this.bPX);
            }
            if (this.bQb != null) {
                this.bPX.a(this.bQb);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget bA(Context context) {
        return new SwanAppWebViewWidget(context);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bPX != null) {
            this.bPX.loadUrl(dVar.mSrc);
            this.bPX.d(dVar);
            if (dVar.bGR == null) {
                dVar.bGR = com.baidu.swan.apps.model.a.a.a.agE();
            }
            if (this.bPX.QD() != null) {
                this.bPX.QD().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bPX != null) {
            if (this.bQa != null) {
                this.bQa.b(this.bPX);
            }
            if (this.bQb != null) {
                this.bQb = null;
            }
            c(this.bMm, this.bPX.QD());
            this.bPX.d(dVar);
            this.bPX.destroy();
            this.bPX = null;
            if (this.bPY != null) {
                this.bPY.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Qy() {
        if (this.bPX == null || !this.bPX.QD().canGoBack()) {
            return false;
        }
        this.bPX.QD().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void QG() {
        com.baidu.swan.apps.media.b.destroy(this.bPW);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        Qz();
        super.destroy();
        com.baidu.swan.apps.w.a.abY().e(this);
        if (this.bPZ != null) {
            this.bPZ.destroy();
        }
        if (this.bGD != null) {
            this.bGD.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void Qz() {
        SwanAppActivity aeu = f.aeJ().aeu();
        if (aeu != null) {
            t.forceHiddenSoftInput(aeu, aeu.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ea(int i) {
        QD().setVisibility(i);
        if (this.bPZ != null) {
            this.bPZ.hs(i);
        }
        if (Qw() != null) {
            Qw().setVisibility(i);
        }
        if (this.bPX != null && this.bPX.QD() != null) {
            com.baidu.swan.apps.scheme.actions.m.d QH = this.bPX.QH();
            this.bPX.QD().setVisibility(i == 0 && QH != null && !QH.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a QA() {
        return this.bGD;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.bQa = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bQb = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: Yc */
    public SwanAppWebViewWidget Qx() {
        return this.bPX;
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
            SwanAppSlaveManager.this.bQd.bAh = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.bQd.bAj = System.currentTimeMillis();
            SwanAppSlaveManager.this.bQd.bAk = "0";
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cuK = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.bQd.bAi = currentTimeMillis;
            if (SwanAppSlaveManager.this.bQd.bAj == 0) {
                SwanAppSlaveManager.this.bQd.bAj = currentTimeMillis;
            }
            final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            lb.f(new UbcFlowEvent("na_first_paint").aZ(currentTimeMillis));
            long Pn = com.baidu.swan.apps.w.a.abQ().Pn();
            if (Pn < 0) {
                Pn = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.bQd.bAj <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppSlaveManager.this.bQd.bAj;
                    }
                    lb.bk("fmp_type", SwanAppSlaveManager.this.bQd.bAk);
                    lb.f(new UbcFlowEvent("na_first_meaningful_paint").aZ(j)).ahL();
                }
            }, "fmp record", Pn, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.k.d.Yn().dx(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gm(String str) {
        this.bQc = str;
        if (this.bPX != null) {
            this.bPX.gm(this.bQc);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d QC() {
        return this.bQd;
    }
}
