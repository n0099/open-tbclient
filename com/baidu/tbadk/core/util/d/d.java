package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0007a {
    private DiskFileOperate akF = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.akF = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0007a
    public void cancel() {
        if (this.akF != null) {
            com.baidu.adp.lib.Disk.d.dp().d(this.akF);
        }
    }
}
