package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ c g;
    private final /* synthetic */ f h;
    private final /* synthetic */ boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, String str, String str2, DiskFileOperate.Action action, f fVar, boolean z) {
        super(str, str2, action);
        this.g = cVar;
        this.h = fVar;
        this.i = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void c(boolean z) {
        long j;
        long j2;
        super.c(z);
        if (z && n() != null) {
            j = this.g.t;
            if (j == 0) {
                this.g.t = n().length();
            }
            c cVar = this.g;
            j2 = cVar.t;
            cVar.t = j2 + s().length();
        }
        h.a().a(this.h, this.i);
    }
}
