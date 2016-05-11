package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s Ky;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f Kz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.Ky = sVar;
        this.Kz = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.Ky.Kx;
        tbWebViewActivity.mView.a(this.Kz);
    }
}
