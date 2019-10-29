package com.baidu.swan.apps.core.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.b.c.a.c;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.core.b;
import com.baidu.swan.apps.core.container.SystemWebViewImpl;
import com.baidu.swan.apps.core.e.e;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.core.i.c implements f<SystemWebViewImpl> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.core.f.c aNA;
    private c aNC;
    private b aND;
    protected boolean aNE;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.k.d aNF;
    private com.baidu.swan.apps.core.e.e aNG;
    private int aNH;

    public d(Context context) {
        super(context);
        this.aNE = true;
        a(new C0181d());
        a(new a());
        aY(context);
    }

    private void aY(Context context) {
        com.baidu.swan.apps.b.b.a Bz = com.baidu.swan.apps.ae.e.Rr().bks.get().AX().Bz();
        if (Bz != null) {
            Bz.aH(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(Context context, com.baidu.swan.apps.b.c.e eVar) {
        super.a(context, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aIX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b
    public void DP() {
        super.DP();
        com.baidu.swan.apps.scheme.actions.k.e eVar = new com.baidu.swan.apps.scheme.actions.k.e(this.aIN);
        eVar.c(this);
        this.aIN.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.aNE && !com.baidu.swan.apps.af.a.b.hz(str)) {
            GJ().GL();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String Cs() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.k.d Cu() {
        return this.aNF;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.k.d dVar) {
        this.aNF = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c GH() {
        if (this.aNC == null) {
            this.aNC = new c(Cr().getContext(), Cr());
        }
        return this.aNC;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        GI();
    }

    private void GI() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b GJ() {
        if (this.aND == null) {
            this.aND = new b(Cr().getContext(), Cr());
            this.aND.d(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.i.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.Cr().getContext()) && com.baidu.swan.apps.af.a.b.hz(d.this.Cr().getUrl())) {
                        d.this.Cr().reload();
                        d.this.aND.GM();
                    }
                }
            });
        }
        return this.aND;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.aNA = cVar;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.aNA = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.swan.apps.core.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0181d extends WebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public C0181d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            d.this.GH().GN();
            if (com.baidu.swan.apps.u.a.Jl().Bn()) {
                d.this.GK();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.GJ().GL();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.GH().hideProgressBar();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (d.DEBUG) {
                Log.d("SwanAppSysWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (com.baidu.swan.apps.af.a.b.hz(str)) {
                return e.O(webView.getContext(), str);
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    private class a extends WebChromeClient {
        private a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            d.this.hideCustomView();
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            onShowCustomView(view, 0, customViewCallback);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int i, final WebChromeClient.CustomViewCallback customViewCallback) {
            if (d.this.aNG == null) {
                d.this.aNG = new com.baidu.swan.apps.core.e.e(d.this.mContext);
            }
            d.this.aNG.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.i.d.a.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void FX() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.aNA != null) {
                d.this.aNA.dc(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.Cz().a(new c.a() { // from class: com.baidu.swan.apps.core.i.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.Cz().b(this);
                        valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
                    }
                }
            });
            try {
                Activity activity = webView.getContext() instanceof Activity ? (Activity) webView.getContext() : null;
                if (activity != null) {
                    activity.startActivityForResult(fileChooserParams.createIntent(), 200);
                }
                return true;
            } catch (Exception e) {
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).QN();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.aNG != null) {
            this.aNG.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar aNO;

        public c(Context context, ViewGroup viewGroup) {
            this.aNO = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.aNO = new EfficientProgressBar(context);
            this.aNO.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.aNO.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.aNO.setVisibility(4);
            this.aNO.setFocusable(false);
            this.aNO.setClickable(false);
            viewGroup.addView(this.aNO);
        }

        public void GN() {
            this.aNO.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.aNO.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.aNO.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView aNN;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.aNN = new NetworkErrorView(context);
            this.aNN.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.aNN, new FrameLayout.LayoutParams(-1, -1));
            this.aNN.setVisibility(8);
        }

        public void GL() {
            this.aNN.setVisibility(0);
        }

        public void GM() {
            this.aNN.setVisibility(8);
        }

        public void d(View.OnClickListener onClickListener) {
            this.aNN.setOnClickListener(onClickListener);
            this.aNN.setReloadClickListener(onClickListener);
        }
    }

    public void GK() {
        com.baidu.swan.apps.core.d.d Fr = com.baidu.swan.apps.w.e.LD().AH().Fr();
        if (Fr != null && Fr.getView() != null) {
            final View findViewById = Fr.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (Fr.Fg().Cm() != null && findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.core.i.d.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (d.DEBUG) {
                            Log.d("SwanAppSysWebViewWidget", "onGlobalLayout");
                        }
                        d.this.ae(findViewById);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != this.aNH) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.aNH = i;
        }
    }
}
