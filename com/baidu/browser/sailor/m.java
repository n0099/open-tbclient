package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements Runnable {
    final /* synthetic */ BdSailorWebView VK;
    final /* synthetic */ BdSailorWebViewClientExt VL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.VL = bdSailorWebViewClientExt;
        this.VK = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.VK.showEmbeddedTitleBar(false);
    }
}
