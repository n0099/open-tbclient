package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.core.d.p {
    final /* synthetic */ TbWebViewActivity QF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.d.n nVar) {
        super(nVar);
        this.QF = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String of() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.d.q(tL = false, value = "trackFPS")
    private void trackFPS() {
        this.QF.trackFPS();
    }
}
