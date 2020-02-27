package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView Jb;
    final /* synthetic */ BdSailorWebViewClientExt Jc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.Jc = bdSailorWebViewClientExt;
        this.Jb = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.Jb.showEmbeddedTitleBar(false);
    }
}
