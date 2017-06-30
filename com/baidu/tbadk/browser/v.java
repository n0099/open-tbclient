package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ u Qn;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h Qo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.Qn = uVar;
        this.Qo = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbWebViewActivity tbWebViewActivity;
        tbWebViewActivity = this.Qn.Qm;
        tbWebViewActivity.mView.a(this.Qo);
    }
}
