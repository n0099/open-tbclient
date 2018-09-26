package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0015a {
    private DiskFileOperate avt = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.avt = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.avt != null) {
            com.baidu.adp.lib.Disk.d.hl().d(this.avt);
        }
    }
}
