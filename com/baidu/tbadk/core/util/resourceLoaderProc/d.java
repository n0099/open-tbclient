package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.g.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0005a {
    private DiskFileOperate aeF = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aeF = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0005a
    public void cancel() {
        if (this.aeF != null) {
            com.baidu.adp.lib.Disk.d.fr().d(this.aeF);
        }
    }
}
