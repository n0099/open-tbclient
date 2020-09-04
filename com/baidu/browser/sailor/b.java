package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView aeG;
    final /* synthetic */ BdSailorWebViewClientExt aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.aeH = bdSailorWebViewClientExt;
        this.aeG = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.aeG.showEmbeddedTitleBar(false);
    }
}
