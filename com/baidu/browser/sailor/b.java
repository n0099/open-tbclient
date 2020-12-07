package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView agr;
    final /* synthetic */ BdSailorWebViewClientExt ags;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.ags = bdSailorWebViewClientExt;
        this.agr = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.agr.showEmbeddedTitleBar(false);
    }
}
