package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BaseWebViewActivity Nn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseWebViewActivity baseWebViewActivity) {
        this.Nn = baseWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Nn.refresh();
    }
}
