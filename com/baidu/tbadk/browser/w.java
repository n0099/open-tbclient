package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ TbWebViewActivity MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbWebViewActivity tbWebViewActivity) {
        this.MG = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.MG.mView.setFullScreen();
    }
}
