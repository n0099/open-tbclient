package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xI;
    private final /* synthetic */ boolean xK;
    private final /* synthetic */ boolean xL;
    private final /* synthetic */ boolean xM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xI = aVar;
        this.xK = z;
        this.xL = z2;
        this.xM = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xI.g(0L);
            com.baidu.adp.lib.stats.upload.b.ix().a(this.xI, this.xK, this.xL, this.xM);
        } else if (this.xI.ib() >= 307200 && this.xI.ih() != "stat") {
            c.a(com.baidu.adp.lib.stats.a.ht().hx(), this.xI.ia(), this.xI);
        }
    }
}
