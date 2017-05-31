package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s Qt;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h Qu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.Qt = sVar;
        this.Qu = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.Qt.Qs;
        tbWebViewActivity.mView.a(this.Qu);
    }
}
