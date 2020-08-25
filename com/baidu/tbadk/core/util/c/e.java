package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes2.dex */
public class e implements a.InterfaceC0019a {
    private DiskFileOperate emy = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.emy = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0019a
    public void cancel() {
        if (this.emy != null) {
            com.baidu.adp.lib.Disk.d.lG().d(this.emy);
        }
    }
}
