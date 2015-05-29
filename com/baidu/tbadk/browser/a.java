package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BaseWebViewActivity NB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaseWebViewActivity baseWebViewActivity) {
        this.NB = baseWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.NB.refresh();
    }
}
