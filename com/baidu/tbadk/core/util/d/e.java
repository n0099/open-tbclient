package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0016a {
    private DiskFileOperate bVN = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.bVN = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0016a
    public void cancel() {
        if (this.bVN != null) {
            com.baidu.adp.lib.Disk.d.gC().d(this.bVN);
        }
    }
}
