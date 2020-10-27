package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView afq;
    final /* synthetic */ BdSailorWebViewClientExt afr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.afr = bdSailorWebViewClientExt;
        this.afq = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.afq.showEmbeddedTitleBar(false);
    }
}
