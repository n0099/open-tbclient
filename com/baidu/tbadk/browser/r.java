package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.core.d.p {
    final /* synthetic */ TbWebViewActivity Rm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.d.n nVar) {
        super(nVar);
        this.Rm = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String oy() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.d.q(uz = false, value = "trackFPS")
    private void trackFPS() {
        this.Rm.trackFPS();
    }
}
