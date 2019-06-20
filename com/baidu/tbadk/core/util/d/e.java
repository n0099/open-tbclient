package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0016a {
    private DiskFileOperate bUG = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.bUG = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.bUG != null) {
            com.baidu.adp.lib.Disk.d.gt().d(this.bUG);
        }
    }
}
