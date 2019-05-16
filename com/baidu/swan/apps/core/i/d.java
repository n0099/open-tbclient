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
    protected com.baidu.swan.apps.core.f.c ati;
    private c atk;
    private b atl;
    protected boolean atm;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.k.d atn;
    private com.baidu.swan.apps.core.e.e ato;
    private int atp;

    public d(Context context) {
        super(context);
        this.atm = true;
        a(new C0138d());
        a(new a());
        aW(context);
    }

    private void aW(Context context) {
        com.baidu.swan.apps.b.b.a wa = com.baidu.swan.apps.ae.e.LH().aQg.get().vy().wa();
        if (wa != null) {
            wa.aF(context);
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
        aVar.aoF = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b
    public void yl() {
        super.yl();
        com.baidu.swan.apps.scheme.actions.k.e eVar = new com.baidu.swan.apps.scheme.actions.k.e(this.aov);
        eVar.c(this);
        this.aov.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.atm && !com.baidu.swan.apps.af.a.b.gN(str)) {
            Bd().Bf();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String wT() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.k.d wV() {
        return this.atn;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.k.d dVar) {
        this.atn = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Bb() {
        if (this.atk == null) {
            this.atk = new c(wS().getContext(), wS());
        }
        return this.atk;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        Bc();
    }

    private void Bc() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b Bd() {
        if (this.atl == null) {
            this.atl = new b(wS().getContext(), wS());
            this.atl.c(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.i.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.wS().getContext()) && com.baidu.swan.apps.af.a.b.gN(d.this.wS().getUrl())) {
                        d.this.wS().reload();
                        d.this.atl.Bg();
                    }
                }
            });
        }
        return this.atl;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.ati = cVar;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.ati = null;
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.swan.apps.core.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0138d extends WebViewClient {
        /* JADX INFO: Access modifiers changed from: protected */
        public C0138d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            d.this.Bb().Bh();
            if (com.baidu.swan.apps.u.a.DE().vO()) {
                d.this.Be();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.Bd().Bf();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.Bb().hideProgressBar();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (d.DEBUG) {
                Log.d("SwanAppSysWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            if (com.baidu.swan.apps.af.a.b.gN(str)) {
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
            if (d.this.ato == null) {
                d.this.ato = new com.baidu.swan.apps.core.e.e(d.this.mContext);
            }
            d.this.ato.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.i.d.a.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void onCustomViewHidden() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.ati != null) {
                d.this.ati.da(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.xa().a(new c.a() { // from class: com.baidu.swan.apps.core.i.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.xa().b(this);
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
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).Ld();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.ato != null) {
            this.ato.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar atw;

        public c(Context context, ViewGroup viewGroup) {
            this.atw = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atw = new EfficientProgressBar(context);
            this.atw.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.atw.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.atw.setVisibility(4);
            this.atw.setFocusable(false);
            this.atw.setClickable(false);
            viewGroup.addView(this.atw);
        }

        public void Bh() {
            this.atw.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.atw.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.atw.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView atv;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.atv = new NetworkErrorView(context);
            this.atv.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.atv, new FrameLayout.LayoutParams(-1, -1));
            this.atv.setVisibility(8);
        }

        public void Bf() {
            this.atv.setVisibility(0);
        }

        public void Bg() {
            this.atv.setVisibility(8);
        }

        public void c(View.OnClickListener onClickListener) {
            this.atv.setOnClickListener(onClickListener);
            this.atv.setReloadClickListener(onClickListener);
        }
    }

    public void Be() {
        com.baidu.swan.apps.core.d.d zL = com.baidu.swan.apps.w.e.FV().vi().zL();
        if (zL != null && zL.getView() != null) {
            final View findViewById = zL.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (zL.zA().wN() != null && findViewById != null) {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.swan.apps.core.i.d.2
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
        if (i != this.atp) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.atp = i;
        }
    }
}
