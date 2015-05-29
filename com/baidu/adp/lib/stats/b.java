package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ BdNormalStatBase wb;
    private final /* synthetic */ BdStatBase wc;
    private final /* synthetic */ boolean wd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, BdStatBase bdStatBase, boolean z) {
        super(str, str2, action);
        this.wb = bdNormalStatBase;
        this.wc = bdStatBase;
        this.wd = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        long j;
        long j2;
        super.l(z);
        if (z && fF() != null) {
            j = this.wb.mCurrentFileSize;
            if (j == 0) {
                this.wb.mCurrentFileSize = fF().length();
            }
            BdNormalStatBase bdNormalStatBase = this.wb;
            j2 = bdNormalStatBase.mCurrentFileSize;
            bdNormalStatBase.mCurrentFileSize = j2 + getContent().length();
        }
        f.hz().b(this.wc, this.wd);
    }
}
