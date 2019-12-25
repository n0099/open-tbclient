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
/* loaded from: classes9.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] bmY = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d bmE;
    private c bmR;
    private b bmS;
    private a bmT;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d bmU;
    private e bmV;
    private int bmW;
    private String bmX;
    private int bmZ;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.bmZ = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Ep = com.baidu.swan.apps.w.a.RH().Ep();
        if (Ep != null) {
            this.bhc.getCurrentWebView().setVideoPlayerFactory(Ep);
        }
        NA();
        bW(context);
    }

    private void NA() {
        this.bhc.getSettings().setLoadWithOverviewMode(true);
        this.bhc.getSettings().setUseWideViewPort(true);
        this.bhc.getSettings().setSupportZoom(true);
        this.bhc.getSettings().setBuiltInZoomControls(true);
        this.bhc.getSettings().setDisplayZoomControls(false);
    }

    private void bW(Context context) {
        com.baidu.swan.apps.adaptation.a.b Fg = com.baidu.swan.apps.runtime.d.ZP().ZR().Ei().Fg();
        if (Fg != null) {
            Fg.bk(context);
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
        aVar.bhu = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kf() {
        super.Kf();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bhh);
        eVar.c(this);
        this.bhh.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Kc() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (LS() && !com.baidu.swan.apps.aj.a.b.kP(str)) {
            NE().hc(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean LS() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Gd() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d Gg() {
        return this.bmU;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.bmU = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c NB() {
        if (this.bmR == null) {
            this.bmR = new c(Gc().getContext(), Gc());
        }
        return this.bmR;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        NC();
    }

    private void NC() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b ND() {
        if (this.bmS == null) {
            this.bmS = new b(Gc().getContext(), Gc());
            this.bmS.e(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.Gc().getContext())) {
                        if (!SwanAppWebViewWidget.this.LS() || com.baidu.swan.apps.aj.a.b.kP(SwanAppWebViewWidget.this.Gc().getUrl())) {
                            SwanAppWebViewWidget.this.Gc().reload();
                            SwanAppWebViewWidget.this.bmS.NH();
                        }
                    }
                }
            });
        }
        return this.bmS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a NE() {
        if (this.bmT == null) {
            this.bmT = new a(Gc().getContext(), Gc());
        }
        return this.bmT;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bmE = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Gf() {
        super.Gf();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.bmE = null;
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
            SwanAppWebViewWidget.this.NB().startProgress();
            SwanAppWebViewWidget.this.NF();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.ND().NI();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.NB().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.LS() || com.baidu.swan.apps.aj.a.b.kP(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.bmY) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.NE().hc(str);
                            SwanAppWebViewWidget.this.Gc().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean bY(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean Kh() {
                                    SwanAppWebViewWidget.this.NE().NH();
                                    SwanAppWebViewWidget.this.Gc().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.bmV == null) {
                SwanAppWebViewWidget.this.bmV = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.bmV.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.bmE != null) {
                    SwanAppWebViewWidget.this.bmE.dW(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.bmV != null) {
            this.bmV.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c {
        private EfficientProgressBar bng;

        public c(Context context, ViewGroup viewGroup) {
            this.bng = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bng = new EfficientProgressBar(context);
            this.bng.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bng.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bng.setVisibility(4);
            this.bng.setFocusable(false);
            this.bng.setClickable(false);
            viewGroup.addView(this.bng);
        }

        public void startProgress() {
            this.bng.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bng.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bng.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private NetworkErrorView bnf;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bnf = new NetworkErrorView(context);
            this.bnf.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bnf, new FrameLayout.LayoutParams(-1, -1));
            this.bnf.setVisibility(8);
        }

        public void NI() {
            this.bnf.setVisibility(0);
        }

        public void NH() {
            this.bnf.setVisibility(8);
        }

        public void e(View.OnClickListener onClickListener) {
            this.bnf.setOnClickListener(onClickListener);
            this.bnf.setReloadClickListener(onClickListener);
        }
    }

    public void NF() {
        final com.baidu.swan.apps.core.d.b LB;
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP != null && (LB = DP.LB()) != null && LB.getView() != null) {
            final View view = null;
            if (LB instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) LB).Lr().FW() != null) {
                    view = LB.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (LB instanceof h) {
                if (((h) LB).FW() != null && LB.getView() != null) {
                    view = LB.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, LB);
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
            if (i != this.bmW) {
                if (this.bmW - i > this.bmZ) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.KJ() && dVar.Lk()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.bmW = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private DomainErrorView bne;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bne = new DomainErrorView(context);
            this.bne.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bne, new FrameLayout.LayoutParams(-1, -1));
            this.bne.setVisibility(8);
        }

        public void hc(String str) {
            this.bne.kl(str);
            this.bne.setVisibility(0);
        }

        public void NH() {
            this.bne.setVisibility(8);
        }
    }

    /* loaded from: classes9.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bmF)) {
                com.baidu.swan.apps.performance.f.aO("route", SwanAppWebViewWidget.this.bmF).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bmG.aWw = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bmF)) {
                com.baidu.swan.apps.performance.f.aO("route", SwanAppWebViewWidget.this.bmF).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bmG.aWy = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bmG.aWz = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bmF)) {
                g.jL(SwanAppWebViewWidget.this.bmF);
                SwanAppWebViewWidget.this.bmF = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bmG.aWx = currentTimeMillis;
            if (SwanAppWebViewWidget.this.bmG.aWy == 0) {
                SwanAppWebViewWidget.this.bmG.aWy = currentTimeMillis;
            }
            final HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
            jx.f(new UbcFlowEvent("na_first_paint").an(currentTimeMillis));
            long EJ = com.baidu.swan.apps.w.a.Rn().EJ();
            if (EJ < 0) {
                EJ = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.bmG.aWy <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.bmG.aWy;
                    }
                    jx.aR("fmp_type", SwanAppWebViewWidget.this.bmG.aWz);
                    jx.f(new UbcFlowEvent("na_first_meaningful_paint").an(j)).WS();
                }
            }, "fmp record", EJ, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.Rn().Ey() && SwanAppWebViewWidget.this.LS() && !com.baidu.swan.apps.aj.a.b.kP(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hb(String str) {
        this.bmX = str;
    }
}
