package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.core.e.e;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.j;
import com.baidu.swan.apps.res.ui.DomainErrorView;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.swan.apps.scheme.actions.m.d;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cgH = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private c cgA;
    private b cgB;
    private a cgC;
    @Nullable
    private d cgD;
    private e cgE;
    private int cgF;
    private String cgG;
    private int cgI;
    protected com.baidu.swan.apps.core.f.d cgn;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cgI = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory SB = com.baidu.swan.apps.t.a.ahG().SB();
        if (SB != null) {
            this.bZE.getCurrentWebView().setVideoPlayerFactory(SB);
        }
        adj();
        bQ(context);
    }

    private void adj() {
        this.bZE.getSettings().setLoadWithOverviewMode(true);
        this.bZE.getSettings().setUseWideViewPort(true);
        this.bZE.getSettings().setSupportZoom(true);
        this.bZE.getSettings().setBuiltInZoomControls(true);
        this.bZE.getSettings().setDisplayZoomControls(false);
    }

    private void bQ(Context context) {
        com.baidu.swan.apps.adaptation.a.b Ug = com.baidu.swan.apps.runtime.d.arr().art().Sv().Ug();
        if (Ug != null) {
            Ug.bb(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
        super.a(swanAppWebViewManager);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bZX = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zj() {
        super.Zj();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.bZJ);
        fVar.c(this);
        this.bZJ.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Zg() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (abp() && !com.baidu.swan.apps.ah.a.b.oG(str)) {
            ado().ko(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean abp() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String UQ() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d UT() {
        return this.cgD;
    }

    public void d(@Nullable d dVar) {
        this.cgD = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c adk() {
        if (this.cgA == null) {
            this.cgA = new c(UP().getContext(), UP());
        }
        return this.cgA;
    }

    public int adl() {
        EfficientProgressBar efficientProgressBar;
        if (this.cgA == null || (efficientProgressBar = this.cgA.cgP) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        adm();
    }

    private void adm() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b adn() {
        if (this.cgB == null) {
            this.cgB = new b(UP().getContext(), UP());
            this.cgB.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.UP().getContext())) {
                        if (!SwanAppWebViewWidget.this.abp() || com.baidu.swan.apps.ah.a.b.oG(SwanAppWebViewWidget.this.UP().getUrl())) {
                            SwanAppWebViewWidget.this.UP().reload();
                            SwanAppWebViewWidget.this.cgB.adr();
                        }
                    }
                }
            });
        }
        return this.cgB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a ado() {
        if (this.cgC == null) {
            this.cgC = new a(UP().getContext(), UP());
        }
        return this.cgC;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.cgn = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void US() {
        super.US();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cgn = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.adk().startProgress();
            SwanAppWebViewWidget.this.adp();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.adn().ads();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.adk().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri qM = al.qM(str);
            if (qM != null) {
                com.baidu.swan.apps.aq.e.startActivitySafely(SwanAppWebViewWidget.this.bZD, new Intent("android.intent.action.DIAL", qM));
                return true;
            } else if (SwanAppWebViewWidget.this.cgo != null) {
                return SwanAppWebViewWidget.this.cgo.fZ(str);
            } else {
                if (!SwanAppWebViewWidget.this.abp() || com.baidu.swan.apps.ah.a.b.oG(str)) {
                    return false;
                }
                showDomainErrorView(str);
                return true;
            }
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.cgH) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.ado().ko(str);
                            SwanAppWebViewWidget.this.UP().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dC(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean Zl() {
                                    SwanAppWebViewWidget.this.ado().adr();
                                    SwanAppWebViewWidget.this.UP().setOnWebViewHookHandler(null);
                                    return true;
                                }
                            });
                            return;
                        }
                    }
                } catch (MalformedURLException e) {
                    if (SwanAppWebViewWidget.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    private class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        private SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            SwanAppWebViewWidget.this.hideCustomView();
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            return onShowCustomView(bdSailorWebView, view, 0, customViewCallback);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (SwanAppWebViewWidget.this.cgE == null) {
                SwanAppWebViewWidget.this.cgE = new e(SwanAppWebViewWidget.this.bZD.getBaseContext());
            }
            SwanAppWebViewWidget.this.cgE.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void onCustomViewHidden() {
                }
            });
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (!aj.isUrlAuxiliary(str)) {
                SwanAppWebViewWidget.this.mTitle = str;
                if (SwanAppWebViewWidget.this.cgn != null) {
                    SwanAppWebViewWidget.this.cgn.fY(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cgE != null) {
            this.cgE.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c {
        private EfficientProgressBar cgP;

        public c(Context context, ViewGroup viewGroup) {
            this.cgP = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cgP = new EfficientProgressBar(context);
            this.cgP.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cgP.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cgP.setVisibility(4);
            this.cgP.setFocusable(false);
            this.cgP.setClickable(false);
            viewGroup.addView(this.cgP);
        }

        public void startProgress() {
            this.cgP.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cgP.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cgP.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        private NetworkErrorView cgO;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cgO = new NetworkErrorView(context);
            this.cgO.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cgO, new FrameLayout.LayoutParams(-1, -1));
            this.cgO.setVisibility(8);
        }

        public void ads() {
            this.cgO.setVisibility(0);
        }

        public void adr() {
            this.cgO.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cgO.setOnClickListener(onClickListener);
            this.cgO.setReloadClickListener(onClickListener);
        }
    }

    public void adp() {
        final com.baidu.swan.apps.core.d.c aaZ;
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && (aaZ = Sc.aaZ()) != null && aaZ.getView() != null) {
            final View view = null;
            if (aaZ instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) aaZ).aaQ().UI() != null) {
                    view = aaZ.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (aaZ instanceof i) {
                if (((i) aaZ).UI() != null && aaZ.getView() != null) {
                    view = aaZ.getView().findViewById(a.f.swan_app_webview_fragment);
                } else {
                    return;
                }
            }
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "onGlobalLayout");
                        }
                        SwanAppWebViewWidget.this.a(view, aaZ);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.swan.apps.core.d.c cVar) {
        if (cVar != null && !cVar.isDetached()) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.cgF) {
                if (this.cgF - i > this.cgI) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.ZR() && eVar.aaI()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cgF = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private DomainErrorView cgN;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cgN = new DomainErrorView(context);
            this.cgN.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cgN, new FrameLayout.LayoutParams(-1, -1));
            this.cgN.setVisibility(8);
        }

        public void ko(String str) {
            this.cgN.nZ(str);
            this.cgN.setVisibility(0);
        }

        public void adr() {
            this.cgN.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cgp)) {
                com.baidu.swan.apps.performance.i.bE("route", SwanAppWebViewWidget.this.cgp).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cgq.bNv = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cgp)) {
                com.baidu.swan.apps.performance.i.bE("route", SwanAppWebViewWidget.this.cgp).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            HybridUbcFlow mZ;
            com.baidu.swan.apps.console.c.aW("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cgq.bNx = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cgq.bNB = "0";
            com.baidu.swan.apps.performance.d.b.aoz().aO(SwanAppWebViewWidget.this.cgq.bNx);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cgq.bNx);
            }
            if (com.baidu.swan.apps.performance.i.cyF && (mZ = com.baidu.swan.apps.performance.i.mZ("startup")) != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                mZ.bH("webviewComponent", str);
                mZ.bH("fmp_type", "0");
                mZ.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppWebViewWidget.this.cgq.bNx).a(UbcFlowEvent.RecordType.UPDATE)).anG();
                mZ.r("value", "arrive_success");
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + SwanAppWebViewWidget.this.cgq.bNx + " , fmpType=" + SwanAppWebViewWidget.this.cgq.bNB + " , fmpTypeName=" + SwanAppWebViewWidget.this.cgq.Vc());
                }
                com.baidu.swan.apps.performance.i.Wv();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cgp)) {
                j.no(SwanAppWebViewWidget.this.cgp);
                SwanAppWebViewWidget.this.cgp = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.aW("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cgq.bNw = currentTimeMillis;
            com.baidu.swan.apps.performance.d.b.aoz().bs(SwanAppWebViewWidget.this.cgq.bNw);
            final long Va = com.baidu.swan.apps.performance.i.cyG ? currentTimeMillis : SwanAppWebViewWidget.this.cgq.Va();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + Va + " , aligned search=" + com.baidu.swan.apps.performance.i.cyG);
            }
            final HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
            mX.f(new UbcFlowEvent("na_first_paint").bm(Va));
            if (SwanAppWebViewWidget.this.cgq.bNx == 0) {
                SwanAppWebViewWidget.this.cgq.bNx = Va;
                SwanAppWebViewWidget.this.cgq.bNB = SwanAppWebViewWidget.this.cgq.aL(Va);
                if (com.baidu.swan.apps.performance.i.cyF) {
                    mX.bH("fmp_type", "1");
                    mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppWebViewWidget.this.cgq.bNw));
                    return;
                }
            }
            long SV = com.baidu.swan.apps.t.a.ahm().SV();
            if (SV < 0) {
                SV = 3000;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.cyG) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.dV(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cgq.bNx <= 0) {
                        j = Va;
                    } else {
                        j = SwanAppWebViewWidget.this.cgq.bNx;
                    }
                    mX.bH("fmp_type", SwanAppWebViewWidget.this.cgq.bNB);
                    mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(j)).anG();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cgq.bNB + " , fmpTypeName=" + SwanAppWebViewWidget.this.cgq.Vc());
                    }
                }
            }, "fmp record", SV, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.aW("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cgq.bNy = System.currentTimeMillis();
            com.baidu.swan.apps.performance.d.b.aoz().aP(SwanAppWebViewWidget.this.cgq.bNy);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cgq.bNy);
            }
            if (com.baidu.swan.apps.performance.i.cyG && com.baidu.swan.apps.performance.i.cyF) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.dV(false);
            } else if (SwanAppWebViewWidget.this.cgq.bNx == 0 && com.baidu.swan.apps.performance.i.cyF) {
                HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
                mX.bH("fmp_type", "2");
                mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppWebViewWidget.this.cgq.bNy));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.aW("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cgq.bNz = System.currentTimeMillis();
            com.baidu.swan.apps.performance.d.b.aoz().br(SwanAppWebViewWidget.this.cgq.bNz);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cgq.bNz);
            }
            if (com.baidu.swan.apps.performance.i.cyG && com.baidu.swan.apps.performance.i.cyF) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.dV(false);
            } else if (SwanAppWebViewWidget.this.cgq.bNx == 0 && com.baidu.swan.apps.performance.i.cyF) {
                HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
                mX.bH("fmp_type", "3");
                mX.f(new UbcFlowEvent("na_first_meaningful_paint").bm(SwanAppWebViewWidget.this.cgq.bNz));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.ahm().SM() && SwanAppWebViewWidget.this.abp() && !com.baidu.swan.apps.ah.a.b.oG(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kn(String str) {
        this.cgG = str;
    }
}
