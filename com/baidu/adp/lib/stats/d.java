package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class d extends DiskFileOperate {
    final /* synthetic */ c g;
    private final /* synthetic */ f h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, String str, String str2, String str3, String str4, DiskFileOperate.Action action, f fVar) {
        super(str, str2, str3, str4, action);
        this.g = cVar;
        this.h = fVar;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void c(boolean z) {
        if (!this.g.f || this.g.j) {
            h.a().a(this.h);
        }
        this.g.t = 0L;
    }
}
