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
/* loaded from: classes8.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cYN = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private c cYF;
    private b cYG;
    private a cYH;
    @Nullable
    private d cYI;
    private e cYJ;
    private int cYK;
    private String cYL;
    private boolean cYM;
    private int cYO;
    protected com.baidu.swan.apps.core.f.d cYs;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cYM = true;
        this.cYO = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory agB = com.baidu.swan.apps.t.a.axw().agB();
        if (agB != null) {
            this.cRs.getCurrentWebView().setVideoPlayerFactory(agB);
        }
        arS();
        cN(context);
    }

    private void arS() {
        this.cRs.getSettings().setLoadWithOverviewMode(true);
        this.cRs.getSettings().setUseWideViewPort(true);
        this.cRs.getSettings().setSupportZoom(true);
        this.cRs.getSettings().setBuiltInZoomControls(true);
        this.cRs.getSettings().setDisplayZoomControls(false);
    }

    private void cN(Context context) {
        com.baidu.swan.apps.adaptation.a.b aip = com.baidu.swan.apps.runtime.d.aIJ().aIL().agv().aip();
        if (aip != null) {
            aip.bV(context);
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
        aVar.cRL = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anA() {
        super.anA();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cRx);
        fVar.c(this);
        this.cRx.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anx() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (apP() && !com.baidu.swan.apps.af.a.b.se(str)) {
            arX().nn(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean apP() {
        return this.cYM;
    }

    public void fw(boolean z) {
        this.cYM = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aja() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d ajf() {
        return this.cYI;
    }

    public void d(@Nullable d dVar) {
        this.cYI = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c arT() {
        if (this.cYF == null) {
            this.cYF = new c(aiZ().getContext(), aiZ());
        }
        return this.cYF;
    }

    public int arU() {
        EfficientProgressBar efficientProgressBar;
        if (this.cYF == null || (efficientProgressBar = this.cYF.cYV) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        arV();
    }

    private void arV() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b arW() {
        if (this.cYG == null) {
            this.cYG = new b(aiZ().getContext(), aiZ());
            this.cYG.f(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aiZ().getContext())) {
                        if (!SwanAppWebViewWidget.this.apP() || com.baidu.swan.apps.af.a.b.se(SwanAppWebViewWidget.this.aiZ().getUrl())) {
                            SwanAppWebViewWidget.this.aiZ().reload();
                            SwanAppWebViewWidget.this.cYG.asa();
                        }
                    }
                }
            });
        }
        return this.cYG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a arX() {
        if (this.cYH == null) {
            this.cYH = new a(aiZ().getContext(), aiZ());
        }
        return this.cYH;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.cYs = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void ajc() {
        super.ajc();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cYs = null;
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
            SwanAppWebViewWidget.this.arT().asc();
            SwanAppWebViewWidget.this.arY();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.arW().asb();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.arT().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri ur = ak.ur(str);
            if (ur != null) {
                com.baidu.swan.apps.ao.e.f(SwanAppWebViewWidget.this.cRr, new Intent("android.intent.action.DIAL", ur));
                return true;
            } else if (SwanAppWebViewWidget.this.cYt != null) {
                return SwanAppWebViewWidget.this.cYt.iC(str);
            } else {
                if (!SwanAppWebViewWidget.this.apP() || com.baidu.swan.apps.af.a.b.se(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cYN) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.arX().nn(str);
                            SwanAppWebViewWidget.this.aiZ().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean fc(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean anC() {
                                    SwanAppWebViewWidget.this.arX().asa();
                                    SwanAppWebViewWidget.this.aiZ().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cYJ == null) {
                SwanAppWebViewWidget.this.cYJ = new e(SwanAppWebViewWidget.this.cRr.getBaseContext());
            }
            SwanAppWebViewWidget.this.cYJ.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cYs != null) {
                    SwanAppWebViewWidget.this.cYs.iB(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cYJ != null) {
            this.cYJ.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class c {
        private EfficientProgressBar cYV;

        public c(Context context, ViewGroup viewGroup) {
            this.cYV = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cYV = new EfficientProgressBar(context);
            this.cYV.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cYV.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cYV.setVisibility(4);
            this.cYV.setFocusable(false);
            this.cYV.setClickable(false);
            viewGroup.addView(this.cYV);
        }

        public void asc() {
            this.cYV.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cYV.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cYV.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private NetworkErrorView cYU;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cYU = new NetworkErrorView(context);
            this.cYU.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cYU, new FrameLayout.LayoutParams(-1, -1));
            this.cYU.setVisibility(8);
        }

        public void asb() {
            this.cYU.setVisibility(0);
        }

        public void asa() {
            this.cYU.setVisibility(8);
        }

        public void f(View.OnClickListener onClickListener) {
            this.cYU.setOnClickListener(onClickListener);
            this.cYU.setReloadClickListener(onClickListener);
        }
    }

    public void arY() {
        final com.baidu.swan.apps.core.d.c apA;
        com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null && (apA = aga.apA()) != null && apA.getView() != null) {
            final View view = null;
            if (apA instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) apA).app().aiS() != null) {
                    view = apA.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (apA instanceof i) {
                if (((i) apA).aiS() != null && apA.getView() != null) {
                    view = apA.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, apA);
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
            if (i != this.cYK) {
                if (this.cYK - i > this.cYO) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.aoj() && eVar.apg()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cYK = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private DomainErrorView cYT;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cYT = new DomainErrorView(context);
            this.cYT.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cYT, new FrameLayout.LayoutParams(-1, -1));
            this.cYT.setVisibility(8);
        }

        public void nn(String str) {
            this.cYT.rt(str);
            this.cYT.setVisibility(0);
        }

        public void asa() {
            this.cYT.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cYu)) {
                com.baidu.swan.apps.performance.i.cd("route", SwanAppWebViewWidget.this.cYu).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cYv.cES = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cYu)) {
                com.baidu.swan.apps.performance.i.cd("route", SwanAppWebViewWidget.this.cYu).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cYv.cEU = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cYv.cEY = "0";
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cf(SwanAppWebViewWidget.this.cYv.cEU);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cYv.cEU);
            }
            HybridUbcFlow qt = com.baidu.swan.apps.performance.i.qt("startup");
            if (qt != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                qt.cg("webviewComponent", str);
                qt.cg("fmp_type", "0");
                qt.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cYv.cEU).a(UbcFlowEvent.RecordType.UPDATE)).aDP();
                qt.p("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cYv.cEU), " , fmpType=", SwanAppWebViewWidget.this.cYv.cEY, " , fmpTypeName=", SwanAppWebViewWidget.this.cYv.ajo());
                com.baidu.swan.apps.performance.i.akI();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cYu)) {
                j.qH(SwanAppWebViewWidget.this.cYu);
                SwanAppWebViewWidget.this.cYu = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cYv.cET = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cI(SwanAppWebViewWidget.this.cYv.cET);
            final long ajm = com.baidu.swan.apps.performance.i.dsq ? currentTimeMillis : SwanAppWebViewWidget.this.cYv.ajm();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + ajm + " , aligned search=" + com.baidu.swan.apps.performance.i.dsq);
            }
            final HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
            qr.f(new UbcFlowEvent("na_first_paint").cE(ajm));
            if (SwanAppWebViewWidget.this.cYv.cEU == 0) {
                SwanAppWebViewWidget.this.cYv.cEU = ajm;
                SwanAppWebViewWidget.this.cYv.cEY = SwanAppWebViewWidget.this.cYv.bZ(ajm);
                qr.cg("fmp_type", "1");
                qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cYv.cET));
            }
            long agV = com.baidu.swan.apps.t.a.axc().agV();
            if (agV < 0) {
                agV = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.dsq) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.fv(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cYv.cEU <= 0) {
                        j = ajm;
                    } else {
                        j = SwanAppWebViewWidget.this.cYv.cEU;
                    }
                    qr.cg("fmp_type", SwanAppWebViewWidget.this.cYv.cEY);
                    qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(j)).aDP();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cYv.cEY + " , fmpTypeName=" + SwanAppWebViewWidget.this.cYv.ajo());
                    }
                }
            }, "fmp record", agV, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cYv.cEV = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cg(SwanAppWebViewWidget.this.cYv.cEV);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cYv.cEV);
            }
            if (com.baidu.swan.apps.performance.i.dsq) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.fv(false);
            } else if (SwanAppWebViewWidget.this.cYv.cEU == 0) {
                HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
                qr.cg("fmp_type", "2");
                qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cYv.cEV));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cYv.cEW = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEn().aEo().cH(SwanAppWebViewWidget.this.cYv.cEW);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cYv.cEW);
            }
            if (com.baidu.swan.apps.performance.i.dsq) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.fv(false);
            } else if (SwanAppWebViewWidget.this.cYv.cEU == 0) {
                HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
                qr.cg("fmp_type", "3");
                qr.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cYv.cEW));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.axc().agM() && SwanAppWebViewWidget.this.apP() && !com.baidu.swan.apps.af.a.b.se(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nm(String str) {
        this.cYL = str;
    }
}
