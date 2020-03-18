package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0017a {
    private DiskFileOperate dcc = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.dcc = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.dcc != null) {
            com.baidu.adp.lib.Disk.d.fk().d(this.dcc);
        }
    }
}
