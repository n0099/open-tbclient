package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0005a {
    private DiskFileOperate aji = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aji = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0005a
    public void cancel() {
        if (this.aji != null) {
            com.baidu.adp.lib.Disk.d.dI().d(this.aji);
        }
    }
}
