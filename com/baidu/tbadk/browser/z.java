package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbWebViewActivity tbWebViewActivity) {
        this.Qm = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Qm.mView.setFullScreen();
    }
}
