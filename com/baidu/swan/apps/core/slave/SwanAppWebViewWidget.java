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
    private static final String[] bsj = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d brP;
    private c bsc;
    private b bsd;
    private a bse;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d bsf;
    private e bsg;
    private int bsh;
    private String bsi;
    private int bsk;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.bsk = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Hh = com.baidu.swan.apps.w.a.Uw().Hh();
        if (Hh != null) {
            this.bmt.getCurrentWebView().setVideoPlayerFactory(Hh);
        }
        Qp();
        bZ(context);
    }

    private void Qp() {
        this.bmt.getSettings().setLoadWithOverviewMode(true);
        this.bmt.getSettings().setUseWideViewPort(true);
        this.bmt.getSettings().setSupportZoom(true);
        this.bmt.getSettings().setBuiltInZoomControls(true);
        this.bmt.getSettings().setDisplayZoomControls(false);
    }

    private void bZ(Context context) {
        com.baidu.swan.apps.adaptation.a.b HW = com.baidu.swan.apps.runtime.d.acF().acH().Ha().HW();
        if (HW != null) {
            HW.bn(context);
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
        aVar.bmL = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MV() {
        super.MV();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bmy);
        eVar.c(this);
        this.bmy.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MS() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (OH() && !com.baidu.swan.apps.aj.a.b.lg(str)) {
            Qt().ht(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean OH() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IT() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d IW() {
        return this.bsf;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.bsf = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Qq() {
        if (this.bsc == null) {
            this.bsc = new c(IS().getContext(), IS());
        }
        return this.bsc;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        Qr();
    }

    private void Qr() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b Qs() {
        if (this.bsd == null) {
            this.bsd = new b(IS().getContext(), IS());
            this.bsd.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.IS().getContext())) {
                        if (!SwanAppWebViewWidget.this.OH() || com.baidu.swan.apps.aj.a.b.lg(SwanAppWebViewWidget.this.IS().getUrl())) {
                            SwanAppWebViewWidget.this.IS().reload();
                            SwanAppWebViewWidget.this.bsd.Qw();
                        }
                    }
                }
            });
        }
        return this.bsd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Qt() {
        if (this.bse == null) {
            this.bse = new a(IS().getContext(), IS());
        }
        return this.bse;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.brP = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void IV() {
        super.IV();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.brP = null;
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
            SwanAppWebViewWidget.this.Qq().startProgress();
            SwanAppWebViewWidget.this.Qu();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.Qs().Qx();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.Qq().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.OH() || com.baidu.swan.apps.aj.a.b.lg(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.bsj) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.Qt().ht(str);
                            SwanAppWebViewWidget.this.IS().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean cl(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean MX() {
                                    SwanAppWebViewWidget.this.Qt().Qw();
                                    SwanAppWebViewWidget.this.IS().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.bsg == null) {
                SwanAppWebViewWidget.this.bsg = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.bsg.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.brP != null) {
                    SwanAppWebViewWidget.this.brP.em(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.bsg != null) {
            this.bsg.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar bsr;

        public c(Context context, ViewGroup viewGroup) {
            this.bsr = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsr = new EfficientProgressBar(context);
            this.bsr.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bsr.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bsr.setVisibility(4);
            this.bsr.setFocusable(false);
            this.bsr.setClickable(false);
            viewGroup.addView(this.bsr);
        }

        public void startProgress() {
            this.bsr.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bsr.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bsr.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView bsq;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsq = new NetworkErrorView(context);
            this.bsq.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bsq, new FrameLayout.LayoutParams(-1, -1));
            this.bsq.setVisibility(8);
        }

        public void Qx() {
            this.bsq.setVisibility(0);
        }

        public void Qw() {
            this.bsq.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.bsq.setOnClickListener(onClickListener);
            this.bsq.setReloadClickListener(onClickListener);
        }
    }

    public void Qu() {
        final com.baidu.swan.apps.core.d.b Oq;
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH != null && (Oq = GH.Oq()) != null && Oq.getView() != null) {
            final View view = null;
            if (Oq instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) Oq).Og().IM() != null) {
                    view = Oq.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (Oq instanceof h) {
                if (((h) Oq).IM() != null && Oq.getView() != null) {
                    view = Oq.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, Oq);
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
            if (i != this.bsh) {
                if (this.bsh - i > this.bsk) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.Nz() && dVar.NZ()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.bsh = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView bsp;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsp = new DomainErrorView(context);
            this.bsp.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bsp, new FrameLayout.LayoutParams(-1, -1));
            this.bsp.setVisibility(8);
        }

        public void ht(String str) {
            this.bsp.kC(str);
            this.bsp.setVisibility(0);
        }

        public void Qw() {
            this.bsp.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brQ)) {
                com.baidu.swan.apps.performance.f.aX("route", SwanAppWebViewWidget.this.brQ).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.brR.bbO = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brQ)) {
                com.baidu.swan.apps.performance.f.aX("route", SwanAppWebViewWidget.this.brQ).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.brR.bbQ = System.currentTimeMillis();
            SwanAppWebViewWidget.this.brR.bbR = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brQ)) {
                g.kc(SwanAppWebViewWidget.this.brQ);
                SwanAppWebViewWidget.this.brQ = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.brR.bbP = currentTimeMillis;
            if (SwanAppWebViewWidget.this.brR.bbQ == 0) {
                SwanAppWebViewWidget.this.brR.bbQ = currentTimeMillis;
            }
            final HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
            jO.f(new UbcFlowEvent("na_first_paint").au(currentTimeMillis));
            long HB = com.baidu.swan.apps.w.a.Uc().HB();
            if (HB < 0) {
                HB = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.brR.bbQ <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.brR.bbQ;
                    }
                    jO.ba("fmp_type", SwanAppWebViewWidget.this.brR.bbR);
                    jO.f(new UbcFlowEvent("na_first_meaningful_paint").au(j)).ZI();
                }
            }, "fmp record", HB, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.Uc().Hq() && SwanAppWebViewWidget.this.OH() && !com.baidu.swan.apps.aj.a.b.lg(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hs(String str) {
        this.bsi = str;
    }
}
