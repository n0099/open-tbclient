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
    private static int brx = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bia;
    private FrameLayout bnO;
    protected PullToRefreshNgWebView brA;
    private com.baidu.swan.apps.view.narootview.a brB;
    private e brC;
    private d brD;
    protected String brE;
    protected com.baidu.swan.apps.adaptation.b.a.d brF;
    private String bry;
    private SwanAppWebViewWidget brz;
    protected Context mContext;

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bmy = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void MS() {
        super.MS();
        Qk();
        l lVar = new l(this.bmk);
        lVar.f(this);
        this.bmk.a(lVar);
        this.brF = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MP() {
        this.bmf.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.e.b(IR()));
        this.bmf.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.a.b(IR()));
        this.bmf.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.c.b(IR()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.w.a.Uh().c(this);
        if (this.brz != null) {
            this.brz.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.acF() != null) {
            com.baidu.swan.apps.runtime.e.acF().acU().cQ(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.w.a.Uh().d(this);
        if (this.brz != null) {
            this.brz.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.acF() != null) {
            com.baidu.swan.apps.runtime.e.acF().acU().cQ(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.brz != null ? this.brz.isSlidable(motionEvent) : this.bmf.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.af
    public double IC() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Lu()) {
            com.baidu.swan.apps.core.c.b.Nn();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        IP().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean IN() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean IH() {
        return IP().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(cVar.backgroundColor);
            if (cVar.bQn) {
                this.brA = new PullToRefreshNgWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                dW(SwanAppConfigData.cG(cVar.bQm));
                a(this.brA);
                a(frameLayout, this.brA);
            } else {
                a(frameLayout, IP());
            }
            this.bnO = frameLayout;
            if (this.brB == null) {
                this.brB = new com.baidu.swan.apps.view.narootview.a(this.mContext, this, frameLayout);
            }
            if (this.bia == null) {
                this.bia = new com.baidu.swan.apps.component.c.a(this.mContext, this.brB);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean dW(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.brA != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.brA.getHeaderLoadingLayout()) != null) {
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
            this.bmf.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.ay("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.brA.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.WS().a(SwanAppSlaveManager.this.IR(), new com.baidu.swan.apps.n.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView II() {
        if (this.brA == null) {
            return null;
        }
        return this.brA;
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

    private void Qk() {
        this.bry = String.valueOf(brx);
        brx++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IR() {
        return this.bry;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.bnO == null) {
            return false;
        }
        if (this.brA != null) {
            this.brA.du(false);
            this.brA.setPullRefreshEnabled(false);
        }
        if (this.brz == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.brz = bZ(this.mActivity != null ? this.mActivity : this.mContext);
            this.brz.fb(this.brE);
            this.brz.ht(this.bry);
            if (dVar.bir == null) {
                dVar.bir = com.baidu.swan.apps.model.a.a.a.Yw();
            }
            a(this.bnO, this.brz.IP());
            if (this.brz.IP() != null) {
                this.brz.IP().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.brz.loadUrl(dVar.mSrc);
            this.brz.d(dVar);
            if (this.brC != null) {
                this.brC.a(this.brz);
            }
            if (this.brD != null) {
                this.brz.a(this.brD);
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
        if (this.brz != null) {
            this.brz.loadUrl(dVar.mSrc);
            this.brz.d(dVar);
            if (dVar.bir == null) {
                dVar.bir = com.baidu.swan.apps.model.a.a.a.Yw();
            }
            if (this.brz.IP() != null) {
                this.brz.IP().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.brz != null) {
            if (this.brC != null) {
                this.brC.b(this.brz);
            }
            if (this.brD != null) {
                this.brD = null;
            }
            c(this.bnO, this.brz.IP());
            this.brz.d(dVar);
            this.brz.destroy();
            this.brz = null;
            if (this.brA != null) {
                this.brA.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean IK() {
        if (this.brz == null || !this.brz.IP().canGoBack()) {
            return false;
        }
        this.brz.IP().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void IS() {
        com.baidu.swan.apps.media.b.destroy(this.bry);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        IL();
        super.destroy();
        com.baidu.swan.apps.w.a.Uh().e(this);
        if (this.brB != null) {
            this.brB.destroy();
        }
        if (this.bia != null) {
            this.bia.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void IL() {
        SwanAppActivity WD = f.WS().WD();
        if (WD != null) {
            t.forceHiddenSoftInput(WD, WD.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void dV(int i) {
        IP().setVisibility(i);
        if (this.brB != null) {
            this.brB.hl(i);
        }
        if (II() != null) {
            II().setVisibility(i);
        }
        if (this.brz != null && this.brz.IP() != null) {
            com.baidu.swan.apps.scheme.actions.m.d IT = this.brz.IT();
            this.brz.IP().setVisibility(i == 0 && IT != null && !IT.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a IM() {
        return this.bia;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.brC = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.brD = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: Ql */
    public SwanAppWebViewWidget IJ() {
        return this.brz;
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
            SwanAppSlaveManager.this.brF.bbB = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.brF.bbD = System.currentTimeMillis();
            SwanAppSlaveManager.this.brF.bbE = "0";
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bVB = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.brF.bbC = currentTimeMillis;
            if (SwanAppSlaveManager.this.brF.bbD == 0) {
                SwanAppSlaveManager.this.brF.bbD = currentTimeMillis;
            }
            final HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            jP.f(new UbcFlowEvent("na_first_paint").au(currentTimeMillis));
            long Hw = com.baidu.swan.apps.w.a.TZ().Hw();
            if (Hw < 0) {
                Hw = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.brF.bbD <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppSlaveManager.this.brF.bbD;
                    }
                    jP.bb("fmp_type", SwanAppSlaveManager.this.brF.bbE);
                    jP.f(new UbcFlowEvent("na_first_meaningful_paint").au(j)).ZE();
                }
            }, "fmp record", Hw, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.k.d.Qw().cA(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void fb(String str) {
        this.brE = str;
        if (this.brz != null) {
            this.brz.fb(this.brE);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d IO() {
        return this.brF;
    }
}
