package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends DiskFileOperate {
    final /* synthetic */ j this$0;
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xO;
    private final /* synthetic */ boolean xQ;
    private final /* synthetic */ boolean xS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2) {
        super(str, str2, str3, str4, action);
        this.this$0 = jVar;
        this.xO = aVar;
        this.xQ = z;
        this.xS = z2;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void p(boolean z) {
        super.p(z);
        if (z) {
            this.xO.i(0L);
            com.baidu.adp.lib.stats.upload.b.gH().a(this.xO, this.xQ, true, this.xS);
        }
    }
}
