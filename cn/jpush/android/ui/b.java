package cn.jpush.android.ui;

import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    final /* synthetic */ FullScreenView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FullScreenView fullScreenView) {
        this.a = fullScreenView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        WebView webView2;
        webView = this.a.mWebView;
        if (webView != null) {
            webView2 = this.a.mWebView;
            webView2.clearHistory();
        }
    }
}
