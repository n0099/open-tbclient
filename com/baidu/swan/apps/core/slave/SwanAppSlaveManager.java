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
    private static int brv = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bhY;
    private FrameLayout bnM;
    private e brA;
    private d brB;
    protected String brC;
    protected com.baidu.swan.apps.adaptation.b.a.d brD;
    private String brw;
    private SwanAppWebViewWidget brx;
    protected PullToRefreshNgWebView bry;
    private com.baidu.swan.apps.view.narootview.a brz;
    protected Context mContext;

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bmw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void MQ() {
        super.MQ();
        Qi();
        l lVar = new l(this.bmi);
        lVar.f(this);
        this.bmi.a(lVar);
        this.brD = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MN() {
        this.bmd.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.e.b(IP()));
        this.bmd.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.a.b(IP()));
        this.bmd.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.c.b(IP()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.w.a.Uf().c(this);
        if (this.brx != null) {
            this.brx.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.acD() != null) {
            com.baidu.swan.apps.runtime.e.acD().acS().cQ(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.w.a.Uf().d(this);
        if (this.brx != null) {
            this.brx.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.acD() != null) {
            com.baidu.swan.apps.runtime.e.acD().acS().cQ(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.brx != null ? this.brx.isSlidable(motionEvent) : this.bmd.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.af
    public double IA() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Ls()) {
            com.baidu.swan.apps.core.c.b.Nl();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        IN().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean IL() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean IF() {
        return IN().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(cVar.backgroundColor);
            if (cVar.bQl) {
                this.bry = new PullToRefreshNgWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                dW(SwanAppConfigData.cG(cVar.bQk));
                a(this.bry);
                a(frameLayout, this.bry);
            } else {
                a(frameLayout, IN());
            }
            this.bnM = frameLayout;
            if (this.brz == null) {
                this.brz = new com.baidu.swan.apps.view.narootview.a(this.mContext, this, frameLayout);
            }
            if (this.bhY == null) {
                this.bhY = new com.baidu.swan.apps.component.c.a(this.mContext, this.brz);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean dW(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.bry != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.bry.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.dW(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.k.b bVar) {
        if (bVar != null && a.b.dT(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.bmd.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.ay("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.bry.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.WQ().a(SwanAppSlaveManager.this.IP(), new com.baidu.swan.apps.n.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView IG() {
        if (this.bry == null) {
            return null;
        }
        return this.bry;
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

    private void Qi() {
        this.brw = String.valueOf(brv);
        brv++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IP() {
        return this.brw;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.bnM == null) {
            return false;
        }
        if (this.bry != null) {
            this.bry.du(false);
            this.bry.setPullRefreshEnabled(false);
        }
        if (this.brx == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.brx = bZ(this.mActivity != null ? this.mActivity : this.mContext);
            this.brx.fb(this.brC);
            this.brx.ht(this.brw);
            if (dVar.bip == null) {
                dVar.bip = com.baidu.swan.apps.model.a.a.a.Yu();
            }
            a(this.bnM, this.brx.IN());
            if (this.brx.IN() != null) {
                this.brx.IN().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.brx.loadUrl(dVar.mSrc);
            this.brx.d(dVar);
            if (this.brA != null) {
                this.brA.a(this.brx);
            }
            if (this.brB != null) {
                this.brx.a(this.brB);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget bZ(Context context) {
        return new SwanAppWebViewWidget(context);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.brx != null) {
            this.brx.loadUrl(dVar.mSrc);
            this.brx.d(dVar);
            if (dVar.bip == null) {
                dVar.bip = com.baidu.swan.apps.model.a.a.a.Yu();
            }
            if (this.brx.IN() != null) {
                this.brx.IN().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.brx != null) {
            if (this.brA != null) {
                this.brA.b(this.brx);
            }
            if (this.brB != null) {
                this.brB = null;
            }
            c(this.bnM, this.brx.IN());
            this.brx.d(dVar);
            this.brx.destroy();
            this.brx = null;
            if (this.bry != null) {
                this.bry.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean II() {
        if (this.brx == null || !this.brx.IN().canGoBack()) {
            return false;
        }
        this.brx.IN().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void IQ() {
        com.baidu.swan.apps.media.b.destroy(this.brw);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        IJ();
        super.destroy();
        com.baidu.swan.apps.w.a.Uf().e(this);
        if (this.brz != null) {
            this.brz.destroy();
        }
        if (this.bhY != null) {
            this.bhY.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void IJ() {
        SwanAppActivity WB = f.WQ().WB();
        if (WB != null) {
            t.forceHiddenSoftInput(WB, WB.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void dV(int i) {
        IN().setVisibility(i);
        if (this.brz != null) {
            this.brz.hl(i);
        }
        if (IG() != null) {
            IG().setVisibility(i);
        }
        if (this.brx != null && this.brx.IN() != null) {
            com.baidu.swan.apps.scheme.actions.m.d IR = this.brx.IR();
            this.brx.IN().setVisibility(i == 0 && IR != null && !IR.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a IK() {
        return this.bhY;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.brA = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.brB = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: Qj */
    public SwanAppWebViewWidget IH() {
        return this.brx;
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
            SwanAppSlaveManager.this.brD.bbz = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.brD.bbB = System.currentTimeMillis();
            SwanAppSlaveManager.this.brD.bbC = "0";
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bVz = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.brD.bbA = currentTimeMillis;
            if (SwanAppSlaveManager.this.brD.bbB == 0) {
                SwanAppSlaveManager.this.brD.bbB = currentTimeMillis;
            }
            final HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            jP.f(new UbcFlowEvent("na_first_paint").au(currentTimeMillis));
            long Hu = com.baidu.swan.apps.w.a.TX().Hu();
            if (Hu < 0) {
                Hu = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.brD.bbB <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppSlaveManager.this.brD.bbB;
                    }
                    jP.bb("fmp_type", SwanAppSlaveManager.this.brD.bbC);
                    jP.f(new UbcFlowEvent("na_first_meaningful_paint").au(j)).ZC();
                }
            }, "fmp record", Hu, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.k.d.Qu().cA(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void fb(String str) {
        this.brC = str;
        if (this.brx != null) {
            this.brx.fb(this.brC);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d IM() {
        return this.brD;
    }
}
