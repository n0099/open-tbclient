package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ BdNormalStatBase g;
    private final /* synthetic */ BdStatBase h;
    private final /* synthetic */ boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, BdStatBase bdStatBase, boolean z) {
        super(str, str2, action);
        this.g = bdNormalStatBase;
        this.h = bdStatBase;
        this.i = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void c(boolean z) {
        long j;
        long j2;
        super.c(z);
        if (z && n() != null) {
            j = this.g.mCurrentFileSize;
            if (j == 0) {
                this.g.mCurrentFileSize = n().length();
            }
            BdNormalStatBase bdNormalStatBase = this.g;
            j2 = bdNormalStatBase.mCurrentFileSize;
            bdNormalStatBase.mCurrentFileSize = j2 + u().length();
        }
        d.b().a(this.h, this.i);
    }
}
