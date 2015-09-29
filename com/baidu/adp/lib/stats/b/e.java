package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xr;
    private final /* synthetic */ boolean xt;
    private final /* synthetic */ boolean xu;
    private final /* synthetic */ boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xr = aVar;
        this.xt = z;
        this.xu = z2;
        this.xv = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xr.i(0L);
            com.baidu.adp.lib.stats.upload.b.ik().a(this.xr, this.xt, this.xu, this.xv);
        } else if (this.xr.hQ() >= 307200 && this.xr.hU() != "stat") {
            c.a(com.baidu.adp.lib.stats.a.hi().hm(), this.xr.hP(), this.xr);
        }
    }
}
