package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a oR;
    final /* synthetic */ j this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(j jVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar) {
        super(str, str2, str3, str4, action);
        this.this$0 = jVar;
        this.oR = aVar;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void m(boolean z) {
        super.m(z);
        if (z) {
            this.oR.i(0L);
        }
    }
}
