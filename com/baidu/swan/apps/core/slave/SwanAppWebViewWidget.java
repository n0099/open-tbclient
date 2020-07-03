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
    private static final String[] ceW = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d ceD;
    private c ceP;
    private b ceQ;
    private a ceR;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d ceS;
    private e ceT;
    private int ceU;
    private String ceV;
    private int ceX;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.ceX = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Sk = com.baidu.swan.apps.u.a.agt().Sk();
        if (Sk != null) {
            this.bYq.getCurrentWebView().setVideoPlayerFactory(Sk);
        }
        acf();
        bN(context);
    }

    private void acf() {
        this.bYq.getSettings().setLoadWithOverviewMode(true);
        this.bYq.getSettings().setUseWideViewPort(true);
        this.bYq.getSettings().setSupportZoom(true);
        this.bYq.getSettings().setBuiltInZoomControls(true);
        this.bYq.getSettings().setDisplayZoomControls(false);
    }

    private void bN(Context context) {
        com.baidu.swan.apps.adaptation.a.b TG = com.baidu.swan.apps.runtime.d.apI().apK().Se().TG();
        if (TG != null) {
            TG.ba(context);
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
        aVar.bYH = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Yt() {
        super.Yt();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bYv);
        eVar.c(this);
        this.bYv.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Yq() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (aan() && !com.baidu.swan.apps.ah.a.b.nY(str)) {
            acj().jV(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean aan() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Uo() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d Ur() {
        return this.ceS;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.ceS = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c acg() {
        if (this.ceP == null) {
            this.ceP = new c(Un().getContext(), Un());
        }
        return this.ceP;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        ach();
    }

    private void ach() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aci() {
        if (this.ceQ == null) {
            this.ceQ = new b(Un().getContext(), Un());
            this.ceQ.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.Un().getContext())) {
                        if (!SwanAppWebViewWidget.this.aan() || com.baidu.swan.apps.ah.a.b.nY(SwanAppWebViewWidget.this.Un().getUrl())) {
                            SwanAppWebViewWidget.this.Un().reload();
                            SwanAppWebViewWidget.this.ceQ.acm();
                        }
                    }
                }
            });
        }
        return this.ceQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a acj() {
        if (this.ceR == null) {
            this.ceR = new a(Un().getContext(), Un());
        }
        return this.ceR;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.ceD = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void Uq() {
        super.Uq();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.ceD = null;
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
            SwanAppWebViewWidget.this.acg().startProgress();
            SwanAppWebViewWidget.this.ack();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.aci().acn();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.acg().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.aan() || com.baidu.swan.apps.ah.a.b.nY(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.ceW) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.acj().jV(str);
                            SwanAppWebViewWidget.this.Un().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dz(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean Yv() {
                                    SwanAppWebViewWidget.this.acj().acm();
                                    SwanAppWebViewWidget.this.Un().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.ceT == null) {
                SwanAppWebViewWidget.this.ceT = new e(SwanAppWebViewWidget.this.bYp.getBaseContext());
            }
            SwanAppWebViewWidget.this.ceT.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.ceD != null) {
                    SwanAppWebViewWidget.this.ceD.fZ(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.ceT != null) {
            this.ceT.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar cfe;

        public c(Context context, ViewGroup viewGroup) {
            this.cfe = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cfe = new EfficientProgressBar(context);
            this.cfe.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.cfe.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.cfe.setVisibility(4);
            this.cfe.setFocusable(false);
            this.cfe.setClickable(false);
            viewGroup.addView(this.cfe);
        }

        public void startProgress() {
            this.cfe.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.cfe.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.cfe.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView cfd;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cfd = new NetworkErrorView(context);
            this.cfd.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cfd, new FrameLayout.LayoutParams(-1, -1));
            this.cfd.setVisibility(8);
        }

        public void acn() {
            this.cfd.setVisibility(0);
        }

        public void acm() {
            this.cfd.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.cfd.setOnClickListener(onClickListener);
            this.cfd.setReloadClickListener(onClickListener);
        }
    }

    public void ack() {
        final com.baidu.swan.apps.core.d.b ZV;
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN != null && (ZV = RN.ZV()) != null && ZV.getView() != null) {
            final View view = null;
            if (ZV instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) ZV).ZM().Uh() != null) {
                    view = ZV.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (ZV instanceof h) {
                if (((h) ZV).Uh() != null && ZV.getView() != null) {
                    view = ZV.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, ZV);
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
            if (i != this.ceU) {
                if (this.ceU - i > this.ceX) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.YW() && dVar.ZE()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.ceU = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView cfc;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.cfc = new DomainErrorView(context);
            this.cfc.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.cfc, new FrameLayout.LayoutParams(-1, -1));
            this.cfc.setVisibility(8);
        }

        public void jV(String str) {
            this.cfc.ns(str);
            this.cfc.setVisibility(0);
        }

        public void acm() {
            this.cfc.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.ceE)) {
                g.bC("route", SwanAppWebViewWidget.this.ceE).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.ceF.bME = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.ceE)) {
                g.bC("route", SwanAppWebViewWidget.this.ceE).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            HybridUbcFlow mz;
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.ceF.bMG = System.currentTimeMillis();
            SwanAppWebViewWidget.this.ceF.bMK = "0";
            if (g.cwr && (mz = g.mz("startup")) != null) {
                mz.bF("fmp_type", "0");
                mz.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.ceF.bMG).a(UbcFlowEvent.RecordType.UPDATE)).amm();
                g.VO();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.ceE)) {
                com.baidu.swan.apps.performance.h.mM(SwanAppWebViewWidget.this.ceE);
                SwanAppWebViewWidget.this.ceE = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.ceF.bMF = System.currentTimeMillis();
            final long Uy = SwanAppWebViewWidget.this.ceF.Uy();
            final HybridUbcFlow mx = g.mx("startup");
            mx.f(new UbcFlowEvent("na_first_paint").bg(Uy));
            if (SwanAppWebViewWidget.this.ceF.bMG == 0) {
                SwanAppWebViewWidget.this.ceF.bMG = Uy;
                SwanAppWebViewWidget.this.ceF.bMK = SwanAppWebViewWidget.this.ceF.aL(Uy);
                if (g.cwr) {
                    mx.bF("fmp_type", "1");
                    mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.ceF.bMF));
                    return;
                }
            }
            long SF = com.baidu.swan.apps.u.a.aga().SF();
            if (SF < 0) {
                SF = 3000;
            }
            n.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.ceF.bMG <= 0) {
                        j = Uy;
                    } else {
                        j = SwanAppWebViewWidget.this.ceF.bMG;
                    }
                    mx.bF("fmp_type", SwanAppWebViewWidget.this.ceF.bMK);
                    mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(j)).amm();
                }
            }, "fmp record", SF, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            }
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.ceF.bMH = System.currentTimeMillis();
            if (SwanAppWebViewWidget.this.ceF.bMG == 0 && g.cwr) {
                HybridUbcFlow mx = g.mx("startup");
                mx.bF("fmp_type", "2");
                mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.ceF.bMH));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            }
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.ceF.bMI = System.currentTimeMillis();
            if (SwanAppWebViewWidget.this.ceF.bMG == 0 && g.cwr) {
                HybridUbcFlow mx = g.mx("startup");
                mx.bF("fmp_type", "3");
                mx.f(new UbcFlowEvent("na_first_meaningful_paint").bg(SwanAppWebViewWidget.this.ceF.bMI));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.u.a.aga().Su() && SwanAppWebViewWidget.this.aan() && !com.baidu.swan.apps.ah.a.b.nY(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jU(String str) {
        this.ceV = str;
    }
}
