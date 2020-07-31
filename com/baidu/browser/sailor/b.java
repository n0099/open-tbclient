package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView acZ;
    final /* synthetic */ BdSailorWebViewClientExt ada;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.ada = bdSailorWebViewClientExt;
        this.acZ = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.acZ.showEmbeddedTitleBar(false);
    }
}
