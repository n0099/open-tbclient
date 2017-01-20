package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ TbWebViewActivity LR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbWebViewActivity tbWebViewActivity) {
        this.LR = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.LR.mView.setFullScreen();
    }
}
