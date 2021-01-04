package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.b;
/* loaded from: classes.dex */
public class d implements b.a {
    private DiskFileOperate ffj = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.ffj = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.b.a
    public void cancel() {
        if (this.ffj != null) {
            com.baidu.adp.lib.Disk.d.lh().d(this.ffj);
        }
    }
}
