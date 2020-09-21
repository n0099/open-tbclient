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
/* loaded from: classes3.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cpd = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d coI;
    private c coV;
    private b coW;
    private a coX;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d coY;
    private e coZ;
    private int cpa;
    private String cpb;
    private boolean cpc;
    private int cpe;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cpc = true;
        this.cpe = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Zf = com.baidu.swan.apps.t.a.apR().Zf();
        if (Zf != null) {
            this.chC.getCurrentWebView().setVideoPlayerFactory(Zf);
        }
        ako();
        bW(context);
    }

    private void ako() {
        this.chC.getSettings().setLoadWithOverviewMode(true);
        this.chC.getSettings().setUseWideViewPort(true);
        this.chC.getSettings().setSupportZoom(true);
        this.chC.getSettings().setBuiltInZoomControls(true);
        this.chC.getSettings().setDisplayZoomControls(false);
    }

    private void bW(Context context) {
        com.baidu.swan.apps.adaptation.a.b aaR = com.baidu.swan.apps.runtime.d.aAn().aAp().YZ().aaR();
        if (aaR != null) {
            aaR.bf(context);
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
        aVar.chV = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void agc() {
        super.agc();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.chH);
        fVar.c(this);
        this.chH.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void afZ() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (ail() && !com.baidu.swan.apps.ag.a.b.qX(str)) {
            akt().ml(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean ail() {
        return this.cpc;
    }

    public void ef(boolean z) {
        this.cpc = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String abC() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d abH() {
        return this.coY;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.coY = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c akp() {
        if (this.coV == null) {
            this.coV = new c(abB().getContext(), abB());
        }
        return this.coV;
    }

    public int akq() {
        EfficientProgressBar efficientProgressBar;
        if (this.coV == null || (efficientProgressBar = this.coV.cpl) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        akr();
    }

    private void akr() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aks() {
        if (this.coW == null) {
            this.coW = new b(abB().getContext(), abB());
            this.coW.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.abB().getContext())) {
                        if (!SwanAppWebViewWidget.this.ail() || com.baidu.swan.apps.ag.a.b.qX(SwanAppWebViewWidget.this.abB().getUrl())) {
                            SwanAppWebViewWidget.this.abB().reload();
                            SwanAppWebViewWidget.this.coW.akw();
                        }
                    }
                }
            });
        }
        return this.coW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a akt() {
        if (this.coX == null) {
            this.coX = new a(abB().getContext(), abB());
        }
        return this.coX;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.coI = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void abE() {
        super.abE();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.coI = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.akp().startProgress();
            SwanAppWebViewWidget.this.aku();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.aks().akx();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.akp().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri ti = ak.ti(str);
            if (ti != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.chB, new Intent("android.intent.action.DIAL", ti));
                return true;
            } else if (SwanAppWebViewWidget.this.coJ != null) {
                return SwanAppWebViewWidget.this.coJ.hR(str);
            } else {
                if (!SwanAppWebViewWidget.this.ail() || com.baidu.swan.apps.ag.a.b.qX(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cpd) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.akt().ml(str);
                            SwanAppWebViewWidget.this.abB().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dL(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean age() {
                                    SwanAppWebViewWidget.this.akt().akw();
                                    SwanAppWebViewWidget.this.abB().setOnWebViewHookHandler(null);
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

    /* loaded from: classes3.dex */
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
            if (SwanAppWebViewWidget.this.coZ == null) {
                SwanAppWebViewWidget.this.coZ = new e(SwanAppWebViewWidget.this.chB.getBaseContext());
            }
            SwanAppWebViewWidget.this.coZ.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.coI != null) {
                    SwanAppWebViewWidget.this.coI.hQ(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.coZ != null) {
            this.coZ.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        private EfficientProgressBar cpl;

        public c(Context context, ViewGroup viewGroup) {
            this.cpl = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cpl = new EfficientProgressBar(context);
            this.cpl.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cpl.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cpl.setVisibility(4);
            this.cpl.setFocusable(false);
            this.cpl.setClickable(false);
            viewGroup.addView(this.cpl);
        }

        public void startProgress() {
            this.cpl.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cpl.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cpl.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private NetworkErrorView cpk;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cpk = new NetworkErrorView(context);
            this.cpk.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cpk, new FrameLayout.LayoutParams(-1, -1));
            this.cpk.setVisibility(8);
        }

        public void akx() {
            this.cpk.setVisibility(0);
        }

        public void akw() {
            this.cpk.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cpk.setOnClickListener(onClickListener);
            this.cpk.setReloadClickListener(onClickListener);
        }
    }

    public void aku() {
        final com.baidu.swan.apps.core.d.c ahW;
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null && (ahW = YG.ahW()) != null && ahW.getView() != null) {
            final View view = null;
            if (ahW instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) ahW).ahL().abu() != null) {
                    view = ahW.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (ahW instanceof i) {
                if (((i) ahW).abu() != null && ahW.getView() != null) {
                    view = ahW.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, ahW);
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
            if (i != this.cpa) {
                if (this.cpa - i > this.cpe) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.agL() && eVar.ahD()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cpa = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private DomainErrorView cpj;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cpj = new DomainErrorView(context);
            this.cpj.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cpj, new FrameLayout.LayoutParams(-1, -1));
            this.cpj.setVisibility(8);
        }

        public void ml(String str) {
            this.cpj.qr(str);
            this.cpj.setVisibility(0);
        }

        public void akw() {
            this.cpj.setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.coK)) {
                com.baidu.swan.apps.performance.i.bT("route", SwanAppWebViewWidget.this.coK).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.coL.bUX = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.coK)) {
                com.baidu.swan.apps.performance.i.bT("route", SwanAppWebViewWidget.this.coK).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.coL.bUZ = System.currentTimeMillis();
            SwanAppWebViewWidget.this.coL.bVd = "0";
            com.baidu.swan.apps.performance.a.f.awK().awL().aT(SwanAppWebViewWidget.this.coL.bUZ);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.coL.bUZ);
            }
            HybridUbcFlow ps = com.baidu.swan.apps.performance.i.ps("startup");
            if (ps != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                ps.bW("webviewComponent", str);
                ps.bW("fmp_type", "0");
                ps.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppWebViewWidget.this.coL.bUZ).a(UbcFlowEvent.RecordType.UPDATE)).awk();
                ps.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.coL.bUZ), " , fmpType=", SwanAppWebViewWidget.this.coL.bVd, " , fmpTypeName=", SwanAppWebViewWidget.this.coL.abQ());
                com.baidu.swan.apps.performance.i.adk();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.coK)) {
                j.pG(SwanAppWebViewWidget.this.coK);
                SwanAppWebViewWidget.this.coK = "";
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
            SwanAppWebViewWidget.this.coL.bUY = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.awK().awL().bw(SwanAppWebViewWidget.this.coL.bUY);
            final long abO = com.baidu.swan.apps.performance.i.cID ? currentTimeMillis : SwanAppWebViewWidget.this.coL.abO();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + abO + " , aligned search=" + com.baidu.swan.apps.performance.i.cID);
            }
            final HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
            pq.f(new UbcFlowEvent("na_first_paint").bs(abO));
            if (SwanAppWebViewWidget.this.coL.bUZ == 0) {
                SwanAppWebViewWidget.this.coL.bUZ = abO;
                SwanAppWebViewWidget.this.coL.bVd = SwanAppWebViewWidget.this.coL.aN(abO);
                pq.bW("fmp_type", "1");
                pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppWebViewWidget.this.coL.bUY));
            }
            long Zz = com.baidu.swan.apps.t.a.apx().Zz();
            if (Zz < 0) {
                Zz = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.cID) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.ee(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.coL.bUZ <= 0) {
                        j = abO;
                    } else {
                        j = SwanAppWebViewWidget.this.coL.bUZ;
                    }
                    pq.bW("fmp_type", SwanAppWebViewWidget.this.coL.bVd);
                    pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(j)).awk();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.coL.bVd + " , fmpTypeName=" + SwanAppWebViewWidget.this.coL.abQ());
                    }
                }
            }, "fmp record", Zz, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.coL.bVa = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awK().awL().aU(SwanAppWebViewWidget.this.coL.bVa);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.coL.bVa);
            }
            if (com.baidu.swan.apps.performance.i.cID) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.ee(false);
            } else if (SwanAppWebViewWidget.this.coL.bUZ == 0) {
                HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
                pq.bW("fmp_type", "2");
                pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppWebViewWidget.this.coL.bVa));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bb("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.coL.bVb = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.awK().awL().bv(SwanAppWebViewWidget.this.coL.bVb);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.coL.bVb);
            }
            if (com.baidu.swan.apps.performance.i.cID) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.ee(false);
            } else if (SwanAppWebViewWidget.this.coL.bUZ == 0) {
                HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
                pq.bW("fmp_type", "3");
                pq.f(new UbcFlowEvent("na_first_meaningful_paint").bs(SwanAppWebViewWidget.this.coL.bVb));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.apx().Zq() && SwanAppWebViewWidget.this.ail() && !com.baidu.swan.apps.ag.a.b.qX(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mk(String str) {
        this.cpb = str;
    }
}
