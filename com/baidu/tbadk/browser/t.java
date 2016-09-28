package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s MI;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f MJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.MI = sVar;
        this.MJ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.MI.MH;
        tbWebViewActivity.mView.a(this.MJ);
    }
}
