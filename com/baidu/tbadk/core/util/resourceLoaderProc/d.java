package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.g.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0004a {
    private DiskFileOperate adB = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.adB = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0004a
    public void cancel() {
        if (this.adB != null) {
            com.baidu.adp.lib.Disk.d.fj().d(this.adB);
        }
    }
}
