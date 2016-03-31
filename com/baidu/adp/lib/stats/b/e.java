package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xZ;
    private final /* synthetic */ boolean yb;
    private final /* synthetic */ boolean yc;
    private final /* synthetic */ boolean yd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xZ = aVar;
        this.yb = z;
        this.yc = z2;
        this.yd = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void k(boolean z) {
        super.k(z);
        if (z) {
            this.xZ.g(0L);
            com.baidu.adp.lib.stats.upload.b.iD().a(this.xZ, this.yb, this.yc, this.yd);
        } else if (this.xZ.ij() >= 307200 && this.xZ.io() != "stat") {
            c.a(com.baidu.adp.lib.stats.a.hz().hD(), this.xZ.ii(), this.xZ);
        }
    }
}
