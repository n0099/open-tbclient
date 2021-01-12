package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.b;
/* loaded from: classes.dex */
public class d implements b.a {
    private DiskFileOperate faA = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.faA = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.faA != null) {
            com.baidu.adp.lib.Disk.d.lh().d(this.faA);
        }
    }
}
