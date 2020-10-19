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
/* loaded from: classes10.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cBs = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d cAX;
    private c cBk;
    private b cBl;
    private a cBm;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cBn;
    private e cBo;
    private int cBp;
    private String cBq;
    private boolean cBr;
    private int cBt;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cBr = true;
        this.cBt = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory abR = com.baidu.swan.apps.t.a.asD().abR();
        if (abR != null) {
            this.ctU.getCurrentWebView().setVideoPlayerFactory(abR);
        }
        amZ();
        cc(context);
    }

    private void amZ() {
        this.ctU.getSettings().setLoadWithOverviewMode(true);
        this.ctU.getSettings().setUseWideViewPort(true);
        this.ctU.getSettings().setSupportZoom(true);
        this.ctU.getSettings().setBuiltInZoomControls(true);
        this.ctU.getSettings().setDisplayZoomControls(false);
    }

    private void cc(Context context) {
        com.baidu.swan.apps.adaptation.a.b adD = com.baidu.swan.apps.runtime.d.aCW().aCY().abL().adD();
        if (adD != null) {
            adD.bl(context);
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
        aVar.cun = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aiN() {
        super.aiN();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.ctZ);
        fVar.c(this);
        this.ctZ.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aiK() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (akW() && !com.baidu.swan.apps.ag.a.b.rJ(str)) {
            ane().mX(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean akW() {
        return this.cBr;
    }

    public void eB(boolean z) {
        this.cBr = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aeo() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d aet() {
        return this.cBn;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cBn = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ana() {
        if (this.cBk == null) {
            this.cBk = new c(aen().getContext(), aen());
        }
        return this.cBk;
    }

    public int anb() {
        EfficientProgressBar efficientProgressBar;
        if (this.cBk == null || (efficientProgressBar = this.cBk.cBA) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        anc();
    }

    private void anc() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b and() {
        if (this.cBl == null) {
            this.cBl = new b(aen().getContext(), aen());
            this.cBl.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aen().getContext())) {
                        if (!SwanAppWebViewWidget.this.akW() || com.baidu.swan.apps.ag.a.b.rJ(SwanAppWebViewWidget.this.aen().getUrl())) {
                            SwanAppWebViewWidget.this.aen().reload();
                            SwanAppWebViewWidget.this.cBl.anh();
                        }
                    }
                }
            });
        }
        return this.cBl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a ane() {
        if (this.cBm == null) {
            this.cBm = new a(aen().getContext(), aen());
        }
        return this.cBm;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cAX = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aeq() {
        super.aeq();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cAX = null;
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
            SwanAppWebViewWidget.this.ana().startProgress();
            SwanAppWebViewWidget.this.anf();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.and().ani();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.ana().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri tU = ak.tU(str);
            if (tU != null) {
                com.baidu.swan.apps.ap.e.startActivitySafely(SwanAppWebViewWidget.this.ctT, new Intent("android.intent.action.DIAL", tU));
                return true;
            } else if (SwanAppWebViewWidget.this.cAY != null) {
                return SwanAppWebViewWidget.this.cAY.is(str);
            } else {
                if (!SwanAppWebViewWidget.this.akW() || com.baidu.swan.apps.ag.a.b.rJ(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cBs) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.ane().mX(str);
                            SwanAppWebViewWidget.this.aen().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean eh(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean aiP() {
                                    SwanAppWebViewWidget.this.ane().anh();
                                    SwanAppWebViewWidget.this.aen().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cBo == null) {
                SwanAppWebViewWidget.this.cBo = new e(SwanAppWebViewWidget.this.ctT.getBaseContext());
            }
            SwanAppWebViewWidget.this.cBo.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cAX != null) {
                    SwanAppWebViewWidget.this.cAX.ir(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cBo != null) {
            this.cBo.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private EfficientProgressBar cBA;

        public c(Context context, ViewGroup viewGroup) {
            this.cBA = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cBA = new EfficientProgressBar(context);
            this.cBA.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cBA.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cBA.setVisibility(4);
            this.cBA.setFocusable(false);
            this.cBA.setClickable(false);
            viewGroup.addView(this.cBA);
        }

        public void startProgress() {
            this.cBA.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cBA.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cBA.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private NetworkErrorView cBz;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cBz = new NetworkErrorView(context);
            this.cBz.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cBz, new FrameLayout.LayoutParams(-1, -1));
            this.cBz.setVisibility(8);
        }

        public void ani() {
            this.cBz.setVisibility(0);
        }

        public void anh() {
            this.cBz.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cBz.setOnClickListener(onClickListener);
            this.cBz.setReloadClickListener(onClickListener);
        }
    }

    public void anf() {
        final com.baidu.swan.apps.core.d.c akH;
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null && (akH = abs.akH()) != null && akH.getView() != null) {
            final View view = null;
            if (akH instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) akH).akw().aeg() != null) {
                    view = akH.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (akH instanceof i) {
                if (((i) akH).aeg() != null && akH.getView() != null) {
                    view = akH.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, akH);
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
            if (i != this.cBp) {
                if (this.cBp - i > this.cBt) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.ajw() && eVar.ako()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cBp = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private DomainErrorView cBy;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cBy = new DomainErrorView(context);
            this.cBy.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cBy, new FrameLayout.LayoutParams(-1, -1));
            this.cBy.setVisibility(8);
        }

        public void mX(String str) {
            this.cBy.rd(str);
            this.cBy.setVisibility(0);
        }

        public void anh() {
            this.cBy.setVisibility(8);
        }
    }

    /* loaded from: classes10.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cAZ)) {
                com.baidu.swan.apps.performance.i.bY("route", SwanAppWebViewWidget.this.cAZ).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cBa.chl = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cAZ)) {
                com.baidu.swan.apps.performance.i.bY("route", SwanAppWebViewWidget.this.cAZ).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cBa.chn = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cBa.chr = "0";
            com.baidu.swan.apps.performance.a.f.azv().azw().bb(SwanAppWebViewWidget.this.cBa.chn);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cBa.chn);
            }
            HybridUbcFlow qe = com.baidu.swan.apps.performance.i.qe("startup");
            if (qe != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                qe.cb("webviewComponent", str);
                qe.cb("fmp_type", "0");
                qe.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppWebViewWidget.this.cBa.chn).a(UbcFlowEvent.RecordType.UPDATE)).ayV();
                qe.r("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cBa.chn), " , fmpType=", SwanAppWebViewWidget.this.cBa.chr, " , fmpTypeName=", SwanAppWebViewWidget.this.cBa.aeC());
                com.baidu.swan.apps.performance.i.afW();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cAZ)) {
                j.qs(SwanAppWebViewWidget.this.cAZ);
                SwanAppWebViewWidget.this.cAZ = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cBa.chm = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.azv().azw().bE(SwanAppWebViewWidget.this.cBa.chm);
            final long aeA = com.baidu.swan.apps.performance.i.cUG ? currentTimeMillis : SwanAppWebViewWidget.this.cBa.aeA();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + aeA + " , aligned search=" + com.baidu.swan.apps.performance.i.cUG);
            }
            final HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
            qc.f(new UbcFlowEvent("na_first_paint").bA(aeA));
            if (SwanAppWebViewWidget.this.cBa.chn == 0) {
                SwanAppWebViewWidget.this.cBa.chn = aeA;
                SwanAppWebViewWidget.this.cBa.chr = SwanAppWebViewWidget.this.cBa.aV(aeA);
                qc.cb("fmp_type", "1");
                qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppWebViewWidget.this.cBa.chm));
            }
            long acl = com.baidu.swan.apps.t.a.asi().acl();
            if (acl < 0) {
                acl = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.cUG) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.eA(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cBa.chn <= 0) {
                        j = aeA;
                    } else {
                        j = SwanAppWebViewWidget.this.cBa.chn;
                    }
                    qc.cb("fmp_type", SwanAppWebViewWidget.this.cBa.chr);
                    qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(j)).ayV();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cBa.chr + " , fmpTypeName=" + SwanAppWebViewWidget.this.cBa.aeC());
                    }
                }
            }, "fmp record", acl, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cBa.cho = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.azv().azw().bc(SwanAppWebViewWidget.this.cBa.cho);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cBa.cho);
            }
            if (com.baidu.swan.apps.performance.i.cUG) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.eA(false);
            } else if (SwanAppWebViewWidget.this.cBa.chn == 0) {
                HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
                qc.cb("fmp_type", "2");
                qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppWebViewWidget.this.cBa.cho));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bg("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cBa.chp = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.azv().azw().bD(SwanAppWebViewWidget.this.cBa.chp);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cBa.chp);
            }
            if (com.baidu.swan.apps.performance.i.cUG) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.eA(false);
            } else if (SwanAppWebViewWidget.this.cBa.chn == 0) {
                HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
                qc.cb("fmp_type", "3");
                qc.f(new UbcFlowEvent("na_first_meaningful_paint").bA(SwanAppWebViewWidget.this.cBa.chp));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.asi().acc() && SwanAppWebViewWidget.this.akW() && !com.baidu.swan.apps.ag.a.b.rJ(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mW(String str) {
        this.cBq = str;
    }
}
