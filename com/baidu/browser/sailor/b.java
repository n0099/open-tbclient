package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView ace;
    final /* synthetic */ BdSailorWebViewClientExt acf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.acf = bdSailorWebViewClientExt;
        this.ace = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.ace.showEmbeddedTitleBar(false);
    }
}
