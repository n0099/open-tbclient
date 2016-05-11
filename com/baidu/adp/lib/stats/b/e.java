package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.Disk.ops.d {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a ob;
    private final /* synthetic */ boolean oc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, action);
        this.ob = aVar;
        this.oc = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void k(boolean z) {
        super.k(z);
        if (z) {
            this.ob.g(bV().length());
            if (this.oc || this.ob.ev() > 102400) {
                d.c(this.ob, false, false, false);
            }
        }
    }
}
