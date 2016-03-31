package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q PI;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f PJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.PI = qVar;
        this.PJ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.PI.PH;
        tbWebViewActivity.mView.a(this.PJ);
    }
}
