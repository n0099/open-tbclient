package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
class a extends DiskFileOperate {
    final /* synthetic */ BdNormalStatBase g;
    private final /* synthetic */ BdStatBase h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BdNormalStatBase bdNormalStatBase, String str, String str2, String str3, String str4, DiskFileOperate.Action action, BdStatBase bdStatBase) {
        super(str, str2, str3, str4, action);
        this.g = bdNormalStatBase;
        this.h = bdStatBase;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void c(boolean z) {
        if (z) {
            if (!this.g.mIsOnlyWifi || this.g.mIsNetworkWifi) {
                f.c().a(this.h);
            }
            this.g.mCurrentFileSize = 0L;
        }
    }
}
