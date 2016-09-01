package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s MJ;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f MK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.MJ = sVar;
        this.MK = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.MJ.MI;
        tbWebViewActivity.mView.a(this.MK);
    }
}
