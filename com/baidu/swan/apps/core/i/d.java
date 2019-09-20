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
    protected com.baidu.swan.apps.core.f.c auj;
    private c aul;
    private b aum;
    protected boolean aun;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.k.d auo;
    private com.baidu.swan.apps.core.e.e aup;
    private int auq;

    public d(Context context) {
        super(context);
        this.aun = true;
        a(new C0149d());
        a(new a());
        aW(context);
    }

    private void aW(Context context) {
        com.baidu.swan.apps.b.b.a wF = com.baidu.swan.apps.ae.e.Mz().aRo.get().wd().wF();
        if (wF != null) {
            wF.aF(context);
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
        aVar.apH = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b
    public void yU() {
        super.yU();
        com.baidu.swan.apps.scheme.actions.k.e eVar = new com.baidu.swan.apps.scheme.actions.k.e(this.apx);
        eVar.c(this);
        this.apx.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.aun && !com.baidu.swan.apps.af.a.b.gV(str)) {
            BP().BR();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String xy() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.k.d xA() {
        return this.auo;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.k.d dVar) {
        this.auo = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c BN() {
        if (this.aul == null) {
            this.aul = new c(xx().getContext(), xx());
        }
        return this.aul;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        BO();
    }

    private void BO() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b BP() {
        if (this.aum == null) {
            this.aum = new b(xx().getContext(), xx());
            this.aum.c(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.i.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.xx().getContext()) && com.baidu.swan.apps.af.a.b.gV(d.this.xx().getUrl())) {
                        d.this.xx().reload();
                        d.this.aum.BS();
                    }
                }
            });
        }
        return this.aum;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.auj = cVar;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.auj = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.swan.apps.core.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0149d extends WebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public C0149d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            d.this.BN().BT();
            if (com.baidu.swan.apps.u.a.Er().wt()) {
                d.this.BQ();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.BP().BR();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.BN().hideProgressBar();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (d.DEBUG) {
                Log.d("SwanAppSysWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (com.baidu.swan.apps.af.a.b.gV(str)) {
                return e.P(webView.getContext(), str);
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
            if (d.this.aup == null) {
                d.this.aup = new com.baidu.swan.apps.core.e.e(d.this.mContext);
            }
            d.this.aup.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.i.d.a.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void Bc() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.auj != null) {
                d.this.auj.dg(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.xF().a(new c.a() { // from class: com.baidu.swan.apps.core.i.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.xF().b(this);
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
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).LU();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.aup != null) {
            this.aup.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar aux;

        public c(Context context, ViewGroup viewGroup) {
            this.aux = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.aux = new EfficientProgressBar(context);
            this.aux.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.aux.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.aux.setVisibility(4);
            this.aux.setFocusable(false);
            this.aux.setClickable(false);
            viewGroup.addView(this.aux);
        }

        public void BT() {
            this.aux.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.aux.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.aux.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView auw;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.auw = new NetworkErrorView(context);
            this.auw.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.auw, new FrameLayout.LayoutParams(-1, -1));
            this.auw.setVisibility(8);
        }

        public void BR() {
            this.auw.setVisibility(0);
        }

        public void BS() {
            this.auw.setVisibility(8);
        }

        public void c(View.OnClickListener onClickListener) {
            this.auw.setOnClickListener(onClickListener);
            this.auw.setReloadClickListener(onClickListener);
        }
    }

    public void BQ() {
        com.baidu.swan.apps.core.d.d Aw = com.baidu.swan.apps.w.e.GJ().vN().Aw();
        if (Aw != null && Aw.getView() != null) {
            final View findViewById = Aw.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (Aw.Al().xs() != null && findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.core.i.d.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (d.DEBUG) {
                            Log.d("SwanAppSysWebViewWidget", "onGlobalLayout");
                        }
                        d.this.Y(findViewById);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != this.auq) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.auq = i;
        }
    }
}
