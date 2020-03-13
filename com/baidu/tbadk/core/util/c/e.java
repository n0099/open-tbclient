package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0017a {
    private DiskFileOperate dbP = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.dbP = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.dbP != null) {
            com.baidu.adp.lib.Disk.d.fk().d(this.dbP);
        }
    }
}
