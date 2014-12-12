package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ BdNormalStatBase lG;
    private final /* synthetic */ BdStatBase lH;
    private final /* synthetic */ boolean lI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, BdStatBase bdStatBase, boolean z) {
        super(str, str2, action);
        this.lG = bdNormalStatBase;
        this.lH = bdStatBase;
        this.lI = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        long j;
        long j2;
        super.l(z);
        if (z && ce() != null) {
            j = this.lG.mCurrentFileSize;
            if (j == 0) {
                this.lG.mCurrentFileSize = ce().length();
            }
            BdNormalStatBase bdNormalStatBase = this.lG;
            j2 = bdNormalStatBase.mCurrentFileSize;
            bdNormalStatBase.mCurrentFileSize = j2 + getContent().length();
        }
        f.es().b(this.lH, this.lI);
    }
}
