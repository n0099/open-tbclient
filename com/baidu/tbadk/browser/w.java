package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ TbWebViewActivity QU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbWebViewActivity tbWebViewActivity) {
        this.QU = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.QU.mView.setFullScreen();
    }
}
