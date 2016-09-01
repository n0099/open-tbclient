package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.Disk.ops.d {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a qY;
    private final /* synthetic */ boolean qZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, action);
        this.qY = aVar;
        this.qZ = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void o(boolean z) {
        super.o(z);
        if (z) {
            this.qY.h(cQ().length());
            if (this.qZ || this.qY.fq() > 102400) {
                d.c(this.qY, false, false, false);
            }
        }
    }
}
