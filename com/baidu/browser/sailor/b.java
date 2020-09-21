package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView aeY;
    final /* synthetic */ BdSailorWebViewClientExt aeZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.aeZ = bdSailorWebViewClientExt;
        this.aeY = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.aeY.showEmbeddedTitleBar(false);
    }
}
