package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.g.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0005a {
    private DiskFileOperate aef = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aef = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0005a
    public void cancel() {
        if (this.aef != null) {
            com.baidu.adp.lib.Disk.d.fj().d(this.aef);
        }
    }
}
