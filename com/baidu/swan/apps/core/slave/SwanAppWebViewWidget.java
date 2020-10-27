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
    private static final String[] cJO = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private c cJG;
    private b cJH;
    private a cJI;
    @Nullable
    private d cJJ;
    private e cJK;
    private int cJL;
    private String cJM;
    private boolean cJN;
    private int cJP;
    protected com.baidu.swan.apps.core.f.d cJt;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cJN = true;
        this.cJP = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory adL = com.baidu.swan.apps.t.a.aux().adL();
        if (adL != null) {
            this.cCs.getCurrentWebView().setVideoPlayerFactory(adL);
        }
        aoT();
        cc(context);
    }

    private void aoT() {
        this.cCs.getSettings().setLoadWithOverviewMode(true);
        this.cCs.getSettings().setUseWideViewPort(true);
        this.cCs.getSettings().setSupportZoom(true);
        this.cCs.getSettings().setBuiltInZoomControls(true);
        this.cCs.getSettings().setDisplayZoomControls(false);
    }

    private void cc(Context context) {
        com.baidu.swan.apps.adaptation.a.b afx = com.baidu.swan.apps.runtime.d.aEQ().aES().adF().afx();
        if (afx != null) {
            afx.bl(context);
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
        aVar.cCL = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akH() {
        super.akH();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cCx);
        fVar.c(this);
        this.cCx.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void akE() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (amQ() && !com.baidu.swan.apps.ag.a.b.sc(str)) {
            aoY().nq(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean amQ() {
        return this.cJN;
    }

    public void eO(boolean z) {
        this.cJN = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String agi() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d agn() {
        return this.cJJ;
    }

    public void d(@Nullable d dVar) {
        this.cJJ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aoU() {
        if (this.cJG == null) {
            this.cJG = new c(agh().getContext(), agh());
        }
        return this.cJG;
    }

    public int aoV() {
        EfficientProgressBar efficientProgressBar;
        if (this.cJG == null || (efficientProgressBar = this.cJG.cJW) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        aoW();
    }

    private void aoW() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aoX() {
        if (this.cJH == null) {
            this.cJH = new b(agh().getContext(), agh());
            this.cJH.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.agh().getContext())) {
                        if (!SwanAppWebViewWidget.this.amQ() || com.baidu.swan.apps.ag.a.b.sc(SwanAppWebViewWidget.this.agh().getUrl())) {
                            SwanAppWebViewWidget.this.agh().reload();
                            SwanAppWebViewWidget.this.cJH.apb();
                        }
                    }
                }
            });
        }
        return this.cJH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a aoY() {
        if (this.cJI == null) {
            this.cJI = new a(agh().getContext(), agh());
        }
        return this.cJI;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.cJt = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void agk() {
        super.agk();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cJt = null;
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
            SwanAppWebViewWidget.this.aoU().startProgress();
            SwanAppWebViewWidget.this.aoZ();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.aoX().apc();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.aoU().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri un = ak.un(str);
            if (un != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.cCr, new Intent("android.intent.action.DIAL", un));
                return true;
            } else if (SwanAppWebViewWidget.this.cJu != null) {
                return SwanAppWebViewWidget.this.cJu.iD(str);
            } else {
                if (!SwanAppWebViewWidget.this.amQ() || com.baidu.swan.apps.ag.a.b.sc(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cJO) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.aoY().nq(str);
                            SwanAppWebViewWidget.this.agh().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean eu(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean akJ() {
                                    SwanAppWebViewWidget.this.aoY().apb();
                                    SwanAppWebViewWidget.this.agh().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cJK == null) {
                SwanAppWebViewWidget.this.cJK = new e(SwanAppWebViewWidget.this.cCr.getBaseContext());
            }
            SwanAppWebViewWidget.this.cJK.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cJt != null) {
                    SwanAppWebViewWidget.this.cJt.iC(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cJK != null) {
            this.cJK.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private EfficientProgressBar cJW;

        public c(Context context, ViewGroup viewGroup) {
            this.cJW = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cJW = new EfficientProgressBar(context);
            this.cJW.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cJW.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cJW.setVisibility(4);
            this.cJW.setFocusable(false);
            this.cJW.setClickable(false);
            viewGroup.addView(this.cJW);
        }

        public void startProgress() {
            this.cJW.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cJW.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cJW.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private NetworkErrorView cJV;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cJV = new NetworkErrorView(context);
            this.cJV.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cJV, new FrameLayout.LayoutParams(-1, -1));
            this.cJV.setVisibility(8);
        }

        public void apc() {
            this.cJV.setVisibility(0);
        }

        public void apb() {
            this.cJV.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cJV.setOnClickListener(onClickListener);
            this.cJV.setReloadClickListener(onClickListener);
        }
    }

    public void aoZ() {
        final com.baidu.swan.apps.core.d.c amB;
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null && (amB = adm.amB()) != null && amB.getView() != null) {
            final View view = null;
            if (amB instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) amB).amq().aga() != null) {
                    view = amB.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (amB instanceof i) {
                if (((i) amB).aga() != null && amB.getView() != null) {
                    view = amB.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, amB);
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
            if (i != this.cJL) {
                if (this.cJL - i > this.cJP) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.alq() && eVar.ami()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cJL = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private DomainErrorView cJU;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cJU = new DomainErrorView(context);
            this.cJU.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cJU, new FrameLayout.LayoutParams(-1, -1));
            this.cJU.setVisibility(8);
        }

        public void nq(String str) {
            this.cJU.rw(str);
            this.cJU.setVisibility(0);
        }

        public void apb() {
            this.cJU.setVisibility(8);
        }
    }

    /* loaded from: classes10.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cJv)) {
                com.baidu.swan.apps.performance.i.cf("route", SwanAppWebViewWidget.this.cJv).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cJw.cpM = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cJv)) {
                com.baidu.swan.apps.performance.i.cf("route", SwanAppWebViewWidget.this.cJv).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cJw.cpO = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cJw.cpS = "0";
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bd(SwanAppWebViewWidget.this.cJw.cpO);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cJw.cpO);
            }
            HybridUbcFlow qx = com.baidu.swan.apps.performance.i.qx("startup");
            if (qx != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                qx.ci("webviewComponent", str);
                qx.ci("fmp_type", "0");
                qx.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppWebViewWidget.this.cJw.cpO).a(UbcFlowEvent.RecordType.UPDATE)).aAP();
                qx.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cJw.cpO), " , fmpType=", SwanAppWebViewWidget.this.cJw.cpS, " , fmpTypeName=", SwanAppWebViewWidget.this.cJw.agw());
                com.baidu.swan.apps.performance.i.ahQ();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cJv)) {
                j.qL(SwanAppWebViewWidget.this.cJv);
                SwanAppWebViewWidget.this.cJv = "";
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
            SwanAppWebViewWidget.this.cJw.cpN = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bG(SwanAppWebViewWidget.this.cJw.cpN);
            final long agu = com.baidu.swan.apps.performance.i.ddf ? currentTimeMillis : SwanAppWebViewWidget.this.cJw.agu();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + agu + " , aligned search=" + com.baidu.swan.apps.performance.i.ddf);
            }
            final HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
            qv.f(new UbcFlowEvent("na_first_paint").bC(agu));
            if (SwanAppWebViewWidget.this.cJw.cpO == 0) {
                SwanAppWebViewWidget.this.cJw.cpO = agu;
                SwanAppWebViewWidget.this.cJw.cpS = SwanAppWebViewWidget.this.cJw.aX(agu);
                qv.ci("fmp_type", "1");
                qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppWebViewWidget.this.cJw.cpN));
            }
            long aef = com.baidu.swan.apps.t.a.aud().aef();
            if (aef < 0) {
                aef = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.ddf) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.eN(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cJw.cpO <= 0) {
                        j = agu;
                    } else {
                        j = SwanAppWebViewWidget.this.cJw.cpO;
                    }
                    qv.ci("fmp_type", SwanAppWebViewWidget.this.cJw.cpS);
                    qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(j)).aAP();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cJw.cpS + " , fmpTypeName=" + SwanAppWebViewWidget.this.cJw.agw());
                    }
                }
            }, "fmp record", aef, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cJw.cpP = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aBp().aBq().be(SwanAppWebViewWidget.this.cJw.cpP);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cJw.cpP);
            }
            if (com.baidu.swan.apps.performance.i.ddf) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.eN(false);
            } else if (SwanAppWebViewWidget.this.cJw.cpO == 0) {
                HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
                qv.ci("fmp_type", "2");
                qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppWebViewWidget.this.cJw.cpP));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bn("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cJw.cpQ = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aBp().aBq().bF(SwanAppWebViewWidget.this.cJw.cpQ);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cJw.cpQ);
            }
            if (com.baidu.swan.apps.performance.i.ddf) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.eN(false);
            } else if (SwanAppWebViewWidget.this.cJw.cpO == 0) {
                HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
                qv.ci("fmp_type", "3");
                qv.f(new UbcFlowEvent("na_first_meaningful_paint").bC(SwanAppWebViewWidget.this.cJw.cpQ));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.aud().adW() && SwanAppWebViewWidget.this.amQ() && !com.baidu.swan.apps.ag.a.b.sc(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void np(String str) {
        this.cJM = str;
    }
}
