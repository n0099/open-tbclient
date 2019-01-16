package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements Runnable {
    final /* synthetic */ BdSailorWebView VV;
    final /* synthetic */ BdSailorWebViewClientExt VW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.VW = bdSailorWebViewClientExt;
        this.VV = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.VV.showEmbeddedTitleBar(false);
    }
}
