package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ BdNormalStatBase lF;
    private final /* synthetic */ BdStatBase lG;
    private final /* synthetic */ boolean lH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, BdStatBase bdStatBase, boolean z) {
        super(str, str2, action);
        this.lF = bdNormalStatBase;
        this.lG = bdStatBase;
        this.lH = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void h(boolean z) {
        long j;
        long j2;
        super.h(z);
        if (z && bD() != null) {
            j = this.lF.mCurrentFileSize;
            if (j == 0) {
                this.lF.mCurrentFileSize = bD().length();
            }
            BdNormalStatBase bdNormalStatBase = this.lF;
            j2 = bdNormalStatBase.mCurrentFileSize;
            bdNormalStatBase.mCurrentFileSize = j2 + getContent().length();
        }
        f.er().b(this.lG, this.lH);
    }
}
