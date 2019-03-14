package com.baidu.swan.apps.core.h;

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
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.core.h.c implements f<SystemWebViewImpl> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.core.e.c asP;
    private c asR;
    private b asS;
    protected boolean asT;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.j.d asU;
    private com.baidu.swan.apps.core.d.e asV;
    private int asW;

    public d(Context context) {
        super(context);
        this.asT = true;
        a(new C0135d());
        a(new a());
        bD(context);
    }

    private void bD(Context context) {
        com.baidu.swan.apps.b.b.a uU = com.baidu.swan.apps.ae.e.Jo().aNZ.get().uP().uU();
        if (uU != null) {
            uU.bm(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.b
    public void a(Context context, com.baidu.swan.apps.b.c.e eVar) {
        super.a(context, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.aoo = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b
    public void xu() {
        super.xu();
        com.baidu.swan.apps.scheme.actions.j.e eVar = new com.baidu.swan.apps.scheme.actions.j.e(this.aoe);
        eVar.c(this);
        this.aoe.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.asT && !com.baidu.swan.apps.af.a.b.gr(str)) {
            zV().zY();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String wd() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.j.d wf() {
        return this.asU;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.j.d dVar) {
        this.asU = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c zT() {
        if (this.asR == null) {
            this.asR = new c(wc().getContext(), wc());
        }
        return this.asR;
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        zU();
    }

    private void zU() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b zV() {
        if (this.asS == null) {
            this.asS = new b(wc().getContext(), wc());
            this.asS.c(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.wc().getContext()) && com.baidu.swan.apps.af.a.b.gr(d.this.wc().getUrl())) {
                        d.this.wc().reload();
                        d.this.asS.zZ();
                    }
                }
            });
        }
        return this.asS;
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.e.c cVar) {
        this.asP = cVar;
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.asP = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.swan.apps.core.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0135d extends WebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public C0135d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            d.this.zT().Aa();
            if (com.baidu.swan.apps.u.a.CB().vn()) {
                d.this.zW();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.zV().zY();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.zT().hideProgressBar();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (d.DEBUG) {
                Log.d("SwanAppSysWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (com.baidu.swan.apps.af.a.b.gr(str)) {
                return e.ad(webView.getContext(), str);
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
            if (d.this.asV == null) {
                d.this.asV = new com.baidu.swan.apps.core.d.e(d.this.mContext);
            }
            d.this.asV.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.h.d.a.1
                @Override // com.baidu.swan.apps.core.d.e.a
                public void onCustomViewHidden() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.asP != null) {
                d.this.asP.dl(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.wk().a(new c.a() { // from class: com.baidu.swan.apps.core.h.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.wk().b(this);
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
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).IK();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.asV != null) {
            this.asV.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar atd;

        public c(Context context, ViewGroup viewGroup) {
            this.atd = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atd = new EfficientProgressBar(context);
            this.atd.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.atd.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.atd.setVisibility(4);
            this.atd.setFocusable(false);
            this.atd.setClickable(false);
            viewGroup.addView(this.atd);
        }

        public void Aa() {
            this.atd.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.atd.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.atd.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView atc;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atc = new NetworkErrorView(context);
            this.atc.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.atc, new FrameLayout.LayoutParams(-1, -1));
            this.atc.setVisibility(8);
        }

        public void zY() {
            this.atc.setVisibility(0);
        }

        public void zZ() {
            this.atc.setVisibility(8);
        }

        public void c(View.OnClickListener onClickListener) {
            this.atc.setOnClickListener(onClickListener);
            this.atc.setReloadClickListener(onClickListener);
        }
    }

    public void zW() {
        com.baidu.swan.apps.core.c.d yP = com.baidu.swan.apps.w.e.Ec().uz().yP();
        if (yP != null && yP.getView() != null) {
            final View findViewById = yP.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (yP.yG().vX() != null && findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.core.h.d.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (d.DEBUG) {
                            Log.d("SwanAppSysWebViewWidget", "onGlobalLayout");
                        }
                        d.this.W(findViewById);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != this.asW) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.asW = i;
        }
    }
}
