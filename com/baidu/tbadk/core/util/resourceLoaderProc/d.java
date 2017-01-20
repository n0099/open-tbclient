package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0005a {
    private DiskFileOperate acB = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.acB = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.acB != null) {
            com.baidu.adp.lib.Disk.d.cz().d(this.acB);
        }
    }
}
