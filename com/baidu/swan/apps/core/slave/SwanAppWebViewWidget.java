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
    private static final String[] bQp = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d bPW;
    private c bQi;
    private b bQj;
    private a bQk;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d bQl;
    private e bQm;
    private int bQn;
    private String bQo;
    private int bQq;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.bQq = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory OU = com.baidu.swan.apps.w.a.acl().OU();
        if (OU != null) {
            this.bKA.getCurrentWebView().setVideoPlayerFactory(OU);
        }
        Ye();
        bN(context);
    }

    private void Ye() {
        this.bKA.getSettings().setLoadWithOverviewMode(true);
        this.bKA.getSettings().setUseWideViewPort(true);
        this.bKA.getSettings().setSupportZoom(true);
        this.bKA.getSettings().setBuiltInZoomControls(true);
        this.bKA.getSettings().setDisplayZoomControls(false);
    }

    private void bN(Context context) {
        com.baidu.swan.apps.adaptation.a.b PI = com.baidu.swan.apps.runtime.d.akK().akM().ON().PI();
        if (PI != null) {
            PI.bb(context);
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
        aVar.bKS = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UI() {
        super.UI();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bKF);
        eVar.c(this);
        this.bKF.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void UF() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (Ww() && !com.baidu.swan.apps.aj.a.b.mt(str)) {
            Yi().iH(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean Ww() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String QF() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d QI() {
        return this.bQl;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.bQl = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Yf() {
        if (this.bQi == null) {
            this.bQi = new c(QE().getContext(), QE());
        }
        return this.bQi;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        Yg();
    }

    private void Yg() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b Yh() {
        if (this.bQj == null) {
            this.bQj = new b(QE().getContext(), QE());
            this.bQj.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.QE().getContext())) {
                        if (!SwanAppWebViewWidget.this.Ww() || com.baidu.swan.apps.aj.a.b.mt(SwanAppWebViewWidget.this.QE().getUrl())) {
                            SwanAppWebViewWidget.this.QE().reload();
                            SwanAppWebViewWidget.this.bQj.Yl();
                        }
                    }
                }
            });
        }
        return this.bQj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Yi() {
        if (this.bQk == null) {
            this.bQk = new a(QE().getContext(), QE());
        }
        return this.bQk;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.bPW = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void QH() {
        super.QH();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.bPW = null;
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
            SwanAppWebViewWidget.this.Yf().startProgress();
            SwanAppWebViewWidget.this.Yj();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.Yh().Ym();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.Yf().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.Ww() || com.baidu.swan.apps.aj.a.b.mt(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.bQp) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.Yi().iH(str);
                            SwanAppWebViewWidget.this.QE().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean dh(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean UK() {
                                    SwanAppWebViewWidget.this.Yi().Yl();
                                    SwanAppWebViewWidget.this.QE().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.bQm == null) {
                SwanAppWebViewWidget.this.bQm = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.bQm.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.bPW != null) {
                    SwanAppWebViewWidget.this.bPW.ff(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.bQm != null) {
            this.bQm.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar bQx;

        public c(Context context, ViewGroup viewGroup) {
            this.bQx = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bQx = new EfficientProgressBar(context);
            this.bQx.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bQx.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bQx.setVisibility(4);
            this.bQx.setFocusable(false);
            this.bQx.setClickable(false);
            viewGroup.addView(this.bQx);
        }

        public void startProgress() {
            this.bQx.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bQx.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bQx.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView bQw;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bQw = new NetworkErrorView(context);
            this.bQw.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bQw, new FrameLayout.LayoutParams(-1, -1));
            this.bQw.setVisibility(8);
        }

        public void Ym() {
            this.bQw.setVisibility(0);
        }

        public void Yl() {
            this.bQw.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.bQw.setOnClickListener(onClickListener);
            this.bQw.setReloadClickListener(onClickListener);
        }
    }

    public void Yj() {
        final com.baidu.swan.apps.core.d.b We;
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou != null && (We = Ou.We()) != null && We.getView() != null) {
            final View view = null;
            if (We instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) We).VU().Qy() != null) {
                    view = We.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (We instanceof h) {
                if (((h) We).Qy() != null && We.getView() != null) {
                    view = We.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, We);
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
            if (i != this.bQn) {
                if (this.bQn - i > this.bQq) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.Vm() && dVar.VN()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.bQn = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView bQv;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bQv = new DomainErrorView(context);
            this.bQv.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bQv, new FrameLayout.LayoutParams(-1, -1));
            this.bQv.setVisibility(8);
        }

        public void iH(String str) {
            this.bQv.lP(str);
            this.bQv.setVisibility(0);
        }

        public void Yl() {
            this.bQv.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bPX)) {
                com.baidu.swan.apps.performance.f.bh("route", SwanAppWebViewWidget.this.bPX).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bPY.bAc = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bPX)) {
                com.baidu.swan.apps.performance.f.bh("route", SwanAppWebViewWidget.this.bPX).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bPY.bAe = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bPY.bAf = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bPX)) {
                g.lp(SwanAppWebViewWidget.this.bPX);
                SwanAppWebViewWidget.this.bPX = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bPY.bAd = currentTimeMillis;
            if (SwanAppWebViewWidget.this.bPY.bAe == 0) {
                SwanAppWebViewWidget.this.bPY.bAe = currentTimeMillis;
            }
            final HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            lb.f(new UbcFlowEvent("na_first_paint").aZ(currentTimeMillis));
            long Po = com.baidu.swan.apps.w.a.abR().Po();
            if (Po < 0) {
                Po = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.bPY.bAe <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.bPY.bAe;
                    }
                    lb.bk("fmp_type", SwanAppWebViewWidget.this.bPY.bAf);
                    lb.f(new UbcFlowEvent("na_first_meaningful_paint").aZ(j)).ahN();
                }
            }, "fmp record", Po, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.abR().Pd() && SwanAppWebViewWidget.this.Ww() && !com.baidu.swan.apps.aj.a.b.mt(str)) {
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
        this.bQo = str;
    }
}
