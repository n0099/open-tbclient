package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a qZ;
    private final /* synthetic */ boolean rb;
    private final /* synthetic */ boolean rd;
    final /* synthetic */ j this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        super(str, str2, str3, str4, action);
        this.this$0 = jVar;
        this.qZ = aVar;
        this.rb = z;
        this.rd = z2;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void o(boolean z) {
        super.o(z);
        if (z) {
            this.qZ.i(0L);
            com.baidu.adp.lib.stats.upload.b.fJ().a(this.qZ, this.rb, true, this.rd);
        }
    }
}
