package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a yn;
    private final /* synthetic */ boolean yp;
    private final /* synthetic */ boolean yq;
    private final /* synthetic */ boolean yr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        super(str, str2, str3, str4, action);
        this.yn = aVar;
        this.yp = z;
        this.yq = z2;
        this.yr = z3;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void p(boolean z) {
        super.p(z);
        if (z) {
            this.yn.h(0L);
            com.baidu.adp.lib.stats.upload.b.gC().a(this.yn, this.yp, this.yq, this.yr);
        } else if (this.yn.gj() >= 307200 && this.yn.gn() != "stat") {
            d.a(BdStatisticsManager.getInstance().getWriteDir(), this.yn.gi(), this.yn);
        }
    }
}
