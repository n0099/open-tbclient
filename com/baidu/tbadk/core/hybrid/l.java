package com.baidu.tbadk.core.hybrid;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ HybridManager abT;
    private final /* synthetic */ String abU;
    private final /* synthetic */ com.baidu.tbadk.core.hybrid.b.b abV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HybridManager hybridManager, String str, com.baidu.tbadk.core.hybrid.b.b bVar) {
        this.abT = hybridManager;
        this.abU = str;
        this.abV = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.f.c.fL().a(this.abU, 10, new m(this, this.abU, this.abV), 0, 0, null, new Object[0]);
    }
}
