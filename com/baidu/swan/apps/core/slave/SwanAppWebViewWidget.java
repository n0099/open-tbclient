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
    private static final String[] brV = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    protected d brB;
    private c brO;
    private b brP;
    private a brQ;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.m.d brR;
    private e brS;
    private int brT;
    private String brU;
    private int brW;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.brW = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory Ha = com.baidu.swan.apps.w.a.Ur().Ha();
        if (Ha != null) {
            this.bmd.getCurrentWebView().setVideoPlayerFactory(Ha);
        }
        Qk();
        ca(context);
    }

    private void Qk() {
        this.bmd.getSettings().setLoadWithOverviewMode(true);
        this.bmd.getSettings().setUseWideViewPort(true);
        this.bmd.getSettings().setSupportZoom(true);
        this.bmd.getSettings().setBuiltInZoomControls(true);
        this.bmd.getSettings().setDisplayZoomControls(false);
    }

    private void ca(Context context) {
        com.baidu.swan.apps.adaptation.a.b HR = com.baidu.swan.apps.runtime.d.acA().acC().GT().HR();
        if (HR != null) {
            HR.bo(context);
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
        aVar.bmw = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MQ() {
        super.MQ();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bmi);
        eVar.c(this);
        this.bmi.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void MN() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (OC() && !com.baidu.swan.apps.aj.a.b.lh(str)) {
            Qo().hu(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean OC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IO() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.m.d IR() {
        return this.brR;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.m.d dVar) {
        this.brR = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Ql() {
        if (this.brO == null) {
            this.brO = new c(IN().getContext(), IN());
        }
        return this.brO;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        Qm();
    }

    private void Qm() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b Qn() {
        if (this.brP == null) {
            this.brP = new b(IN().getContext(), IN());
            this.brP.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.IN().getContext())) {
                        if (!SwanAppWebViewWidget.this.OC() || com.baidu.swan.apps.aj.a.b.lh(SwanAppWebViewWidget.this.IN().getUrl())) {
                            SwanAppWebViewWidget.this.IN().reload();
                            SwanAppWebViewWidget.this.brP.Qr();
                        }
                    }
                }
            });
        }
        return this.brP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Qo() {
        if (this.brQ == null) {
            this.brQ = new a(IN().getContext(), IN());
        }
        return this.brQ;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(d dVar) {
        this.brB = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void IQ() {
        super.IQ();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.brB = null;
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
            SwanAppWebViewWidget.this.Ql().startProgress();
            SwanAppWebViewWidget.this.Qp();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.Qn().Qs();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.Ql().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.OC() || com.baidu.swan.apps.aj.a.b.lh(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.brV) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.Qo().hu(str);
                            SwanAppWebViewWidget.this.IN().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean ck(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean MS() {
                                    SwanAppWebViewWidget.this.Qo().Qr();
                                    SwanAppWebViewWidget.this.IN().setOnWebViewHookHandler(null);
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
            if (SwanAppWebViewWidget.this.brS == null) {
                SwanAppWebViewWidget.this.brS = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.brS.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.brB != null) {
                    SwanAppWebViewWidget.this.brB.en(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.brS != null) {
            this.brS.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        private EfficientProgressBar bsd;

        public c(Context context, ViewGroup viewGroup) {
            this.bsd = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsd = new EfficientProgressBar(context);
            this.bsd.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bsd.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bsd.setVisibility(4);
            this.bsd.setFocusable(false);
            this.bsd.setClickable(false);
            viewGroup.addView(this.bsd);
        }

        public void startProgress() {
            this.bsd.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bsd.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bsd.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private NetworkErrorView bsc;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsc = new NetworkErrorView(context);
            this.bsc.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bsc, new FrameLayout.LayoutParams(-1, -1));
            this.bsc.setVisibility(8);
        }

        public void Qs() {
            this.bsc.setVisibility(0);
        }

        public void Qr() {
            this.bsc.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.bsc.setOnClickListener(onClickListener);
            this.bsc.setReloadClickListener(onClickListener);
        }
    }

    public void Qp() {
        final com.baidu.swan.apps.core.d.b Ol;
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA != null && (Ol = GA.Ol()) != null && Ol.getView() != null) {
            final View view = null;
            if (Ol instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) Ol).Ob().IH() != null) {
                    view = Ol.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (Ol instanceof h) {
                if (((h) Ol).IH() != null && Ol.getView() != null) {
                    view = Ol.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, Ol);
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
            if (i != this.brT) {
                if (this.brT - i > this.brW) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.Nu() && dVar.NU()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.brT = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private DomainErrorView bsb;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bsb = new DomainErrorView(context);
            this.bsb.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bsb, new FrameLayout.LayoutParams(-1, -1));
            this.bsb.setVisibility(8);
        }

        public void hu(String str) {
            this.bsb.kD(str);
            this.bsb.setVisibility(0);
        }

        public void Qr() {
            this.bsb.setVisibility(8);
        }
    }

    /* loaded from: classes11.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brC)) {
                com.baidu.swan.apps.performance.f.aY("route", SwanAppWebViewWidget.this.brC).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.brD.bbz = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brC)) {
                com.baidu.swan.apps.performance.f.aY("route", SwanAppWebViewWidget.this.brC).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.brD.bbB = System.currentTimeMillis();
            SwanAppWebViewWidget.this.brD.bbC = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.brC)) {
                g.kd(SwanAppWebViewWidget.this.brC);
                SwanAppWebViewWidget.this.brC = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.brD.bbA = currentTimeMillis;
            if (SwanAppWebViewWidget.this.brD.bbB == 0) {
                SwanAppWebViewWidget.this.brD.bbB = currentTimeMillis;
            }
            final HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            jP.f(new UbcFlowEvent("na_first_paint").au(currentTimeMillis));
            long Hu = com.baidu.swan.apps.w.a.TX().Hu();
            if (Hu < 0) {
                Hu = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.brD.bbB <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.brD.bbB;
                    }
                    jP.bb("fmp_type", SwanAppWebViewWidget.this.brD.bbC);
                    jP.f(new UbcFlowEvent("na_first_meaningful_paint").au(j)).ZD();
                }
            }, "fmp record", Hu, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.TX().Hj() && SwanAppWebViewWidget.this.OC() && !com.baidu.swan.apps.aj.a.b.lh(str)) {
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
        this.brU = str;
    }
}
