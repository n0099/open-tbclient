package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class q extends com.baidu.tbadk.core.d.p {
    final /* synthetic */ TbWebViewActivity LR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.d.n nVar) {
        super(nVar);
        this.LR = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String nN() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.d.q(tE = false, value = "trackFPS")
    private void trackFPS() {
        this.LR.trackFPS();
    }
}
