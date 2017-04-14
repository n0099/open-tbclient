package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ TbWebViewActivity Rm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbWebViewActivity tbWebViewActivity) {
        this.Rm = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Rm.mView.setFullScreen();
    }
}
