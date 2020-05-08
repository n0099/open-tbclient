package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.core.e.e;
import com.baidu.swan.apps.core.f.d;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.res.ui.DomainErrorView;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] bQu = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d bQb;
    private c bQn;
    private b bQo;
    private a bQp;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d bQq;
    private e bQr;
    private int bQs;
    private String bQt;
    private int bQv;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.bQv = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory OT = com.baidu.swan.apps.w.a.ack().OT();
        if (OT != null) {
            this.bKF.getCurrentWebView().setVideoPlayerFactory(OT);
        }
        Yd();
        bB(context);
    }

    private void Yd() {
        this.bKF.getSettings().setLoadWithOverviewMode(true);
        this.bKF.getSettings().setUseWideViewPort(true);
        this.bKF.getSettings().setSupportZoom(true);
        this.bKF.getSettings().setBuiltInZoomControls(true);
        this.bKF.getSettings().setDisplayZoomControls(false);
    }

    private void bB(Context context) {
        com.baidu.swan.apps.adaptation.a.b PH = com.baidu.swan.apps.runtime.d.akJ().akL().OM().PH();
        if (PH != null) {
            PH.aP(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
        super.a(context, swanAppWebViewManager);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void a(SwanAppWebViewManager.a aVar) {
        super.a(aVar);
        aVar.bKX = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UH() {
        super.UH();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bKK);
        eVar.c(this);
        this.bKK.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UE() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (Wv() && !com.baidu.swan.apps.aj.a.b.mt(str)) {
            Yh().iH(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean Wv() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String QE() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d QH() {
        return this.bQq;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.bQq = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Ye() {
        if (this.bQn == null) {
            this.bQn = new c(QD().getContext(), QD());
        }
        return this.bQn;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        Yf();
    }

    private void Yf() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b Yg() {
        if (this.bQo == null) {
            this.bQo = new b(QD().getContext(), QD());
            this.bQo.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.QD().getContext())) {
                        if (!SwanAppWebViewWidget.this.Wv() || com.baidu.swan.apps.aj.a.b.mt(SwanAppWebViewWidget.this.QD().getUrl())) {
                            SwanAppWebViewWidget.this.QD().reload();
                            SwanAppWebViewWidget.this.bQo.Yk();
                        }
                    }
                }
            });
        }
        return this.bQo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Yh() {
        if (this.bQp == null) {
            this.bQp = new a(QD().getContext(), QD());
        }
        return this.bQp;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bQb = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void QG() {
        super.QG();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.bQb = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.Ye().startProgress();
            SwanAppWebViewWidget.this.Yi();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.Yg().Yl();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.Ye().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.Wv() || com.baidu.swan.apps.aj.a.b.mt(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.bQu) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.Yh().iH(str);
                            SwanAppWebViewWidget.this.QD().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dh(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean UJ() {
                                    SwanAppWebViewWidget.this.Yh().Yk();
                                    SwanAppWebViewWidget.this.QD().setOnWebViewHookHandler(null);
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

    /* loaded from: classes11.dex */
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
            if (SwanAppWebViewWidget.this.bQr == null) {
                SwanAppWebViewWidget.this.bQr = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.bQr.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void onCustomViewHidden() {
                }
            });
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (!ag.isUrlAuxiliary(str)) {
                SwanAppWebViewWidget.this.mTitle = str;
                if (SwanAppWebViewWidget.this.bQb != null) {
                    SwanAppWebViewWidget.this.bQb.ff(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.bQr != null) {
            this.bQr.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar bQC;

        public c(Context context, ViewGroup viewGroup) {
            this.bQC = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bQC = new EfficientProgressBar(context);
            this.bQC.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bQC.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bQC.setVisibility(4);
            this.bQC.setFocusable(false);
            this.bQC.setClickable(false);
            viewGroup.addView(this.bQC);
        }

        public void startProgress() {
            this.bQC.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bQC.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bQC.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView bQB;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bQB = new NetworkErrorView(context);
            this.bQB.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bQB, new FrameLayout.LayoutParams(-1, -1));
            this.bQB.setVisibility(8);
        }

        public void Yl() {
            this.bQB.setVisibility(0);
        }

        public void Yk() {
            this.bQB.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.bQB.setOnClickListener(onClickListener);
            this.bQB.setReloadClickListener(onClickListener);
        }
    }

    public void Yi() {
        final com.baidu.swan.apps.core.d.b Wd;
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot != null && (Wd = Ot.Wd()) != null && Wd.getView() != null) {
            final View view = null;
            if (Wd instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) Wd).VT().Qx() != null) {
                    view = Wd.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (Wd instanceof h) {
                if (((h) Wd).Qx() != null && Wd.getView() != null) {
                    view = Wd.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, Wd);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.swan.apps.core.d.b bVar) {
        if (bVar != null && !bVar.isDetached()) {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.bQs) {
                if (this.bQs - i > this.bQv) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.Vl() && dVar.VM()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.bQs = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView bQA;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bQA = new DomainErrorView(context);
            this.bQA.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bQA, new FrameLayout.LayoutParams(-1, -1));
            this.bQA.setVisibility(8);
        }

        public void iH(String str) {
            this.bQA.lP(str);
            this.bQA.setVisibility(0);
        }

        public void Yk() {
            this.bQA.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bQc)) {
                com.baidu.swan.apps.performance.f.bh("route", SwanAppWebViewWidget.this.bQc).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bQd.bAh = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bQc)) {
                com.baidu.swan.apps.performance.f.bh("route", SwanAppWebViewWidget.this.bQc).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bQd.bAj = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bQd.bAk = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bQc)) {
                g.lp(SwanAppWebViewWidget.this.bQc);
                SwanAppWebViewWidget.this.bQc = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bQd.bAi = currentTimeMillis;
            if (SwanAppWebViewWidget.this.bQd.bAj == 0) {
                SwanAppWebViewWidget.this.bQd.bAj = currentTimeMillis;
            }
            final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            lb.f(new UbcFlowEvent("na_first_paint").aZ(currentTimeMillis));
            long Pn = com.baidu.swan.apps.w.a.abQ().Pn();
            if (Pn < 0) {
                Pn = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.bQd.bAj <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.bQd.bAj;
                    }
                    lb.bk("fmp_type", SwanAppWebViewWidget.this.bQd.bAk);
                    lb.f(new UbcFlowEvent("na_first_meaningful_paint").aZ(j)).ahM();
                }
            }, "fmp record", Pn, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.abQ().Pc() && SwanAppWebViewWidget.this.Wv() && !com.baidu.swan.apps.aj.a.b.mt(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iG(String str) {
        this.bQt = str;
    }
}
