package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView afR;
    final /* synthetic */ BdSailorWebViewClientExt afS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.afS = bdSailorWebViewClientExt;
        this.afR = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.afR.showEmbeddedTitleBar(false);
    }
}
