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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
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
/* loaded from: classes25.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cUQ = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private c cUI;
    private b cUJ;
    private a cUK;
    @Nullable
    private d cUL;
    private e cUM;
    private int cUN;
    private String cUO;
    private boolean cUP;
    private int cUR;
    protected com.baidu.swan.apps.core.f.d cUv;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cUP = true;
        this.cUR = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory aiL = com.baidu.swan.apps.t.a.azx().aiL();
        if (aiL != null) {
            this.cNv.getCurrentWebView().setVideoPlayerFactory(aiL);
        }
        atU();
        cI(context);
    }

    private void atU() {
        this.cNv.getSettings().setLoadWithOverviewMode(true);
        this.cNv.getSettings().setUseWideViewPort(true);
        this.cNv.getSettings().setSupportZoom(true);
        this.cNv.getSettings().setBuiltInZoomControls(true);
        this.cNv.getSettings().setDisplayZoomControls(false);
    }

    private void cI(Context context) {
        com.baidu.swan.apps.adaptation.a.b akx = com.baidu.swan.apps.runtime.d.aJQ().aJS().aiF().akx();
        if (akx != null) {
            akx.bR(context);
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
        aVar.cNO = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void apH() {
        super.apH();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cNA);
        fVar.c(this);
        this.cNA.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void apE() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (arQ() && !com.baidu.swan.apps.ag.a.b.sT(str)) {
            atZ().oh(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean arQ() {
        return this.cUP;
    }

    public void fp(boolean z) {
        this.cUP = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String ali() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d aln() {
        return this.cUL;
    }

    public void d(@Nullable d dVar) {
        this.cUL = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c atV() {
        if (this.cUI == null) {
            this.cUI = new c(alh().getContext(), alh());
        }
        return this.cUI;
    }

    public int atW() {
        EfficientProgressBar efficientProgressBar;
        if (this.cUI == null || (efficientProgressBar = this.cUI.cUY) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        atX();
    }

    private void atX() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b atY() {
        if (this.cUJ == null) {
            this.cUJ = new b(alh().getContext(), alh());
            this.cUJ.e(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.alh().getContext())) {
                        if (!SwanAppWebViewWidget.this.arQ() || com.baidu.swan.apps.ag.a.b.sT(SwanAppWebViewWidget.this.alh().getUrl())) {
                            SwanAppWebViewWidget.this.alh().reload();
                            SwanAppWebViewWidget.this.cUJ.auc();
                        }
                    }
                }
            });
        }
        return this.cUJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a atZ() {
        if (this.cUK == null) {
            this.cUK = new a(alh().getContext(), alh());
        }
        return this.cUK;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.cUv = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void alk() {
        super.alk();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cUv = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes25.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.atV().startProgress();
            SwanAppWebViewWidget.this.aua();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.atY().aud();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.atV().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri vd = ak.vd(str);
            if (vd != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.cNu, new Intent("android.intent.action.DIAL", vd));
                return true;
            } else if (SwanAppWebViewWidget.this.cUw != null) {
                return SwanAppWebViewWidget.this.cUw.jo(str);
            } else {
                if (!SwanAppWebViewWidget.this.arQ() || com.baidu.swan.apps.ag.a.b.sT(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cUQ) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.atZ().oh(str);
                            SwanAppWebViewWidget.this.alh().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean eV(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean apJ() {
                                    SwanAppWebViewWidget.this.atZ().auc();
                                    SwanAppWebViewWidget.this.alh().setOnWebViewHookHandler(null);
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

    /* loaded from: classes25.dex */
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
            if (SwanAppWebViewWidget.this.cUM == null) {
                SwanAppWebViewWidget.this.cUM = new e(SwanAppWebViewWidget.this.cNu.getBaseContext());
            }
            SwanAppWebViewWidget.this.cUM.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void onCustomViewHidden() {
                }
            });
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (!ai.isUrlAuxiliary(str)) {
                SwanAppWebViewWidget.this.mTitle = str;
                if (SwanAppWebViewWidget.this.cUv != null) {
                    SwanAppWebViewWidget.this.cUv.jn(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cUM != null) {
            this.cUM.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class c {
        private EfficientProgressBar cUY;

        public c(Context context, ViewGroup viewGroup) {
            this.cUY = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cUY = new EfficientProgressBar(context);
            this.cUY.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cUY.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cUY.setVisibility(4);
            this.cUY.setFocusable(false);
            this.cUY.setClickable(false);
            viewGroup.addView(this.cUY);
        }

        public void startProgress() {
            this.cUY.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cUY.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cUY.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class b {
        private NetworkErrorView cUX;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cUX = new NetworkErrorView(context);
            this.cUX.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cUX, new FrameLayout.LayoutParams(-1, -1));
            this.cUX.setVisibility(8);
        }

        public void aud() {
            this.cUX.setVisibility(0);
        }

        public void auc() {
            this.cUX.setVisibility(8);
        }

        public void e(View.OnClickListener onClickListener) {
            this.cUX.setOnClickListener(onClickListener);
            this.cUX.setReloadClickListener(onClickListener);
        }
    }

    public void aua() {
        final com.baidu.swan.apps.core.d.c arB;
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null && (arB = aim.arB()) != null && arB.getView() != null) {
            final View view = null;
            if (arB instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) arB).arq().ala() != null) {
                    view = arB.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (arB instanceof i) {
                if (((i) arB).ala() != null && arB.getView() != null) {
                    view = arB.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, arB);
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
            if (i != this.cUN) {
                if (this.cUN - i > this.cUR) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.aqq() && eVar.ari()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cUN = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private DomainErrorView cUW;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cUW = new DomainErrorView(context);
            this.cUW.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cUW, new FrameLayout.LayoutParams(-1, -1));
            this.cUW.setVisibility(8);
        }

        public void oh(String str) {
            this.cUW.sl(str);
            this.cUW.setVisibility(0);
        }

        public void auc() {
            this.cUW.setVisibility(8);
        }
    }

    /* loaded from: classes25.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cUx)) {
                com.baidu.swan.apps.performance.i.cl("route", SwanAppWebViewWidget.this.cUx).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUy.cAS = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cUx)) {
                com.baidu.swan.apps.performance.i.cl("route", SwanAppWebViewWidget.this.cUx).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUy.cAU = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cUy.cAY = "0";
            com.baidu.swan.apps.performance.a.f.aGp().aGq().bY(SwanAppWebViewWidget.this.cUy.cAU);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cUy.cAU);
            }
            HybridUbcFlow rm = com.baidu.swan.apps.performance.i.rm("startup");
            if (rm != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                rm.co("webviewComponent", str);
                rm.co("fmp_type", "0");
                rm.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppWebViewWidget.this.cUy.cAU).a(UbcFlowEvent.RecordType.UPDATE)).aFP();
                rm.q("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cUy.cAU), " , fmpType=", SwanAppWebViewWidget.this.cUy.cAY, " , fmpTypeName=", SwanAppWebViewWidget.this.cUy.alw());
                com.baidu.swan.apps.performance.i.amQ();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cUx)) {
                j.rA(SwanAppWebViewWidget.this.cUx);
                SwanAppWebViewWidget.this.cUx = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cUy.cAT = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aGp().aGq().cB(SwanAppWebViewWidget.this.cUy.cAT);
            final long alu = com.baidu.swan.apps.performance.i.dou ? currentTimeMillis : SwanAppWebViewWidget.this.cUy.alu();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + alu + " , aligned search=" + com.baidu.swan.apps.performance.i.dou);
            }
            final HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
            rk.f(new UbcFlowEvent("na_first_paint").cx(alu));
            if (SwanAppWebViewWidget.this.cUy.cAU == 0) {
                SwanAppWebViewWidget.this.cUy.cAU = alu;
                SwanAppWebViewWidget.this.cUy.cAY = SwanAppWebViewWidget.this.cUy.bS(alu);
                rk.co("fmp_type", "1");
                rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppWebViewWidget.this.cUy.cAT));
            }
            long ajf = com.baidu.swan.apps.t.a.azd().ajf();
            if (ajf < 0) {
                ajf = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.dou) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.fo(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cUy.cAU <= 0) {
                        j = alu;
                    } else {
                        j = SwanAppWebViewWidget.this.cUy.cAU;
                    }
                    rk.co("fmp_type", SwanAppWebViewWidget.this.cUy.cAY);
                    rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(j)).aFP();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cUy.cAY + " , fmpTypeName=" + SwanAppWebViewWidget.this.cUy.alw());
                    }
                }
            }, "fmp record", ajf, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUy.cAV = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aGp().aGq().bZ(SwanAppWebViewWidget.this.cUy.cAV);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cUy.cAV);
            }
            if (com.baidu.swan.apps.performance.i.dou) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.fo(false);
            } else if (SwanAppWebViewWidget.this.cUy.cAU == 0) {
                HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
                rk.co("fmp_type", "2");
                rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppWebViewWidget.this.cUy.cAV));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bt("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUy.cAW = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aGp().aGq().cA(SwanAppWebViewWidget.this.cUy.cAW);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cUy.cAW);
            }
            if (com.baidu.swan.apps.performance.i.dou) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.fo(false);
            } else if (SwanAppWebViewWidget.this.cUy.cAU == 0) {
                HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
                rk.co("fmp_type", "3");
                rk.f(new UbcFlowEvent("na_first_meaningful_paint").cx(SwanAppWebViewWidget.this.cUy.cAW));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.azd().aiW() && SwanAppWebViewWidget.this.arQ() && !com.baidu.swan.apps.ag.a.b.sT(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void og(String str) {
        this.cUO = str;
    }
}
