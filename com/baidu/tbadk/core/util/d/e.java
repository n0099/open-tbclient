package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0018a {
    private DiskFileOperate aEu = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aEu = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.aEu != null) {
            com.baidu.adp.lib.Disk.d.hB().d(this.aEu);
        }
    }
}
