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
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.w;
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
/* loaded from: classes7.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements c<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cgg = 10;
    @Nullable
    private com.baidu.swan.apps.component.c.a bVb;
    private FrameLayout cbR;
    private String cgh;
    private String cgi;
    private SwanAppWebViewWidget cgj;
    protected PullToRefreshNgWebView cgk;
    private com.baidu.swan.apps.view.narootview.a cgl;
    private e cgm;
    private d cgn;
    protected d cgo;
    protected String cgp;
    protected com.baidu.swan.apps.adaptation.b.a.d cgq;

    public SwanAppSlaveManager(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bZX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Zj() {
        super.Zj();
        adg();
        l lVar = new l(this.bZJ);
        lVar.f(this);
        this.bZJ.a(lVar);
        this.cgq = new com.baidu.swan.apps.adaptation.b.a.d();
        a(new SwanAppSlaveWebviewClientExt());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zg() {
        String UR = UR();
        this.bZE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.f.d(UR));
        this.bZE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.a.b(UR));
        this.bZE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.d.b(UR));
        this.bZE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.f.c(UR));
        this.bZE.getCurrentWebView().addZeusPluginFactory(new com.baidu.swan.apps.p.b.c(UR));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onResume() {
        super.onResume();
        com.baidu.swan.apps.t.a.ahu().c(this);
        if (this.cgj != null) {
            this.cgj.onResume();
        }
        if (com.baidu.swan.apps.runtime.e.arv() != null) {
            com.baidu.swan.apps.runtime.e.arv().arM().er(true);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        com.baidu.swan.apps.t.a.ahu().d(this);
        if (this.cgj != null) {
            this.cgj.onPause();
        }
        if (com.baidu.swan.apps.runtime.e.arv() != null) {
            com.baidu.swan.apps.runtime.e.arv().arM().er(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return this.cgj != null ? this.cgj.isSlidable(motionEvent) : this.bZE.isSlidable(motionEvent);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public double UB() {
        return 1.0d;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        super.loadUrl(str);
        if (com.baidu.swan.apps.console.c.XD()) {
            com.baidu.swan.apps.core.c.b.ZG();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        UP().loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean UM() {
        return BdZeusUtil.isWebkitLoaded();
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean UG() {
        return UP().getParent() != null;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(FrameLayout frameLayout, com.baidu.swan.apps.runtime.config.c cVar) {
        if (frameLayout != null) {
            if (cVar.cII) {
                this.cgk = new PullToRefreshNgWebView(this.bZD.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
                ew(SwanAppConfigData.dU(cVar.cIH));
                a(this.cgk);
                a(frameLayout, this.cgk);
            } else {
                a(frameLayout, UP());
            }
            this.cbR = frameLayout;
            if (this.cgl == null) {
                this.cgl = new com.baidu.swan.apps.view.narootview.a(this.bZD.getBaseContext(), this, frameLayout);
            }
            if (this.bVb == null) {
                this.bVb = new com.baidu.swan.apps.component.c.a(this.bZD.getBaseContext(), this.cgl);
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
    public void ho(String str) {
        this.cgi = str;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public String UO() {
        return this.cgi;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean ew(int i) {
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        if (this.cgk != null && (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) this.cgk.getHeaderLoadingLayout()) != null) {
            return neutralHeaderLoadingLayout.ew(i);
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.turbo.b bVar) {
        if (bVar != null && a.b.et(0)) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "pathList item: " + bVar.appPath);
            }
            this.bZE.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.ba("appjs", bVar.appPath));
        }
    }

    protected void a(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        if (pullToRefreshBaseWebView != null) {
            this.cgk.setOnRefreshListener(new PullToRefreshBase.a<NgWebView>() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.1
                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    f.akr().a(SwanAppSlaveManager.this.UR(), new com.baidu.swan.apps.event.a.b("PullDownRefresh"));
                }

                @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.a
                public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public PullToRefreshBaseWebView UH() {
        if (this.cgk == null) {
            return null;
        }
        return this.cgk;
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

    private void adg() {
        this.cgh = String.valueOf(cgg);
        cgg++;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String UR() {
        return this.cgh;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        super.attachActivity(activity);
        if (this.cgj != null) {
            this.cgj.attachActivity(activity);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean a(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (dVar == null || this.cbR == null) {
            return false;
        }
        if (this.cgk != null) {
            this.cgk.eY(false);
            this.cgk.setPullRefreshEnabled(false);
        }
        if (this.cgj == null) {
            if (DEBUG && !(this.bZD.getBaseContext() instanceof Activity)) {
                Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
            }
            this.cgj = adh();
            this.cgj.hn(this.cgp);
            this.cgj.kn(this.cgh);
            if (!TextUtils.isEmpty(dVar.alk)) {
                this.cgj.jv(dVar.alk);
            }
            if (dVar.bVp == null) {
                dVar.bVp = com.baidu.swan.apps.model.a.a.a.amu();
            }
            a(this.cbR, this.cgj.UP());
            if (this.cgj.UP() != null) {
                this.cgj.UP().setVisibility(dVar.hidden ? 8 : 0);
            }
            this.cgj.loadUrl(dVar.mSrc);
            this.cgj.d(dVar);
            if (this.cgm != null) {
                this.cgm.a(this.cgj);
            }
            if (this.cgn != null) {
                this.cgj.a(this.cgn);
            }
            if (this.cgo != null) {
                this.cgj.b(this.cgo);
            }
            return true;
        }
        return false;
    }

    @NonNull
    protected SwanAppWebViewWidget adh() {
        return new SwanAppWebViewWidget(this.bZD.getBaseContext());
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean b(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cgj != null) {
            if (!TextUtils.isEmpty(dVar.alk)) {
                this.cgj.jv(dVar.alk);
            }
            this.cgj.loadUrl(dVar.mSrc);
            this.cgj.d(dVar);
            if (dVar.bVp == null) {
                dVar.bVp = com.baidu.swan.apps.model.a.a.a.amu();
            }
            if (this.cgj.UP() != null) {
                this.cgj.UP().setVisibility(dVar.hidden ? 8 : 0);
            }
            if (this.cgn != null) {
                this.cgj.a(this.cgn);
            }
            if (this.cgo != null) {
                this.cgj.b(this.cgo);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean c(com.baidu.swan.apps.scheme.actions.m.d dVar) {
        if (this.cgj != null) {
            if (this.cgm != null) {
                this.cgm.b(this.cgj);
            }
            if (this.cgn != null) {
                this.cgn = null;
            }
            if (this.cgo != null) {
                this.cgo = null;
            }
            c(this.cbR, this.cgj.UP());
            this.cgj.d(dVar);
            this.cgj.destroy();
            this.cgj = null;
            if (this.cgk != null) {
                this.cgk.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public boolean UJ() {
        if (this.cgj == null || !this.cgj.UP().canGoBack()) {
            return false;
        }
        this.cgj.UP().goBack();
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void US() {
        com.baidu.swan.apps.media.b.destroy(this.cgh);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        c((com.baidu.swan.apps.scheme.actions.m.d) null);
        UK();
        super.destroy();
        com.baidu.swan.apps.t.a.ahu().e(this);
        if (this.cgl != null) {
            this.cgl.destroy();
        }
        if (this.bVb != null) {
            this.bVb.onDestroy();
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void UK() {
        SwanAppActivity akb = f.akr().akb();
        if (akb != null) {
            w.forceHiddenSoftInput(akb, akb.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void ev(int i) {
        UP().setVisibility(i);
        if (this.cgl != null) {
            this.cgl.in(i);
        }
        if (UH() != null) {
            UH().setVisibility(i);
        }
        if (this.cgj != null && this.cgj.UP() != null) {
            com.baidu.swan.apps.scheme.actions.m.d UT = this.cgj.UT();
            this.cgj.UP().setVisibility(i == 0 && UT != null && !UT.hidden ? 0 : 8);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    public com.baidu.swan.apps.component.c.a UL() {
        return this.bVb;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(e eVar) {
        this.cgm = eVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cgn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.c
    @Nullable
    /* renamed from: adi */
    public SwanAppWebViewWidget UI() {
        return this.cgj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
            SwanAppSlaveManager.this.cgq.bNv = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            HybridUbcFlow mZ;
            com.baidu.swan.apps.console.c.aW("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cgq.bNx = System.currentTimeMillis();
            SwanAppSlaveManager.this.cgq.bNB = "0";
            com.baidu.swan.apps.performance.d.b.aoz().aO(SwanAppSlaveManager.this.cgq.bNx);
            com.baidu.swan.apps.core.d.aO(SwanAppSlaveManager.this.cgq.bNx);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppSlaveManager.this.cgq.bNx);
            }
            if (i.cyF && (mZ = i.mZ("startup")) != null) {
                mZ.bH("webviewComponent", "1");
                mZ.bH("fmp_type", "0");
                mZ.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppSlaveManager.this.cgq.bNx).a(UbcFlowEvent.RecordType.UPDATE)).anF();
                mZ.r("value", "arrive_success");
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + SwanAppSlaveManager.this.cgq.bNx + " , fmpType=" + SwanAppSlaveManager.this.cgq.bNB + " , fmpTypeName=" + SwanAppSlaveManager.this.cgq.Vc());
                }
                i.Wv();
            }
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cOO = SearchFlowEvent.EventType.END;
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
            com.baidu.swan.apps.console.c.aW("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppSlaveManager.this.cgq.bNw = currentTimeMillis;
            com.baidu.swan.apps.performance.d.b.aoz().bs(SwanAppSlaveManager.this.cgq.bNw);
            final long Va = i.cyG ? currentTimeMillis : SwanAppSlaveManager.this.cgq.Va();
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + Va + " , aligned search=" + i.cyG);
            }
            final HybridUbcFlow mX = i.mX("startup");
            mX.f(new UbcFlowEvent("na_first_paint").bm(Va));
            if (SwanAppSlaveManager.this.cgq.bNx == 0) {
                SwanAppSlaveManager.this.cgq.bNx = Va;
                SwanAppSlaveManager.this.cgq.bNB = SwanAppSlaveManager.this.cgq.aL(Va);
                if (i.cyF) {
                    mX.bH("fmp_type", "1");
                    mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppSlaveManager.this.cgq.bNw));
                    return;
                }
            }
            long SV = com.baidu.swan.apps.t.a.ahm().SV();
            if (SV < 0) {
                SV = 3000;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppSlaveManager.SwanAppSlaveWebviewClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (i.cyG) {
                        if (SwanAppSlaveManager.DEBUG) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppSlaveManager.this.dV(true);
                        return;
                    }
                    if (SwanAppSlaveManager.this.cgq.bNx <= 0) {
                        j = Va;
                    } else {
                        j = SwanAppSlaveManager.this.cgq.bNx;
                    }
                    mX.bH("fmp_type", SwanAppSlaveManager.this.cgq.bNB);
                    mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(j)).anF();
                    if (SwanAppSlaveManager.DEBUG) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppSlaveManager.this.cgq.bNB + " , fmpTypeName=" + SwanAppSlaveManager.this.cgq.Vc());
                    }
                }
            }, "fmp record", SV, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.aW("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cgq.bNy = System.currentTimeMillis();
            com.baidu.swan.apps.performance.d.b.aoz().aP(SwanAppSlaveManager.this.cgq.bNy);
            com.baidu.swan.apps.core.d.aP(SwanAppSlaveManager.this.cgq.bNy);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppSlaveManager.this.cgq.bNy);
            }
            if (i.cyG && i.cyF) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                }
                SwanAppSlaveManager.this.dV(false);
            } else if (SwanAppSlaveManager.this.cgq.bNx == 0 && i.cyF) {
                HybridUbcFlow mX = i.mX("startup");
                mX.bH("fmp_type", "2");
                mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppSlaveManager.this.cgq.bNy));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.aW("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppSlaveManager.this.cgq.bNz = System.currentTimeMillis();
            com.baidu.swan.apps.performance.d.b.aoz().br(SwanAppSlaveManager.this.cgq.bNz);
            if (SwanAppSlaveManager.DEBUG) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppSlaveManager.this.cgq.bNz);
            }
            if (i.cyG && i.cyF) {
                if (SwanAppSlaveManager.DEBUG) {
                    Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                }
                SwanAppSlaveManager.this.dV(false);
            } else if (SwanAppSlaveManager.this.cgq.bNx == 0 && i.cyF) {
                HybridUbcFlow mX = i.mX("startup");
                mX.bH("fmp_type", "3");
                mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppSlaveManager.this.cgq.bNz));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dV(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.cgq.toString());
        }
        this.cgq.Vb();
        long j = this.cgq.bNx;
        String str = this.cgq.bNB;
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.cgq.toString());
        }
        if (DEBUG && (j <= 0 || TextUtils.isEmpty(str))) {
            throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.cgq.toString());
        }
        HybridUbcFlow mX = i.mX("startup");
        mX.bH("fmp_type", str);
        mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(j).a(UbcFlowEvent.RecordType.UPDATE));
        mX.r("value", "arrive_success");
        if (DEBUG) {
            Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cgq.Vc());
        }
        if (z) {
            if (DEBUG) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.cgq.Vc());
            }
            mX.anF();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
        com.baidu.swan.apps.core.turbo.d.adw().dX(false);
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public void hn(String str) {
        this.cgp = str;
        if (this.cgj != null) {
            this.cgj.hn(this.cgp);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.c
    public com.baidu.swan.apps.adaptation.b.a.d UN() {
        return this.cgq;
    }

    public void b(d dVar) {
        this.cgo = dVar;
    }
}
