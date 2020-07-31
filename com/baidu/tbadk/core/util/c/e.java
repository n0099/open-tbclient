package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.e.a;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0022a {
    private DiskFileOperate ecP = null;

    public void f(DiskFileOperate diskFileOperate) {
        this.ecP = diskFileOperate;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0022a
    public void cancel() {
        if (this.ecP != null) {
            com.baidu.adp.lib.Disk.d.kh().d(this.ecP);
        }
    }
}
