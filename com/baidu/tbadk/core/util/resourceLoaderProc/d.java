package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0004a {
    private DiskFileOperate acD = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.acD = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        if (this.acD != null) {
            com.baidu.adp.lib.Disk.d.fj().d(this.acD);
        }
    }
}
