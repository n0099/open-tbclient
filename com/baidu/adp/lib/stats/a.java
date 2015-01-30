package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class a extends DiskFileOperate {
    final /* synthetic */ BdNormalStatBase lJ;
    private final /* synthetic */ BdStatBase lK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdNormalStatBase bdNormalStatBase, String str, String str2, String str3, String str4, DiskFileOperate.Action action, BdStatBase bdStatBase) {
        super(str, str2, str3, str4, action);
        this.lJ = bdNormalStatBase;
        this.lK = bdStatBase;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        if (z) {
            if (!this.lJ.mIsOnlyWifi || this.lJ.mIsNetworkWifi) {
                f.eq().a(this.lK);
            }
            this.lJ.mCurrentFileSize = 0L;
        }
    }
}
