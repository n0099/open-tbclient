package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.core.c.o {
    final /* synthetic */ TbWebViewActivity Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.m mVar) {
        super(mVar);
        this.Kx = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String ne() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.c.p(sC = false, value = "trackFPS")
    private void trackFPS() {
        this.Kx.trackFPS();
    }
}
