package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c implements Runnable {
    final /* synthetic */ BdSailorWebView adf;
    final /* synthetic */ BdSailorWebViewClientExt adh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.adh = bdSailorWebViewClientExt;
        this.adf = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.adf.showEmbeddedTitleBar(false);
    }
}
