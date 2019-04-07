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
    protected com.baidu.swan.apps.core.e.c asT;
    private c asV;
    private b asW;
    protected boolean asX;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.j.d asY;
    private com.baidu.swan.apps.core.d.e asZ;
    private int ata;

    public d(Context context) {
        super(context);
        this.asX = true;
        a(new C0135d());
        a(new a());
        bD(context);
    }

    private void bD(Context context) {
        com.baidu.swan.apps.b.b.a uT = com.baidu.swan.apps.ae.e.Jm().aOc.get().uO().uT();
        if (uT != null) {
            uT.bm(context);
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
        aVar.aos = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b
    public void xt() {
        super.xt();
        com.baidu.swan.apps.scheme.actions.j.e eVar = new com.baidu.swan.apps.scheme.actions.j.e(this.aoi);
        eVar.c(this);
        this.aoi.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.asX && !com.baidu.swan.apps.af.a.b.gt(str)) {
            zU().zX();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String wc() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.j.d we() {
        return this.asY;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.j.d dVar) {
        this.asY = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c zS() {
        if (this.asV == null) {
            this.asV = new c(wb().getContext(), wb());
        }
        return this.asV;
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        zT();
    }

    private void zT() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b zU() {
        if (this.asW == null) {
            this.asW = new b(wb().getContext(), wb());
            this.asW.c(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.h.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.wb().getContext()) && com.baidu.swan.apps.af.a.b.gt(d.this.wb().getUrl())) {
                        d.this.wb().reload();
                        d.this.asW.zY();
                    }
                }
            });
        }
        return this.asW;
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.e.c cVar) {
        this.asT = cVar;
    }

    @Override // com.baidu.swan.apps.core.h.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.asT = null;
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
            d.this.zS().zZ();
            if (com.baidu.swan.apps.u.a.Cz().vm()) {
                d.this.zV();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.zU().zX();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.zS().hideProgressBar();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (d.DEBUG) {
                Log.d("SwanAppSysWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (com.baidu.swan.apps.af.a.b.gt(str)) {
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
            if (d.this.asZ == null) {
                d.this.asZ = new com.baidu.swan.apps.core.d.e(d.this.mContext);
            }
            d.this.asZ.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.h.d.a.1
                @Override // com.baidu.swan.apps.core.d.e.a
                public void onCustomViewHidden() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.asT != null) {
                d.this.asT.dn(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.wj().a(new c.a() { // from class: com.baidu.swan.apps.core.h.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.wj().b(this);
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
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).II();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.asZ != null) {
            this.asZ.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar ath;

        public c(Context context, ViewGroup viewGroup) {
            this.ath = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.ath = new EfficientProgressBar(context);
            this.ath.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.ath.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.ath.setVisibility(4);
            this.ath.setFocusable(false);
            this.ath.setClickable(false);
            viewGroup.addView(this.ath);
        }

        public void zZ() {
            this.ath.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.ath.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.ath.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView atg;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atg = new NetworkErrorView(context);
            this.atg.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.atg, new FrameLayout.LayoutParams(-1, -1));
            this.atg.setVisibility(8);
        }

        public void zX() {
            this.atg.setVisibility(0);
        }

        public void zY() {
            this.atg.setVisibility(8);
        }

        public void c(View.OnClickListener onClickListener) {
            this.atg.setOnClickListener(onClickListener);
            this.atg.setReloadClickListener(onClickListener);
        }
    }

    public void zV() {
        com.baidu.swan.apps.core.c.d yO = com.baidu.swan.apps.w.e.Ea().uy().yO();
        if (yO != null && yO.getView() != null) {
            final View findViewById = yO.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (yO.yF().vW() != null && findViewById != null) {
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
        if (i != this.ata) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.ata = i;
        }
    }
}
