package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0018a {
    private DiskFileOperate aZa = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aZa = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.aZa != null) {
            com.baidu.adp.lib.Disk.d.ll().d(this.aZa);
        }
    }
}
