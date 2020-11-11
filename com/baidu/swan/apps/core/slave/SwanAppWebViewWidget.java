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
/* loaded from: classes10.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cPH = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private b cPA;
    private a cPB;
    @Nullable
    private d cPC;
    private e cPD;
    private int cPE;
    private String cPF;
    private boolean cPG;
    private int cPI;
    protected com.baidu.swan.apps.core.f.d cPm;
    private c cPz;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cPG = true;
        this.cPI = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory agl = com.baidu.swan.apps.t.a.awX().agl();
        if (agl != null) {
            this.cIl.getCurrentWebView().setVideoPlayerFactory(agl);
        }
        aru();
        cc(context);
    }

    private void aru() {
        this.cIl.getSettings().setLoadWithOverviewMode(true);
        this.cIl.getSettings().setUseWideViewPort(true);
        this.cIl.getSettings().setSupportZoom(true);
        this.cIl.getSettings().setBuiltInZoomControls(true);
        this.cIl.getSettings().setDisplayZoomControls(false);
    }

    private void cc(Context context) {
        com.baidu.swan.apps.adaptation.a.b ahX = com.baidu.swan.apps.runtime.d.aHq().aHs().agf().ahX();
        if (ahX != null) {
            ahX.bl(context);
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
        aVar.cIE = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anh() {
        super.anh();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cIq);
        fVar.c(this);
        this.cIq.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void ane() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (apr() && !com.baidu.swan.apps.ag.a.b.sq(str)) {
            arz().nF(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean apr() {
        return this.cPG;
    }

    public void eX(boolean z) {
        this.cPG = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiI() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d aiN() {
        return this.cPC;
    }

    public void d(@Nullable d dVar) {
        this.cPC = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c arv() {
        if (this.cPz == null) {
            this.cPz = new c(aiH().getContext(), aiH());
        }
        return this.cPz;
    }

    public int arw() {
        EfficientProgressBar efficientProgressBar;
        if (this.cPz == null || (efficientProgressBar = this.cPz.cPP) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        arx();
    }

    private void arx() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b ary() {
        if (this.cPA == null) {
            this.cPA = new b(aiH().getContext(), aiH());
            this.cPA.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aiH().getContext())) {
                        if (!SwanAppWebViewWidget.this.apr() || com.baidu.swan.apps.ag.a.b.sq(SwanAppWebViewWidget.this.aiH().getUrl())) {
                            SwanAppWebViewWidget.this.aiH().reload();
                            SwanAppWebViewWidget.this.cPA.arC();
                        }
                    }
                }
            });
        }
        return this.cPA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a arz() {
        if (this.cPB == null) {
            this.cPB = new a(aiH().getContext(), aiH());
        }
        return this.cPB;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.cPm = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiK() {
        super.aiK();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cPm = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.arv().startProgress();
            SwanAppWebViewWidget.this.arA();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.ary().arD();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.arv().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri uB = ak.uB(str);
            if (uB != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.cIk, new Intent("android.intent.action.DIAL", uB));
                return true;
            } else if (SwanAppWebViewWidget.this.cPn != null) {
                return SwanAppWebViewWidget.this.cPn.iQ(str);
            } else {
                if (!SwanAppWebViewWidget.this.apr() || com.baidu.swan.apps.ag.a.b.sq(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cPH) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.arz().nF(str);
                            SwanAppWebViewWidget.this.aiH().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean eD(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean anj() {
                                    SwanAppWebViewWidget.this.arz().arC();
                                    SwanAppWebViewWidget.this.aiH().setOnWebViewHookHandler(null);
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

    /* loaded from: classes10.dex */
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
            if (SwanAppWebViewWidget.this.cPD == null) {
                SwanAppWebViewWidget.this.cPD = new e(SwanAppWebViewWidget.this.cIk.getBaseContext());
            }
            SwanAppWebViewWidget.this.cPD.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cPm != null) {
                    SwanAppWebViewWidget.this.cPm.iP(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cPD != null) {
            this.cPD.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private EfficientProgressBar cPP;

        public c(Context context, ViewGroup viewGroup) {
            this.cPP = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cPP = new EfficientProgressBar(context);
            this.cPP.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cPP.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cPP.setVisibility(4);
            this.cPP.setFocusable(false);
            this.cPP.setClickable(false);
            viewGroup.addView(this.cPP);
        }

        public void startProgress() {
            this.cPP.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cPP.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cPP.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private NetworkErrorView cPO;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cPO = new NetworkErrorView(context);
            this.cPO.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cPO, new FrameLayout.LayoutParams(-1, -1));
            this.cPO.setVisibility(8);
        }

        public void arD() {
            this.cPO.setVisibility(0);
        }

        public void arC() {
            this.cPO.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cPO.setOnClickListener(onClickListener);
            this.cPO.setReloadClickListener(onClickListener);
        }
    }

    public void arA() {
        final com.baidu.swan.apps.core.d.c apb;
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null && (apb = afM.apb()) != null && apb.getView() != null) {
            final View view = null;
            if (apb instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) apb).aoQ().aiA() != null) {
                    view = apb.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (apb instanceof i) {
                if (((i) apb).aiA() != null && apb.getView() != null) {
                    view = apb.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, apb);
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
            if (i != this.cPE) {
                if (this.cPE - i > this.cPI) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.anQ() && eVar.aoI()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cPE = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private DomainErrorView cPN;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cPN = new DomainErrorView(context);
            this.cPN.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cPN, new FrameLayout.LayoutParams(-1, -1));
            this.cPN.setVisibility(8);
        }

        public void nF(String str) {
            this.cPN.rK(str);
            this.cPN.setVisibility(0);
        }

        public void arC() {
            this.cPN.setVisibility(8);
        }
    }

    /* loaded from: classes10.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cPo)) {
                com.baidu.swan.apps.performance.i.cf("route", SwanAppWebViewWidget.this.cPo).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cPp.cvK = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cPo)) {
                com.baidu.swan.apps.performance.i.cf("route", SwanAppWebViewWidget.this.cPo).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cPp.cvM = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cPp.cvQ = "0";
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bz(SwanAppWebViewWidget.this.cPp.cvM);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cPp.cvM);
            }
            HybridUbcFlow qL = com.baidu.swan.apps.performance.i.qL("startup");
            if (qL != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                qL.ci("webviewComponent", str);
                qL.ci("fmp_type", "0");
                qL.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cPp.cvM).a(UbcFlowEvent.RecordType.UPDATE)).aDp();
                qL.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cPp.cvM), " , fmpType=", SwanAppWebViewWidget.this.cPp.cvQ, " , fmpTypeName=", SwanAppWebViewWidget.this.cPp.aiW());
                com.baidu.swan.apps.performance.i.akq();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cPo)) {
                j.qZ(SwanAppWebViewWidget.this.cPo);
                SwanAppWebViewWidget.this.cPo = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cPp.cvL = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cc(SwanAppWebViewWidget.this.cPp.cvL);
            final long aiU = com.baidu.swan.apps.performance.i.djc ? currentTimeMillis : SwanAppWebViewWidget.this.cPp.aiU();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + aiU + " , aligned search=" + com.baidu.swan.apps.performance.i.djc);
            }
            final HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
            qJ.f(new UbcFlowEvent("na_first_paint").bY(aiU));
            if (SwanAppWebViewWidget.this.cPp.cvM == 0) {
                SwanAppWebViewWidget.this.cPp.cvM = aiU;
                SwanAppWebViewWidget.this.cPp.cvQ = SwanAppWebViewWidget.this.cPp.bt(aiU);
                qJ.ci("fmp_type", "1");
                qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cPp.cvL));
            }
            long agF = com.baidu.swan.apps.t.a.awD().agF();
            if (agF < 0) {
                agF = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.djc) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.eW(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cPp.cvM <= 0) {
                        j = aiU;
                    } else {
                        j = SwanAppWebViewWidget.this.cPp.cvM;
                    }
                    qJ.ci("fmp_type", SwanAppWebViewWidget.this.cPp.cvQ);
                    qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(j)).aDp();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cPp.cvQ + " , fmpTypeName=" + SwanAppWebViewWidget.this.cPp.aiW());
                    }
                }
            }, "fmp record", agF, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cPp.cvN = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().bA(SwanAppWebViewWidget.this.cPp.cvN);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cPp.cvN);
            }
            if (com.baidu.swan.apps.performance.i.djc) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.eW(false);
            } else if (SwanAppWebViewWidget.this.cPp.cvM == 0) {
                HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ.ci("fmp_type", "2");
                qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cPp.cvN));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cPp.cvO = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aDP().aDQ().cb(SwanAppWebViewWidget.this.cPp.cvO);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cPp.cvO);
            }
            if (com.baidu.swan.apps.performance.i.djc) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.eW(false);
            } else if (SwanAppWebViewWidget.this.cPp.cvM == 0) {
                HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ.ci("fmp_type", "3");
                qJ.f(new UbcFlowEvent("na_first_meaningful_paint").bY(SwanAppWebViewWidget.this.cPp.cvO));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.awD().agw() && SwanAppWebViewWidget.this.apr() && !com.baidu.swan.apps.ag.a.b.sq(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nE(String str) {
        this.cPF = str;
    }
}
