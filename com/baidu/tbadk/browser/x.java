package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ TbWebViewActivity QF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TbWebViewActivity tbWebViewActivity) {
        this.QF = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.QF.mView.setFullScreen();
    }
}
