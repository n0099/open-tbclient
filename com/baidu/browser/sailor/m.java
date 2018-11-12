package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m implements Runnable {
    final /* synthetic */ BdSailorWebView VM;
    final /* synthetic */ BdSailorWebViewClientExt VN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.VN = bdSailorWebViewClientExt;
        this.VM = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.VM.showEmbeddedTitleBar(false);
    }
}
