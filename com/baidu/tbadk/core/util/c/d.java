package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0006a {
    private DiskFileOperate ait = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.ait = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0006a
    public void cancel() {
        if (this.ait != null) {
            com.baidu.adp.lib.Disk.d.dH().d(this.ait);
        }
    }
}
