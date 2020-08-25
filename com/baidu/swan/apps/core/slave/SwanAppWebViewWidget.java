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
    private static final String[] cmW = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d cmB;
    private c cmO;
    private b cmP;
    private a cmQ;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cmR;
    private e cmS;
    private int cmT;
    private String cmU;
    private boolean cmV;
    private int cmX;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cmV = true;
        this.cmX = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Yw = com.baidu.swan.apps.t.a.apg().Yw();
        if (Yw != null) {
            this.cfx.getCurrentWebView().setVideoPlayerFactory(Yw);
        }
        ajE();
        bX(context);
    }

    private void ajE() {
        this.cfx.getSettings().setLoadWithOverviewMode(true);
        this.cfx.getSettings().setUseWideViewPort(true);
        this.cfx.getSettings().setSupportZoom(true);
        this.cfx.getSettings().setBuiltInZoomControls(true);
        this.cfx.getSettings().setDisplayZoomControls(false);
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
        aVar.cfQ = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afs() {
        super.afs();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cfC);
        fVar.c(this);
        this.cfC.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afp() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (ahB() && !com.baidu.swan.apps.ag.a.b.qD(str)) {
            ajJ().lR(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean ahB() {
        return this.cmV;
    }

    public void eg(boolean z) {
        this.cmV = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaT() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d aaY() {
        return this.cmR;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cmR = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ajF() {
        if (this.cmO == null) {
            this.cmO = new c(aaS().getContext(), aaS());
        }
        return this.cmO;
    }

    public int ajG() {
        EfficientProgressBar efficientProgressBar;
        if (this.cmO == null || (efficientProgressBar = this.cmO.cne) == null) {
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
        if (this.cmP == null) {
            this.cmP = new b(aaS().getContext(), aaS());
            this.cmP.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aaS().getContext())) {
                        if (!SwanAppWebViewWidget.this.ahB() || com.baidu.swan.apps.ag.a.b.qD(SwanAppWebViewWidget.this.aaS().getUrl())) {
                            SwanAppWebViewWidget.this.aaS().reload();
                            SwanAppWebViewWidget.this.cmP.ajM();
                        }
                    }
                }
            });
        }
        return this.cmP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a ajJ() {
        if (this.cmQ == null) {
            this.cmQ = new a(aaS().getContext(), aaS());
        }
        return this.cmQ;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cmB = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aaV() {
        super.aaV();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cmB = null;
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
            Uri sO = ak.sO(str);
            if (sO != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.cfw, new Intent("android.intent.action.DIAL", sO));
                return true;
            } else if (SwanAppWebViewWidget.this.cmC != null) {
                return SwanAppWebViewWidget.this.cmC.hu(str);
            } else {
                if (!SwanAppWebViewWidget.this.ahB() || com.baidu.swan.apps.ag.a.b.qD(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cmW) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.ajJ().lR(str);
                            SwanAppWebViewWidget.this.aaS().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dM(boolean z) {
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
            if (SwanAppWebViewWidget.this.cmS == null) {
                SwanAppWebViewWidget.this.cmS = new e(SwanAppWebViewWidget.this.cfw.getBaseContext());
            }
            SwanAppWebViewWidget.this.cmS.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cmB != null) {
                    SwanAppWebViewWidget.this.cmB.ht(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cmS != null) {
            this.cmS.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class c {
        private EfficientProgressBar cne;

        public c(Context context, ViewGroup viewGroup) {
            this.cne = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cne = new EfficientProgressBar(context);
            this.cne.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cne.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cne.setVisibility(4);
            this.cne.setFocusable(false);
            this.cne.setClickable(false);
            viewGroup.addView(this.cne);
        }

        public void startProgress() {
            this.cne.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cne.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cne.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private NetworkErrorView cnd;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cnd = new NetworkErrorView(context);
            this.cnd.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cnd, new FrameLayout.LayoutParams(-1, -1));
            this.cnd.setVisibility(8);
        }

        public void ajN() {
            this.cnd.setVisibility(0);
        }

        public void ajM() {
            this.cnd.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cnd.setOnClickListener(onClickListener);
            this.cnd.setReloadClickListener(onClickListener);
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
            if (i != this.cmT) {
                if (this.cmT - i > this.cmX) {
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
                this.cmT = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private DomainErrorView cnc;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cnc = new DomainErrorView(context);
            this.cnc.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cnc, new FrameLayout.LayoutParams(-1, -1));
            this.cnc.setVisibility(8);
        }

        public void lR(String str) {
            this.cnc.pX(str);
            this.cnc.setVisibility(0);
        }

        public void ajM() {
            this.cnc.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cmD)) {
                com.baidu.swan.apps.performance.i.bT("route", SwanAppWebViewWidget.this.cmD).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmE.bST = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cmD)) {
                com.baidu.swan.apps.performance.i.bT("route", SwanAppWebViewWidget.this.cmD).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmE.bSV = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cmE.bSZ = "0";
            com.baidu.swan.apps.performance.a.f.awb().awc().aS(SwanAppWebViewWidget.this.cmE.bSV);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cmE.bSV);
            }
            HybridUbcFlow oY = com.baidu.swan.apps.performance.i.oY("startup");
            if (oY != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                oY.bW("webviewComponent", str);
                oY.bW("fmp_type", "0");
                oY.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmE.bSV).a(UbcFlowEvent.RecordType.UPDATE)).avB();
                oY.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cmE.bSV), " , fmpType=", SwanAppWebViewWidget.this.cmE.bSZ, " , fmpTypeName=", SwanAppWebViewWidget.this.cmE.abh());
                com.baidu.swan.apps.performance.i.acB();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cmD)) {
                j.pm(SwanAppWebViewWidget.this.cmD);
                SwanAppWebViewWidget.this.cmD = "";
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
            SwanAppWebViewWidget.this.cmE.bSU = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.awb().awc().bv(SwanAppWebViewWidget.this.cmE.bSU);
            final long abf = com.baidu.swan.apps.performance.i.cGz ? currentTimeMillis : SwanAppWebViewWidget.this.cmE.abf();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + abf + " , aligned search=" + com.baidu.swan.apps.performance.i.cGz);
            }
            final HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
            oW.f(new UbcFlowEvent("na_first_paint").br(abf));
            if (SwanAppWebViewWidget.this.cmE.bSV == 0) {
                SwanAppWebViewWidget.this.cmE.bSV = abf;
                SwanAppWebViewWidget.this.cmE.bSZ = SwanAppWebViewWidget.this.cmE.aM(abf);
                oW.bW("fmp_type", "1");
                oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmE.bSU));
            }
            long YQ = com.baidu.swan.apps.t.a.aoM().YQ();
            if (YQ < 0) {
                YQ = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.cGz) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.ef(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cmE.bSV <= 0) {
                        j = abf;
                    } else {
                        j = SwanAppWebViewWidget.this.cmE.bSV;
                    }
                    oW.bW("fmp_type", SwanAppWebViewWidget.this.cmE.bSZ);
                    oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(j)).avB();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cmE.bSZ + " , fmpTypeName=" + SwanAppWebViewWidget.this.cmE.abh());
                    }
                }
            }, "fmp record", YQ, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmE.bSW = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().aT(SwanAppWebViewWidget.this.cmE.bSW);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cmE.bSW);
            }
            if (com.baidu.swan.apps.performance.i.cGz) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.ef(false);
            } else if (SwanAppWebViewWidget.this.cmE.bSV == 0) {
                HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
                oW.bW("fmp_type", "2");
                oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmE.bSW));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cmE.bSX = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awb().awc().bu(SwanAppWebViewWidget.this.cmE.bSX);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cmE.bSX);
            }
            if (com.baidu.swan.apps.performance.i.cGz) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.ef(false);
            } else if (SwanAppWebViewWidget.this.cmE.bSV == 0) {
                HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
                oW.bW("fmp_type", "3");
                oW.f(new UbcFlowEvent("na_first_meaningful_paint").br(SwanAppWebViewWidget.this.cmE.bSX));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.aoM().YH() && SwanAppWebViewWidget.this.ahB() && !com.baidu.swan.apps.ag.a.b.qD(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lQ(String str) {
        this.cmU = str;
    }
}
