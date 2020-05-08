package com.baidu.browser.sailor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView ach;
    final /* synthetic */ BdSailorWebViewClientExt aci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.aci = bdSailorWebViewClientExt;
        this.ach = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.ach.showEmbeddedTitleBar(false);
    }
}
