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
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.n;
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
    private static final String[] cag = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d bZN;
    private c bZZ;
    private b caa;
    private a cab;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d cac;
    private e cad;
    private int cae;
    private String caf;
    private int cah;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.cah = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Re = com.baidu.swan.apps.u.a.afn().Re();
        if (Re != null) {
            this.bTC.getCurrentWebView().setVideoPlayerFactory(Re);
        }
        aaZ();
        bM(context);
    }

    private void aaZ() {
        this.bTC.getSettings().setLoadWithOverviewMode(true);
        this.bTC.getSettings().setUseWideViewPort(true);
        this.bTC.getSettings().setSupportZoom(true);
        this.bTC.getSettings().setBuiltInZoomControls(true);
        this.bTC.getSettings().setDisplayZoomControls(false);
    }

    private void bM(Context context) {
        com.baidu.swan.apps.adaptation.a.b SA = com.baidu.swan.apps.runtime.d.aoB().aoD().QY().SA();
        if (SA != null) {
            SA.aZ(context);
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
        aVar.bTT = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xn() {
        super.Xn();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bTH);
        eVar.c(this);
        this.bTH.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Xk() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (Zh() && !com.baidu.swan.apps.ah.a.b.nQ(str)) {
            abd().jN(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean Zh() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Ti() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d Tl() {
        return this.cac;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.cac = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aba() {
        if (this.bZZ == null) {
            this.bZZ = new c(Th().getContext(), Th());
        }
        return this.bZZ;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        abb();
    }

    private void abb() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b abc() {
        if (this.caa == null) {
            this.caa = new b(Th().getContext(), Th());
            this.caa.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.Th().getContext())) {
                        if (!SwanAppWebViewWidget.this.Zh() || com.baidu.swan.apps.ah.a.b.nQ(SwanAppWebViewWidget.this.Th().getUrl())) {
                            SwanAppWebViewWidget.this.Th().reload();
                            SwanAppWebViewWidget.this.caa.abg();
                        }
                    }
                }
            });
        }
        return this.caa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a abd() {
        if (this.cab == null) {
            this.cab = new a(Th().getContext(), Th());
        }
        return this.cab;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bZN = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Tk() {
        super.Tk();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.bZN = null;
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
            SwanAppWebViewWidget.this.aba().startProgress();
            SwanAppWebViewWidget.this.abe();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.abc().abh();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.aba().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.Zh() || com.baidu.swan.apps.ah.a.b.nQ(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.cag) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.abd().jN(str);
                            SwanAppWebViewWidget.this.Th().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean du(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean Xp() {
                                    SwanAppWebViewWidget.this.abd().abg();
                                    SwanAppWebViewWidget.this.Th().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.cad == null) {
                SwanAppWebViewWidget.this.cad = new e(SwanAppWebViewWidget.this.bTB.getBaseContext());
            }
            SwanAppWebViewWidget.this.cad.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void onCustomViewHidden() {
                }
            });
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (!ah.isUrlAuxiliary(str)) {
                SwanAppWebViewWidget.this.mTitle = str;
                if (SwanAppWebViewWidget.this.bZN != null) {
                    SwanAppWebViewWidget.this.bZN.fR(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.cad != null) {
            this.cad.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar cao;

        public c(Context context, ViewGroup viewGroup) {
            this.cao = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cao = new EfficientProgressBar(context);
            this.cao.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cao.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cao.setVisibility(4);
            this.cao.setFocusable(false);
            this.cao.setClickable(false);
            viewGroup.addView(this.cao);
        }

        public void startProgress() {
            this.cao.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cao.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cao.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView can;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.can = new NetworkErrorView(context);
            this.can.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.can, new FrameLayout.LayoutParams(-1, -1));
            this.can.setVisibility(8);
        }

        public void abh() {
            this.can.setVisibility(0);
        }

        public void abg() {
            this.can.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.can.setOnClickListener(onClickListener);
            this.can.setReloadClickListener(onClickListener);
        }
    }

    public void abe() {
        final com.baidu.swan.apps.core.d.b YP;
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH != null && (YP = QH.YP()) != null && YP.getView() != null) {
            final View view = null;
            if (YP instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) YP).YG().Tb() != null) {
                    view = YP.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (YP instanceof h) {
                if (((h) YP).Tb() != null && YP.getView() != null) {
                    view = YP.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, YP);
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
            if (i != this.cae) {
                if (this.cae - i > this.cah) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.XQ() && dVar.Yy()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.cae = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView cam;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cam = new DomainErrorView(context);
            this.cam.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cam, new FrameLayout.LayoutParams(-1, -1));
            this.cam.setVisibility(8);
        }

        public void jN(String str) {
            this.cam.nk(str);
            this.cam.setVisibility(0);
        }

        public void abg() {
            this.cam.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bZO)) {
                g.bA("route", SwanAppWebViewWidget.this.bZO).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bZP.bHQ = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bZO)) {
                g.bA("route", SwanAppWebViewWidget.this.bZO).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            HybridUbcFlow mr;
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bZP.bHS = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bZP.bHW = "0";
            if (g.crD && (mr = g.mr("startup")) != null) {
                mr.bD("fmp_type", "0");
                mr.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.bZP.bHS).a(UbcFlowEvent.RecordType.UPDATE)).alg();
                g.UI();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bZO)) {
                com.baidu.swan.apps.performance.h.mE(SwanAppWebViewWidget.this.bZO);
                SwanAppWebViewWidget.this.bZO = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bZP.bHR = System.currentTimeMillis();
            final long Ts = SwanAppWebViewWidget.this.bZP.Ts();
            final HybridUbcFlow mp = g.mp("startup");
            mp.f(new UbcFlowEvent("na_first_paint").bg(Ts));
            if (SwanAppWebViewWidget.this.bZP.bHS == 0) {
                SwanAppWebViewWidget.this.bZP.bHS = Ts;
                SwanAppWebViewWidget.this.bZP.bHW = SwanAppWebViewWidget.this.bZP.aL(Ts);
                if (g.crD) {
                    mp.bD("fmp_type", "1");
                    mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.bZP.bHR));
                    return;
                }
            }
            long Rz = com.baidu.swan.apps.u.a.aeU().Rz();
            if (Rz < 0) {
                Rz = 3000;
            }
            n.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.bZP.bHS <= 0) {
                        j = Ts;
                    } else {
                        j = SwanAppWebViewWidget.this.bZP.bHS;
                    }
                    mp.bD("fmp_type", SwanAppWebViewWidget.this.bZP.bHW);
                    mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(j)).alg();
                }
            }, "fmp record", Rz, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            }
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bZP.bHT = System.currentTimeMillis();
            if (SwanAppWebViewWidget.this.bZP.bHS == 0 && g.crD) {
                HybridUbcFlow mp = g.mp("startup");
                mp.bD("fmp_type", "2");
                mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.bZP.bHT));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            }
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bZP.bHU = System.currentTimeMillis();
            if (SwanAppWebViewWidget.this.bZP.bHS == 0 && g.crD) {
                HybridUbcFlow mp = g.mp("startup");
                mp.bD("fmp_type", "3");
                mp.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.bZP.bHU));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.u.a.aeU().Ro() && SwanAppWebViewWidget.this.Zh() && !com.baidu.swan.apps.ah.a.b.nQ(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jM(String str) {
        this.caf = str;
    }
}
