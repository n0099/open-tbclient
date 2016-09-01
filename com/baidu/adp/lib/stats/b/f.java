package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a qY;
    private final /* synthetic */ boolean ra;
    private final /* synthetic */ boolean rb;
    private final /* synthetic */ boolean rc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.qY = aVar;
        this.ra = z;
        this.rb = z2;
        this.rc = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void o(boolean z) {
        super.o(z);
        if (z) {
            this.qY.h(0L);
            com.baidu.adp.lib.stats.upload.b.fJ().a(this.qY, this.ra, this.rb, this.rc);
        } else if (this.qY.fq() >= 307200 && this.qY.fu() != "stat") {
            d.a(com.baidu.adp.lib.stats.a.eI().eM(), this.qY.fp(), this.qY);
        }
    }
}
