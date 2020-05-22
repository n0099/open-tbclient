package com.baidu.swan.apps.core.slave;

import android.app.Activity;
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
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshNgWebView;
import com.baidu.swan.apps.core.f.d;
import com.baidu.swan.apps.core.f.e;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.l;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.w.f;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bZH = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bPv;
    private FrameLayout bVv;
    private String bZI;
    private SwanAppWebViewWidget bZJ;
    protected PullToRefreshNgWebView bZK;
    private com.baidu.swan.apps.view.narootview.a bZL;
    private e bZM;
    private d bZN;
    protected String bZO;
    protected com.baidu.swan.apps.adaptation.b.a.d bZP;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bTT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Xn() {
        super.Xn();
        aaW();
        l lVar = new l(this.bTH);
        lVar.f(this);
        this.bTH.a(lVar);
        this.bZP = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xk() {
        this.bTC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.e.d(Tj()));
        this.bTC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.a.b(Tj()));
        this.bTC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.c.b(Tj()));
        this.bTC.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.e.c(Tj()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.u.a.afc().c(this);
        if (this.bZJ != null) {
            this.bZJ.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aoF() != null) {
            com.baidu.swan.apps.runtime.e.aoF().aoW().ee(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.u.a.afc().d(this);
        if (this.bZJ != null) {
            this.bZJ.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aoF() != null) {
            com.baidu.swan.apps.runtime.e.aoF().aoW().ee(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.bZJ != null ? this.bZJ.isSlidable(motionEvent) : this.bTC.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ai
    public double SU() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.VR()) {
            com.baidu.swan.apps.core.c.b.XI();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Th().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Tf() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean SZ() {
        return Th().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.cBg) {
                this.bZK = new PullToRefreshNgWebView(this.bTB.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                eh(SwanAppConfigData.dT(cVar.cBf));
                a(this.bZK);
                a(frameLayout, this.bZK);
            } else {
                a(frameLayout, Th());
            }
            this.bVv = frameLayout;
            if (this.bZL == null) {
                this.bZL = new com.baidu.swan.apps.view.narootview.a(this.bTB.getBaseContext(), this, frameLayout);
            }
            if (this.bPv == null) {
                this.bPv = new com.baidu.swan.apps.component.c.a(this.bTB.getBaseContext(), this.bZL);
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
    public boolean eh(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.bZK != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.bZK.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.eh(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.ee(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.bTC.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.aW("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.bZK.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.ahV().a(SwanAppSlaveManager.this.Tj(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView Ta() {
        if (this.bZK == null) {
            return null;
        }
        return this.bZK;
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

    private void aaW() {
        this.bZI = String.valueOf(bZH);
        bZH++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Tj() {
        return this.bZI;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.bZJ != null) {
            this.bZJ.attachActivity(activity);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.bVv == null) {
            return false;
        }
        if (this.bZK != null) {
            this.bZK.eK(false);
            this.bZK.setPullRefreshEnabled(false);
        }
        if (this.bZJ == null) {
            if (DEBUG && !(this.bTB.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.bZJ = aaX();
            this.bZJ.gZ(this.bZO);
            this.bZJ.jM(this.bZI);
            if (dVar.bPJ == null) {
                dVar.bPJ = com.baidu.swan.apps.model.a.a.a.ajX();
            }
            a(this.bVv, this.bZJ.Th());
            if (this.bZJ.Th() != null) {
                this.bZJ.Th().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.bZJ.loadUrl(dVar.mSrc);
            this.bZJ.d(dVar);
            if (this.bZM != null) {
                this.bZM.a(this.bZJ);
            }
            if (this.bZN != null) {
                this.bZJ.a(this.bZN);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget aaX() {
        return new SwanAppWebViewWidget(this.bTB.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bZJ != null) {
            this.bZJ.loadUrl(dVar.mSrc);
            this.bZJ.d(dVar);
            if (dVar.bPJ == null) {
                dVar.bPJ = com.baidu.swan.apps.model.a.a.a.ajX();
            }
            if (this.bZJ.Th() != null) {
                this.bZJ.Th().setVisibility(dVar.hidden ? 8 : 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.bZJ != null) {
            if (this.bZM != null) {
                this.bZM.b(this.bZJ);
            }
            if (this.bZN != null) {
                this.bZN = null;
            }
            c(this.bVv, this.bZJ.Th());
            this.bZJ.d(dVar);
            this.bZJ.destroy();
            this.bZJ = null;
            if (this.bZK != null) {
                this.bZK.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean Tc() {
        if (this.bZJ == null || !this.bZJ.Th().canGoBack()) {
            return false;
        }
        this.bZJ.Th().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Tk() {
        com.baidu.swan.apps.media.b.destroy(this.bZI);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        Td();
        super.destroy();
        com.baidu.swan.apps.u.a.afc().e(this);
        if (this.bZL != null) {
            this.bZL.destroy();
        }
        if (this.bPv != null) {
            this.bPv.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void Td() {
        SwanAppActivity ahF = f.ahV().ahF();
        if (ahF != null) {
            u.forceHiddenSoftInput(ahF, ahF.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void eg(int i) {
        Th().setVisibility(i);
        if (this.bZL != null) {
            this.bZL.hP(i);
        }
        if (Ta() != null) {
            Ta().setVisibility(i);
        }
        if (this.bZJ != null && this.bZJ.Th() != null) {
            com.baidu.swan.apps.scheme.actions.m.d Tl = this.bZJ.Tl();
            this.bZJ.Th().setVisibility(i == 0 && Tl != null && !Tl.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a Te() {
        return this.bPv;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.bZM = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bZN = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: aaY */
    public SwanAppWebViewWidget Tb() {
        return this.bZJ;
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
            SwanAppSlaveManager.this.bZP.bHQ = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            HybridUbcFlow mr;
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedEx");
            }
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.bZP.bHS = System.currentTimeMillis();
            SwanAppSlaveManager.this.bZP.bHW = "0";
            if (g.crD && (mr = g.mr("startup")) != null) {
                mr.bD("fmp_type", "0");
                mr.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.bZP.bHS).a(UbcFlowEvent.RecordType.UPDATE)).alf();
                g.UI();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cGJ = SearchFlowEvent.EventType.END;
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
            SwanAppSlaveManager.this.bZP.bHR = System.currentTimeMillis();
            final long Ts = SwanAppSlaveManager.this.bZP.Ts();
            final HybridUbcFlow mp = g.mp("startup");
            mp.f(new UbcFlowEvent("na_first_paint").bg(Ts));
            if (SwanAppSlaveManager.this.bZP.bHS == 0) {
                SwanAppSlaveManager.this.bZP.bHS = Ts;
                SwanAppSlaveManager.this.bZP.bHW = SwanAppSlaveManager.this.bZP.aL(Ts);
                if (g.crD) {
                    mp.bD("fmp_type", "1");
                    mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.bZP.bHR));
                    return;
                }
            }
            long Rz = com.baidu.swan.apps.u.a.aeU().Rz();
            if (Rz < 0) {
                Rz = 3000;
            }
            n.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppSlaveManager.this.bZP.bHS <= 0) {
                        j = Ts;
                    } else {
                        j = SwanAppSlaveManager.this.bZP.bHS;
                    }
                    mp.bD("fmp_type", SwanAppSlaveManager.this.bZP.bHW);
                    mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(j)).alf();
                }
            }, "fmp record", Rz, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            }
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.bZP.bHT = System.currentTimeMillis();
            if (SwanAppSlaveManager.this.bZP.bHS == 0 && g.crD) {
                HybridUbcFlow mp = g.mp("startup");
                mp.bD("fmp_type", "2");
                mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.bZP.bHT));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            }
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.bZP.bHU = System.currentTimeMillis();
            if (SwanAppSlaveManager.this.bZP.bHS == 0 && g.crD) {
                HybridUbcFlow mp = g.mp("startup");
                mp.bD("fmp_type", "3");
                mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppSlaveManager.this.bZP.bHU));
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.abl().dM(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gZ(String str) {
        this.bZO = str;
        if (this.bZJ != null) {
            this.bZJ.gZ(this.bZO);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d Tg() {
        return this.bZP;
    }
}
