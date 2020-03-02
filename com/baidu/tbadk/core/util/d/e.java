package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0017a {
    private DiskFileOperate dbC = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.dbC = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.dbC != null) {
            com.baidu.adp.lib.Disk.d.fk().d(this.dbC);
        }
    }
}
