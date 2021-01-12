package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView afZ;
    final /* synthetic */ BdSailorWebViewClientExt aga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.aga = bdSailorWebViewClientExt;
        this.afZ = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.afZ.showEmbeddedTitleBar(false);
    }
}
