package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
    private static final String[] cVa = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d cUF;
    private c cUS;
    private b cUT;
    private a cUU;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cUV;
    private e cUW;
    private int cUX;
    private String cUY;
    private boolean cUZ;
    private int cVb;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cUZ = true;
        this.cVb = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory aga = com.baidu.swan.apps.t.a.awV().aga();
        if (aga != null) {
            this.cNE.getCurrentWebView().setVideoPlayerFactory(aga);
        }
        arr();
        cP(context);
    }

    private void arr() {
        this.cNE.getSettings().setLoadWithOverviewMode(true);
        this.cNE.getSettings().setUseWideViewPort(true);
        this.cNE.getSettings().setSupportZoom(true);
        this.cNE.getSettings().setBuiltInZoomControls(true);
        this.cNE.getSettings().setDisplayZoomControls(false);
    }

    private void cP(Context context) {
        com.baidu.swan.apps.adaptation.a.b ahO = com.baidu.swan.apps.runtime.d.aIn().aIp().afU().ahO();
        if (ahO != null) {
            ahO.bX(context);
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
        aVar.cNX = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amZ() {
        super.amZ();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cNJ);
        fVar.c(this);
        this.cNJ.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void amW() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (apo() && !com.baidu.swan.apps.af.a.b.rE(str)) {
            arw().mO(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean apo() {
        return this.cUZ;
    }

    public void fu(boolean z) {
        this.cUZ = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiz() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d aiE() {
        return this.cUV;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cUV = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ars() {
        if (this.cUS == null) {
            this.cUS = new c(aiy().getContext(), aiy());
        }
        return this.cUS;
    }

    public int art() {
        EfficientProgressBar efficientProgressBar;
        if (this.cUS == null || (efficientProgressBar = this.cUS.cVi) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        aru();
    }

    private void aru() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b arv() {
        if (this.cUT == null) {
            this.cUT = new b(aiy().getContext(), aiy());
            this.cUT.f(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aiy().getContext())) {
                        if (!SwanAppWebViewWidget.this.apo() || com.baidu.swan.apps.af.a.b.rE(SwanAppWebViewWidget.this.aiy().getUrl())) {
                            SwanAppWebViewWidget.this.aiy().reload();
                            SwanAppWebViewWidget.this.cUT.arz();
                        }
                    }
                }
            });
        }
        return this.cUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a arw() {
        if (this.cUU == null) {
            this.cUU = new a(aiy().getContext(), aiy());
        }
        return this.cUU;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cUF = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiB() {
        super.aiB();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cUF = null;
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
            SwanAppWebViewWidget.this.ars().arB();
            SwanAppWebViewWidget.this.arx();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.arv().arA();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.ars().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri tR = ak.tR(str);
            if (tR != null) {
                com.baidu.swan.apps.ao.e.f(SwanAppWebViewWidget.this.cND, new Intent("android.intent.action.DIAL", tR));
                return true;
            } else if (SwanAppWebViewWidget.this.cUG != null) {
                return SwanAppWebViewWidget.this.cUG.hW(str);
            } else {
                if (!SwanAppWebViewWidget.this.apo() || com.baidu.swan.apps.af.a.b.rE(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cVa) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.arw().mO(str);
                            SwanAppWebViewWidget.this.aiy().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean fa(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean anb() {
                                    SwanAppWebViewWidget.this.arw().arz();
                                    SwanAppWebViewWidget.this.aiy().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cUW == null) {
                SwanAppWebViewWidget.this.cUW = new e(SwanAppWebViewWidget.this.cND.getBaseContext());
            }
            SwanAppWebViewWidget.this.cUW.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cUF != null) {
                    SwanAppWebViewWidget.this.cUF.hV(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cUW != null) {
            this.cUW.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class c {
        private EfficientProgressBar cVi;

        public c(Context context, ViewGroup viewGroup) {
            this.cVi = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cVi = new EfficientProgressBar(context);
            this.cVi.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cVi.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cVi.setVisibility(4);
            this.cVi.setFocusable(false);
            this.cVi.setClickable(false);
            viewGroup.addView(this.cVi);
        }

        public void arB() {
            this.cVi.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cVi.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cVi.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private NetworkErrorView cVh;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cVh = new NetworkErrorView(context);
            this.cVh.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cVh, new FrameLayout.LayoutParams(-1, -1));
            this.cVh.setVisibility(8);
        }

        public void arA() {
            this.cVh.setVisibility(0);
        }

        public void arz() {
            this.cVh.setVisibility(8);
        }

        public void f(View.OnClickListener onClickListener) {
            this.cVh.setOnClickListener(onClickListener);
            this.cVh.setReloadClickListener(onClickListener);
        }
    }

    public void arx() {
        final com.baidu.swan.apps.core.d.c aoY;
        com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && (aoY = afz.aoY()) != null && aoY.getView() != null) {
            final View view = null;
            if (aoY instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) aoY).aoN().air() != null) {
                    view = aoY.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (aoY instanceof i) {
                if (((i) aoY).air() != null && aoY.getView() != null) {
                    view = aoY.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, aoY);
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
            if (i != this.cUX) {
                if (this.cUX - i > this.cVb) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.anI() && eVar.aoF()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cUX = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private DomainErrorView cVg;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cVg = new DomainErrorView(context);
            this.cVg.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cVg, new FrameLayout.LayoutParams(-1, -1));
            this.cVg.setVisibility(8);
        }

        public void mO(String str) {
            this.cVg.qT(str);
            this.cVg.setVisibility(0);
        }

        public void arz() {
            this.cVg.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cUH)) {
                com.baidu.swan.apps.performance.i.cj("route", SwanAppWebViewWidget.this.cUH).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUI.cAW = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cUH)) {
                com.baidu.swan.apps.performance.i.cj("route", SwanAppWebViewWidget.this.cUH).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUI.cAY = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cUI.cBc = "0";
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bZ(SwanAppWebViewWidget.this.cUI.cAY);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cUI.cAY);
            }
            HybridUbcFlow pU = com.baidu.swan.apps.performance.i.pU("startup");
            if (pU != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                pU.cm("webviewComponent", str);
                pU.cm("fmp_type", "0");
                pU.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cUI.cAY).a(UbcFlowEvent.RecordType.UPDATE)).aDq();
                pU.q("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cUI.cAY), " , fmpType=", SwanAppWebViewWidget.this.cUI.cBc, " , fmpTypeName=", SwanAppWebViewWidget.this.cUI.aiN());
                com.baidu.swan.apps.performance.i.akh();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cUH)) {
                j.qi(SwanAppWebViewWidget.this.cUH);
                SwanAppWebViewWidget.this.cUH = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cUI.cAX = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cC(SwanAppWebViewWidget.this.cUI.cAX);
            final long aiL = com.baidu.swan.apps.performance.i.doD ? currentTimeMillis : SwanAppWebViewWidget.this.cUI.aiL();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + aiL + " , aligned search=" + com.baidu.swan.apps.performance.i.doD);
            }
            final HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
            pS.f(new UbcFlowEvent("na_first_paint").cy(aiL));
            if (SwanAppWebViewWidget.this.cUI.cAY == 0) {
                SwanAppWebViewWidget.this.cUI.cAY = aiL;
                SwanAppWebViewWidget.this.cUI.cBc = SwanAppWebViewWidget.this.cUI.bT(aiL);
                pS.cm("fmp_type", "1");
                pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cUI.cAX));
            }
            long agu = com.baidu.swan.apps.t.a.awB().agu();
            if (agu < 0) {
                agu = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.doD) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.ft(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cUI.cAY <= 0) {
                        j = aiL;
                    } else {
                        j = SwanAppWebViewWidget.this.cUI.cAY;
                    }
                    pS.cm("fmp_type", SwanAppWebViewWidget.this.cUI.cBc);
                    pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(j)).aDq();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cUI.cBc + " , fmpTypeName=" + SwanAppWebViewWidget.this.cUI.aiN());
                    }
                }
            }, "fmp record", agu, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUI.cAZ = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().ca(SwanAppWebViewWidget.this.cUI.cAZ);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cUI.cAZ);
            }
            if (com.baidu.swan.apps.performance.i.doD) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.ft(false);
            } else if (SwanAppWebViewWidget.this.cUI.cAY == 0) {
                HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
                pS.cm("fmp_type", "2");
                pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cUI.cAZ));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.br("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cUI.cBa = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cB(SwanAppWebViewWidget.this.cUI.cBa);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cUI.cBa);
            }
            if (com.baidu.swan.apps.performance.i.doD) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.ft(false);
            } else if (SwanAppWebViewWidget.this.cUI.cAY == 0) {
                HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
                pS.cm("fmp_type", "3");
                pS.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cUI.cBa));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.awB().agl() && SwanAppWebViewWidget.this.apo() && !com.baidu.swan.apps.af.a.b.rE(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mN(String str) {
        this.cUY = str;
    }
}
