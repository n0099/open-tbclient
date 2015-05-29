package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.Disk.ops.e {
    private final /* synthetic */ com.baidu.adp.lib.stats.base.a xt;
    private final /* synthetic */ boolean xu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, DiskFileOperate.Action action, com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        super(str, str2, action);
        this.xt = aVar;
        this.xu = z;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.xt.l(fF().length());
            if (this.xu || this.xt.ie() > 102400) {
                c.d(this.xt, false);
            }
        }
    }
}
