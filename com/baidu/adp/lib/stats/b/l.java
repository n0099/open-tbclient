package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends DiskFileOperate {
    final /* synthetic */ i this$0;
    private final /* synthetic */ boolean xB;
    private final /* synthetic */ boolean xD;
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        super(str, str2, str3, str4, action);
        this.this$0 = iVar;
        this.xz = aVar;
        this.xB = z;
        this.xD = z2;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xz.h(0L);
            com.baidu.adp.lib.stats.upload.b.in().a(this.xz, this.xB, true, this.xD);
        }
    }
}
