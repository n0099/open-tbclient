package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0018a {
    private DiskFileOperate aZc = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aZc = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.aZc != null) {
            com.baidu.adp.lib.Disk.d.ll().d(this.aZc);
        }
    }
}
