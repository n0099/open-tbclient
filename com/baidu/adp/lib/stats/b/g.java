package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class g extends com.baidu.adp.lib.Disk.ops.d {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar) {
        super(str, str2, action);
        this.xO = aVar;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void p(boolean z) {
        super.p(z);
        if (z) {
            this.xO.h(dW().length());
        }
    }
}
