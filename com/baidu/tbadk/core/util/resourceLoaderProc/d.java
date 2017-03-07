package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0005a {
    private DiskFileOperate ahR = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.ahR = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.ahR != null) {
            com.baidu.adp.lib.Disk.d.dI().d(this.ahR);
        }
    }
}
