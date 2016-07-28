package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a oH;
    private final /* synthetic */ boolean oJ;
    private final /* synthetic */ boolean oK;
    private final /* synthetic */ boolean oL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.oH = aVar;
        this.oJ = z;
        this.oK = z2;
        this.oL = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void m(boolean z) {
        super.m(z);
        if (z) {
            this.oH.h(0L);
            com.baidu.adp.lib.stats.upload.b.eO().a(this.oH, this.oJ, this.oK, this.oL);
        } else if (this.oH.ev() >= 307200 && this.oH.ez() != "stat") {
            d.a(com.baidu.adp.lib.stats.a.dN().dR(), this.oH.eu(), this.oH);
        }
    }
}
