package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a qR;
    private final /* synthetic */ boolean qT;
    private final /* synthetic */ boolean qU;
    private final /* synthetic */ boolean qV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.qR = aVar;
        this.qT = z;
        this.qU = z2;
        this.qV = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void o(boolean z) {
        super.o(z);
        if (z) {
            this.qR.h(0L);
            com.baidu.adp.lib.stats.upload.b.fH().a(this.qR, this.qT, this.qU, this.qV);
        } else if (this.qR.fo() >= 307200 && this.qR.fs() != "stat") {
            d.a(com.baidu.adp.lib.stats.a.eG().eK(), this.qR.fn(), this.qR);
        }
    }
}
