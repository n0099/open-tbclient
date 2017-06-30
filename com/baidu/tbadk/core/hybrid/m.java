package com.baidu.tbadk.core.hybrid;

import com.baidu.tbadk.core.hybrid.HybridManager;
/* loaded from: classes.dex */
class m extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ String abU;
    private final /* synthetic */ com.baidu.tbadk.core.hybrid.b.b abV;
    final /* synthetic */ l abW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str, com.baidu.tbadk.core.hybrid.b.b bVar) {
        this.abW = lVar;
        this.abU = str;
        this.abV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        com.baidu.adp.widget.a.a aVar2;
        HybridManager hybridManager;
        if ((com.baidu.adp.lib.f.c.fL().a(this.abU, 10, new Object[0]) instanceof com.baidu.adp.widget.a.a) && (aVar2 = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fL().a(this.abU, 10, new Object[0])) != null && aVar2.kS() != null) {
            hybridManager = this.abW.abT;
            new HybridManager.c(aVar2, this.abV).execute(new Void[0]);
        }
    }
}
