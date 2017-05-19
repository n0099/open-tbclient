package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xS;
    private final /* synthetic */ boolean xU;
    private final /* synthetic */ boolean xV;
    private final /* synthetic */ boolean xW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.xS = aVar;
        this.xU = z;
        this.xV = z2;
        this.xW = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void p(boolean z) {
        super.p(z);
        if (z) {
            this.xS.h(0L);
            com.baidu.adp.lib.stats.upload.b.gI().a(this.xS, this.xU, this.xV, this.xW);
        } else if (this.xS.gp() >= 307200 && this.xS.gt() != "stat") {
            d.a(BdStatisticsManager.getInstance().getWriteDir(), this.xS.go(), this.xS);
        }
    }
}
