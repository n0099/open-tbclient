package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r QV;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.g QW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.baidu.tbadk.coreExtra.share.g gVar) {
        this.QV = rVar;
        this.QW = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.QV.QU;
        tbWebViewActivity.mView.a(this.QW);
    }
}
