package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xs;
    private final /* synthetic */ boolean xu;
    private final /* synthetic */ boolean xv;
    private final /* synthetic */ boolean xw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xs = aVar;
        this.xu = z;
        this.xv = z2;
        this.xw = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xs.g(0L);
            com.baidu.adp.lib.stats.upload.b.im().a(this.xs, this.xu, this.xv, this.xw);
        } else if (this.xs.hS() >= 307200 && this.xs.hW() != "stat") {
            c.a(com.baidu.adp.lib.stats.a.hk().ho(), this.xs.hR(), this.xs);
        }
    }
}
