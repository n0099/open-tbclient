package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.core.c.p {
    final /* synthetic */ TbWebViewActivity MH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.n nVar) {
        super(nVar);
        this.MH = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String nP() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.c.q(tV = false, value = "trackFPS")
    private void trackFPS() {
        this.MH.trackFPS();
    }
}
