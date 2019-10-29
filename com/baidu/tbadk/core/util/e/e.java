package com.baidu.tbadk.core.util.e;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0016a {
    private DiskFileOperate clH = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.clH = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.clH != null) {
            com.baidu.adp.lib.Disk.d.eP().d(this.clH);
        }
    }
}
