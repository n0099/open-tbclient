package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xR;
    private final /* synthetic */ boolean xT;
    private final /* synthetic */ boolean xU;
    private final /* synthetic */ boolean xV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xR = aVar;
        this.xT = z;
        this.xU = z2;
        this.xV = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void p(boolean z) {
        super.p(z);
        if (z) {
            this.xR.h(0L);
            com.baidu.adp.lib.stats.upload.b.gI().a(this.xR, this.xT, this.xU, this.xV);
        } else if (this.xR.gp() >= 307200 && this.xR.gt() != "stat") {
            d.a(BdStatisticsManager.getInstance().getWriteDir(), this.xR.go(), this.xR);
        }
    }
}
