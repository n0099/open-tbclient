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
/* loaded from: classes9.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cZM = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private c cZE;
    private b cZF;
    private a cZG;
    @Nullable
    private d cZH;
    private e cZI;
    private int cZJ;
    private String cZK;
    private boolean cZL;
    private int cZN;
    protected com.baidu.swan.apps.core.f.d cZr;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cZL = true;
        this.cZN = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory ajU = com.baidu.swan.apps.t.a.aAP().ajU();
        if (ajU != null) {
            this.cSq.getCurrentWebView().setVideoPlayerFactory(ajU);
        }
        avm();
        cQ(context);
    }

    private void avm() {
        this.cSq.getSettings().setLoadWithOverviewMode(true);
        this.cSq.getSettings().setUseWideViewPort(true);
        this.cSq.getSettings().setSupportZoom(true);
        this.cSq.getSettings().setBuiltInZoomControls(true);
        this.cSq.getSettings().setDisplayZoomControls(false);
    }

    private void cQ(Context context) {
        com.baidu.swan.apps.adaptation.a.b alI = com.baidu.swan.apps.runtime.d.aMh().aMj().ajO().alI();
        if (alI != null) {
            alI.bY(context);
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
        aVar.cSJ = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqU() {
        super.aqU();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cSv);
        fVar.c(this);
        this.cSv.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void aqR() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (atj() && !com.baidu.swan.apps.af.a.b.sQ(str)) {
            avr().nZ(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean atj() {
        return this.cZL;
    }

    public void fy(boolean z) {
        this.cZL = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String amt() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d amy() {
        return this.cZH;
    }

    public void d(@Nullable d dVar) {
        this.cZH = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c avn() {
        if (this.cZE == null) {
            this.cZE = new c(ams().getContext(), ams());
        }
        return this.cZE;
    }

    public int avo() {
        EfficientProgressBar efficientProgressBar;
        if (this.cZE == null || (efficientProgressBar = this.cZE.cZU) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        avp();
    }

    private void avp() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b avq() {
        if (this.cZF == null) {
            this.cZF = new b(ams().getContext(), ams());
            this.cZF.f(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.ams().getContext())) {
                        if (!SwanAppWebViewWidget.this.atj() || com.baidu.swan.apps.af.a.b.sQ(SwanAppWebViewWidget.this.ams().getUrl())) {
                            SwanAppWebViewWidget.this.ams().reload();
                            SwanAppWebViewWidget.this.cZF.avu();
                        }
                    }
                }
            });
        }
        return this.cZF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a avr() {
        if (this.cZG == null) {
            this.cZG = new a(ams().getContext(), ams());
        }
        return this.cZG;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.cZr = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void amv() {
        super.amv();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cZr = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.avn().avw();
            SwanAppWebViewWidget.this.avs();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.avq().avv();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.avn().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri vc = ak.vc(str);
            if (vc != null) {
                com.baidu.swan.apps.ao.e.f(SwanAppWebViewWidget.this.cSp, new Intent("android.intent.action.DIAL", vc));
                return true;
            } else if (SwanAppWebViewWidget.this.cZs != null) {
                return SwanAppWebViewWidget.this.cZs.jh(str);
            } else {
                if (!SwanAppWebViewWidget.this.atj() || com.baidu.swan.apps.af.a.b.sQ(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cZM) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.avr().nZ(str);
                            SwanAppWebViewWidget.this.ams().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean fe(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean aqW() {
                                    SwanAppWebViewWidget.this.avr().avu();
                                    SwanAppWebViewWidget.this.ams().setOnWebViewHookHandler(null);
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

    /* loaded from: classes9.dex */
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
            if (SwanAppWebViewWidget.this.cZI == null) {
                SwanAppWebViewWidget.this.cZI = new e(SwanAppWebViewWidget.this.cSp.getBaseContext());
            }
            SwanAppWebViewWidget.this.cZI.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cZr != null) {
                    SwanAppWebViewWidget.this.cZr.jg(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cZI != null) {
            this.cZI.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c {
        private EfficientProgressBar cZU;

        public c(Context context, ViewGroup viewGroup) {
            this.cZU = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cZU = new EfficientProgressBar(context);
            this.cZU.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cZU.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cZU.setVisibility(4);
            this.cZU.setFocusable(false);
            this.cZU.setClickable(false);
            viewGroup.addView(this.cZU);
        }

        public void avw() {
            this.cZU.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cZU.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cZU.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private NetworkErrorView cZT;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cZT = new NetworkErrorView(context);
            this.cZT.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cZT, new FrameLayout.LayoutParams(-1, -1));
            this.cZT.setVisibility(8);
        }

        public void avv() {
            this.cZT.setVisibility(0);
        }

        public void avu() {
            this.cZT.setVisibility(8);
        }

        public void f(View.OnClickListener onClickListener) {
            this.cZT.setOnClickListener(onClickListener);
            this.cZT.setReloadClickListener(onClickListener);
        }
    }

    public void avs() {
        final com.baidu.swan.apps.core.d.c asU;
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null && (asU = ajt.asU()) != null && asU.getView() != null) {
            final View view = null;
            if (asU instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) asU).asJ().aml() != null) {
                    view = asU.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (asU instanceof i) {
                if (((i) asU).aml() != null && asU.getView() != null) {
                    view = asU.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, asU);
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
            if (i != this.cZJ) {
                if (this.cZJ - i > this.cZN) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.arD() && eVar.asB()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cZJ = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private DomainErrorView cZS;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cZS = new DomainErrorView(context);
            this.cZS.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cZS, new FrameLayout.LayoutParams(-1, -1));
            this.cZS.setVisibility(8);
        }

        public void nZ(String str) {
            this.cZS.se(str);
            this.cZS.setVisibility(0);
        }

        public void avu() {
            this.cZS.setVisibility(8);
        }
    }

    /* loaded from: classes9.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cZt)) {
                com.baidu.swan.apps.performance.i.ck("route", SwanAppWebViewWidget.this.cZt).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cZu.cFI = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cZt)) {
                com.baidu.swan.apps.performance.i.ck("route", SwanAppWebViewWidget.this.cZt).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cZu.cFK = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cZu.cFO = "0";
            com.baidu.swan.apps.performance.a.f.aHJ().aHK().bZ(SwanAppWebViewWidget.this.cZu.cFK);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cZu.cFK);
            }
            HybridUbcFlow rf = com.baidu.swan.apps.performance.i.rf("startup");
            if (rf != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                rf.cn("webviewComponent", str);
                rf.cn("fmp_type", "0");
                rf.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cZu.cFK).a(UbcFlowEvent.RecordType.UPDATE)).aHk();
                rf.q("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cZu.cFK), " , fmpType=", SwanAppWebViewWidget.this.cZu.cFO, " , fmpTypeName=", SwanAppWebViewWidget.this.cZu.amH());
                com.baidu.swan.apps.performance.i.aob();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cZt)) {
                j.rt(SwanAppWebViewWidget.this.cZt);
                SwanAppWebViewWidget.this.cZt = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.cZu.cFJ = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aHJ().aHK().cC(SwanAppWebViewWidget.this.cZu.cFJ);
            final long amF = com.baidu.swan.apps.performance.i.dtt ? currentTimeMillis : SwanAppWebViewWidget.this.cZu.amF();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + amF + " , aligned search=" + com.baidu.swan.apps.performance.i.dtt);
            }
            final HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
            rd.f(new UbcFlowEvent("na_first_paint").cy(amF));
            if (SwanAppWebViewWidget.this.cZu.cFK == 0) {
                SwanAppWebViewWidget.this.cZu.cFK = amF;
                SwanAppWebViewWidget.this.cZu.cFO = SwanAppWebViewWidget.this.cZu.bT(amF);
                rd.cn("fmp_type", "1");
                rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cZu.cFJ));
            }
            long ako = com.baidu.swan.apps.t.a.aAv().ako();
            if (ako < 0) {
                ako = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.dtt) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.fx(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cZu.cFK <= 0) {
                        j = amF;
                    } else {
                        j = SwanAppWebViewWidget.this.cZu.cFK;
                    }
                    rd.cn("fmp_type", SwanAppWebViewWidget.this.cZu.cFO);
                    rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(j)).aHk();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cZu.cFO + " , fmpTypeName=" + SwanAppWebViewWidget.this.cZu.amH());
                    }
                }
            }, "fmp record", ako, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cZu.cFL = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aHJ().aHK().ca(SwanAppWebViewWidget.this.cZu.cFL);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cZu.cFL);
            }
            if (com.baidu.swan.apps.performance.i.dtt) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.fx(false);
            } else if (SwanAppWebViewWidget.this.cZu.cFK == 0) {
                HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
                rd.cn("fmp_type", "2");
                rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cZu.cFL));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bs("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cZu.cFM = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aHJ().aHK().cB(SwanAppWebViewWidget.this.cZu.cFM);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cZu.cFM);
            }
            if (com.baidu.swan.apps.performance.i.dtt) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.fx(false);
            } else if (SwanAppWebViewWidget.this.cZu.cFK == 0) {
                HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
                rd.cn("fmp_type", "3");
                rd.f(new UbcFlowEvent("na_first_meaningful_paint").cy(SwanAppWebViewWidget.this.cZu.cFM));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.aAv().akf() && SwanAppWebViewWidget.this.atj() && !com.baidu.swan.apps.af.a.b.sQ(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nY(String str) {
        this.cZK = str;
    }
}
