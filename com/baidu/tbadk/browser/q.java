package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class q extends com.baidu.tbadk.core.c.p {
    final /* synthetic */ TbWebViewActivity MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.n nVar) {
        super(nVar);
        this.MG = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String nT() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.c.q(tZ = false, value = "trackFPS")
    private void trackFPS() {
        this.MG.trackFPS();
    }
}
