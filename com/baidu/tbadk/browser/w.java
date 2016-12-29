package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ TbWebViewActivity ME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TbWebViewActivity tbWebViewActivity) {
        this.ME = tbWebViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ME.mView.setFullScreen();
    }
}
