package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView Iw;
    final /* synthetic */ BdSailorWebViewClientExt Ix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.Ix = bdSailorWebViewClientExt;
        this.Iw = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.Iw.showEmbeddedTitleBar(false);
    }
}
