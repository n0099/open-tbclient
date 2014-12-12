package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
class e implements o {
    final /* synthetic */ TbCDNTachometerService BG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbCDNTachometerService tbCDNTachometerService) {
        this.BG = tbCDNTachometerService;
    }

    @Override // com.baidu.tbadk.cdnOptimize.o
    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BG.startTachometer(gVar);
    }
}
