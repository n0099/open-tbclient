package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class c implements Runnable {
    final /* synthetic */ BdSailorWebView acA;
    final /* synthetic */ BdSailorWebViewClientExt acC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.acC = bdSailorWebViewClientExt;
        this.acA = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.acA.showEmbeddedTitleBar(false);
    }
}
