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
    protected com.baidu.swan.apps.core.f.c aNi;
    private c aNk;
    private b aNl;
    protected boolean aNm;
    @Nullable
    private com.baidu.swan.apps.scheme.actions.k.d aNn;
    private com.baidu.swan.apps.core.e.e aNo;
    private int aNp;

    public d(Context context) {
        super(context);
        this.aNm = true;
        a(new C0181d());
        a(new a());
        aY(context);
    }

    private void aY(Context context) {
        com.baidu.swan.apps.b.b.a BA = com.baidu.swan.apps.ae.e.Rt().bka.get().AY().BA();
        if (BA != null) {
            BA.aH(context);
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
        aVar.aIF = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b
    public void DQ() {
        super.DQ();
        com.baidu.swan.apps.scheme.actions.k.e eVar = new com.baidu.swan.apps.scheme.actions.k.e(this.aIv);
        eVar.c(this);
        this.aIv.a(eVar);
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        if (this.aNm && !com.baidu.swan.apps.af.a.b.hz(str)) {
            GK().GM();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public String Ct() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.b.c.f
    @Nullable
    public com.baidu.swan.apps.scheme.actions.k.d Cv() {
        return this.aNn;
    }

    public void d(@Nullable com.baidu.swan.apps.scheme.actions.k.d dVar) {
        this.aNn = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c GI() {
        if (this.aNk == null) {
            this.aNk = new c(Cs().getContext(), Cs());
        }
        return this.aNk;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void onPause() {
        super.onPause();
        GJ();
    }

    private void GJ() {
        loadJavaScript("document.querySelector('video').pause();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b GK() {
        if (this.aNl == null) {
            this.aNl = new b(Cs().getContext(), Cs());
            this.aNl.d(new View.OnClickListener() { // from class: com.baidu.swan.apps.core.i.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (SwanAppNetworkUtils.isNetworkConnected(d.this.Cs().getContext()) && com.baidu.swan.apps.af.a.b.hz(d.this.Cs().getUrl())) {
                        d.this.Cs().reload();
                        d.this.aNl.GN();
                    }
                }
            });
        }
        return this.aNl;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.b.c.c
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        this.aNi = cVar;
    }

    @Override // com.baidu.swan.apps.core.i.c, com.baidu.swan.apps.core.b, com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.aNi = null;
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
            d.this.GI().GO();
            if (com.baidu.swan.apps.u.a.Jm().Bo()) {
                d.this.GL();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (i != -10) {
                d.this.GK().GM();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            d.this.GI().hideProgressBar();
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
            if (d.this.aNo == null) {
                d.this.aNo = new com.baidu.swan.apps.core.e.e(d.this.mContext);
            }
            d.this.aNo.a(view, i, new e.a() { // from class: com.baidu.swan.apps.core.i.d.a.1
                @Override // com.baidu.swan.apps.core.e.e.a
                public void FY() {
                    customViewCallback.onCustomViewHidden();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (d.this.aNi != null) {
                d.this.aNi.dc(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            com.baidu.swan.apps.b.c.a.c.CA().a(new c.a() { // from class: com.baidu.swan.apps.core.i.d.a.2
                @Override // com.baidu.swan.apps.b.c.a.c.a
                public void a(Activity activity, int i, int i2, Intent intent) {
                    if (i == 200) {
                        com.baidu.swan.apps.b.c.a.c.CA().b(this);
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
                com.baidu.swan.apps.res.widget.b.d.a(webView.getContext(), webView.getResources().getText(a.h.swan_webview_show_file_chooser_failed)).QO();
                return false;
            }
        }
    }

    public void hideCustomView() {
        if (this.aNo != null) {
            this.aNo.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        private EfficientProgressBar aNw;

        public c(Context context, ViewGroup viewGroup) {
            this.aNw = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.aNw = new EfficientProgressBar(context);
            this.aNw.setProgressDrawable(context.getResources().getDrawable(a.e.aiapps_progress_thumb));
            this.aNw.setId(a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.aNw.setVisibility(4);
            this.aNw.setFocusable(false);
            this.aNw.setClickable(false);
            viewGroup.addView(this.aNw);
        }

        public void GO() {
            this.aNw.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.aNw.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.aNw.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private NetworkErrorView aNv;

        public b(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.aNv = new NetworkErrorView(context);
            this.aNv.setBackgroundColor(context.getResources().getColor(a.c.aiapps_white));
            viewGroup.addView(this.aNv, new FrameLayout.LayoutParams(-1, -1));
            this.aNv.setVisibility(8);
        }

        public void GM() {
            this.aNv.setVisibility(0);
        }

        public void GN() {
            this.aNv.setVisibility(8);
        }

        public void d(View.OnClickListener onClickListener) {
            this.aNv.setOnClickListener(onClickListener);
            this.aNv.setReloadClickListener(onClickListener);
        }
    }

    public void GL() {
        com.baidu.swan.apps.core.d.d Fs = com.baidu.swan.apps.w.e.LE().AI().Fs();
        if (Fs != null && Fs.getView() != null) {
            final View findViewById = Fs.getView().findViewById(a.f.ai_apps_fragment_base_view);
            if (Fs.Fh().Cn() != null && findViewById != null) {
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
        if (i != this.aNp) {
            view.getLayoutParams().height = i;
            view.requestLayout();
            this.aNp = i;
        }
    }
}
