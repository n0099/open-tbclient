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
    private static final String[] brW = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d brC;
    private c brP;
    private b brQ;
    private a brR;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d brS;
    private e brT;
    private int brU;
    private String brV;
    private int brX;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.brX = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Hc = com.baidu.swan.apps.w.a.Ut().Hc();
        if (Hc != null) {
            this.bme.getCurrentWebView().setVideoPlayerFactory(Hc);
        }
        Qm();
        ca(context);
    }

    private void Qm() {
        this.bme.getSettings().setLoadWithOverviewMode(true);
        this.bme.getSettings().setUseWideViewPort(true);
        this.bme.getSettings().setSupportZoom(true);
        this.bme.getSettings().setBuiltInZoomControls(true);
        this.bme.getSettings().setDisplayZoomControls(false);
    }

    private void ca(Context context) {
        com.baidu.swan.apps.adaptation.a.b HT = com.baidu.swan.apps.runtime.d.acC().acE().GV().HT();
        if (HT != null) {
            HT.bo(context);
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
        aVar.bmx = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MS() {
        super.MS();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bmj);
        eVar.c(this);
        this.bmj.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MP() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (OE() && !com.baidu.swan.apps.aj.a.b.lh(str)) {
            Qq().hu(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean OE() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IQ() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d IT() {
        return this.brS;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.brS = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Qn() {
        if (this.brP == null) {
            this.brP = new c(IP().getContext(), IP());
        }
        return this.brP;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        Qo();
    }

    private void Qo() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b Qp() {
        if (this.brQ == null) {
            this.brQ = new b(IP().getContext(), IP());
            this.brQ.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.IP().getContext())) {
                        if (!SwanAppWebViewWidget.this.OE() || com.baidu.swan.apps.aj.a.b.lh(SwanAppWebViewWidget.this.IP().getUrl())) {
                            SwanAppWebViewWidget.this.IP().reload();
                            SwanAppWebViewWidget.this.brQ.Qt();
                        }
                    }
                }
            });
        }
        return this.brQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Qq() {
        if (this.brR == null) {
            this.brR = new a(IP().getContext(), IP());
        }
        return this.brR;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.brC = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void IS() {
        super.IS();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.brC = null;
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
            SwanAppWebViewWidget.this.Qn().startProgress();
            SwanAppWebViewWidget.this.Qr();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.Qp().Qu();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.Qn().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.OE() || com.baidu.swan.apps.aj.a.b.lh(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.brW) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.Qq().hu(str);
                            SwanAppWebViewWidget.this.IP().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean ck(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean MU() {
                                    SwanAppWebViewWidget.this.Qq().Qt();
                                    SwanAppWebViewWidget.this.IP().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.brT == null) {
                SwanAppWebViewWidget.this.brT = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.brT.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.brC != null) {
                    SwanAppWebViewWidget.this.brC.en(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.brT != null) {
            this.brT.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar bse;

        public c(Context context, ViewGroup viewGroup) {
            this.bse = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bse = new EfficientProgressBar(context);
            this.bse.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bse.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bse.setVisibility(4);
            this.bse.setFocusable(false);
            this.bse.setClickable(false);
            viewGroup.addView(this.bse);
        }

        public void startProgress() {
            this.bse.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bse.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bse.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView bsd;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsd = new NetworkErrorView(context);
            this.bsd.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bsd, new FrameLayout.LayoutParams(-1, -1));
            this.bsd.setVisibility(8);
        }

        public void Qu() {
            this.bsd.setVisibility(0);
        }

        public void Qt() {
            this.bsd.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.bsd.setOnClickListener(onClickListener);
            this.bsd.setReloadClickListener(onClickListener);
        }
    }

    public void Qr() {
        final com.baidu.swan.apps.core.d.b On;
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC != null && (On = GC.On()) != null && On.getView() != null) {
            final View view = null;
            if (On instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) On).Od().IJ() != null) {
                    view = On.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (On instanceof h) {
                if (((h) On).IJ() != null && On.getView() != null) {
                    view = On.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, On);
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
            if (i != this.brU) {
                if (this.brU - i > this.brX) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.Nw() && dVar.NW()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.brU = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView bsc;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsc = new DomainErrorView(context);
            this.bsc.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bsc, new FrameLayout.LayoutParams(-1, -1));
            this.bsc.setVisibility(8);
        }

        public void hu(String str) {
            this.bsc.kD(str);
            this.bsc.setVisibility(0);
        }

        public void Qt() {
            this.bsc.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brD)) {
                com.baidu.swan.apps.performance.f.aY("route", SwanAppWebViewWidget.this.brD).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.brE.bbA = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brD)) {
                com.baidu.swan.apps.performance.f.aY("route", SwanAppWebViewWidget.this.brD).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.brE.bbC = System.currentTimeMillis();
            SwanAppWebViewWidget.this.brE.bbD = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brD)) {
                g.kd(SwanAppWebViewWidget.this.brD);
                SwanAppWebViewWidget.this.brD = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.brE.bbB = currentTimeMillis;
            if (SwanAppWebViewWidget.this.brE.bbC == 0) {
                SwanAppWebViewWidget.this.brE.bbC = currentTimeMillis;
            }
            final HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            jP.f(new UbcFlowEvent("na_first_paint").au(currentTimeMillis));
            long Hw = com.baidu.swan.apps.w.a.TZ().Hw();
            if (Hw < 0) {
                Hw = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.brE.bbC <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.brE.bbC;
                    }
                    jP.bb("fmp_type", SwanAppWebViewWidget.this.brE.bbD);
                    jP.f(new UbcFlowEvent("na_first_meaningful_paint").au(j)).ZF();
                }
            }, "fmp record", Hw, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.TZ().Hl() && SwanAppWebViewWidget.this.OE() && !com.baidu.swan.apps.aj.a.b.lh(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ht(String str) {
        this.brV = str;
    }
}
