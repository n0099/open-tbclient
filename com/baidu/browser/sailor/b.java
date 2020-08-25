package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView aeE;
    final /* synthetic */ BdSailorWebViewClientExt aeF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.aeF = bdSailorWebViewClientExt;
        this.aeE = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.aeE.showEmbeddedTitleBar(false);
    }
}
