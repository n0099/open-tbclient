package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xq;
    private final /* synthetic */ boolean xs;
    private final /* synthetic */ boolean xt;
    private final /* synthetic */ boolean xu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xq = aVar;
        this.xs = z;
        this.xt = z2;
        this.xu = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xq.g(0L);
            com.baidu.adp.lib.stats.upload.b.ij().a(this.xq, this.xs, this.xt, this.xu);
        } else if (this.xq.hP() >= 307200 && this.xq.hT() != "stat") {
            c.a(com.baidu.adp.lib.stats.a.hh().hl(), this.xq.hO(), this.xq);
        }
    }
}
