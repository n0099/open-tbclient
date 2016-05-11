package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a ob;
    private final /* synthetic */ boolean od;
    private final /* synthetic */ boolean oe;
    private final /* synthetic */ boolean of;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.ob = aVar;
        this.od = z;
        this.oe = z2;
        this.of = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void k(boolean z) {
        super.k(z);
        if (z) {
            this.ob.g(0L);
            com.baidu.adp.lib.stats.upload.b.eO().a(this.ob, this.od, this.oe, this.of);
        } else if (this.ob.ev() >= 307200 && this.ob.ez() != "stat") {
            d.a(com.baidu.adp.lib.stats.a.dN().dR(), this.ob.eu(), this.ob);
        }
    }
}
