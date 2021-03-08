package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView ahk;
    final /* synthetic */ BdSailorWebViewClientExt ahl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.ahl = bdSailorWebViewClientExt;
        this.ahk = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.ahk.showEmbeddedTitleBar(false);
    }
}
