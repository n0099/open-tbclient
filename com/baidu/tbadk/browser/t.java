package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s Rp;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h Rq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.Rp = sVar;
        this.Rq = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.Rp.Ro;
        tbWebViewActivity.mView.a(this.Rq);
    }
}
