package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class s extends com.baidu.tbadk.core.c.o {
    final /* synthetic */ TbWebViewActivity PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.c.m mVar) {
        super(mVar);
        this.PH = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String pT() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.c.p(uY = false, value = "trackFPS")
    private void trackFPS() {
        this.PH.trackFPS();
    }
}
