package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.g.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0006a {
    private DiskFileOperate adq = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.adq = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        if (this.adq != null) {
            com.baidu.adp.lib.Disk.d.cB().d(this.adq);
        }
    }
}
