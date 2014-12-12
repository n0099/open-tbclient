package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class a extends DiskFileOperate {
    final /* synthetic */ BdNormalStatBase lG;
    private final /* synthetic */ BdStatBase lH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdNormalStatBase bdNormalStatBase, String str, String str2, String str3, String str4, DiskFileOperate.Action action, BdStatBase bdStatBase) {
        super(str, str2, str3, str4, action);
        this.lG = bdNormalStatBase;
        this.lH = bdStatBase;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        if (z) {
            if (!this.lG.mIsOnlyWifi || this.lG.mIsNetworkWifi) {
                f.es().a(this.lH);
            }
            this.lG.mCurrentFileSize = 0L;
        }
    }
}
