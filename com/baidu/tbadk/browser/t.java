package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s Rn;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.g Ro;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.g gVar) {
        this.Rn = sVar;
        this.Ro = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.Rn.Rm;
        tbWebViewActivity.mView.a(this.Ro);
    }
}
