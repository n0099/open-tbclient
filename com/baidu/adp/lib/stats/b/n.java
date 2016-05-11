package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a om;
    final /* synthetic */ j this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(j jVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar) {
        super(str, str2, str3, str4, action);
        this.this$0 = jVar;
        this.om = aVar;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void k(boolean z) {
        super.k(z);
        if (z) {
            this.om.h(0L);
        }
    }
}
