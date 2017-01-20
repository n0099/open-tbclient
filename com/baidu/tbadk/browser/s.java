package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r LS;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f LT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.LS = rVar;
        this.LT = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.LS.LR;
        tbWebViewActivity.mView.a(this.LT);
    }
}
