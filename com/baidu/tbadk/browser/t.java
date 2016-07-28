package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s Kx;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f Ky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.Kx = sVar;
        this.Ky = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.Kx.Kw;
        tbWebViewActivity.mView.a(this.Ky);
    }
}
