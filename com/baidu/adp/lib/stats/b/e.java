package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.Disk.ops.d {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a qR;
    private final /* synthetic */ boolean qS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, action);
        this.qR = aVar;
        this.qS = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void o(boolean z) {
        super.o(z);
        if (z) {
            this.qR.h(cO().length());
            if (this.qS || this.qR.fo() > 102400) {
                d.c(this.qR, false, false, false);
            }
        }
    }
}
