package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xO;
    private final /* synthetic */ boolean xQ;
    private final /* synthetic */ boolean xR;
    private final /* synthetic */ boolean xS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xO = aVar;
        this.xQ = z;
        this.xR = z2;
        this.xS = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void p(boolean z) {
        super.p(z);
        if (z) {
            this.xO.h(0L);
            com.baidu.adp.lib.stats.upload.b.gH().a(this.xO, this.xQ, this.xR, this.xS);
        } else if (this.xO.go() >= 307200 && this.xO.gs() != "stat") {
            d.a(BdStatisticsManager.getInstance().getWriteDir(), this.xO.gn(), this.xO);
        }
    }
}
