package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0018a {
    private DiskFileOperate aEt = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aEt = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.aEt != null) {
            com.baidu.adp.lib.Disk.d.hB().d(this.aEt);
        }
    }
}
