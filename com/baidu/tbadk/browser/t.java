package com.baidu.tbadk.browser;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.core.hybrid.w {
    final /* synthetic */ TbWebViewActivity Qm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbWebViewActivity tbWebViewActivity, com.baidu.tbadk.core.hybrid.s sVar) {
        super(sVar);
        this.Qm = tbWebViewActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_COMMON_Performance";
    }

    @com.baidu.tbadk.core.hybrid.x(tN = false, value = "trackFPS")
    private void trackFPS() {
        this.Qm.trackFPS();
    }
}
