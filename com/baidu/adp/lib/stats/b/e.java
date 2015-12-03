package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ boolean xA;
    private final /* synthetic */ boolean xB;
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xx;
    private final /* synthetic */ boolean xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xx = aVar;
        this.xz = z;
        this.xA = z2;
        this.xB = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xx.g(0L);
            com.baidu.adp.lib.stats.upload.b.in().a(this.xx, this.xz, this.xA, this.xB);
        } else if (this.xx.hT() >= 307200 && this.xx.hX() != "stat") {
            c.a(com.baidu.adp.lib.stats.a.hl().hp(), this.xx.hS(), this.xx);
        }
    }
}
