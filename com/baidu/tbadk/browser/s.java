package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r MH;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f MI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.MH = rVar;
        this.MI = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.MH.MG;
        tbWebViewActivity.mView.a(this.MI);
    }
}
