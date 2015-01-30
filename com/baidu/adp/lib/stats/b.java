package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.Disk.ops.e {
    final /* synthetic */ BdNormalStatBase lJ;
    private final /* synthetic */ BdStatBase lK;
    private final /* synthetic */ boolean lL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BdNormalStatBase bdNormalStatBase, String str, String str2, DiskFileOperate.Action action, BdStatBase bdStatBase, boolean z) {
        super(str, str2, action);
        this.lJ = bdNormalStatBase;
        this.lK = bdStatBase;
        this.lL = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        long j;
        long j2;
        super.l(z);
        if (z && cc() != null) {
            j = this.lJ.mCurrentFileSize;
            if (j == 0) {
                this.lJ.mCurrentFileSize = cc().length();
            }
            BdNormalStatBase bdNormalStatBase = this.lJ;
            j2 = bdNormalStatBase.mCurrentFileSize;
            bdNormalStatBase.mCurrentFileSize = j2 + getContent().length();
        }
        f.eq().b(this.lK, this.lL);
    }
}
