package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ BdNormalStatBase wX;
    private final /* synthetic */ BdStatBase wY;
    private final /* synthetic */ boolean wZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, BdStatBase bdStatBase, boolean z) {
        super(str, str2, action);
        this.wX = bdNormalStatBase;
        this.wY = bdStatBase;
        this.wZ = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        long j;
        long j2;
        super.l(z);
        if (z && fA() != null) {
            j = this.wX.mCurrentFileSize;
            if (j == 0) {
                this.wX.mCurrentFileSize = fA().length();
            }
            BdNormalStatBase bdNormalStatBase = this.wX;
            j2 = bdNormalStatBase.mCurrentFileSize;
            bdNormalStatBase.mCurrentFileSize = j2 + getContent().length();
        }
        f.hP().b(this.wY, this.wZ);
    }
}
