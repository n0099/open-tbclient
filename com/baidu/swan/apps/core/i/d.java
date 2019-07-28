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
    protected com.baidu.swan.apps.core.f.c atL;
    private c atN;
    private b atO;
    protected boolean atP;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.k.d atQ;
    private com.baidu.swan.apps.core.e.e atR;
    private int atS;

    public d(Context context) {
        super(context);
        this.atP = true;
        a(new C0140d());
        a(new a());
        aW(context);
    }

    private void aW(Context context) {
        com.baidu.swan.apps.b.b.a wB = com.baidu.swan.apps.ae.e.Mv().aQQ.get().vZ().wB();
        if (wB != null) {
            wB.aF(context);
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
        aVar.api = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b
    public void yQ() {
        super.yQ();
        com.baidu.swan.apps.scheme.actions.k.e eVar = new com.baidu.swan.apps.scheme.actions.k.e(this.aoY);
        eVar.c(this);
        this.aoY.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.atP && !com.baidu.swan.apps.af.a.b.gT(str)) {
            BL().BN();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String xu() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.k.d xw() {
        return this.atQ;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.k.d dVar) {
        this.atQ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c BJ() {
        if (this.atN == null) {
            this.atN = new c(xt().getContext(), xt());
        }
        return this.atN;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        BK();
    }

    private void BK() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b BL() {
        if (this.atO == null) {
            this.atO = new b(xt().getContext(), xt());
            this.atO.c(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.i.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.xt().getContext()) && com.baidu.swan.apps.af.a.b.gT(d.this.xt().getUrl())) {
                        d.this.xt().reload();
                        d.this.atO.BO();
                    }
                }
            });
        }
        return this.atO;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.atL = cVar;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.atL = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.swan.apps.core.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0140d extends WebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public C0140d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            d.this.BJ().BP();
            if (com.baidu.swan.apps.u.a.En().wp()) {
                d.this.BM();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.BL().BN();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.BJ().hideProgressBar();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (d.DEBUG) {
                Log.d("SwanAppSysWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (com.baidu.swan.apps.af.a.b.gT(str)) {
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
            if (d.this.atR == null) {
                d.this.atR = new com.baidu.swan.apps.core.e.e(d.this.mContext);
            }
            d.this.atR.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.i.d.a.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void AY() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.atL != null) {
                d.this.atL.de(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.xB().a(new c.a() { // from class: com.baidu.swan.apps.core.i.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.xB().b(this);
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
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).LQ();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.atR != null) {
            this.atR.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar atZ;

        public c(Context context, ViewGroup viewGroup) {
            this.atZ = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atZ = new EfficientProgressBar(context);
            this.atZ.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.atZ.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.atZ.setVisibility(4);
            this.atZ.setFocusable(false);
            this.atZ.setClickable(false);
            viewGroup.addView(this.atZ);
        }

        public void BP() {
            this.atZ.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.atZ.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.atZ.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView atY;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atY = new NetworkErrorView(context);
            this.atY.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.atY, new FrameLayout.LayoutParams(-1, -1));
            this.atY.setVisibility(8);
        }

        public void BN() {
            this.atY.setVisibility(0);
        }

        public void BO() {
            this.atY.setVisibility(8);
        }

        public void c(View.OnClickListener onClickListener) {
            this.atY.setOnClickListener(onClickListener);
            this.atY.setReloadClickListener(onClickListener);
        }
    }

    public void BM() {
        com.baidu.swan.apps.core.d.d As = com.baidu.swan.apps.w.e.GF().vJ().As();
        if (As != null && As.getView() != null) {
            final View findViewById = As.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (As.Ah().xo() != null && findViewById != null) {
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
        if (i != this.atS) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.atS = i;
        }
    }
}
