package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.f.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0015a {
    private DiskFileOperate atq = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.atq = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0015a
    public void cancel() {
        if (this.atq != null) {
            com.baidu.adp.lib.Disk.d.gf().d(this.atq);
        }
    }
}
