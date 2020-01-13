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
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
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
/* loaded from: classes10.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements f<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String[] bnM = {HttpHost.DEFAULT_SCHEME_NAME, "https"};
    private c bnF;
    private b bnG;
    private a bnH;
    @Nullable
    private d bnI;
    private e bnJ;
    private int bnK;
    private String bnL;
    private int bnN;
    protected com.baidu.swan.apps.core.f.d bns;
    private String mTitle;

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.bnN = 200;
        a(new WebViewWidgetClient());
        a(new SwanAppWebChromeClient());
        a(new SwanAppWebViewWidgetClientExt());
        VideoPlayerFactory EL = com.baidu.swan.apps.w.a.Sd().EL();
        if (EL != null) {
            this.bhR.getCurrentWebView().setVideoPlayerFactory(EL);
        }
        NW();
        bW(context);
    }

    private void NW() {
        this.bhR.getSettings().setLoadWithOverviewMode(true);
        this.bhR.getSettings().setUseWideViewPort(true);
        this.bhR.getSettings().setSupportZoom(true);
        this.bhR.getSettings().setBuiltInZoomControls(true);
        this.bhR.getSettings().setDisplayZoomControls(false);
    }

    private void bW(Context context) {
        com.baidu.swan.apps.adaptation.a.b FC = com.baidu.swan.apps.runtime.d.aam().aao().EE().FC();
        if (FC != null) {
            FC.bk(context);
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
        aVar.bil = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void KB() {
        super.KB();
        com.baidu.swan.apps.scheme.actions.m.e eVar = new com.baidu.swan.apps.scheme.actions.m.e(this.bhW);
        eVar.c(this);
        this.bhW.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    protected void Ky() {
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        if (Mo() && !com.baidu.swan.apps.aj.a.b.kS(str)) {
            Oa().hf(str);
        } else {
            super.loadUrl(str);
        }
    }

    protected boolean Mo() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Gz() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.adaptation.b.f
    @Nullable
    public d GC() {
        return this.bnI;
    }

    public void d(@Nullable d dVar) {
        this.bnI = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c NX() {
        if (this.bnF == null) {
            this.bnF = new c(Gy().getContext(), Gy());
        }
        return this.bnF;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void onPause() {
        super.onPause();
        NY();
    }

    private void NY() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b NZ() {
        if (this.bnG == null) {
            this.bnG = new b(Gy().getContext(), Gy());
            this.bnG.setReloadListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(SwanAppWebViewWidget.this.Gy().getContext())) {
                        if (!SwanAppWebViewWidget.this.Mo() || com.baidu.swan.apps.aj.a.b.kS(SwanAppWebViewWidget.this.Gy().getUrl())) {
                            SwanAppWebViewWidget.this.Gy().reload();
                            SwanAppWebViewWidget.this.bnG.Od();
                        }
                    }
                }
            });
        }
        return this.bnG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a Oa() {
        if (this.bnH == null) {
            this.bnH = new a(Gy().getContext(), Gy());
        }
        return this.bnH;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.adaptation.b.c
    public void a(com.baidu.swan.apps.core.f.d dVar) {
        this.bns = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void GB() {
        super.GB();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.bns = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.NX().startProgress();
            SwanAppWebViewWidget.this.Ob();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                SwanAppWebViewWidget.this.NZ().Oe();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.NX().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (!SwanAppWebViewWidget.this.Mo() || com.baidu.swan.apps.aj.a.b.kS(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }

        private void showDomainErrorView(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    URL url = new URL(str);
                    for (String str2 : SwanAppWebViewWidget.bnM) {
                        if (TextUtils.equals(url.getProtocol(), str2)) {
                            SwanAppWebViewWidget.this.Oa().hf(str);
                            SwanAppWebViewWidget.this.Gy().setOnWebViewHookHandler(new com.baidu.swan.apps.core.container.c() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient.1
                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean cd(boolean z) {
                                    return z;
                                }

                                @Override // com.baidu.swan.apps.core.container.c
                                public boolean KD() {
                                    SwanAppWebViewWidget.this.Oa().Od();
                                    SwanAppWebViewWidget.this.Gy().setOnWebViewHookHandler(null);
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

    /* loaded from: classes10.dex */
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
            if (SwanAppWebViewWidget.this.bnJ == null) {
                SwanAppWebViewWidget.this.bnJ = new e(SwanAppWebViewWidget.this.mContext);
            }
            SwanAppWebViewWidget.this.bnJ.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebChromeClient.1
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
                if (SwanAppWebViewWidget.this.bns != null) {
                    SwanAppWebViewWidget.this.bns.dY(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        if (this.bnJ != null) {
            this.bnJ.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c {
        private EfficientProgressBar bnU;

        public c(Context context, ViewGroup viewGroup) {
            this.bnU = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bnU = new EfficientProgressBar(context);
            this.bnU.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.bnU.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.bnU.setVisibility(4);
            this.bnU.setFocusable(false);
            this.bnU.setClickable(false);
            viewGroup.addView(this.bnU);
        }

        public void startProgress() {
            this.bnU.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.bnU.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.bnU.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private NetworkErrorView bnT;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bnT = new NetworkErrorView(context);
            this.bnT.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bnT, new FrameLayout.LayoutParams(-1, -1));
            this.bnT.setVisibility(8);
        }

        public void Oe() {
            this.bnT.setVisibility(0);
        }

        public void Od() {
            this.bnT.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.bnT.setOnClickListener(onClickListener);
            this.bnT.setReloadClickListener(onClickListener);
        }
    }

    public void Ob() {
        final com.baidu.swan.apps.core.d.b LX;
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El != null && (LX = El.LX()) != null && LX.getView() != null) {
            final View view = null;
            if (LX instanceof com.baidu.swan.apps.core.d.d) {
                if (((com.baidu.swan.apps.core.d.d) LX).LN().Gs() != null) {
                    view = LX.getView().findViewById(a.f.ai_apps_fragment_base_view);
                } else {
                    return;
                }
            } else if (LX instanceof h) {
                if (((h) LX).Gs() != null && LX.getView() != null) {
                    view = LX.getView().findViewById(a.f.swan_app_webview_fragment);
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
                        SwanAppWebViewWidget.this.a(view, LX);
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
            if (i != this.bnK) {
                if (this.bnK - i > this.bnN) {
                    int i2 = 0;
                    if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) bVar;
                        if (dVar.Lf() && dVar.LG()) {
                            i2 = view.getResources().getDimensionPixelSize(a.d.aiapps_bottom_tab_height);
                        }
                    }
                    view.getLayoutParams().height = i2 + i;
                } else {
                    view.getLayoutParams().height = i;
                }
                view.requestLayout();
                this.bnK = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private DomainErrorView bnS;

        public a(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.bnS = new DomainErrorView(context);
            this.bnS.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.bnS, new FrameLayout.LayoutParams(-1, -1));
            this.bnS.setVisibility(8);
        }

        public void hf(String str) {
            this.bnS.ko(str);
            this.bnS.setVisibility(0);
        }

        public void Od() {
            this.bnS.setVisibility(8);
        }
    }

    /* loaded from: classes10.dex */
    private class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bnt)) {
                com.baidu.swan.apps.performance.f.aP("route", SwanAppWebViewWidget.this.bnt).f(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bnu.aXo = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bnt)) {
                com.baidu.swan.apps.performance.f.aP("route", SwanAppWebViewWidget.this.bnt).f(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.bnu.aXq = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bnu.aXr = "0";
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.bnt)) {
                g.jO(SwanAppWebViewWidget.this.bnt);
                SwanAppWebViewWidget.this.bnt = "";
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.DEBUG) {
                Log.d("SwanAppWebViewWidget", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            }
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            final long currentTimeMillis = System.currentTimeMillis();
            SwanAppWebViewWidget.this.bnu.aXp = currentTimeMillis;
            if (SwanAppWebViewWidget.this.bnu.aXq == 0) {
                SwanAppWebViewWidget.this.bnu.aXq = currentTimeMillis;
            }
            final HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
            jA.f(new UbcFlowEvent("na_first_paint").aq(currentTimeMillis));
            long Ff = com.baidu.swan.apps.w.a.RJ().Ff();
            if (Ff < 0) {
                Ff = 3000;
            }
            m.b(new Runnable() { // from class: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.SwanAppWebViewWidgetClientExt.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    if (SwanAppWebViewWidget.this.bnu.aXq <= 0) {
                        j = currentTimeMillis;
                    } else {
                        j = SwanAppWebViewWidget.this.bnu.aXq;
                    }
                    jA.aS("fmp_type", SwanAppWebViewWidget.this.bnu.aXr);
                    jA.f(new UbcFlowEvent("na_first_meaningful_paint").aq(j)).Xp();
                }
            }, "fmp record", Ff, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (com.baidu.swan.apps.w.a.RJ().EU() && SwanAppWebViewWidget.this.Mo() && !com.baidu.swan.apps.aj.a.b.kS(str)) {
                if (SwanAppWebViewWidget.DEBUG) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void he(String str) {
        this.bnL = str;
    }
}
