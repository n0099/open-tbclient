package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.core.c.p {
    final /* synthetic */ TbWebViewActivity Kw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.n nVar) {
        super(nVar);
        this.Kw = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String mU() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.c.q(sB = false, value = "trackFPS")
    private void trackFPS() {
        this.Kw.trackFPS();
    }
}
