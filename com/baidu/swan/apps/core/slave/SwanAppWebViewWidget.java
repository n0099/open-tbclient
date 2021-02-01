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
/* loaded from: classes9.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] cXn = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d cWS;
    private c cXf;
    private b cXg;
    private a cXh;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cXi;
    private e cXj;
    private int cXk;
    private String cXl;
    private boolean cXm;
    private int cXo;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cXm = true;
        this.cXo = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory agy = com.baidu.swan.apps.t.a.axt().agy();
        if (agy != null) {
            this.cPS.getCurrentWebView().setVideoPlayerFactory(agy);
        }
        arP();
        cO(context);
    }

    private void arP() {
        this.cPS.getSettings().setLoadWithOverviewMode(true);
        this.cPS.getSettings().setUseWideViewPort(true);
        this.cPS.getSettings().setSupportZoom(true);
        this.cPS.getSettings().setBuiltInZoomControls(true);
        this.cPS.getSettings().setDisplayZoomControls(false);
    }

    private void cO(Context context) {
        com.baidu.swan.apps.adaptation.a.b aim = com.baidu.swan.apps.runtime.d.aIG().aII().ags().aim();
        if (aim != null) {
            aim.bW(context);
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
        aVar.cQl = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anx() {
        super.anx();
        com.baidu.swan.apps.scheme.actions.m.f fVar = new com.baidu.swan.apps.scheme.actions.m.f(this.cPX);
        fVar.c(this);
        this.cPX.a(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void anu() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (apM() && !com.baidu.swan.apps.af.a.b.rX(str)) {
            arU().ng(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean apM() {
        return this.cXm;
    }

    public void fw(boolean z) {
        this.cXm = z;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiX() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d ajc() {
        return this.cXi;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cXi = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c arQ() {
        if (this.cXf == null) {
            this.cXf = new c(aiW().getContext(), aiW());
        }
        return this.cXf;
    }

    public int arR() {
        EfficientProgressBar efficientProgressBar;
        if (this.cXf == null || (efficientProgressBar = this.cXf.cXv) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        arS();
    }

    private void arS() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b arT() {
        if (this.cXg == null) {
            this.cXg = new b(aiW().getContext(), aiW());
            this.cXg.f(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.aiW().getContext())) {
                        if (!SwanAppWebViewWidget.this.apM() || com.baidu.swan.apps.af.a.b.rX(SwanAppWebViewWidget.this.aiW().getUrl())) {
                            SwanAppWebViewWidget.this.aiW().reload();
                            SwanAppWebViewWidget.this.cXg.arX();
                        }
                    }
                }
            });
        }
        return this.cXg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a arU() {
        if (this.cXh == null) {
            this.cXh = new a(aiW().getContext(), aiW());
        }
        return this.cXh;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.cWS = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void aiZ() {
        super.aiZ();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.cWS = null;
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
            SwanAppWebViewWidget.this.arQ().arZ();
            SwanAppWebViewWidget.this.arV();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.arT().arY();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.arQ().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri uk = ak.uk(str);
            if (uk != null) {
                com.baidu.swan.apps.ao.e.f(SwanAppWebViewWidget.this.cPR, new Intent("android.intent.action.DIAL", uk));
                return true;
            } else if (SwanAppWebViewWidget.this.cWT != null) {
                return SwanAppWebViewWidget.this.cWT.iw(str);
            } else {
                if (!SwanAppWebViewWidget.this.apM() || com.baidu.swan.apps.af.a.b.rX(str)) {
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
                    for (String str2 : SwanAppWebViewWidget.cXn) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.arU().ng(str);
                            SwanAppWebViewWidget.this.aiW().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean fc(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean anz() {
                                    SwanAppWebViewWidget.this.arU().arX();
                                    SwanAppWebViewWidget.this.aiW().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cXj == null) {
                SwanAppWebViewWidget.this.cXj = new e(SwanAppWebViewWidget.this.cPR.getBaseContext());
            }
            SwanAppWebViewWidget.this.cXj.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.cWS != null) {
                    SwanAppWebViewWidget.this.cWS.iv(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cXj != null) {
            this.cXj.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c {
        private EfficientProgressBar cXv;

        public c(Context context, ViewGroup viewGroup) {
            this.cXv = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cXv = new EfficientProgressBar(context);
            this.cXv.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cXv.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cXv.setVisibility(4);
            this.cXv.setFocusable(false);
            this.cXv.setClickable(false);
            viewGroup.addView(this.cXv);
        }

        public void arZ() {
            this.cXv.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cXv.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cXv.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private NetworkErrorView cXu;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cXu = new NetworkErrorView(context);
            this.cXu.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cXu, new FrameLayout.LayoutParams(-1, -1));
            this.cXu.setVisibility(8);
        }

        public void arY() {
            this.cXu.setVisibility(0);
        }

        public void arX() {
            this.cXu.setVisibility(8);
        }

        public void f(View.OnClickListener onClickListener) {
            this.cXu.setOnClickListener(onClickListener);
            this.cXu.setReloadClickListener(onClickListener);
        }
    }

    public void arV() {
        final com.baidu.swan.apps.core.d.c apx;
        com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null && (apx = afX.apx()) != null && apx.getView() != null) {
            final View view = null;
            if (apx instanceof com.baidu.swan.apps.core.d.e) {
                if (((com.baidu.swan.apps.core.d.e) apx).apm().aiP() != null) {
                    view = apx.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (apx instanceof i) {
                if (((i) apx).aiP() != null && apx.getView() != null) {
                    view = apx.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, apx);
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
            if (i != this.cXk) {
                if (this.cXk - i > this.cXo) {
                    int i2 = 0;
                    if (cVar instanceof com.baidu.swan.apps.core.d.e) {
                        com.baidu.swan.apps.core.d.e eVar = (com.baidu.swan.apps.core.d.e) cVar;
                        if (eVar.aog() && eVar.apd()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cXk = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private DomainErrorView cXt;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cXt = new DomainErrorView(context);
            this.cXt.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cXt, new FrameLayout.LayoutParams(-1, -1));
            this.cXt.setVisibility(8);
        }

        public void ng(String str) {
            this.cXt.rl(str);
            this.cXt.setVisibility(0);
        }

        public void arX() {
            this.cXt.setVisibility(8);
        }
    }

    /* loaded from: classes9.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cWU)) {
                com.baidu.swan.apps.performance.i.cd("route", SwanAppWebViewWidget.this.cWU).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cWV.cDs = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cWU)) {
                com.baidu.swan.apps.performance.i.cd("route", SwanAppWebViewWidget.this.cWU).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cWV.cDu = System.currentTimeMillis();
            SwanAppWebViewWidget.this.cWV.cDy = "0";
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cf(SwanAppWebViewWidget.this.cWV.cDu);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.cWV.cDu);
            }
            HybridUbcFlow qm = com.baidu.swan.apps.performance.i.qm("startup");
            if (qm != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                qm.cg("webviewComponent", str);
                qm.cg("fmp_type", "0");
                qm.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cWV.cDu).a(UbcFlowEvent.RecordType.UPDATE)).aDM();
                qm.o("value", "arrive_success");
                com.baidu.swan.apps.console.c.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.cWV.cDu), " , fmpType=", SwanAppWebViewWidget.this.cWV.cDy, " , fmpTypeName=", SwanAppWebViewWidget.this.cWV.ajl());
                com.baidu.swan.apps.performance.i.akF();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.cWU)) {
                j.qA(SwanAppWebViewWidget.this.cWU);
                SwanAppWebViewWidget.this.cWU = "";
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
            SwanAppWebViewWidget.this.cWV.cDt = currentTimeMillis;
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cI(SwanAppWebViewWidget.this.cWV.cDt);
            final long ajj = com.baidu.swan.apps.performance.i.dqO ? currentTimeMillis : SwanAppWebViewWidget.this.cWV.ajj();
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + ajj + " , aligned search=" + com.baidu.swan.apps.performance.i.dqO);
            }
            final HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
            qk.f(new UbcFlowEvent("na_first_paint").cE(ajj));
            if (SwanAppWebViewWidget.this.cWV.cDu == 0) {
                SwanAppWebViewWidget.this.cWV.cDu = ajj;
                SwanAppWebViewWidget.this.cWV.cDy = SwanAppWebViewWidget.this.cWV.bZ(ajj);
                qk.cg("fmp_type", "1");
                qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cWV.cDt));
            }
            long agS = com.baidu.swan.apps.t.a.awZ().agS();
            if (agS < 0) {
                agS = IMConnection.RETRY_DELAY_TIMES;
            }
            p.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (com.baidu.swan.apps.performance.i.dqO) {
                        if (SwanAppWebViewWidget.DEBUG) {
                            Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                        }
                        SwanAppWebViewWidget.this.fv(true);
                        return;
                    }
                    if (SwanAppWebViewWidget.this.cWV.cDu <= 0) {
                        j = ajj;
                    } else {
                        j = SwanAppWebViewWidget.this.cWV.cDu;
                    }
                    qk.cg("fmp_type", SwanAppWebViewWidget.this.cWV.cDy);
                    qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(j)).aDM();
                    if (SwanAppWebViewWidget.DEBUG) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.cWV.cDy + " , fmpTypeName=" + SwanAppWebViewWidget.this.cWV.ajl());
                    }
                }
            }, "fmp record", agS, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cWV.cDv = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cg(SwanAppWebViewWidget.this.cWV.cDv);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.cWV.cDv);
            }
            if (com.baidu.swan.apps.performance.i.dqO) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.fv(false);
            } else if (SwanAppWebViewWidget.this.cWV.cDu == 0) {
                HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
                qk.cg("fmp_type", "2");
                qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cWV.cDv));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            com.baidu.swan.apps.console.c.bl("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.cWV.cDw = System.currentTimeMillis();
            com.baidu.swan.apps.performance.a.f.aEk().aEl().cH(SwanAppWebViewWidget.this.cWV.cDw);
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.cWV.cDw);
            }
            if (com.baidu.swan.apps.performance.i.dqO) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.fv(false);
            } else if (SwanAppWebViewWidget.this.cWV.cDu == 0) {
                HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
                qk.cg("fmp_type", "3");
                qk.f(new UbcFlowEvent("na_first_meaningful_paint").cE(SwanAppWebViewWidget.this.cWV.cDw));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.t.a.awZ().agJ() && SwanAppWebViewWidget.this.apM() && !com.baidu.swan.apps.af.a.b.rX(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nf(String str) {
        this.cXl = str;
    }
}
