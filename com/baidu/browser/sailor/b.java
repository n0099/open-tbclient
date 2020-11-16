package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView afv;
    final /* synthetic */ BdSailorWebViewClientExt afw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.afw = bdSailorWebViewClientExt;
        this.afv = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.afv.showEmbeddedTitleBar(false);
    }
}
