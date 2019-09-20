package com.baidu.tbadk.core.util.e;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0016a {
    private DiskFileOperate bWE = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.bWE = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.bWE != null) {
            com.baidu.adp.lib.Disk.d.gC().d(this.bWE);
        }
    }
}
