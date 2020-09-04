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
/* loaded from: classes8.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cna = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d cmF;
    private c cmS;
    private b cmT;
    private a cmU;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cmV;
    private e cmW;
    private int cmX;
    private String cmY;
    private boolean cmZ;
    private int cnb;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cmZ = true;
        this.cnb = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Yw = com.baidu.swan.apps.t.a.apg().Yw();
        if (Yw != null) {
            this.cfB.getCurrentWebView().setVideoPlayerFactory(Yw);
        }
        ajE();
        bX(context);
    }

    private void ajE() {
        this.cfB.getSettings().setLoadWithOverviewMode(true);
        this.cfB.getSettings().setUseWideViewPort(true);
        this.cfB.getSettings().setSupportZoom(true);
        this.cfB.getSettings().setBuiltInZoomControls(true);
        this.cfB.getSettings().setDisplayZoomControls(false);
    }

    private void bX(Context context) {
        com.baidu.swan.apps.adaptation.a.b aai = com.baidu.swan.apps.runtime.d.azE().azG().Yq().aai();
        if (aai != null) {
            aai.bg(context);
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
        aVar.cfU = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afs() {
        super.afs();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cfG);
        fVar.c(this);
        this.cfG.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (ahB() && !com.baidu.swan.apps.ag.a.b.qE(str)) {
            ajJ().lS(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean ahB() {
        return this.cmZ;
    }

    public void eh(boolean z) {
        this.cmZ = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaT() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d aaY() {
        return this.cmV;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cmV = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ajF() {
        if (this.cmS == null) {
            this.cmS = new c(aaS().getContext(), aaS());
        }
        return this.cmS;
    }

    public int ajG() {
        EfficientProgressBar efficientProgressBar;
        if (this.cmS == null || (efficientProgressBar = this.cmS.cni) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        ajH();
    }

    private void ajH() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b ajI() {
        if (this.cmT == null) {
            this.cmT = new b(aaS().getContext(), aaS());
            this.cmT.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aaS().getContext())) {
                        if (!SwanAppWebViewWidget.this.ahB() || com.baidu.swan.apps.ag.a.b.qE(SwanAppWebViewWidget.this.aaS().getUrl())) {
                            SwanAppWebViewWidget.this.aaS().reload();
                            SwanAppWebViewWidget.this.cmT.ajM();
                        }
                    }
                }
            });
        }
        return this.cmT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a ajJ() {
        if (this.cmU == null) {
            this.cmU = new a(aaS().getContext(), aaS());
        }
        return this.cmU;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cmF = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aaV() {
        super.aaV();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cmF = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.ajF().startProgress();
            SwanAppWebViewWidget.this.ajK();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.ajI().ajN();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.ajF().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri sP = ak.sP(str);
            if (sP != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.cfA, new Intent("android.intent.action.DIAL", sP));
                return true;
            } else if (SwanAppWebViewWidget.this.cmG != null) {
                return SwanAppWebViewWidget.this.cmG.hv(str);
            } else {
                if (!SwanAppWebViewWidget.this.ahB() || com.baidu.swan.apps.ag.a.b.qE(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cna) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.ajJ().lS(str);
                            SwanAppWebViewWidget.this.aaS().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dN(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean afu() {
                                    SwanAppWebViewWidget.this.ajJ().ajM();
                                    SwanAppWebViewWidget.this.aaS().setOnWebViewHookHandler(null);
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

    /* loaded from: classes8.dex */
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
            if (SwanAppWebViewWidget.this.cmW == null) {
                SwanAppWebViewWidget.this.cmW = new e(SwanAppWebViewWidget.this.cfA.getBaseContext());
            }
            SwanAppWebViewWidget.this.cmW.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cmF != null) {
                    SwanAppWebViewWidget.this.cmF.hu(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cmW != null) {
            this.cmW.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class c {
        private EfficientProgressBar cni;

        public c(Context context, ViewGroup viewGroup) {
            this.cni = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cni = new EfficientProgressBar(context);
            this.cni.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cni.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cni.setVisibility(4);
            this.cni.setFocusable(false);
            this.cni.setClickable(false);
            viewGroup.addView(this.cni);
        }

        public void startProgress() {
            this.cni.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cni.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cni.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private NetworkErrorView cnh;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cnh = new NetworkErrorView(context);
            this.cnh.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cnh, new FrameLayout.LayoutParams(-1, -1));
            this.cnh.setVisibility(8);
        }

        public void ajN() {
            this.cnh.setVisibility(0);
        }

        public void ajM() {
            this.cnh.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cnh.setOnClickListener(onClickListener);
            this.cnh.setReloadClickListener(onClickListener);
        }
    }

    public void ajK() {
        final com.baidu.swan.apps.core.d.c ahm;
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null && (ahm = XX.ahm()) != null && ahm.getView() != null) {
            final View view = null;
            if (ahm instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) ahm).ahb().aaL() != null) {
                    view = ahm.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (ahm instanceof i) {
                if (((i) ahm).aaL() != null && ahm.getView() != null) {
                    view = ahm.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, ahm);
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
            if (i != this.cmX) {
                if (this.cmX - i > this.cnb) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.agb() && eVar.agT()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cmX = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private DomainErrorView cng;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cng = new DomainErrorView(context);
            this.cng.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cng, new FrameLayout.LayoutParams(-1, -1));
            this.cng.setVisibility(8);
        }

        public void lS(String str) {
            this.cng.pY(str);
            this.cng.setVisibility(0);
        }

        public void ajM() {
            this.cng.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cmH)) {
                com.baidu.swan.apps.performance.i.bT("route", SwanAppWebViewWidget.this.cmH).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmI.bSX = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cmH)) {
                com.baidu.swan.apps.performance.i.bT("route", SwanAppWebViewWidget.this.cmH).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmI.bSZ = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cmI.bTd = "0";
            com.baidu.swan.apps.performance.a.f.awb().awc().aS(SwanAppWebViewWidget.this.cmI.bSZ);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cmI.bSZ);
            }
            HybridUbcFlow oZ = com.baidu.swan.apps.performance.i.oZ("startup");
            if (oZ != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                oZ.bW("webviewComponent", str);
                oZ.bW("fmp_type", "0");
                oZ.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmI.bSZ).a(UbcFlowEvent.RecordType.UPDATE)).avB();
                oZ.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cmI.bSZ), " , fmpType=", SwanAppWebViewWidget.this.cmI.bTd, " , fmpTypeName=", SwanAppWebViewWidget.this.cmI.abh());
                com.baidu.swan.apps.performance.i.acB();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cmH)) {
                j.pn(SwanAppWebViewWidget.this.cmH);
                SwanAppWebViewWidget.this.cmH = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cmI.bSY = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.awb().awc().bv(SwanAppWebViewWidget.this.cmI.bSY);
            final long abf = com.baidu.swan.apps.performance.i.cGD ? currentTimeMillis : SwanAppWebViewWidget.this.cmI.abf();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + abf + " , aligned search=" + com.baidu.swan.apps.performance.i.cGD);
            }
            final HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
            oX.f(new UbcFlowEvent("na_first_paint").br(abf));
            if (SwanAppWebViewWidget.this.cmI.bSZ == 0) {
                SwanAppWebViewWidget.this.cmI.bSZ = abf;
                SwanAppWebViewWidget.this.cmI.bTd = SwanAppWebViewWidget.this.cmI.aM(abf);
                oX.bW("fmp_type", "1");
                oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmI.bSY));
            }
            long YQ = com.baidu.swan.apps.t.a.aoM().YQ();
            if (YQ < 0) {
                YQ = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.cGD) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.eg(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cmI.bSZ <= 0) {
                        j = abf;
                    } else {
                        j = SwanAppWebViewWidget.this.cmI.bSZ;
                    }
                    oX.bW("fmp_type", SwanAppWebViewWidget.this.cmI.bTd);
                    oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(j)).avB();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cmI.bTd + " , fmpTypeName=" + SwanAppWebViewWidget.this.cmI.abh());
                    }
                }
            }, "fmp record", YQ, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmI.bTa = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().aT(SwanAppWebViewWidget.this.cmI.bTa);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cmI.bTa);
            }
            if (com.baidu.swan.apps.performance.i.cGD) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.eg(false);
            } else if (SwanAppWebViewWidget.this.cmI.bSZ == 0) {
                HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
                oX.bW("fmp_type", "2");
                oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmI.bTa));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmI.bTb = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().bu(SwanAppWebViewWidget.this.cmI.bTb);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cmI.bTb);
            }
            if (com.baidu.swan.apps.performance.i.cGD) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.eg(false);
            } else if (SwanAppWebViewWidget.this.cmI.bSZ == 0) {
                HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
                oX.bW("fmp_type", "3");
                oX.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmI.bTb));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.aoM().YH() && SwanAppWebViewWidget.this.ahB() && !com.baidu.swan.apps.ag.a.b.qE(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lR(String str) {
        this.cmY = str;
    }
}
