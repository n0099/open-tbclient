package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s QG;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h QH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.QG = sVar;
        this.QH = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.QG.QF;
        tbWebViewActivity.mView.a(this.QH);
    }
}
