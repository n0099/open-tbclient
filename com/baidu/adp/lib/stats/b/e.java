package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends DiskFileOperate {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xt;
    private final /* synthetic */ boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, str3, str4, action);
        this.xt = aVar;
        this.xv = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xt.l(0L);
            com.baidu.adp.lib.stats.upload.b.iv().a(this.xt, this.xv);
        } else if (this.xt.ie() >= 307200 && this.xt.ig() != "stat") {
            c.a(com.baidu.adp.lib.h.a.iB().iC(), this.xt.getUploadingLogFile(), this.xt);
        }
    }
}
