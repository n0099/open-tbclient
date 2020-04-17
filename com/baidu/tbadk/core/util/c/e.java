package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0019a {
    private DiskFileOperate dBr = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.dBr = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        if (this.dBr != null) {
            com.baidu.adp.lib.Disk.d.jP().d(this.dBr);
        }
    }
}
