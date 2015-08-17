package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0004a {
    private DiskFileOperate acu = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.acu = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        if (this.acu != null) {
            com.baidu.adp.lib.Disk.d.fm().d(this.acu);
        }
    }
}
