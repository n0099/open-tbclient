package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ TbWebViewActivity Qs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbWebViewActivity tbWebViewActivity) {
        this.Qs = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Qs.mView.setFullScreen();
    }
}
