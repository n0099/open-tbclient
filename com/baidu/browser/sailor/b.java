package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView IB;
    final /* synthetic */ BdSailorWebViewClientExt IC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.IC = bdSailorWebViewClientExt;
        this.IB = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.IB.showEmbeddedTitleBar(false);
    }
}
