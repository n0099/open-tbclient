package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0018a {
    private DiskFileOperate aXv = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.aXv = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0018a
    public void cancel() {
        if (this.aXv != null) {
            com.baidu.adp.lib.Disk.d.ll().d(this.aXv);
        }
    }
}
