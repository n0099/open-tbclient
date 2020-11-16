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
import com.baidu.swan.apps.core.f.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.j;
import com.baidu.swan.apps.res.ui.DomainErrorView;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cNX = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d cNC;
    private c cNP;
    private b cNQ;
    private a cNR;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cNS;
    private e cNT;
    private int cNU;
    private String cNV;
    private boolean cNW;
    private int cNY;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cNW = true;
        this.cNY = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory afD = com.baidu.swan.apps.t.a.awp().afD();
        if (afD != null) {
            this.cGB.getCurrentWebView().setVideoPlayerFactory(afD);
        }
        aqM();
        cc(context);
    }

    private void aqM() {
        this.cGB.getSettings().setLoadWithOverviewMode(true);
        this.cGB.getSettings().setUseWideViewPort(true);
        this.cGB.getSettings().setSupportZoom(true);
        this.cGB.getSettings().setBuiltInZoomControls(true);
        this.cGB.getSettings().setDisplayZoomControls(false);
    }

    private void cc(Context context) {
        com.baidu.swan.apps.adaptation.a.b ahp = com.baidu.swan.apps.runtime.d.aGI().aGK().afx().ahp();
        if (ahp != null) {
            ahp.bl(context);
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
        aVar.cGU = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amz() {
        super.amz();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cGG);
        fVar.c(this);
        this.cGG.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amw() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (aoI() && !com.baidu.swan.apps.ag.a.b.sl(str)) {
            aqR().nz(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean aoI() {
        return this.cNW;
    }

    public void fa(boolean z) {
        this.cNW = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aia() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d aif() {
        return this.cNS;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cNS = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aqN() {
        if (this.cNP == null) {
            this.cNP = new c(ahZ().getContext(), ahZ());
        }
        return this.cNP;
    }

    public int aqO() {
        EfficientProgressBar efficientProgressBar;
        if (this.cNP == null || (efficientProgressBar = this.cNP.cOf) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        aqP();
    }

    private void aqP() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aqQ() {
        if (this.cNQ == null) {
            this.cNQ = new b(ahZ().getContext(), ahZ());
            this.cNQ.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.ahZ().getContext())) {
                        if (!SwanAppWebViewWidget.this.aoI() || com.baidu.swan.apps.ag.a.b.sl(SwanAppWebViewWidget.this.ahZ().getUrl())) {
                            SwanAppWebViewWidget.this.ahZ().reload();
                            SwanAppWebViewWidget.this.cNQ.aqU();
                        }
                    }
                }
            });
        }
        return this.cNQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a aqR() {
        if (this.cNR == null) {
            this.cNR = new a(ahZ().getContext(), ahZ());
        }
        return this.cNR;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cNC = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aic() {
        super.aic();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cNC = null;
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
            SwanAppWebViewWidget.this.aqN().startProgress();
            SwanAppWebViewWidget.this.aqS();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.aqQ().aqV();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.aqN().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri uw = ak.uw(str);
            if (uw != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.cGA, new Intent("android.intent.action.DIAL", uw));
                return true;
            } else if (SwanAppWebViewWidget.this.cND != null) {
                return SwanAppWebViewWidget.this.cND.iK(str);
            } else {
                if (!SwanAppWebViewWidget.this.aoI() || com.baidu.swan.apps.ag.a.b.sl(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cNX) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.aqR().nz(str);
                            SwanAppWebViewWidget.this.ahZ().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean eG(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean amB() {
                                    SwanAppWebViewWidget.this.aqR().aqU();
                                    SwanAppWebViewWidget.this.ahZ().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cNT == null) {
                SwanAppWebViewWidget.this.cNT = new e(SwanAppWebViewWidget.this.cGA.getBaseContext());
            }
            SwanAppWebViewWidget.this.cNT.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cNC != null) {
                    SwanAppWebViewWidget.this.cNC.iJ(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cNT != null) {
            this.cNT.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c {
        private EfficientProgressBar cOf;

        public c(Context context, ViewGroup viewGroup) {
            this.cOf = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cOf = new EfficientProgressBar(context);
            this.cOf.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cOf.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cOf.setVisibility(4);
            this.cOf.setFocusable(false);
            this.cOf.setClickable(false);
            viewGroup.addView(this.cOf);
        }

        public void startProgress() {
            this.cOf.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cOf.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cOf.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        private NetworkErrorView cOe;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cOe = new NetworkErrorView(context);
            this.cOe.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cOe, new FrameLayout.LayoutParams(-1, -1));
            this.cOe.setVisibility(8);
        }

        public void aqV() {
            this.cOe.setVisibility(0);
        }

        public void aqU() {
            this.cOe.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cOe.setOnClickListener(onClickListener);
            this.cOe.setReloadClickListener(onClickListener);
        }
    }

    public void aqS() {
        final com.baidu.swan.apps.core.d.c aot;
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null && (aot = afe.aot()) != null && aot.getView() != null) {
            final View view = null;
            if (aot instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) aot).aoi().ahS() != null) {
                    view = aot.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (aot instanceof i) {
                if (((i) aot).ahS() != null && aot.getView() != null) {
                    view = aot.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, aot);
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
            if (i != this.cNU) {
                if (this.cNU - i > this.cNY) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.ani() && eVar.aoa()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cNU = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private DomainErrorView cOd;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cOd = new DomainErrorView(context);
            this.cOd.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cOd, new FrameLayout.LayoutParams(-1, -1));
            this.cOd.setVisibility(8);
        }

        public void nz(String str) {
            this.cOd.rE(str);
            this.cOd.setVisibility(0);
        }

        public void aqU() {
            this.cOd.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cNE)) {
                com.baidu.swan.apps.performance.i.ce("route", SwanAppWebViewWidget.this.cNE).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cNF.ctY = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cNE)) {
                com.baidu.swan.apps.performance.i.ce("route", SwanAppWebViewWidget.this.cNE).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cNF.cua = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cNF.cue = "0";
            com.baidu.swan.apps.performance.a.f.aDh().aDi().bz(SwanAppWebViewWidget.this.cNF.cua);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cNF.cua);
            }
            HybridUbcFlow qF = com.baidu.swan.apps.performance.i.qF("startup");
            if (qF != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                qF.ch("webviewComponent", str);
                qF.ch("fmp_type", "0");
                qF.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cNF.cua).a(UbcFlowEvent.RecordType.UPDATE)).aCH();
                qF.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cNF.cua), " , fmpType=", SwanAppWebViewWidget.this.cNF.cue, " , fmpTypeName=", SwanAppWebViewWidget.this.cNF.aio());
                com.baidu.swan.apps.performance.i.ajI();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cNE)) {
                j.qT(SwanAppWebViewWidget.this.cNE);
                SwanAppWebViewWidget.this.cNE = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cNF.ctZ = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aDh().aDi().cc(SwanAppWebViewWidget.this.cNF.ctZ);
            final long aim = com.baidu.swan.apps.performance.i.dhs ? currentTimeMillis : SwanAppWebViewWidget.this.cNF.aim();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + aim + " , aligned search=" + com.baidu.swan.apps.performance.i.dhs);
            }
            final HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
            qD.f(new UbcFlowEvent("na_first_paint").bY(aim));
            if (SwanAppWebViewWidget.this.cNF.cua == 0) {
                SwanAppWebViewWidget.this.cNF.cua = aim;
                SwanAppWebViewWidget.this.cNF.cue = SwanAppWebViewWidget.this.cNF.bt(aim);
                qD.ch("fmp_type", "1");
                qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cNF.ctZ));
            }
            long afX = com.baidu.swan.apps.t.a.avV().afX();
            if (afX < 0) {
                afX = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.dhs) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.eZ(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cNF.cua <= 0) {
                        j = aim;
                    } else {
                        j = SwanAppWebViewWidget.this.cNF.cua;
                    }
                    qD.ch("fmp_type", SwanAppWebViewWidget.this.cNF.cue);
                    qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(j)).aCH();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cNF.cue + " , fmpTypeName=" + SwanAppWebViewWidget.this.cNF.aio());
                    }
                }
            }, "fmp record", afX, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cNF.cub = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDh().aDi().bA(SwanAppWebViewWidget.this.cNF.cub);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cNF.cub);
            }
            if (com.baidu.swan.apps.performance.i.dhs) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.eZ(false);
            } else if (SwanAppWebViewWidget.this.cNF.cua == 0) {
                HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
                qD.ch("fmp_type", "2");
                qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cNF.cub));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bm("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cNF.cuc = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDh().aDi().cb(SwanAppWebViewWidget.this.cNF.cuc);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cNF.cuc);
            }
            if (com.baidu.swan.apps.performance.i.dhs) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.eZ(false);
            } else if (SwanAppWebViewWidget.this.cNF.cua == 0) {
                HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
                qD.ch("fmp_type", "3");
                qD.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cNF.cuc));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.avV().afO() && SwanAppWebViewWidget.this.aoI() && !com.baidu.swan.apps.ag.a.b.sl(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ny(String str) {
        this.cNV = str;
    }
}
