package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0017a {
    private DiskFileOperate cXo = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.cXo = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0017a
    public void cancel() {
        if (this.cXo != null) {
            com.baidu.adp.lib.Disk.d.fj().d(this.cXo);
        }
    }
}
