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
/* loaded from: classes10.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bnm = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bdL;
    private FrameLayout bjC;
    private String bnn;
    private SwanAppWebViewWidget bno;
    protected PullToRefreshNgWebView bnp;
    private com.baidu.swan.apps.view.narootview.a bnq;
    private e bnr;
    private d bns;
    protected String bnt;
    protected com.baidu.swan.apps.adaptation.b.a.d bnu;
    protected Context mContext;

    public SwanAppSlaveManager(Context context) {
        super(context);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bil = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void KB() {
        super.KB();
        NU();
        l lVar = new l(this.bhW);
        lVar.f(this);
        this.bhW.a(lVar);
        this.bnu = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Ky() {
        this.bhR.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.e.b(GA()));
        this.bhR.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.a.b(GA()));
        this.bhR.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.r.c.b(GA()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.w.a.RR().c(this);
        if (this.bno != null) {
            this.bno.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aap() != null) {
            com.baidu.swan.apps.runtime.e.aap().aaE().cJ(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.w.a.RR().d(this);
        if (this.bno != null) {
            this.bno.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aap() != null) {
            com.baidu.swan.apps.runtime.e.aap().aaE().cJ(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.bno != null ? this.bno.isSlidable(motionEvent) : this.bhR.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.af
    public double Gl() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.Jd()) {
            com.baidu.swan.apps.core.c.b.KW();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Gy().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Gw() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Gq() {
        return Gy().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(cVar.backgroundColor);
            if (cVar.bMg) {
                this.bnp = new PullToRefreshNgWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                dG(SwanAppConfigData.cy(cVar.bMf));
                a(this.bnp);
                a(frameLayout, this.bnp);
            } else {
                a(frameLayout, Gy());
            }
            this.bjC = frameLayout;
            if (this.bnq == null) {
                this.bnq = new com.baidu.swan.apps.view.narootview.a(this.mContext, this, frameLayout);
            }
            if (this.bdL == null) {
                this.bdL = new com.baidu.swan.apps.component.c.a(this.mContext, this.bnq);
            }
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean dG(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.bnp != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.bnp.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.dG(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.k.b bVar) {
        if (bVar != null && a.b.dD(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.bhR.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.ao("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.bnp.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.UC().a(SwanAppSlaveManager.this.GA(), new com.baidu.swan.apps.n.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView Gr() {
        if (this.bnp == null) {
            return null;
        }
        return this.bnp;
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

    private void NU() {
        this.bnn = String.valueOf(bnm);
        bnm++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String GA() {
        return this.bnn;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.bjC == null) {
            return false;
        }
        if (this.bnp != null) {
            this.bnp.dn(false);
            this.bnp.setPullRefreshEnabled(false);
        }
        if (this.bno == null) {
            if (DEBUG && this.mActivity == null) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("activity context is null.")));
            }
            this.bno = bV(this.mActivity != null ? this.mActivity : this.mContext);
            this.bno.eM(this.bnt);
            this.bno.he(this.bnn);
            if (dVar.bdZ == null) {
                dVar.bdZ = com.baidu.swan.apps.model.a.a.a.Wg();
            }
            a(this.bjC, this.bno.Gy());
            if (this.bno.Gy() != null) {
                this.bno.Gy().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.bno.loadUrl(dVar.mSrc);
            this.bno.d(dVar);
            if (this.bnr != null) {
                this.bnr.a(this.bno);
            }
            if (this.bns != null) {
                this.bno.a(this.bns);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget bV(Context context) {
        return new SwanAppWebViewWidget(context);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bno != null) {
            this.bno.loadUrl(dVar.mSrc);
            this.bno.d(dVar);
            if (dVar.bdZ == null) {
                dVar.bdZ = com.baidu.swan.apps.model.a.a.a.Wg();
            }
            if (this.bno.Gy() != null) {
                this.bno.Gy().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bno != null) {
            if (this.bnr != null) {
                this.bnr.b(this.bno);
            }
            if (this.bns != null) {
                this.bns = null;
            }
            c(this.bjC, this.bno.Gy());
            this.bno.d(dVar);
            this.bno.destroy();
            this.bno = null;
            if (this.bnp != null) {
                this.bnp.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Gt() {
        if (this.bno == null || !this.bno.Gy().canGoBack()) {
            return false;
        }
        this.bno.Gy().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void GB() {
        com.baidu.swan.apps.media.b.destroy(this.bnn);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        Gu();
        super.destroy();
        com.baidu.swan.apps.w.a.RR().e(this);
        if (this.bnq != null) {
            this.bnq.destroy();
        }
        if (this.bdL != null) {
            this.bdL.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void Gu() {
        SwanAppActivity Un = f.UC().Un();
        if (Un != null) {
            t.forceHiddenSoftInput(Un, Un.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void dF(int i) {
        Gy().setVisibility(i);
        if (this.bnq != null) {
            this.bnq.gU(i);
        }
        if (Gr() != null) {
            Gr().setVisibility(i);
        }
        if (this.bno != null && this.bno.Gy() != null) {
            com.baidu.swan.apps.scheme.actions.m.d GC = this.bno.GC();
            this.bno.Gy().setVisibility(i == 0 && GC != null && !GC.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a Gv() {
        return this.bdL;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.bnr = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bns = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: NV */
    public SwanAppWebViewWidget Gs() {
        return this.bno;
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
            SwanAppSlaveManager.this.bnu.aXo = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.bnu.aXq = System.currentTimeMillis();
            SwanAppSlaveManager.this.bnu.aXr = "0";
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bRu = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.bnu.aXp = currentTimeMillis;
            if (SwanAppSlaveManager.this.bnu.aXq == 0) {
                SwanAppSlaveManager.this.bnu.aXq = currentTimeMillis;
            }
            final HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
            jA.f(new UbcFlowEvent("na_first_paint").aq(currentTimeMillis));
            long Ff = com.baidu.swan.apps.w.a.RJ().Ff();
            if (Ff < 0) {
                Ff = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.bnu.aXq <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppSlaveManager.this.bnu.aXq;
                    }
                    jA.aS("fmp_type", SwanAppSlaveManager.this.bnu.aXr);
                    jA.f(new UbcFlowEvent("na_first_meaningful_paint").aq(j)).Xo();
                }
            }, "fmp record", Ff, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.k.d.Og().ct(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void eM(String str) {
        this.bnt = str;
        if (this.bno != null) {
            this.bno.eM(this.bnt);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d Gx() {
        return this.bnu;
    }
}
