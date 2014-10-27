package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
class d implements i {
    final /* synthetic */ TbCDNTachometerService xS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbCDNTachometerService tbCDNTachometerService) {
        this.xS = tbCDNTachometerService;
    }

    @Override // com.baidu.tbadk.cdnOptimize.i
    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.xS.startTachometer(fVar);
    }
}
