package com.baidu.tbadk.cdnOptimize;
/* loaded from: classes.dex */
class d implements i {
    final /* synthetic */ TbCDNTachometerService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbCDNTachometerService tbCDNTachometerService) {
        this.a = tbCDNTachometerService;
    }

    @Override // com.baidu.tbadk.cdnOptimize.i
    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.a.startTachometer(fVar);
    }
}
