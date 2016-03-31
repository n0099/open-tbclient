package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends DiskFileOperate {
    final /* synthetic */ i this$0;
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xZ;
    private final /* synthetic */ boolean yb;
    private final /* synthetic */ boolean yd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        super(str, str2, str3, str4, action);
        this.this$0 = iVar;
        this.xZ = aVar;
        this.yb = z;
        this.yd = z2;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void k(boolean z) {
        super.k(z);
        if (z) {
            this.xZ.h(0L);
            com.baidu.adp.lib.stats.upload.b.iD().a(this.xZ, this.yb, true, this.yd);
        }
    }
}
