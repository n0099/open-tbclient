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
/* loaded from: classes8.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cUz = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a cIS;
    private FrameLayout cPT;
    private String cRB;
    private String cUA;
    private SwanAppWebViewWidget cUB;
    protected PullToRefreshNgWebView cUC;
    private com.baidu.swan.apps.view.narootview.a cUD;
    private e cUE;
    private d cUF;
    protected d cUG;
    protected String cUH;
    protected com.baidu.swan.apps.adaptation.b.a.d cUI;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.cNX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void amZ() {
        super.amZ();
        arn();
        l lVar = new l(this.cNJ);
        lVar.f(this);
        this.cNJ.a(lVar);
        this.cUI = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amW() {
        String aiA = aiA();
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.d(aiA));
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.a.b(aiA));
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.d.b(aiA));
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.f.c(aiA));
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.b.c(aiA));
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.d(aiA));
        this.cNE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.inlinewidget.rtcroom.c(aiA));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.awJ().c(this);
        if (this.cUB != null) {
            this.cUB.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.aIr() != null) {
            com.baidu.swan.apps.runtime.e.aIr().aII().fV(true);
        }
        aro();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.awJ().d(this);
        if (this.cUB != null) {
            this.cUB.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.aIr() != null) {
            com.baidu.swan.apps.runtime.e.aIr().aII().fV(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cUB != null ? this.cUB.isSlidable(motionEvent) : this.cNE.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ao
    public double aij() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.alq()) {
            com.baidu.swan.apps.core.c.b.anw();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aiv() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean aip() {
        return aiy().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.dDB) {
                this.cUC = new PullToRefreshNgWebView(this.cND.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                gc(SwanAppConfigData.rt(cVar.dDA));
                a(this.cUC);
                b(frameLayout, this.cUC);
            } else {
                b(frameLayout, aiy());
            }
            this.cPT = frameLayout;
            if (this.cUD == null) {
                this.cUD = new com.baidu.swan.apps.view.narootview.a(this.cND.getBaseContext(), this, frameLayout);
            }
            if (this.cIS == null) {
                this.cIS = new com.baidu.swan.apps.component.c.a(this.cND.getBaseContext(), this.cUD);
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
    public void jG(String str) {
        this.cUA = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String aix() {
        return this.cUA;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean gc(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cUC != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cUC.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.gc(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.fZ(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.cNE.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bx("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cUC.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.azN().a(SwanAppSlaveManager.this.aiA(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView aiq() {
        if (this.cUC == null) {
            return null;
        }
        return this.cUC;
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

    private void arn() {
        this.cRB = String.valueOf(cUz);
        cUz++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiA() {
        return this.cRB;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cUB != null) {
            this.cUB.attachActivity(activity);
        }
    }

    private void aro() {
        NgWebView ngWebView;
        if (!com.baidu.swan.apps.menu.fontsize.b.aBU() && !com.baidu.swan.apps.menu.fontsize.b.aBS()) {
            if (this.cUB != null && this.cUB.aiy() != null) {
                ngWebView = this.cUB.aiy();
            } else {
                ngWebView = this.cNE;
            }
            ngWebView.getSettings().setTextZoom(com.baidu.swan.apps.menu.fontsize.b.ig(com.baidu.swan.apps.menu.fontsize.b.aBT()));
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cPT == null) {
            return false;
        }
        if (this.cUC != null) {
            this.cUC.gF(false);
            this.cUC.setPullRefreshEnabled(false);
        }
        if (this.cUB == null) {
            if (DEBUG && !(this.cND.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cUB = arp();
            this.cUB.jF(this.cUH);
            this.cUB.mN(this.cRB);
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cUB.lR(dVar.mUa);
            }
            if (dVar.cJg == null) {
                dVar.cJg = com.baidu.swan.apps.model.a.a.a.aCf();
            }
            b(this.cPT, this.cUB.aiy());
            if (this.cUB.aiy() != null) {
                this.cUB.aiy().setVisibility(dVar.hidden ? 8 : 0);
                aro();
            }
            this.cUB.fu(dVar.dFT);
            this.cUB.loadUrl(dVar.mSrc);
            this.cUB.d(dVar);
            if (this.cUE != null) {
                this.cUE.a(this.cUB);
            }
            if (this.cUF != null) {
                this.cUB.a(this.cUF);
            }
            if (this.cUG != null) {
                this.cUB.b(this.cUG);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget arp() {
        return new SwanAppWebViewWidget(this.cND.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cUB != null) {
            if (!TextUtils.isEmpty(dVar.mUa)) {
                this.cUB.lR(dVar.mUa);
            }
            this.cUB.fu(dVar.dFT);
            this.cUB.loadUrl(dVar.mSrc);
            this.cUB.d(dVar);
            if (dVar.cJg == null) {
                dVar.cJg = com.baidu.swan.apps.model.a.a.a.aCf();
            }
            if (this.cUB.aiy() != null) {
                this.cUB.aiy().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cUF != null) {
                this.cUB.a(this.cUF);
            }
            if (this.cUG != null) {
                this.cUB.b(this.cUG);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cUB != null) {
            if (this.cUE != null) {
                this.cUE.b(this.cUB);
            }
            if (this.cUF != null) {
                this.cUF = null;
            }
            if (this.cUG != null) {
                this.cUG = null;
            }
            d(this.cPT, this.cUB.aiy());
            this.cUB.d(dVar);
            this.cUB.destroy();
            this.cUB = null;
            if (this.cUC != null) {
                this.cUC.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ais() {
        if (this.cUB == null || !this.cUB.aiy().canGoBack()) {
            return false;
        }
        this.cUB.aiy().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiB() {
        com.baidu.swan.apps.media.b.gE(this.cRB);
        com.baidu.swan.apps.inlinewidget.rtcroom.e.avJ().nL(this.cRB);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        ait();
        super.destroy();
        com.baidu.swan.apps.t.a.awJ().e(this);
        if (this.cUD != null) {
            this.cUD.destroy();
        }
        if (this.cIS != null) {
            this.cIS.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ait() {
        SwanAppActivity azx = f.azN().azx();
        if (azx != null) {
            w.forceHiddenSoftInput(azx, azx.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void gb(int i) {
        aiy().setVisibility(i);
        if (this.cUD != null) {
            this.cUD.kt(i);
        }
        if (aiq() != null) {
            aiq().setVisibility(i);
        }
        if (this.cUB != null && this.cUB.aiy() != null) {
            com.baidu.swan.apps.scheme.actions.m.d aiE = this.cUB.aiE();
            this.cUB.aiy().setVisibility(i == 0 && aiE != null && !aiE.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a aiu() {
        return this.cIS;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cUE = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cUF = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: arq */
    public SwanAppWebViewWidget air() {
        return this.cUB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            SwanAppSlaveManager.this.cUI.cAW = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cUI.cAY = System.currentTimeMillis();
            SwanAppSlaveManager.this.cUI.cBc = "0";
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bZ(SwanAppSlaveManager.this.cUI.cAY);
            com.baidu.swan.apps.core.f.bZ(SwanAppSlaveManager.this.cUI.cAY);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cUI.cAY);
            }
            HybridUbcFlow pU = i.pU("startup");
            if (pU != null) {
                pU.cm("webviewComponent", "1");
                pU.cm("fmp_type", "0");
                pU.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cUI.cAY).a(UbcFlowEvent.RecordType.UPDATE)).aDp();
                pU.q("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppSlaveManager.this.cUI.cAY), " , fmpType=", SwanAppSlaveManager.this.cUI.cBc, " , fmpTypeName=", SwanAppSlaveManager.this.cUI.aiN());
                i.akh();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dJG = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.br("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cUI.cAX = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cC(SwanAppSlaveManager.this.cUI.cAX);
            final long aiL = i.doD ? currentTimeMillis : SwanAppSlaveManager.this.cUI.aiL();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + aiL + " , aligned search=" + i.doD);
            }
            final HybridUbcFlow pS = i.pS("startup");
            pS.f(new UbcFlowEvent("na_first_paint").cy(aiL));
            if (SwanAppSlaveManager.this.cUI.cAY == 0) {
                SwanAppSlaveManager.this.cUI.cAY = aiL;
                SwanAppSlaveManager.this.cUI.cBc = SwanAppSlaveManager.this.cUI.bT(aiL);
                pS.cm("fmp_type", "1");
                pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cUI.cAX));
            }
            long agu = com.baidu.swan.apps.t.a.awB().agu();
            if (agu < 0) {
                agu = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.doD) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.ft(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cUI.cAY <= 0) {
                        j = aiL;
                    } else {
                        j = SwanAppSlaveManager.this.cUI.cAY;
                    }
                    pS.cm("fmp_type", SwanAppSlaveManager.this.cUI.cBc);
                    pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(j)).aDp();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cUI.cBc + " , fmpTypeName=" + SwanAppSlaveManager.this.cUI.aiN());
                    }
                }
            }, "fmp record", agu, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cUI.cAZ = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().ca(SwanAppSlaveManager.this.cUI.cAZ);
            com.baidu.swan.apps.core.f.ca(SwanAppSlaveManager.this.cUI.cAZ);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cUI.cAZ);
            }
            if (i.doD) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.ft(false);
            } else if (SwanAppSlaveManager.this.cUI.cAY == 0) {
                HybridUbcFlow pS = i.pS("startup");
                pS.cm("fmp_type", "2");
                pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cUI.cAZ));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cUI.cBa = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cB(SwanAppSlaveManager.this.cUI.cBa);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cUI.cBa);
            }
            if (i.doD) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.ft(false);
            } else if (SwanAppSlaveManager.this.cUI.cAY == 0) {
                HybridUbcFlow pS = i.pS("startup");
                pS.cm("fmp_type", "3");
                pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppSlaveManager.this.cUI.cBa));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void ft(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cUI.toString());
        }
        this.cUI.aiM();
        long j = this.cUI.cAY;
        String str = this.cUI.cBc;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cUI.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cUI.toString());
        }
        HybridUbcFlow pS = i.pS("startup");
        pS.cm("fmp_type", str);
        pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(j).a(UbcFlowEvent.RecordType.UPDATE));
        pS.q("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cUI.aiN());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cUI.aiN());
            }
            pS.aDp();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.arG().fw(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void jF(String str) {
        this.cUH = str;
        if (this.cUB != null) {
            this.cUB.jF(this.cUH);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d aiw() {
        return this.cUI;
    }

    public void b(d dVar) {
        this.cUG = dVar;
    }
}
