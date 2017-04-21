package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ TbWebViewActivity Ro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbWebViewActivity tbWebViewActivity) {
        this.Ro = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ro.mView.setFullScreen();
    }
}
