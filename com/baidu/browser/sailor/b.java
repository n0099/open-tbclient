package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView afp;
    final /* synthetic */ BdSailorWebViewClientExt afq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.afq = bdSailorWebViewClientExt;
        this.afp = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.afp.showEmbeddedTitleBar(false);
    }
}
