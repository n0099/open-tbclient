package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.Disk.ops.d {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xZ;
    private final /* synthetic */ boolean ya;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, action);
        this.xZ = aVar;
        this.ya = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void k(boolean z) {
        super.k(z);
        if (z) {
            this.xZ.g(fH().length());
            if (this.ya || this.xZ.ij() > 102400) {
                c.c(this.xZ, false, false, false);
            }
        }
    }
}
