package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.Disk.ops.d {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xr;
    private final /* synthetic */ boolean xs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, action);
        this.xr = aVar;
        this.xs = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xr.g(fy().length());
            if (this.xs || this.xr.hQ() > 102400) {
                c.c(this.xr, false, false, false);
            }
        }
    }
}
