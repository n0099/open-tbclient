package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView agR;
    final /* synthetic */ BdSailorWebViewClientExt agS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.agS = bdSailorWebViewClientExt;
        this.agR = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.agR.showEmbeddedTitleBar(false);
    }
}
