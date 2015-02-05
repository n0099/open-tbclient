package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
class e implements o {
    final /* synthetic */ TbCDNTachometerService BD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbCDNTachometerService tbCDNTachometerService) {
        this.BD = tbCDNTachometerService;
    }

    @Override // com.baidu.tbadk.cdnOptimize.o
    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.BD.startTachometer(gVar);
    }
}
