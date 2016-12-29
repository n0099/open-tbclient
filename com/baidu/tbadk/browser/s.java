package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r MF;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.MF = rVar;
        this.MG = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.MF.ME;
        tbWebViewActivity.mView.a(this.MG);
    }
}
